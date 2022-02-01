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
  private static final TextPaint ZcW;
  private static Comparator<Integer> ZcX;
  public static boolean dal;
  private int FVT;
  private c ZcY;
  private char[] ZcZ;
  private float[] Zcu;
  private int Zda;
  private float Zdb;
  private boolean Zdc;
  private float Zdd;
  private float Zde;
  private float Zdf;
  private RectF Zdg;
  private RectF Zdh;
  private LinkedList<Integer> Zdi;
  private float Zdj;
  private float mHeight;
  private float mWidth;
  public int tH;
  public int tI;
  
  static
  {
    AppMethodBeat.i(39757);
    ZcW = new TextPaint(1);
    ZcX = new d.1();
    dal = false;
    AppMethodBeat.o(39757);
  }
  
  public d(c paramc, char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2, float paramFloat3, float paramFloat4, TextPaint paramTextPaint, boolean paramBoolean, float paramFloat5, int paramInt3, int paramInt4, float paramFloat6)
  {
    AppMethodBeat.i(39746);
    this.Zdd = -1.0F;
    this.Zde = 0.0F;
    this.Zdf = 0.0F;
    this.Zdg = new RectF();
    this.Zdh = new RectF();
    this.Zdi = null;
    this.ZcY = paramc;
    this.ZcZ = paramArrayOfChar;
    this.tH = paramInt1;
    this.tI = paramInt2;
    this.Zda = paramInt3;
    this.Zcu = paramArrayOfFloat;
    this.Zdb = paramFloat4;
    this.Zde = paramFloat5;
    this.Zdc = paramBoolean;
    this.mHeight = paramFloat3;
    this.mWidth = paramFloat2;
    this.Zdf = paramFloat6;
    this.FVT = paramInt4;
    paramc = paramTextPaint.getFontMetrics();
    paramFloat3 = paramc.leading - paramc.top;
    paramFloat4 = paramc.bottom;
    paramFloat5 = paramc.leading;
    this.Zdj = ((this.mHeight - paramc.bottom + paramc.top) / 2.0F + paramFloat1 - paramc.top);
    this.Zdg.set(0.0F, this.Zdj - paramFloat3, 0.0F + paramFloat2, paramFloat4 - paramFloat5 + this.Zdj);
    this.Zdh.set(0.0F, this.Zdj - paramFloat3, 0.0F + paramFloat6, this.Zdg.top + this.mHeight);
    AppMethodBeat.o(39746);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(39756);
    this.tH = paramObjectInputStream.readInt();
    this.tI = paramObjectInputStream.readInt();
    this.Zcu = ((float[])paramObjectInputStream.readObject());
    this.Zdg = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
    this.Zdc = paramObjectInputStream.readBoolean();
    this.Zdb = paramObjectInputStream.readFloat();
    this.Zdd = paramObjectInputStream.readFloat();
    AppMethodBeat.o(39756);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    AppMethodBeat.i(39755);
    paramObjectOutputStream.writeInt(this.tH);
    paramObjectOutputStream.writeInt(this.tI);
    paramObjectOutputStream.writeObject(this.Zcu);
    paramObjectOutputStream.writeFloat(this.Zdg.left);
    paramObjectOutputStream.writeFloat(this.Zdg.top);
    paramObjectOutputStream.writeFloat(this.Zdg.right);
    paramObjectOutputStream.writeFloat(this.Zdg.bottom);
    paramObjectOutputStream.writeBoolean(this.Zdc);
    paramObjectOutputStream.writeFloat(this.Zdb);
    paramObjectOutputStream.writeFloat(ikw());
    AppMethodBeat.o(39755);
  }
  
  public final void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat)
  {
    AppMethodBeat.i(39747);
    float f2 = ikw();
    Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
    float f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
    int j = this.tH;
    int k = this.tI;
    Object localObject1 = this.ZcY.ZcP.Zdo;
    Object localObject2 = this.ZcY.ZcP.Zdp;
    LineBackgroundSpan[] arrayOfLineBackgroundSpan = (LineBackgroundSpan[])this.ZcY.ZcP.Zdn;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.ZcY.ZcP.Zdm)
    {
      if ((localObject1[i] < k) && (localObject2[i] > j)) {
        localLinkedList.add(arrayOfLineBackgroundSpan[i]);
      }
      i += 1;
    }
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((LineBackgroundSpan)((Iterator)localObject1).next()).drawBackground(paramCanvas, paramTextPaint, (int)this.Zdg.left, (int)this.Zdg.right, (int)this.Zdg.top, (int)f1, (int)this.Zdg.bottom, this.ZcY.getText(), this.tH, this.tI, this.Zda);
    }
    if (dal) {}
    for (localObject1 = new StringBuilder("canvas w=").append(paramCanvas.getWidth()).append(" canvas h=").append(paramCanvas.getHeight()).append('\n');; localObject1 = null)
    {
      int m = this.tH;
      i = 0;
      k = this.tH;
      f2 = 0.0F + f2;
      int n;
      if (k < this.tI)
      {
        j = i;
        float f4;
        float f3;
        if (k + 1 < this.tI)
        {
          j = i;
          f4 = f1;
          n = m;
          f3 = f2;
          if (this.Zcu[(k + 1)] == 0.0F) {
            break label561;
          }
          j = i;
          if (i == 0) {
            if ((!this.Zdc) || (this.Zcu[(k + 1)] != this.Zde)) {
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
            localObject2 = (ImageSpan)this.ZcY.ZcI.nG(m, n);
            if (localObject2 == null) {
              break label592;
            }
            ZcW.set(paramTextPaint);
            ((ImageSpan)localObject2).draw(paramCanvas, "", m, n, f2, 0, (int)f1, (int)(this.mHeight + paramFloat), ZcW);
            f3 = f2;
            if (j != 0) {
              f3 = f2 + this.Zde;
            }
            j = 0;
            f3 += this.Zcu[m] + this.Zdb;
            if (dal) {
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
        ZcW.set(paramTextPaint);
        localObject2 = (AbsoluteSizeSpan)this.ZcY.ZcK.nG(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((AbsoluteSizeSpan)localObject2).updateDrawState(ZcW);
        }
        localObject2 = (RelativeSizeSpan)this.ZcY.ZcL.nG(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((RelativeSizeSpan)localObject2).updateDrawState(ZcW);
        }
        localObject2 = (ForegroundColorSpan)this.ZcY.ZcN.nG(m, n);
        if (localObject2 != null) {
          ((ForegroundColorSpan)localObject2).updateDrawState(ZcW);
        }
        localObject2 = (ClickableSpan)this.ZcY.ZcO.nG(m, n);
        if (localObject2 != null) {
          ((ClickableSpan)localObject2).updateDrawState(ZcW);
        }
        if (i == 0) {
          break label800;
        }
        f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
      }
      label800:
      for (;;)
      {
        paramCanvas.drawText(this.ZcZ, m, n - m, f2, f1, ZcW);
        break;
        AppMethodBeat.o(39747);
        return;
      }
    }
  }
  
  public final int aAb(int paramInt)
  {
    AppMethodBeat.i(39751);
    int k = this.tH;
    float f1 = this.Zdg.left + ikw();
    int n = this.tH;
    int m = this.tH;
    int i = 0;
    if (m < this.tI)
    {
      int j = i;
      if (m + 1 < this.tI)
      {
        j = i;
        if (this.Zcu[(m + 1)] != 0.0F)
        {
          j = i;
          if (i != 0) {
            break label156;
          }
          if ((this.Zdc) && (this.Zcu[(m + 1)] == this.Zde))
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
          f2 = f1 + this.Zde;
        }
        f1 = f2 + (this.Zcu[n] + this.Zdb);
        if ((f2 <= paramInt) && (paramInt < f1))
        {
          AppMethodBeat.o(39751);
          return k;
        }
        if (f2 > paramInt)
        {
          paramInt = this.tH;
          AppMethodBeat.o(39751);
          return paramInt;
        }
        if (paramInt > this.Zdg.right)
        {
          if (this.tI == this.ZcZ.length)
          {
            paramInt = this.tI;
            AppMethodBeat.o(39751);
            return paramInt;
          }
          paramInt = this.tI;
          AppMethodBeat.o(39751);
          return paramInt - 1;
        }
        k += 1;
        i = 0;
        n = m + 1;
      }
    }
    paramInt = this.tI;
    AppMethodBeat.o(39751);
    return paramInt;
  }
  
  public final float azU(int paramInt)
  {
    AppMethodBeat.i(39750);
    float f1 = this.Zdg.left + ikw();
    int m = this.tH;
    int k = this.tH;
    int i = 0;
    if ((k < this.tI) && (k < paramInt))
    {
      int j = i;
      int n;
      float f2;
      if (k + 1 < this.tI)
      {
        j = i;
        n = m;
        f2 = f1;
        if (this.Zcu[(k + 1)] == 0.0F) {
          break label181;
        }
        j = i;
        if (i == 0) {
          if ((!this.Zdc) || (this.Zcu[(k + 1)] != this.Zde)) {
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
            f2 = f1 + this.Zde;
          }
          f2 += this.Zcu[m] + this.Zdb;
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
      if ((paramObject.getStart() != this.tH) || (paramObject.getEnd() != this.tI) || (!paramObject.iks().equals(this.Zdg)) || (paramObject.ikv() != this.Zdc) || (paramObject.iku() != this.Zdb) || (paramObject.ikw() != this.Zdd))
      {
        AppMethodBeat.o(39752);
        return false;
      }
      int i = this.tH;
      while (i < this.tI)
      {
        if (this.Zcu[i] != paramObject.ikr()[i])
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
  
  public final int getEnd()
  {
    return this.tI;
  }
  
  public final float getHeight()
  {
    return this.mHeight;
  }
  
  public final int getStart()
  {
    return this.tH;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(39753);
    int i = this.tH;
    int j = this.tI;
    int k = (int)this.mHeight;
    int m = (int)this.mWidth;
    int n = (int)this.Zdd;
    int i1 = this.Zdg.hashCode();
    AppMethodBeat.o(39753);
    return i + j + k + m + n + i1;
  }
  
  public final float[] ikr()
  {
    return this.Zcu;
  }
  
  public final RectF iks()
  {
    return this.Zdg;
  }
  
  public final RectF ikt()
  {
    return this.Zdh;
  }
  
  public final float iku()
  {
    return this.Zdb;
  }
  
  public final boolean ikv()
  {
    return this.Zdc;
  }
  
  public final float ikw()
  {
    AppMethodBeat.i(39749);
    if (this.Zdd != -1.0F)
    {
      f1 = this.Zdd;
      AppMethodBeat.o(39749);
      return f1;
    }
    if ((this.FVT & 0x7) == 1)
    {
      int j = this.tH;
      int i = this.tH;
      float f2;
      for (f1 = 0.0F; i < this.tI; f1 = f2)
      {
        int k;
        if (i + 1 < this.tI)
        {
          k = j;
          f2 = f1;
          if (this.Zcu[(i + 1)] == 0.0F) {}
        }
        else
        {
          f2 = f1 + (this.Zcu[j] + this.Zdb);
          k = i + 1;
        }
        i += 1;
        j = k;
      }
    }
    for (float f1 = (this.Zdf - f1) / 2.0F;; f1 = 0.0F)
    {
      f1 = Math.max(0.0F, f1);
      if ((this.ZcY.ZcI.nG(this.tH, this.tH + 1) == null) && (this.ZcY.ikA().containsKey(Character.valueOf(this.ZcZ[this.tH]))))
      {
        f1 -= ((Float)this.ZcY.ikA().get(Character.valueOf(this.ZcZ[this.tH]))).floatValue();
        this.Zdd = f1;
        AppMethodBeat.o(39749);
        return f1;
      }
      this.Zdd = f1;
      f1 = this.Zdd;
      AppMethodBeat.o(39749);
      return f1;
    }
  }
  
  public final float ikx()
  {
    return this.Zdj;
  }
  
  public final RectF nF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39748);
    RectF localRectF = new RectF();
    if (paramInt1 >= paramInt2)
    {
      AppMethodBeat.o(39748);
      return localRectF;
    }
    float f1 = ikw();
    int i = this.tH;
    while (i < paramInt1)
    {
      f1 += this.Zcu[i] + this.Zdb;
      i += 1;
    }
    float f2 = f1;
    while (paramInt1 < paramInt2)
    {
      f2 += this.Zcu[paramInt1] + this.Zdb;
      paramInt1 += 1;
    }
    localRectF.set(f1, this.Zdg.top, f2, this.Zdg.bottom);
    AppMethodBeat.o(39748);
    return localRectF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(39754);
    String str = "MeasuredLine{mStart=" + this.tH + ", mEnd=" + this.tI + ", mLetter=" + this.Zdb + ", isSmartLetter=" + this.Zdc + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.Zdd + ", mLineRect=" + this.Zdg + ", mLineRect=" + this.Zdh + '}';
    AppMethodBeat.o(39754);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.d
 * JD-Core Version:    0.7.0.1
 */