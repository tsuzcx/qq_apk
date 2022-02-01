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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomFitTextView
  extends TextView
{
  private String INO;
  private Rect INP;
  private LinkedList<String> INQ;
  public int INR;
  private Drawable INS;
  public boolean INU;
  private int INV;
  private Paint bLZ;
  private boolean jbA;
  public int maxLines;
  
  public CustomFitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143056);
    this.INP = new Rect();
    this.INQ = new LinkedList();
    this.jbA = true;
    this.INV = 0;
    AppMethodBeat.o(143056);
  }
  
  public CustomFitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143057);
    this.INP = new Rect();
    this.INQ = new LinkedList();
    this.jbA = true;
    this.INV = 0;
    AppMethodBeat.o(143057);
  }
  
  private void appendText(String paramString)
  {
    AppMethodBeat.i(143061);
    if (this.INQ != null)
    {
      if ((paramString == null) || ("".equals(paramString)))
      {
        AppMethodBeat.o(143061);
        return;
      }
      this.INQ.add(paramString);
    }
    AppMethodBeat.o(143061);
  }
  
  private int e(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
    while ((paramInt1 >= 0) && (bs.D(paramString.charAt(paramInt1)))) {
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
  
  private int ftH()
  {
    AppMethodBeat.i(143059);
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    float f1 = this.INQ.size();
    float f2 = localFontMetrics.bottom;
    float f3 = localFontMetrics.top;
    int i = (int)((localFontMetrics.leading + (f2 - f3)) * f1 + getPaddingTop() + getPaddingBottom());
    int j = Math.max(0, this.INQ.size() - 1);
    int k = this.INV;
    AppMethodBeat.o(143059);
    return i + j * k;
  }
  
  private boolean gl(String paramString, int paramInt)
  {
    AppMethodBeat.i(143060);
    int k;
    int n;
    int i1;
    int i;
    if ((this.jbA) && (paramInt > 0) && (paramString != null) && (!"".equals(paramString)))
    {
      this.INQ.clear();
      k = 0;
      n = paramString.length();
      i1 = paramInt - getPaddingLeft() - getPaddingRight();
      if (this.INU)
      {
        paramInt = this.INS.getIntrinsicWidth();
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
          appendText(paramString.substring(k, e(paramString, k, n, paramInt, i1)).trim());
        }
      }
      for (;;)
      {
        j += 1;
        break label126;
        paramInt = 0;
        break;
        int m = e(paramString, k, n, 0, i1);
        appendText(paramString.substring(k, m).trim());
        if (m >= n)
        {
          ac.w("MicroMsg.CustomFitTextView", "not match last line, but match text length end");
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
    this.INO = paramString;
    if (this.INO == null)
    {
      ac.w("MicroMsg.CustomFitTextView", "ori text is null");
      this.INO = "";
    }
    if (this.maxLines <= 0)
    {
      ac.w("MicroMsg.CustomFitTextView", "maxLines is invalid");
      this.maxLines = 2;
    }
    this.INV = getResources().getDimensionPixelSize(2131165187);
    this.INU = paramBoolean;
    this.INR = paramInt2;
    if (this.INU) {
      this.INS = getResources().getDrawable(this.INR);
    }
    this.bLZ = new Paint();
    this.bLZ.set(getPaint());
    this.bLZ.setAntiAlias(true);
    this.bLZ.setColor(paramInt3);
    gl(this.INO, getWidth());
    setHeight(Math.max(ftH(), a.fromDPToPix(getContext(), 32)));
    AppMethodBeat.o(143058);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143063);
    if (!this.jbA)
    {
      AppMethodBeat.o(143063);
      return;
    }
    if ((this.INO == null) || ("".equals(this.INO)) || (this.INQ.size() == 0))
    {
      AppMethodBeat.o(143063);
      return;
    }
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    float f2 = localFontMetrics.descent - localFontMetrics.ascent;
    float f3 = getPaddingLeft();
    float f1 = getPaddingTop();
    Iterator localIterator = this.INQ.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      f1 = localFontMetrics.leading + f2 + f1;
      paramCanvas.drawText(str, f3, f1, this.bLZ);
    }
    if (this.INU)
    {
      getPaint().getTextBounds((String)this.INQ.getLast(), 0, ((String)this.INQ.getLast()).length(), this.INP);
      int i = getPaddingLeft() + this.INP.right;
      int j = this.INS.getIntrinsicWidth();
      int k = (int)(f1 - f2 - localFontMetrics.leading);
      int m = this.INS.getIntrinsicHeight();
      this.INS.setBounds(i, k, j + i, m + k);
      this.INS.draw(paramCanvas);
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
    if (gl(this.INO, i)) {
      paramInt1 = Math.max(ftH(), paramInt2);
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
      this.jbA = bool;
      if (this.jbA) {
        gl(this.INO, paramInt1);
      }
      AppMethodBeat.o(143064);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CustomFitTextView
 * JD-Core Version:    0.7.0.1
 */