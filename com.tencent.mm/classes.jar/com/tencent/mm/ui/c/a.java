package com.tencent.mm.ui.c;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.c.a.c;

public final class a
{
  public static Animation gt(Context paramContext)
  {
    AppMethodBeat.i(141578);
    if (paramContext == null)
    {
      ae.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
      AppMethodBeat.o(141578);
      return null;
    }
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130771985);
    if (-1L > 0L) {
      paramContext.setDuration(-1L);
    }
    paramContext.setInterpolator(new c());
    AppMethodBeat.o(141578);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.c.a
 * JD-Core Version:    0.7.0.1
 */