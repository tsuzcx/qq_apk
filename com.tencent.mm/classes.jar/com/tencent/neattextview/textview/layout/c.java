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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements a
{
  private static final TextPaint wEk = new TextPaint(1);
  private static Comparator<Integer> wEl = new Comparator() {};
  public int Eo;
  public int aiH;
  private float mHeight;
  private float mWidth;
  private float[] wDE;
  private b wEm;
  private char[] wEn;
  private int wEo;
  private float wEp;
  private boolean wEq;
  private float wEr = -1.0F;
  private RectF wEs = new RectF();
  private LinkedList<Integer> wEt = null;
  
  public c(b paramb, char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2, float paramFloat3, float paramFloat4, TextPaint paramTextPaint, boolean paramBoolean, int paramInt3)
  {
    this.wEm = paramb;
    this.wEn = paramArrayOfChar;
    this.aiH = paramInt1;
    this.Eo = paramInt2;
    this.wEo = paramInt3;
    this.wDE = paramArrayOfFloat;
    this.wEp = paramFloat4;
    this.wEq = paramBoolean;
    this.mHeight = paramFloat3;
    this.mWidth = paramFloat2;
    paramb = paramTextPaint.getFontMetrics();
    paramFloat3 = paramb.leading;
    paramFloat4 = paramb.top;
    float f1 = paramb.bottom;
    float f2 = paramb.leading;
    paramFloat1 = (this.mHeight - paramb.bottom + paramb.top) / 2.0F + paramFloat1 - paramb.top;
    this.wEs.set(0.0F, paramFloat1 - (paramFloat3 - paramFloat4), 0.0F + paramFloat2, paramFloat1 + (f1 - f2));
  }
  
  private boolean a(TextPaint paramTextPaint, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    wEk.set(paramTextPaint);
    paramTextPaint = (AbsoluteSizeSpan)this.wEm.wDT.ga(paramInt1, paramInt2);
    if (paramTextPaint != null)
    {
      paramTextPaint.updateDrawState(wEk);
      bool1 = true;
    }
    paramTextPaint = (RelativeSizeSpan)this.wEm.wDU.ga(paramInt1, paramInt2);
    if (paramTextPaint != null)
    {
      paramTextPaint.updateDrawState(wEk);
      bool1 = bool2;
    }
    for (;;)
    {
      paramTextPaint = (ForegroundColorSpan)this.wEm.wDW.ga(paramInt1, paramInt2);
      if (paramTextPaint != null) {
        paramTextPaint.updateDrawState(wEk);
      }
      paramTextPaint = (ClickableSpan)this.wEm.wDX.ga(paramInt1, paramInt2);
      if (paramTextPaint != null) {
        paramTextPaint.updateDrawState(wEk);
      }
      return bool1;
    }
  }
  
  private void fZ(int paramInt1, int paramInt2)
  {
    if (this.wEt == null)
    {
      this.wEt = new LinkedList();
      b.a[] arrayOfa = b.a.values();
      int n = arrayOfa.length;
      int i = 0;
      while (i < n)
      {
        Object localObject1 = arrayOfa[i];
        if (localObject1 != b.a.wEe)
        {
          Object localObject2 = this.wEm;
          int j;
          int k;
          label127:
          LinkedList localLinkedList;
          switch (b.1.wEc[localObject1.ordinal()])
          {
          default: 
            localObject1 = null;
            localObject2 = ((d)localObject1).gb(paramInt1, paramInt2);
            int i1 = localObject2.length;
            j = 0;
            k = 0;
            if (j >= i1) {
              break label307;
            }
            if (localObject2[j] != 0)
            {
              localLinkedList = this.wEt;
              if (localObject1.wEy[k] >= paramInt1) {
                break label281;
              }
              m = paramInt1;
              label163:
              localLinkedList.add(Integer.valueOf(m));
              localLinkedList = this.wEt;
              if (localObject1.wEz[k] <= paramInt2) {
                break label294;
              }
            }
            break;
          }
          label281:
          label294:
          for (int m = paramInt2;; m = localObject1.wEz[k])
          {
            localLinkedList.add(Integer.valueOf(m));
            k += 1;
            j += 1;
            break label127;
            localObject1 = ((b)localObject2).wDX;
            break;
            localObject1 = ((b)localObject2).wDV;
            break;
            localObject1 = ((b)localObject2).wDS;
            break;
            localObject1 = ((b)localObject2).wDT;
            break;
            localObject1 = ((b)localObject2).wDU;
            break;
            localObject1 = ((b)localObject2).wDW;
            break;
            m = localObject1.wEy[k];
            break label163;
          }
        }
        label307:
        i += 1;
      }
      Collections.sort(this.wEt, wEl);
    }
  }
  
  private int getLength()
  {
    return this.Eo - this.aiH;
  }
  
  public final void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat)
  {
    float f1 = 0.0F + cNK();
    Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
    float f2 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
    int j = this.aiH;
    int k = this.Eo;
    Object localObject1 = this.wEm.wDY.wEy;
    Object localObject2 = this.wEm.wDY.wEz;
    LineBackgroundSpan[] arrayOfLineBackgroundSpan = (LineBackgroundSpan[])this.wEm.wDY.wEx;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.wEm.wDY.wEw)
    {
      if ((localObject1[i] < k) && (localObject2[i] > j)) {
        localLinkedList.add(arrayOfLineBackgroundSpan[i]);
      }
      i += 1;
    }
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((LineBackgroundSpan)((Iterator)localObject1).next()).drawBackground(paramCanvas, paramTextPaint, (int)this.wEs.left, (int)this.wEs.right, (int)this.wEs.top, (int)f2, (int)this.wEs.bottom, this.wEm.getText(), this.aiH, this.Eo, this.wEo);
    }
    float f3;
    if ((this.wEp != 0.0F) || (this.wEq))
    {
      j = this.aiH;
      i = this.aiH;
      f3 = f1;
      f1 = f2;
      f2 = f3;
      if (i < this.Eo)
      {
        float f4;
        if (i + 1 < this.Eo)
        {
          k = j;
          f4 = f2;
          f3 = f1;
          if (this.wDE[(i + 1)] == 0.0F) {}
        }
        else
        {
          k = i + 1;
          localObject1 = (ImageSpan)this.wEm.wDS.ga(j, k);
          if (localObject1 == null) {
            break label446;
          }
          wEk.set(paramTextPaint);
          ((ImageSpan)localObject1).draw(paramCanvas, "", j, k, f2, 0, (int)f1, (int)(this.mHeight + paramFloat), wEk);
        }
        for (;;)
        {
          f4 = f2 + (this.wDE[j] + this.wEp);
          f3 = f1;
          i += 1;
          j = k;
          f2 = f4;
          f1 = f3;
          break;
          label446:
          if (a(paramTextPaint, j, k)) {
            f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
          }
          paramCanvas.drawText(this.wEn, j, k - j, f2, f1, wEk);
        }
      }
    }
    else
    {
      fZ(this.aiH, this.Eo);
      i = this.aiH;
      localObject1 = this.wEt.iterator();
      f3 = f1;
      f1 = f2;
      f2 = f3;
      while (((Iterator)localObject1).hasNext())
      {
        j = ((Integer)((Iterator)localObject1).next()).intValue();
        if ((j > 0) && (i != j))
        {
          localObject2 = (ImageSpan)this.wEm.wDS.gc(i, j);
          if (localObject2 != null)
          {
            wEk.set(paramTextPaint);
            ((ImageSpan)localObject2).draw(paramCanvas, "", i, j, f2, 0, (int)f1, (int)(this.mHeight + paramFloat), wEk);
          }
          while (i < j)
          {
            f2 += this.wDE[i];
            i += 1;
            continue;
            if (a(paramTextPaint, i, j)) {
              f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
            }
            paramCanvas.drawText(this.wEn, i, j - i, f2, f1, wEk);
          }
          i = j;
        }
      }
      if (i < this.aiH + getLength()) {
        if (!a(paramTextPaint, i, this.aiH + getLength())) {
          break label835;
        }
      }
    }
    label835:
    for (paramFloat = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;; paramFloat = f1)
    {
      paramCanvas.drawText(this.wEn, i, this.aiH + getLength() - i, f2, paramFloat, wEk);
      return;
    }
  }
  
  public final float[] cNG()
  {
    return this.wDE;
  }
  
  public final RectF cNH()
  {
    return this.wEs;
  }
  
  public final float cNI()
  {
    return this.wEp;
  }
  
  public final boolean cNJ()
  {
    return this.wEq;
  }
  
  public final float cNK()
  {
    if (this.wEr != -1.0F) {
      return this.wEr;
    }
    if ((this.wEm.wDS.ga(this.aiH, this.aiH + 1) == null) && (this.wEm.cNO().containsKey(Character.valueOf(this.wEn[this.aiH]))))
    {
      float f = -((Float)this.wEm.cNO().get(Character.valueOf(this.wEn[this.aiH]))).floatValue();
      this.wEr = f;
      return f;
    }
    this.wEr = 0.0F;
    return this.wEr;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      if ((paramObject.getStart() != this.aiH) || (paramObject.getEnd() != this.Eo) || (!paramObject.cNH().equals(this.wEs)) || (paramObject.cNJ() != this.wEq) || (paramObject.cNI() != this.wEp) || (paramObject.cNK() != this.wEr)) {
        return false;
      }
      int i = this.aiH;
      while (i < this.Eo)
      {
        if (this.wDE[i] != paramObject.cNG()[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public final RectF fY(int paramInt1, int paramInt2)
  {
    RectF localRectF = new RectF();
    if (paramInt1 >= paramInt2) {
      return localRectF;
    }
    float f1 = cNK();
    int i = this.aiH;
    while (i < paramInt1)
    {
      f1 += this.wDE[i] + this.wEp;
      i += 1;
    }
    float f2 = f1;
    while (paramInt1 < paramInt2)
    {
      f2 += this.wDE[paramInt1] + this.wEp;
      paramInt1 += 1;
    }
    localRectF.set(f1, this.wEs.top, f2, this.wEs.bottom);
    return localRectF;
  }
  
  public final int getEnd()
  {
    return this.Eo;
  }
  
  public final float getHeight()
  {
    return this.mHeight;
  }
  
  public final int getStart()
  {
    return this.aiH;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final int hashCode()
  {
    return this.aiH + this.Eo + (int)this.mHeight + (int)this.mWidth + (int)this.wEr + this.wEs.hashCode();
  }
  
  public final String toString()
  {
    return "MeasuredLine{mStart=" + this.aiH + ", mEnd=" + this.Eo + ", mLetter=" + this.wEp + ", isSmartLetter=" + this.wEq + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.wEr + ", mLineRect=" + this.wEs + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.c
 * JD-Core Version:    0.7.0.1
 */