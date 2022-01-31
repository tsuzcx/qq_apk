package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomFitTextView
  extends TextView
{
  private boolean fwM = true;
  public int maxLines;
  private Paint vZm;
  private String vZn;
  private Rect vZo = new Rect();
  private LinkedList<String> vZp = new LinkedList();
  public int vZq;
  private Drawable vZr;
  public boolean vZs;
  private int vZt = 0;
  
  public CustomFitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CustomFitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aej(String paramString)
  {
    if ((this.vZp == null) || (paramString == null) || ("".equals(paramString))) {
      return;
    }
    this.vZp.add(paramString);
  }
  
  private int cIX()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    float f1 = this.vZp.size();
    float f2 = localFontMetrics.bottom;
    float f3 = localFontMetrics.top;
    return (int)((localFontMetrics.leading + (f2 - f3)) * f1 + getPaddingTop() + getPaddingBottom()) + Math.max(0, this.vZp.size() - 1) * this.vZt;
  }
  
  private int d(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if (paramInt2 <= paramInt1) {
      i = paramInt1 + 1;
    }
    do
    {
      return i;
      i = paramInt2;
    } while (getPaint().measureText(paramString, paramInt1, paramInt2) + paramInt3 < paramInt4);
    int j = paramString.length();
    for (;;)
    {
      i = paramInt2;
      if (getPaint().measureText(paramString, paramInt1, paramInt2) + paramInt3 <= paramInt4) {
        break;
      }
      paramInt2 = paramInt2 + paramInt1 >> 1;
    }
    while ((i <= j) && (getPaint().measureText(paramString, paramInt1, i) + paramInt3 < paramInt4)) {
      i += 1;
    }
    paramInt2 = Math.min(j, i) - 1;
    paramInt1 = paramInt2;
    while ((paramInt1 >= 0) && (bk.m(paramString.charAt(paramInt1)))) {
      paramInt1 -= 1;
    }
    if ((paramInt1 < 0) || (paramInt1 == paramInt2)) {
      return i - 1;
    }
    return paramInt1 + 1;
  }
  
  private boolean dL(String paramString, int paramInt)
  {
    int k;
    int n;
    int i1;
    int i;
    if ((this.fwM) && (paramInt > 0) && (paramString != null) && (!"".equals(paramString)))
    {
      this.vZp.clear();
      k = 0;
      n = paramString.length();
      i1 = paramInt - getPaddingLeft() - getPaddingRight();
      if (this.vZs)
      {
        paramInt = this.vZr.getIntrinsicWidth();
        float f = getPaint().measureText(paramString, 0, n);
        f = paramInt + f;
        i = this.maxLines;
        if (Float.compare(f, this.maxLines * i1) >= 0) {
          break label230;
        }
        i = (int)Math.ceil(f / i1);
      }
    }
    label230:
    for (;;)
    {
      int j = 0;
      label121:
      if (j < i) {
        if (j == i - 1) {
          aej(paramString.substring(k, d(paramString, k, n, paramInt, i1)).trim());
        }
      }
      for (;;)
      {
        j += 1;
        break label121;
        paramInt = 0;
        break;
        int m = d(paramString, k, n, 0, i1);
        aej(paramString.substring(k, m).trim());
        if (m >= n)
        {
          y.w("MicroMsg.CustomFitTextView", "not match last line, but match text length end");
          return true;
          return false;
        }
        k = m;
      }
    }
  }
  
  public final void a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    this.maxLines = paramInt1;
    this.vZn = paramString;
    if (this.vZn == null)
    {
      y.w("MicroMsg.CustomFitTextView", "ori text is null");
      this.vZn = "";
    }
    if (this.maxLines <= 0)
    {
      y.w("MicroMsg.CustomFitTextView", "maxLines is invalid");
      this.maxLines = 2;
    }
    this.vZt = getResources().getDimensionPixelSize(a.e.BasicPaddingSize);
    this.vZs = paramBoolean;
    this.vZq = paramInt2;
    if (this.vZs) {
      this.vZr = getResources().getDrawable(this.vZq);
    }
    this.vZm = new Paint();
    this.vZm.set(getPaint());
    this.vZm.setAntiAlias(true);
    this.vZm.setColor(paramInt3);
    dL(this.vZn, getWidth());
    setHeight(Math.max(cIX(), a.fromDPToPix(getContext(), 32)));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.fwM) {}
    Paint.FontMetrics localFontMetrics;
    float f2;
    float f1;
    do
    {
      do
      {
        return;
      } while ((this.vZn == null) || ("".equals(this.vZn)) || (this.vZp.size() == 0));
      localFontMetrics = getPaint().getFontMetrics();
      f2 = localFontMetrics.descent - localFontMetrics.ascent;
      float f3 = getPaddingLeft();
      f1 = getPaddingTop();
      Iterator localIterator = this.vZp.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        f1 = localFontMetrics.leading + f2 + f1;
        paramCanvas.drawText(str, f3, f1, this.vZm);
      }
    } while (!this.vZs);
    getPaint().getTextBounds((String)this.vZp.getLast(), 0, ((String)this.vZp.getLast()).length(), this.vZo);
    int i = getPaddingLeft() + this.vZo.right;
    int j = this.vZr.getIntrinsicWidth();
    int k = (int)(f1 - f2 - localFontMetrics.leading);
    int m = this.vZr.getIntrinsicHeight();
    this.vZr.setBounds(i, k, j + i, m + k);
    this.vZr.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = a.fromDPToPix(getContext(), 32);
    paramInt1 = paramInt2;
    if (dL(this.vZn, i)) {
      paramInt1 = Math.max(cIX(), paramInt2);
    }
    setMeasuredDimension(i, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {}
    for (boolean bool = true;; bool = false)
    {
      this.fwM = bool;
      if (this.fwM) {
        dL(this.vZn, paramInt1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CustomFitTextView
 * JD-Core Version:    0.7.0.1
 */