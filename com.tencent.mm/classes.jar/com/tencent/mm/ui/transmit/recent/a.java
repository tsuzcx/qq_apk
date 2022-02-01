package com.tencent.mm.ui.transmit.recent;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/transmit/recent/RecentForwardDataProvider;", "", "()V", "RECENT_FORWARD_LOG_VERSION", "", "getRECENT_FORWARD_LOG_VERSION", "()I", "RECENT_FORWARD_OFF", "getRECENT_FORWARD_OFF", "RECENT_FORWARD_ON", "getRECENT_FORWARD_ON", "blockList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "conversationList", "Lcom/tencent/mm/ui/contact/item/ConversationDataItem;", "createConversationDataItem", "position", "dataCursor", "Landroid/database/Cursor;", "fullFillNickName", "username", "nickName", "getConversationItems", "getConversationList", "", "getForwardConversationInfoList", "Lcom/tencent/mm/ui/transmit/recent/ForwardConversationInfo;", "getForwardConversationInfoListByIPC", "initBlockSet", "", "initData", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a afPS;
  private ArrayList<g> XOo;
  private final int XOs;
  private final int XOt;
  private final ArrayList<String> afPT;
  
  static
  {
    AppMethodBeat.i(250913);
    afPS = new a.a((byte)0);
    AppMethodBeat.o(250913);
  }
  
  public a()
  {
    AppMethodBeat.i(250884);
    this.XOs = 1;
    this.XOt = 2;
    this.afPT = new ArrayList();
    this.XOo = new ArrayList();
    if (MMApplicationContext.isMainProcess())
    {
      this.XOo.clear();
      this.afPT.clear();
      HashSet localHashSet1 = new HashSet();
      localHashSet1.addAll((Collection)w.jyV());
      HashSet localHashSet2 = w.jyW();
      w.j(localHashSet2);
      localHashSet1.addAll((Collection)localHashSet2);
      this.afPT.addAll((Collection)localHashSet1);
      this.afPT.addAll((Collection)com.tencent.mm.pluginsdk.platformtools.a.iIW());
    }
    AppMethodBeat.o(250884);
  }
  
  public static ArrayList<ForwardConversationInfo> jEd()
  {
    AppMethodBeat.i(250891);
    Object localObject = (Bundle)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(IPCVoid.mzv, a..ExternalSyntheticLambda0.INSTANCE);
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((Bundle)localObject).getParcelableArrayList("list"))
    {
      localObject = new ArrayList();
      AppMethodBeat.o(250891);
      return localObject;
      ((Bundle)localObject).setClassLoader(ForwardConversationInfo.class.getClassLoader());
    }
    AppMethodBeat.o(250891);
    return localObject;
  }
  
  private static ArrayList<g> y(Cursor paramCursor)
  {
    AppMethodBeat.i(250904);
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramCursor.getCount() > 0)
    {
      paramCursor.moveToFirst();
      i = 0;
    }
    for (;;)
    {
      g localg = new g(i);
      Object localObject = new bb();
      ((bb)localObject).convertFrom(paramCursor);
      localg.contact = ((n)h.ax(n.class)).bzA().bxq(((bd)localObject).field_username);
      if (localg.contact == null) {
        localg.contact = ((n)h.ax(n.class)).bzA().bxv(((bd)localObject).field_username);
      }
      localg.afey = false;
      localg.username = ((bd)localObject).field_username;
      String str2 = ((bd)localObject).field_username;
      s.s(str2, "conversation.username");
      String str1 = localg.contact.field_nickname;
      s.s(str1, "conversationDataItem.contact.nickname");
      localObject = str1;
      if (Util.isNullOrNil(str1))
      {
        localObject = ((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(str2);
        s.s(localObject, "{\n            MMKernel.s…yName(username)\n        }");
      }
      localg.pJG = ((CharSequence)localObject);
      Log.i("MircoMsg.RecentForwardDataProvider", "createConversationDataItem " + i + " item: " + localg + " nickname:" + localg.pJG + " username:" + localg.username);
      localArrayList.add(localg);
      if (!paramCursor.moveToNext())
      {
        AppMethodBeat.o(250904);
        return localArrayList;
      }
      i += 1;
    }
  }
  
  private static final Bundle z(IPCVoid paramIPCVoid)
  {
    AppMethodBeat.i(250909);
    paramIPCVoid = new a().jEc();
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("list", paramIPCVoid);
    AppMethodBeat.o(250909);
    return localBundle;
  }
  
  public final ArrayList<ForwardConversationInfo> jEc()
  {
    AppMethodBeat.i(250923);
    Object localObject1 = ((PluginMessengerFoundation)h.az(PluginMessengerFoundation.class)).getRecentForwardInfoStorage().jdQ();
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    Cursor localCursor = ((n)h.ax(n.class)).bzG().a((List)localObject2, 1, (List)this.afPT, com.tencent.mm.l.a.maX, false, "");
    s.s(localCursor, "service(IMessengerStorag…PARENT_REF_NULL,false,\"\")");
    ArrayList localArrayList = y(localCursor);
    localObject2 = ((ArrayList)localObject2).iterator();
    label144:
    label279:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (String)((Iterator)localObject2).next();
      Object localObject4 = ((List)localArrayList).iterator();
      int i = 0;
      if (((Iterator)localObject4).hasNext()) {
        if (!s.p(((g)((Iterator)localObject4).next()).username, localObject3)) {}
      }
      for (;;)
      {
        if (i < 0) {
          break label279;
        }
        localObject3 = localArrayList.get(i);
        s.s(localObject3, "items[index]");
        localObject3 = (g)localObject3;
        localObject4 = ((g)localObject3).username;
        String str1 = ((g)localObject3).pJG.toString();
        String str2 = ((com.tencent.mm.ui.contact.a.a)localObject3).contact.aJs();
        s.s(str2, "conversation.contact.alias");
        ((ArrayList)localObject1).add(new ForwardConversationInfo((String)localObject4, str1, str2, ((com.tencent.mm.ui.contact.a.a)localObject3).contact.field_conRemark.toString()));
        break;
        i += 1;
        break label144;
        i = -1;
      }
    }
    localCursor.close();
    AppMethodBeat.o(250923);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.recent.a
 * JD-Core Version:    0.7.0.1
 */