package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/OpenImKefuServiceChattingUI;", "Lcom/tencent/mm/ui/chatting/ChattingUI;", "()V", "isConfirmPageShown", "", "()Z", "isConfirmPageShown$delegate", "Lkotlin/Lazy;", "startConversationRequest", "Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;", "getStartConversationRequest", "()Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;", "startConversationRequest$delegate", "createFragment", "Lcom/tencent/mm/ui/chatting/ChattingUIFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OpenImKefuServiceChattingUI
  extends ChattingUI
{
  public static final OpenImKefuServiceChattingUI.a afrG;
  private final j afrH;
  private final j afrI;
  
  static
  {
    AppMethodBeat.i(256635);
    afrG = new OpenImKefuServiceChattingUI.a((byte)0);
    AppMethodBeat.o(256635);
  }
  
  public OpenImKefuServiceChattingUI()
  {
    AppMethodBeat.i(256621);
    this.afrH = k.cm((kotlin.g.a.a)new c(this));
    this.afrI = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(256621);
  }
  
  private final OpenIMKefuStartConversationRequest jAY()
  {
    AppMethodBeat.i(256625);
    OpenIMKefuStartConversationRequest localOpenIMKefuStartConversationRequest = (OpenIMKefuStartConversationRequest)this.afrH.getValue();
    AppMethodBeat.o(256625);
    return localOpenIMKefuStartConversationRequest;
  }
  
  private final boolean jAZ()
  {
    AppMethodBeat.i(256629);
    boolean bool = ((Boolean)this.afrI.getValue()).booleanValue();
    AppMethodBeat.o(256629);
    return bool;
  }
  
  public final ChattingUIFragment jot()
  {
    AppMethodBeat.i(256637);
    ChattingUIFragment localChattingUIFragment = (ChattingUIFragment)new OpenImKefuServiceConversationUI.OpenImKefuChattingUIFragment((byte)0);
    AppMethodBeat.o(256637);
    return localChattingUIFragment;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    OpenIMKefuStartConversationRequest localOpenIMKefuStartConversationRequest = null;
    AppMethodBeat.i(256641);
    super.onCreate(paramBundle);
    paramBundle = jAY();
    s.checkNotNull(paramBundle);
    Log.i("MicroMsg.OpenImKefuServiceChattingUI", "alvinluo enterKefuChattingUI getContactScene: %s, isConfirmPageShown: %s", new Object[] { Integer.valueOf(paramBundle.prw), Boolean.valueOf(jAZ()) });
    int i;
    if (jAZ())
    {
      i = 24;
      paramBundle = jAY();
      if (paramBundle != null) {
        break label103;
      }
      paramBundle = localOpenIMKefuStartConversationRequest;
    }
    for (;;)
    {
      localOpenIMKefuStartConversationRequest = jAY();
      s.checkNotNull(localOpenIMKefuStartConversationRequest);
      com.tencent.mm.openim.d.a.B(paramBundle, i, localOpenIMKefuStartConversationRequest.prw);
      AppMethodBeat.o(256641);
      return;
      i = 23;
      break;
      label103:
      du localdu = paramBundle.pry;
      paramBundle = localOpenIMKefuStartConversationRequest;
      if (localdu != null) {
        paramBundle = localdu.username;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    b(OpenImKefuServiceChattingUI paramOpenImKefuServiceChattingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<OpenIMKefuStartConversationRequest>
  {
    c(OpenImKefuServiceChattingUI paramOpenImKefuServiceChattingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.OpenImKefuServiceChattingUI
 * JD-Core Version:    0.7.0.1
 */