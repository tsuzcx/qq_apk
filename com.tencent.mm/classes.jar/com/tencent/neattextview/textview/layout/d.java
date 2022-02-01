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
  private static final TextPaint RBu;
  private static Comparator<Integer> RBv;
  public static boolean cWq;
  private int AoL;
  public int Pc;
  private float[] RAR;
  private boolean RBA;
  private float RBB;
  private float RBC;
  private float RBD;
  private RectF RBE;
  private RectF RBF;
  private LinkedList<Integer> RBG;
  private float RBH;
  private c RBw;
  private char[] RBx;
  private int RBy;
  private float RBz;
  public int avh;
  private float mHeight;
  private float mWidth;
  
  static
  {
    AppMethodBeat.i(39757);
    RBu = new TextPaint(1);
    RBv = new Comparator() {};
    cWq = false;
    AppMethodBeat.o(39757);
  }
  
  public d(c paramc, char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2, float paramFloat3, float paramFloat4, TextPaint paramTextPaint, boolean paramBoolean, float paramFloat5, int paramInt3, int paramInt4, float paramFloat6)
  {
    AppMethodBeat.i(39746);
    this.RBB = -1.0F;
    this.RBC = 0.0F;
    this.RBD = 0.0F;
    this.RBE = new RectF();
    this.RBF = new RectF();
    this.RBG = null;
    this.RBw = paramc;
    this.RBx = paramArrayOfChar;
    this.avh = paramInt1;
    this.Pc = paramInt2;
    this.RBy = paramInt3;
    this.RAR = paramArrayOfFloat;
    this.RBz = paramFloat4;
    this.RBC = paramFloat5;
    this.RBA = paramBoolean;
    this.mHeight = paramFloat3;
    this.mWidth = paramFloat2;
    this.RBD = paramFloat6;
    this.AoL = paramInt4;
    paramc = paramTextPaint.getFontMetrics();
    paramFloat3 = paramc.leading - paramc.top;
    paramFloat4 = paramc.bottom;
    paramFloat5 = paramc.leading;
    this.RBH = ((this.mHeight - paramc.bottom + paramc.top) / 2.0F + paramFloat1 - paramc.top);
    this.RBE.set(0.0F, this.RBH - paramFloat3, 0.0F + paramFloat2, paramFloat4 - paramFloat5 + this.RBH);
    this.RBF.set(0.0F, this.RBH - paramFloat3, 0.0F + paramFloat6, this.RBE.top + this.mHeight);
    AppMethodBeat.o(39746);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(39756);
    this.avh = paramObjectInputStream.readInt();
    this.Pc = paramObjectInputStream.readInt();
    this.RAR = ((float[])paramObjectInputStream.readObject());
    this.RBE = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
    this.RBA = paramObjectInputStream.readBoolean();
    this.RBz = paramObjectInputStream.readFloat();
    this.RBB = paramObjectInputStream.readFloat();
    AppMethodBeat.o(39756);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    AppMethodBeat.i(39755);
    paramObjectOutputStream.writeInt(this.avh);
    paramObjectOutputStream.writeInt(this.Pc);
    paramObjectOutputStream.writeObject(this.RAR);
    paramObjectOutputStream.writeFloat(this.RBE.left);
    paramObjectOutputStream.writeFloat(this.RBE.top);
    paramObjectOutputStream.writeFloat(this.RBE.right);
    paramObjectOutputStream.writeFloat(this.RBE.bottom);
    paramObjectOutputStream.writeBoolean(this.RBA);
    paramObjectOutputStream.writeFloat(this.RBz);
    paramObjectOutputStream.writeFloat(hiN());
    AppMethodBeat.o(39755);
  }
  
  public final void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat)
  {
    AppMethodBeat.i(39747);
    float f2 = hiN();
    Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
    float f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
    int j = this.avh;
    int k = this.Pc;
    Object localObject1 = this.RBw.RBn.RBM;
    Object localObject2 = this.RBw.RBn.RBN;
    LineBackgroundSpan[] arrayOfLineBackgroundSpan = (LineBackgroundSpan[])this.RBw.RBn.RBL;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.RBw.RBn.RBK)
    {
      if ((localObject1[i] < k) && (localObject2[i] > j)) {
        localLinkedList.add(arrayOfLineBackgroundSpan[i]);
      }
      i += 1;
    }
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((LineBackgroundSpan)((Iterator)localObject1).next()).drawBackground(paramCanvas, paramTextPaint, (int)this.RBE.left, (int)this.RBE.right, (int)this.RBE.top, (int)f1, (int)this.RBE.bottom, this.RBw.getText(), this.avh, this.Pc, this.RBy);
    }
    if (cWq) {}
    for (localObject1 = new StringBuilder("canvas w=").append(paramCanvas.getWidth()).append(" canvas h=").append(paramCanvas.getHeight()).append('\n');; localObject1 = null)
    {
      int m = this.avh;
      i = 0;
      k = this.avh;
      f2 = 0.0F + f2;
      int n;
      if (k < this.Pc)
      {
        j = i;
        float f4;
        float f3;
        if (k + 1 < this.Pc)
        {
          j = i;
          f4 = f1;
          n = m;
          f3 = f2;
          if (this.RAR[(k + 1)] == 0.0F) {
            break label561;
          }
          j = i;
          if (i == 0) {
            if ((!this.RBA) || (this.RAR[(k + 1)] != this.RBC)) {
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
            localObject2 = (ImageSpan)this.RBw.RBg.mp(m, n);
            if (localObject2 == null) {
              break label592;
            }
            RBu.set(paramTextPaint);
            ((ImageSpan)localObject2).draw(paramCanvas, "", m, n, f2, 0, (int)f1, (int)(this.mHeight + paramFloat), RBu);
            f3 = f2;
            if (j != 0) {
              f3 = f2 + this.RBC;
            }
            j = 0;
            f3 += this.RAR[m] + this.RBz;
            if (cWq) {
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
        RBu.set(paramTextPaint);
        localObject2 = (AbsoluteSizeSpan)this.RBw.RBi.mp(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((AbsoluteSizeSpan)localObject2).updateDrawState(RBu);
        }
        localObject2 = (RelativeSizeSpan)this.RBw.RBj.mp(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((RelativeSizeSpan)localObject2).updateDrawState(RBu);
        }
        localObject2 = (ForegroundColorSpan)this.RBw.RBl.mp(m, n);
        if (localObject2 != null) {
          ((ForegroundColorSpan)localObject2).updateDrawState(RBu);
        }
        localObject2 = (ClickableSpan)this.RBw.RBm.mp(m, n);
        if (localObject2 != null) {
          ((ClickableSpan)localObject2).updateDrawState(RBu);
        }
        if (i == 0) {
          break label800;
        }
        f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
      }
      label800:
      for (;;)
      {
        paramCanvas.drawText(this.RBx, m, n - m, f2, f1, RBu);
        break;
        AppMethodBeat.o(39747);
        return;
      }
    }
  }
  
  public final int aqs(int paramInt)
  {
    AppMethodBeat.i(39751);
    int k = this.avh;
    float f1 = this.RBE.left + hiN();
    int n = this.avh;
    int m = this.avh;
    int i = 0;
    if (m < this.Pc)
    {
      int j = i;
      if (m + 1 < this.Pc)
      {
        j = i;
        if (this.RAR[(m + 1)] != 0.0F)
        {
          j = i;
          if (i != 0) {
            break label156;
          }
          if ((this.RBA) && (this.RAR[(m + 1)] == this.RBC))
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
          f2 = f1 + this.RBC;
        }
        f1 = f2 + (this.RAR[n] + this.RBz);
        if ((f2 <= paramInt) && (paramInt < f1))
        {
          AppMethodBeat.o(39751);
          return k;
        }
        if (f2 > paramInt)
        {
          paramInt = this.avh;
          AppMethodBeat.o(39751);
          return paramInt;
        }
        if (paramInt > this.RBE.right)
        {
          if (this.Pc == this.RBx.length)
          {
            paramInt = this.Pc;
            AppMethodBeat.o(39751);
            return paramInt;
          }
          paramInt = this.Pc;
          AppMethodBeat.o(39751);
          return paramInt - 1;
        }
        k += 1;
        i = 0;
        n = m + 1;
      }
    }
    paramInt = this.Pc;
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
      if ((paramObject.getStart() != this.avh) || (paramObject.getEnd() != this.Pc) || (!paramObject.hiJ().equals(this.RBE)) || (paramObject.hiM() != this.RBA) || (paramObject.hiL() != this.RBz) || (paramObject.hiN() != this.RBB))
      {
        AppMethodBeat.o(39752);
        return false;
      }
      int i = this.avh;
      while (i < this.Pc)
      {
        if (this.RAR[i] != paramObject.hiI()[i])
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
    return this.Pc;
  }
  
  public final float getHeight()
  {
    return this.mHeight;
  }
  
  public final float getPrimaryHorizontal(int paramInt)
  {
    AppMethodBeat.i(39750);
    float f1 = this.RBE.left + hiN();
    int m = this.avh;
    int k = this.avh;
    int i = 0;
    if ((k < this.Pc) && (k < paramInt))
    {
      int j = i;
      int n;
      float f2;
      if (k + 1 < this.Pc)
      {
        j = i;
        n = m;
        f2 = f1;
        if (this.RAR[(k + 1)] == 0.0F) {
          break label181;
        }
        j = i;
        if (i == 0) {
          if ((!this.RBA) || (this.RAR[(k + 1)] != this.RBC)) {
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
            f2 = f1 + this.RBC;
          }
          f2 += this.RAR[m] + this.RBz;
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
    return this.avh;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(39753);
    int i = this.avh;
    int j = this.Pc;
    int k = (int)this.mHeight;
    int m = (int)this.mWidth;
    int n = (int)this.RBB;
    int i1 = this.RBE.hashCode();
    AppMethodBeat.o(39753);
    return i + j + k + m + n + i1;
  }
  
  public final float[] hiI()
  {
    return this.RAR;
  }
  
  public final RectF hiJ()
  {
    return this.RBE;
  }
  
  public final RectF hiK()
  {
    return this.RBF;
  }
  
  public final float hiL()
  {
    return this.RBz;
  }
  
  public final boolean hiM()
  {
    return this.RBA;
  }
  
  public final float hiN()
  {
    AppMethodBeat.i(39749);
    if (this.RBB != -1.0F)
    {
      f1 = this.RBB;
      AppMethodBeat.o(39749);
      return f1;
    }
    if ((this.AoL & 0x7) == 1)
    {
      int j = this.avh;
      int i = this.avh;
      float f2;
      for (f1 = 0.0F; i < this.Pc; f1 = f2)
      {
        int k;
        if (i + 1 < this.Pc)
        {
          k = j;
          f2 = f1;
          if (this.RAR[(i + 1)] == 0.0F) {}
        }
        else
        {
          f2 = f1 + (this.RAR[j] + this.RBz);
          k = i + 1;
        }
        i += 1;
        j = k;
      }
    }
    for (float f1 = (this.RBD - f1) / 2.0F;; f1 = 0.0F)
    {
      f1 = Math.max(0.0F, f1);
      if ((this.RBw.RBg.mp(this.avh, this.avh + 1) == null) && (this.RBw.hiR().containsKey(Character.valueOf(this.RBx[this.avh]))))
      {
        f1 -= ((Float)this.RBw.hiR().get(Character.valueOf(this.RBx[this.avh]))).floatValue();
        this.RBB = f1;
        AppMethodBeat.o(39749);
        return f1;
      }
      this.RBB = f1;
      f1 = this.RBB;
      AppMethodBeat.o(39749);
      return f1;
    }
  }
  
  public final float hiO()
  {
    return this.RBH;
  }
  
  public final RectF mo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39748);
    RectF localRectF = new RectF();
    if (paramInt1 >= paramInt2)
    {
      AppMethodBeat.o(39748);
      return localRectF;
    }
    float f1 = hiN();
    int i = this.avh;
    while (i < paramInt1)
    {
      f1 += this.RAR[i] + this.RBz;
      i += 1;
    }
    float f2 = f1;
    while (paramInt1 < paramInt2)
    {
      f2 += this.RAR[paramInt1] + this.RBz;
      paramInt1 += 1;
    }
    localRectF.set(f1, this.RBE.top, f2, this.RBE.bottom);
    AppMethodBeat.o(39748);
    return localRectF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(39754);
    String str = "MeasuredLine{mStart=" + this.avh + ", mEnd=" + this.Pc + ", mLetter=" + this.RBz + ", isSmartLetter=" + this.RBA + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.RBB + ", mLineRect=" + this.RBE + ", mLineRect=" + this.RBF + '}';
    AppMethodBeat.o(39754);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.d
 * JD-Core Version:    0.7.0.1
 */