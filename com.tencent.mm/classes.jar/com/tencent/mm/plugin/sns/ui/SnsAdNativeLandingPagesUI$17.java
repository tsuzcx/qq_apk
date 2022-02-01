package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.sdk.platformtools.ae;

final class SnsAdNativeLandingPagesUI$17
  extends BroadcastReceiver
{
  SnsAdNativeLandingPagesUI$17(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(219812);
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      ae.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
      AppMethodBeat.o(219812);
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
    {
      ae.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
      an.aG(this.ApW);
    }
    AppMethodBeat.o(219812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.17
 * JD-Core Version:    0.7.0.1
 */