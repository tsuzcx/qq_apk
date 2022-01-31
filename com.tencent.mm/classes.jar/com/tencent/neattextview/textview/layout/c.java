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
  private static final char[] Bbk = { '…' };
  private static final String Bbl = new String(Bbk);
  e<ImageSpan> BbA = new e(ImageSpan.class);
  e<AbsoluteSizeSpan> BbB = new e(AbsoluteSizeSpan.class);
  e<RelativeSizeSpan> BbC = new e(RelativeSizeSpan.class);
  private e<BackgroundColorSpan> BbD = new e(BackgroundColorSpan.class);
  e<ForegroundColorSpan> BbE = new e(ForegroundColorSpan.class);
  e<ClickableSpan> BbF = new e(ClickableSpan.class);
  e<LineBackgroundSpan> BbG = new e(LineBackgroundSpan.class);
  private float BbH = 0.0F;
  private LinkedList<com.tencent.neattextview.textview.b.c> BbI;
  protected boolean[] BbJ;
  protected String Bbm;
  protected char[] Bbn;
  protected float[] Bbo;
  protected float[] Bbp;
  protected float[] Bbq = new float[com.tencent.neattextview.textview.a.a.Bbg.length];
  protected float[] Bbr = new float[com.tencent.neattextview.textview.a.a.Bbh.length];
  protected HashMap<Character, Float> Bbs = new HashMap(com.tencent.neattextview.textview.a.a.Bbg.length);
  public ArrayList<b> Bbt = new ArrayList();
  private LinkedList<com.tencent.neattextview.textview.b.b> Bbu = new LinkedList();
  private float Bbv;
  private float Bbw;
  private int Bbx;
  private TextPaint Bby = new TextPaint();
  private float[] Bbz;
  private int bdk = 0;
  protected TextPaint hB;
  private float mPaddingLeft;
  private float mPaddingTop;
  protected CharSequence mText;
  private float vBh;
  
  public c(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    this.mText = paramCharSequence;
    this.Bbm = paramCharSequence.toString();
    this.Bbn = this.Bbm.toCharArray();
    if (paramArrayOfFloat != null)
    {
      this.Bbo = new float[paramArrayOfFloat.length];
      System.arraycopy(paramArrayOfFloat, 0, this.Bbo, 0, paramArrayOfFloat.length);
    }
  }
  
  private void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat, TextPaint paramTextPaint)
  {
    int i;
    float f;
    if ((paramTruncateAt != null) && (paramTruncateAt != TextUtils.TruncateAt.MARQUEE)) {
      if ((this.mText != null) && (this.Bbt.size() > 0) && (this.mText.length() > ((b)this.Bbt.get(this.Bbt.size() - 1)).getEnd()))
      {
        i = 1;
        if (i == 0) {
          break label294;
        }
        f = paramTextPaint.measureText(Bbl) + paramTextPaint.getTextSize() / 6.0F + paramFloat;
        if ((this.bdk != 1) || (paramTruncateAt != TextUtils.TruncateAt.MIDDLE)) {
          break label230;
        }
        paramTruncateAt = (b)this.Bbt.get(0);
        i = paramTruncateAt.getStart();
        paramFloat = 0.0F;
        label128:
        if (i >= paramTruncateAt.getEnd()) {
          break label224;
        }
        paramFloat += this.Bbo[i];
        if (paramFloat < this.vBh / 2.0F) {
          break label215;
        }
      }
    }
    for (;;)
    {
      label160:
      paramFloat = 0.0F;
      for (;;)
      {
        if (i > 0)
        {
          paramFloat += this.Bbo[i];
          if (paramFloat < f)
          {
            this.Bbo[i] = 0.0F;
            this.Bbn[i] = '\000';
            i -= 1;
            continue;
            i = 0;
            break;
            label215:
            i += 1;
            break label128;
            label224:
            i = 0;
            break label160;
            label230:
            if (paramTruncateAt != TextUtils.TruncateAt.END) {
              break label295;
            }
            i = ((b)this.Bbt.get(this.Bbt.size() - 1)).getEnd() - 1;
            break label160;
          }
        }
      }
      if (i >= 0)
      {
        this.Bbo[i] = f;
        this.Bbn[i] = Bbk[0];
      }
      label294:
      return;
      label295:
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
      this.BbA.a((Spanned)localObject, i);
      this.BbB.a((Spanned)localObject, i);
      this.BbC.a((Spanned)localObject, i);
      this.BbE.a((Spanned)localObject, i);
      this.BbD.a((Spanned)localObject, i);
      this.BbF.a((Spanned)localObject, i);
      this.BbG.a((Spanned)localObject, i);
    }
    this.Bby.set(paramTextPaint);
    int i = 0;
    int j;
    int m;
    int n;
    while (i < this.BbB.Bca)
    {
      ((AbsoluteSizeSpan[])this.BbB.Bcb)[i].updateMeasureState(this.Bby);
      j = this.BbB.Bcc[i];
      m = this.BbB.Bcd[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.Bby.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.Bbo, j, n);
      if (this.Bbp == null) {
        this.Bbp = new float[paramCharSequence.length()];
      }
      this.Bbp[j] = this.Bby.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.BbC.Bca)
    {
      ((RelativeSizeSpan[])this.BbC.Bcb)[i].updateMeasureState(this.Bby);
      j = this.BbC.Bcc[i];
      m = this.BbC.Bcd[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.Bby.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.Bbo, j, n);
      if (this.Bbp == null) {
        this.Bbp = new float[paramCharSequence.length()];
      }
      this.Bbp[j] = this.Bby.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.BbA.Bca)
    {
      paramTextPaint = ((ImageSpan[])this.BbA.Bcb)[i];
      m = this.BbA.Bcc[i];
      n = this.BbA.Bcd[i];
      paramTextPaint = paramTextPaint.getDrawable();
      localObject = new Rect();
      if (paramTextPaint != null) {
        ((Rect)localObject).set(paramTextPaint.getBounds());
      }
      this.Bbo[m] = ((Rect)localObject).width();
      paramArrayOfBoolean[m] = true;
      j = m + 1;
      while ((j < m + (n - m)) && (j < this.Bbo.length))
      {
        this.Bbo[j] = 0.0F;
        paramArrayOfBoolean[j] = true;
        j += 1;
      }
      if (this.Bbp == null) {
        this.Bbp = new float[paramCharSequence.length()];
      }
      this.Bbp[m] = ((Rect)localObject).height();
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.BbD.Bca) {
        break;
      }
      paramCharSequence = ((BackgroundColorSpan[])this.BbD.Bcb)[i];
      j = this.BbD.Bcc[i];
      m = this.BbD.Bcd[i];
      this.Bbu.add(new com.tencent.neattextview.textview.b.a(j, m, paramCharSequence));
      i += 1;
    }
    while (j < this.BbF.Bca)
    {
      paramCharSequence = ((ClickableSpan[])this.BbF.Bcb)[j];
      i = this.BbF.Bcc[j];
      k = this.BbF.Bcd[j];
      this.Bbu.add(new com.tencent.neattextview.textview.b.c(i, k, paramCharSequence));
      j += 1;
    }
  }
  
  private void d(Paint paramPaint)
  {
    this.Bbs.clear();
    Rect localRect = new Rect();
    char[] arrayOfChar = com.tencent.neattextview.textview.a.a.Bbg;
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
      this.Bbq[j] = (f1 - f2);
      j += 1;
      i += 1;
    }
    arrayOfChar = com.tencent.neattextview.textview.a.a.Bbh;
    k = arrayOfChar.length;
    i = 0;
    j = 0;
    if (i < k)
    {
      paramPaint.getTextBounds(String.valueOf(arrayOfChar[i]), 0, 1, localRect);
      if (localRect.left > 0) {}
      for (f1 = localRect.left;; f1 = 0.0F)
      {
        this.Bbr[j] = f1;
        this.Bbs.put(Character.valueOf(com.tencent.neattextview.textview.a.a.Bbh[j]), Float.valueOf(f1));
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
    Iterator localIterator = this.Bbu.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.neattextview.textview.b.b)localIterator.next()).a(paramCanvas, this.hB, this.Bbt);
    }
    localIterator = this.Bbt.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.a(paramCanvas, this.hB, paramFloat1);
      paramFloat1 = localb.getHeight() + paramFloat1;
    }
    paramCanvas.restore();
  }
  
  public final void a(TextPaint paramTextPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, TextUtils.TruncateAt paramTruncateAt, float paramFloat6, boolean paramBoolean, int paramInt2)
  {
    this.hB = new TextPaint(paramTextPaint);
    this.Bbv = paramFloat2;
    this.vBh = paramFloat1;
    this.mPaddingLeft = paramFloat3;
    this.mPaddingTop = paramFloat4;
    this.bdk = paramInt1;
    this.Bbw = paramFloat5;
    this.Bbz = null;
    this.Bbx = paramInt2;
    paramInt2 = this.mText.length();
    if (this.Bbo == null)
    {
      this.Bbo = new float[paramInt2];
      paramTextPaint.getTextWidths(this.Bbm, this.Bbo);
    }
    this.BbJ = new boolean[paramInt2];
    a(this.mText, paramTextPaint, this.BbJ);
    d(paramTextPaint);
    a(paramTextPaint, paramFloat1, paramInt1, paramBoolean);
    a(paramTruncateAt, paramFloat6, paramTextPaint);
  }
  
  protected abstract void a(TextPaint paramTextPaint, float paramFloat, int paramInt, boolean paramBoolean);
  
  protected final void a(char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, int paramInt3, float paramFloat2, boolean paramBoolean, float paramFloat3, float paramFloat4)
  {
    Paint.FontMetrics localFontMetrics = this.hB.getFontMetrics();
    float f1 = localFontMetrics.bottom - localFontMetrics.top;
    float f2 = f1;
    if (this.Bbp != null)
    {
      int i = paramInt1;
      for (;;)
      {
        f2 = f1;
        if (i >= paramInt2) {
          break;
        }
        f2 = f1;
        if (f1 < this.Bbp[i]) {
          f2 = this.Bbp[i];
        }
        i += 1;
        f1 = f2;
      }
    }
    f1 = f2 + this.Bbw;
    paramArrayOfChar = new d(this, paramArrayOfChar, paramInt1, paramInt2, this.BbH, paramArrayOfFloat, paramFloat1, f1, paramFloat2, this.hB, paramBoolean, paramFloat3, paramInt3, this.Bbx, paramFloat4);
    this.BbH += f1;
    this.Bbt.add(paramArrayOfChar);
  }
  
  public final void al(CharSequence paramCharSequence)
  {
    a(paramCharSequence, this.hB, this.BbJ);
  }
  
  public int dTo()
  {
    return this.Bbt.size();
  }
  
  public final List<com.tencent.neattextview.textview.b.c> dTp()
  {
    if (this.BbI == null)
    {
      this.BbI = new LinkedList();
      Iterator localIterator = this.Bbu.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.neattextview.textview.b.b localb = (com.tencent.neattextview.textview.b.b)localIterator.next();
        if (localb.getClass() == com.tencent.neattextview.textview.b.c.class) {
          this.BbI.add((com.tencent.neattextview.textview.b.c)localb);
        }
      }
    }
    return this.BbI;
  }
  
  public final float[] dTq()
  {
    return this.Bbo;
  }
  
  public final String dTx()
  {
    return this.Bbm;
  }
  
  public final float[] dTy()
  {
    if (this.Bbz == null)
    {
      Iterator localIterator = this.Bbt.iterator();
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
      this.Bbz = new float[] { f2, f1 };
    }
    return this.Bbz;
  }
  
  public final HashMap<Character, Float> dTz()
  {
    return this.Bbs;
  }
  
  public final int getLineBaseline(int paramInt)
  {
    int i = this.Bbt.size();
    if (i > paramInt) {}
    for (b localb = (b)this.Bbt.get(paramInt);; localb = (b)this.Bbt.get(i - 1))
    {
      return (int)localb.dTw();
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineBottom(int paramInt)
  {
    int i = this.Bbt.size();
    if (i > paramInt) {}
    for (b localb = (b)this.Bbt.get(paramInt);; localb = (b)this.Bbt.get(i - 1))
    {
      return (int)localb.dTr().bottom;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int getLineForOffset(int paramInt)
  {
    Iterator localIterator = this.Bbt.iterator();
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
    Iterator localIterator = this.Bbt.iterator();
    float f1 = 0.0F;
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (b)localIterator.next();
      float f2 = f1;
      if (f1 == 0.0F) {
        f2 = ((b)localObject).dTs().top;
      }
      localObject = ((b)localObject).dTs();
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
    if (this.Bbt.size() > paramInt) {
      return ((b)this.Bbt.get(paramInt)).dTr().right;
    }
    return 0.0F;
  }
  
  public final int getLineStart(int paramInt)
  {
    if (this.Bbt.size() > paramInt) {
      return ((b)this.Bbt.get(paramInt)).getStart();
    }
    return this.Bbn.length;
  }
  
  public final int getLineTop(int paramInt)
  {
    int i = this.Bbt.size();
    if (i > paramInt) {}
    for (b localb = (b)this.Bbt.get(paramInt);; localb = (b)this.Bbt.get(i - 1))
    {
      return (int)localb.dTr().top;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final float getLineWidth(int paramInt)
  {
    if (this.Bbt.size() > paramInt) {
      return ((b)this.Bbt.get(paramInt)).dTr().width();
    }
    return 0.0F;
  }
  
  public final int getOffsetForHorizontal(int paramInt, float paramFloat)
  {
    float f = this.mPaddingLeft;
    if (this.Bbt.size() > paramInt) {
      return ((b)this.Bbt.get(paramInt)).RZ((int)(paramFloat - f));
    }
    return 0;
  }
  
  public final float getPrimaryHorizontal(int paramInt)
  {
    int i = getLineForOffset(paramInt);
    if (i < 0) {
      return 0.0F;
    }
    return ((b)this.Bbt.get(i)).getPrimaryHorizontal(paramInt);
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  public final TextPaint getTextPaint()
  {
    return this.hB;
  }
  
  public final int ii(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 - this.mPaddingLeft);
    paramInt2 = (int)(paramInt2 - this.mPaddingTop);
    Iterator localIterator = this.Bbt.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.dTs().contains(paramInt1, paramInt2)) {
        return localb.RZ(paramInt1);
      }
    }
    return this.Bbn.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.c
 * JD-Core Version:    0.7.0.1
 */