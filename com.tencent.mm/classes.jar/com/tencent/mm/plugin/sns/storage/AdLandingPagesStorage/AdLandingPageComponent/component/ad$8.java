package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class ad$8
  implements ak
{
  ad$8(ad paramad, Context paramContext) {}
  
  public final void qZ(boolean paramBoolean)
  {
    AppMethodBeat.i(200228);
    try
    {
      Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localIntent.putExtra("show", i);
        d.U(this.val$context).b(localIntent);
        AppMethodBeat.o(200228);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
      AppMethodBeat.o(200228);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.8
 * JD-Core Version:    0.7.0.1
 */