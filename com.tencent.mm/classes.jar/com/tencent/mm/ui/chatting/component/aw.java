package com.tencent.mm.ui.chatting.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.ay.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest;
import com.tencent.mm.openim.api.d;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.h.a;
import com.tencent.mm.openim.model.OpenImKefuStartChattingResultReceiver;
import com.tencent.mm.openim.model.OpenImKefuStartChattingResultReceiver.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.component.api.am;
import com.tencent.mm.ui.y;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=am.class)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/OpenIMKefuComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IOpenIMKefuComponent;", "()V", "session", "", "checkResUpdate", "", "closeChatting", "dealWithResendMsg", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "handleNameCardClick", "username", "", "extraData", "Landroid/os/Bundle;", "init", "onChattingEnterAnimStart", "onChattingInit", "onComponentInstall", "context", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "onComponentUnInstall", "release", "resendCardMsg", "msg", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  extends a
  implements am
{
  public static final aw.a aevw;
  private long hBk;
  
  static
  {
    AppMethodBeat.i(255816);
    aevw = new aw.a((byte)0);
    AppMethodBeat.o(255816);
  }
  
  private static final void a(aw paramaw)
  {
    AppMethodBeat.i(255807);
    s.u(paramaw, "this$0");
    paramaw.hlc.aezO.getController().supportInvalidateOptionsMenu();
    AppMethodBeat.o(255807);
  }
  
  private static final void jtj()
  {
    AppMethodBeat.i(255809);
    LauncherUI.getInstance().closeChatting(false);
    AppMethodBeat.o(255809);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(255829);
    super.a(parama);
    if (au.bwQ(this.hlc.getTalkerUserName()))
    {
      parama = this.hlc.Uxa;
      if (parama != null) {
        ((e)com.tencent.mm.kernel.h.ax(e.class)).u(parama.field_openImAppid, parama.field_descWordingId, 1);
      }
    }
    AppMethodBeat.o(255829);
  }
  
  public final boolean cU(cc paramcc)
  {
    AppMethodBeat.i(255852);
    if ((paramcc != null) && (paramcc.jbC() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (!s.p(this.hlc.getTalkerUserName(), "medianote"))
      {
        bh.bCz();
        c.bzz().d((k.b)new f(paramcc.field_talker, paramcc.field_msgSvrId));
      }
      an.cu(paramcc);
      this.hlc.jpK();
      AppMethodBeat.o(255852);
      return true;
    }
    AppMethodBeat.o(255852);
    return false;
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(255836);
    super.jjf();
    Log.v("MicroMsg.OpenIMKefuComponent", "alvinluo kefu onChattingInit");
    AppMethodBeat.o(255836);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(255840);
    super.jjg();
    com.tencent.threadpool.h.ahAA.o(new aw..ExternalSyntheticLambda0(this), 200L);
    AppMethodBeat.o(255840);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(255832);
    super.jqF();
    AppMethodBeat.o(255832);
  }
  
  public final void x(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(255846);
    OpenIMKefuStartConversationRequest localOpenIMKefuStartConversationRequest = new OpenIMKefuStartConversationRequest();
    Object localObject1 = this.hlc;
    label86:
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localOpenIMKefuStartConversationRequest.context = ((Context)localObject1);
      localOpenIMKefuStartConversationRequest.prw = 2;
      localOpenIMKefuStartConversationRequest.prx = h.a.xD(localOpenIMKefuStartConversationRequest.prw);
      localOpenIMKefuStartConversationRequest.prE = true;
      localOpenIMKefuStartConversationRequest.prB = true;
      localOpenIMKefuStartConversationRequest.prz = true;
      localObject1 = localOpenIMKefuStartConversationRequest.context;
      if (localObject1 != null) {
        break label251;
      }
      localObject1 = "";
      localOpenIMKefuStartConversationRequest.prA = ((String)localObject1);
      localObject2 = new du();
      if (paramBundle != null) {
        break label275;
      }
      paramBundle = "";
    }
    for (;;)
    {
      ((du)localObject2).YFW = paramBundle;
      ((du)localObject2).username = paramString;
      paramString = ah.aiuX;
      localOpenIMKefuStartConversationRequest.pry = ((du)localObject2);
      localOpenIMKefuStartConversationRequest.hBk = System.currentTimeMillis();
      this.hBk = localOpenIMKefuStartConversationRequest.hBk;
      paramString = new Intent();
      paramBundle = MMHandler.createFreeHandler(Looper.getMainLooper());
      s.s(paramBundle, "createFreeHandler(Looper.getMainLooper())");
      paramString.putExtra("key_result_receiver", (Parcelable)new OpenImKefuStartChattingResultReceiver(paramBundle, (OpenImKefuStartChattingResultReceiver.b)new aw.b(this)));
      paramBundle = ah.aiuX;
      localOpenIMKefuStartConversationRequest.prF = paramString;
      paramString = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (paramString != null) {
        paramString.a(localOpenIMKefuStartConversationRequest);
      }
      AppMethodBeat.o(255846);
      return;
      localObject1 = ((com.tencent.mm.ui.chatting.d.a)localObject1).aezO.getContext();
      break;
      label251:
      localObject2 = ((Context)localObject1).getString(l.i.open_im_kefu_start_conversation_error_tips);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label86;
      }
      localObject1 = "";
      break label86;
      label275:
      localObject1 = paramBundle.getString("kefu_card_ticket", "");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.aw
 * JD-Core Version:    0.7.0.1
 */