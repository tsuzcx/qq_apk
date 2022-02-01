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
  private static final TextPaint LDX;
  private static Comparator<Integer> LDY;
  public static boolean cFj;
  private int LDH;
  private c LDZ;
  private float[] LDv;
  private char[] LEa;
  private int LEb;
  private float LEc;
  private boolean LEd;
  private float LEe;
  private float LEf;
  private float LEg;
  private RectF LEh;
  private RectF LEi;
  private LinkedList<Integer> LEj;
  private float LEk;
  public int OQ;
  public int avj;
  private float mHeight;
  private float mWidth;
  
  static
  {
    AppMethodBeat.i(39757);
    LDX = new TextPaint(1);
    LDY = new Comparator() {};
    cFj = false;
    AppMethodBeat.o(39757);
  }
  
  public d(c paramc, char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2, float paramFloat3, float paramFloat4, TextPaint paramTextPaint, boolean paramBoolean, float paramFloat5, int paramInt3, int paramInt4, float paramFloat6)
  {
    AppMethodBeat.i(39746);
    this.LEe = -1.0F;
    this.LEf = 0.0F;
    this.LEg = 0.0F;
    this.LEh = new RectF();
    this.LEi = new RectF();
    this.LEj = null;
    this.LDZ = paramc;
    this.LEa = paramArrayOfChar;
    this.avj = paramInt1;
    this.OQ = paramInt2;
    this.LEb = paramInt3;
    this.LDv = paramArrayOfFloat;
    this.LEc = paramFloat4;
    this.LEf = paramFloat5;
    this.LEd = paramBoolean;
    this.mHeight = paramFloat3;
    this.mWidth = paramFloat2;
    this.LEg = paramFloat6;
    this.LDH = paramInt4;
    paramc = paramTextPaint.getFontMetrics();
    paramFloat3 = paramc.leading - paramc.top;
    paramFloat4 = paramc.bottom;
    paramFloat5 = paramc.leading;
    this.LEk = ((this.mHeight - paramc.bottom + paramc.top) / 2.0F + paramFloat1 - paramc.top);
    this.LEh.set(0.0F, this.LEk - paramFloat3, 0.0F + paramFloat2, paramFloat4 - paramFloat5 + this.LEk);
    this.LEi.set(0.0F, this.LEk - paramFloat3, 0.0F + paramFloat6, this.LEh.top + this.mHeight);
    AppMethodBeat.o(39746);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(39756);
    this.avj = paramObjectInputStream.readInt();
    this.OQ = paramObjectInputStream.readInt();
    this.LDv = ((float[])paramObjectInputStream.readObject());
    this.LEh = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
    this.LEd = paramObjectInputStream.readBoolean();
    this.LEc = paramObjectInputStream.readFloat();
    this.LEe = paramObjectInputStream.readFloat();
    AppMethodBeat.o(39756);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    AppMethodBeat.i(39755);
    paramObjectOutputStream.writeInt(this.avj);
    paramObjectOutputStream.writeInt(this.OQ);
    paramObjectOutputStream.writeObject(this.LDv);
    paramObjectOutputStream.writeFloat(this.LEh.left);
    paramObjectOutputStream.writeFloat(this.LEh.top);
    paramObjectOutputStream.writeFloat(this.LEh.right);
    paramObjectOutputStream.writeFloat(this.LEh.bottom);
    paramObjectOutputStream.writeBoolean(this.LEd);
    paramObjectOutputStream.writeFloat(this.LEc);
    paramObjectOutputStream.writeFloat(fSI());
    AppMethodBeat.o(39755);
  }
  
  public final void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat)
  {
    AppMethodBeat.i(39747);
    float f2 = fSI();
    Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
    float f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
    int j = this.avj;
    int k = this.OQ;
    Object localObject1 = this.LDZ.LDQ.LEp;
    Object localObject2 = this.LDZ.LDQ.LEq;
    LineBackgroundSpan[] arrayOfLineBackgroundSpan = (LineBackgroundSpan[])this.LDZ.LDQ.LEo;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.LDZ.LDQ.LEn)
    {
      if ((localObject1[i] < k) && (localObject2[i] > j)) {
        localLinkedList.add(arrayOfLineBackgroundSpan[i]);
      }
      i += 1;
    }
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((LineBackgroundSpan)((Iterator)localObject1).next()).drawBackground(paramCanvas, paramTextPaint, (int)this.LEh.left, (int)this.LEh.right, (int)this.LEh.top, (int)f1, (int)this.LEh.bottom, this.LDZ.getText(), this.avj, this.OQ, this.LEb);
    }
    if (cFj) {}
    for (localObject1 = new StringBuilder("canvas w=").append(paramCanvas.getWidth()).append(" canvas h=").append(paramCanvas.getHeight()).append('\n');; localObject1 = null)
    {
      int m = this.avj;
      i = 0;
      k = this.avj;
      f2 = 0.0F + f2;
      int n;
      if (k < this.OQ)
      {
        j = i;
        float f4;
        float f3;
        if (k + 1 < this.OQ)
        {
          j = i;
          f4 = f1;
          n = m;
          f3 = f2;
          if (this.LDv[(k + 1)] == 0.0F) {
            break label561;
          }
          j = i;
          if (i == 0) {
            if ((!this.LEd) || (this.LDv[(k + 1)] != this.LEf)) {
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
            localObject2 = (ImageSpan)this.LDZ.LDK.kJ(m, n);
            if (localObject2 == null) {
              break label592;
            }
            LDX.set(paramTextPaint);
            ((ImageSpan)localObject2).draw(paramCanvas, "", m, n, f2, 0, (int)f1, (int)(this.mHeight + paramFloat), LDX);
            f3 = f2;
            if (j != 0) {
              f3 = f2 + this.LEf;
            }
            j = 0;
            f3 += this.LDv[m] + this.LEc;
            if (cFj) {
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
        LDX.set(paramTextPaint);
        localObject2 = (AbsoluteSizeSpan)this.LDZ.LDL.kJ(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((AbsoluteSizeSpan)localObject2).updateDrawState(LDX);
        }
        localObject2 = (RelativeSizeSpan)this.LDZ.LDM.kJ(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((RelativeSizeSpan)localObject2).updateDrawState(LDX);
        }
        localObject2 = (ForegroundColorSpan)this.LDZ.LDO.kJ(m, n);
        if (localObject2 != null) {
          ((ForegroundColorSpan)localObject2).updateDrawState(LDX);
        }
        localObject2 = (ClickableSpan)this.LDZ.LDP.kJ(m, n);
        if (localObject2 != null) {
          ((ClickableSpan)localObject2).updateDrawState(LDX);
        }
        if (i == 0) {
          break label800;
        }
        f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
      }
      label800:
      for (;;)
      {
        paramCanvas.drawText(this.LEa, m, n - m, f2, f1, LDX);
        break;
        AppMethodBeat.o(39747);
        return;
      }
    }
  }
  
  public final int agw(int paramInt)
  {
    AppMethodBeat.i(39751);
    int k = this.avj;
    float f1 = this.LEh.left + fSI();
    int n = this.avj;
    int m = this.avj;
    int i = 0;
    if (m < this.OQ)
    {
      int j = i;
      if (m + 1 < this.OQ)
      {
        j = i;
        if (this.LDv[(m + 1)] != 0.0F)
        {
          j = i;
          if (i != 0) {
            break label156;
          }
          if ((this.LEd) && (this.LDv[(m + 1)] == this.LEf))
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
          f2 = f1 + this.LEf;
        }
        f1 = f2 + (this.LDv[n] + this.LEc);
        if ((f2 <= paramInt) && (paramInt < f1))
        {
          AppMethodBeat.o(39751);
          return k;
        }
        if (f2 > paramInt)
        {
          paramInt = this.avj;
          AppMethodBeat.o(39751);
          return paramInt;
        }
        if (paramInt > this.LEh.right)
        {
          if (this.OQ == this.LEa.length)
          {
            paramInt = this.OQ;
            AppMethodBeat.o(39751);
            return paramInt;
          }
          paramInt = this.OQ;
          AppMethodBeat.o(39751);
          return paramInt - 1;
        }
        k += 1;
        i = 0;
        n = m + 1;
      }
    }
    paramInt = this.OQ;
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
      if ((paramObject.getStart() != this.avj) || (paramObject.getEnd() != this.OQ) || (!paramObject.fSE().equals(this.LEh)) || (paramObject.fSH() != this.LEd) || (paramObject.fSG() != this.LEc) || (paramObject.fSI() != this.LEe))
      {
        AppMethodBeat.o(39752);
        return false;
      }
      int i = this.avj;
      while (i < this.OQ)
      {
        if (this.LDv[i] != paramObject.fSD()[i])
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
  
  public final float[] fSD()
  {
    return this.LDv;
  }
  
  public final RectF fSE()
  {
    return this.LEh;
  }
  
  public final RectF fSF()
  {
    return this.LEi;
  }
  
  public final float fSG()
  {
    return this.LEc;
  }
  
  public final boolean fSH()
  {
    return this.LEd;
  }
  
  public final float fSI()
  {
    AppMethodBeat.i(39749);
    if (this.LEe != -1.0F)
    {
      f1 = this.LEe;
      AppMethodBeat.o(39749);
      return f1;
    }
    if ((this.LDH & 0x7) == 1)
    {
      int j = this.avj;
      int i = this.avj;
      float f2;
      for (f1 = 0.0F; i < this.OQ; f1 = f2)
      {
        int k;
        if (i + 1 < this.OQ)
        {
          k = j;
          f2 = f1;
          if (this.LDv[(i + 1)] == 0.0F) {}
        }
        else
        {
          f2 = f1 + (this.LDv[j] + this.LEc);
          k = i + 1;
        }
        i += 1;
        j = k;
      }
    }
    for (float f1 = (this.LEg - f1) / 2.0F;; f1 = 0.0F)
    {
      f1 = Math.max(0.0F, f1);
      if ((this.LDZ.LDK.kJ(this.avj, this.avj + 1) == null) && (this.LDZ.fSM().containsKey(Character.valueOf(this.LEa[this.avj]))))
      {
        f1 -= ((Float)this.LDZ.fSM().get(Character.valueOf(this.LEa[this.avj]))).floatValue();
        this.LEe = f1;
        AppMethodBeat.o(39749);
        return f1;
      }
      this.LEe = f1;
      f1 = this.LEe;
      AppMethodBeat.o(39749);
      return f1;
    }
  }
  
  public final float fSJ()
  {
    return this.LEk;
  }
  
  public final int getEnd()
  {
    return this.OQ;
  }
  
  public final float getHeight()
  {
    return this.mHeight;
  }
  
  public final float getPrimaryHorizontal(int paramInt)
  {
    AppMethodBeat.i(39750);
    float f1 = this.LEh.left + fSI();
    int m = this.avj;
    int k = this.avj;
    int i = 0;
    if ((k < this.OQ) && (k < paramInt))
    {
      int j = i;
      int n;
      float f2;
      if (k + 1 < this.OQ)
      {
        j = i;
        n = m;
        f2 = f1;
        if (this.LDv[(k + 1)] == 0.0F) {
          break label181;
        }
        j = i;
        if (i == 0) {
          if ((!this.LEd) || (this.LDv[(k + 1)] != this.LEf)) {
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
            f2 = f1 + this.LEf;
          }
          f2 += this.LDv[m] + this.LEc;
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
    return this.avj;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(39753);
    int i = this.avj;
    int j = this.OQ;
    int k = (int)this.mHeight;
    int m = (int)this.mWidth;
    int n = (int)this.LEe;
    int i1 = this.LEh.hashCode();
    AppMethodBeat.o(39753);
    return i + j + k + m + n + i1;
  }
  
  public final RectF kI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39748);
    RectF localRectF = new RectF();
    if (paramInt1 >= paramInt2)
    {
      AppMethodBeat.o(39748);
      return localRectF;
    }
    float f1 = fSI();
    int i = this.avj;
    while (i < paramInt1)
    {
      f1 += this.LDv[i] + this.LEc;
      i += 1;
    }
    float f2 = f1;
    while (paramInt1 < paramInt2)
    {
      f2 += this.LDv[paramInt1] + this.LEc;
      paramInt1 += 1;
    }
    localRectF.set(f1, this.LEh.top, f2, this.LEh.bottom);
    AppMethodBeat.o(39748);
    return localRectF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(39754);
    String str = "MeasuredLine{mStart=" + this.avj + ", mEnd=" + this.OQ + ", mLetter=" + this.LEc + ", isSmartLetter=" + this.LEd + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.LEe + ", mLineRect=" + this.LEh + ", mLineRect=" + this.LEi + '}';
    AppMethodBeat.o(39754);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.d
 * JD-Core Version:    0.7.0.1
 */