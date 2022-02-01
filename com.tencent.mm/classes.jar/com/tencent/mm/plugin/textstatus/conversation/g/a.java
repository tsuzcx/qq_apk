package com.tencent.mm.plugin.textstatus.conversation.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.r.a;
import com.tencent.mm.plugin.textstatus.a.r.b;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.plugin.textstatus.conversation.d.g;
import com.tencent.mm.plugin.textstatus.h.f.i;
import com.tencent.mm.plugin.textstatus.proto.bd;
import com.tencent.mm.plugin.textstatus.proto.o;
import com.tencent.mm.plugin.textstatus.proto.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx.a;
import com.tencent.mm.ui.base.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/service/TextStatusContactService;", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusContactService;", "()V", "TAG", "", "contactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension", "()Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "canTalk", "", "sessionId", "checkContactExpired", "", "isCheckAvatar", "clickAvatar", "context", "Landroid/content/Context;", "talker", "fetchContact", "Lcom/tencent/mm/modelbase/NetSceneBase;", "item", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "callback", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusContactService$ReqContactCallback;", "lifeCycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "contact", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContact;", "params", "Lkotlin/Pair;", "sessionsToNames", "", "getBigUrl", "getContact", "getUsernameBySessionId", "handleClickConversationTop", "isSessionMute", "jumpChatInner", "jumpChatting", "fromUserName", "jumpFriendChatting", "changeUserName", "modifyMsgSessionMuteSetting", "ifOpen", "preRenderMiniApp", "replyGreeting", "lifecycleOwner", "Lkotlin/Function1;", "report", "action", "", "requestContact", "sessionIds", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.textstatus.a.r
{
  public static final a Tjq;
  private static final bx.a pqO;
  
  static
  {
    AppMethodBeat.i(291201);
    Tjq = new a();
    pqO = (bx.a)new a.a();
    AppMethodBeat.o(291201);
  }
  
  public static com.tencent.mm.am.p a(com.tencent.mm.plugin.textstatus.conversation.d.d paramd, q paramq, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(291188);
    if (paramd != null)
    {
      Object localObject = new o();
      ((o)localObject).tag = paramd.field_tag;
      ((o)localObject).ToB = paramd.field_source_id;
      ((o)localObject).ToW = paramd.field_status_id;
      ((o)localObject).Tpb = paramd.field_modify_count;
      ((o)localObject).Tpa = paramd.field_card_key;
      ((o)localObject).action = 1;
      paramd = new com.tencent.mm.plugin.textstatus.conversation.b.c(paramd);
      localObject = com.tencent.mm.kernel.h.aZW();
      kotlin.g.b.s.s(localObject, "getNetSceneQueue()");
      com.tencent.mm.plugin.textstatus.conversation.e.a.a((com.tencent.mm.am.s)localObject, (com.tencent.mm.am.p)paramd, paramq, (com.tencent.mm.am.h)new a.d(paramd, paramb));
      paramd = (com.tencent.mm.am.p)paramd;
      AppMethodBeat.o(291188);
      return paramd;
    }
    AppMethodBeat.o(291188);
    return null;
  }
  
  private static com.tencent.mm.am.p a(List<kotlin.r<String, String>> paramList, r.b paramb, q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(291145);
    kotlin.g.b.s.u(paramList, "sessionsToNames");
    paramList = new com.tencent.mm.plugin.textstatus.conversation.b.a(paramList, paramBoolean);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.aZW();
    kotlin.g.b.s.s(locals, "getNetSceneQueue()");
    com.tencent.mm.plugin.textstatus.conversation.e.a.a(locals, (com.tencent.mm.am.p)paramList, paramq, (com.tencent.mm.am.h)new a.b(paramList, paramb));
    paramList = (com.tencent.mm.am.p)paramList;
    AppMethodBeat.o(291145);
    return paramList;
  }
  
  private static com.tencent.mm.am.p a(kotlin.r<String, String> paramr, r.b paramb, q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(291126);
    kotlin.g.b.s.u(paramr, "params");
    paramr = a(kotlin.a.p.listOf(paramr), paramb, paramq, paramBoolean);
    AppMethodBeat.o(291126);
    return paramr;
  }
  
  private static final void a(String paramString, Context paramContext, boolean paramBoolean, List paramList)
  {
    AppMethodBeat.i(291192);
    kotlin.g.b.s.u(paramContext, "$context");
    if (paramBoolean)
    {
      k(paramString, paramContext);
      AppMethodBeat.o(291192);
      return;
    }
    k.c(paramContext, paramContext.getString(a.h.msg_net_error), "", true);
    AppMethodBeat.o(291192);
  }
  
  public static void bY(Context paramContext, String paramString)
  {
    AppMethodBeat.i(291155);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "changeUserName");
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("Chat_Mode", 1);
    localIntent.setClassName(paramContext, "com.tencent.mm.ui.chatting.ChattingUI");
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/textstatus/conversation/service/TextStatusContactService", "jumpFriendChatting", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/conversation/service/TextStatusContactService", "jumpFriendChatting", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(291155);
  }
  
  public static com.tencent.mm.plugin.textstatus.h.f.h bdK(String paramString)
  {
    AppMethodBeat.i(291101);
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    paramString = com.tencent.mm.plugin.textstatus.b.f.hGK().bdK(paramString);
    AppMethodBeat.o(291101);
    return paramString;
  }
  
  public static boolean bdL(String paramString)
  {
    AppMethodBeat.i(291171);
    paramString = bdK(paramString);
    if ((paramString != null) && (paramString.field_canTalk == 1))
    {
      AppMethodBeat.o(291171);
      return true;
    }
    AppMethodBeat.o(291171);
    return false;
  }
  
  public static bx.a diu()
  {
    return pqO;
  }
  
  private static void k(String paramString, Context paramContext)
  {
    AppMethodBeat.i(291163);
    Object localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.b.f.hGL().aAB(paramString);
    localObject = new Intent();
    ((Intent)localObject).putExtra("Chat_Self", com.tencent.mm.plugin.auth.a.a.cUx());
    ((Intent)localObject).putExtra("Chat_User", paramString);
    ((Intent)localObject).putExtra("finish_direct", true);
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    com.tencent.mm.br.c.g(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject);
    AppMethodBeat.o(291163);
  }
  
  public final void a(String paramString1, String paramString2, Context paramContext)
  {
    AppMethodBeat.i(291255);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
          break label80;
        }
      }
    }
    label80:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label86;
      }
      AppMethodBeat.o(291255);
      return;
      i = 0;
      break;
    }
    label86:
    localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    String str = com.tencent.mm.plugin.textstatus.b.f.hGM().bdP(paramString1).field_sessionId;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    if (n.bp((CharSequence)localObject))
    {
      localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      com.tencent.mm.plugin.textstatus.b.f.hGM().b(paramString1, paramString2, 0, 0, 0, 0, "");
    }
    localObject = bdK(paramString1);
    if (localObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.TextStatus.TextStatusContactService", kotlin.g.b.s.X("jumpChatting() called with: contact == null ", Boolean.valueOf(bool)));
      if (localObject != null) {
        break;
      }
      a(v.Y(paramString1, paramString2), new a..ExternalSyntheticLambda0(paramString1, paramContext), false, 12);
      AppMethodBeat.o(291255);
      return;
    }
    k(paramString1, paramContext);
    AppMethodBeat.o(291255);
  }
  
  public final void a(List<String> paramList, r.b paramb, q paramq)
  {
    AppMethodBeat.i(291310);
    Log.d("MicroMsg.TextStatus.TextStatusContactService", "requestSessionStatus() called with: sessionIds = " + paramList + ", callback = " + paramb);
    LinkedList localLinkedList = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Object localObject = bdK(str);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.textstatus.h.f.h)localObject).field_userName;
        if (localObject != null) {
          localLinkedList.add(v.Y(str, localObject));
        }
      }
    }
    a((List)localLinkedList, paramb, paramq, true);
    AppMethodBeat.o(291310);
  }
  
  public final boolean aAp(String paramString)
  {
    AppMethodBeat.i(291276);
    paramString = bdK(paramString);
    if ((paramString != null) && (paramString.field_block == 1))
    {
      AppMethodBeat.o(291276);
      return true;
    }
    AppMethodBeat.o(291276);
    return false;
  }
  
  public final void bV(Context paramContext, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(291241);
    kotlin.g.b.s.u(paramContext, "context");
    if (kotlin.g.b.s.p(paramString, com.tencent.mm.plugin.auth.a.a.cUx()))
    {
      paramContext = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
      paramContext = com.tencent.mm.plugin.auth.a.a.cUx();
      kotlin.g.b.s.s(paramContext, "username()");
      f.a.hp(paramContext, 152);
      AppMethodBeat.o(291241);
      return;
    }
    com.tencent.mm.plugin.textstatus.h.f.h localh = bdK(paramString);
    if (localh == null)
    {
      paramContext = localObject;
      if (paramContext == null) {
        Log.e("MicroMsg.TextStatus.TextStatusContactService", kotlin.g.b.s.X("contact is null for ", paramString));
      }
      AppMethodBeat.o(291241);
      return;
    }
    new com.tencent.mm.plugin.textstatus.conversation.ui.a(paramContext, localh, null, false, 4).dDn();
    paramContext = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
    if (paramString == null) {}
    for (paramContext = "";; paramContext = paramString)
    {
      f.a.hp(paramContext, 151);
      paramContext = ah.aiuX;
      break;
    }
  }
  
  public final void bW(Context paramContext, String paramString)
  {
    AppMethodBeat.i(291217);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
    if (paramString == null) {}
    for (localObject = "";; localObject = paramString)
    {
      f.a.hp((String)localObject, 160);
      localObject = bdK(paramString);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(291217);
      return;
    }
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    if (com.tencent.mm.plugin.textstatus.b.f.bdN(paramString) != null) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(291217);
      return;
    }
    kotlin.g.b.s.u(localObject, "contact");
    a(v.Y(((com.tencent.mm.plugin.textstatus.h.f.h)localObject).field_sessionId, ((com.tencent.mm.plugin.textstatus.h.f.h)localObject).field_userName), null, false, 8);
    paramString = c.Tjw;
    c.U(paramContext, ((com.tencent.mm.plugin.textstatus.h.f.h)localObject).field_userName, "chat");
    AppMethodBeat.o(291217);
  }
  
  public final void bX(Context paramContext, String paramString)
  {
    AppMethodBeat.i(291237);
    kotlin.g.b.s.u(paramContext, "context");
    paramString = bdK(paramString);
    Object localObject = c.Tjw;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      c.a(paramContext, kotlin.a.p.listOf(paramString), "chat");
      AppMethodBeat.o(291237);
      return;
      localObject = paramString.field_userName;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
    }
  }
  
  public final String bdq(String paramString)
  {
    AppMethodBeat.i(291264);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = bdK(paramString);
      if (paramString == null) {
        break;
      }
      paramString = paramString.field_bigHeadImgUrl;
      AppMethodBeat.o(291264);
      return paramString;
    }
    AppMethodBeat.o(291264);
    return "";
  }
  
  public final void d(Context paramContext, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(291293);
    kotlin.g.b.s.u(paramContext, "context");
    Log.d("MicroMsg.TextStatus.TextStatusContactService", "modifyMsgSessionMuteSetting() called with: ifOpen = " + paramBoolean + ", sessionId = " + paramString);
    Object localObject1 = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
    if (paramString == null)
    {
      localObject1 = "";
      if (!paramBoolean) {
        break label99;
      }
    }
    label99:
    for (int i = 155;; i = 156)
    {
      f.a.hp((String)localObject1, i);
      localObject2 = bdK(paramString);
      if (localObject2 != null) {
        break label107;
      }
      AppMethodBeat.o(291293);
      return;
      localObject1 = paramString;
      break;
    }
    label107:
    Object localObject3 = new bd();
    ((bd)localObject3).ToG = ((com.tencent.mm.plugin.textstatus.h.f.h)localObject2).field_userName;
    ((bd)localObject3).ToL = paramBoolean;
    localObject1 = new u();
    ((u)localObject1).Tps = 11;
    localObject3 = ((bd)localObject3).toByteArray();
    ((u)localObject1).Tpt = com.tencent.mm.bx.b.bsj(Base64.encodeToString((byte[])localObject3, 0, localObject3.length, 2));
    localObject3 = e.Tjy;
    paramContext = (q)paramContext;
    paramString = (r.a)new c(paramString, (com.tencent.mm.plugin.textstatus.h.f.h)localObject2);
    kotlin.g.b.s.u(localObject1, "item");
    Object localObject2 = new LinkedList();
    ((LinkedList)localObject2).add(localObject1);
    localObject1 = ah.aiuX;
    e.a((LinkedList)localObject2, paramContext, paramString);
    AppMethodBeat.o(291293);
  }
  
  public final void dh(String paramString, int paramInt)
  {
    AppMethodBeat.i(291225);
    Object localObject = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    f.a.hp((String)localObject, paramInt);
    AppMethodBeat.o(291225);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/conversation/service/TextStatusContactService$modifyMsgSessionMuteSetting$1", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusContactService$OplogCallback;", "onDone", "", "result", "", "rsp", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusOplogResp;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements r.a
  {
    c(String paramString, com.tencent.mm.plugin.textstatus.h.f.h paramh) {}
    
    public final void Fv(boolean paramBoolean)
    {
      AppMethodBeat.i(291097);
      if (paramBoolean)
      {
        a locala = a.Tjq;
        a.a(v.Y(this.AGN, this.Tjt.field_userName), null, false, 14);
      }
      AppMethodBeat.o(291097);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.g.a
 * JD-Core Version:    0.7.0.1
 */