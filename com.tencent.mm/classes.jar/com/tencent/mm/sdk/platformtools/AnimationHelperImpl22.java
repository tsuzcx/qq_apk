package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AnimationHelperImpl22
  implements BackwardSupportUtil.AnimationHelper.IHelper
{
  @TargetApi(8)
  public void cancelAnimation(View paramView, Animation paramAnimation)
  {
    AppMethodBeat.i(262250);
    paramAnimation.cancel();
    AppMethodBeat.o(262250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.AnimationHelperImpl22
 * JD-Core Version:    0.7.0.1
 */