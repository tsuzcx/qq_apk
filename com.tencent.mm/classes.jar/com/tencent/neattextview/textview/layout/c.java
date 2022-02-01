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
  public static final char[] RAN = { '…' };
  private static final String RAO = new String(RAN);
  private int AoL;
  protected String RAP;
  protected char[] RAQ;
  protected float[] RAR;
  protected float[] RAS;
  protected float[] RAT = new float[com.tencent.neattextview.textview.a.a.RAJ.length];
  protected float[] RAU = new float[com.tencent.neattextview.textview.a.a.RAK.length];
  protected HashMap<Character, Float> RAV = new HashMap(com.tencent.neattextview.textview.a.a.RAJ.length);
  public ArrayList<b> RAX = new ArrayList();
  private LinkedList<com.tencent.neattextview.textview.b.b> RAY = new LinkedList();
  private float RAZ;
  private float RBa;
  private float RBb;
  private float RBc;
  private float RBd;
  private TextPaint RBe = new TextPaint();
  private float[] RBf;
  e<ImageSpan> RBg = new e(ImageSpan.class);
  private e<LineHeightSpan> RBh = new e(LineHeightSpan.class);
  e<AbsoluteSizeSpan> RBi = new e(AbsoluteSizeSpan.class);
  e<RelativeSizeSpan> RBj = new e(RelativeSizeSpan.class);
  private e<BackgroundColorSpan> RBk = new e(BackgroundColorSpan.class);
  e<ForegroundColorSpan> RBl = new e(ForegroundColorSpan.class);
  e<ClickableSpan> RBm = new e(ClickableSpan.class);
  e<LineBackgroundSpan> RBn = new e(LineBackgroundSpan.class);
  private float RBo = 0.0F;
  private LinkedList<com.tencent.neattextview.textview.b.c> RBp;
  protected boolean[] RBq;
  private int RBr = 0;
  private int RBs = 0;
  private int RBt = 0;
  protected TextPaint ayn;
  private int bJw = 0;
  private TextUtils.TruncateAt hux;
  protected CharSequence mText;
  private float qTi;
  
  public c(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    this.mText = paramCharSequence;
    this.RAP = paramCharSequence.toString();
    this.RAQ = this.RAP.toCharArray();
    if (paramArrayOfFloat != null)
    {
      this.RAR = new float[paramArrayOfFloat.length];
      System.arraycopy(paramArrayOfFloat, 0, this.RAR, 0, paramArrayOfFloat.length);
    }
  }
  
  private void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat, TextPaint paramTextPaint)
  {
    int i;
    label115:
    float f1;
    if ((this.hux != null) && (this.hux != TextUtils.TruncateAt.MARQUEE))
    {
      i = this.RAX.size();
      if (i > 0)
      {
        b localb = (b)this.RAX.get(i - 1);
        if ((this.mText != null) && ((this.mText.length() > localb.getEnd()) || ((this.RBd > 0.0F) && (hiQ()[0] - localb.getWidth() < this.RBd))))
        {
          i = 1;
          if (i == 0) {
            break label331;
          }
          i = 1;
          if (i == 0) {
            break label492;
          }
          f1 = paramTextPaint.measureText(RAO) + paramFloat + paramTextPaint.getTextSize() / 6.0F;
          paramTextPaint = (b)this.RAX.get(this.RAX.size() - 1);
          this.RBt = (this.RAX.size() - 1);
          if ((this.bJw != 1) || (paramTruncateAt != TextUtils.TruncateAt.MIDDLE)) {
            break label352;
          }
          paramTruncateAt = (b)this.RAX.get(0);
          i = paramTruncateAt.getStart();
          paramFloat = 0.0F;
          label209:
          if (i >= paramTruncateAt.getEnd()) {
            break label346;
          }
          paramFloat += this.RAR[i];
          if (paramFloat < this.qTi / 2.0F) {
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
          paramFloat = this.qTi;
          float f2 = paramTextPaint.getPrimaryHorizontal(i);
          if (((this.RAR[i] <= 0.0F) || (paramFloat - f2 < f1)) && (i != k))
          {
            this.RAR[i] = 0.0F;
            this.RAQ[i] = '\000';
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
        while ((this.RBg.RBM != null) && (j < this.RBg.RBM.length))
        {
          if (this.RBg.RBM[j] == i)
          {
            this.RBg.RBM[j] = -1;
            this.RBg.RBN[j] = -1;
          }
          j += 1;
        }
        this.RBs = (this.RAQ.length - i);
        this.RAR[i] = f1;
        this.RAQ[i] = RAN[0];
        this.RBr = (i - k);
      }
      return;
      label492:
      this.RBs = 0;
      return;
      label498:
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
      this.RBg.a((Spanned)localObject, i);
      this.RBh.a((Spanned)localObject, i);
      this.RBi.a((Spanned)localObject, i);
      this.RBj.a((Spanned)localObject, i);
      this.RBl.a((Spanned)localObject, i);
      this.RBk.a((Spanned)localObject, i);
      this.RBm.a((Spanned)localObject, i);
      this.RBn.a((Spanned)localObject, i);
    }
    this.RBe.set(paramTextPaint);
    int i = 0;
    int j;
    int m;
    int n;
    while (i < this.RBi.RBK)
    {
      ((AbsoluteSizeSpan[])this.RBi.RBL)[i].updateMeasureState(this.RBe);
      j = this.RBi.RBM[i];
      m = this.RBi.RBN[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.RBe.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.RAR, j, n);
      if (this.RAS == null) {
        this.RAS = new float[paramCharSequence.length()];
      }
      paramTextPaint = this.RAS;
      paramTextPaint[j] = Math.max(paramTextPaint[j], this.RBe.getTextSize());
      i += 1;
    }
    i = 0;
    while (i < this.RBj.RBK)
    {
      ((RelativeSizeSpan[])this.RBj.RBL)[i].updateMeasureState(this.RBe);
      j = this.RBj.RBM[i];
      m = this.RBj.RBN[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.RBe.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.RAR, j, n);
      if (this.RAS == null) {
        this.RAS = new float[paramCharSequence.length()];
      }
      paramTextPaint = this.RAS;
      paramTextPaint[j] = Math.max(paramTextPaint[j], this.RBe.getTextSize());
      i += 1;
    }
    i = 0;
    while (i < this.RBh.RBK)
    {
      localObject = ((LineHeightSpan[])this.RBh.RBL)[i];
      j = this.RBh.RBM[i];
      m = this.RBh.RBN[i];
      if (this.RAS == null) {
        this.RAS = new float[paramCharSequence.length()];
      }
      paramTextPaint = this.ayn.getFontMetricsInt();
      ((LineHeightSpan)localObject).chooseHeight(paramCharSequence, j, m, 0, 0, paramTextPaint);
      localObject = this.RAS;
      localObject[j] = Math.max(localObject[j], paramTextPaint.descent - paramTextPaint.ascent);
      i += 1;
    }
    i = 0;
    while (i < this.RBg.RBK)
    {
      paramTextPaint = ((ImageSpan[])this.RBg.RBL)[i];
      m = this.RBg.RBM[i];
      n = this.RBg.RBN[i];
      localObject = paramTextPaint.getDrawable();
      paramTextPaint = new Rect();
      if (localObject != null) {
        paramTextPaint.set(((Drawable)localObject).getBounds());
      }
      this.RAR[m] = paramTextPaint.width();
      paramArrayOfBoolean[m] = true;
      j = m + 1;
      while ((j < m + (n - m)) && (j < this.RAR.length))
      {
        this.RAR[j] = 0.0F;
        paramArrayOfBoolean[j] = true;
        j += 1;
      }
      if (this.RAS == null) {
        this.RAS = new float[paramCharSequence.length()];
      }
      localObject = this.ayn.getFontMetrics();
      float f1 = ((Paint.FontMetrics)localObject).bottom;
      float f2 = ((Paint.FontMetrics)localObject).top;
      localObject = this.RAS;
      localObject[m] = Math.max(localObject[m], Math.max(f1 - f2, paramTextPaint.height()));
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.RBk.RBK) {
        break;
      }
      paramCharSequence = ((BackgroundColorSpan[])this.RBk.RBL)[i];
      j = this.RBk.RBM[i];
      m = this.RBk.RBN[i];
      this.RAY.add(new com.tencent.neattextview.textview.b.a(j, m, paramCharSequence));
      i += 1;
    }
    while (j < this.RBm.RBK)
    {
      paramCharSequence = ((ClickableSpan[])this.RBm.RBL)[j];
      i = this.RBm.RBM[j];
      k = this.RBm.RBN[j];
      this.RAY.add(new com.tencent.neattextview.textview.b.c(i, k, paramCharSequence));
      j += 1;
    }
  }
  
  private void c(Paint paramPaint)
  {
    this.RAV.clear();
    Rect localRect = new Rect();
    char[] arrayOfChar = com.tencent.neattextview.textview.a.a.RAJ;
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
      this.RAT[j] = (f1 - f2);
      j += 1;
      i += 1;
    }
    arrayOfChar = com.tencent.neattextview.textview.a.a.RAK;
    k = arrayOfChar.length;
    i = 0;
    j = 0;
    while (i < k)
    {
      paramPaint.getTextBounds(String.valueOf(arrayOfChar[i]), 0, 1, localRect);
      f1 = Math.max(localRect.left, 0);
      this.RAU[j] = f1;
      this.RAV.put(Character.valueOf(com.tencent.neattextview.textview.a.a.RAK[j]), Float.valueOf(f1));
      j += 1;
      i += 1;
    }
  }
  
  public final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramFloat1 = 0.0F;
    Iterator localIterator = this.RAY.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.neattextview.textview.b.b)localIterator.next()).a(paramCanvas, this.ayn, this.RAX);
    }
    localIterator = this.RAX.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.a(paramCanvas, this.ayn, paramFloat1);
      paramFloat1 = localb.getHeight() + paramFloat1;
    }
    paramCanvas.restore();
  }
  
  public final void a(TextPaint paramTextPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, TextUtils.TruncateAt paramTruncateAt, float paramFloat6, boolean paramBoolean, int paramInt2)
  {
    this.ayn = new TextPaint(paramTextPaint);
    this.RBd = paramFloat6;
    this.RAZ = paramFloat2;
    this.qTi = paramFloat1;
    this.RBa = paramFloat3;
    this.RBb = paramFloat4;
    this.bJw = paramInt1;
    this.hux = paramTruncateAt;
    this.RBc = paramFloat5;
    this.RBf = null;
    this.AoL = paramInt2;
    paramInt2 = this.mText.length();
    if (this.RAR == null)
    {
      this.RAR = new float[paramInt2];
      paramTextPaint.getTextWidths(this.RAP, this.RAR);
    }
    this.RBq = new boolean[paramInt2];
    a(this.mText, paramTextPaint, this.RBq);
    c(paramTextPaint);
    a(paramTextPaint, new float[0], paramFloat1, paramInt1, paramBoolean);
    a(paramTruncateAt, paramFloat6, paramTextPaint);
  }
  
  public final void a(TextPaint paramTextPaint, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, TextUtils.TruncateAt paramTruncateAt, float paramFloat6, boolean paramBoolean, int paramInt2)
  {
    this.ayn = new TextPaint(paramTextPaint);
    this.RBd = paramFloat6;
    this.RAZ = paramFloat2;
    this.qTi = paramFloat1;
    this.RBa = paramFloat3;
    this.RBb = paramFloat4;
    this.bJw = paramInt1;
    this.hux = paramTruncateAt;
    this.RBc = paramFloat5;
    this.RBf = null;
    this.AoL = paramInt2;
    paramInt2 = this.mText.length();
    if (this.RAR == null)
    {
      this.RAR = new float[paramInt2];
      paramTextPaint.getTextWidths(this.RAP, this.RAR);
    }
    this.RBq = new boolean[paramInt2];
    a(this.mText, paramTextPaint, this.RBq);
    c(paramTextPaint);
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
    Paint.FontMetrics localFontMetrics = this.ayn.getFontMetrics();
    float f1 = localFontMetrics.bottom - localFontMetrics.top;
    float f2 = f1;
    int i;
    if (this.RAS != null)
    {
      i = paramInt1;
      f2 = f1;
      if (i < paramInt2)
      {
        f2 = this.RAS[i];
        if (f2 <= 0.0F) {
          break label145;
        }
        f1 = f2;
      }
    }
    label145:
    for (;;)
    {
      i += 1;
      break;
      f1 = f2 + this.RBc;
      paramArrayOfChar = new d(this, paramArrayOfChar, paramInt1, paramInt2, this.RBo, paramArrayOfFloat, paramFloat1, f1, paramFloat2, this.ayn, paramBoolean, paramFloat3, paramInt3, this.AoL, paramFloat4);
      this.RBo += f1;
      this.RAX.add(paramArrayOfChar);
      return;
    }
  }
  
  public final void aG(CharSequence paramCharSequence)
  {
    a(paramCharSequence, this.ayn, this.RBq);
  }
  
  public final int getEllipsisCount(int paramInt)
  {
    if (this.RBt == paramInt) {
      return this.RBs;
    }
    return 0;
  }
  
  public final int getEllipsisStart(int paramInt)
  {
    if (this.RBt == paramInt) {
      return this.RBr;
    }
    return 0;
  }
  
  public final int getLineBaseline(int paramInt)
  {
    int i = this.RAX.size();
    if (i > paramInt) {}
    for (b localb = (b)this.RAX.get(paramInt);; localb = (b)this.RAX.get(i - 1))
    {
      return (int)localb.hiO();
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineBottom(int paramInt)
  {
    int i = this.RAX.size();
    if (i > paramInt) {}
    for (b localb = (b)this.RAX.get(paramInt);; localb = (b)this.RAX.get(i - 1))
    {
      return (int)localb.hiJ().bottom;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineForOffset(int paramInt)
  {
    Iterator localIterator = this.RAX.iterator();
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
    int i = (int)(paramInt - this.RBb);
    Iterator localIterator = this.RAX.iterator();
    float f1 = 0.0F;
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (b)localIterator.next();
      float f2 = f1;
      if (f1 == 0.0F) {
        f2 = ((b)localObject).hiK().top;
      }
      localObject = ((b)localObject).hiK();
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
    if (this.RAX.size() > paramInt) {
      return ((b)this.RAX.get(paramInt)).hiJ().right;
    }
    return 0.0F;
  }
  
  public final int getLineStart(int paramInt)
  {
    if (this.RAX.size() > paramInt) {
      return ((b)this.RAX.get(paramInt)).getStart();
    }
    return this.RAQ.length;
  }
  
  public final int getLineTop(int paramInt)
  {
    int i = this.RAX.size();
    if (i > paramInt) {}
    for (b localb = (b)this.RAX.get(paramInt);; localb = (b)this.RAX.get(i - 1))
    {
      return (int)localb.hiJ().top;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final float getLineWidth(int paramInt)
  {
    if (this.RAX.size() > paramInt) {
      return ((b)this.RAX.get(paramInt)).hiJ().width();
    }
    return 0.0F;
  }
  
  public final int getOffsetForHorizontal(int paramInt, float paramFloat)
  {
    float f = this.RBa;
    if (this.RAX.size() > paramInt) {
      return ((b)this.RAX.get(paramInt)).aqs((int)(paramFloat - f));
    }
    return 0;
  }
  
  public final float getPrimaryHorizontal(int paramInt)
  {
    int i = getLineForOffset(paramInt);
    if (i < 0) {
      return 0.0F;
    }
    return ((b)this.RAX.get(i)).getPrimaryHorizontal(paramInt);
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  public final TextPaint getTextPaint()
  {
    return this.ayn;
  }
  
  public int hiG()
  {
    return this.RAX.size();
  }
  
  public final List<com.tencent.neattextview.textview.b.c> hiH()
  {
    if (this.RBp == null)
    {
      this.RBp = new LinkedList();
      Iterator localIterator = this.RAY.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.neattextview.textview.b.b localb = (com.tencent.neattextview.textview.b.b)localIterator.next();
        if (localb.getClass() == com.tencent.neattextview.textview.b.c.class) {
          this.RBp.add((com.tencent.neattextview.textview.b.c)localb);
        }
      }
    }
    return this.RBp;
  }
  
  public final float[] hiI()
  {
    return this.RAR;
  }
  
  public final String hiP()
  {
    return this.RAP;
  }
  
  public final float[] hiQ()
  {
    if (this.RBf == null)
    {
      Iterator localIterator = this.RAX.iterator();
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
      this.RBf = new float[] { f2, f1 };
    }
    return this.RBf;
  }
  
  public final HashMap<Character, Float> hiR()
  {
    return this.RAV;
  }
  
  public final int mn(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 - this.RBa);
    paramInt2 = (int)(paramInt2 - this.RBb);
    Iterator localIterator = this.RAX.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.hiK().contains(paramInt1, paramInt2)) {
        return localb.aqs(paramInt1);
      }
    }
    return this.RAQ.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.c
 * JD-Core Version:    0.7.0.1
 */