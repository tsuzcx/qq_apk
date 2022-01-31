package com.tencent.mm.ui.c;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.c.a.c;

public final class a
{
  public static Animation eY(Context paramContext)
  {
    AppMethodBeat.i(106218);
    if (paramContext == null)
    {
      ab.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
      AppMethodBeat.o(106218);
      return null;
    }
    paramContext = AnimationUtils.loadAnimation(paramContext, 2131034129);
    if (-1L > 0L) {
      paramContext.setDuration(-1L);
    }
    paramContext.setInterpolator(new c());
    AppMethodBeat.o(106218);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.c.a
 * JD-Core Version:    0.7.0.1
 */