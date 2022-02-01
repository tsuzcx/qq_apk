package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.RelativeSizeSpan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class c
  implements a
{
  public static final char[] JJI = { '…' };
  private static final String JJJ = new String(JJI);
  protected String JJK;
  protected char[] JJL;
  protected float[] JJM;
  protected float[] JJN;
  protected float[] JJO = new float[com.tencent.neattextview.textview.a.a.JJE.length];
  protected float[] JJP = new float[com.tencent.neattextview.textview.a.a.JJF.length];
  protected HashMap<Character, Float> JJQ = new HashMap(com.tencent.neattextview.textview.a.a.JJE.length);
  public ArrayList<b> JJR = new ArrayList();
  private LinkedList<com.tencent.neattextview.textview.b.b> JJS = new LinkedList();
  private float JJT;
  private float JJU;
  private float JJV;
  private float JJW;
  private float JJX;
  private int JJY;
  private TextPaint JJZ = new TextPaint();
  private float[] JKa;
  e<ImageSpan> JKb = new e(ImageSpan.class);
  e<AbsoluteSizeSpan> JKc = new e(AbsoluteSizeSpan.class);
  e<RelativeSizeSpan> JKd = new e(RelativeSizeSpan.class);
  private e<BackgroundColorSpan> JKe = new e(BackgroundColorSpan.class);
  e<ForegroundColorSpan> JKf = new e(ForegroundColorSpan.class);
  e<ClickableSpan> JKg = new e(ClickableSpan.class);
  e<LineBackgroundSpan> JKh = new e(LineBackgroundSpan.class);
  private float JKi = 0.0F;
  private LinkedList<com.tencent.neattextview.textview.b.c> JKj;
  protected boolean[] JKk;
  private int JKl = 0;
  private int JKm = 0;
  private int JKn = 0;
  protected TextPaint awy;
  private int byS = 0;
  private TextUtils.TruncateAt gls;
  protected CharSequence mText;
  private float oTD;
  
  public c(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    this.mText = paramCharSequence;
    this.JJK = paramCharSequence.toString();
    this.JJL = this.JJK.toCharArray();
    if (paramArrayOfFloat != null)
    {
      this.JJM = new float[paramArrayOfFloat.length];
      System.arraycopy(paramArrayOfFloat, 0, this.JJM, 0, paramArrayOfFloat.length);
    }
  }
  
  private void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat, TextPaint paramTextPaint)
  {
    int i;
    label129:
    float f;
    if ((this.gls != null) && (this.gls != TextUtils.TruncateAt.MARQUEE)) {
      if ((this.mText != null) && (this.JJR.size() > 0) && ((this.mText.length() > ((b)this.JJR.get(this.JJR.size() - 1)).getEnd()) || ((this.JJX > 0.0F) && (fBw()[0] - ((b)this.JJR.get(this.JJR.size() - 1)).getWidth() < this.JJX))))
      {
        i = 1;
        if (i == 0) {
          break label327;
        }
        i = 1;
        if (i == 0) {
          break label415;
        }
        f = paramTextPaint.measureText(JJJ) + paramTextPaint.getTextSize() / 6.0F + paramFloat;
        paramTextPaint = (b)this.JJR.get(this.JJR.size() - 1);
        this.JKn = (this.JJR.size() - 1);
        if ((this.byS != 1) || (paramTruncateAt != TextUtils.TruncateAt.MIDDLE)) {
          break label348;
        }
        paramTruncateAt = (b)this.JJR.get(0);
        i = paramTruncateAt.getStart();
        paramFloat = 0.0F;
        label223:
        if (i >= paramTruncateAt.getEnd()) {
          break label342;
        }
        paramFloat += this.JJM[i];
        if (paramFloat < this.oTD / 2.0F) {
          break label333;
        }
      }
    }
    for (;;)
    {
      label255:
      int j = paramTextPaint.getStart();
      paramFloat = 0.0F;
      for (;;)
      {
        if (i >= j)
        {
          paramFloat += this.JJM[i];
          if ((paramFloat < f) && (i != j))
          {
            this.JJM[i] = 0.0F;
            this.JJL[i] = '\000';
            i -= 1;
            continue;
            i = 0;
            break;
            label327:
            i = 0;
            break label129;
            label333:
            i += 1;
            break label223;
            label342:
            i = 0;
            break label255;
            label348:
            if (paramTruncateAt != TextUtils.TruncateAt.END) {
              break label416;
            }
            i = paramTextPaint.getEnd() - 1;
            break label255;
          }
        }
      }
      if (i >= 0)
      {
        this.JKm = (this.JJL.length - i);
        this.JJM[i] = f;
        this.JJL[i] = JJI[0];
        this.JKl = (i - j);
      }
      label415:
      return;
      label416:
      i = 0;
    }
  }
  
  private void a(CharSequence paramCharSequence, TextPaint paramTextPaint, boolean[] paramArrayOfBoolean)
  {
    int k = 0;
    Object localObject;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject = (Spanned)paramCharSequence;
      i = paramCharSequence.length();
      this.JKb.a((Spanned)localObject, i);
      this.JKc.a((Spanned)localObject, i);
      this.JKd.a((Spanned)localObject, i);
      this.JKf.a((Spanned)localObject, i);
      this.JKe.a((Spanned)localObject, i);
      this.JKg.a((Spanned)localObject, i);
      this.JKh.a((Spanned)localObject, i);
    }
    this.JJZ.set(paramTextPaint);
    int i = 0;
    int j;
    int m;
    int n;
    while (i < this.JKc.JKE)
    {
      ((AbsoluteSizeSpan[])this.JKc.JKF)[i].updateMeasureState(this.JJZ);
      j = this.JKc.JKG[i];
      m = this.JKc.JKH[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.JJZ.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.JJM, j, n);
      if (this.JJN == null) {
        this.JJN = new float[paramCharSequence.length()];
      }
      this.JJN[j] = this.JJZ.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.JKd.JKE)
    {
      ((RelativeSizeSpan[])this.JKd.JKF)[i].updateMeasureState(this.JJZ);
      j = this.JKd.JKG[i];
      m = this.JKd.JKH[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.JJZ.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.JJM, j, n);
      if (this.JJN == null) {
        this.JJN = new float[paramCharSequence.length()];
      }
      this.JJN[j] = this.JJZ.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.JKb.JKE)
    {
      paramTextPaint = ((ImageSpan[])this.JKb.JKF)[i];
      m = this.JKb.JKG[i];
      n = this.JKb.JKH[i];
      paramTextPaint = paramTextPaint.getDrawable();
      localObject = new Rect();
      if (paramTextPaint != null) {
        ((Rect)localObject).set(paramTextPaint.getBounds());
      }
      this.JJM[m] = ((Rect)localObject).width();
      paramArrayOfBoolean[m] = true;
      j = m + 1;
      while ((j < m + (n - m)) && (j < this.JJM.length))
      {
        this.JJM[j] = 0.0F;
        paramArrayOfBoolean[j] = true;
        j += 1;
      }
      if (this.JJN == null) {
        this.JJN = new float[paramCharSequence.length()];
      }
      this.JJN[m] = ((Rect)localObject).height();
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.JKe.JKE) {
        break;
      }
      paramCharSequence = ((BackgroundColorSpan[])this.JKe.JKF)[i];
      j = this.JKe.JKG[i];
      m = this.JKe.JKH[i];
      this.JJS.add(new com.tencent.neattextview.textview.b.a(j, m, paramCharSequence));
      i += 1;
    }
    while (j < this.JKg.JKE)
    {
      paramCharSequence = ((ClickableSpan[])this.JKg.JKF)[j];
      i = this.JKg.JKG[j];
      k = this.JKg.JKH[j];
      this.JJS.add(new com.tencent.neattextview.textview.b.c(i, k, paramCharSequence));
      j += 1;
    }
  }
  
  private void b(Paint paramPaint)
  {
    this.JJQ.clear();
    Rect localRect = new Rect();
    char[] arrayOfChar = com.tencent.neattextview.textview.a.a.JJE;
    int k = arrayOfChar.length;
    int i = 0;
    int j = 0;
    float f1;
    while (i < k)
    {
      char c = arrayOfChar[i];
      f1 = paramPaint.measureText(String.valueOf(c));
      paramPaint.getTextBounds(String.valueOf(c), 0, 1, localRect);
      float f2 = localRect.right;
      this.JJO[j] = (f1 - f2);
      j += 1;
      i += 1;
    }
    arrayOfChar = com.tencent.neattextview.textview.a.a.JJF;
    k = arrayOfChar.length;
    i = 0;
    j = 0;
    if (i < k)
    {
      paramPaint.getTextBounds(String.valueOf(arrayOfChar[i]), 0, 1, localRect);
      if (localRect.left > 0) {}
      for (f1 = localRect.left;; f1 = 0.0F)
      {
        this.JJP[j] = f1;
        this.JJQ.put(Character.valueOf(com.tencent.neattextview.textview.a.a.JJF[j]), Float.valueOf(f1));
        j += 1;
        i += 1;
        break;
      }
    }
  }
  
  public final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramFloat1 = 0.0F;
    Iterator localIterator = this.JJS.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.neattextview.textview.b.b)localIterator.next()).a(paramCanvas, this.awy, this.JJR);
    }
    localIterator = this.JJR.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.a(paramCanvas, this.awy, paramFloat1);
      paramFloat1 = localb.getHeight() + paramFloat1;
    }
    paramCanvas.restore();
  }
  
  public final void a(TextPaint paramTextPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, TextUtils.TruncateAt paramTruncateAt, float paramFloat6, boolean paramBoolean, int paramInt2)
  {
    this.awy = new TextPaint(paramTextPaint);
    this.JJX = paramFloat6;
    this.JJT = paramFloat2;
    this.oTD = paramFloat1;
    this.JJU = paramFloat3;
    this.JJV = paramFloat4;
    this.byS = paramInt1;
    this.gls = paramTruncateAt;
    this.JJW = paramFloat5;
    this.JKa = null;
    this.JJY = paramInt2;
    paramInt2 = this.mText.length();
    if (this.JJM == null)
    {
      this.JJM = new float[paramInt2];
      paramTextPaint.getTextWidths(this.JJK, this.JJM);
    }
    this.JKk = new boolean[paramInt2];
    a(this.mText, paramTextPaint, this.JKk);
    b(paramTextPaint);
    a(paramTextPaint, paramFloat1, paramInt1, paramBoolean);
    a(paramTruncateAt, paramFloat6, paramTextPaint);
  }
  
  protected abstract void a(TextPaint paramTextPaint, float paramFloat, int paramInt, boolean paramBoolean);
  
  protected final void a(char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, int paramInt3, float paramFloat2, boolean paramBoolean, float paramFloat3, float paramFloat4)
  {
    Paint.FontMetrics localFontMetrics = this.awy.getFontMetrics();
    float f1 = localFontMetrics.bottom - localFontMetrics.top;
    float f2 = f1;
    if (this.JJN != null)
    {
      int i = paramInt1;
      for (;;)
      {
        f2 = f1;
        if (i >= paramInt2) {
          break;
        }
        f2 = f1;
        if (f1 < this.JJN[i]) {
          f2 = this.JJN[i];
        }
        i += 1;
        f1 = f2;
      }
    }
    f1 = f2 + this.JJW;
    paramArrayOfChar = new d(this, paramArrayOfChar, paramInt1, paramInt2, this.JKi, paramArrayOfFloat, paramFloat1, f1, paramFloat2, this.awy, paramBoolean, paramFloat3, paramInt3, this.JJY, paramFloat4);
    this.JKi += f1;
    this.JJR.add(paramArrayOfChar);
  }
  
  public final void ay(CharSequence paramCharSequence)
  {
    a(paramCharSequence, this.awy, this.JKk);
  }
  
  public int fBm()
  {
    return this.JJR.size();
  }
  
  public final List<com.tencent.neattextview.textview.b.c> fBn()
  {
    if (this.JKj == null)
    {
      this.JKj = new LinkedList();
      Iterator localIterator = this.JJS.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.neattextview.textview.b.b localb = (com.tencent.neattextview.textview.b.b)localIterator.next();
        if (localb.getClass() == com.tencent.neattextview.textview.b.c.class) {
          this.JKj.add((com.tencent.neattextview.textview.b.c)localb);
        }
      }
    }
    return this.JKj;
  }
  
  public final float[] fBo()
  {
    return this.JJM;
  }
  
  public final String fBv()
  {
    return this.JJK;
  }
  
  public final float[] fBw()
  {
    if (this.JKa == null)
    {
      Iterator localIterator = this.JJR.iterator();
      float f2 = 0.0F;
      float f1 = 0.0F;
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        float f3 = f2;
        if (f2 < localb.getWidth()) {
          f3 = localb.getWidth();
        }
        f1 = localb.getHeight() + f1;
        f2 = f3;
      }
      this.JKa = new float[] { f2, f1 };
    }
    return this.JKa;
  }
  
  public final HashMap<Character, Float> fBx()
  {
    return this.JJQ;
  }
  
  public final int getEllipsisCount(int paramInt)
  {
    if (this.JKn == paramInt) {
      return this.JKm;
    }
    return 0;
  }
  
  public final int getLineBaseline(int paramInt)
  {
    int i = this.JJR.size();
    if (i > paramInt) {}
    for (b localb = (b)this.JJR.get(paramInt);; localb = (b)this.JJR.get(i - 1))
    {
      return (int)localb.fBu();
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineBottom(int paramInt)
  {
    int i = this.JJR.size();
    if (i > paramInt) {}
    for (b localb = (b)this.JJR.get(paramInt);; localb = (b)this.JJR.get(i - 1))
    {
      return (int)localb.fBp().bottom;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineForOffset(int paramInt)
  {
    Iterator localIterator = this.JJR.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.getStart() <= paramInt) && (paramInt < localb.getEnd())) {
        return i;
      }
      i += 1;
    }
    return i - 1;
  }
  
  public final int getLineForVertical(int paramInt)
  {
    int i = (int)(paramInt - this.JJV);
    Iterator localIterator = this.JJR.iterator();
    float f1 = 0.0F;
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (b)localIterator.next();
      float f2 = f1;
      if (f1 == 0.0F) {
        f2 = ((b)localObject).fBq().top;
      }
      localObject = ((b)localObject).fBq();
      if (((RectF)localObject).contains(((RectF)localObject).centerX(), i)) {
        return paramInt;
      }
      paramInt += 1;
      f1 = f2;
    }
    if (i <= f1) {
      return 0;
    }
    return paramInt - 1;
  }
  
  public final float getLineRight(int paramInt)
  {
    if (this.JJR.size() > paramInt) {
      return ((b)this.JJR.get(paramInt)).fBp().right;
    }
    return 0.0F;
  }
  
  public final int getLineStart(int paramInt)
  {
    if (this.JJR.size() > paramInt) {
      return ((b)this.JJR.get(paramInt)).getStart();
    }
    return this.JJL.length;
  }
  
  public final int getLineTop(int paramInt)
  {
    int i = this.JJR.size();
    if (i > paramInt) {}
    for (b localb = (b)this.JJR.get(paramInt);; localb = (b)this.JJR.get(i - 1))
    {
      return (int)localb.fBp().top;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final float getLineWidth(int paramInt)
  {
    if (this.JJR.size() > paramInt) {
      return ((b)this.JJR.get(paramInt)).fBp().width();
    }
    return 0.0F;
  }
  
  public final int getOffsetForHorizontal(int paramInt, float paramFloat)
  {
    float f = this.JJU;
    if (this.JJR.size() > paramInt) {
      return ((b)this.JJR.get(paramInt)).adW((int)(paramFloat - f));
    }
    return 0;
  }
  
  public final float getPrimaryHorizontal(int paramInt)
  {
    int i = getLineForOffset(paramInt);
    if (i < 0) {
      return 0.0F;
    }
    return ((b)this.JJR.get(i)).getPrimaryHorizontal(paramInt);
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  public final TextPaint getTextPaint()
  {
    return this.awy;
  }
  
  public final int ks(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 - this.JJU);
    paramInt2 = (int)(paramInt2 - this.JJV);
    Iterator localIterator = this.JJR.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.fBq().contains(paramInt1, paramInt2)) {
        return localb.adW(paramInt1);
      }
    }
    return this.JJL.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.c
 * JD-Core Version:    0.7.0.1
 */