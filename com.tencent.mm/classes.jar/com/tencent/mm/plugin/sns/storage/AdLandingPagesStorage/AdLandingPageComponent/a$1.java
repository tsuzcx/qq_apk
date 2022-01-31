package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class a$1
  extends BroadcastReceiver
{
  a$1(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.mm.adlanding.close_exposure_voice".equals(paramIntent.getAction())) && (!this.oCd.bFm().oDg.equals(paramIntent.getStringExtra("para_id"))))
    {
      paramContext = this.oCd;
      if (paramContext.oCc) {
        paramContext.bER();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.1
 * JD-Core Version:    0.7.0.1
 */