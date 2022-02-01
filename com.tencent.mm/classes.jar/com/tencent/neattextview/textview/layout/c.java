package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
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
import android.text.style.LineHeightSpan;
import android.text.style.RelativeSizeSpan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class c
  implements a
{
  public static final char[] ahaU = { '…' };
  private static final String ahaV = new String(ahaU);
  private int LQR;
  protected String ahaW;
  protected char[] ahaX;
  protected float[] ahaY;
  protected float[] ahaZ;
  protected float[] ahba = new float[com.tencent.neattextview.textview.a.a.ahaQ.length];
  protected float[] ahbb = new float[com.tencent.neattextview.textview.a.a.ahaR.length];
  protected HashMap<Character, Float> ahbc = new HashMap(com.tencent.neattextview.textview.a.a.ahaQ.length);
  public ArrayList<b> ahbd = new ArrayList();
  private LinkedList<com.tencent.neattextview.textview.b.b> ahbe = new LinkedList();
  private float ahbf;
  private float ahbg;
  private float ahbh;
  private float ahbi;
  private float ahbj;
  private TextPaint ahbk = new TextPaint();
  private float[] ahbl;
  e<ImageSpan> ahbm = new e(ImageSpan.class);
  private e<LineHeightSpan> ahbn = new e(LineHeightSpan.class);
  e<AbsoluteSizeSpan> ahbo = new e(AbsoluteSizeSpan.class);
  e<RelativeSizeSpan> ahbp = new e(RelativeSizeSpan.class);
  private e<BackgroundColorSpan> ahbq = new e(BackgroundColorSpan.class);
  e<ForegroundColorSpan> ahbr = new e(ForegroundColorSpan.class);
  e<ClickableSpan> ahbs = new e(ClickableSpan.class);
  e<LineBackgroundSpan> ahbt = new e(LineBackgroundSpan.class);
  private float ahbu = 0.0F;
  private LinkedList<com.tencent.neattextview.textview.b.c> ahbv;
  protected boolean[] ahbw;
  private int ahbx = 0;
  private int ahby = 0;
  private int ahbz = 0;
  private TextUtils.TruncateAt bbe;
  private int dmJ = 0;
  protected CharSequence mText;
  private float xBM;
  protected TextPaint xe;
  
  public c(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    this.mText = paramCharSequence;
    this.ahaW = paramCharSequence.toString();
    this.ahaX = this.ahaW.toCharArray();
    if (paramArrayOfFloat != null)
    {
      this.ahaY = new float[paramArrayOfFloat.length];
      System.arraycopy(paramArrayOfFloat, 0, this.ahaY, 0, paramArrayOfFloat.length);
    }
  }
  
  private void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat, TextPaint paramTextPaint)
  {
    int i;
    label115:
    float f1;
    if ((this.bbe != null) && (this.bbe != TextUtils.TruncateAt.MARQUEE))
    {
      i = this.ahbd.size();
      if (i > 0)
      {
        b localb = (b)this.ahbd.get(i - 1);
        if ((this.mText != null) && ((this.mText.length() > localb.getEnd()) || ((this.ahbj > 0.0F) && (jQR()[0] - localb.getWidth() < this.ahbj))))
        {
          i = 1;
          if (i == 0) {
            break label331;
          }
          i = 1;
          if (i == 0) {
            break label492;
          }
          f1 = paramTextPaint.measureText(ahaV) + paramFloat + paramTextPaint.getTextSize() / 6.0F;
          paramTextPaint = (b)this.ahbd.get(this.ahbd.size() - 1);
          this.ahbz = (this.ahbd.size() - 1);
          if ((this.dmJ != 1) || (paramTruncateAt != TextUtils.TruncateAt.MIDDLE)) {
            break label352;
          }
          paramTruncateAt = (b)this.ahbd.get(0);
          i = paramTruncateAt.getStart();
          paramFloat = 0.0F;
          label209:
          if (i >= paramTruncateAt.getEnd()) {
            break label346;
          }
          paramFloat += this.ahaY[i];
          if (paramFloat < this.xBM / 2.0F) {
            break label337;
          }
        }
      }
    }
    for (;;)
    {
      label241:
      int k = paramTextPaint.getStart();
      for (;;)
      {
        if (i >= k)
        {
          paramFloat = this.xBM;
          float f2 = paramTextPaint.dv(i);
          if (((this.ahaY[i] <= 0.0F) || (paramFloat - f2 < f1)) && (i != k))
          {
            this.ahaY[i] = 0.0F;
            this.ahaX[i] = '\000';
            i -= 1;
            continue;
            i = 0;
            break;
            label331:
            i = 0;
            break label115;
            label337:
            i += 1;
            break label209;
            label346:
            i = 0;
            break label241;
            label352:
            if (paramTruncateAt != TextUtils.TruncateAt.END) {
              break label498;
            }
            i = paramTextPaint.getEnd() - 1;
            break label241;
          }
        }
      }
      if (i >= 0)
      {
        int j = 0;
        while ((this.ahbm.ahbS != null) && (j < this.ahbm.ahbS.length))
        {
          if (this.ahbm.ahbS[j] == i)
          {
            this.ahbm.ahbS[j] = -1;
            this.ahbm.ahbT[j] = -1;
          }
          j += 1;
        }
        this.ahby = (this.ahaX.length - i);
        this.ahaY[i] = f1;
        this.ahaX[i] = ahaU[0];
        this.ahbx = (i - k);
      }
      return;
      label492:
      this.ahby = 0;
      return;
      label498:
      i = 0;
    }
  }
  
  private void a(CharSequence paramCharSequence, TextPaint paramTextPaint, boolean[] paramArrayOfBoolean)
  {
    int k = 0;
    Object localObject1;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject1 = (Spanned)paramCharSequence;
      i = paramCharSequence.length();
      this.ahbm.a((Spanned)localObject1, i);
      this.ahbn.a((Spanned)localObject1, i);
      this.ahbo.a((Spanned)localObject1, i);
      this.ahbp.a((Spanned)localObject1, i);
      this.ahbr.a((Spanned)localObject1, i);
      this.ahbq.a((Spanned)localObject1, i);
      this.ahbs.a((Spanned)localObject1, i);
      this.ahbt.a((Spanned)localObject1, i);
    }
    this.ahbk.set(paramTextPaint);
    int i = 0;
    int j;
    int m;
    int n;
    while (i < this.ahbo.ahbQ)
    {
      ((AbsoluteSizeSpan[])this.ahbo.ahbR)[i].updateMeasureState(this.ahbk);
      j = this.ahbo.ahbS[i];
      m = this.ahbo.ahbT[i];
      n = m - j;
      localObject1 = new float[n];
      this.ahbk.getTextWidths(paramCharSequence, j, m, (float[])localObject1);
      System.arraycopy(localObject1, 0, this.ahaY, j, n);
      if (this.ahaZ == null) {
        this.ahaZ = new float[paramCharSequence.length()];
      }
      localObject1 = this.ahaZ;
      localObject1[j] = Math.max(localObject1[j], this.ahbk.getTextSize());
      i += 1;
    }
    i = 0;
    while (i < this.ahbp.ahbQ)
    {
      ((RelativeSizeSpan[])this.ahbp.ahbR)[i].updateMeasureState(this.ahbk);
      j = this.ahbp.ahbS[i];
      m = this.ahbp.ahbT[i];
      n = m - j;
      localObject1 = new float[n];
      this.ahbk.getTextWidths(paramCharSequence, j, m, (float[])localObject1);
      System.arraycopy(localObject1, 0, this.ahaY, j, n);
      if (this.ahaZ == null) {
        this.ahaZ = new float[paramCharSequence.length()];
      }
      localObject1 = this.ahaZ;
      localObject1[j] = Math.max(localObject1[j], this.ahbk.getTextSize());
      i += 1;
    }
    i = 0;
    Object localObject2;
    while (i < this.ahbn.ahbQ)
    {
      localObject2 = ((LineHeightSpan[])this.ahbn.ahbR)[i];
      j = this.ahbn.ahbS[i];
      m = this.ahbn.ahbT[i];
      if (this.ahaZ == null) {
        this.ahaZ = new float[paramCharSequence.length()];
      }
      localObject1 = this.xe.getFontMetricsInt();
      ((LineHeightSpan)localObject2).chooseHeight(paramCharSequence, j, m, 0, 0, (Paint.FontMetricsInt)localObject1);
      localObject2 = this.ahaZ;
      localObject2[j] = Math.max(localObject2[j], ((Paint.FontMetricsInt)localObject1).descent - ((Paint.FontMetricsInt)localObject1).ascent);
      i += 1;
    }
    i = 0;
    while (i < this.ahbm.ahbQ)
    {
      localObject2 = ((ImageSpan[])this.ahbm.ahbR)[i];
      m = this.ahbm.ahbS[i];
      n = this.ahbm.ahbT[i];
      Drawable localDrawable = ((ImageSpan)localObject2).getDrawable();
      localObject1 = new Rect();
      if (localDrawable != null) {
        ((Rect)localObject1).set(localDrawable.getBounds());
      }
      this.ahaY[m] = ((ImageSpan)localObject2).getSize(paramTextPaint, paramCharSequence, m, n, null);
      paramArrayOfBoolean[m] = true;
      j = m + 1;
      while ((j < m + (n - m)) && (j < this.ahaY.length))
      {
        this.ahaY[j] = 0.0F;
        paramArrayOfBoolean[j] = true;
        j += 1;
      }
      if (this.ahaZ == null) {
        this.ahaZ = new float[paramCharSequence.length()];
      }
      localObject2 = this.xe.getFontMetrics();
      float f1 = ((Paint.FontMetrics)localObject2).bottom;
      float f2 = ((Paint.FontMetrics)localObject2).top;
      localObject2 = this.ahaZ;
      localObject2[m] = Math.max(localObject2[m], Math.max(f1 - f2, ((Rect)localObject1).height()));
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.ahbq.ahbQ) {
        break;
      }
      paramCharSequence = ((BackgroundColorSpan[])this.ahbq.ahbR)[i];
      j = this.ahbq.ahbS[i];
      m = this.ahbq.ahbT[i];
      this.ahbe.add(new com.tencent.neattextview.textview.b.a(j, m, paramCharSequence));
      i += 1;
    }
    while (j < this.ahbs.ahbQ)
    {
      paramCharSequence = ((ClickableSpan[])this.ahbs.ahbR)[j];
      i = this.ahbs.ahbS[j];
      k = this.ahbs.ahbT[j];
      this.ahbe.add(new com.tencent.neattextview.textview.b.c(i, k, paramCharSequence));
      j += 1;
    }
  }
  
  private void f(Paint paramPaint)
  {
    this.ahbc.clear();
    Rect localRect = new Rect();
    char[] arrayOfChar = com.tencent.neattextview.textview.a.a.ahaQ;
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
      this.ahba[j] = (f1 - f2);
      j += 1;
      i += 1;
    }
    arrayOfChar = com.tencent.neattextview.textview.a.a.ahaR;
    k = arrayOfChar.length;
    i = 0;
    j = 0;
    while (i < k)
    {
      paramPaint.getTextBounds(String.valueOf(arrayOfChar[i]), 0, 1, localRect);
      f1 = Math.max(localRect.left, 0);
      this.ahbb[j] = f1;
      this.ahbc.put(Character.valueOf(com.tencent.neattextview.textview.a.a.ahaR[j]), Float.valueOf(f1));
      j += 1;
      i += 1;
    }
  }
  
  public final int H(int paramInt, float paramFloat)
  {
    float f = this.ahbg;
    if (this.ahbd.size() > paramInt) {
      return ((b)this.ahbd.get(paramInt)).aGO((int)(paramFloat - f));
    }
    return 0;
  }
  
  public final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramFloat1 = 0.0F;
    Iterator localIterator = this.ahbe.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.neattextview.textview.b.b)localIterator.next()).a(paramCanvas, this.xe, this.ahbd);
    }
    localIterator = this.ahbd.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.a(paramCanvas, this.xe, paramFloat1);
      paramFloat1 = localb.getHeight() + paramFloat1;
    }
    paramCanvas.restore();
  }
  
  public final void a(TextPaint paramTextPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, TextUtils.TruncateAt paramTruncateAt, float paramFloat6, boolean paramBoolean, int paramInt2)
  {
    this.xe = new TextPaint(paramTextPaint);
    this.ahbj = paramFloat6;
    this.ahbf = paramFloat2;
    this.xBM = paramFloat1;
    this.ahbg = paramFloat3;
    this.ahbh = paramFloat4;
    this.dmJ = paramInt1;
    this.bbe = paramTruncateAt;
    this.ahbi = paramFloat5;
    this.ahbl = null;
    this.LQR = paramInt2;
    paramInt2 = this.mText.length();
    if (this.ahaY == null)
    {
      this.ahaY = new float[paramInt2];
      paramTextPaint.getTextWidths(this.ahaW, this.ahaY);
    }
    this.ahbw = new boolean[paramInt2];
    a(this.mText, paramTextPaint, this.ahbw);
    f(paramTextPaint);
    a(paramTextPaint, new float[0], paramFloat1, paramInt1, paramBoolean);
    a(paramTruncateAt, paramFloat6, paramTextPaint);
  }
  
  public final void a(TextPaint paramTextPaint, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, TextUtils.TruncateAt paramTruncateAt, float paramFloat6, boolean paramBoolean, int paramInt2)
  {
    this.xe = new TextPaint(paramTextPaint);
    this.ahbj = paramFloat6;
    this.ahbf = paramFloat2;
    this.xBM = paramFloat1;
    this.ahbg = paramFloat3;
    this.ahbh = paramFloat4;
    this.dmJ = paramInt1;
    this.bbe = paramTruncateAt;
    this.ahbi = paramFloat5;
    this.ahbl = null;
    this.LQR = paramInt2;
    paramInt2 = this.mText.length();
    if (this.ahaY == null)
    {
      this.ahaY = new float[paramInt2];
      paramTextPaint.getTextWidths(this.ahaW, this.ahaY);
    }
    this.ahbw = new boolean[paramInt2];
    a(this.mText, paramTextPaint, this.ahbw);
    f(paramTextPaint);
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    paramInt2 = 0;
    while (paramInt2 < paramArrayOfFloat.length)
    {
      arrayOfFloat[paramInt2] = (paramFloat1 - paramArrayOfFloat[paramInt2]);
      paramInt2 += 1;
    }
    a(paramTextPaint, arrayOfFloat, paramFloat1, paramInt1, paramBoolean);
    a(paramTruncateAt, paramFloat6, paramTextPaint);
  }
  
  protected abstract void a(TextPaint paramTextPaint, float[] paramArrayOfFloat, float paramFloat, int paramInt, boolean paramBoolean);
  
  protected final void a(char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, int paramInt3, float paramFloat2, boolean paramBoolean, float paramFloat3, float paramFloat4)
  {
    float f1 = this.ahbi;
    float f2 = f1;
    int i;
    if (this.ahaZ != null)
    {
      i = paramInt1;
      if (i < paramInt2)
      {
        f2 = this.ahaZ[i];
        if (f2 <= this.ahbi) {
          break label123;
        }
        f1 = f2;
      }
    }
    label123:
    for (;;)
    {
      i += 1;
      break;
      f2 = f1;
      paramArrayOfChar = new d(this, paramArrayOfChar, paramInt1, paramInt2, this.ahbu, paramArrayOfFloat, paramFloat1, f2, paramFloat2, this.xe, paramBoolean, paramFloat3, paramInt3, this.LQR, paramFloat4);
      this.ahbu += f2;
      this.ahbd.add(paramArrayOfChar);
      return;
    }
  }
  
  public final int aGH(int paramInt)
  {
    int i = this.ahbd.size();
    if (i > paramInt) {}
    for (b localb = (b)this.ahbd.get(paramInt);; localb = (b)this.ahbd.get(i - 1))
    {
      return (int)localb.jQP();
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int aGI(int paramInt)
  {
    int i = this.ahbd.size();
    if (i > paramInt) {}
    for (b localb = (b)this.ahbd.get(paramInt);; localb = (b)this.ahbd.get(i - 1))
    {
      return (int)localb.jQK().top;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int aGJ(int paramInt)
  {
    int i = this.ahbd.size();
    if (i > paramInt) {}
    for (b localb = (b)this.ahbd.get(paramInt);; localb = (b)this.ahbd.get(i - 1))
    {
      return (int)localb.jQK().bottom;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final float aGK(int paramInt)
  {
    if (this.ahbd.size() > paramInt) {
      return ((b)this.ahbd.get(paramInt)).jQK().width();
    }
    return 0.0F;
  }
  
  public final float aGL(int paramInt)
  {
    if (this.ahbd.size() > paramInt) {
      return ((b)this.ahbd.get(paramInt)).jQK().right;
    }
    return 0.0F;
  }
  
  public final int aGM(int paramInt)
  {
    if (this.ahbz == paramInt) {
      return this.ahbx;
    }
    return 0;
  }
  
  public final int aGN(int paramInt)
  {
    if (this.ahbz == paramInt) {
      return this.ahby;
    }
    return 0;
  }
  
  public final TextPaint aLt()
  {
    return this.xe;
  }
  
  public final void bj(CharSequence paramCharSequence)
  {
    a(paramCharSequence, this.xe, this.ahbw);
  }
  
  public final int di(int paramInt)
  {
    Iterator localIterator = this.ahbd.iterator();
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
  
  public final int dk(int paramInt)
  {
    if (this.ahbd.size() > paramInt) {
      return ((b)this.ahbd.get(paramInt)).getStart();
    }
    return this.ahaX.length;
  }
  
  public final int du(int paramInt)
  {
    int i = (int)(paramInt - this.ahbh);
    Iterator localIterator = this.ahbd.iterator();
    float f1 = 0.0F;
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (b)localIterator.next();
      float f2 = f1;
      if (f1 == 0.0F) {
        f2 = ((b)localObject).jQL().top;
      }
      localObject = ((b)localObject).jQL();
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
  
  public final float dv(int paramInt)
  {
    int i = di(paramInt);
    if (i < 0) {
      return 0.0F;
    }
    return ((b)this.ahbd.get(i)).dv(paramInt);
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  public int jQH()
  {
    return this.ahbd.size();
  }
  
  public final List<com.tencent.neattextview.textview.b.c> jQI()
  {
    if (this.ahbv == null)
    {
      this.ahbv = new LinkedList();
      Iterator localIterator = this.ahbe.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.neattextview.textview.b.b localb = (com.tencent.neattextview.textview.b.b)localIterator.next();
        if (localb.getClass() == com.tencent.neattextview.textview.b.c.class) {
          this.ahbv.add((com.tencent.neattextview.textview.b.c)localb);
        }
      }
    }
    return this.ahbv;
  }
  
  public final float[] jQJ()
  {
    return this.ahaY;
  }
  
  public final String jQQ()
  {
    return this.ahaW;
  }
  
  public final float[] jQR()
  {
    if (this.ahbl == null)
    {
      Iterator localIterator = this.ahbd.iterator();
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
      this.ahbl = new float[] { f2, f1 };
    }
    return this.ahbl;
  }
  
  public final HashMap<Character, Float> jQS()
  {
    return this.ahbc;
  }
  
  public final int pB(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 - this.ahbg);
    paramInt2 = (int)(paramInt2 - this.ahbh);
    Iterator localIterator = this.ahbd.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.jQL().contains(paramInt1, paramInt2)) {
        return localb.aGO(paramInt1);
      }
    }
    return this.ahaX.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.c
 * JD-Core Version:    0.7.0.1
 */