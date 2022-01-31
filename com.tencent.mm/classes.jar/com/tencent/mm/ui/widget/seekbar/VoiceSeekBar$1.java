package com.tencent.mm.ui.widget.seekbar;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoiceSeekBar$1
  implements ViewTreeObserver.OnPreDrawListener
{
  VoiceSeekBar$1(VoiceSeekBar paramVoiceSeekBar) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(112964);
    this.AKm.qTD.getViewTreeObserver().removeOnPreDrawListener(this);
    this.AKm.AKl = this.AKm.qTD.getHeight();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.AKm.qTC.getLayoutParams();
    localLayoutParams.topMargin = ((int)((1.0F - this.AKm.AKk) * this.AKm.AKl));
    this.AKm.qTC.setLayoutParams(localLayoutParams);
    this.AKm.requestLayout();
    AppMethodBeat.o(112964);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.seekbar.VoiceSeekBar.1
 * JD-Core Version:    0.7.0.1
 */