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
  public static final char[] IhZ = { '…' };
  private static final String Iia = new String(IhZ);
  private int IiA = 0;
  private int IiB = 0;
  private int IiC = 0;
  protected String Iib;
  protected char[] Iic;
  protected float[] Iid;
  protected float[] Iie;
  protected float[] Iif = new float[com.tencent.neattextview.textview.a.a.IhV.length];
  protected float[] Iig = new float[com.tencent.neattextview.textview.a.a.IhW.length];
  protected HashMap<Character, Float> Iih = new HashMap(com.tencent.neattextview.textview.a.a.IhV.length);
  public ArrayList<b> Iii = new ArrayList();
  private LinkedList<com.tencent.neattextview.textview.b.b> Iij = new LinkedList();
  private float Iik;
  private float Iil;
  private float Iim;
  private int Iin;
  private TextPaint Iio = new TextPaint();
  private float[] Iip;
  e<ImageSpan> Iiq = new e(ImageSpan.class);
  e<AbsoluteSizeSpan> Iir = new e(AbsoluteSizeSpan.class);
  e<RelativeSizeSpan> Iis = new e(RelativeSizeSpan.class);
  private e<BackgroundColorSpan> Iit = new e(BackgroundColorSpan.class);
  e<ForegroundColorSpan> Iiu = new e(ForegroundColorSpan.class);
  e<ClickableSpan> Iiv = new e(ClickableSpan.class);
  e<LineBackgroundSpan> Iiw = new e(LineBackgroundSpan.class);
  private float Iix = 0.0F;
  private LinkedList<com.tencent.neattextview.textview.b.c> Iiy;
  protected boolean[] Iiz;
  protected TextPaint avD;
  private int bBk = 0;
  private TextUtils.TruncateAt ggM;
  private float mPaddingLeft;
  private float mPaddingTop;
  protected CharSequence mText;
  private float oqd;
  
  public c(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    this.mText = paramCharSequence;
    this.Iib = paramCharSequence.toString();
    this.Iic = this.Iib.toCharArray();
    if (paramArrayOfFloat != null)
    {
      this.Iid = new float[paramArrayOfFloat.length];
      System.arraycopy(paramArrayOfFloat, 0, this.Iid, 0, paramArrayOfFloat.length);
    }
  }
  
  private void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat, TextPaint paramTextPaint)
  {
    int i;
    label129:
    float f;
    if ((this.ggM != null) && (this.ggM != TextUtils.TruncateAt.MARQUEE)) {
      if ((this.mText != null) && (this.Iii.size() > 0) && ((this.mText.length() > ((b)this.Iii.get(this.Iii.size() - 1)).getEnd()) || ((this.Iim > 0.0F) && (flf()[0] - ((b)this.Iii.get(this.Iii.size() - 1)).getWidth() < this.Iim))))
      {
        i = 1;
        if (i == 0) {
          break label327;
        }
        i = 1;
        if (i == 0) {
          break label415;
        }
        f = paramTextPaint.measureText(Iia) + paramTextPaint.getTextSize() / 6.0F + paramFloat;
        paramTextPaint = (b)this.Iii.get(this.Iii.size() - 1);
        this.IiC = (this.Iii.size() - 1);
        if ((this.bBk != 1) || (paramTruncateAt != TextUtils.TruncateAt.MIDDLE)) {
          break label348;
        }
        paramTruncateAt = (b)this.Iii.get(0);
        i = paramTruncateAt.getStart();
        paramFloat = 0.0F;
        label223:
        if (i >= paramTruncateAt.getEnd()) {
          break label342;
        }
        paramFloat += this.Iid[i];
        if (paramFloat < this.oqd / 2.0F) {
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
          paramFloat += this.Iid[i];
          if ((paramFloat < f) && (i != j))
          {
            this.Iid[i] = 0.0F;
            this.Iic[i] = '\000';
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
        this.IiB = (this.Iic.length - i);
        this.Iid[i] = f;
        this.Iic[i] = IhZ[0];
        this.IiA = (i - j);
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
      this.Iiq.a((Spanned)localObject, i);
      this.Iir.a((Spanned)localObject, i);
      this.Iis.a((Spanned)localObject, i);
      this.Iiu.a((Spanned)localObject, i);
      this.Iit.a((Spanned)localObject, i);
      this.Iiv.a((Spanned)localObject, i);
      this.Iiw.a((Spanned)localObject, i);
    }
    this.Iio.set(paramTextPaint);
    int i = 0;
    int j;
    int m;
    int n;
    while (i < this.Iir.IiT)
    {
      ((AbsoluteSizeSpan[])this.Iir.IiU)[i].updateMeasureState(this.Iio);
      j = this.Iir.IiV[i];
      m = this.Iir.IiW[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.Iio.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.Iid, j, n);
      if (this.Iie == null) {
        this.Iie = new float[paramCharSequence.length()];
      }
      this.Iie[j] = this.Iio.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.Iis.IiT)
    {
      ((RelativeSizeSpan[])this.Iis.IiU)[i].updateMeasureState(this.Iio);
      j = this.Iis.IiV[i];
      m = this.Iis.IiW[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.Iio.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.Iid, j, n);
      if (this.Iie == null) {
        this.Iie = new float[paramCharSequence.length()];
      }
      this.Iie[j] = this.Iio.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.Iiq.IiT)
    {
      paramTextPaint = ((ImageSpan[])this.Iiq.IiU)[i];
      m = this.Iiq.IiV[i];
      n = this.Iiq.IiW[i];
      paramTextPaint = paramTextPaint.getDrawable();
      localObject = new Rect();
      if (paramTextPaint != null) {
        ((Rect)localObject).set(paramTextPaint.getBounds());
      }
      this.Iid[m] = ((Rect)localObject).width();
      paramArrayOfBoolean[m] = true;
      j = m + 1;
      while ((j < m + (n - m)) && (j < this.Iid.length))
      {
        this.Iid[j] = 0.0F;
        paramArrayOfBoolean[j] = true;
        j += 1;
      }
      if (this.Iie == null) {
        this.Iie = new float[paramCharSequence.length()];
      }
      this.Iie[m] = ((Rect)localObject).height();
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.Iit.IiT) {
        break;
      }
      paramCharSequence = ((BackgroundColorSpan[])this.Iit.IiU)[i];
      j = this.Iit.IiV[i];
      m = this.Iit.IiW[i];
      this.Iij.add(new com.tencent.neattextview.textview.b.a(j, m, paramCharSequence));
      i += 1;
    }
    while (j < this.Iiv.IiT)
    {
      paramCharSequence = ((ClickableSpan[])this.Iiv.IiU)[j];
      i = this.Iiv.IiV[j];
      k = this.Iiv.IiW[j];
      this.Iij.add(new com.tencent.neattextview.textview.b.c(i, k, paramCharSequence));
      j += 1;
    }
  }
  
  private void b(Paint paramPaint)
  {
    this.Iih.clear();
    Rect localRect = new Rect();
    char[] arrayOfChar = com.tencent.neattextview.textview.a.a.IhV;
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
      this.Iif[j] = (f1 - f2);
      j += 1;
      i += 1;
    }
    arrayOfChar = com.tencent.neattextview.textview.a.a.IhW;
    k = arrayOfChar.length;
    i = 0;
    j = 0;
    if (i < k)
    {
      paramPaint.getTextBounds(String.valueOf(arrayOfChar[i]), 0, 1, localRect);
      if (localRect.left > 0) {}
      for (f1 = localRect.left;; f1 = 0.0F)
      {
        this.Iig[j] = f1;
        this.Iih.put(Character.valueOf(com.tencent.neattextview.textview.a.a.IhW[j]), Float.valueOf(f1));
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
    Iterator localIterator = this.Iij.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.neattextview.textview.b.b)localIterator.next()).a(paramCanvas, this.avD, this.Iii);
    }
    localIterator = this.Iii.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.a(paramCanvas, this.avD, paramFloat1);
      paramFloat1 = localb.getHeight() + paramFloat1;
    }
    paramCanvas.restore();
  }
  
  public final void a(TextPaint paramTextPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, TextUtils.TruncateAt paramTruncateAt, float paramFloat6, boolean paramBoolean, int paramInt2)
  {
    this.avD = new TextPaint(paramTextPaint);
    this.Iim = paramFloat6;
    this.Iik = paramFloat2;
    this.oqd = paramFloat1;
    this.mPaddingLeft = paramFloat3;
    this.mPaddingTop = paramFloat4;
    this.bBk = paramInt1;
    this.ggM = paramTruncateAt;
    this.Iil = paramFloat5;
    this.Iip = null;
    this.Iin = paramInt2;
    paramInt2 = this.mText.length();
    if (this.Iid == null)
    {
      this.Iid = new float[paramInt2];
      paramTextPaint.getTextWidths(this.Iib, this.Iid);
    }
    this.Iiz = new boolean[paramInt2];
    a(this.mText, paramTextPaint, this.Iiz);
    b(paramTextPaint);
    a(paramTextPaint, paramFloat1, paramInt1, paramBoolean);
    a(paramTruncateAt, paramFloat6, paramTextPaint);
  }
  
  protected abstract void a(TextPaint paramTextPaint, float paramFloat, int paramInt, boolean paramBoolean);
  
  protected final void a(char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, int paramInt3, float paramFloat2, boolean paramBoolean, float paramFloat3, float paramFloat4)
  {
    Paint.FontMetrics localFontMetrics = this.avD.getFontMetrics();
    float f1 = localFontMetrics.bottom - localFontMetrics.top;
    float f2 = f1;
    if (this.Iie != null)
    {
      int i = paramInt1;
      for (;;)
      {
        f2 = f1;
        if (i >= paramInt2) {
          break;
        }
        f2 = f1;
        if (f1 < this.Iie[i]) {
          f2 = this.Iie[i];
        }
        i += 1;
        f1 = f2;
      }
    }
    f1 = f2 + this.Iil;
    paramArrayOfChar = new d(this, paramArrayOfChar, paramInt1, paramInt2, this.Iix, paramArrayOfFloat, paramFloat1, f1, paramFloat2, this.avD, paramBoolean, paramFloat3, paramInt3, this.Iin, paramFloat4);
    this.Iix += f1;
    this.Iii.add(paramArrayOfChar);
  }
  
  public final void ax(CharSequence paramCharSequence)
  {
    a(paramCharSequence, this.avD, this.Iiz);
  }
  
  public int fkV()
  {
    return this.Iii.size();
  }
  
  public final List<com.tencent.neattextview.textview.b.c> fkW()
  {
    if (this.Iiy == null)
    {
      this.Iiy = new LinkedList();
      Iterator localIterator = this.Iij.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.neattextview.textview.b.b localb = (com.tencent.neattextview.textview.b.b)localIterator.next();
        if (localb.getClass() == com.tencent.neattextview.textview.b.c.class) {
          this.Iiy.add((com.tencent.neattextview.textview.b.c)localb);
        }
      }
    }
    return this.Iiy;
  }
  
  public final float[] fkX()
  {
    return this.Iid;
  }
  
  public final String fle()
  {
    return this.Iib;
  }
  
  public final float[] flf()
  {
    if (this.Iip == null)
    {
      Iterator localIterator = this.Iii.iterator();
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
      this.Iip = new float[] { f2, f1 };
    }
    return this.Iip;
  }
  
  public final HashMap<Character, Float> flg()
  {
    return this.Iih;
  }
  
  public final int getEllipsisCount(int paramInt)
  {
    if (this.IiC == paramInt) {
      return this.IiB;
    }
    return 0;
  }
  
  public final int getLineBaseline(int paramInt)
  {
    int i = this.Iii.size();
    if (i > paramInt) {}
    for (b localb = (b)this.Iii.get(paramInt);; localb = (b)this.Iii.get(i - 1))
    {
      return (int)localb.fld();
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineBottom(int paramInt)
  {
    int i = this.Iii.size();
    if (i > paramInt) {}
    for (b localb = (b)this.Iii.get(paramInt);; localb = (b)this.Iii.get(i - 1))
    {
      return (int)localb.fkY().bottom;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineForOffset(int paramInt)
  {
    Iterator localIterator = this.Iii.iterator();
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
    int i = (int)(paramInt - this.mPaddingTop);
    Iterator localIterator = this.Iii.iterator();
    float f1 = 0.0F;
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (b)localIterator.next();
      float f2 = f1;
      if (f1 == 0.0F) {
        f2 = ((b)localObject).fkZ().top;
      }
      localObject = ((b)localObject).fkZ();
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
    if (this.Iii.size() > paramInt) {
      return ((b)this.Iii.get(paramInt)).fkY().right;
    }
    return 0.0F;
  }
  
  public final int getLineStart(int paramInt)
  {
    if (this.Iii.size() > paramInt) {
      return ((b)this.Iii.get(paramInt)).getStart();
    }
    return this.Iic.length;
  }
  
  public final int getLineTop(int paramInt)
  {
    int i = this.Iii.size();
    if (i > paramInt) {}
    for (b localb = (b)this.Iii.get(paramInt);; localb = (b)this.Iii.get(i - 1))
    {
      return (int)localb.fkY().top;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final float getLineWidth(int paramInt)
  {
    if (this.Iii.size() > paramInt) {
      return ((b)this.Iii.get(paramInt)).fkY().width();
    }
    return 0.0F;
  }
  
  public final int getOffsetForHorizontal(int paramInt, float paramFloat)
  {
    float f = this.mPaddingLeft;
    if (this.Iii.size() > paramInt) {
      return ((b)this.Iii.get(paramInt)).abD((int)(paramFloat - f));
    }
    return 0;
  }
  
  public final float getPrimaryHorizontal(int paramInt)
  {
    int i = getLineForOffset(paramInt);
    if (i < 0) {
      return 0.0F;
    }
    return ((b)this.Iii.get(i)).getPrimaryHorizontal(paramInt);
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  public final TextPaint getTextPaint()
  {
    return this.avD;
  }
  
  public final int kf(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 - this.mPaddingLeft);
    paramInt2 = (int)(paramInt2 - this.mPaddingTop);
    Iterator localIterator = this.Iii.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.fkZ().contains(paramInt1, paramInt2)) {
        return localb.abD(paramInt1);
      }
    }
    return this.Iic.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.c
 * JD-Core Version:    0.7.0.1
 */