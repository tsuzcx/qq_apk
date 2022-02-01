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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements b
{
  private static final TextPaint JKo;
  private static Comparator<Integer> JKp;
  public static boolean cuo;
  private float[] JJM;
  private int JJY;
  private LinkedList<Integer> JKA;
  private float JKB;
  private c JKq;
  private char[] JKr;
  private int JKs;
  private float JKt;
  private boolean JKu;
  private float JKv;
  private float JKw;
  private float JKx;
  private RectF JKy;
  private RectF JKz;
  public int MZ;
  public int atr;
  private float mHeight;
  private float mWidth;
  
  static
  {
    AppMethodBeat.i(39757);
    JKo = new TextPaint(1);
    JKp = new Comparator() {};
    cuo = false;
    AppMethodBeat.o(39757);
  }
  
  public d(c paramc, char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2, float paramFloat3, float paramFloat4, TextPaint paramTextPaint, boolean paramBoolean, float paramFloat5, int paramInt3, int paramInt4, float paramFloat6)
  {
    AppMethodBeat.i(39746);
    this.JKv = -1.0F;
    this.JKw = 0.0F;
    this.JKx = 0.0F;
    this.JKy = new RectF();
    this.JKz = new RectF();
    this.JKA = null;
    this.JKq = paramc;
    this.JKr = paramArrayOfChar;
    this.atr = paramInt1;
    this.MZ = paramInt2;
    this.JKs = paramInt3;
    this.JJM = paramArrayOfFloat;
    this.JKt = paramFloat4;
    this.JKw = paramFloat5;
    this.JKu = paramBoolean;
    this.mHeight = paramFloat3;
    this.mWidth = paramFloat2;
    this.JKx = paramFloat6;
    this.JJY = paramInt4;
    paramc = paramTextPaint.getFontMetrics();
    paramFloat3 = paramc.leading - paramc.top;
    paramFloat4 = paramc.bottom;
    paramFloat5 = paramc.leading;
    this.JKB = ((this.mHeight - paramc.bottom + paramc.top) / 2.0F + paramFloat1 - paramc.top);
    this.JKy.set(0.0F, this.JKB - paramFloat3, 0.0F + paramFloat2, paramFloat4 - paramFloat5 + this.JKB);
    this.JKz.set(0.0F, this.JKB - paramFloat3, 0.0F + paramFloat6, this.JKy.top + this.mHeight);
    AppMethodBeat.o(39746);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(39756);
    this.atr = paramObjectInputStream.readInt();
    this.MZ = paramObjectInputStream.readInt();
    this.JJM = ((float[])paramObjectInputStream.readObject());
    this.JKy = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
    this.JKu = paramObjectInputStream.readBoolean();
    this.JKt = paramObjectInputStream.readFloat();
    this.JKv = paramObjectInputStream.readFloat();
    AppMethodBeat.o(39756);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    AppMethodBeat.i(39755);
    paramObjectOutputStream.writeInt(this.atr);
    paramObjectOutputStream.writeInt(this.MZ);
    paramObjectOutputStream.writeObject(this.JJM);
    paramObjectOutputStream.writeFloat(this.JKy.left);
    paramObjectOutputStream.writeFloat(this.JKy.top);
    paramObjectOutputStream.writeFloat(this.JKy.right);
    paramObjectOutputStream.writeFloat(this.JKy.bottom);
    paramObjectOutputStream.writeBoolean(this.JKu);
    paramObjectOutputStream.writeFloat(this.JKt);
    paramObjectOutputStream.writeFloat(fBt());
    AppMethodBeat.o(39755);
  }
  
  public final void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat)
  {
    AppMethodBeat.i(39747);
    float f2 = fBt();
    Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
    float f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
    int j = this.atr;
    int k = this.MZ;
    Object localObject1 = this.JKq.JKh.JKG;
    Object localObject2 = this.JKq.JKh.JKH;
    LineBackgroundSpan[] arrayOfLineBackgroundSpan = (LineBackgroundSpan[])this.JKq.JKh.JKF;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.JKq.JKh.JKE)
    {
      if ((localObject1[i] < k) && (localObject2[i] > j)) {
        localLinkedList.add(arrayOfLineBackgroundSpan[i]);
      }
      i += 1;
    }
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((LineBackgroundSpan)((Iterator)localObject1).next()).drawBackground(paramCanvas, paramTextPaint, (int)this.JKy.left, (int)this.JKy.right, (int)this.JKy.top, (int)f1, (int)this.JKy.bottom, this.JKq.getText(), this.atr, this.MZ, this.JKs);
    }
    if (cuo) {}
    for (localObject1 = new StringBuilder("canvas w=").append(paramCanvas.getWidth()).append(" canvas h=").append(paramCanvas.getHeight()).append('\n');; localObject1 = null)
    {
      int m = this.atr;
      i = 0;
      k = this.atr;
      f2 = 0.0F + f2;
      int n;
      if (k < this.MZ)
      {
        j = i;
        float f4;
        float f3;
        if (k + 1 < this.MZ)
        {
          j = i;
          f4 = f1;
          n = m;
          f3 = f2;
          if (this.JJM[(k + 1)] == 0.0F) {
            break label561;
          }
          j = i;
          if (i == 0) {
            if ((!this.JKu) || (this.JJM[(k + 1)] != this.JKw)) {
              break label586;
            }
          }
        }
        label561:
        label586:
        for (i = 1;; i = 0)
        {
          j = i;
          f4 = f1;
          n = m;
          f3 = f2;
          if (i == 0)
          {
            j = i;
            n = k + 1;
            localObject2 = (ImageSpan)this.JKq.JKb.ku(m, n);
            if (localObject2 == null) {
              break label592;
            }
            JKo.set(paramTextPaint);
            ((ImageSpan)localObject2).draw(paramCanvas, "", m, n, f2, 0, (int)f1, (int)(this.mHeight + paramFloat), JKo);
            f3 = f2;
            if (j != 0) {
              f3 = f2 + this.JKw;
            }
            j = 0;
            f3 += this.JJM[m] + this.JKt;
            if (cuo) {
              ((StringBuilder)localObject1).append(f3).append(',');
            }
            f4 = f1;
          }
          k += 1;
          i = j;
          f1 = f4;
          m = n;
          f2 = f3;
          break;
        }
        label592:
        i = 0;
        JKo.set(paramTextPaint);
        localObject2 = (AbsoluteSizeSpan)this.JKq.JKc.ku(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((AbsoluteSizeSpan)localObject2).updateDrawState(JKo);
        }
        localObject2 = (RelativeSizeSpan)this.JKq.JKd.ku(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((RelativeSizeSpan)localObject2).updateDrawState(JKo);
        }
        localObject2 = (ForegroundColorSpan)this.JKq.JKf.ku(m, n);
        if (localObject2 != null) {
          ((ForegroundColorSpan)localObject2).updateDrawState(JKo);
        }
        localObject2 = (ClickableSpan)this.JKq.JKg.ku(m, n);
        if (localObject2 != null) {
          ((ClickableSpan)localObject2).updateDrawState(JKo);
        }
        if (i == 0) {
          break label800;
        }
        f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
      }
      label800:
      for (;;)
      {
        paramCanvas.drawText(this.JKr, m, n - m, f2, f1, JKo);
        break;
        AppMethodBeat.o(39747);
        return;
      }
    }
  }
  
  public final int adW(int paramInt)
  {
    AppMethodBeat.i(39751);
    int k = this.atr;
    float f1 = this.JKy.left + fBt();
    int n = this.atr;
    int m = this.atr;
    int i = 0;
    if (m < this.MZ)
    {
      int j = i;
      if (m + 1 < this.MZ)
      {
        j = i;
        if (this.JJM[(m + 1)] != 0.0F)
        {
          j = i;
          if (i != 0) {
            break label156;
          }
          if ((this.JKu) && (this.JJM[(m + 1)] == this.JKw))
          {
            i = 1;
            label118:
            j = i;
            if (i == 0) {
              break label156;
            }
            j = i;
          }
        }
        else
        {
          k += 1;
          i = j;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        i = 0;
        break label118;
        label156:
        float f2 = f1;
        if (j != 0) {
          f2 = f1 + this.JKw;
        }
        f1 = f2 + (this.JJM[n] + this.JKt);
        if ((f2 <= paramInt) && (paramInt < f1))
        {
          AppMethodBeat.o(39751);
          return k;
        }
        if (f2 > paramInt)
        {
          paramInt = this.atr;
          AppMethodBeat.o(39751);
          return paramInt;
        }
        if (paramInt > this.JKy.right)
        {
          if (this.MZ == this.JKr.length)
          {
            paramInt = this.MZ;
            AppMethodBeat.o(39751);
            return paramInt;
          }
          paramInt = this.MZ;
          AppMethodBeat.o(39751);
          return paramInt - 1;
        }
        k += 1;
        i = 0;
        n = m + 1;
      }
    }
    paramInt = this.MZ;
    AppMethodBeat.o(39751);
    return paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(39752);
    if (paramObject == null)
    {
      AppMethodBeat.o(39752);
      return false;
    }
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if ((paramObject.getStart() != this.atr) || (paramObject.getEnd() != this.MZ) || (!paramObject.fBp().equals(this.JKy)) || (paramObject.fBs() != this.JKu) || (paramObject.fBr() != this.JKt) || (paramObject.fBt() != this.JKv))
      {
        AppMethodBeat.o(39752);
        return false;
      }
      int i = this.atr;
      while (i < this.MZ)
      {
        if (this.JJM[i] != paramObject.fBo()[i])
        {
          AppMethodBeat.o(39752);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(39752);
      return true;
    }
    AppMethodBeat.o(39752);
    return false;
  }
  
  public final float[] fBo()
  {
    return this.JJM;
  }
  
  public final RectF fBp()
  {
    return this.JKy;
  }
  
  public final RectF fBq()
  {
    return this.JKz;
  }
  
  public final float fBr()
  {
    return this.JKt;
  }
  
  public final boolean fBs()
  {
    return this.JKu;
  }
  
  public final float fBt()
  {
    AppMethodBeat.i(39749);
    if (this.JKv != -1.0F)
    {
      f1 = this.JKv;
      AppMethodBeat.o(39749);
      return f1;
    }
    if ((this.JJY & 0x7) == 1)
    {
      int j = this.atr;
      int i = this.atr;
      float f2;
      for (f1 = 0.0F; i < this.MZ; f1 = f2)
      {
        int k;
        if (i + 1 < this.MZ)
        {
          k = j;
          f2 = f1;
          if (this.JJM[(i + 1)] == 0.0F) {}
        }
        else
        {
          f2 = f1 + (this.JJM[j] + this.JKt);
          k = i + 1;
        }
        i += 1;
        j = k;
      }
    }
    for (float f1 = (this.JKx - f1) / 2.0F;; f1 = 0.0F)
    {
      f1 = Math.max(0.0F, f1);
      if ((this.JKq.JKb.ku(this.atr, this.atr + 1) == null) && (this.JKq.fBx().containsKey(Character.valueOf(this.JKr[this.atr]))))
      {
        f1 -= ((Float)this.JKq.fBx().get(Character.valueOf(this.JKr[this.atr]))).floatValue();
        this.JKv = f1;
        AppMethodBeat.o(39749);
        return f1;
      }
      this.JKv = f1;
      f1 = this.JKv;
      AppMethodBeat.o(39749);
      return f1;
    }
  }
  
  public final float fBu()
  {
    return this.JKB;
  }
  
  public final int getEnd()
  {
    return this.MZ;
  }
  
  public final float getHeight()
  {
    return this.mHeight;
  }
  
  public final float getPrimaryHorizontal(int paramInt)
  {
    AppMethodBeat.i(39750);
    float f1 = this.JKy.left + fBt();
    int m = this.atr;
    int k = this.atr;
    int i = 0;
    if ((k < this.MZ) && (k < paramInt))
    {
      int j = i;
      int n;
      float f2;
      if (k + 1 < this.MZ)
      {
        j = i;
        n = m;
        f2 = f1;
        if (this.JJM[(k + 1)] == 0.0F) {
          break label181;
        }
        j = i;
        if (i == 0) {
          if ((!this.JKu) || (this.JJM[(k + 1)] != this.JKw)) {
            break label200;
          }
        }
      }
      label181:
      label200:
      for (i = 1;; i = 0)
      {
        j = i;
        n = m;
        f2 = f1;
        if (i == 0)
        {
          j = i;
          f2 = f1;
          if (j != 0) {
            f2 = f1 + this.JKw;
          }
          f2 += this.JJM[m] + this.JKt;
          j = 0;
          n = k + 1;
        }
        k += 1;
        i = j;
        m = n;
        f1 = f2;
        break;
      }
    }
    AppMethodBeat.o(39750);
    return f1;
  }
  
  public final int getStart()
  {
    return this.atr;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(39753);
    int i = this.atr;
    int j = this.MZ;
    int k = (int)this.mHeight;
    int m = (int)this.mWidth;
    int n = (int)this.JKv;
    int i1 = this.JKy.hashCode();
    AppMethodBeat.o(39753);
    return i + j + k + m + n + i1;
  }
  
  public final RectF kt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39748);
    RectF localRectF = new RectF();
    if (paramInt1 >= paramInt2)
    {
      AppMethodBeat.o(39748);
      return localRectF;
    }
    float f1 = fBt();
    int i = this.atr;
    while (i < paramInt1)
    {
      f1 += this.JJM[i] + this.JKt;
      i += 1;
    }
    float f2 = f1;
    while (paramInt1 < paramInt2)
    {
      f2 += this.JJM[paramInt1] + this.JKt;
      paramInt1 += 1;
    }
    localRectF.set(f1, this.JKy.top, f2, this.JKy.bottom);
    AppMethodBeat.o(39748);
    return localRectF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(39754);
    String str = "MeasuredLine{mStart=" + this.atr + ", mEnd=" + this.MZ + ", mLetter=" + this.JKt + ", isSmartLetter=" + this.JKu + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.JKv + ", mLineRect=" + this.JKy + ", mLineRect=" + this.JKz + '}';
    AppMethodBeat.o(39754);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.d
 * JD-Core Version:    0.7.0.1
 */