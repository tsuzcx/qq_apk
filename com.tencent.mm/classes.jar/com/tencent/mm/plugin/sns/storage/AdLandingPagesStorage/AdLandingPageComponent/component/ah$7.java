package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ah$7
  implements ak
{
  ah$7(ah paramah, Context paramContext) {}
  
  public final void qZ(boolean paramBoolean)
  {
    AppMethodBeat.i(200271);
    Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localIntent.putExtra("show", i);
      d.U(this.val$context).b(localIntent);
      AppMethodBeat.o(200271);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah.7
 * JD-Core Version:    0.7.0.1
 */