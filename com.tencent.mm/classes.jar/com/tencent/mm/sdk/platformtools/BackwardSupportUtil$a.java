package com.tencent.mm.sdk.platformtools;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BackwardSupportUtil$a
{
  public static void a(View paramView, Animation paramAnimation)
  {
    AppMethodBeat.i(156061);
    if (Build.VERSION.SDK_INT >= 8)
    {
      new c();
      paramAnimation.cancel();
      AppMethodBeat.o(156061);
      return;
    }
    new b();
    b.fK(paramView);
    AppMethodBeat.o(156061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a
 * JD-Core Version:    0.7.0.1
 */