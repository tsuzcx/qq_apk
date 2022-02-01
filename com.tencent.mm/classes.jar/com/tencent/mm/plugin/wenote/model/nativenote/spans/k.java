package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.WeakReference;

public class k
  implements LeadingMarginSpan, f<Boolean>, g<Boolean>
{
  private int opX;
  public boolean opY;
  public boolean oqA;
  private WeakReference<Drawable> oqB;
  public boolean oqe;
  public boolean oqf;
  public boolean oqz;
  
  public k(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(30641);
    this.oqe = false;
    this.oqf = false;
    this.oqz = false;
    this.oqA = false;
    this.opX = paramInt;
    boolean bool1 = bool2;
    if (paramBoolean2)
    {
      bool1 = bool2;
      if (paramBoolean4)
      {
        bool1 = bool2;
        if (!paramBoolean3) {
          bool1 = true;
        }
      }
    }
    this.opY = bool1;
    this.oqA = paramBoolean1;
    this.oqe = paramBoolean3;
    this.oqf = paramBoolean4;
    this.oqz = paramBoolean2;
    AppMethodBeat.o(30641);
  }
  
  private k esY()
  {
    AppMethodBeat.i(30643);
    k localk = new k(this.oqA, this.opX, this.oqz, this.oqe, this.oqf);
    AppMethodBeat.o(30643);
    return localk;
  }
  
  public final void a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent, k paramk)
  {
    AppMethodBeat.i(30644);
    if (paramMotionEvent.getX() > this.opX)
    {
      ad.e("MicroMsg.NoteTodoSpan", "x > mGapWidth");
      AppMethodBeat.o(30644);
      return;
    }
    int i = paramSpannable.getSpanStart(paramk);
    int j = paramSpannable.getSpanEnd(paramk);
    if (this.oqA)
    {
      paramMotionEvent = "true";
      ad.i("MicroMsg.NoteTodoSpan", "current mIsTodoCheck: %s", new Object[] { paramMotionEvent });
      paramSpannable.removeSpan(this);
      if (this.oqA) {
        break label176;
      }
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      this.oqA = bool;
      paramSpannable.setSpan(esY(), i, j, 33);
      paramTextView = (WXRTEditText)paramTextView;
      if (paramTextView.getEditTextType() == 0)
      {
        paramTextView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(paramTextView.getRecyclerItemPosition());
        if ((paramTextView != null) && (paramTextView.getType() == 1)) {
          ((i)paramTextView).content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramSpannable);
        }
      }
      AppMethodBeat.o(30644);
      return;
      paramMotionEvent = "false";
      break;
    }
  }
  
  public void drawLeadingMargin(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, Layout paramLayout)
  {
    AppMethodBeat.i(30642);
    paramCharSequence = (Spanned)paramCharSequence;
    if ((!this.opY) && (paramCharSequence.getSpanStart(this) == paramInt6))
    {
      paramLayout = this.oqB;
      paramCharSequence = null;
      if (paramLayout != null) {
        paramCharSequence = (Drawable)paramLayout.get();
      }
      paramLayout = paramCharSequence;
      if (paramCharSequence == null) {
        if (!this.oqA) {
          break label112;
        }
      }
      label112:
      for (paramCharSequence = android.support.v4.content.b.l(aj.getContext(), 2131233488);; paramCharSequence = android.support.v4.content.b.l(aj.getContext(), 2131233489))
      {
        this.oqB = new WeakReference(paramCharSequence);
        paramLayout = paramCharSequence;
        if (paramLayout != null) {
          break;
        }
        AppMethodBeat.o(30642);
        return;
      }
      paramLayout.setBounds(0, 0, paramLayout.getIntrinsicWidth(), paramLayout.getIntrinsicHeight());
      paramCanvas.save();
      paramPaint = paramPaint.getFontMetricsInt();
      paramInt1 = paramPaint.descent;
      paramCanvas.translate(0.0F, (paramPaint.ascent + (paramInt1 + paramInt4 + paramInt4)) / 2 - paramLayout.getBounds().bottom / 2);
      paramLayout.draw(paramCanvas);
      paramCanvas.restore();
    }
    AppMethodBeat.o(30642);
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    if (this.opY) {
      return 0;
    }
    return this.opX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.k
 * JD-Core Version:    0.7.0.1
 */