package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
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

public abstract class b
{
  private static final char[] wDA = { '…' };
  private static final String wDB = new String(wDA);
  protected TextPaint gI;
  protected CharSequence mText;
  private float rKD;
  protected String wDC;
  protected char[] wDD;
  protected float[] wDE;
  protected float[] wDF;
  protected float[] wDG = new float[com.tencent.neattextview.textview.a.a.wDw.length];
  protected float[] wDH = new float[com.tencent.neattextview.textview.a.a.wDx.length];
  protected HashMap<Character, Float> wDI = new HashMap(com.tencent.neattextview.textview.a.a.wDw.length);
  public ArrayList<a> wDJ = new ArrayList();
  public LinkedList<com.tencent.neattextview.textview.b.b> wDK = new LinkedList();
  private float wDL;
  private float wDM;
  private float wDN;
  private float wDO;
  private int wDP = 0;
  private TextPaint wDQ = new TextPaint();
  private float[] wDR;
  d<ImageSpan> wDS = new d(ImageSpan.class);
  d<AbsoluteSizeSpan> wDT = new d(AbsoluteSizeSpan.class);
  d<RelativeSizeSpan> wDU = new d(RelativeSizeSpan.class);
  d<BackgroundColorSpan> wDV = new d(BackgroundColorSpan.class);
  d<ForegroundColorSpan> wDW = new d(ForegroundColorSpan.class);
  d<ClickableSpan> wDX = new d(ClickableSpan.class);
  d<LineBackgroundSpan> wDY = new d(LineBackgroundSpan.class);
  private float wDZ = 0.0F;
  public LinkedList<com.tencent.neattextview.textview.b.c> wEa;
  protected boolean[] wEb;
  
  public b(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    this.mText = paramCharSequence;
    this.wDC = paramCharSequence.toString();
    this.wDD = this.wDC.toCharArray();
    if (paramArrayOfFloat != null)
    {
      this.wDE = new float[paramArrayOfFloat.length];
      System.arraycopy(paramArrayOfFloat, 0, this.wDE, 0, paramArrayOfFloat.length);
    }
  }
  
  private void a(TextUtils.TruncateAt paramTruncateAt, TextPaint paramTextPaint)
  {
    int i;
    float f2;
    float f1;
    if ((paramTruncateAt != null) && (paramTruncateAt != TextUtils.TruncateAt.MARQUEE)) {
      if ((this.mText != null) && (this.wDJ.size() > 0) && (this.mText.length() > ((a)this.wDJ.get(this.wDJ.size() - 1)).getEnd()))
      {
        i = 1;
        if (i == 0) {
          break label279;
        }
        f2 = paramTextPaint.measureText(wDB);
        if ((this.wDP != 1) || (paramTruncateAt != TextUtils.TruncateAt.MIDDLE)) {
          break label220;
        }
        paramTruncateAt = (a)this.wDJ.get(0);
        i = paramTruncateAt.getStart();
        f1 = 0.0F;
        label118:
        if (i >= paramTruncateAt.getEnd()) {
          break label214;
        }
        f1 += this.wDE[i];
        if (f1 < this.rKD / 2.0F) {
          break label205;
        }
      }
    }
    for (;;)
    {
      label150:
      f1 = 0.0F;
      for (;;)
      {
        if (i >= 0)
        {
          f1 += this.wDE[i];
          if (f1 < f2)
          {
            this.wDE[i] = 0.0F;
            this.wDD[i] = '\000';
            i -= 1;
            continue;
            i = 0;
            break;
            label205:
            i += 1;
            break label118;
            label214:
            i = 0;
            break label150;
            label220:
            if (paramTruncateAt != TextUtils.TruncateAt.END) {
              break label280;
            }
            i = ((a)this.wDJ.get(this.wDJ.size() - 1)).getEnd() - 1;
            break label150;
          }
        }
      }
      this.wDE[i] = f2;
      this.wDD[i] = wDA[0];
      label279:
      return;
      label280:
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
      this.wDS.a((Spanned)localObject, i);
      this.wDT.a((Spanned)localObject, i);
      this.wDU.a((Spanned)localObject, i);
      this.wDW.a((Spanned)localObject, i);
      this.wDV.a((Spanned)localObject, i);
      this.wDX.a((Spanned)localObject, i);
      this.wDY.a((Spanned)localObject, i);
    }
    this.wDQ.set(paramTextPaint);
    int i = 0;
    int j;
    int m;
    int n;
    while (i < this.wDT.wEw)
    {
      ((AbsoluteSizeSpan[])this.wDT.wEx)[i].updateMeasureState(this.wDQ);
      j = this.wDT.wEy[i];
      m = this.wDT.wEz[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.wDQ.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.wDE, j, n);
      if (this.wDF == null) {
        this.wDF = new float[paramCharSequence.length()];
      }
      this.wDF[j] = this.wDQ.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.wDU.wEw)
    {
      ((RelativeSizeSpan[])this.wDU.wEx)[i].updateMeasureState(this.wDQ);
      j = this.wDU.wEy[i];
      m = this.wDU.wEz[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.wDQ.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.wDE, j, n);
      if (this.wDF == null) {
        this.wDF = new float[paramCharSequence.length()];
      }
      this.wDF[j] = this.wDQ.getTextSize();
      i += 1;
    }
    i = 0;
    while (i < this.wDS.wEw)
    {
      paramTextPaint = ((ImageSpan[])this.wDS.wEx)[i];
      m = this.wDS.wEy[i];
      n = this.wDS.wEz[i];
      paramTextPaint = paramTextPaint.getDrawable();
      localObject = new Rect();
      if (paramTextPaint != null) {
        ((Rect)localObject).set(paramTextPaint.getBounds());
      }
      this.wDE[m] = ((Rect)localObject).width();
      paramArrayOfBoolean[m] = true;
      j = m + 1;
      while (j < m + (n - m))
      {
        this.wDE[j] = 0.0F;
        paramArrayOfBoolean[j] = true;
        j += 1;
      }
      if (this.wDF == null) {
        this.wDF = new float[paramCharSequence.length()];
      }
      this.wDF[m] = ((Rect)localObject).height();
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.wDV.wEw) {
        break;
      }
      paramCharSequence = ((BackgroundColorSpan[])this.wDV.wEx)[i];
      j = this.wDV.wEy[i];
      m = this.wDV.wEz[i];
      this.wDK.add(new com.tencent.neattextview.textview.b.a(j, m, paramCharSequence));
      i += 1;
    }
    while (j < this.wDX.wEw)
    {
      paramCharSequence = ((ClickableSpan[])this.wDX.wEx)[j];
      i = this.wDX.wEy[j];
      k = this.wDX.wEz[j];
      this.wDK.add(new com.tencent.neattextview.textview.b.c(i, k, paramCharSequence));
      j += 1;
    }
  }
  
  private void c(Paint paramPaint)
  {
    this.wDI.clear();
    Rect localRect = new Rect();
    char[] arrayOfChar = com.tencent.neattextview.textview.a.a.wDw;
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
      this.wDG[j] = (f1 - f2);
      j += 1;
      i += 1;
    }
    arrayOfChar = com.tencent.neattextview.textview.a.a.wDx;
    k = arrayOfChar.length;
    i = 0;
    j = 0;
    if (i < k)
    {
      paramPaint.getTextBounds(String.valueOf(arrayOfChar[i]), 0, 1, localRect);
      if (localRect.left > 0) {}
      for (f1 = localRect.left;; f1 = 0.0F)
      {
        this.wDH[j] = f1;
        this.wDI.put(Character.valueOf(com.tencent.neattextview.textview.a.a.wDx[j]), Float.valueOf(f1));
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
    Iterator localIterator = this.wDK.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.neattextview.textview.b.b)localIterator.next()).a(paramCanvas, this.gI, this.wDJ);
    }
    localIterator = this.wDJ.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      locala.a(paramCanvas, this.gI, paramFloat1);
      paramFloat1 = locala.getHeight() + paramFloat1;
    }
    paramCanvas.restore();
  }
  
  public final void a(TextPaint paramTextPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt, TextUtils.TruncateAt paramTruncateAt, boolean paramBoolean)
  {
    this.gI = new TextPaint(paramTextPaint);
    this.wDL = paramFloat2;
    this.rKD = paramFloat1;
    this.wDM = paramFloat3;
    this.wDN = paramFloat4;
    this.wDP = paramInt;
    this.wDO = paramFloat5;
    this.wDR = null;
    int i = this.mText.length();
    if (this.wDE == null)
    {
      this.wDE = new float[i];
      paramTextPaint.getTextWidths(this.wDC, this.wDE);
    }
    this.wEb = new boolean[i];
    a(this.mText, paramTextPaint, this.wEb);
    c(paramTextPaint);
    a(paramTextPaint, paramFloat1, paramInt, paramBoolean);
    a(paramTruncateAt, paramTextPaint);
  }
  
  protected abstract void a(TextPaint paramTextPaint, float paramFloat, int paramInt, boolean paramBoolean);
  
  protected final void a(char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    Paint.FontMetrics localFontMetrics = this.gI.getFontMetrics();
    float f1 = localFontMetrics.bottom - localFontMetrics.top;
    float f2 = f1;
    if (this.wDF != null)
    {
      int i = paramInt1;
      for (;;)
      {
        f2 = f1;
        if (i >= paramInt2) {
          break;
        }
        f2 = f1;
        if (f1 < this.wDF[i]) {
          f2 = this.wDF[i];
        }
        i += 1;
        f1 = f2;
      }
    }
    f1 = f2 + this.wDO;
    paramArrayOfChar = new c(this, paramArrayOfChar, paramInt1, paramInt2, this.wDZ, paramArrayOfFloat, paramFloat1, f1, paramFloat2, this.gI, paramBoolean, paramInt3);
    this.wDZ += f1;
    this.wDJ.add(paramArrayOfChar);
  }
  
  public int cNL()
  {
    return this.wDJ.size();
  }
  
  public final float[] cNM()
  {
    if (this.wDR == null)
    {
      Iterator localIterator = this.wDJ.iterator();
      float f2 = 0.0F;
      float f1 = 0.0F;
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        float f3 = f2;
        if (f2 < locala.getWidth()) {
          f3 = locala.getWidth();
        }
        f1 = locala.getHeight() + f1;
        f2 = f3;
      }
      this.wDR = new float[] { f2, f1 };
    }
    return this.wDR;
  }
  
  public final TextPaint cNN()
  {
    return this.gI;
  }
  
  public final HashMap<Character, Float> cNO()
  {
    return this.wDI;
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.b
 * JD-Core Version:    0.7.0.1
 */