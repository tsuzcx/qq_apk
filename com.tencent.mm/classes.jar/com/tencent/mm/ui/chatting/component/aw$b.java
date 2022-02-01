package com.tencent.mm.ui.chatting.component;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.model.OpenImKefuStartChattingResultReceiver.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/component/OpenIMKefuComponent$handleNameCardClick$request$1$2$1", "Lcom/tencent/mm/openim/model/OpenImKefuStartChattingResultReceiver$ReceiveResultCallback;", "onReceiveResult", "", "resultData", "Landroid/os/Bundle;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw$b
  implements OpenImKefuStartChattingResultReceiver.b
{
  aw$b(aw paramaw) {}
  
  public final void R(Bundle paramBundle)
  {
    AppMethodBeat.i(255798);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = Integer.valueOf(paramBundle.getInt("result_key_action")))
    {
      Log.i("MicroMsg.OpenIMKefuComponent", "alvinluo startConversation result action: %s", new Object[] { paramBundle });
      if (paramBundle != null) {
        break;
      }
      AppMethodBeat.o(255798);
      return;
    }
    if (paramBundle.intValue() == 3) {
      aw.jtk();
    }
    AppMethodBeat.o(255798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.aw.b
 * JD-Core Version:    0.7.0.1
 */