package com.tencent.mm.plugin.websearch.ui;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebSearchVideoPlayerSeekBar$3
  implements View.OnLayoutChangeListener
{
  WebSearchVideoPlayerSeekBar$3(WebSearchVideoPlayerSeekBar paramWebSearchVideoPlayerSeekBar) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(73816);
    if (paramInt3 - paramInt1 != paramInt7 - paramInt5) {
      this.uLv.aFy();
    }
    AppMethodBeat.o(73816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar.3
 * JD-Core Version:    0.7.0.1
 */