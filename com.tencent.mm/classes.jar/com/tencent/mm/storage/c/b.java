package com.tencent.mm.storage.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.cl;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/forward/RecentForwardInfoStorage;", "", "()V", "mInfoList", "Lcom/tencent/mm/storage/RecentForwardInfoList;", "canDisplay", "", "userName", "", "deleteInfoByName", "getInfoListFromMMKV", "insert", "", "info", "Lcom/tencent/mm/storage/RecentForwardInfo;", "index", "", "insertList", "infoList", "", "isValidTime", "time", "", "queryLimit", "count", "type", "queryRecentForwardChatRoomTop5", "queryRecentForwardTop10", "queryRecentForwardTop5", "queryRecentForwardUserTop5", "setInfoListToMMKV", "list", "updateForwardInfo", "userNames", "Companion", "plugin-messenger-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a admU;
  private static final j<MultiProcessMMKV> exj;
  public cl admV;
  
  static
  {
    AppMethodBeat.i(248748);
    admU = new a((byte)0);
    exj = k.cm((a)b.admW);
    AppMethodBeat.o(248748);
  }
  
  public b()
  {
    AppMethodBeat.i(248721);
    c.a(this);
    AppMethodBeat.o(248721);
  }
  
  private void a(ck paramck)
  {
    AppMethodBeat.i(248737);
    s.u(paramck, "info");
    cl localcl = jdR();
    localcl.ZDA.add(0, paramck);
    if (localcl.ZDA.size() > 20) {
      localcl.ZDA.subList(0, 20);
    }
    a(localcl);
    AppMethodBeat.o(248737);
  }
  
  private final void a(cl paramcl)
  {
    AppMethodBeat.i(248741);
    a.atj().encode("MMKV_KEY_RECENT_FORWARD_INFO_LIST", paramcl.toByteArray());
    this.admV = paramcl;
    AppMethodBeat.o(248741);
  }
  
  private static boolean bzo(String paramString)
  {
    AppMethodBeat.i(248730);
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(paramString);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(paramString);
    if ((localau != null) && (!localau.aSF()) && (paramString != null) && (!kotlin.n.n.T("hidden_conv_parent", paramString.field_parentRef, true)))
    {
      AppMethodBeat.o(248730);
      return true;
    }
    AppMethodBeat.o(248730);
    return false;
  }
  
  public static final int bzr(String paramString)
  {
    AppMethodBeat.i(248744);
    int i = a.bzr(paramString);
    AppMethodBeat.o(248744);
    return i;
  }
  
  private static boolean zi(long paramLong)
  {
    AppMethodBeat.i(248725);
    if (cn.bDw() - paramLong < 31536000000L)
    {
      AppMethodBeat.o(248725);
      return true;
    }
    AppMethodBeat.o(248725);
    return false;
  }
  
  public final List<String> azl(int paramInt)
  {
    AppMethodBeat.i(248760);
    Object localObject1 = jdR();
    Object localObject2 = ((cl)localObject1).ZDA;
    LinkedList localLinkedList = new LinkedList();
    localObject2 = ((LinkedList)localObject2).iterator();
    s.s(localObject2, "infoList.iterator()");
    while ((((Iterator)localObject2).hasNext()) && (localLinkedList.size() < 5))
    {
      ck localck = (ck)((Iterator)localObject2).next();
      String str = localck.userName;
      if (zi(localck.adlo))
      {
        s.s(str, "userName");
        if (!bzo(str))
        {
          ((Iterator)localObject2).remove();
          a((cl)localObject1);
        }
        else if (paramInt == -1)
        {
          localLinkedList.add(str);
        }
        else
        {
          int i;
          if (paramInt > 0) {
            if (paramInt <= 4) {
              i = 1;
            }
          }
          while (i != 0) {
            switch (paramInt)
            {
            default: 
              break;
            case 1: 
              if (localck.adlp == 2) {
                break;
              }
              localLinkedList.add(str);
              break;
              i = 0;
              continue;
              i = 0;
            }
          }
          if (localck.adlp == 2) {
            localLinkedList.add(str);
          }
        }
      }
    }
    Log.i("MicroMsg.RecentForwardInfoStorage", s.X("[queryLimit] userNameList size=", Integer.valueOf(localLinkedList.size())));
    localObject1 = (List)localLinkedList;
    AppMethodBeat.o(248760);
    return localObject1;
  }
  
  public final boolean bzp(String paramString)
  {
    AppMethodBeat.i(248768);
    s.u(paramString, "userName");
    cl localcl = jdR();
    Object localObject = localcl.ZDA;
    s.s(localObject, "list.info_list");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ck localck = (ck)((Iterator)localObject).next();
      if (s.p(localck.userName, paramString))
      {
        localcl.ZDA.remove(localck);
        a(localcl);
        Log.i("MicroMsg.RecentForwardInfoStorage", "deleteShareInfo: " + paramString + ' ');
        AppMethodBeat.o(248768);
        return true;
      }
    }
    Log.e("MicroMsg.RecentForwardInfoStorage", "deleteShareInfo: " + paramString + " is fail");
    AppMethodBeat.o(248768);
    return false;
  }
  
  public final void bzq(String paramString)
  {
    AppMethodBeat.i(248772);
    if (paramString != null) {
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label86;
        }
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ck localck = new ck();
        localck.adlo = cn.bDw();
        localck.userName = paramString;
        localck.adlp = a.bzr(paramString);
        bzp(paramString);
        a(localck);
      }
      AppMethodBeat.o(248772);
      return;
      i = 0;
      break;
    }
  }
  
  public final List<String> jdQ()
  {
    AppMethodBeat.i(248752);
    List localList = azl(-1);
    Log.i("MicroMsg.RecentForwardInfoStorage", s.X("[query] list size=", Integer.valueOf(localList.size())));
    AppMethodBeat.o(248752);
    return localList;
  }
  
  public final cl jdR()
  {
    AppMethodBeat.i(248780);
    cl localcl = this.admV;
    if (localcl != null)
    {
      AppMethodBeat.o(248780);
      return localcl;
    }
    localcl = new cl();
    byte[] arrayOfByte = a.atj().decodeBytes("MMKV_KEY_RECENT_FORWARD_INFO_LIST");
    if (arrayOfByte != null) {
      localcl.parseFrom(arrayOfByte);
    }
    this.admV = localcl;
    AppMethodBeat.o(248780);
    return localcl;
  }
  
  public final void ni(List<? extends ck> paramList)
  {
    AppMethodBeat.i(248777);
    s.u(paramList, "infoList");
    cl localcl = jdR();
    localcl.ZDA.addAll(0, (Collection)paramList);
    if (localcl.ZDA.size() > 20) {
      localcl.ZDA.subList(0, 20);
    }
    a(localcl);
    AppMethodBeat.o(248777);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/forward/RecentForwardInfoStorage$Companion;", "", "()V", "CONVERSATION_RECENT_FORWARD_CONTACTS_LIMIT", "", "EXPIRE_TIME", "", "FINDER_RECENT_FORWARD_CONTACTS_LIMIT", "MMKV_KEY_RECENT_FORWARD_INFO_LIST", "", "QUERY_TYPE_CHAT_ROOM", "QUERY_TYPE_USER", "RECEIVER_TYPE_CHAT_ROOM", "RECEIVER_TYPE_FILE_HELPER", "RECEIVER_TYPE_FRIEND", "RECEIVER_TYPE_SELF", "RECENT_FORWARD_MAX_STORAGE_CAPACITY", "TAG", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "getReceiverType", "username", "plugin-messenger-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static MultiProcessMMKV atj()
    {
      AppMethodBeat.i(248727);
      Object localObject = b.bAs().getValue();
      s.s(localObject, "<get-mmkv>(...)");
      localObject = (MultiProcessMMKV)localObject;
      AppMethodBeat.o(248727);
      return localObject;
    }
    
    public static int bzr(String paramString)
    {
      AppMethodBeat.i(248733);
      s.u(paramString, "username");
      if (au.bwE(paramString))
      {
        AppMethodBeat.o(248733);
        return 2;
      }
      if (au.bws(paramString))
      {
        AppMethodBeat.o(248733);
        return 3;
      }
      if (z.Iy(paramString))
      {
        AppMethodBeat.o(248733);
        return 4;
      }
      AppMethodBeat.o(248733);
      return 1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<MultiProcessMMKV>
  {
    public static final b admW;
    
    static
    {
      AppMethodBeat.i(248732);
      admW = new b();
      AppMethodBeat.o(248732);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.c.b
 * JD-Core Version:    0.7.0.1
 */