package com.tencent.mm.sdk.platformtools;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AnimationHelperImpl21below
  implements BackwardSupportUtil.AnimationHelper.IHelper
{
  public void cancelAnimation(View paramView, Animation paramAnimation)
  {
    AppMethodBeat.i(263131);
    if (paramView != null) {
      paramView.setAnimation(null);
    }
    AppMethodBeat.o(263131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.AnimationHelperImpl21below
 * JD-Core Version:    0.7.0.1
 */