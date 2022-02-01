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
  public static final char[] LDr = { '…' };
  private static final String LDs = new String(LDr);
  public ArrayList<b> LDA = new ArrayList();
  private LinkedList<com.tencent.neattextview.textview.b.b> LDB = new LinkedList();
  private float LDC;
  private float LDD;
  private float LDE;
  private float LDF;
  private float LDG;
  private int LDH;
  private TextPaint LDI = new TextPaint();
  private float[] LDJ;
  e<ImageSpan> LDK = new e(ImageSpan.class);
  e<AbsoluteSizeSpan> LDL = new e(AbsoluteSizeSpan.class);
  e<RelativeSizeSpan> LDM = new e(RelativeSizeSpan.class);
  private e<BackgroundColorSpan> LDN = new e(BackgroundColorSpan.class);
  e<ForegroundColorSpan> LDO = new e(ForegroundColorSpan.class);
  e<ClickableSpan> LDP = new e(ClickableSpan.class);
  e<LineBackgroundSpan> LDQ = new e(LineBackgroundSpan.class);
  private float LDR = 0.0F;
  private LinkedList<com.tencent.neattextview.textview.b.c> LDS;
  protected boolean[] LDT;
  private int LDU = 0;
  private int LDV = 0;
  private int LDW = 0;
  protected String LDt;
  protected char[] LDu;
  protected float[] LDv;
  protected float[] LDw;
  protected float[] LDx = new float[com.tencent.neattextview.textview.a.a.LDn.length];
  protected float[] LDy = new float[com.tencent.neattextview.textview.a.a.LDo.length];
  protected HashMap<Character, Float> LDz = new HashMap(com.tencent.neattextview.textview.a.a.LDn.length);
  protected TextPaint ayp;
  private int bJg = 0;
  private TextUtils.TruncateAt gFc;
  protected CharSequence mText;
  private float pxn;
  
  public c(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    this.mText = paramCharSequence;
    this.LDt = paramCharSequence.toString();
    this.LDu = this.LDt.toCharArray();
    if (paramArrayOfFloat != null)
    {
      this.LDv = new float[paramArrayOfFloat.length];
      System.arraycopy(paramArrayOfFloat, 0, this.LDv, 0, paramArrayOfFloat.length);
    }
  }
  
  private void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat, TextPaint paramTextPaint)
  {
    int i;
    label129:
    float f;
    if ((this.gFc != null) && (this.gFc != TextUtils.TruncateAt.MARQUEE)) {
      if ((this.mText != null) && (this.LDA.size() > 0) && ((this.mText.length() > ((b)this.LDA.get(this.LDA.size() - 1)).getEnd()) || ((this.LDG > 0.0F) && (fSL()[0] - ((b)this.LDA.get(this.LDA.size() - 1)).getWidth() < this.LDG))))
      {
        i = 1;
        if (i == 0) {
          break label327;
        }
        i = 1;
        if (i == 0) {
          break label415;
        }
        f = paramTextPaint.measureText(LDs) + paramTextPaint.getTextSize() / 6.0F + paramFloat;
        paramTextPaint = (b)this.LDA.get(this.LDA.size() - 1);
        this.LDW = (this.LDA.size() - 1);
        if ((this.bJg != 1) || (paramTruncateAt != TextUtils.TruncateAt.MIDDLE)) {
          break label348;
        }
        paramTruncateAt = (b)this.LDA.get(0);
        i = paramTruncateAt.getStart();
        paramFloat = 0.0F;
        label223:
        if (i >= paramTruncateAt.getEnd()) {
          break label342;
        }
        paramFloat += this.LDv[i];
        if (paramFloat < this.pxn / 2.0F) {
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
          paramFloat += this.LDv[i];
          if ((paramFloat < f) && (i != j))
          {
            this.LDv[i] = 0.0F;
            this.LDu[i] = '\000';
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
        this.LDV = (this.LDu.length - i);
        this.LDv[i] = f;
        this.LDu[i] = LDr[0];
        this.LDU = (i - j);
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
      this.LDK.a((Spanned)localObject, i);
      this.LDL.a((Spanned)localObject, i);
      this.LDM.a((Spanned)localObject, i);
      this.LDO.a((Spanned)localObject, i);
      this.LDN.a((Spanned)localObject, i);
      this.LDP.a((Spanned)localObject, i);
      this.LDQ.a((Spanned)localObject, i);
    }
    this.LDI.set(paramTextPaint);
    int i = 0;
    int j;
    int m;
    int n;
    while (i < this.LDL.LEn)
    {
      ((AbsoluteSizeSpan[])this.LDL.LEo)[i].updateMeasureState(this.LDI);
      j = this.LDL.LEp[i];
      m = this.LDL.LEq[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.LDI.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.LDv, j, n);
      if (this.LDw == null) {
        this.LDw = new float[paramCharSequence.length()];
      }
      this.LDw[j] = this.LDI.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.LDM.LEn)
    {
      ((RelativeSizeSpan[])this.LDM.LEo)[i].updateMeasureState(this.LDI);
      j = this.LDM.LEp[i];
      m = this.LDM.LEq[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.LDI.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.LDv, j, n);
      if (this.LDw == null) {
        this.LDw = new float[paramCharSequence.length()];
      }
      this.LDw[j] = this.LDI.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.LDK.LEn)
    {
      paramTextPaint = ((ImageSpan[])this.LDK.LEo)[i];
      m = this.LDK.LEp[i];
      n = this.LDK.LEq[i];
      paramTextPaint = paramTextPaint.getDrawable();
      localObject = new Rect();
      if (paramTextPaint != null) {
        ((Rect)localObject).set(paramTextPaint.getBounds());
      }
      this.LDv[m] = ((Rect)localObject).width();
      paramArrayOfBoolean[m] = true;
      j = m + 1;
      while ((j < m + (n - m)) && (j < this.LDv.length))
      {
        this.LDv[j] = 0.0F;
        paramArrayOfBoolean[j] = true;
        j += 1;
      }
      if (this.LDw == null) {
        this.LDw = new float[paramCharSequence.length()];
      }
      this.LDw[m] = ((Rect)localObject).height();
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.LDN.LEn) {
        break;
      }
      paramCharSequence = ((BackgroundColorSpan[])this.LDN.LEo)[i];
      j = this.LDN.LEp[i];
      m = this.LDN.LEq[i];
      this.LDB.add(new com.tencent.neattextview.textview.b.a(j, m, paramCharSequence));
      i += 1;
    }
    while (j < this.LDP.LEn)
    {
      paramCharSequence = ((ClickableSpan[])this.LDP.LEo)[j];
      i = this.LDP.LEp[j];
      k = this.LDP.LEq[j];
      this.LDB.add(new com.tencent.neattextview.textview.b.c(i, k, paramCharSequence));
      j += 1;
    }
  }
  
  private void c(Paint paramPaint)
  {
    this.LDz.clear();
    Rect localRect = new Rect();
    char[] arrayOfChar = com.tencent.neattextview.textview.a.a.LDn;
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
      this.LDx[j] = (f1 - f2);
      j += 1;
      i += 1;
    }
    arrayOfChar = com.tencent.neattextview.textview.a.a.LDo;
    k = arrayOfChar.length;
    i = 0;
    j = 0;
    if (i < k)
    {
      paramPaint.getTextBounds(String.valueOf(arrayOfChar[i]), 0, 1, localRect);
      if (localRect.left > 0) {}
      for (f1 = localRect.left;; f1 = 0.0F)
      {
        this.LDy[j] = f1;
        this.LDz.put(Character.valueOf(com.tencent.neattextview.textview.a.a.LDo[j]), Float.valueOf(f1));
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
    Iterator localIterator = this.LDB.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.neattextview.textview.b.b)localIterator.next()).a(paramCanvas, this.ayp, this.LDA);
    }
    localIterator = this.LDA.iterator();
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
    this.LDG = paramFloat6;
    this.LDC = paramFloat2;
    this.pxn = paramFloat1;
    this.LDD = paramFloat3;
    this.LDE = paramFloat4;
    this.bJg = paramInt1;
    this.gFc = paramTruncateAt;
    this.LDF = paramFloat5;
    this.LDJ = null;
    this.LDH = paramInt2;
    paramInt2 = this.mText.length();
    if (this.LDv == null)
    {
      this.LDv = new float[paramInt2];
      paramTextPaint.getTextWidths(this.LDt, this.LDv);
    }
    this.LDT = new boolean[paramInt2];
    a(this.mText, paramTextPaint, this.LDT);
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
    if (this.LDw != null)
    {
      int i = paramInt1;
      for (;;)
      {
        f2 = f1;
        if (i >= paramInt2) {
          break;
        }
        f2 = f1;
        if (f1 < this.LDw[i]) {
          f2 = this.LDw[i];
        }
        i += 1;
        f1 = f2;
      }
    }
    f1 = f2 + this.LDF;
    paramArrayOfChar = new d(this, paramArrayOfChar, paramInt1, paramInt2, this.LDR, paramArrayOfFloat, paramFloat1, f1, paramFloat2, this.ayp, paramBoolean, paramFloat3, paramInt3, this.LDH, paramFloat4);
    this.LDR += f1;
    this.LDA.add(paramArrayOfChar);
  }
  
  public final void az(CharSequence paramCharSequence)
  {
    a(paramCharSequence, this.ayp, this.LDT);
  }
  
  public int fSB()
  {
    return this.LDA.size();
  }
  
  public final List<com.tencent.neattextview.textview.b.c> fSC()
  {
    if (this.LDS == null)
    {
      this.LDS = new LinkedList();
      Iterator localIterator = this.LDB.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.neattextview.textview.b.b localb = (com.tencent.neattextview.textview.b.b)localIterator.next();
        if (localb.getClass() == com.tencent.neattextview.textview.b.c.class) {
          this.LDS.add((com.tencent.neattextview.textview.b.c)localb);
        }
      }
    }
    return this.LDS;
  }
  
  public final float[] fSD()
  {
    return this.LDv;
  }
  
  public final String fSK()
  {
    return this.LDt;
  }
  
  public final float[] fSL()
  {
    if (this.LDJ == null)
    {
      Iterator localIterator = this.LDA.iterator();
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
      this.LDJ = new float[] { f2, f1 };
    }
    return this.LDJ;
  }
  
  public final HashMap<Character, Float> fSM()
  {
    return this.LDz;
  }
  
  public final int getEllipsisCount(int paramInt)
  {
    if (this.LDW == paramInt) {
      return this.LDV;
    }
    return 0;
  }
  
  public final int getLineBaseline(int paramInt)
  {
    int i = this.LDA.size();
    if (i > paramInt) {}
    for (b localb = (b)this.LDA.get(paramInt);; localb = (b)this.LDA.get(i - 1))
    {
      return (int)localb.fSJ();
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineBottom(int paramInt)
  {
    int i = this.LDA.size();
    if (i > paramInt) {}
    for (b localb = (b)this.LDA.get(paramInt);; localb = (b)this.LDA.get(i - 1))
    {
      return (int)localb.fSE().bottom;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineForOffset(int paramInt)
  {
    Iterator localIterator = this.LDA.iterator();
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
    int i = (int)(paramInt - this.LDE);
    Iterator localIterator = this.LDA.iterator();
    float f1 = 0.0F;
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (b)localIterator.next();
      float f2 = f1;
      if (f1 == 0.0F) {
        f2 = ((b)localObject).fSF().top;
      }
      localObject = ((b)localObject).fSF();
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
    if (this.LDA.size() > paramInt) {
      return ((b)this.LDA.get(paramInt)).fSE().right;
    }
    return 0.0F;
  }
  
  public final int getLineStart(int paramInt)
  {
    if (this.LDA.size() > paramInt) {
      return ((b)this.LDA.get(paramInt)).getStart();
    }
    return this.LDu.length;
  }
  
  public final int getLineTop(int paramInt)
  {
    int i = this.LDA.size();
    if (i > paramInt) {}
    for (b localb = (b)this.LDA.get(paramInt);; localb = (b)this.LDA.get(i - 1))
    {
      return (int)localb.fSE().top;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final float getLineWidth(int paramInt)
  {
    if (this.LDA.size() > paramInt) {
      return ((b)this.LDA.get(paramInt)).fSE().width();
    }
    return 0.0F;
  }
  
  public final int getOffsetForHorizontal(int paramInt, float paramFloat)
  {
    float f = this.LDD;
    if (this.LDA.size() > paramInt) {
      return ((b)this.LDA.get(paramInt)).agw((int)(paramFloat - f));
    }
    return 0;
  }
  
  public final float getPrimaryHorizontal(int paramInt)
  {
    int i = getLineForOffset(paramInt);
    if (i < 0) {
      return 0.0F;
    }
    return ((b)this.LDA.get(i)).getPrimaryHorizontal(paramInt);
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  public final TextPaint getTextPaint()
  {
    return this.ayp;
  }
  
  public final int kH(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 - this.LDD);
    paramInt2 = (int)(paramInt2 - this.LDE);
    Iterator localIterator = this.LDA.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.fSF().contains(paramInt1, paramInt2)) {
        return localb.agw(paramInt1);
      }
    }
    return this.LDu.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.c
 * JD-Core Version:    0.7.0.1
 */