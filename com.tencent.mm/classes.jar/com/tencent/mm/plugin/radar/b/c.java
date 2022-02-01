package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl.d;
import d.a.j;
import d.l;
import d.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getDelegate", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgListener", "com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1;", "needVerify", "Ljava/util/HashMap;", "", "onFMsgInfoNotify", "com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1;", "verifying", "Ljava/util/LinkedList;", "addContact", "", "username", "buildContact", "Lcom/tencent/mm/storage/Contact;", "verify", "Lcom/tencent/mm/storage/MsgInfo$VerifyContent;", "getStatus", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getVerifyMsg", "", "onAddContactReturn", "ret", "hasSendVerify", "errMsg", "timeStamp", "onCreate", "", "onDestroy", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onRecvFriendAdded", "contact", "onRecvFriendVerify", "onVerifyContactReturn", "putVerifyMsg", "msgContent", "removeVerifyMsg", "removeVerifying", "reset", "updateFMsgConversationState", "state", "verifyContact", "AddContactHelper", "Companion", "IOnAddContact", "IOnAddContactHelper", "Status", "plugin-radar_release"})
public final class c
  implements n.b
{
  public static final String TAG = "MicroMsg.RadarAddContact";
  public static final b uRM;
  final Context context;
  private final ap handler;
  private final LinkedList<String> uRH;
  public final HashMap<String, String> uRI;
  public final i uRJ;
  public final g uRK;
  final c uRL;
  
  static
  {
    AppMethodBeat.i(138536);
    uRM = new b((byte)0);
    TAG = "MicroMsg.RadarAddContact";
    AppMethodBeat.o(138536);
  }
  
  public c(c paramc, Context paramContext)
  {
    AppMethodBeat.i(138535);
    this.uRL = paramc;
    this.context = paramContext;
    this.uRH = new LinkedList();
    this.uRI = new HashMap();
    this.uRJ = new i(this);
    this.uRK = new g(this);
    this.handler = new ap();
    AppMethodBeat.o(138535);
  }
  
  private final void U(af paramaf)
  {
    AppMethodBeat.i(138531);
    if (this.uRH.contains(paramaf.getUsername())) {
      this.uRH.remove(paramaf.getUsername());
    }
    if (this.uRH.contains(paramaf.Sx())) {
      this.uRH.remove(paramaf.Sx());
    }
    AppMethodBeat.o(138531);
  }
  
  private final void V(af paramaf)
  {
    AppMethodBeat.i(138532);
    this.uRI.remove(paramaf.getUsername());
    this.uRI.remove(paramaf.Sx());
    AppMethodBeat.o(138532);
  }
  
  private final void W(final af paramaf)
  {
    AppMethodBeat.i(138534);
    U(paramaf);
    V(paramaf);
    this.handler.post((Runnable)new j(this, paramaf));
    AppMethodBeat.o(138534);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(138533);
    d.g.b.k.h(paramn, "stg");
    ad.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(138533);
      return;
    }
    paramn = (String)paramObject;
    paramObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(paramObject, "service(IMessengerStorage::class.java)");
    paramObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramObject).apM().aHY(paramn);
    if ((paramObject != null) && (paramObject.ZJ()))
    {
      ad.d(TAG, "ContactStg onNotifyChange %s", new Object[] { paramn });
      W(paramObject);
    }
    AppMethodBeat.o(138533);
  }
  
  public final long alh(final String paramString)
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
      locala.uRO = localLinkedList;
      locala.kGt = paramString;
      if (paramString != null) {
        locala.uRN.add(paramString);
      }
      new com.tencent.mm.pluginsdk.ui.applet.aa(locala.uRQ.context, null).D((List)locala.uRN, (List)localLinkedList);
      AppMethodBeat.o(138529);
      return l;
    }
  }
  
  public final e ali(String paramString)
  {
    AppMethodBeat.i(138530);
    d.g.b.k.h(paramString, "username");
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject, "service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apM().aHY(paramString);
    if ((localObject == null) || (((af)localObject).ZV() == 0)) {
      if (this.uRH.contains(paramString)) {
        localObject = e.uRS;
      }
    }
    for (;;)
    {
      ad.d(TAG, "query username(%s) status %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(138530);
      return localObject;
      localObject = e.uRR;
      continue;
      if (((af)localObject).ZJ()) {
        localObject = e.uRT;
      } else if (this.uRI.containsKey(paramString)) {
        localObject = e.uRU;
      } else if (this.uRH.contains(paramString)) {
        localObject = e.uRS;
      } else {
        localObject = e.uRR;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$AddContactHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "callback", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;)V", "lstScene", "Ljava/util/LinkedList;", "", "lstUsername", "", "mUsername", "addContact", "", "username", "finish", "ok", "", "hasSentVerify", "respUsername", "errMsg", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "onStop", "sendVerifyRequest", "verifyOk", "verifyTicket", "plugin-radar_release"})
  public final class a
    implements com.tencent.mm.al.g
  {
    String kGt;
    final LinkedList<String> uRN;
    LinkedList<Integer> uRO;
    private final c.d uRP;
    
    public a()
    {
      AppMethodBeat.i(138516);
      Object localObject;
      this.uRP = localObject;
      this.uRN = new LinkedList();
      AppMethodBeat.o(138516);
    }
    
    private final void b(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138514);
      com.tencent.mm.kernel.g.aeS().b(30, (com.tencent.mm.al.g)this);
      c.d locald = this.uRP;
      if (locald != null)
      {
        locald.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
        AppMethodBeat.o(138514);
        return;
      }
      AppMethodBeat.o(138514);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(138515);
      d.g.b.k.h(paramn, "scene");
      ad.d(c.access$getTAG$cp(), "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      if (paramn.getType() != 30)
      {
        ad.w(c.access$getTAG$cp(), "not expected scene,  type = " + paramn.getType());
        AppMethodBeat.o(138515);
        return;
      }
      if (((o)paramn).evs() == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          b(false, true, this.kGt, "");
          AppMethodBeat.o(138515);
          return;
        }
        if ((paramInt1 == 4) && (paramInt2 == -34)) {
          paramn = c.this.context.getString(2131759479);
        }
      }
      for (;;)
      {
        b(false, false, this.kGt, paramn);
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
            b(true, false, this.kGt, "");
            AppMethodBeat.o(138515);
            return;
          }
          if (paramInt2 == -44)
          {
            new com.tencent.mm.pluginsdk.ui.applet.aa(c.this.context, null).D((List)this.uRN, (List)this.uRO);
            AppMethodBeat.o(138515);
            return;
          }
          if (paramInt2 == -87)
          {
            b(false, false, this.kGt, c.this.context.getString(2131757604));
            AppMethodBeat.o(138515);
            return;
          }
          if ((paramInt2 == -24) && (!bt.isNullOrNil(paramString)))
          {
            String str = this.kGt;
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
      com.tencent.mm.kernel.g.aeS().a(30, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(138513);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "", "onAddContactReturn", "", "ok", "", "hasSentVerify", "errMsg", "", "username", "timeStamp", "", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onVerifyContactReturn", "plugin-radar_release"})
  public static abstract interface c
  {
    public abstract void W(af paramaf);
    
    public abstract void X(af paramaf);
    
    public abstract void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "", "(Ljava/lang/String;I)V", "Stranger", "Verifying", "Added", "NeedVerify", "plugin-radar_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(138517);
      e locale1 = new e("Stranger", 0);
      uRR = locale1;
      e locale2 = new e("Verifying", 1);
      uRS = locale2;
      e locale3 = new e("Added", 2);
      uRT = locale3;
      e locale4 = new e("NeedVerify", 3);
      uRU = locale4;
      uRV = new e[] { locale1, locale2, locale3, locale4 };
      AppMethodBeat.o(138517);
    }
    
    private e() {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/model/RadarAddContact$addContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
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
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apM().aHY(paramString1);
        d.g.b.k.g(localObject, "contact");
        if (((af)localObject).ZV() > 0) {
          w.u((af)localObject);
        }
        c.eg(paramString1, 1);
        if (j.a((Iterable)c.a(this.uRQ), paramString1))
        {
          localObject = (Collection)c.a(this.uRQ);
          if (localObject == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            AppMethodBeat.o(138520);
            throw paramString1;
          }
          d.g.b.aa.eL(localObject).remove(paramString1);
        }
        ad.d(c.access$getTAG$cp(), "addContact %s return ok", new Object[] { paramString });
      }
      for (;;)
      {
        c.a(this.uRQ, paramBoolean1, paramBoolean2, paramString2, paramString1, l);
        AppMethodBeat.o(138520);
        return;
        if (paramBoolean2)
        {
          if ((paramString1 != null) && (!c.a(this.uRQ).contains(paramString1))) {
            c.a(this.uRQ).add(paramString1);
          }
          c.eg(paramString1, 2);
          ad.d(c.access$getTAG$cp(), "addContact has sent verify to %s", new Object[] { paramString });
        }
        else
        {
          ad.d(c.access$getTAG$cp(), "addContact return not ok, user canceled or error");
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "NODE_ENCRYPT_USERNAME", "", "NODE_TYPE", "NODE_USERNAME", "onDeleteMsg", "", "msg", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "onRecieveMsg", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-radar_release"})
  public static final class g
    implements cc.a
  {
    private final String uRX = ".sysmsg.addcontact.type";
    private final String uRY = ".sysmsg.addcontact.username";
    private final String uRZ = ".sysmsg.addcontact.encryptusername";
    
    public final void a(f.a parama)
    {
      AppMethodBeat.i(138521);
      d.g.b.k.h(parama, "addMsgInfo");
      Object localObject1 = z.a(parama.fTo.Cxz);
      Object localObject2 = bw.K((String)localObject1, "sysmsg");
      if (localObject2 == null)
      {
        AppMethodBeat.o(138521);
        return;
      }
      if (d.g.b.k.g((String)((Map)localObject2).get(this.uRX), "1"))
      {
        parama = (String)((Map)localObject2).get(this.uRY);
        localObject2 = (String)((Map)localObject2).get(this.uRZ);
        CharSequence localCharSequence = (CharSequence)parama;
        if ((localCharSequence == null) || (d.n.n.aC(localCharSequence)))
        {
          i = 1;
          if (i == 0)
          {
            localCharSequence = (CharSequence)localObject2;
            if ((localCharSequence != null) && (!d.n.n.aC(localCharSequence))) {
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
          ad.e(c.access$getTAG$cp(), "error! server return incorrect content! : %s", new Object[] { localObject1 });
          AppMethodBeat.o(138521);
          return;
          i = 0;
          break;
        }
        label177:
        localObject1 = new af();
        ((af)localObject1).setUsername(parama);
        ((af)localObject1).nj((String)localObject2);
        c.c(this.uRQ, (af)localObject1);
        ad.d(c.access$getTAG$cp(), "receive contact added system message useranme %s, encypt %s", new Object[] { ((af)localObject1).getUsername(), ((af)localObject1).Sx() });
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(138523);
      this.uRQ.uRL.a(this.uSa, this.uSb, this.hIm, this.iPR, this.uRW);
      AppMethodBeat.o(138523);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RadarSayHiMsgEvent;", "callback", "", "event", "plugin-radar_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<ov>
  {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(c paramc, af paramaf) {}
    
    public final void run()
    {
      AppMethodBeat.i(138525);
      this.uRQ.uRL.W(paramaf);
      AppMethodBeat.o(138525);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(c paramc, af paramaf) {}
    
    public final void run()
    {
      AppMethodBeat.i(138526);
      this.uRQ.uRL.X(this.uSc);
      AppMethodBeat.o(138526);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(c paramc, boolean paramBoolean, String paramString1, String paramString2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(138527);
      this.uRQ.uRL.a(this.uSa, this.hIm, this.iPR, this.uRW);
      AppMethodBeat.o(138527);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/model/RadarAddContact$verifyContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
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
        Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).apM().aHY(paramString1);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          paramBoolean2 = paramBoolean1;
          if (((af)localObject2).ZV() != 0) {}
        }
        else
        {
          localObject1 = c.a(bl.d.aIR(this.uSd));
          localObject2 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(localObject2, "service(IMessengerStorage::class.java)");
          if (!((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).apM().af((af)localObject1))
          {
            ad.e(c.access$getTAG$cp(), "canAddContact fail, insert fail");
            paramBoolean1 = false;
          }
          localObject2 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(localObject2, "service(IMessengerStorage::class.java)");
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).apM().aHY(((af)localObject1).getUsername());
          paramBoolean2 = paramBoolean1;
        }
        ad.d(c.access$getTAG$cp(), "verifyContact return ok");
        w.u((af)localObject1);
        c.eg(paramString1, 1);
      }
      for (;;)
      {
        c.a(this.uRQ, paramBoolean2, paramString2, paramString1, this.uRW);
        AppMethodBeat.o(138528);
        return;
        ad.d(c.access$getTAG$cp(), "verifyContact return not ok");
        paramBoolean2 = paramBoolean1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c
 * JD-Core Version:    0.7.0.1
 */