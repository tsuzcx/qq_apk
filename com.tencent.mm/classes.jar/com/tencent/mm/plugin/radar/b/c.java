package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv.d;
import d.a.j;
import d.g.b.p;
import d.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getDelegate", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgListener", "com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1;", "needVerify", "Ljava/util/HashMap;", "", "onFMsgInfoNotify", "com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1;", "verifying", "Ljava/util/LinkedList;", "addContact", "", "username", "buildContact", "Lcom/tencent/mm/storage/Contact;", "verify", "Lcom/tencent/mm/storage/MsgInfo$VerifyContent;", "getStatus", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getVerifyMsg", "", "onAddContactReturn", "ret", "hasSendVerify", "errMsg", "timeStamp", "onCreate", "", "onDestroy", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onRecvFriendAdded", "contact", "onRecvFriendVerify", "onVerifyContactReturn", "putVerifyMsg", "msgContent", "removeVerifyMsg", "removeVerifying", "reset", "updateFMsgConversationState", "state", "verifyContact", "AddContactHelper", "Companion", "IOnAddContact", "IOnAddContactHelper", "Status", "plugin-radar_release"})
public final class c
  implements n.b
{
  public static final String TAG = "MicroMsg.RadarAddContact";
  public static final c.b xyh;
  final Context context;
  private final aq handler;
  private final LinkedList<String> xyc;
  public final HashMap<String, String> xyd;
  public final i xye;
  public final g xyf;
  final c xyg;
  
  static
  {
    AppMethodBeat.i(138536);
    xyh = new c.b((byte)0);
    TAG = "MicroMsg.RadarAddContact";
    AppMethodBeat.o(138536);
  }
  
  public c(c paramc, Context paramContext)
  {
    AppMethodBeat.i(138535);
    this.xyg = paramc;
    this.context = paramContext;
    this.xyc = new LinkedList();
    this.xyd = new HashMap();
    this.xye = new i(this);
    this.xyf = new g(this);
    this.handler = new aq();
    AppMethodBeat.o(138535);
  }
  
  private final void ac(an paraman)
  {
    AppMethodBeat.i(138531);
    if (this.xyc.contains(paraman.getUsername())) {
      this.xyc.remove(paraman.getUsername());
    }
    if (this.xyc.contains(paraman.VN())) {
      this.xyc.remove(paraman.VN());
    }
    AppMethodBeat.o(138531);
  }
  
  private final void ad(an paraman)
  {
    AppMethodBeat.i(138532);
    this.xyd.remove(paraman.getUsername());
    this.xyd.remove(paraman.VN());
    AppMethodBeat.o(138532);
  }
  
  private final void ae(final an paraman)
  {
    AppMethodBeat.i(138534);
    ac(paraman);
    ad(paraman);
    this.handler.post((Runnable)new j(this, paraman));
    AppMethodBeat.o(138534);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(138533);
    p.h(paramn, "stg");
    com.tencent.mm.sdk.platformtools.ae.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      com.tencent.mm.sdk.platformtools.ae.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(138533);
      return;
    }
    paramn = (String)paramObject;
    paramObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramObject, "service(IMessengerStorage::class.java)");
    paramObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramObject).azF().BH(paramn);
    if ((paramObject != null) && (paramObject.ads()))
    {
      com.tencent.mm.sdk.platformtools.ae.d(TAG, "ContactStg onNotifyChange %s", new Object[] { paramn });
      ae(paramObject);
    }
    AppMethodBeat.o(138533);
  }
  
  public final long awu(final String paramString)
  {
    AppMethodBeat.i(138529);
    p.h(paramString, "username");
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
      locala.xyj = localLinkedList;
      locala.lJm = paramString;
      if (paramString != null) {
        locala.xyi.add(paramString);
      }
      new aa(locala.xyl.context, null).D((List)locala.xyi, (List)localLinkedList);
      AppMethodBeat.o(138529);
      return l;
    }
  }
  
  public final e awv(String paramString)
  {
    AppMethodBeat.i(138530);
    p.h(paramString, "username");
    Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().BH(paramString);
    if ((localObject == null) || (((an)localObject).adE() == 0)) {
      if (this.xyc.contains(paramString)) {
        localObject = e.xyn;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.d(TAG, "query username(%s) status %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(138530);
      return localObject;
      localObject = e.xym;
      continue;
      if (((an)localObject).ads()) {
        localObject = e.xyo;
      } else if (this.xyd.containsKey(paramString)) {
        localObject = e.xyp;
      } else if (this.xyc.contains(paramString)) {
        localObject = e.xyn;
      } else {
        localObject = e.xym;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$AddContactHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "callback", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;)V", "lstScene", "Ljava/util/LinkedList;", "", "lstUsername", "", "mUsername", "addContact", "", "username", "finish", "ok", "", "hasSentVerify", "respUsername", "errMsg", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "onStop", "sendVerifyRequest", "verifyOk", "verifyTicket", "plugin-radar_release"})
  public final class a
    implements f
  {
    String lJm;
    final LinkedList<String> xyi;
    LinkedList<Integer> xyj;
    private final c.d xyk;
    
    public a()
    {
      AppMethodBeat.i(138516);
      Object localObject;
      this.xyk = localObject;
      this.xyi = new LinkedList();
      AppMethodBeat.o(138516);
    }
    
    private final void b(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138514);
      g.ajj().b(30, (f)this);
      c.d locald = this.xyk;
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
      p.h(paramn, "scene");
      com.tencent.mm.sdk.platformtools.ae.d(c.access$getTAG$cp(), "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      if (paramn.getType() != 30)
      {
        com.tencent.mm.sdk.platformtools.ae.w(c.access$getTAG$cp(), "not expected scene,  type = " + paramn.getType());
        AppMethodBeat.o(138515);
        return;
      }
      if (((o)paramn).fdu() == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          b(false, true, this.lJm, "");
          AppMethodBeat.o(138515);
          return;
        }
        if ((paramInt1 == 4) && (paramInt2 == -34)) {
          paramn = c.this.context.getString(2131759479);
        }
      }
      for (;;)
      {
        b(false, false, this.lJm, paramn);
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
            b(true, false, this.lJm, "");
            AppMethodBeat.o(138515);
            return;
          }
          if (paramInt2 == -44)
          {
            new aa(c.this.context, null).D((List)this.xyi, (List)this.xyj);
            AppMethodBeat.o(138515);
            return;
          }
          if (paramInt2 == -87)
          {
            b(false, false, this.lJm, c.this.context.getString(2131757604));
            AppMethodBeat.o(138515);
            return;
          }
          if ((paramInt2 == -24) && (!bu.isNullOrNil(paramString)))
          {
            String str = this.lJm;
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
      g.ajj().a(30, (f)this);
      AppMethodBeat.o(138513);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "", "onAddContactReturn", "", "ok", "", "hasSentVerify", "errMsg", "", "username", "timeStamp", "", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onVerifyContactReturn", "plugin-radar_release"})
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong);
    
    public abstract void ae(an paraman);
    
    public abstract void af(an paraman);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "", "(Ljava/lang/String;I)V", "Stranger", "Verifying", "Added", "NeedVerify", "plugin-radar_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(138517);
      e locale1 = new e("Stranger", 0);
      xym = locale1;
      e locale2 = new e("Verifying", 1);
      xyn = locale2;
      e locale3 = new e("Added", 2);
      xyo = locale3;
      e locale4 = new e("NeedVerify", 3);
      xyp = locale4;
      xyq = new e[] { locale1, locale2, locale3, locale4 };
      AppMethodBeat.o(138517);
    }
    
    private e() {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/model/RadarAddContact$addContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
  public static final class f
    implements c.d
  {
    f(String paramString, long paramLong) {}
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138520);
      if (paramBoolean1)
      {
        Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject, "service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().BH(paramString1);
        p.g(localObject, "contact");
        if (((an)localObject).adE() > 0) {
          x.B((an)localObject);
        }
        c.eO(paramString1, 1);
        if (j.a((Iterable)c.a(this.xyl), paramString1))
        {
          localObject = (Collection)c.a(this.xyl);
          if (localObject == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            AppMethodBeat.o(138520);
            throw paramString1;
          }
          d.g.b.ae.eU(localObject).remove(paramString1);
        }
        com.tencent.mm.sdk.platformtools.ae.d(c.access$getTAG$cp(), "addContact %s return ok", new Object[] { paramString });
      }
      for (;;)
      {
        c.a(this.xyl, paramBoolean1, paramBoolean2, paramString2, paramString1, l);
        AppMethodBeat.o(138520);
        return;
        if (paramBoolean2)
        {
          if ((paramString1 != null) && (!c.a(this.xyl).contains(paramString1))) {
            c.a(this.xyl).add(paramString1);
          }
          c.eO(paramString1, 2);
          com.tencent.mm.sdk.platformtools.ae.d(c.access$getTAG$cp(), "addContact has sent verify to %s", new Object[] { paramString });
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ae.d(c.access$getTAG$cp(), "addContact return not ok, user canceled or error");
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "NODE_ENCRYPT_USERNAME", "", "NODE_TYPE", "NODE_USERNAME", "onDeleteMsg", "", "msg", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "onRecieveMsg", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-radar_release"})
  public static final class g
    implements cf.a
  {
    private final String xyt = ".sysmsg.addcontact.type";
    private final String xyu = ".sysmsg.addcontact.username";
    private final String xyv = ".sysmsg.addcontact.encryptusername";
    
    public final void a(e.a parama)
    {
      AppMethodBeat.i(138521);
      p.h(parama, "addMsgInfo");
      Object localObject1 = z.a(parama.gte.FNI);
      Object localObject2 = bx.M((String)localObject1, "sysmsg");
      if (localObject2 == null)
      {
        AppMethodBeat.o(138521);
        return;
      }
      if (p.i((String)((Map)localObject2).get(this.xyt), "1"))
      {
        parama = (String)((Map)localObject2).get(this.xyu);
        localObject2 = (String)((Map)localObject2).get(this.xyv);
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
          com.tencent.mm.sdk.platformtools.ae.e(c.access$getTAG$cp(), "error! server return incorrect content! : %s", new Object[] { localObject1 });
          AppMethodBeat.o(138521);
          return;
          i = 0;
          break;
        }
        label177:
        localObject1 = new an();
        ((an)localObject1).setUsername(parama);
        ((an)localObject1).tu((String)localObject2);
        c.c(this.xyl, (an)localObject1);
        com.tencent.mm.sdk.platformtools.ae.d(c.access$getTAG$cp(), "receive contact added system message useranme %s, encypt %s", new Object[] { ((an)localObject1).getUsername(), ((an)localObject1).VN() });
      }
      AppMethodBeat.o(138521);
    }
    
    public final void a(e.c paramc)
    {
      AppMethodBeat.i(138522);
      paramc = (Throwable)new d.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
      AppMethodBeat.o(138522);
      throw paramc;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(138523);
      this.xyl.xyg.a(this.uKv, this.xyw, this.iEZ, this.gTN, this.xyr);
      AppMethodBeat.o(138523);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RadarSayHiMsgEvent;", "callback", "", "event", "plugin-radar_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<pp>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(c paramc, an paraman) {}
    
    public final void run()
    {
      AppMethodBeat.i(138525);
      this.xyl.xyg.ae(paraman);
      AppMethodBeat.o(138525);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(c paramc, an paraman) {}
    
    public final void run()
    {
      AppMethodBeat.i(138526);
      this.xyl.xyg.af(this.xyx);
      AppMethodBeat.o(138526);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(c paramc, boolean paramBoolean, String paramString1, String paramString2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(138527);
      this.xyl.xyg.a(this.uKv, this.iEZ, this.gTN, this.xyr);
      AppMethodBeat.o(138527);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/model/RadarAddContact$verifyContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
  public static final class m
    implements c.d
  {
    public m(String paramString, long paramLong) {}
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138528);
      if (paramBoolean1)
      {
        Object localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject1, "service(IMessengerStorage::class.java)");
        Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azF().BH(paramString1);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          paramBoolean2 = paramBoolean1;
          if (((an)localObject2).adE() != 0) {}
        }
        else
        {
          localObject1 = c.a(bv.d.aVF(this.xyy));
          localObject2 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(localObject2, "service(IMessengerStorage::class.java)");
          if (!((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).azF().an((an)localObject1))
          {
            com.tencent.mm.sdk.platformtools.ae.e(c.access$getTAG$cp(), "canAddContact fail, insert fail");
            paramBoolean1 = false;
          }
          localObject2 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(localObject2, "service(IMessengerStorage::class.java)");
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).azF().BH(((an)localObject1).getUsername());
          paramBoolean2 = paramBoolean1;
        }
        com.tencent.mm.sdk.platformtools.ae.d(c.access$getTAG$cp(), "verifyContact return ok");
        x.B((an)localObject1);
        c.eO(paramString1, 1);
      }
      for (;;)
      {
        c.a(this.xyl, paramBoolean2, paramString2, paramString1, this.xyr);
        AppMethodBeat.o(138528);
        return;
        com.tencent.mm.sdk.platformtools.ae.d(c.access$getTAG$cp(), "verifyContact return not ok");
        paramBoolean2 = paramBoolean1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c
 * JD-Core Version:    0.7.0.1
 */