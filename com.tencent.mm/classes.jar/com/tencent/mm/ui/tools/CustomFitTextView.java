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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomFitTextView
  extends TextView
{
  private String ArA;
  private Rect ArB;
  private LinkedList<String> ArC;
  public int ArD;
  private Drawable ArE;
  public boolean ArF;
  private int ArG;
  private Paint Arz;
  private boolean gNN;
  public int maxLines;
  
  public CustomFitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107617);
    this.ArB = new Rect();
    this.ArC = new LinkedList();
    this.gNN = true;
    this.ArG = 0;
    AppMethodBeat.o(107617);
  }
  
  public CustomFitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107618);
    this.ArB = new Rect();
    this.ArC = new LinkedList();
    this.gNN = true;
    this.ArG = 0;
    AppMethodBeat.o(107618);
  }
  
  private void appendText(String paramString)
  {
    AppMethodBeat.i(107622);
    if (this.ArC != null)
    {
      if ((paramString == null) || ("".equals(paramString)))
      {
        AppMethodBeat.o(107622);
        return;
      }
      this.ArC.add(paramString);
    }
    AppMethodBeat.o(107622);
  }
  
  private int dNL()
  {
    AppMethodBeat.i(107620);
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    float f1 = this.ArC.size();
    float f2 = localFontMetrics.bottom;
    float f3 = localFontMetrics.top;
    int i = (int)((localFontMetrics.leading + (f2 - f3)) * f1 + getPaddingTop() + getPaddingBottom());
    int j = Math.max(0, this.ArC.size() - 1);
    int k = this.ArG;
    AppMethodBeat.o(107620);
    return i + j * k;
  }
  
  private boolean eV(String paramString, int paramInt)
  {
    AppMethodBeat.i(107621);
    int k;
    int n;
    int i1;
    int i;
    if ((this.gNN) && (paramInt > 0) && (paramString != null) && (!"".equals(paramString)))
    {
      this.ArC.clear();
      k = 0;
      n = paramString.length();
      i1 = paramInt - getPaddingLeft() - getPaddingRight();
      if (this.ArF)
      {
        paramInt = this.ArE.getIntrinsicWidth();
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
          ab.w("MicroMsg.CustomFitTextView", "not match last line, but match text length end");
          AppMethodBeat.o(107621);
          return true;
          AppMethodBeat.o(107621);
          return false;
        }
        k = m;
      }
    }
  }
  
  private int f(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107623);
    if (paramInt2 <= paramInt1)
    {
      AppMethodBeat.o(107623);
      return paramInt1 + 1;
    }
    if (getPaint().measureText(paramString, paramInt1, paramInt2) + paramInt3 < paramInt4)
    {
      AppMethodBeat.o(107623);
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
    while ((paramInt1 >= 0) && (bo.C(paramString.charAt(paramInt1)))) {
      paramInt1 -= 1;
    }
    if ((paramInt1 < 0) || (paramInt1 == paramInt2))
    {
      AppMethodBeat.o(107623);
      return i - 1;
    }
    AppMethodBeat.o(107623);
    return paramInt1 + 1;
  }
  
  public final void a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107619);
    this.maxLines = paramInt1;
    this.ArA = paramString;
    if (this.ArA == null)
    {
      ab.w("MicroMsg.CustomFitTextView", "ori text is null");
      this.ArA = "";
    }
    if (this.maxLines <= 0)
    {
      ab.w("MicroMsg.CustomFitTextView", "maxLines is invalid");
      this.maxLines = 2;
    }
    this.ArG = getResources().getDimensionPixelSize(2131427496);
    this.ArF = paramBoolean;
    this.ArD = paramInt2;
    if (this.ArF) {
      this.ArE = getResources().getDrawable(this.ArD);
    }
    this.Arz = new Paint();
    this.Arz.set(getPaint());
    this.Arz.setAntiAlias(true);
    this.Arz.setColor(paramInt3);
    eV(this.ArA, getWidth());
    setHeight(Math.max(dNL(), a.fromDPToPix(getContext(), 32)));
    AppMethodBeat.o(107619);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107624);
    if (!this.gNN)
    {
      AppMethodBeat.o(107624);
      return;
    }
    if ((this.ArA == null) || ("".equals(this.ArA)) || (this.ArC.size() == 0))
    {
      AppMethodBeat.o(107624);
      return;
    }
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    float f2 = localFontMetrics.descent - localFontMetrics.ascent;
    float f3 = getPaddingLeft();
    float f1 = getPaddingTop();
    Iterator localIterator = this.ArC.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      f1 = localFontMetrics.leading + f2 + f1;
      paramCanvas.drawText(str, f3, f1, this.Arz);
    }
    if (this.ArF)
    {
      getPaint().getTextBounds((String)this.ArC.getLast(), 0, ((String)this.ArC.getLast()).length(), this.ArB);
      int i = getPaddingLeft() + this.ArB.right;
      int j = this.ArE.getIntrinsicWidth();
      int k = (int)(f1 - f2 - localFontMetrics.leading);
      int m = this.ArE.getIntrinsicHeight();
      this.ArE.setBounds(i, k, j + i, m + k);
      this.ArE.draw(paramCanvas);
    }
    AppMethodBeat.o(107624);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107626);
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = a.fromDPToPix(getContext(), 32);
    paramInt1 = paramInt2;
    if (eV(this.ArA, i)) {
      paramInt1 = Math.max(dNL(), paramInt2);
    }
    setMeasuredDimension(i, paramInt1);
    AppMethodBeat.o(107626);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107625);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {}
    for (boolean bool = true;; bool = false)
    {
      this.gNN = bool;
      if (this.gNN) {
        eV(this.ArA, paramInt1);
      }
      AppMethodBeat.o(107625);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CustomFitTextView
 * JD-Core Version:    0.7.0.1
 */