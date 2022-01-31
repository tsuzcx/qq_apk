package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class e$5
  implements ViewTreeObserver.OnPreDrawListener
{
  e$5(e parame, DynamicGridView paramDynamicGridView, List paramList) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(40325);
    this.skM.getViewTreeObserver().removeOnPreDrawListener(this);
    this.skN.Fm(this.skP.size());
    AppMethodBeat.o(40325);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.5
 * JD-Core Version:    0.7.0.1
 */