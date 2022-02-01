package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ci.a;

final class w$6
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  w$6(TextView paramTextView, Context paramContext) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(187465);
    if (this.oTS.getLineCount() > 1) {
      this.oTS.setTextSize(0, a.aY(this.val$context, a.e.DescTextSize));
    }
    this.oTS.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    AppMethodBeat.o(187465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.w.6
 * JD-Core Version:    0.7.0.1
 */