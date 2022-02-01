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
  public static final char[] Mav = { '…' };
  private static final String Maw = new String(Mav);
  protected float[] MaA;
  protected float[] MaB = new float[com.tencent.neattextview.textview.a.a.Mar.length];
  protected float[] MaC = new float[com.tencent.neattextview.textview.a.a.Mas.length];
  protected HashMap<Character, Float> MaD = new HashMap(com.tencent.neattextview.textview.a.a.Mar.length);
  public ArrayList<b> MaE = new ArrayList();
  private LinkedList<com.tencent.neattextview.textview.b.b> MaF = new LinkedList();
  private float MaG;
  private float MaH;
  private float MaI;
  private float MaJ;
  private float MaK;
  private int MaL;
  private TextPaint MaM = new TextPaint();
  private float[] MaN;
  e<ImageSpan> MaO = new e(ImageSpan.class);
  e<AbsoluteSizeSpan> MaP = new e(AbsoluteSizeSpan.class);
  e<RelativeSizeSpan> MaQ = new e(RelativeSizeSpan.class);
  private e<BackgroundColorSpan> MaR = new e(BackgroundColorSpan.class);
  e<ForegroundColorSpan> MaS = new e(ForegroundColorSpan.class);
  e<ClickableSpan> MaT = new e(ClickableSpan.class);
  e<LineBackgroundSpan> MaU = new e(LineBackgroundSpan.class);
  private float MaV = 0.0F;
  private LinkedList<com.tencent.neattextview.textview.b.c> MaW;
  protected boolean[] MaX;
  private int MaY = 0;
  private int MaZ = 0;
  protected String Max;
  protected char[] May;
  protected float[] Maz;
  private int Mba = 0;
  protected TextPaint ayp;
  private int bJg = 0;
  private TextUtils.TruncateAt gHJ;
  protected CharSequence mText;
  private float pDR;
  
  public c(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    this.mText = paramCharSequence;
    this.Max = paramCharSequence.toString();
    this.May = this.Max.toCharArray();
    if (paramArrayOfFloat != null)
    {
      this.Maz = new float[paramArrayOfFloat.length];
      System.arraycopy(paramArrayOfFloat, 0, this.Maz, 0, paramArrayOfFloat.length);
    }
  }
  
  private void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat, TextPaint paramTextPaint)
  {
    int i;
    label129:
    float f;
    if ((this.gHJ != null) && (this.gHJ != TextUtils.TruncateAt.MARQUEE)) {
      if ((this.mText != null) && (this.MaE.size() > 0) && ((this.mText.length() > ((b)this.MaE.get(this.MaE.size() - 1)).getEnd()) || ((this.MaK > 0.0F) && (fXl()[0] - ((b)this.MaE.get(this.MaE.size() - 1)).getWidth() < this.MaK))))
      {
        i = 1;
        if (i == 0) {
          break label327;
        }
        i = 1;
        if (i == 0) {
          break label415;
        }
        f = paramTextPaint.measureText(Maw) + paramTextPaint.getTextSize() / 6.0F + paramFloat;
        paramTextPaint = (b)this.MaE.get(this.MaE.size() - 1);
        this.Mba = (this.MaE.size() - 1);
        if ((this.bJg != 1) || (paramTruncateAt != TextUtils.TruncateAt.MIDDLE)) {
          break label348;
        }
        paramTruncateAt = (b)this.MaE.get(0);
        i = paramTruncateAt.getStart();
        paramFloat = 0.0F;
        label223:
        if (i >= paramTruncateAt.getEnd()) {
          break label342;
        }
        paramFloat += this.Maz[i];
        if (paramFloat < this.pDR / 2.0F) {
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
          paramFloat += this.Maz[i];
          if ((paramFloat < f) && (i != j))
          {
            this.Maz[i] = 0.0F;
            this.May[i] = '\000';
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
        this.MaZ = (this.May.length - i);
        this.Maz[i] = f;
        this.May[i] = Mav[0];
        this.MaY = (i - j);
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
      this.MaO.a((Spanned)localObject, i);
      this.MaP.a((Spanned)localObject, i);
      this.MaQ.a((Spanned)localObject, i);
      this.MaS.a((Spanned)localObject, i);
      this.MaR.a((Spanned)localObject, i);
      this.MaT.a((Spanned)localObject, i);
      this.MaU.a((Spanned)localObject, i);
    }
    this.MaM.set(paramTextPaint);
    int i = 0;
    int j;
    int m;
    int n;
    while (i < this.MaP.Mbr)
    {
      ((AbsoluteSizeSpan[])this.MaP.Mbs)[i].updateMeasureState(this.MaM);
      j = this.MaP.Mbt[i];
      m = this.MaP.Mbu[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.MaM.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.Maz, j, n);
      if (this.MaA == null) {
        this.MaA = new float[paramCharSequence.length()];
      }
      this.MaA[j] = this.MaM.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.MaQ.Mbr)
    {
      ((RelativeSizeSpan[])this.MaQ.Mbs)[i].updateMeasureState(this.MaM);
      j = this.MaQ.Mbt[i];
      m = this.MaQ.Mbu[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.MaM.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.Maz, j, n);
      if (this.MaA == null) {
        this.MaA = new float[paramCharSequence.length()];
      }
      this.MaA[j] = this.MaM.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.MaO.Mbr)
    {
      paramTextPaint = ((ImageSpan[])this.MaO.Mbs)[i];
      m = this.MaO.Mbt[i];
      n = this.MaO.Mbu[i];
      paramTextPaint = paramTextPaint.getDrawable();
      localObject = new Rect();
      if (paramTextPaint != null) {
        ((Rect)localObject).set(paramTextPaint.getBounds());
      }
      this.Maz[m] = ((Rect)localObject).width();
      paramArrayOfBoolean[m] = true;
      j = m + 1;
      while ((j < m + (n - m)) && (j < this.Maz.length))
      {
        this.Maz[j] = 0.0F;
        paramArrayOfBoolean[j] = true;
        j += 1;
      }
      if (this.MaA == null) {
        this.MaA = new float[paramCharSequence.length()];
      }
      this.MaA[m] = ((Rect)localObject).height();
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.MaR.Mbr) {
        break;
      }
      paramCharSequence = ((BackgroundColorSpan[])this.MaR.Mbs)[i];
      j = this.MaR.Mbt[i];
      m = this.MaR.Mbu[i];
      this.MaF.add(new com.tencent.neattextview.textview.b.a(j, m, paramCharSequence));
      i += 1;
    }
    while (j < this.MaT.Mbr)
    {
      paramCharSequence = ((ClickableSpan[])this.MaT.Mbs)[j];
      i = this.MaT.Mbt[j];
      k = this.MaT.Mbu[j];
      this.MaF.add(new com.tencent.neattextview.textview.b.c(i, k, paramCharSequence));
      j += 1;
    }
  }
  
  private void c(Paint paramPaint)
  {
    this.MaD.clear();
    Rect localRect = new Rect();
    char[] arrayOfChar = com.tencent.neattextview.textview.a.a.Mar;
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
      this.MaB[j] = (f1 - f2);
      j += 1;
      i += 1;
    }
    arrayOfChar = com.tencent.neattextview.textview.a.a.Mas;
    k = arrayOfChar.length;
    i = 0;
    j = 0;
    if (i < k)
    {
      paramPaint.getTextBounds(String.valueOf(arrayOfChar[i]), 0, 1, localRect);
      if (localRect.left > 0) {}
      for (f1 = localRect.left;; f1 = 0.0F)
      {
        this.MaC[j] = f1;
        this.MaD.put(Character.valueOf(com.tencent.neattextview.textview.a.a.Mas[j]), Float.valueOf(f1));
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
    Iterator localIterator = this.MaF.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.neattextview.textview.b.b)localIterator.next()).a(paramCanvas, this.ayp, this.MaE);
    }
    localIterator = this.MaE.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.a(paramCanvas, this.ayp, paramFloat1);
      paramFloat1 = localb.getHeight() + paramFloat1;
    }
    paramCanvas.restore();
  }
  
  public final void a(TextPaint paramTextPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, TextUtils.TruncateAt paramTruncateAt, float paramFloat6, boolean paramBoolean, int paramInt2)
  {
    this.ayp = new TextPaint(paramTextPaint);
    this.MaK = paramFloat6;
    this.MaG = paramFloat2;
    this.pDR = paramFloat1;
    this.MaH = paramFloat3;
    this.MaI = paramFloat4;
    this.bJg = paramInt1;
    this.gHJ = paramTruncateAt;
    this.MaJ = paramFloat5;
    this.MaN = null;
    this.MaL = paramInt2;
    paramInt2 = this.mText.length();
    if (this.Maz == null)
    {
      this.Maz = new float[paramInt2];
      paramTextPaint.getTextWidths(this.Max, this.Maz);
    }
    this.MaX = new boolean[paramInt2];
    a(this.mText, paramTextPaint, this.MaX);
    c(paramTextPaint);
    a(paramTextPaint, paramFloat1, paramInt1, paramBoolean);
    a(paramTruncateAt, paramFloat6, paramTextPaint);
  }
  
  protected abstract void a(TextPaint paramTextPaint, float paramFloat, int paramInt, boolean paramBoolean);
  
  protected final void a(char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, int paramInt3, float paramFloat2, boolean paramBoolean, float paramFloat3, float paramFloat4)
  {
    Paint.FontMetrics localFontMetrics = this.ayp.getFontMetrics();
    float f1 = localFontMetrics.bottom - localFontMetrics.top;
    float f2 = f1;
    if (this.MaA != null)
    {
      int i = paramInt1;
      for (;;)
      {
        f2 = f1;
        if (i >= paramInt2) {
          break;
        }
        f2 = f1;
        if (f1 < this.MaA[i]) {
          f2 = this.MaA[i];
        }
        i += 1;
        f1 = f2;
      }
    }
    f1 = f2 + this.MaJ;
    paramArrayOfChar = new d(this, paramArrayOfChar, paramInt1, paramInt2, this.MaV, paramArrayOfFloat, paramFloat1, f1, paramFloat2, this.ayp, paramBoolean, paramFloat3, paramInt3, this.MaL, paramFloat4);
    this.MaV += f1;
    this.MaE.add(paramArrayOfChar);
  }
  
  public final void ay(CharSequence paramCharSequence)
  {
    a(paramCharSequence, this.ayp, this.MaX);
  }
  
  public int fXb()
  {
    return this.MaE.size();
  }
  
  public final List<com.tencent.neattextview.textview.b.c> fXc()
  {
    if (this.MaW == null)
    {
      this.MaW = new LinkedList();
      Iterator localIterator = this.MaF.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.neattextview.textview.b.b localb = (com.tencent.neattextview.textview.b.b)localIterator.next();
        if (localb.getClass() == com.tencent.neattextview.textview.b.c.class) {
          this.MaW.add((com.tencent.neattextview.textview.b.c)localb);
        }
      }
    }
    return this.MaW;
  }
  
  public final float[] fXd()
  {
    return this.Maz;
  }
  
  public final String fXk()
  {
    return this.Max;
  }
  
  public final float[] fXl()
  {
    if (this.MaN == null)
    {
      Iterator localIterator = this.MaE.iterator();
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
      this.MaN = new float[] { f2, f1 };
    }
    return this.MaN;
  }
  
  public final HashMap<Character, Float> fXm()
  {
    return this.MaD;
  }
  
  public final int getEllipsisCount(int paramInt)
  {
    if (this.Mba == paramInt) {
      return this.MaZ;
    }
    return 0;
  }
  
  public final int getLineBaseline(int paramInt)
  {
    int i = this.MaE.size();
    if (i > paramInt) {}
    for (b localb = (b)this.MaE.get(paramInt);; localb = (b)this.MaE.get(i - 1))
    {
      return (int)localb.fXj();
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineBottom(int paramInt)
  {
    int i = this.MaE.size();
    if (i > paramInt) {}
    for (b localb = (b)this.MaE.get(paramInt);; localb = (b)this.MaE.get(i - 1))
    {
      return (int)localb.fXe().bottom;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineForOffset(int paramInt)
  {
    Iterator localIterator = this.MaE.iterator();
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
    int i = (int)(paramInt - this.MaI);
    Iterator localIterator = this.MaE.iterator();
    float f1 = 0.0F;
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (b)localIterator.next();
      float f2 = f1;
      if (f1 == 0.0F) {
        f2 = ((b)localObject).fXf().top;
      }
      localObject = ((b)localObject).fXf();
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
    if (this.MaE.size() > paramInt) {
      return ((b)this.MaE.get(paramInt)).fXe().right;
    }
    return 0.0F;
  }
  
  public final int getLineStart(int paramInt)
  {
    if (this.MaE.size() > paramInt) {
      return ((b)this.MaE.get(paramInt)).getStart();
    }
    return this.May.length;
  }
  
  public final int getLineTop(int paramInt)
  {
    int i = this.MaE.size();
    if (i > paramInt) {}
    for (b localb = (b)this.MaE.get(paramInt);; localb = (b)this.MaE.get(i - 1))
    {
      return (int)localb.fXe().top;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final float getLineWidth(int paramInt)
  {
    if (this.MaE.size() > paramInt) {
      return ((b)this.MaE.get(paramInt)).fXe().width();
    }
    return 0.0F;
  }
  
  public final int getOffsetForHorizontal(int paramInt, float paramFloat)
  {
    float f = this.MaH;
    if (this.MaE.size() > paramInt) {
      return ((b)this.MaE.get(paramInt)).ahf((int)(paramFloat - f));
    }
    return 0;
  }
  
  public final float getPrimaryHorizontal(int paramInt)
  {
    int i = getLineForOffset(paramInt);
    if (i < 0) {
      return 0.0F;
    }
    return ((b)this.MaE.get(i)).getPrimaryHorizontal(paramInt);
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  public final TextPaint getTextPaint()
  {
    return this.ayp;
  }
  
  public final int kO(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 - this.MaH);
    paramInt2 = (int)(paramInt2 - this.MaI);
    Iterator localIterator = this.MaE.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.fXf().contains(paramInt1, paramInt2)) {
        return localb.ahf(paramInt1);
      }
    }
    return this.May.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.c
 * JD-Core Version:    0.7.0.1
 */