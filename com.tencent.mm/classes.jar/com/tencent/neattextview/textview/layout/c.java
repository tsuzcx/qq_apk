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
  public static final char[] Zcq = { '…' };
  private static final String Zcr = new String(Zcq);
  private int FVT;
  private LinkedList<com.tencent.neattextview.textview.b.b> ZcA = new LinkedList();
  private float ZcB;
  private float ZcC;
  private float ZcD;
  private float ZcE;
  private float ZcF;
  private TextPaint ZcG = new TextPaint();
  private float[] ZcH;
  e<ImageSpan> ZcI = new e(ImageSpan.class);
  private e<LineHeightSpan> ZcJ = new e(LineHeightSpan.class);
  e<AbsoluteSizeSpan> ZcK = new e(AbsoluteSizeSpan.class);
  e<RelativeSizeSpan> ZcL = new e(RelativeSizeSpan.class);
  private e<BackgroundColorSpan> ZcM = new e(BackgroundColorSpan.class);
  e<ForegroundColorSpan> ZcN = new e(ForegroundColorSpan.class);
  e<ClickableSpan> ZcO = new e(ClickableSpan.class);
  e<LineBackgroundSpan> ZcP = new e(LineBackgroundSpan.class);
  private float ZcQ = 0.0F;
  private LinkedList<com.tencent.neattextview.textview.b.c> ZcR;
  protected boolean[] ZcS;
  private int ZcT = 0;
  private int ZcU = 0;
  private int ZcV = 0;
  protected String Zcs;
  protected char[] Zct;
  protected float[] Zcu;
  protected float[] Zcv;
  protected float[] Zcw = new float[com.tencent.neattextview.textview.a.a.Zcm.length];
  protected float[] Zcx = new float[com.tencent.neattextview.textview.a.a.Zcn.length];
  protected HashMap<Character, Float> Zcy = new HashMap(com.tencent.neattextview.textview.a.a.Zcm.length);
  public ArrayList<b> Zcz = new ArrayList();
  private int btf = 0;
  private TextUtils.TruncateAt kgs;
  protected CharSequence mText;
  private float uvo;
  protected TextPaint wi;
  
  public c(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    this.mText = paramCharSequence;
    this.Zcs = paramCharSequence.toString();
    this.Zct = this.Zcs.toCharArray();
    if (paramArrayOfFloat != null)
    {
      this.Zcu = new float[paramArrayOfFloat.length];
      System.arraycopy(paramArrayOfFloat, 0, this.Zcu, 0, paramArrayOfFloat.length);
    }
  }
  
  private void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat, TextPaint paramTextPaint)
  {
    int i;
    label115:
    float f1;
    if ((this.kgs != null) && (this.kgs != TextUtils.TruncateAt.MARQUEE))
    {
      i = this.Zcz.size();
      if (i > 0)
      {
        b localb = (b)this.Zcz.get(i - 1);
        if ((this.mText != null) && ((this.mText.length() > localb.getEnd()) || ((this.ZcF > 0.0F) && (ikz()[0] - localb.getWidth() < this.ZcF))))
        {
          i = 1;
          if (i == 0) {
            break label331;
          }
          i = 1;
          if (i == 0) {
            break label492;
          }
          f1 = paramTextPaint.measureText(Zcr) + paramFloat + paramTextPaint.getTextSize() / 6.0F;
          paramTextPaint = (b)this.Zcz.get(this.Zcz.size() - 1);
          this.ZcV = (this.Zcz.size() - 1);
          if ((this.btf != 1) || (paramTruncateAt != TextUtils.TruncateAt.MIDDLE)) {
            break label352;
          }
          paramTruncateAt = (b)this.Zcz.get(0);
          i = paramTruncateAt.getStart();
          paramFloat = 0.0F;
          label209:
          if (i >= paramTruncateAt.getEnd()) {
            break label346;
          }
          paramFloat += this.Zcu[i];
          if (paramFloat < this.uvo / 2.0F) {
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
          paramFloat = this.uvo;
          float f2 = paramTextPaint.azU(i);
          if (((this.Zcu[i] <= 0.0F) || (paramFloat - f2 < f1)) && (i != k))
          {
            this.Zcu[i] = 0.0F;
            this.Zct[i] = '\000';
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
        while ((this.ZcI.Zdo != null) && (j < this.ZcI.Zdo.length))
        {
          if (this.ZcI.Zdo[j] == i)
          {
            this.ZcI.Zdo[j] = -1;
            this.ZcI.Zdp[j] = -1;
          }
          j += 1;
        }
        this.ZcU = (this.Zct.length - i);
        this.Zcu[i] = f1;
        this.Zct[i] = Zcq[0];
        this.ZcT = (i - k);
      }
      return;
      label492:
      this.ZcU = 0;
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
      this.ZcI.a((Spanned)localObject, i);
      this.ZcJ.a((Spanned)localObject, i);
      this.ZcK.a((Spanned)localObject, i);
      this.ZcL.a((Spanned)localObject, i);
      this.ZcN.a((Spanned)localObject, i);
      this.ZcM.a((Spanned)localObject, i);
      this.ZcO.a((Spanned)localObject, i);
      this.ZcP.a((Spanned)localObject, i);
    }
    this.ZcG.set(paramTextPaint);
    int i = 0;
    int j;
    int m;
    int n;
    while (i < this.ZcK.Zdm)
    {
      ((AbsoluteSizeSpan[])this.ZcK.Zdn)[i].updateMeasureState(this.ZcG);
      j = this.ZcK.Zdo[i];
      m = this.ZcK.Zdp[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.ZcG.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.Zcu, j, n);
      if (this.Zcv == null) {
        this.Zcv = new float[paramCharSequence.length()];
      }
      paramTextPaint = this.Zcv;
      paramTextPaint[j] = Math.max(paramTextPaint[j], this.ZcG.getTextSize());
      i += 1;
    }
    i = 0;
    while (i < this.ZcL.Zdm)
    {
      ((RelativeSizeSpan[])this.ZcL.Zdn)[i].updateMeasureState(this.ZcG);
      j = this.ZcL.Zdo[i];
      m = this.ZcL.Zdp[i];
      n = m - j;
      paramTextPaint = new float[n];
      this.ZcG.getTextWidths(paramCharSequence, j, m, paramTextPaint);
      System.arraycopy(paramTextPaint, 0, this.Zcu, j, n);
      if (this.Zcv == null) {
        this.Zcv = new float[paramCharSequence.length()];
      }
      paramTextPaint = this.Zcv;
      paramTextPaint[j] = Math.max(paramTextPaint[j], this.ZcG.getTextSize());
      i += 1;
    }
    i = 0;
    while (i < this.ZcJ.Zdm)
    {
      localObject = ((LineHeightSpan[])this.ZcJ.Zdn)[i];
      j = this.ZcJ.Zdo[i];
      m = this.ZcJ.Zdp[i];
      if (this.Zcv == null) {
        this.Zcv = new float[paramCharSequence.length()];
      }
      paramTextPaint = this.wi.getFontMetricsInt();
      ((LineHeightSpan)localObject).chooseHeight(paramCharSequence, j, m, 0, 0, paramTextPaint);
      localObject = this.Zcv;
      localObject[j] = Math.max(localObject[j], paramTextPaint.descent - paramTextPaint.ascent);
      i += 1;
    }
    i = 0;
    while (i < this.ZcI.Zdm)
    {
      paramTextPaint = ((ImageSpan[])this.ZcI.Zdn)[i];
      m = this.ZcI.Zdo[i];
      n = this.ZcI.Zdp[i];
      localObject = paramTextPaint.getDrawable();
      paramTextPaint = new Rect();
      if (localObject != null) {
        paramTextPaint.set(((Drawable)localObject).getBounds());
      }
      this.Zcu[m] = paramTextPaint.width();
      paramArrayOfBoolean[m] = true;
      j = m + 1;
      while ((j < m + (n - m)) && (j < this.Zcu.length))
      {
        this.Zcu[j] = 0.0F;
        paramArrayOfBoolean[j] = true;
        j += 1;
      }
      if (this.Zcv == null) {
        this.Zcv = new float[paramCharSequence.length()];
      }
      localObject = this.wi.getFontMetrics();
      float f1 = ((Paint.FontMetrics)localObject).bottom;
      float f2 = ((Paint.FontMetrics)localObject).top;
      localObject = this.Zcv;
      localObject[m] = Math.max(localObject[m], Math.max(f1 - f2, paramTextPaint.height()));
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.ZcM.Zdm) {
        break;
      }
      paramCharSequence = ((BackgroundColorSpan[])this.ZcM.Zdn)[i];
      j = this.ZcM.Zdo[i];
      m = this.ZcM.Zdp[i];
      this.ZcA.add(new com.tencent.neattextview.textview.b.a(j, m, paramCharSequence));
      i += 1;
    }
    while (j < this.ZcO.Zdm)
    {
      paramCharSequence = ((ClickableSpan[])this.ZcO.Zdn)[j];
      i = this.ZcO.Zdo[j];
      k = this.ZcO.Zdp[j];
      this.ZcA.add(new com.tencent.neattextview.textview.b.c(i, k, paramCharSequence));
      j += 1;
    }
  }
  
  private void c(Paint paramPaint)
  {
    this.Zcy.clear();
    Rect localRect = new Rect();
    char[] arrayOfChar = com.tencent.neattextview.textview.a.a.Zcm;
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
      this.Zcw[j] = (f1 - f2);
      j += 1;
      i += 1;
    }
    arrayOfChar = com.tencent.neattextview.textview.a.a.Zcn;
    k = arrayOfChar.length;
    i = 0;
    j = 0;
    while (i < k)
    {
      paramPaint.getTextBounds(String.valueOf(arrayOfChar[i]), 0, 1, localRect);
      f1 = Math.max(localRect.left, 0);
      this.Zcx[j] = f1;
      this.Zcy.put(Character.valueOf(com.tencent.neattextview.textview.a.a.Zcn[j]), Float.valueOf(f1));
      j += 1;
      i += 1;
    }
  }
  
  public final int E(int paramInt, float paramFloat)
  {
    float f = this.ZcC;
    if (this.Zcz.size() > paramInt) {
      return ((b)this.Zcz.get(paramInt)).aAb((int)(paramFloat - f));
    }
    return 0;
  }
  
  public final int Ji(int paramInt)
  {
    Iterator localIterator = this.Zcz.iterator();
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
  
  public final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramFloat1 = 0.0F;
    Iterator localIterator = this.ZcA.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.neattextview.textview.b.b)localIterator.next()).a(paramCanvas, this.wi, this.Zcz);
    }
    localIterator = this.Zcz.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.a(paramCanvas, this.wi, paramFloat1);
      paramFloat1 = localb.getHeight() + paramFloat1;
    }
    paramCanvas.restore();
  }
  
  public final void a(TextPaint paramTextPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, TextUtils.TruncateAt paramTruncateAt, float paramFloat6, boolean paramBoolean, int paramInt2)
  {
    this.wi = new TextPaint(paramTextPaint);
    this.ZcF = paramFloat6;
    this.ZcB = paramFloat2;
    this.uvo = paramFloat1;
    this.ZcC = paramFloat3;
    this.ZcD = paramFloat4;
    this.btf = paramInt1;
    this.kgs = paramTruncateAt;
    this.ZcE = paramFloat5;
    this.ZcH = null;
    this.FVT = paramInt2;
    paramInt2 = this.mText.length();
    if (this.Zcu == null)
    {
      this.Zcu = new float[paramInt2];
      paramTextPaint.getTextWidths(this.Zcs, this.Zcu);
    }
    this.ZcS = new boolean[paramInt2];
    a(this.mText, paramTextPaint, this.ZcS);
    c(paramTextPaint);
    a(paramTextPaint, new float[0], paramFloat1, paramInt1, paramBoolean);
    a(paramTruncateAt, paramFloat6, paramTextPaint);
  }
  
  public final void a(TextPaint paramTextPaint, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, TextUtils.TruncateAt paramTruncateAt, float paramFloat6, boolean paramBoolean, int paramInt2)
  {
    this.wi = new TextPaint(paramTextPaint);
    this.ZcF = paramFloat6;
    this.ZcB = paramFloat2;
    this.uvo = paramFloat1;
    this.ZcC = paramFloat3;
    this.ZcD = paramFloat4;
    this.btf = paramInt1;
    this.kgs = paramTruncateAt;
    this.ZcE = paramFloat5;
    this.ZcH = null;
    this.FVT = paramInt2;
    paramInt2 = this.mText.length();
    if (this.Zcu == null)
    {
      this.Zcu = new float[paramInt2];
      paramTextPaint.getTextWidths(this.Zcs, this.Zcu);
    }
    this.ZcS = new boolean[paramInt2];
    a(this.mText, paramTextPaint, this.ZcS);
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
    Paint.FontMetrics localFontMetrics = this.wi.getFontMetrics();
    float f1 = localFontMetrics.bottom - localFontMetrics.top;
    float f2 = f1;
    int i;
    if (this.Zcv != null)
    {
      i = paramInt1;
      f2 = f1;
      if (i < paramInt2)
      {
        f2 = this.Zcv[i];
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
      f1 = f2 + this.ZcE;
      paramArrayOfChar = new d(this, paramArrayOfChar, paramInt1, paramInt2, this.ZcQ, paramArrayOfFloat, paramFloat1, f1, paramFloat2, this.wi, paramBoolean, paramFloat3, paramInt3, this.FVT, paramFloat4);
      this.ZcQ += f1;
      this.Zcz.add(paramArrayOfChar);
      return;
    }
  }
  
  public final int aAa(int paramInt)
  {
    if (this.ZcV == paramInt) {
      return this.ZcU;
    }
    return 0;
  }
  
  public final void aV(CharSequence paramCharSequence)
  {
    a(paramCharSequence, this.wi, this.ZcS);
  }
  
  public final TextPaint arx()
  {
    return this.wi;
  }
  
  public final int azR(int paramInt)
  {
    int i = this.Zcz.size();
    if (i > paramInt) {}
    for (b localb = (b)this.Zcz.get(paramInt);; localb = (b)this.Zcz.get(i - 1))
    {
      return (int)localb.ikx();
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int azS(int paramInt)
  {
    int i = this.Zcz.size();
    if (i > paramInt) {}
    for (b localb = (b)this.Zcz.get(paramInt);; localb = (b)this.Zcz.get(i - 1))
    {
      return (int)localb.iks().top;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final int azT(int paramInt)
  {
    int i = this.Zcz.size();
    if (i > paramInt) {}
    for (b localb = (b)this.Zcz.get(paramInt);; localb = (b)this.Zcz.get(i - 1))
    {
      return (int)localb.iks().bottom;
      if (i <= 0) {
        break;
      }
    }
    return 0;
  }
  
  public final float azU(int paramInt)
  {
    int i = Ji(paramInt);
    if (i < 0) {
      return 0.0F;
    }
    return ((b)this.Zcz.get(i)).azU(paramInt);
  }
  
  public final float azV(int paramInt)
  {
    if (this.Zcz.size() > paramInt) {
      return ((b)this.Zcz.get(paramInt)).iks().width();
    }
    return 0.0F;
  }
  
  public final int azW(int paramInt)
  {
    if (this.Zcz.size() > paramInt) {
      return ((b)this.Zcz.get(paramInt)).getStart();
    }
    return this.Zct.length;
  }
  
  public final int azX(int paramInt)
  {
    int i = (int)(paramInt - this.ZcD);
    Iterator localIterator = this.Zcz.iterator();
    float f1 = 0.0F;
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (b)localIterator.next();
      float f2 = f1;
      if (f1 == 0.0F) {
        f2 = ((b)localObject).ikt().top;
      }
      localObject = ((b)localObject).ikt();
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
  
  public final float azY(int paramInt)
  {
    if (this.Zcz.size() > paramInt) {
      return ((b)this.Zcz.get(paramInt)).iks().right;
    }
    return 0.0F;
  }
  
  public final int azZ(int paramInt)
  {
    if (this.ZcV == paramInt) {
      return this.ZcT;
    }
    return 0;
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  public final HashMap<Character, Float> ikA()
  {
    return this.Zcy;
  }
  
  public int ikp()
  {
    return this.Zcz.size();
  }
  
  public final List<com.tencent.neattextview.textview.b.c> ikq()
  {
    if (this.ZcR == null)
    {
      this.ZcR = new LinkedList();
      Iterator localIterator = this.ZcA.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.neattextview.textview.b.b localb = (com.tencent.neattextview.textview.b.b)localIterator.next();
        if (localb.getClass() == com.tencent.neattextview.textview.b.c.class) {
          this.ZcR.add((com.tencent.neattextview.textview.b.c)localb);
        }
      }
    }
    return this.ZcR;
  }
  
  public final float[] ikr()
  {
    return this.Zcu;
  }
  
  public final String iky()
  {
    return this.Zcs;
  }
  
  public final float[] ikz()
  {
    if (this.ZcH == null)
    {
      Iterator localIterator = this.Zcz.iterator();
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
      this.ZcH = new float[] { f2, f1 };
    }
    return this.ZcH;
  }
  
  public final int nE(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 - this.ZcC);
    paramInt2 = (int)(paramInt2 - this.ZcD);
    Iterator localIterator = this.Zcz.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.ikt().contains(paramInt1, paramInt2)) {
        return localb.aAb(paramInt1);
      }
    }
    return this.Zct.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.c
 * JD-Core Version:    0.7.0.1
 */