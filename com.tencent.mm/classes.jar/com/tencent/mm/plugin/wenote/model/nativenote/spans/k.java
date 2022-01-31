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
import com.tencent.mm.R.g;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public class k
  implements LeadingMarginSpan, f<Boolean>, g<Boolean>
{
  public boolean rKA = false;
  private WeakReference<Drawable> rKB;
  private int rKt;
  public boolean rKu;
  public boolean rKx = false;
  public boolean rKy = false;
  public boolean rKz = false;
  
  public k(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.rKt = paramInt;
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
    this.rKu = bool1;
    this.rKA = paramBoolean1;
    this.rKx = paramBoolean3;
    this.rKy = paramBoolean4;
    this.rKz = paramBoolean2;
  }
  
  private k cje()
  {
    return new k(this.rKA, this.rKt, this.rKz, this.rKx, this.rKy);
  }
  
  public final void a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent, k paramk)
  {
    if (paramMotionEvent.getX() > this.rKt)
    {
      y.e("MicroMsg.NoteTodoSpan", "x > mGapWidth");
      return;
    }
    int i = paramSpannable.getSpanStart(paramk);
    int j = paramSpannable.getSpanEnd(paramk);
    if (this.rKA)
    {
      paramMotionEvent = "true";
      label51:
      y.i("MicroMsg.NoteTodoSpan", "current mIsTodoCheck: %s", new Object[] { paramMotionEvent });
      paramSpannable.removeSpan(this);
      if (this.rKA) {
        break label158;
      }
    }
    label158:
    for (boolean bool = true;; bool = false)
    {
      this.rKA = bool;
      paramSpannable.setSpan(cje(), i, j, 33);
      paramTextView = (WXRTEditText)paramTextView;
      if (paramTextView.getEditTextType() != 0) {
        break;
      }
      paramTextView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(paramTextView.getRecyclerItemPosition());
      if ((paramTextView == null) || (paramTextView.getType() != 1)) {
        break;
      }
      ((i)paramTextView).content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramSpannable);
      return;
      paramMotionEvent = "false";
      break label51;
    }
  }
  
  public void drawLeadingMargin(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, Layout paramLayout)
  {
    paramCharSequence = (Spanned)paramCharSequence;
    if ((!this.rKu) && (paramCharSequence.getSpanStart(this) == paramInt6))
    {
      paramLayout = this.rKB;
      paramCharSequence = null;
      if (paramLayout != null) {
        paramCharSequence = (Drawable)paramLayout.get();
      }
      paramLayout = paramCharSequence;
      if (paramCharSequence == null) {
        if (!this.rKA) {
          break label101;
        }
      }
    }
    label101:
    for (paramCharSequence = android.support.v4.content.b.g(ae.getContext(), R.g.note_select_press);; paramCharSequence = android.support.v4.content.b.g(ae.getContext(), R.g.note_select_unpress))
    {
      this.rKB = new WeakReference(paramCharSequence);
      paramLayout = paramCharSequence;
      if (paramLayout != null) {
        break;
      }
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
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    if (this.rKu) {
      return 0;
    }
    return this.rKt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.k
 * JD-Core Version:    0.7.0.1
 */