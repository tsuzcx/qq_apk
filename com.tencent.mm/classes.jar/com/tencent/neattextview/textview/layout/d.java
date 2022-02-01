package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements b
{
  private static final TextPaint ahbA;
  private static Comparator<Integer> ahbB;
  public static boolean eYL;
  private int LQR;
  private float[] ahaY;
  private c ahbC;
  private char[] ahbD;
  private int ahbE;
  private float ahbF;
  private boolean ahbG;
  private float ahbH;
  private float ahbI;
  private float ahbJ;
  private RectF ahbK;
  private RectF ahbL;
  private LinkedList<Integer> ahbM;
  private float ahbN;
  private float mHeight;
  private float mWidth;
  public int uG;
  public int uH;
  
  static
  {
    AppMethodBeat.i(39757);
    ahbA = new TextPaint(1);
    ahbB = new d.1();
    eYL = false;
    AppMethodBeat.o(39757);
  }
  
  public d(c paramc, char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2, float paramFloat3, float paramFloat4, TextPaint paramTextPaint, boolean paramBoolean, float paramFloat5, int paramInt3, int paramInt4, float paramFloat6)
  {
    AppMethodBeat.i(39746);
    this.ahbH = -1.0F;
    this.ahbI = 0.0F;
    this.ahbJ = 0.0F;
    this.ahbK = new RectF();
    this.ahbL = new RectF();
    this.ahbM = null;
    this.ahbC = paramc;
    this.ahbD = paramArrayOfChar;
    this.uG = paramInt1;
    this.uH = paramInt2;
    this.ahbE = paramInt3;
    this.ahaY = paramArrayOfFloat;
    this.ahbF = paramFloat4;
    this.ahbI = paramFloat5;
    this.ahbG = paramBoolean;
    this.mHeight = paramFloat3;
    this.mWidth = paramFloat2;
    this.ahbJ = paramFloat6;
    this.LQR = paramInt4;
    paramc = paramTextPaint.getFontMetrics();
    paramFloat3 = paramc.leading - paramc.top;
    paramFloat4 = paramc.bottom;
    paramFloat5 = paramc.leading;
    this.ahbN = ((this.mHeight - paramc.bottom + paramc.top) / 2.0F + paramFloat1 - paramc.top);
    this.ahbK.set(0.0F, this.ahbN - paramFloat3, 0.0F + paramFloat2, paramFloat4 - paramFloat5 + this.ahbN);
    this.ahbL.set(0.0F, this.ahbN - paramFloat3, 0.0F + paramFloat6, this.ahbK.top + this.mHeight);
    AppMethodBeat.o(39746);
  }
  
  public final void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat)
  {
    AppMethodBeat.i(39747);
    float f2 = jQO();
    Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
    float f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
    int j = this.uG;
    int k = this.uH;
    Object localObject1 = this.ahbC.ahbt.ahbS;
    Object localObject2 = this.ahbC.ahbt.ahbT;
    LineBackgroundSpan[] arrayOfLineBackgroundSpan = (LineBackgroundSpan[])this.ahbC.ahbt.ahbR;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.ahbC.ahbt.ahbQ)
    {
      if ((localObject1[i] < k) && (localObject2[i] > j)) {
        localLinkedList.add(arrayOfLineBackgroundSpan[i]);
      }
      i += 1;
    }
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((LineBackgroundSpan)((Iterator)localObject1).next()).drawBackground(paramCanvas, paramTextPaint, (int)this.ahbK.left, (int)this.ahbK.right, (int)this.ahbK.top, (int)f1, (int)this.ahbK.bottom, this.ahbC.getText(), this.uG, this.uH, this.ahbE);
    }
    if (eYL) {}
    for (localObject1 = new StringBuilder("canvas w=").append(paramCanvas.getWidth()).append(" canvas h=").append(paramCanvas.getHeight()).append('\n');; localObject1 = null)
    {
      int m = this.uG;
      i = 0;
      k = this.uG;
      f2 = 0.0F + f2;
      int n;
      if (k < this.uH)
      {
        j = i;
        float f4;
        float f3;
        if (k + 1 < this.uH)
        {
          j = i;
          f4 = f1;
          n = m;
          f3 = f2;
          if (this.ahaY[(k + 1)] == 0.0F) {
            break label559;
          }
          j = i;
          if (i == 0) {
            if ((!this.ahbG) || (this.ahaY[(k + 1)] != this.ahbI)) {
              break label584;
            }
          }
        }
        label559:
        label584:
        for (i = 1;; i = 0)
        {
          j = i;
          f4 = f1;
          n = m;
          f3 = f2;
          if (i == 0)
          {
            j = i;
            n = k + 1;
            localObject2 = (ImageSpan)this.ahbC.ahbm.pD(m, n);
            if (localObject2 == null) {
              break label590;
            }
            ahbA.set(paramTextPaint);
            ((ImageSpan)localObject2).draw(paramCanvas, "", m, n, f2, 0, (int)f1, (int)(this.mHeight + paramFloat), ahbA);
            f3 = f2;
            if (j != 0) {
              f3 = f2 + this.ahbI;
            }
            j = 0;
            f3 += this.ahaY[m] + this.ahbF;
            if (eYL) {
              ((StringBuilder)localObject1).append(f3).append(',');
            }
            f4 = f1;
          }
          k += 1;
          i = j;
          f1 = f4;
          m = n;
          f2 = f3;
          break;
        }
        label590:
        i = 0;
        ahbA.set(paramTextPaint);
        localObject2 = (AbsoluteSizeSpan)this.ahbC.ahbo.pD(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((AbsoluteSizeSpan)localObject2).updateDrawState(ahbA);
        }
        localObject2 = (RelativeSizeSpan)this.ahbC.ahbp.pD(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((RelativeSizeSpan)localObject2).updateDrawState(ahbA);
        }
        localObject2 = (ForegroundColorSpan)this.ahbC.ahbr.pD(m, n);
        if (localObject2 != null) {
          ((ForegroundColorSpan)localObject2).updateDrawState(ahbA);
        }
        localObject2 = (ClickableSpan)this.ahbC.ahbs.pD(m, n);
        if (localObject2 != null) {
          ((ClickableSpan)localObject2).updateDrawState(ahbA);
        }
        if (i == 0) {
          break label804;
        }
        f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
      }
      label804:
      for (;;)
      {
        i = (int)f2;
        paramCanvas.drawText(this.ahbD, m, n - m, i, f1, ahbA);
        break;
        AppMethodBeat.o(39747);
        return;
      }
    }
  }
  
  public final int aGO(int paramInt)
  {
    AppMethodBeat.i(39751);
    int k = this.uG;
    float f1 = this.ahbK.left + jQO();
    int n = this.uG;
    int m = this.uG;
    int i = 0;
    if (m < this.uH)
    {
      int j = i;
      if (m + 1 < this.uH)
      {
        j = i;
        if (this.ahaY[(m + 1)] != 0.0F)
        {
          j = i;
          if (i != 0) {
            break label156;
          }
          if ((this.ahbG) && (this.ahaY[(m + 1)] == this.ahbI))
          {
            i = 1;
            label118:
            j = i;
            if (i == 0) {
              break label156;
            }
            j = i;
          }
        }
        else
        {
          k += 1;
          i = j;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        i = 0;
        break label118;
        label156:
        float f2 = f1;
        if (j != 0) {
          f2 = f1 + this.ahbI;
        }
        f1 = f2 + (this.ahaY[n] + this.ahbF);
        if ((f2 <= paramInt) && (paramInt < f1))
        {
          AppMethodBeat.o(39751);
          return k;
        }
        if (f2 > paramInt)
        {
          paramInt = this.uG;
          AppMethodBeat.o(39751);
          return paramInt;
        }
        if (paramInt > this.ahbK.right)
        {
          if (this.uH == this.ahbD.length)
          {
            paramInt = this.uH;
            AppMethodBeat.o(39751);
            return paramInt;
          }
          paramInt = this.uH;
          AppMethodBeat.o(39751);
          return paramInt - 1;
        }
        k += 1;
        i = 0;
        n = m + 1;
      }
    }
    paramInt = this.uH;
    AppMethodBeat.o(39751);
    return paramInt;
  }
  
  public final float dv(int paramInt)
  {
    AppMethodBeat.i(39750);
    float f1 = this.ahbK.left + jQO();
    int m = this.uG;
    int k = this.uG;
    int i = 0;
    if ((k < this.uH) && (k < paramInt))
    {
      int j = i;
      int n;
      float f2;
      if (k + 1 < this.uH)
      {
        j = i;
        n = m;
        f2 = f1;
        if (this.ahaY[(k + 1)] == 0.0F) {
          break label181;
        }
        j = i;
        if (i == 0) {
          if ((!this.ahbG) || (this.ahaY[(k + 1)] != this.ahbI)) {
            break label200;
          }
        }
      }
      label181:
      label200:
      for (i = 1;; i = 0)
      {
        j = i;
        n = m;
        f2 = f1;
        if (i == 0)
        {
          j = i;
          f2 = f1;
          if (j != 0) {
            f2 = f1 + this.ahbI;
          }
          f2 += this.ahaY[m] + this.ahbF;
          j = 0;
          n = k + 1;
        }
        k += 1;
        i = j;
        m = n;
        f1 = f2;
        break;
      }
    }
    AppMethodBeat.o(39750);
    return f1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(39752);
    if (paramObject == null)
    {
      AppMethodBeat.o(39752);
      return false;
    }
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if ((paramObject.getStart() != this.uG) || (paramObject.getEnd() != this.uH) || (!paramObject.jQK().equals(this.ahbK)) || (paramObject.jQN() != this.ahbG) || (paramObject.jQM() != this.ahbF) || (paramObject.jQO() != this.ahbH))
      {
        AppMethodBeat.o(39752);
        return false;
      }
      int i = this.uG;
      while (i < this.uH)
      {
        if (this.ahaY[i] != paramObject.jQJ()[i])
        {
          AppMethodBeat.o(39752);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(39752);
      return true;
    }
    AppMethodBeat.o(39752);
    return false;
  }
  
  public final int getEnd()
  {
    return this.uH;
  }
  
  public final float getHeight()
  {
    return this.mHeight;
  }
  
  public final int getStart()
  {
    return this.uG;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(39753);
    int i = this.uG;
    int j = this.uH;
    int k = (int)this.mHeight;
    int m = (int)this.mWidth;
    int n = (int)this.ahbH;
    int i1 = this.ahbK.hashCode();
    AppMethodBeat.o(39753);
    return i + j + k + m + n + i1;
  }
  
  public final float[] jQJ()
  {
    return this.ahaY;
  }
  
  public final RectF jQK()
  {
    return this.ahbK;
  }
  
  public final RectF jQL()
  {
    return this.ahbL;
  }
  
  public final float jQM()
  {
    return this.ahbF;
  }
  
  public final boolean jQN()
  {
    return this.ahbG;
  }
  
  public final float jQO()
  {
    AppMethodBeat.i(39749);
    if (this.ahbH != -1.0F)
    {
      f1 = this.ahbH;
      AppMethodBeat.o(39749);
      return f1;
    }
    if ((this.LQR & 0x7) == 1)
    {
      int j = this.uG;
      int i = this.uG;
      float f2;
      for (f1 = 0.0F; i < this.uH; f1 = f2)
      {
        int k;
        if (i + 1 < this.uH)
        {
          k = j;
          f2 = f1;
          if (this.ahaY[(i + 1)] == 0.0F) {}
        }
        else
        {
          f2 = f1 + (this.ahaY[j] + this.ahbF);
          k = i + 1;
        }
        i += 1;
        j = k;
      }
    }
    for (float f1 = (this.ahbJ - f1) / 2.0F;; f1 = 0.0F)
    {
      f1 = Math.max(0.0F, f1);
      if ((this.ahbC.ahbm.pD(this.uG, this.uG + 1) == null) && (this.ahbC.jQS().containsKey(Character.valueOf(this.ahbD[this.uG]))))
      {
        f1 -= ((Float)this.ahbC.jQS().get(Character.valueOf(this.ahbD[this.uG]))).floatValue();
        this.ahbH = f1;
        AppMethodBeat.o(39749);
        return f1;
      }
      this.ahbH = f1;
      f1 = this.ahbH;
      AppMethodBeat.o(39749);
      return f1;
    }
  }
  
  public final float jQP()
  {
    return this.ahbN;
  }
  
  public final RectF pC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39748);
    RectF localRectF = new RectF();
    if (paramInt1 >= paramInt2)
    {
      AppMethodBeat.o(39748);
      return localRectF;
    }
    float f1 = jQO();
    int i = this.uG;
    while (i < paramInt1)
    {
      f1 += this.ahaY[i] + this.ahbF;
      i += 1;
    }
    float f2 = f1;
    while (paramInt1 < paramInt2)
    {
      f2 += this.ahaY[paramInt1] + this.ahbF;
      paramInt1 += 1;
    }
    localRectF.set(f1, this.ahbK.top, f2, this.ahbK.bottom);
    AppMethodBeat.o(39748);
    return localRectF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(39754);
    String str = "MeasuredLine{mStart=" + this.uG + ", mEnd=" + this.uH + ", mLetter=" + this.ahbF + ", isSmartLetter=" + this.ahbG + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.ahbH + ", mLineRect=" + this.ahbK + ", mLineRect=" + this.ahbL + '}';
    AppMethodBeat.o(39754);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.d
 * JD-Core Version:    0.7.0.1
 */