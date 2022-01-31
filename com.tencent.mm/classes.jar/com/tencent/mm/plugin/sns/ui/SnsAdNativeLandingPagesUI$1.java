package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class SnsAdNativeLandingPagesUI$1
  extends BroadcastReceiver
{
  SnsAdNativeLandingPagesUI$1(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    int i = paramIntent.getIntExtra("show", 0);
    paramContext = (b)((m)SnsAdNativeLandingPagesUI.a(this.oUU).getAdapter()).ae(SnsAdNativeLandingPagesUI.a(this.oUU).getCurrentItem());
    y.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show %d", new Object[] { Integer.valueOf(i) });
    if (i == 1) {}
    for (;;)
    {
      paramContext.oJs = bool;
      if ((!paramContext.bFR()) || (bool)) {
        break;
      }
      paramContext.bFQ();
      return;
      bool = false;
    }
    paramContext.bFP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.1
 * JD-Core Version:    0.7.0.1
 */