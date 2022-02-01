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
  private static final TextPaint IiD;
  private static Comparator<Integer> IiE;
  public static boolean cxf;
  private c IiF;
  private char[] IiG;
  private int IiH;
  private float IiI;
  private boolean IiJ;
  private float IiK;
  private float IiL;
  private float IiM;
  private RectF IiN;
  private RectF IiO;
  private LinkedList<Integer> IiP;
  private float IiQ;
  private float[] Iid;
  private int Iin;
  public int Mc;
  public int asw;
  private float mHeight;
  private float mWidth;
  
  static
  {
    AppMethodBeat.i(39757);
    IiD = new TextPaint(1);
    IiE = new Comparator() {};
    cxf = false;
    AppMethodBeat.o(39757);
  }
  
  public d(c paramc, char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2, float paramFloat3, float paramFloat4, TextPaint paramTextPaint, boolean paramBoolean, float paramFloat5, int paramInt3, int paramInt4, float paramFloat6)
  {
    AppMethodBeat.i(39746);
    this.IiK = -1.0F;
    this.IiL = 0.0F;
    this.IiM = 0.0F;
    this.IiN = new RectF();
    this.IiO = new RectF();
    this.IiP = null;
    this.IiF = paramc;
    this.IiG = paramArrayOfChar;
    this.asw = paramInt1;
    this.Mc = paramInt2;
    this.IiH = paramInt3;
    this.Iid = paramArrayOfFloat;
    this.IiI = paramFloat4;
    this.IiL = paramFloat5;
    this.IiJ = paramBoolean;
    this.mHeight = paramFloat3;
    this.mWidth = paramFloat2;
    this.IiM = paramFloat6;
    this.Iin = paramInt4;
    paramc = paramTextPaint.getFontMetrics();
    paramFloat3 = paramc.leading - paramc.top;
    paramFloat4 = paramc.bottom;
    paramFloat5 = paramc.leading;
    this.IiQ = ((this.mHeight - paramc.bottom + paramc.top) / 2.0F + paramFloat1 - paramc.top);
    this.IiN.set(0.0F, this.IiQ - paramFloat3, 0.0F + paramFloat2, paramFloat4 - paramFloat5 + this.IiQ);
    this.IiO.set(0.0F, this.IiQ - paramFloat3, 0.0F + paramFloat6, this.IiN.top + this.mHeight);
    AppMethodBeat.o(39746);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(39756);
    this.asw = paramObjectInputStream.readInt();
    this.Mc = paramObjectInputStream.readInt();
    this.Iid = ((float[])paramObjectInputStream.readObject());
    this.IiN = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
    this.IiJ = paramObjectInputStream.readBoolean();
    this.IiI = paramObjectInputStream.readFloat();
    this.IiK = paramObjectInputStream.readFloat();
    AppMethodBeat.o(39756);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    AppMethodBeat.i(39755);
    paramObjectOutputStream.writeInt(this.asw);
    paramObjectOutputStream.writeInt(this.Mc);
    paramObjectOutputStream.writeObject(this.Iid);
    paramObjectOutputStream.writeFloat(this.IiN.left);
    paramObjectOutputStream.writeFloat(this.IiN.top);
    paramObjectOutputStream.writeFloat(this.IiN.right);
    paramObjectOutputStream.writeFloat(this.IiN.bottom);
    paramObjectOutputStream.writeBoolean(this.IiJ);
    paramObjectOutputStream.writeFloat(this.IiI);
    paramObjectOutputStream.writeFloat(flc());
    AppMethodBeat.o(39755);
  }
  
  public final void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat)
  {
    AppMethodBeat.i(39747);
    float f2 = flc();
    Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
    float f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
    int j = this.asw;
    int k = this.Mc;
    Object localObject1 = this.IiF.Iiw.IiV;
    Object localObject2 = this.IiF.Iiw.IiW;
    LineBackgroundSpan[] arrayOfLineBackgroundSpan = (LineBackgroundSpan[])this.IiF.Iiw.IiU;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.IiF.Iiw.IiT)
    {
      if ((localObject1[i] < k) && (localObject2[i] > j)) {
        localLinkedList.add(arrayOfLineBackgroundSpan[i]);
      }
      i += 1;
    }
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((LineBackgroundSpan)((Iterator)localObject1).next()).drawBackground(paramCanvas, paramTextPaint, (int)this.IiN.left, (int)this.IiN.right, (int)this.IiN.top, (int)f1, (int)this.IiN.bottom, this.IiF.getText(), this.asw, this.Mc, this.IiH);
    }
    if (cxf) {}
    for (localObject1 = new StringBuilder("canvas w=").append(paramCanvas.getWidth()).append(" canvas h=").append(paramCanvas.getHeight()).append('\n');; localObject1 = null)
    {
      int m = this.asw;
      i = 0;
      k = this.asw;
      f2 = 0.0F + f2;
      int n;
      if (k < this.Mc)
      {
        j = i;
        float f4;
        float f3;
        if (k + 1 < this.Mc)
        {
          j = i;
          f4 = f1;
          n = m;
          f3 = f2;
          if (this.Iid[(k + 1)] == 0.0F) {
            break label561;
          }
          j = i;
          if (i == 0) {
            if ((!this.IiJ) || (this.Iid[(k + 1)] != this.IiL)) {
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
            localObject2 = (ImageSpan)this.IiF.Iiq.kh(m, n);
            if (localObject2 == null) {
              break label592;
            }
            IiD.set(paramTextPaint);
            ((ImageSpan)localObject2).draw(paramCanvas, "", m, n, f2, 0, (int)f1, (int)(this.mHeight + paramFloat), IiD);
            f3 = f2;
            if (j != 0) {
              f3 = f2 + this.IiL;
            }
            j = 0;
            f3 += this.Iid[m] + this.IiI;
            if (cxf) {
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
        IiD.set(paramTextPaint);
        localObject2 = (AbsoluteSizeSpan)this.IiF.Iir.kh(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((AbsoluteSizeSpan)localObject2).updateDrawState(IiD);
        }
        localObject2 = (RelativeSizeSpan)this.IiF.Iis.kh(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((RelativeSizeSpan)localObject2).updateDrawState(IiD);
        }
        localObject2 = (ForegroundColorSpan)this.IiF.Iiu.kh(m, n);
        if (localObject2 != null) {
          ((ForegroundColorSpan)localObject2).updateDrawState(IiD);
        }
        localObject2 = (ClickableSpan)this.IiF.Iiv.kh(m, n);
        if (localObject2 != null) {
          ((ClickableSpan)localObject2).updateDrawState(IiD);
        }
        if (i == 0) {
          break label800;
        }
        f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
      }
      label800:
      for (;;)
      {
        paramCanvas.drawText(this.IiG, m, n - m, f2, f1, IiD);
        break;
        AppMethodBeat.o(39747);
        return;
      }
    }
  }
  
  public final int abD(int paramInt)
  {
    AppMethodBeat.i(39751);
    int k = this.asw;
    float f1 = this.IiN.left + flc();
    int n = this.asw;
    int m = this.asw;
    int i = 0;
    if (m < this.Mc)
    {
      int j = i;
      if (m + 1 < this.Mc)
      {
        j = i;
        if (this.Iid[(m + 1)] != 0.0F)
        {
          j = i;
          if (i != 0) {
            break label156;
          }
          if ((this.IiJ) && (this.Iid[(m + 1)] == this.IiL))
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
          f2 = f1 + this.IiL;
        }
        f1 = f2 + (this.Iid[n] + this.IiI);
        if ((f2 <= paramInt) && (paramInt < f1))
        {
          AppMethodBeat.o(39751);
          return k;
        }
        if (f2 > paramInt)
        {
          paramInt = this.asw;
          AppMethodBeat.o(39751);
          return paramInt;
        }
        if (paramInt > this.IiN.right)
        {
          if (this.Mc == this.IiG.length)
          {
            paramInt = this.Mc;
            AppMethodBeat.o(39751);
            return paramInt;
          }
          paramInt = this.Mc;
          AppMethodBeat.o(39751);
          return paramInt - 1;
        }
        k += 1;
        i = 0;
        n = m + 1;
      }
    }
    paramInt = this.Mc;
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
      if ((paramObject.getStart() != this.asw) || (paramObject.getEnd() != this.Mc) || (!paramObject.fkY().equals(this.IiN)) || (paramObject.flb() != this.IiJ) || (paramObject.fla() != this.IiI) || (paramObject.flc() != this.IiK))
      {
        AppMethodBeat.o(39752);
        return false;
      }
      int i = this.asw;
      while (i < this.Mc)
      {
        if (this.Iid[i] != paramObject.fkX()[i])
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
  
  public final float[] fkX()
  {
    return this.Iid;
  }
  
  public final RectF fkY()
  {
    return this.IiN;
  }
  
  public final RectF fkZ()
  {
    return this.IiO;
  }
  
  public final float fla()
  {
    return this.IiI;
  }
  
  public final boolean flb()
  {
    return this.IiJ;
  }
  
  public final float flc()
  {
    AppMethodBeat.i(39749);
    if (this.IiK != -1.0F)
    {
      f1 = this.IiK;
      AppMethodBeat.o(39749);
      return f1;
    }
    if ((this.Iin & 0x7) == 1)
    {
      int j = this.asw;
      int i = this.asw;
      float f2;
      for (f1 = 0.0F; i < this.Mc; f1 = f2)
      {
        int k;
        if (i + 1 < this.Mc)
        {
          k = j;
          f2 = f1;
          if (this.Iid[(i + 1)] == 0.0F) {}
        }
        else
        {
          f2 = f1 + (this.Iid[j] + this.IiI);
          k = i + 1;
        }
        i += 1;
        j = k;
      }
    }
    for (float f1 = (this.IiM - f1) / 2.0F;; f1 = 0.0F)
    {
      f1 = Math.max(0.0F, f1);
      if ((this.IiF.Iiq.kh(this.asw, this.asw + 1) == null) && (this.IiF.flg().containsKey(Character.valueOf(this.IiG[this.asw]))))
      {
        f1 -= ((Float)this.IiF.flg().get(Character.valueOf(this.IiG[this.asw]))).floatValue();
        this.IiK = f1;
        AppMethodBeat.o(39749);
        return f1;
      }
      this.IiK = f1;
      f1 = this.IiK;
      AppMethodBeat.o(39749);
      return f1;
    }
  }
  
  public final float fld()
  {
    return this.IiQ;
  }
  
  public final int getEnd()
  {
    return this.Mc;
  }
  
  public final float getHeight()
  {
    return this.mHeight;
  }
  
  public final float getPrimaryHorizontal(int paramInt)
  {
    AppMethodBeat.i(39750);
    float f1 = this.IiN.left + flc();
    int m = this.asw;
    int k = this.asw;
    int i = 0;
    if ((k < this.Mc) && (k < paramInt))
    {
      int j = i;
      int n;
      float f2;
      if (k + 1 < this.Mc)
      {
        j = i;
        n = m;
        f2 = f1;
        if (this.Iid[(k + 1)] == 0.0F) {
          break label181;
        }
        j = i;
        if (i == 0) {
          if ((!this.IiJ) || (this.Iid[(k + 1)] != this.IiL)) {
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
            f2 = f1 + this.IiL;
          }
          f2 += this.Iid[m] + this.IiI;
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
    return this.asw;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(39753);
    int i = this.asw;
    int j = this.Mc;
    int k = (int)this.mHeight;
    int m = (int)this.mWidth;
    int n = (int)this.IiK;
    int i1 = this.IiN.hashCode();
    AppMethodBeat.o(39753);
    return i + j + k + m + n + i1;
  }
  
  public final RectF kg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39748);
    RectF localRectF = new RectF();
    if (paramInt1 >= paramInt2)
    {
      AppMethodBeat.o(39748);
      return localRectF;
    }
    float f1 = flc();
    int i = this.asw;
    while (i < paramInt1)
    {
      f1 += this.Iid[i] + this.IiI;
      i += 1;
    }
    float f2 = f1;
    while (paramInt1 < paramInt2)
    {
      f2 += this.Iid[paramInt1] + this.IiI;
      paramInt1 += 1;
    }
    localRectF.set(f1, this.IiN.top, f2, this.IiN.bottom);
    AppMethodBeat.o(39748);
    return localRectF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(39754);
    String str = "MeasuredLine{mStart=" + this.asw + ", mEnd=" + this.Mc + ", mLetter=" + this.IiI + ", isSmartLetter=" + this.IiJ + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.IiK + ", mLineRect=" + this.IiN + ", mLineRect=" + this.IiO + '}';
    AppMethodBeat.o(39754);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.d
 * JD-Core Version:    0.7.0.1
 */