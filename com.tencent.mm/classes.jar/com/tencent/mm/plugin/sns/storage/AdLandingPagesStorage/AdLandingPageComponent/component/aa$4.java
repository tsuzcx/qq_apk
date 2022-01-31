package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class aa$4
  implements ad
{
  aa$4(aa paramaa, Context paramContext) {}
  
  public final void ls(boolean paramBoolean)
  {
    AppMethodBeat.i(37305);
    Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localIntent.putExtra("show", i);
      d.R(this.val$context).c(localIntent);
      AppMethodBeat.o(37305);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa.4
 * JD-Core Version:    0.7.0.1
 */