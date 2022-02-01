package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Paint;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  implements Runnable
{
  e$1(TextView paramTextView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(36751);
    TextPaint localTextPaint = this.jip.getPaint();
    float f = this.jip.getMeasuredWidth() - this.jip.getPaddingLeft() - this.jip.getPaddingRight();
    if (localTextPaint.measureText(this.val$content) > f)
    {
      this.jip.setMinLines(2);
      AppMethodBeat.o(36751);
      return;
    }
    this.jip.setMinLines(0);
    AppMethodBeat.o(36751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.1
 * JD-Core Version:    0.7.0.1
 */