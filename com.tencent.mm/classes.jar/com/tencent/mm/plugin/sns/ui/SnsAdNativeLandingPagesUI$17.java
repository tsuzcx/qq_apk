package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.sdk.platformtools.ac;

final class SnsAdNativeLandingPagesUI$17
  extends BroadcastReceiver
{
  SnsAdNativeLandingPagesUI$17(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(200457);
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      ac.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
      AppMethodBeat.o(200457);
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
    {
      ac.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
      al.aF(this.yHq);
    }
    AppMethodBeat.o(200457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.17
 * JD-Core Version:    0.7.0.1
 */