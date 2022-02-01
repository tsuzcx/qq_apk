package com.tencent.mm.plugin.radar.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.radar.a.g;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.g.b.an;
import kotlin.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getDelegate", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgListener", "com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1;", "needVerify", "Ljava/util/HashMap;", "", "onFMsgInfoNotify", "com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1;", "verifying", "Ljava/util/LinkedList;", "addContact", "", "username", "buildContact", "Lcom/tencent/mm/storage/Contact;", "verify", "Lcom/tencent/mm/storage/MsgInfo$VerifyContent;", "getStatus", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getVerifyMsg", "", "onAddContactReturn", "ret", "hasSendVerify", "errMsg", "timeStamp", "onCreate", "", "onDestroy", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onRecvFriendAdded", "contact", "onRecvFriendVerify", "onVerifyContactReturn", "putVerifyMsg", "msgContent", "removeVerifyMsg", "removeVerifying", "reset", "updateFMsgConversationState", "state", "verifyContact", "AddContactHelper", "Companion", "IOnAddContact", "IOnAddContactHelper", "Status", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements MStorageEx.IOnStorageChange
{
  public static final b.b Nrs;
  public static final String TAG;
  private final c Nrt;
  private final LinkedList<String> Nru;
  public final HashMap<String, String> Nrv;
  public final RadarAddContact.onFMsgInfoNotify.1 Nrw;
  public final g Nrx;
  final Context context;
  private final MMHandler handler;
  
  static
  {
    AppMethodBeat.i(138536);
    Nrs = new b.b((byte)0);
    TAG = "MicroMsg.RadarAddContact";
    AppMethodBeat.o(138536);
  }
  
  public b(c paramc, Context paramContext)
  {
    AppMethodBeat.i(138535);
    this.Nrt = paramc;
    this.context = paramContext;
    this.Nru = new LinkedList();
    this.Nrv = new HashMap();
    this.Nrw = new RadarAddContact.onFMsgInfoNotify.1(this, f.hfK);
    this.Nrx = new g(this);
    this.handler = new MMHandler();
    AppMethodBeat.o(138535);
  }
  
  private static final void a(b paramb, au paramau)
  {
    AppMethodBeat.i(267198);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramau, "$contact");
    paramb.Nrt.at(paramau);
    AppMethodBeat.o(267198);
  }
  
  private static final void a(b paramb, boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(267210);
    kotlin.g.b.s.u(paramb, "this$0");
    paramb.Nrt.a(paramBoolean, paramString1, paramString2, paramLong);
    AppMethodBeat.o(267210);
  }
  
  private static final void a(b paramb, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(267205);
    kotlin.g.b.s.u(paramb, "this$0");
    paramb.Nrt.a(paramBoolean1, paramBoolean2, paramString1, paramString2, paramLong);
    AppMethodBeat.o(267205);
  }
  
  private final void aq(au paramau)
  {
    AppMethodBeat.i(138531);
    if (this.Nru.contains(paramau.field_username)) {
      this.Nru.remove(paramau.field_username);
    }
    if (this.Nru.contains(paramau.field_encryptUsername)) {
      this.Nru.remove(paramau.field_encryptUsername);
    }
    AppMethodBeat.o(138531);
  }
  
  private final void ar(au paramau)
  {
    AppMethodBeat.i(138532);
    this.Nrv.remove(paramau.field_username);
    this.Nrv.remove(paramau.field_encryptUsername);
    AppMethodBeat.o(138532);
  }
  
  private final void as(au paramau)
  {
    AppMethodBeat.i(138534);
    aq(paramau);
    ar(paramau);
    this.handler.post(new b..ExternalSyntheticLambda0(this, paramau));
    AppMethodBeat.o(138534);
  }
  
  private static final void b(b paramb, au paramau)
  {
    AppMethodBeat.i(267200);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramau, "$contact");
    paramb.Nrt.as(paramau);
    AppMethodBeat.o(267200);
  }
  
  public final long aSv(final String paramString)
  {
    AppMethodBeat.i(138529);
    kotlin.g.b.s.u(paramString, "username");
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
      locala.NrA = localLinkedList;
      locala.sWX = paramString;
      if (paramString != null) {
        locala.Nrz.add(paramString);
      }
      new com.tencent.mm.pluginsdk.ui.applet.ab(locala.NrB.context, null).S((List)locala.Nrz, (List)localLinkedList);
      AppMethodBeat.o(138529);
      return l;
    }
  }
  
  public final e aSw(String paramString)
  {
    AppMethodBeat.i(138530);
    kotlin.g.b.s.u(paramString, "username");
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString);
    if ((localObject == null) || ((int)((d)localObject).maN == 0)) {
      if (this.Nru.contains(paramString)) {
        localObject = e.NrD;
      }
    }
    for (;;)
    {
      Log.d(TAG, "query username(%s) status %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(138530);
      return localObject;
      localObject = e.NrC;
      continue;
      if (d.rs(((az)localObject).field_type)) {
        localObject = e.NrE;
      } else if (this.Nrv.containsKey(paramString)) {
        localObject = e.NrF;
      } else if (this.Nru.contains(paramString)) {
        localObject = e.NrD;
      } else {
        localObject = e.NrC;
      }
    }
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(138533);
    kotlin.g.b.s.u(paramMStorageEx, "stg");
    Log.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(138533);
      return;
    }
    paramMStorageEx = (String)paramObject;
    paramObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramMStorageEx);
    if ((paramObject != null) && (d.rs(paramObject.field_type)))
    {
      Log.d(TAG, "ContactStg onNotifyChange %s", new Object[] { paramMStorageEx });
      as(paramObject);
    }
    AppMethodBeat.o(138533);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$AddContactHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "callback", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;)V", "lstScene", "Ljava/util/LinkedList;", "", "lstUsername", "", "mUsername", "addContact", "", "username", "finish", "ok", "", "hasSentVerify", "respUsername", "errMsg", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "onStop", "sendVerifyRequest", "verifyOk", "verifyTicket", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements com.tencent.mm.am.h
  {
    LinkedList<Integer> NrA;
    private final b.d Nry;
    final LinkedList<String> Nrz;
    String sWX;
    
    public a()
    {
      AppMethodBeat.i(138516);
      Object localObject;
      this.Nry = localObject;
      this.Nrz = new LinkedList();
      AppMethodBeat.o(138516);
    }
    
    private final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138514);
      com.tencent.mm.kernel.h.aZW().b(30, (com.tencent.mm.am.h)this);
      b.d locald = this.Nry;
      if (locald != null) {
        locald.canAddContact(paramBoolean1, paramBoolean2, paramString1, paramString2);
      }
      AppMethodBeat.o(138514);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(138515);
      kotlin.g.b.s.u(paramp, "scene");
      Log.d(b.access$getTAG$cp(), "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      if (paramp.getType() != 30)
      {
        Log.w(b.access$getTAG$cp(), kotlin.g.b.s.X("not expected scene,  type = ", Integer.valueOf(paramp.getType())));
        AppMethodBeat.o(138515);
        return;
      }
      if (((v)paramp).hId == 2)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(false, true, this.sWX, "");
          AppMethodBeat.o(138515);
          return;
        }
        if ((paramInt1 == 4) && (paramInt2 == -34))
        {
          paramp = b.this.context.getString(a.g.fmessage_request_too_offen);
          kotlin.g.b.s.s(paramp, "when {\n                 …il)\n                    }");
        }
      }
      for (;;)
      {
        a(false, false, this.sWX, paramp);
        AppMethodBeat.o(138515);
        return;
        if ((paramInt1 == 4) && (paramInt2 == -94))
        {
          paramp = b.this.context.getString(a.g.fmessage_user_not_support);
          break;
        }
        if ((paramInt1 == 4) && ((paramInt2 == -24) || (paramInt2 == -101)))
        {
          paramp = paramString;
          if (paramString != null) {
            break;
          }
        }
        paramp = b.this.context.getString(a.g.sendrequest_send_fail);
        break;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(true, false, this.sWX, "");
          AppMethodBeat.o(138515);
          return;
        }
        if (paramInt2 == -44)
        {
          new com.tencent.mm.pluginsdk.ui.applet.ab(b.this.context, null).S((List)this.Nrz, (List)this.NrA);
          AppMethodBeat.o(138515);
          return;
        }
        if (paramInt2 == -87)
        {
          a(false, false, this.sWX, b.this.context.getString(a.g.contact_info_biz_join_fans_limit));
          AppMethodBeat.o(138515);
          return;
        }
        if ((paramInt2 == -24) && (!Util.isNullOrNil(paramString)))
        {
          String str = this.sWX;
          paramp = paramString;
          if (paramString == null) {
            paramp = "";
          }
          a(false, false, str, paramp);
          AppMethodBeat.o(138515);
          return;
        }
        if ((paramInt1 == 4) && (paramInt2 == -22)) {
          paramp = b.this.context.getString(a.g.addcontact_fail_blacklist);
        } else {
          paramp = b.this.context.getString(a.g.addcontact_fail);
        }
      }
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(138513);
      com.tencent.mm.kernel.h.aZW().a(30, (com.tencent.mm.am.h)this);
      AppMethodBeat.o(138513);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "", "onAddContactReturn", "", "ok", "", "hasSentVerify", "errMsg", "", "username", "timeStamp", "", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onVerifyContactReturn", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong);
    
    public abstract void as(au paramau);
    
    public abstract void at(au paramau);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void canAddContact(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "", "(Ljava/lang/String;I)V", "Stranger", "Verifying", "Added", "NeedVerify", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum e
  {
    static
    {
      AppMethodBeat.i(138517);
      NrC = new e("Stranger", 0);
      NrD = new e("Verifying", 1);
      NrE = new e("Added", 2);
      NrF = new e("NeedVerify", 3);
      NrG = new e[] { NrC, NrD, NrE, NrF };
      AppMethodBeat.o(138517);
    }
    
    private e() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/model/RadarAddContact$addContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements b.d
  {
    f(b paramb, String paramString, long paramLong) {}
    
    public final void canAddContact(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138520);
      if (paramBoolean1)
      {
        Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString1);
        if ((int)((d)localObject).maN > 0) {
          com.tencent.mm.model.ab.I((au)localObject);
        }
        b.gA(paramString1, 1);
        if (kotlin.a.p.a((Iterable)b.a(this.NrB), paramString1))
        {
          localObject = (Collection)b.a(this.NrB);
          if (localObject == null)
          {
            paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            AppMethodBeat.o(138520);
            throw paramString1;
          }
          an.hA(localObject).remove(paramString1);
        }
        Log.d(b.access$getTAG$cp(), "addContact %s return ok", new Object[] { paramString });
      }
      for (;;)
      {
        b.b(this.NrB, paramBoolean1, paramBoolean2, paramString2, paramString1, l);
        AppMethodBeat.o(138520);
        return;
        if (paramBoolean2)
        {
          if ((paramString1 != null) && (!b.a(this.NrB).contains(paramString1))) {
            b.a(this.NrB).add(paramString1);
          }
          b.gA(paramString1, 2);
          Log.d(b.access$getTAG$cp(), "addContact has sent verify to %s", new Object[] { paramString });
        }
        else
        {
          Log.d(b.access$getTAG$cp(), "addContact return not ok, user canceled or error");
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "NODE_ENCRYPT_USERNAME", "", "NODE_TYPE", "NODE_USERNAME", "onDeleteMsg", "", "msg", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "onRecieveMsg", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements cl.a
  {
    private final String NrI = ".sysmsg.addcontact.type";
    private final String NrJ = ".sysmsg.addcontact.username";
    private final String NrK = ".sysmsg.addcontact.encryptusername";
    
    g(b paramb) {}
    
    public final void a(g.a parama)
    {
      AppMethodBeat.i(138521);
      kotlin.g.b.s.u(parama, "addMsgInfo");
      Object localObject1 = w.a(parama.mpN.YFG);
      Object localObject2 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
      if (localObject2 == null)
      {
        AppMethodBeat.o(138521);
        return;
      }
      if (kotlin.g.b.s.p(((Map)localObject2).get(this.NrI), "1"))
      {
        parama = (String)((Map)localObject2).get(this.NrJ);
        localObject2 = (String)((Map)localObject2).get(this.NrK);
        CharSequence localCharSequence = (CharSequence)parama;
        if ((localCharSequence == null) || (kotlin.n.n.bp(localCharSequence)))
        {
          i = 1;
          if (i == 0)
          {
            localCharSequence = (CharSequence)localObject2;
            if ((localCharSequence != null) && (!kotlin.n.n.bp(localCharSequence))) {
              break label170;
            }
          }
        }
        label170:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label175;
          }
          Log.e(b.access$getTAG$cp(), "error! server return incorrect content! : %s", new Object[] { localObject1 });
          AppMethodBeat.o(138521);
          return;
          i = 0;
          break;
        }
        label175:
        localObject1 = new au();
        ((au)localObject1).setUsername(parama);
        ((au)localObject1).Bd((String)localObject2);
        b.e(this.NrB, (au)localObject1);
        Log.d(b.access$getTAG$cp(), "receive contact added system message useranme %s, encypt %s", new Object[] { ((az)localObject1).field_username, ((az)localObject1).field_encryptUsername });
      }
      AppMethodBeat.o(138521);
    }
    
    public final void a(g.c paramc)
    {
      AppMethodBeat.i(138522);
      paramc = (Throwable)new q("An operation is not implemented: ".concat(String.valueOf("not implemented")));
      AppMethodBeat.o(138522);
      throw paramc;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/model/RadarAddContact$verifyContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements b.d
  {
    public h(String paramString, b paramb, long paramLong) {}
    
    public final void canAddContact(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(138528);
      if (paramBoolean1)
      {
        au localau2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString1);
        au localau1;
        if (localau2 != null)
        {
          localau1 = localau2;
          paramBoolean2 = paramBoolean1;
          if ((int)localau2.maN != 0) {}
        }
        else
        {
          localau1 = b.a(cc.f.byv(this.qQH));
          if (!((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aB(localau1))
          {
            Log.e(b.access$getTAG$cp(), "canAddContact fail, insert fail");
            paramBoolean1 = false;
          }
          localau1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(localau1.field_username);
          paramBoolean2 = paramBoolean1;
        }
        Log.d(b.access$getTAG$cp(), "verifyContact return ok");
        com.tencent.mm.model.ab.I(localau1);
        b.gA(paramString1, 1);
      }
      for (;;)
      {
        b.b(this.NrB, paramBoolean2, paramString2, paramString1, this.NrH);
        AppMethodBeat.o(138528);
        return;
        Log.d(b.access$getTAG$cp(), "verifyContact return not ok");
        paramBoolean2 = paramBoolean1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.model.b
 * JD-Core Version:    0.7.0.1
 */