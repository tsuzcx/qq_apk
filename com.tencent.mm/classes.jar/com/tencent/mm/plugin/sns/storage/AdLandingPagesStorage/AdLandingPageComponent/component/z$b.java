package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.model.OpenImKefuStartChattingResultReceiver.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageJumpKefuBtnComp$doBtnClick$1", "Lcom/tencent/mm/openim/model/OpenImKefuStartChattingResultReceiver$ReceiveResultCallback;", "onReceiveResult", "", "resultData", "Landroid/os/Bundle;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z$b
  implements OpenImKefuStartChattingResultReceiver.b
{
  public final void R(Bundle paramBundle)
  {
    AppMethodBeat.i(306991);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = Integer.valueOf(paramBundle.getInt("result_key_action")))
    {
      Log.i("MicroMsg.AdLandingPageJumpKefuBtnComp", "adLandingPage startConversation result action: %s", new Object[] { paramBundle });
      AppMethodBeat.o(306991);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.b
 * JD-Core Version:    0.7.0.1
 */