package com.tencent.mm.ui.c;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.c.b.c;

public final class a
{
  public static Animation jdMethod_if(Context paramContext)
  {
    AppMethodBeat.i(141578);
    if (paramContext == null)
    {
      Log.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
      AppMethodBeat.o(141578);
      return null;
    }
    paramContext = AnimationUtils.loadAnimation(paramContext, a.a.anim_flash);
    if (-1L > 0L) {
      paramContext.setDuration(-1L);
    }
    paramContext.setInterpolator(new c());
    AppMethodBeat.o(141578);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.c.a
 * JD-Core Version:    0.7.0.1
 */