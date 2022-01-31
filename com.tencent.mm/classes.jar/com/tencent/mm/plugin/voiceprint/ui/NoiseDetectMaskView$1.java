package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NoiseDetectMaskView$1
  implements View.OnClickListener
{
  NoiseDetectMaskView$1(NoiseDetectMaskView paramNoiseDetectMaskView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26141);
    if (NoiseDetectMaskView.a(this.tsd) != null) {
      NoiseDetectMaskView.a(this.tsd).cLr();
    }
    AppMethodBeat.o(26141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView.1
 * JD-Core Version:    0.7.0.1
 */