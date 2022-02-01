package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.rh;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.radar.a.g;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca.d;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import kotlin.a.j;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getDelegate", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgListener", "com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1;", "needVerify", "Ljava/util/HashMap;", "", "onFMsgInfoNotify", "com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1;", "verifying", "Ljava/util/LinkedList;", "addContact", "", "username", "buildContact", "Lcom/tencent/mm/storage/Contact;", "verify", "Lcom/tencent/mm/storage/MsgInfo$VerifyContent;", "getStatus", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getVerifyMsg", "", "onAddContactReturn", "ret", "hasSendVerify", "errMsg", "timeStamp", "onCreate", "", "onDestroy", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onRecvFriendAdded", "contact", "onRecvFriendVerify", "onVerifyContactReturn", "putVerifyMsg", "msgContent", "removeVerifyMsg", "removeVerifying", "reset", "updateFMsgConversationState", "state", "verifyContact", "AddContactHelper", "Companion", "IOnAddContact", "IOnAddContactHelper", "Status", "plugin-radar_release"})
public final class b
  implements MStorageEx.IOnStorageChange
{
  public static final b.b HtH;
  public static final String TAG = "MicroMsg.RadarAddContact";
  private final LinkedList<String> HtC;
  public final HashMap<String, String> HtD;
  public final i HtE;
  public final g HtF;
  final c HtG;
  final Context context;
  private final MMHandler handler;
  
  static
  {
    AppMethodBeat.i(138536);
    HtH = new b.b((byte)0);
    TAG = "MicroMsg.RadarAddContact";
    AppMethodBeat.o(138536);
  }
  
  public b(c paramc, Context paramContext)
  {
    AppMethodBeat.i(138535);
    this.HtG = paramc;
    this.context = paramContext;
    this.HtC = new LinkedList();
    this.HtD = new HashMap();
    this.HtE = new i(this);
    this.HtF = new g(this);
    this.handler = new MMHandler();
    AppMethodBeat.o(138535);
  }
  
  private final void ak(as paramas)
  {
    AppMethodBeat.i(138531);
    if (this.HtC.contains(paramas.getUsername())) {
      this.HtC.remove(paramas.getUsername());
    }
    if (this.HtC.contains(paramas.apn())) {
      this.HtC.remove(paramas.apn());
    }
    AppMethodBeat.o(138531);
  }
  
  private final void al(as paramas)
  {
    AppMethodBeat.i(138532);
    this.HtD.remove(paramas.getUsername());
    this.HtD.remove(paramas.apn());
    AppMethodBeat.o(138532);
  }
  
  private final void am(final as paramas)
  {
    AppMethodBeat.i(138534);
    ak(paramas);
    al(paramas);
    this.handler.post((Runnable)new j(this, paramas));
    AppMethodBeat.o(138534);
  }
  
  public final long aVn(final String paramString)
  {
    AppMethodBeat.i(138529);
    p.k(paramString, "username");
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
      locala.HtJ = localLinkedList;
      locala.pRV = paramString;
      if (paramString != null) {
        locala.HtI.add(paramString);
      }
      new aa(locala.HtL.context, null).F((List)locala.HtI, (List)localLinkedList);
      AppMethodBeat.o(138529);
      return l;
    }
  }
  
  public final e aVo(String paramString)
  {
    AppMethodBeat.i(138530);
    p.k(paramString, "username");
    Object localObject = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject, "service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL().RG(paramString);
    if ((localObject == null) || (((as)localObject).ayq() == 0)) {
      if (this.HtC.contains(paramString)) {
        localObject = e.HtN;
      }
    }
    for (;;)
    {
      Log.d(TAG, "query username(%s) status %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(138530);
      return localObject;
      localObject = e.HtM;
      continue;
      if (((as)localObject).axZ()) {
        localObject = e.HtO;
      } else if (this.HtD.containsKey(paramString)) {
        localObject = e.HtP;
      } else if (this.HtC.contains(paramString)) {
        localObject = e.HtN;
      } else {
        localObject = e.HtM;
      }
    }
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(138533);
    p.k(paramMStorageEx, "stg");
    Log.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(138533);
      return;
    }
    paramMStorageEx = (String)paramObject;
    paramObject = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(paramObject, "service(IMessengerStorage::class.java)");
    paramObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)paramObject).bbL().RG(paramMStorageEx);
    if ((paramObject != null) && (paramObject.axZ()))
    {
      Log.d(TAG, "ContactStg onNotifyChange %s", new Object[] { paramMStorageEx });
      am(paramObject);
    }
    AppMethodBeat.o(138533);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$AddContactHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "callback", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;)V", "lstScene", "Ljava/util/LinkedList;", "", "lstUsername", "", "mUsername", "addContact", "", "username", "finish", "ok", "", "hasSentVerify", "respUsername", "errMsg", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "onStop", "sendVerifyRequest", "verifyOk", "verifyTicket", "plugin-radar_release"})
  public final class a
    implements i
  {
    final LinkedList<String> HtI;
    LinkedList<Integer> HtJ;
    private final b.d HtK;
    String pRV;
    
    public a()
    {
      AppMethodBeat.i(138516);
      Object localObject;
      this.HtK = localObject;
      this.HtI = new LinkedList();
      AppMethodBeat.o(138516);
    }
    
    private final void c(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138514);
      h.aGY().b(30, (i)this);
      b.d locald = this.HtK;
      if (locald != null)
      {
        locald.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
        AppMethodBeat.o(138514);
        return;
      }
      AppMethodBeat.o(138514);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(138515);
      p.k(paramq, "scene");
      Log.d(b.access$getTAG$cp(), "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      if (paramq.getType() != 30)
      {
        Log.w(b.access$getTAG$cp(), "not expected scene,  type = " + paramq.getType());
        AppMethodBeat.o(138515);
        return;
      }
      if (((com.tencent.mm.pluginsdk.model.t)paramq).hhd() == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          c(false, true, this.pRV, "");
          AppMethodBeat.o(138515);
          return;
        }
        if ((paramInt1 == 4) && (paramInt2 == -34))
        {
          paramq = b.this.context.getString(a.g.fmessage_request_too_offen);
          p.j(paramq, "when {\n                 …il)\n                    }");
        }
      }
      for (;;)
      {
        c(false, false, this.pRV, paramq);
        AppMethodBeat.o(138515);
        return;
        if ((paramInt1 == 4) && (paramInt2 == -94))
        {
          paramq = b.this.context.getString(a.g.fmessage_user_not_support);
          break;
        }
        if ((paramInt1 == 4) && ((paramInt2 == -24) || (paramInt2 == -101)))
        {
          paramq = paramString;
          if (paramString != null) {
            break;
          }
        }
        paramq = b.this.context.getString(a.g.sendrequest_send_fail);
        break;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          c(true, false, this.pRV, "");
          AppMethodBeat.o(138515);
          return;
        }
        if (paramInt2 == -44)
        {
          new aa(b.this.context, null).F((List)this.HtI, (List)this.HtJ);
          AppMethodBeat.o(138515);
          return;
        }
        if (paramInt2 == -87)
        {
          c(false, false, this.pRV, b.this.context.getString(a.g.contact_info_biz_join_fans_limit));
          AppMethodBeat.o(138515);
          return;
        }
        if ((paramInt2 == -24) && (!Util.isNullOrNil(paramString)))
        {
          String str = this.pRV;
          paramq = paramString;
          if (paramString == null) {
            paramq = "";
          }
          c(false, false, str, paramq);
          AppMethodBeat.o(138515);
          return;
        }
        if ((paramInt1 == 4) && (paramInt2 == -22)) {
          paramq = b.this.context.getString(a.g.addcontact_fail_blacklist);
        } else {
          paramq = b.this.context.getString(a.g.addcontact_fail);
        }
      }
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(138513);
      h.aGY().a(30, (i)this);
      AppMethodBeat.o(138513);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "", "onAddContactReturn", "", "ok", "", "hasSentVerify", "errMsg", "", "username", "timeStamp", "", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onVerifyContactReturn", "plugin-radar_release"})
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong);
    
    public abstract void am(as paramas);
    
    public abstract void an(as paramas);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "", "(Ljava/lang/String;I)V", "Stranger", "Verifying", "Added", "NeedVerify", "plugin-radar_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(138517);
      e locale1 = new e("Stranger", 0);
      HtM = locale1;
      e locale2 = new e("Verifying", 1);
      HtN = locale2;
      e locale3 = new e("Added", 2);
      HtO = locale3;
      e locale4 = new e("NeedVerify", 3);
      HtP = locale4;
      HtQ = new e[] { locale1, locale2, locale3, locale4 };
      AppMethodBeat.o(138517);
    }
    
    private e() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/model/RadarAddContact$addContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
  public static final class f
    implements b.d
  {
    f(String paramString, long paramLong) {}
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138520);
      if (paramBoolean1)
      {
        Object localObject = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
        p.j(localObject, "service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL().RG(paramString1);
        p.j(localObject, "contact");
        if (((as)localObject).ayq() > 0) {
          ab.H((as)localObject);
        }
        b.fI(paramString1, 1);
        if (j.a((Iterable)b.a(this.HtL), paramString1))
        {
          localObject = (Collection)b.a(this.HtL);
          if (localObject == null)
          {
            paramString1 = new kotlin.t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            AppMethodBeat.o(138520);
            throw paramString1;
          }
          ag.fc(localObject).remove(paramString1);
        }
        Log.d(b.access$getTAG$cp(), "addContact %s return ok", new Object[] { paramString });
      }
      for (;;)
      {
        b.a(this.HtL, paramBoolean1, paramBoolean2, paramString2, paramString1, l);
        AppMethodBeat.o(138520);
        return;
        if (paramBoolean2)
        {
          if ((paramString1 != null) && (!b.a(this.HtL).contains(paramString1))) {
            b.a(this.HtL).add(paramString1);
          }
          b.fI(paramString1, 2);
          Log.d(b.access$getTAG$cp(), "addContact has sent verify to %s", new Object[] { paramString });
        }
        else
        {
          Log.d(b.access$getTAG$cp(), "addContact return not ok, user canceled or error");
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "NODE_ENCRYPT_USERNAME", "", "NODE_TYPE", "NODE_USERNAME", "onDeleteMsg", "", "msg", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "onRecieveMsg", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-radar_release"})
  public static final class g
    implements ck.a
  {
    private final String HtS = ".sysmsg.addcontact.type";
    private final String HtT = ".sysmsg.addcontact.username";
    private final String HtU = ".sysmsg.addcontact.encryptusername";
    
    public final void a(h.a parama)
    {
      AppMethodBeat.i(138521);
      p.k(parama, "addMsgInfo");
      Object localObject1 = z.a(parama.jQG.RIF);
      Object localObject2 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
      if (localObject2 == null)
      {
        AppMethodBeat.o(138521);
        return;
      }
      if (p.h((String)((Map)localObject2).get(this.HtS), "1"))
      {
        parama = (String)((Map)localObject2).get(this.HtT);
        localObject2 = (String)((Map)localObject2).get(this.HtU);
        CharSequence localCharSequence = (CharSequence)parama;
        if ((localCharSequence == null) || (kotlin.n.n.ba(localCharSequence)))
        {
          i = 1;
          if (i == 0)
          {
            localCharSequence = (CharSequence)localObject2;
            if ((localCharSequence != null) && (!kotlin.n.n.ba(localCharSequence))) {
              break label173;
            }
          }
        }
        label173:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label178;
          }
          Log.e(b.access$getTAG$cp(), "error! server return incorrect content! : %s", new Object[] { localObject1 });
          AppMethodBeat.o(138521);
          return;
          i = 0;
          break;
        }
        label178:
        localObject1 = new as();
        ((as)localObject1).setUsername(parama);
        ((as)localObject1).Iy((String)localObject2);
        b.c(this.HtL, (as)localObject1);
        Log.d(b.access$getTAG$cp(), "receive contact added system message useranme %s, encypt %s", new Object[] { ((as)localObject1).getUsername(), ((as)localObject1).apn() });
      }
      AppMethodBeat.o(138521);
    }
    
    public final void a(h.c paramc)
    {
      AppMethodBeat.i(138522);
      paramc = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
      AppMethodBeat.o(138522);
      throw paramc;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(b paramb, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(138523);
      this.HtL.HtG.a(this.xgz, this.HtV, this.mqJ, this.kyF, this.HtR);
      AppMethodBeat.o(138523);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RadarSayHiMsgEvent;", "callback", "", "event", "plugin-radar_release"})
  public static final class i
    extends IListener<rh>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(b paramb, as paramas) {}
    
    public final void run()
    {
      AppMethodBeat.i(138525);
      this.HtL.HtG.am(paramas);
      AppMethodBeat.o(138525);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(b paramb, as paramas) {}
    
    public final void run()
    {
      AppMethodBeat.i(138526);
      this.HtL.HtG.an(this.HtW);
      AppMethodBeat.o(138526);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(b paramb, boolean paramBoolean, String paramString1, String paramString2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(138527);
      this.HtL.HtG.a(this.xgz, this.mqJ, this.kyF, this.HtR);
      AppMethodBeat.o(138527);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/model/RadarAddContact$verifyContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
  public static final class m
    implements b.d
  {
    public m(String paramString, long paramLong) {}
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138528);
      if (paramBoolean1)
      {
        Object localObject1 = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
        p.j(localObject1, "service(IMessengerStorage::class.java)");
        Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).bbL().RG(paramString1);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          paramBoolean2 = paramBoolean1;
          if (((as)localObject2).ayq() != 0) {}
        }
        else
        {
          localObject1 = b.a(ca.d.bxc(this.nQU));
          localObject2 = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          p.j(localObject2, "service(IMessengerStorage::class.java)");
          if (!((com.tencent.mm.plugin.messenger.foundation.a.n)localObject2).bbL().av((as)localObject1))
          {
            Log.e(b.access$getTAG$cp(), "canAddContact fail, insert fail");
            paramBoolean1 = false;
          }
          localObject2 = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          p.j(localObject2, "service(IMessengerStorage::class.java)");
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject2).bbL().RG(((as)localObject1).getUsername());
          paramBoolean2 = paramBoolean1;
        }
        Log.d(b.access$getTAG$cp(), "verifyContact return ok");
        ab.H((as)localObject1);
        b.fI(paramString1, 1);
      }
      for (;;)
      {
        b.a(this.HtL, paramBoolean2, paramString2, paramString1, this.HtR);
        AppMethodBeat.o(138528);
        return;
        Log.d(b.access$getTAG$cp(), "verifyContact return not ok");
        paramBoolean2 = paramBoolean1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.b
 * JD-Core Version:    0.7.0.1
 */