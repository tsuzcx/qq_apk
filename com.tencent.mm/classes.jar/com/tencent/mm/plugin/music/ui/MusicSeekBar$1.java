package com.tencent.mm.plugin.music.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.SeekBar;

final class MusicSeekBar$1
  implements ValueAnimator.AnimatorUpdateListener
{
  MusicSeekBar$1(MusicSeekBar paramMusicSeekBar) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.mCm.mCj;
    paramValueAnimator.mCo = f;
    paramValueAnimator.invalidateSelf();
    MusicSeekBar.a(this.mCm).setThumb(this.mCm.mCj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicSeekBar.1
 * JD-Core Version:    0.7.0.1
 */