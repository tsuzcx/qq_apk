package com.tencent.mm.plugin.radar.b;

import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getDelegate", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgListener", "com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1;", "needVerify", "Ljava/util/HashMap;", "", "onFMsgInfoNotify", "com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1;", "verifying", "Ljava/util/LinkedList;", "addContact", "", "username", "buildContact", "Lcom/tencent/mm/storage/Contact;", "verify", "Lcom/tencent/mm/storage/MsgInfo$VerifyContent;", "getStatus", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getVerifyMsg", "", "onAddContactReturn", "ret", "hasSendVerify", "errMsg", "timeStamp", "onCreate", "", "onDestroy", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onRecvFriendAdded", "contact", "onRecvFriendVerify", "onVerifyContactReturn", "putVerifyMsg", "msgContent", "removeVerifyMsg", "removeVerifying", "reset", "updateFMsgConversationState", "state", "verifyContact", "AddContactHelper", "Companion", "IOnAddContact", "IOnAddContactHelper", "Status", "plugin-radar_release"})
public final class c
  implements n.b
{
  public static final String TAG = "MicroMsg.RadarAddContact";
  public static final b pPP;
  final Context context;
  private final ak handler;
  private final LinkedList<String> pPK;
  public final HashMap<String, String> pPL;
  public final c.i pPM;
  public final c.g pPN;
  final c.c pPO;
  
  static
  {
    AppMethodBeat.i(102891);
    pPP = new b((byte)0);
    TAG = "MicroMsg.RadarAddContact";
    AppMethodBeat.o(102891);
  }
  
  public c(c.c paramc, Context paramContext)
  {
    AppMethodBeat.i(102890);
    this.pPO = paramc;
    this.context = paramContext;
    this.pPK = new LinkedList();
    this.pPL = new HashMap();
    this.pPM = new c.i(this);
    this.pPN = new c.g(this);
    this.handler = new ak();
    AppMethodBeat.o(102890);
  }
  
  private final void N(ad paramad)
  {
    AppMethodBeat.i(102886);
    if (this.pPK.contains(paramad.getUsername())) {
      this.pPK.remove(paramad.getUsername());
    }
    if (this.pPK.contains(paramad.Hv())) {
      this.pPK.remove(paramad.Hv());
    }
    AppMethodBeat.o(102886);
  }
  
  private final void O(ad paramad)
  {
    AppMethodBeat.i(102887);
    this.pPL.remove(paramad.getUsername());
    this.pPL.remove(paramad.Hv());
    AppMethodBeat.o(102887);
  }
  
  private final void P(ad paramad)
  {
    AppMethodBeat.i(102889);
    N(paramad);
    O(paramad);
    this.handler.post((Runnable)new c.j(this, paramad));
    AppMethodBeat.o(102889);
  }
  
  public final long XG(String paramString)
  {
    AppMethodBeat.i(102884);
    a.f.b.j.q(paramString, "username");
    long l = System.currentTimeMillis();
    c.a locala = new c.a(this, (c.d)new c.f(this, paramString, l));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(48));
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Assert.assertTrue(true);
      locala.onStart();
      locala.pPR = localLinkedList;
      locala.ikj = paramString;
      if (paramString != null) {
        locala.pPQ.add(paramString);
      }
      new s(locala.pPT.context, null).r((List)locala.pPQ, (List)localLinkedList);
      AppMethodBeat.o(102884);
      return l;
    }
  }
  
  public final c.e XH(String paramString)
  {
    AppMethodBeat.i(102885);
    a.f.b.j.q(paramString, "username");
    Object localObject = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject, "service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).YA().arw(paramString);
    if ((localObject == null) || (((ad)localObject).Od() == 0)) {
      if (this.pPK.contains(paramString)) {
        localObject = c.e.pPV;
      }
    }
    for (;;)
    {
      ab.d(TAG, "query username(%s) status %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(102885);
      return localObject;
      localObject = c.e.pPU;
      continue;
      if (((ad)localObject).NT()) {
        localObject = c.e.pPW;
      } else if (this.pPL.containsKey(paramString)) {
        localObject = c.e.pPX;
      } else if (this.pPK.contains(paramString)) {
        localObject = c.e.pPV;
      } else {
        localObject = c.e.pPU;
      }
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(102888);
    a.f.b.j.q(paramn, "stg");
    ab.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(102888);
      return;
    }
    paramn = (String)paramObject;
    paramObject = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(paramObject, "service(IMessengerStorage::class.java)");
    paramObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramObject).YA().arw(paramn);
    if ((paramObject != null) && (paramObject.NT()))
    {
      ab.d(TAG, "ContactStg onNotifyChange %s", new Object[] { paramn });
      P(paramObject);
    }
    AppMethodBeat.o(102888);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c
 * JD-Core Version:    0.7.0.1
 */