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
  public boolean pxJ;
  public boolean pxK;
  private WeakReference<Drawable> pxL;
  private int pxh;
  public boolean pxi;
  public boolean pxo;
  public boolean pxp;
  
  public k(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(30641);
    this.pxo = false;
    this.pxp = false;
    this.pxJ = false;
    this.pxK = false;
    this.pxh = paramInt;
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
    this.pxi = bool1;
    this.pxK = paramBoolean1;
    this.pxo = paramBoolean3;
    this.pxp = paramBoolean4;
    this.pxJ = paramBoolean2;
    AppMethodBeat.o(30641);
  }
  
  private k eXk()
  {
    AppMethodBeat.i(30643);
    k localk = new k(this.pxK, this.pxh, this.pxJ, this.pxo, this.pxp);
    AppMethodBeat.o(30643);
    return localk;
  }
  
  public final void a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent, k paramk)
  {
    AppMethodBeat.i(30644);
    if (paramMotionEvent.getX() > this.pxh)
    {
      ad.e("MicroMsg.NoteTodoSpan", "x > mGapWidth");
      AppMethodBeat.o(30644);
      return;
    }
    int i = paramSpannable.getSpanStart(paramk);
    int j = paramSpannable.getSpanEnd(paramk);
    if (this.pxK)
    {
      paramMotionEvent = "true";
      ad.i("MicroMsg.NoteTodoSpan", "current mIsTodoCheck: %s", new Object[] { paramMotionEvent });
      paramSpannable.removeSpan(this);
      if (this.pxK) {
        break label176;
      }
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      this.pxK = bool;
      paramSpannable.setSpan(eXk(), i, j, 33);
      paramTextView = (WXRTEditText)paramTextView;
      if (paramTextView.getEditTextType() == 0)
      {
        paramTextView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(paramTextView.getRecyclerItemPosition());
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
    if ((!this.pxi) && (paramCharSequence.getSpanStart(this) == paramInt6))
    {
      paramLayout = this.pxL;
      paramCharSequence = null;
      if (paramLayout != null) {
        paramCharSequence = (Drawable)paramLayout.get();
      }
      paramLayout = paramCharSequence;
      if (paramCharSequence == null) {
        if (!this.pxK) {
          break label112;
        }
      }
      label112:
      for (paramCharSequence = android.support.v4.content.b.l(aj.getContext(), 2131233488);; paramCharSequence = android.support.v4.content.b.l(aj.getContext(), 2131233489))
      {
        this.pxL = new WeakReference(paramCharSequence);
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
    if (this.pxi) {
      return 0;
    }
    return this.pxh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.k
 * JD-Core Version:    0.7.0.1
 */