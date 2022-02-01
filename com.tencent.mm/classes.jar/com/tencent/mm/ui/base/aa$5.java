package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.cd.a;

final class aa$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aa$5(TextView paramTextView, Context paramContext) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(251489);
    if (this.rZg.getLineCount() > 1) {
      this.rZg.setTextSize(0, a.br(this.val$context, a.e.DescTextSize));
    }
    this.rZg.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    AppMethodBeat.o(251489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.aa.5
 * JD-Core Version:    0.7.0.1
 */