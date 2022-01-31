package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NoiseDetectMaskView$2
  implements View.OnClickListener
{
  NoiseDetectMaskView$2(NoiseDetectMaskView paramNoiseDetectMaskView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26142);
    if (NoiseDetectMaskView.b(this.tsd) != null) {
      NoiseDetectMaskView.b(this.tsd).cLq();
    }
    AppMethodBeat.o(26142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView.2
 * JD-Core Version:    0.7.0.1
 */