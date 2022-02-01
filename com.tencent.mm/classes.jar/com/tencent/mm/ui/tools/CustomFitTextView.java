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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomFitTextView
  extends TextView
{
  private String Qqp;
  private Rect Qqq;
  private LinkedList<String> Qqr;
  public int Qqs;
  private Drawable Qqt;
  public boolean Qqu;
  private int Qqv;
  private Paint cgU;
  private boolean kyn;
  public int maxLines;
  
  public CustomFitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143056);
    this.Qqq = new Rect();
    this.Qqr = new LinkedList();
    this.kyn = true;
    this.Qqv = 0;
    AppMethodBeat.o(143056);
  }
  
  public CustomFitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143057);
    this.Qqq = new Rect();
    this.Qqr = new LinkedList();
    this.kyn = true;
    this.Qqv = 0;
    AppMethodBeat.o(143057);
  }
  
  private void appendText(String paramString)
  {
    AppMethodBeat.i(143061);
    if (this.Qqr != null)
    {
      if ((paramString == null) || ("".equals(paramString)))
      {
        AppMethodBeat.o(143061);
        return;
      }
      this.Qqr.add(paramString);
    }
    AppMethodBeat.o(143061);
  }
  
  private int f(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143062);
    if (paramInt2 <= paramInt1)
    {
      AppMethodBeat.o(143062);
      return paramInt1 + 1;
    }
    if (getPaint().measureText(paramString, paramInt1, paramInt2) + paramInt3 < paramInt4)
    {
      AppMethodBeat.o(143062);
      return paramInt2;
    }
    int j = paramString.length();
    int i;
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
    while ((paramInt1 >= 0) && (Util.isAlpha(paramString.charAt(paramInt1)))) {
      paramInt1 -= 1;
    }
    if ((paramInt1 < 0) || (paramInt1 == paramInt2))
    {
      AppMethodBeat.o(143062);
      return i - 1;
    }
    AppMethodBeat.o(143062);
    return paramInt1 + 1;
  }
  
  private int gXE()
  {
    AppMethodBeat.i(143059);
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    float f1 = this.Qqr.size();
    float f2 = localFontMetrics.bottom;
    float f3 = localFontMetrics.top;
    int i = (int)((localFontMetrics.leading + (f2 - f3)) * f1 + getPaddingTop() + getPaddingBottom());
    int j = Math.max(0, this.Qqr.size() - 1);
    int k = this.Qqv;
    AppMethodBeat.o(143059);
    return i + j * k;
  }
  
  private boolean hk(String paramString, int paramInt)
  {
    AppMethodBeat.i(143060);
    int k;
    int n;
    int i1;
    int i;
    if ((this.kyn) && (paramInt > 0) && (paramString != null) && (!"".equals(paramString)))
    {
      this.Qqr.clear();
      k = 0;
      n = paramString.length();
      i1 = paramInt - getPaddingLeft() - getPaddingRight();
      if (this.Qqu)
      {
        paramInt = this.Qqt.getIntrinsicWidth();
        float f = getPaint().measureText(paramString, 0, n);
        f = paramInt + f;
        i = this.maxLines;
        if (Float.compare(f, this.maxLines * i1) >= 0) {
          break label245;
        }
        i = (int)Math.ceil(f / i1);
      }
    }
    label245:
    for (;;)
    {
      int j = 0;
      label126:
      if (j < i) {
        if (j == i - 1) {
          appendText(paramString.substring(k, f(paramString, k, n, paramInt, i1)).trim());
        }
      }
      for (;;)
      {
        j += 1;
        break label126;
        paramInt = 0;
        break;
        int m = f(paramString, k, n, 0, i1);
        appendText(paramString.substring(k, m).trim());
        if (m >= n)
        {
          Log.w("MicroMsg.CustomFitTextView", "not match last line, but match text length end");
          AppMethodBeat.o(143060);
          return true;
          AppMethodBeat.o(143060);
          return false;
        }
        k = m;
      }
    }
  }
  
  public final void a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143058);
    this.maxLines = paramInt1;
    this.Qqp = paramString;
    if (this.Qqp == null)
    {
      Log.w("MicroMsg.CustomFitTextView", "ori text is null");
      this.Qqp = "";
    }
    if (this.maxLines <= 0)
    {
      Log.w("MicroMsg.CustomFitTextView", "maxLines is invalid");
      this.maxLines = 2;
    }
    this.Qqv = getResources().getDimensionPixelSize(2131165190);
    this.Qqu = paramBoolean;
    this.Qqs = paramInt2;
    if (this.Qqu) {
      this.Qqt = getResources().getDrawable(this.Qqs);
    }
    this.cgU = new Paint();
    this.cgU.set(getPaint());
    this.cgU.setAntiAlias(true);
    this.cgU.setColor(paramInt3);
    hk(this.Qqp, getWidth());
    setHeight(Math.max(gXE(), a.fromDPToPix(getContext(), 32)));
    AppMethodBeat.o(143058);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143063);
    if (!this.kyn)
    {
      AppMethodBeat.o(143063);
      return;
    }
    if ((this.Qqp == null) || ("".equals(this.Qqp)) || (this.Qqr.size() == 0))
    {
      AppMethodBeat.o(143063);
      return;
    }
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    float f2 = localFontMetrics.descent - localFontMetrics.ascent;
    float f3 = getPaddingLeft();
    float f1 = getPaddingTop();
    Iterator localIterator = this.Qqr.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      f1 = localFontMetrics.leading + f2 + f1;
      paramCanvas.drawText(str, f3, f1, this.cgU);
    }
    if (this.Qqu)
    {
      getPaint().getTextBounds((String)this.Qqr.getLast(), 0, ((String)this.Qqr.getLast()).length(), this.Qqq);
      int i = getPaddingLeft() + this.Qqq.right;
      int j = this.Qqt.getIntrinsicWidth();
      int k = (int)(f1 - f2 - localFontMetrics.leading);
      int m = this.Qqt.getIntrinsicHeight();
      this.Qqt.setBounds(i, k, j + i, m + k);
      this.Qqt.draw(paramCanvas);
    }
    AppMethodBeat.o(143063);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143065);
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = a.fromDPToPix(getContext(), 32);
    paramInt1 = paramInt2;
    if (hk(this.Qqp, i)) {
      paramInt1 = Math.max(gXE(), paramInt2);
    }
    setMeasuredDimension(i, paramInt1);
    AppMethodBeat.o(143065);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143064);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {}
    for (boolean bool = true;; bool = false)
    {
      this.kyn = bool;
      if (this.kyn) {
        hk(this.Qqp, paramInt1);
      }
      AppMethodBeat.o(143064);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CustomFitTextView
 * JD-Core Version:    0.7.0.1
 */