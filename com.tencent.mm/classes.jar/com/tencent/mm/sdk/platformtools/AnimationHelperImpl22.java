package com.tencent.mm.sdk.platformtools;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AnimationHelperImpl22
  implements BackwardSupportUtil.AnimationHelper.IHelper
{
  public void cancelAnimation(View paramView, Animation paramAnimation)
  {
    AppMethodBeat.i(243523);
    paramAnimation.cancel();
    AppMethodBeat.o(243523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.AnimationHelperImpl22
 * JD-Core Version:    0.7.0.1
 */