package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo.d;
import d.a.j;
import d.l;
import d.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getDelegate", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgListener", "com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1;", "needVerify", "Ljava/util/HashMap;", "", "onFMsgInfoNotify", "com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1;", "verifying", "Ljava/util/LinkedList;", "addContact", "", "username", "buildContact", "Lcom/tencent/mm/storage/Contact;", "verify", "Lcom/tencent/mm/storage/MsgInfo$VerifyContent;", "getStatus", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getVerifyMsg", "", "onAddContactReturn", "ret", "hasSendVerify", "errMsg", "timeStamp", "onCreate", "", "onDestroy", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onRecvFriendAdded", "contact", "onRecvFriendVerify", "onVerifyContactReturn", "putVerifyMsg", "msgContent", "removeVerifyMsg", "removeVerifying", "reset", "updateFMsgConversationState", "state", "verifyContact", "AddContactHelper", "Companion", "IOnAddContact", "IOnAddContactHelper", "Status", "plugin-radar_release"})
public final class c
  implements n.b
{
  public static final String TAG = "MicroMsg.RadarAddContact";
  public static final c.b waB;
  final Context context;
  private final ao handler;
  final c waA;
  private final LinkedList<String> waw;
  public final HashMap<String, String> wax;
  public final i way;
  public final g waz;
  
  static
  {
    AppMethodBeat.i(138536);
    waB = new c.b((byte)0);
    TAG = "MicroMsg.RadarAddContact";
    AppMethodBeat.o(138536);
  }
  
  public c(c paramc, Context paramContext)
  {
    AppMethodBeat.i(138535);
    this.waA = paramc;
    this.context = paramContext;
    this.waw = new LinkedList();
    this.wax = new HashMap();
    this.way = new i(this);
    this.waz = new g(this);
    this.handler = new ao();
    AppMethodBeat.o(138535);
  }
  
  private final void V(ai paramai)
  {
    AppMethodBeat.i(138531);
    if (this.waw.contains(paramai.getUsername())) {
      this.waw.remove(paramai.getUsername());
    }
    if (this.waw.contains(paramai.Tq())) {
      this.waw.remove(paramai.Tq());
    }
    AppMethodBeat.o(138531);
  }
  
  private final void W(ai paramai)
  {
    AppMethodBeat.i(138532);
    this.wax.remove(paramai.getUsername());
    this.wax.remove(paramai.Tq());
    AppMethodBeat.o(138532);
  }
  
  private final void X(final ai paramai)
  {
    AppMethodBeat.i(138534);
    V(paramai);
    W(paramai);
    this.handler.post((Runnable)new j(this, paramai));
    AppMethodBeat.o(138534);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(138533);
    d.g.b.k.h(paramn, "stg");
    ac.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(138533);
      return;
    }
    paramn = (String)paramObject;
    paramObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(paramObject, "service(IMessengerStorage::class.java)");
    paramObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramObject).awB().aNt(paramn);
    if ((paramObject != null) && (paramObject.aaE()))
    {
      ac.d(TAG, "ContactStg onNotifyChange %s", new Object[] { paramn });
      X(paramObject);
    }
    AppMethodBeat.o(138533);
  }
  
  public final long aqg(final String paramString)
  {
    AppMethodBeat.i(138529);
    d.g.b.k.h(paramString, "username");
    final long l = System.currentTimeMillis();
    a locala = new a((d)new f(this, paramString, l));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(48));
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Assert.assertTrue(true);
      locala.onStart();
      locala.waD = localLinkedList;
      locala.lhM = paramString;
      if (paramString != null) {
        locala.waC.add(paramString);
      }
      new com.tencent.mm.pluginsdk.ui.applet.aa(locala.waF.context, null).C((List)locala.waC, (List)localLinkedList);
      AppMethodBeat.o(138529);
      return l;
    }
  }
  
  public final e aqh(String paramString)
  {
    AppMethodBeat.i(138530);
    d.g.b.k.h(paramString, "username");
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject, "service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNt(paramString);
    if ((localObject == null) || (((ai)localObject).aaQ() == 0)) {
      if (this.waw.contains(paramString)) {
        localObject = e.waH;
      }
    }
    for (;;)
    {
      ac.d(TAG, "query username(%s) status %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(138530);
      return localObject;
      localObject = e.waG;
      continue;
      if (((ai)localObject).aaE()) {
        localObject = e.waI;
      } else if (this.wax.containsKey(paramString)) {
        localObject = e.waJ;
      } else if (this.waw.contains(paramString)) {
        localObject = e.waH;
      } else {
        localObject = e.waG;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$AddContactHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "callback", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;)V", "lstScene", "Ljava/util/LinkedList;", "", "lstUsername", "", "mUsername", "addContact", "", "username", "finish", "ok", "", "hasSentVerify", "respUsername", "errMsg", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "onStop", "sendVerifyRequest", "verifyOk", "verifyTicket", "plugin-radar_release"})
  public final class a
    implements com.tencent.mm.ak.g
  {
    String lhM;
    final LinkedList<String> waC;
    LinkedList<Integer> waD;
    private final c.d waE;
    
    public a()
    {
      AppMethodBeat.i(138516);
      Object localObject;
      this.waE = localObject;
      this.waC = new LinkedList();
      AppMethodBeat.o(138516);
    }
    
    private final void b(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138514);
      com.tencent.mm.kernel.g.agi().b(30, (com.tencent.mm.ak.g)this);
      c.d locald = this.waE;
      if (locald != null)
      {
        locald.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
        AppMethodBeat.o(138514);
        return;
      }
      AppMethodBeat.o(138514);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(138515);
      d.g.b.k.h(paramn, "scene");
      ac.d(c.access$getTAG$cp(), "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      if (paramn.getType() != 30)
      {
        ac.w(c.access$getTAG$cp(), "not expected scene,  type = " + paramn.getType());
        AppMethodBeat.o(138515);
        return;
      }
      if (((o)paramn).eKM() == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          b(false, true, this.lhM, "");
          AppMethodBeat.o(138515);
          return;
        }
        if ((paramInt1 == 4) && (paramInt2 == -34)) {
          paramn = c.this.context.getString(2131759479);
        }
      }
      for (;;)
      {
        b(false, false, this.lhM, paramn);
        AppMethodBeat.o(138515);
        return;
        if ((paramInt1 == 4) && (paramInt2 == -94))
        {
          paramn = c.this.context.getString(2131759482);
        }
        else if ((paramInt1 == 4) && ((paramInt2 == -24) || (paramInt2 == -101)))
        {
          paramn = paramString;
          if (paramString != null) {}
        }
        else
        {
          paramn = c.this.context.getString(2131763075);
          continue;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            b(true, false, this.lhM, "");
            AppMethodBeat.o(138515);
            return;
          }
          if (paramInt2 == -44)
          {
            new com.tencent.mm.pluginsdk.ui.applet.aa(c.this.context, null).C((List)this.waC, (List)this.waD);
            AppMethodBeat.o(138515);
            return;
          }
          if (paramInt2 == -87)
          {
            b(false, false, this.lhM, c.this.context.getString(2131757604));
            AppMethodBeat.o(138515);
            return;
          }
          if ((paramInt2 == -24) && (!bs.isNullOrNil(paramString)))
          {
            String str = this.lhM;
            paramn = paramString;
            if (paramString == null) {
              paramn = "";
            }
            b(false, false, str, paramn);
            AppMethodBeat.o(138515);
            return;
          }
          if ((paramInt1 == 4) && (paramInt2 == -22)) {
            paramn = c.this.context.getString(2131755167);
          } else {
            paramn = c.this.context.getString(2131755166);
          }
        }
      }
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(138513);
      com.tencent.mm.kernel.g.agi().a(30, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(138513);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "", "onAddContactReturn", "", "ok", "", "hasSentVerify", "errMsg", "", "username", "timeStamp", "", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onVerifyContactReturn", "plugin-radar_release"})
  public static abstract interface c
  {
    public abstract void X(ai paramai);
    
    public abstract void Y(ai paramai);
    
    public abstract void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "", "(Ljava/lang/String;I)V", "Stranger", "Verifying", "Added", "NeedVerify", "plugin-radar_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(138517);
      e locale1 = new e("Stranger", 0);
      waG = locale1;
      e locale2 = new e("Verifying", 1);
      waH = locale2;
      e locale3 = new e("Added", 2);
      waI = locale3;
      e locale4 = new e("NeedVerify", 3);
      waJ = locale4;
      waK = new e[] { locale1, locale2, locale3, locale4 };
      AppMethodBeat.o(138517);
    }
    
    private e() {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/model/RadarAddContact$addContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
  public static final class f
    implements c.d
  {
    f(String paramString, long paramLong) {}
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138520);
      if (paramBoolean1)
      {
        Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(localObject, "service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNt(paramString1);
        d.g.b.k.g(localObject, "contact");
        if (((ai)localObject).aaQ() > 0) {
          w.u((ai)localObject);
        }
        c.en(paramString1, 1);
        if (j.a((Iterable)c.a(this.waF), paramString1))
        {
          localObject = (Collection)c.a(this.waF);
          if (localObject == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            AppMethodBeat.o(138520);
            throw paramString1;
          }
          d.g.b.aa.eO(localObject).remove(paramString1);
        }
        ac.d(c.access$getTAG$cp(), "addContact %s return ok", new Object[] { paramString });
      }
      for (;;)
      {
        c.a(this.waF, paramBoolean1, paramBoolean2, paramString2, paramString1, l);
        AppMethodBeat.o(138520);
        return;
        if (paramBoolean2)
        {
          if ((paramString1 != null) && (!c.a(this.waF).contains(paramString1))) {
            c.a(this.waF).add(paramString1);
          }
          c.en(paramString1, 2);
          ac.d(c.access$getTAG$cp(), "addContact has sent verify to %s", new Object[] { paramString });
        }
        else
        {
          ac.d(c.access$getTAG$cp(), "addContact return not ok, user canceled or error");
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "NODE_ENCRYPT_USERNAME", "", "NODE_TYPE", "NODE_USERNAME", "onDeleteMsg", "", "msg", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "onRecieveMsg", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-radar_release"})
  public static final class g
    implements cc.a
  {
    private final String waM = ".sysmsg.addcontact.type";
    private final String waN = ".sysmsg.addcontact.username";
    private final String waO = ".sysmsg.addcontact.encryptusername";
    
    public final void a(f.a parama)
    {
      AppMethodBeat.i(138521);
      d.g.b.k.h(parama, "addMsgInfo");
      Object localObject1 = z.a(parama.fXi.DPV);
      Object localObject2 = bv.L((String)localObject1, "sysmsg");
      if (localObject2 == null)
      {
        AppMethodBeat.o(138521);
        return;
      }
      if (d.g.b.k.g((String)((Map)localObject2).get(this.waM), "1"))
      {
        parama = (String)((Map)localObject2).get(this.waN);
        localObject2 = (String)((Map)localObject2).get(this.waO);
        CharSequence localCharSequence = (CharSequence)parama;
        if ((localCharSequence == null) || (d.n.n.aD(localCharSequence)))
        {
          i = 1;
          if (i == 0)
          {
            localCharSequence = (CharSequence)localObject2;
            if ((localCharSequence != null) && (!d.n.n.aD(localCharSequence))) {
              break label172;
            }
          }
        }
        label172:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label177;
          }
          ac.e(c.access$getTAG$cp(), "error! server return incorrect content! : %s", new Object[] { localObject1 });
          AppMethodBeat.o(138521);
          return;
          i = 0;
          break;
        }
        label177:
        localObject1 = new ai();
        ((ai)localObject1).setUsername(parama);
        ((ai)localObject1).qp((String)localObject2);
        c.c(this.waF, (ai)localObject1);
        ac.d(c.access$getTAG$cp(), "receive contact added system message useranme %s, encypt %s", new Object[] { ((ai)localObject1).getUsername(), ((ai)localObject1).Tq() });
      }
      AppMethodBeat.o(138521);
    }
    
    public final void a(f.c paramc)
    {
      AppMethodBeat.i(138522);
      paramc = (Throwable)new d.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
      AppMethodBeat.o(138522);
      throw paramc;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(138523);
      this.waF.waA.a(this.waP, this.waQ, this.iiO, this.gxu, this.waL);
      AppMethodBeat.o(138523);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RadarSayHiMsgEvent;", "callback", "", "event", "plugin-radar_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<pe>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(c paramc, ai paramai) {}
    
    public final void run()
    {
      AppMethodBeat.i(138525);
      this.waF.waA.X(paramai);
      AppMethodBeat.o(138525);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(c paramc, ai paramai) {}
    
    public final void run()
    {
      AppMethodBeat.i(138526);
      this.waF.waA.Y(this.waR);
      AppMethodBeat.o(138526);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(c paramc, boolean paramBoolean, String paramString1, String paramString2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(138527);
      this.waF.waA.a(this.waP, this.iiO, this.gxu, this.waL);
      AppMethodBeat.o(138527);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/model/RadarAddContact$verifyContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
  public static final class m
    implements c.d
  {
    public m(String paramString, long paramLong) {}
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138528);
      if (paramBoolean1)
      {
        Object localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(localObject1, "service(IMessengerStorage::class.java)");
        Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).awB().aNt(paramString1);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          paramBoolean2 = paramBoolean1;
          if (((ai)localObject2).aaQ() != 0) {}
        }
        else
        {
          localObject1 = c.a(bo.d.aOn(this.waS));
          localObject2 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(localObject2, "service(IMessengerStorage::class.java)");
          if (!((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).awB().ag((ai)localObject1))
          {
            ac.e(c.access$getTAG$cp(), "canAddContact fail, insert fail");
            paramBoolean1 = false;
          }
          localObject2 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(localObject2, "service(IMessengerStorage::class.java)");
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).awB().aNt(((ai)localObject1).getUsername());
          paramBoolean2 = paramBoolean1;
        }
        ac.d(c.access$getTAG$cp(), "verifyContact return ok");
        w.u((ai)localObject1);
        c.en(paramString1, 1);
      }
      for (;;)
      {
        c.a(this.waF, paramBoolean2, paramString2, paramString1, this.waL);
        AppMethodBeat.o(138528);
        return;
        ac.d(c.access$getTAG$cp(), "verifyContact return not ok");
        paramBoolean2 = paramBoolean1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c
 * JD-Core Version:    0.7.0.1
 */