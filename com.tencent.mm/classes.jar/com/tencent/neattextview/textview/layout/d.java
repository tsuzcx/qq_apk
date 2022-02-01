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
  private static final TextPaint Mbb;
  private static Comparator<Integer> Mbc;
  public static boolean cFS;
  private int MaL;
  private float[] Maz;
  private c Mbd;
  private char[] Mbe;
  private int Mbf;
  private float Mbg;
  private boolean Mbh;
  private float Mbi;
  private float Mbj;
  private float Mbk;
  private RectF Mbl;
  private RectF Mbm;
  private LinkedList<Integer> Mbn;
  private float Mbo;
  public int OQ;
  public int avj;
  private float mHeight;
  private float mWidth;
  
  static
  {
    AppMethodBeat.i(39757);
    Mbb = new TextPaint(1);
    Mbc = new Comparator() {};
    cFS = false;
    AppMethodBeat.o(39757);
  }
  
  public d(c paramc, char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2, float paramFloat3, float paramFloat4, TextPaint paramTextPaint, boolean paramBoolean, float paramFloat5, int paramInt3, int paramInt4, float paramFloat6)
  {
    AppMethodBeat.i(39746);
    this.Mbi = -1.0F;
    this.Mbj = 0.0F;
    this.Mbk = 0.0F;
    this.Mbl = new RectF();
    this.Mbm = new RectF();
    this.Mbn = null;
    this.Mbd = paramc;
    this.Mbe = paramArrayOfChar;
    this.avj = paramInt1;
    this.OQ = paramInt2;
    this.Mbf = paramInt3;
    this.Maz = paramArrayOfFloat;
    this.Mbg = paramFloat4;
    this.Mbj = paramFloat5;
    this.Mbh = paramBoolean;
    this.mHeight = paramFloat3;
    this.mWidth = paramFloat2;
    this.Mbk = paramFloat6;
    this.MaL = paramInt4;
    paramc = paramTextPaint.getFontMetrics();
    paramFloat3 = paramc.leading - paramc.top;
    paramFloat4 = paramc.bottom;
    paramFloat5 = paramc.leading;
    this.Mbo = ((this.mHeight - paramc.bottom + paramc.top) / 2.0F + paramFloat1 - paramc.top);
    this.Mbl.set(0.0F, this.Mbo - paramFloat3, 0.0F + paramFloat2, paramFloat4 - paramFloat5 + this.Mbo);
    this.Mbm.set(0.0F, this.Mbo - paramFloat3, 0.0F + paramFloat6, this.Mbl.top + this.mHeight);
    AppMethodBeat.o(39746);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(39756);
    this.avj = paramObjectInputStream.readInt();
    this.OQ = paramObjectInputStream.readInt();
    this.Maz = ((float[])paramObjectInputStream.readObject());
    this.Mbl = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
    this.Mbh = paramObjectInputStream.readBoolean();
    this.Mbg = paramObjectInputStream.readFloat();
    this.Mbi = paramObjectInputStream.readFloat();
    AppMethodBeat.o(39756);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    AppMethodBeat.i(39755);
    paramObjectOutputStream.writeInt(this.avj);
    paramObjectOutputStream.writeInt(this.OQ);
    paramObjectOutputStream.writeObject(this.Maz);
    paramObjectOutputStream.writeFloat(this.Mbl.left);
    paramObjectOutputStream.writeFloat(this.Mbl.top);
    paramObjectOutputStream.writeFloat(this.Mbl.right);
    paramObjectOutputStream.writeFloat(this.Mbl.bottom);
    paramObjectOutputStream.writeBoolean(this.Mbh);
    paramObjectOutputStream.writeFloat(this.Mbg);
    paramObjectOutputStream.writeFloat(fXi());
    AppMethodBeat.o(39755);
  }
  
  public final void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat)
  {
    AppMethodBeat.i(39747);
    float f2 = fXi();
    Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
    float f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
    int j = this.avj;
    int k = this.OQ;
    Object localObject1 = this.Mbd.MaU.Mbt;
    Object localObject2 = this.Mbd.MaU.Mbu;
    LineBackgroundSpan[] arrayOfLineBackgroundSpan = (LineBackgroundSpan[])this.Mbd.MaU.Mbs;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.Mbd.MaU.Mbr)
    {
      if ((localObject1[i] < k) && (localObject2[i] > j)) {
        localLinkedList.add(arrayOfLineBackgroundSpan[i]);
      }
      i += 1;
    }
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((LineBackgroundSpan)((Iterator)localObject1).next()).drawBackground(paramCanvas, paramTextPaint, (int)this.Mbl.left, (int)this.Mbl.right, (int)this.Mbl.top, (int)f1, (int)this.Mbl.bottom, this.Mbd.getText(), this.avj, this.OQ, this.Mbf);
    }
    if (cFS) {}
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
          if (this.Maz[(k + 1)] == 0.0F) {
            break label561;
          }
          j = i;
          if (i == 0) {
            if ((!this.Mbh) || (this.Maz[(k + 1)] != this.Mbj)) {
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
            localObject2 = (ImageSpan)this.Mbd.MaO.kQ(m, n);
            if (localObject2 == null) {
              break label592;
            }
            Mbb.set(paramTextPaint);
            ((ImageSpan)localObject2).draw(paramCanvas, "", m, n, f2, 0, (int)f1, (int)(this.mHeight + paramFloat), Mbb);
            f3 = f2;
            if (j != 0) {
              f3 = f2 + this.Mbj;
            }
            j = 0;
            f3 += this.Maz[m] + this.Mbg;
            if (cFS) {
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
        Mbb.set(paramTextPaint);
        localObject2 = (AbsoluteSizeSpan)this.Mbd.MaP.kQ(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((AbsoluteSizeSpan)localObject2).updateDrawState(Mbb);
        }
        localObject2 = (RelativeSizeSpan)this.Mbd.MaQ.kQ(m, n);
        if (localObject2 != null)
        {
          i = 1;
          ((RelativeSizeSpan)localObject2).updateDrawState(Mbb);
        }
        localObject2 = (ForegroundColorSpan)this.Mbd.MaS.kQ(m, n);
        if (localObject2 != null) {
          ((ForegroundColorSpan)localObject2).updateDrawState(Mbb);
        }
        localObject2 = (ClickableSpan)this.Mbd.MaT.kQ(m, n);
        if (localObject2 != null) {
          ((ClickableSpan)localObject2).updateDrawState(Mbb);
        }
        if (i == 0) {
          break label800;
        }
        f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
      }
      label800:
      for (;;)
      {
        paramCanvas.drawText(this.Mbe, m, n - m, f2, f1, Mbb);
        break;
        AppMethodBeat.o(39747);
        return;
      }
    }
  }
  
  public final int ahf(int paramInt)
  {
    AppMethodBeat.i(39751);
    int k = this.avj;
    float f1 = this.Mbl.left + fXi();
    int n = this.avj;
    int m = this.avj;
    int i = 0;
    if (m < this.OQ)
    {
      int j = i;
      if (m + 1 < this.OQ)
      {
        j = i;
        if (this.Maz[(m + 1)] != 0.0F)
        {
          j = i;
          if (i != 0) {
            break label156;
          }
          if ((this.Mbh) && (this.Maz[(m + 1)] == this.Mbj))
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
          f2 = f1 + this.Mbj;
        }
        f1 = f2 + (this.Maz[n] + this.Mbg);
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
        if (paramInt > this.Mbl.right)
        {
          if (this.OQ == this.Mbe.length)
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
      if ((paramObject.getStart() != this.avj) || (paramObject.getEnd() != this.OQ) || (!paramObject.fXe().equals(this.Mbl)) || (paramObject.fXh() != this.Mbh) || (paramObject.fXg() != this.Mbg) || (paramObject.fXi() != this.Mbi))
      {
        AppMethodBeat.o(39752);
        return false;
      }
      int i = this.avj;
      while (i < this.OQ)
      {
        if (this.Maz[i] != paramObject.fXd()[i])
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
  
  public final float[] fXd()
  {
    return this.Maz;
  }
  
  public final RectF fXe()
  {
    return this.Mbl;
  }
  
  public final RectF fXf()
  {
    return this.Mbm;
  }
  
  public final float fXg()
  {
    return this.Mbg;
  }
  
  public final boolean fXh()
  {
    return this.Mbh;
  }
  
  public final float fXi()
  {
    AppMethodBeat.i(39749);
    if (this.Mbi != -1.0F)
    {
      f1 = this.Mbi;
      AppMethodBeat.o(39749);
      return f1;
    }
    if ((this.MaL & 0x7) == 1)
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
          if (this.Maz[(i + 1)] == 0.0F) {}
        }
        else
        {
          f2 = f1 + (this.Maz[j] + this.Mbg);
          k = i + 1;
        }
        i += 1;
        j = k;
      }
    }
    for (float f1 = (this.Mbk - f1) / 2.0F;; f1 = 0.0F)
    {
      f1 = Math.max(0.0F, f1);
      if ((this.Mbd.MaO.kQ(this.avj, this.avj + 1) == null) && (this.Mbd.fXm().containsKey(Character.valueOf(this.Mbe[this.avj]))))
      {
        f1 -= ((Float)this.Mbd.fXm().get(Character.valueOf(this.Mbe[this.avj]))).floatValue();
        this.Mbi = f1;
        AppMethodBeat.o(39749);
        return f1;
      }
      this.Mbi = f1;
      f1 = this.Mbi;
      AppMethodBeat.o(39749);
      return f1;
    }
  }
  
  public final float fXj()
  {
    return this.Mbo;
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
    float f1 = this.Mbl.left + fXi();
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
        if (this.Maz[(k + 1)] == 0.0F) {
          break label181;
        }
        j = i;
        if (i == 0) {
          if ((!this.Mbh) || (this.Maz[(k + 1)] != this.Mbj)) {
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
            f2 = f1 + this.Mbj;
          }
          f2 += this.Maz[m] + this.Mbg;
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
    int n = (int)this.Mbi;
    int i1 = this.Mbl.hashCode();
    AppMethodBeat.o(39753);
    return i + j + k + m + n + i1;
  }
  
  public final RectF kP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39748);
    RectF localRectF = new RectF();
    if (paramInt1 >= paramInt2)
    {
      AppMethodBeat.o(39748);
      return localRectF;
    }
    float f1 = fXi();
    int i = this.avj;
    while (i < paramInt1)
    {
      f1 += this.Maz[i] + this.Mbg;
      i += 1;
    }
    float f2 = f1;
    while (paramInt1 < paramInt2)
    {
      f2 += this.Maz[paramInt1] + this.Mbg;
      paramInt1 += 1;
    }
    localRectF.set(f1, this.Mbl.top, f2, this.Mbl.bottom);
    AppMethodBeat.o(39748);
    return localRectF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(39754);
    String str = "MeasuredLine{mStart=" + this.avj + ", mEnd=" + this.OQ + ", mLetter=" + this.Mbg + ", isSmartLetter=" + this.Mbh + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.Mbi + ", mLineRect=" + this.Mbl + ", mLineRect=" + this.Mbm + '}';
    AppMethodBeat.o(39754);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.d
 * JD-Core Version:    0.7.0.1
 */