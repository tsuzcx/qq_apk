package com.tencent.mm.ui.c;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.ac.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.c.a.c;

public final class a
{
  public static Animation gE(Context paramContext)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
      return null;
    }
    paramContext = AnimationUtils.loadAnimation(paramContext, a.a.anim_flash);
    if (-1L > 0L) {
      paramContext.setDuration(-1L);
    }
    paramContext.setInterpolator(new c());
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.c.a
 * JD-Core Version:    0.7.0.1
 */