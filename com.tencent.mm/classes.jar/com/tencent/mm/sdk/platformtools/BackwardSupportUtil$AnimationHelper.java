package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BackwardSupportUtil$AnimationHelper
{
  public static void cancelAnimation(View paramView, Animation paramAnimation)
  {
    AppMethodBeat.i(156061);
    if (Build.VERSION.SDK_INT >= 8)
    {
      new AnimationHelperImpl22().cancelAnimation(paramView, paramAnimation);
      AppMethodBeat.o(156061);
      return;
    }
    new AnimationHelperImpl21below().cancelAnimation(paramView, paramAnimation);
    AppMethodBeat.o(156061);
  }
  
  public static void overridePendingTransition(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261892);
    paramActivity.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(261892);
  }
  
  public static abstract interface IHelper
  {
    public abstract void cancelAnimation(View paramView, Animation paramAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper
 * JD-Core Version:    0.7.0.1
 */