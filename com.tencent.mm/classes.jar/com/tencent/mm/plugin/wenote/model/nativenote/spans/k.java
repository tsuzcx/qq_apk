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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;

public class k
  implements LeadingMarginSpan, f<Boolean>, g<Boolean>
{
  private int vAX;
  public boolean vAY;
  public boolean vBb;
  public boolean vBc;
  public boolean vBd;
  public boolean vBe;
  private WeakReference<Drawable> vBf;
  
  public k(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(26947);
    this.vBb = false;
    this.vBc = false;
    this.vBd = false;
    this.vBe = false;
    this.vAX = paramInt;
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
    this.vAY = bool1;
    this.vBe = paramBoolean1;
    this.vBb = paramBoolean3;
    this.vBc = paramBoolean4;
    this.vBd = paramBoolean2;
    AppMethodBeat.o(26947);
  }
  
  private k djF()
  {
    AppMethodBeat.i(26949);
    k localk = new k(this.vBe, this.vAX, this.vBd, this.vBb, this.vBc);
    AppMethodBeat.o(26949);
    return localk;
  }
  
  public final void a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent, k paramk)
  {
    AppMethodBeat.i(26950);
    if (paramMotionEvent.getX() > this.vAX)
    {
      ab.e("MicroMsg.NoteTodoSpan", "x > mGapWidth");
      AppMethodBeat.o(26950);
      return;
    }
    int i = paramSpannable.getSpanStart(paramk);
    int j = paramSpannable.getSpanEnd(paramk);
    if (this.vBe)
    {
      paramMotionEvent = "true";
      ab.i("MicroMsg.NoteTodoSpan", "current mIsTodoCheck: %s", new Object[] { paramMotionEvent });
      paramSpannable.removeSpan(this);
      if (this.vBe) {
        break label176;
      }
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      this.vBe = bool;
      paramSpannable.setSpan(djF(), i, j, 33);
      paramTextView = (WXRTEditText)paramTextView;
      if (paramTextView.getEditTextType() == 0)
      {
        paramTextView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(paramTextView.getRecyclerItemPosition());
        if ((paramTextView != null) && (paramTextView.getType() == 1)) {
          ((i)paramTextView).content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramSpannable);
        }
      }
      AppMethodBeat.o(26950);
      return;
      paramMotionEvent = "false";
      break;
    }
  }
  
  public void drawLeadingMargin(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, Layout paramLayout)
  {
    AppMethodBeat.i(26948);
    paramCharSequence = (Spanned)paramCharSequence;
    if ((!this.vAY) && (paramCharSequence.getSpanStart(this) == paramInt6))
    {
      paramLayout = this.vBf;
      paramCharSequence = null;
      if (paramLayout != null) {
        paramCharSequence = (Drawable)paramLayout.get();
      }
      paramLayout = paramCharSequence;
      if (paramCharSequence == null) {
        if (!this.vBe) {
          break label112;
        }
      }
      label112:
      for (paramCharSequence = android.support.v4.content.b.k(ah.getContext(), 2130839833);; paramCharSequence = android.support.v4.content.b.k(ah.getContext(), 2130839834))
      {
        this.vBf = new WeakReference(paramCharSequence);
        paramLayout = paramCharSequence;
        if (paramLayout != null) {
          break;
        }
        AppMethodBeat.o(26948);
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
    AppMethodBeat.o(26948);
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    if (this.vAY) {
      return 0;
    }
    return this.vAX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.k
 * JD-Core Version:    0.7.0.1
 */