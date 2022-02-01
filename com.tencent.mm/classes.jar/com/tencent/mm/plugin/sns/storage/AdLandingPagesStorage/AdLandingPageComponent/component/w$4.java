package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w$4
  implements ak
{
  w$4(w paramw, Context paramContext) {}
  
  public final void qZ(boolean paramBoolean)
  {
    AppMethodBeat.i(96628);
    Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localIntent.putExtra("show", i);
      d.U(this.val$context).b(localIntent);
      AppMethodBeat.o(96628);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w.4
 * JD-Core Version:    0.7.0.1
 */