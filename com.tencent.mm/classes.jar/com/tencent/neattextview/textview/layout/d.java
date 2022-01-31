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
  private static final TextPaint BbK;
  private static Comparator<Integer> BbL;
  private c BbM;
  private char[] BbN;
  private int BbO;
  private float BbP;
  private boolean BbQ;
  private float BbR;
  private float BbS;
  private float BbT;
  private RectF BbU;
  private RectF BbV;
  private LinkedList<Integer> BbW;
  private float BbX;
  private float[] Bbo;
  private int Bbx;
  public int Fe;
  public int akX;
  private float mHeight;
  private float mWidth;
  
  static
  {
    AppMethodBeat.i(3255);
    BbK = new TextPaint(1);
    BbL = new Comparator() {};
    AppMethodBeat.o(3255);
  }
  
  public d(c paramc, char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2, float paramFloat3, float paramFloat4, TextPaint paramTextPaint, boolean paramBoolean, float paramFloat5, int paramInt3, int paramInt4, float paramFloat6)
  {
    AppMethodBeat.i(3244);
    this.BbR = -1.0F;
    this.BbS = 0.0F;
    this.BbT = 0.0F;
    this.BbU = new RectF();
    this.BbV = new RectF();
    this.BbW = null;
    this.BbM = paramc;
    this.BbN = paramArrayOfChar;
    this.akX = paramInt1;
    this.Fe = paramInt2;
    this.BbO = paramInt3;
    this.Bbo = paramArrayOfFloat;
    this.BbP = paramFloat4;
    this.BbS = paramFloat5;
    this.BbQ = paramBoolean;
    this.mHeight = paramFloat3;
    this.mWidth = paramFloat2;
    this.BbT = paramFloat6;
    this.Bbx = paramInt4;
    paramc = paramTextPaint.getFontMetrics();
    paramFloat3 = paramc.leading - paramc.top;
    paramFloat4 = paramc.bottom;
    paramFloat5 = paramc.leading;
    this.BbX = ((this.mHeight - paramc.bottom + paramc.top) / 2.0F + paramFloat1 - paramc.top);
    this.BbU.set(0.0F, this.BbX - paramFloat3, 0.0F + paramFloat2, paramFloat4 - paramFloat5 + this.BbX);
    this.BbV.set(0.0F, this.BbX - paramFloat3, 0.0F + paramFloat6, this.BbU.top + this.mHeight);
    AppMethodBeat.o(3244);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    AppMethodBeat.i(3254);
    this.akX = paramObjectInputStream.readInt();
    this.Fe = paramObjectInputStream.readInt();
    this.Bbo = ((float[])paramObjectInputStream.readObject());
    this.BbU = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
    this.BbQ = paramObjectInputStream.readBoolean();
    this.BbP = paramObjectInputStream.readFloat();
    this.BbR = paramObjectInputStream.readFloat();
    AppMethodBeat.o(3254);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    AppMethodBeat.i(3253);
    paramObjectOutputStream.writeInt(this.akX);
    paramObjectOutputStream.writeInt(this.Fe);
    paramObjectOutputStream.writeObject(this.Bbo);
    paramObjectOutputStream.writeFloat(this.BbU.left);
    paramObjectOutputStream.writeFloat(this.BbU.top);
    paramObjectOutputStream.writeFloat(this.BbU.right);
    paramObjectOutputStream.writeFloat(this.BbU.bottom);
    paramObjectOutputStream.writeBoolean(this.BbQ);
    paramObjectOutputStream.writeFloat(this.BbP);
    paramObjectOutputStream.writeFloat(dTv());
    AppMethodBeat.o(3253);
  }
  
  public final int RZ(int paramInt)
  {
    AppMethodBeat.i(3249);
    int k = this.akX;
    float f1 = this.BbU.left + dTv();
    int n = this.akX;
    int m = this.akX;
    int i = 0;
    if (m < this.Fe)
    {
      int j = i;
      if (m + 1 < this.Fe)
      {
        j = i;
        if (this.Bbo[(m + 1)] != 0.0F)
        {
          j = i;
          if (i != 0) {
            break label156;
          }
          if ((this.BbQ) && (this.Bbo[(m + 1)] == this.BbS))
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
          f2 = f1 + this.BbS;
        }
        f1 = f2 + (this.Bbo[n] + this.BbP);
        if ((f2 <= paramInt) && (paramInt < f1))
        {
          AppMethodBeat.o(3249);
          return k;
        }
        if (f2 > paramInt)
        {
          paramInt = this.akX;
          AppMethodBeat.o(3249);
          return paramInt;
        }
        if (paramInt > this.BbU.right)
        {
          if (this.Fe == this.BbN.length)
          {
            paramInt = this.Fe;
            AppMethodBeat.o(3249);
            return paramInt;
          }
          paramInt = this.Fe;
          AppMethodBeat.o(3249);
          return paramInt - 1;
        }
        k += 1;
        i = 0;
        n = m + 1;
      }
    }
    paramInt = this.Fe;
    AppMethodBeat.o(3249);
    return paramInt;
  }
  
  public final void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat)
  {
    AppMethodBeat.i(3245);
    float f2 = dTv();
    Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
    float f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
    int j = this.akX;
    int k = this.Fe;
    Object localObject = this.BbM.BbG.Bcc;
    int[] arrayOfInt = this.BbM.BbG.Bcd;
    LineBackgroundSpan[] arrayOfLineBackgroundSpan = (LineBackgroundSpan[])this.BbM.BbG.Bcb;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.BbM.BbG.Bca)
    {
      if ((localObject[i] < k) && (arrayOfInt[i] > j)) {
        localLinkedList.add(arrayOfLineBackgroundSpan[i]);
      }
      i += 1;
    }
    localObject = localLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((LineBackgroundSpan)((Iterator)localObject).next()).drawBackground(paramCanvas, paramTextPaint, (int)this.BbU.left, (int)this.BbU.right, (int)this.BbU.top, (int)f1, (int)this.BbU.bottom, this.BbM.getText(), this.akX, this.Fe, this.BbO);
    }
    int m = this.akX;
    i = 0;
    k = this.akX;
    f2 = 0.0F + f2;
    int n;
    if (k < this.Fe)
    {
      j = i;
      float f4;
      float f3;
      if (k + 1 < this.Fe)
      {
        j = i;
        f4 = f1;
        n = m;
        f3 = f2;
        if (this.Bbo[(k + 1)] == 0.0F) {
          break label500;
        }
        j = i;
        if (i == 0) {
          if ((!this.BbQ) || (this.Bbo[(k + 1)] != this.BbS)) {
            break label525;
          }
        }
      }
      label525:
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
          localObject = (ImageSpan)this.BbM.BbA.ik(m, n);
          if (localObject == null) {
            break label531;
          }
          BbK.set(paramTextPaint);
          ((ImageSpan)localObject).draw(paramCanvas, "", m, n, f2, 0, (int)f1, (int)(this.mHeight + paramFloat), BbK);
          f3 = f2;
          if (j != 0) {
            f3 = f2 + this.BbS;
          }
          j = 0;
          f3 += this.Bbo[m] + this.BbP;
          f4 = f1;
        }
        label500:
        k += 1;
        i = j;
        f1 = f4;
        m = n;
        f2 = f3;
        break;
      }
      label531:
      i = 0;
      BbK.set(paramTextPaint);
      localObject = (AbsoluteSizeSpan)this.BbM.BbB.ik(m, n);
      if (localObject != null)
      {
        i = 1;
        ((AbsoluteSizeSpan)localObject).updateDrawState(BbK);
      }
      localObject = (RelativeSizeSpan)this.BbM.BbC.ik(m, n);
      if (localObject != null)
      {
        i = 1;
        ((RelativeSizeSpan)localObject).updateDrawState(BbK);
      }
      localObject = (ForegroundColorSpan)this.BbM.BbE.ik(m, n);
      if (localObject != null) {
        ((ForegroundColorSpan)localObject).updateDrawState(BbK);
      }
      localObject = (ClickableSpan)this.BbM.BbF.ik(m, n);
      if (localObject != null) {
        ((ClickableSpan)localObject).updateDrawState(BbK);
      }
      if (i == 0) {
        break label740;
      }
      f1 = (this.mHeight - localFontMetrics.bottom + localFontMetrics.top) / 2.0F + paramFloat - localFontMetrics.top;
    }
    label740:
    for (;;)
    {
      paramCanvas.drawText(this.BbN, m, n - m, f2, f1, BbK);
      break;
      AppMethodBeat.o(3245);
      return;
    }
  }
  
  public final float[] dTq()
  {
    return this.Bbo;
  }
  
  public final RectF dTr()
  {
    return this.BbU;
  }
  
  public final RectF dTs()
  {
    return this.BbV;
  }
  
  public final float dTt()
  {
    return this.BbP;
  }
  
  public final boolean dTu()
  {
    return this.BbQ;
  }
  
  public final float dTv()
  {
    AppMethodBeat.i(3247);
    if (this.BbR != -1.0F)
    {
      f1 = this.BbR;
      AppMethodBeat.o(3247);
      return f1;
    }
    if ((this.Bbx & 0x7) == 1)
    {
      int j = this.akX;
      int i = this.akX;
      float f2;
      for (f1 = 0.0F; i < this.Fe; f1 = f2)
      {
        int k;
        if (i + 1 < this.Fe)
        {
          k = j;
          f2 = f1;
          if (this.Bbo[(i + 1)] == 0.0F) {}
        }
        else
        {
          f2 = f1 + (this.Bbo[j] + this.BbP);
          k = i + 1;
        }
        i += 1;
        j = k;
      }
    }
    for (float f1 = (this.BbT - f1) / 2.0F;; f1 = 0.0F)
    {
      f1 = Math.max(0.0F, f1);
      if ((this.BbM.BbA.ik(this.akX, this.akX + 1) == null) && (this.BbM.dTz().containsKey(Character.valueOf(this.BbN[this.akX]))))
      {
        f1 -= ((Float)this.BbM.dTz().get(Character.valueOf(this.BbN[this.akX]))).floatValue();
        this.BbR = f1;
        AppMethodBeat.o(3247);
        return f1;
      }
      this.BbR = f1;
      f1 = this.BbR;
      AppMethodBeat.o(3247);
      return f1;
    }
  }
  
  public final float dTw()
  {
    return this.BbX;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(3250);
    if (paramObject == null)
    {
      AppMethodBeat.o(3250);
      return false;
    }
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if ((paramObject.getStart() != this.akX) || (paramObject.getEnd() != this.Fe) || (!paramObject.dTr().equals(this.BbU)) || (paramObject.dTu() != this.BbQ) || (paramObject.dTt() != this.BbP) || (paramObject.dTv() != this.BbR))
      {
        AppMethodBeat.o(3250);
        return false;
      }
      int i = this.akX;
      while (i < this.Fe)
      {
        if (this.Bbo[i] != paramObject.dTq()[i])
        {
          AppMethodBeat.o(3250);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(3250);
      return true;
    }
    AppMethodBeat.o(3250);
    return false;
  }
  
  public final int getEnd()
  {
    return this.Fe;
  }
  
  public final float getHeight()
  {
    return this.mHeight;
  }
  
  public final float getPrimaryHorizontal(int paramInt)
  {
    AppMethodBeat.i(3248);
    float f1 = this.BbU.left + dTv();
    int m = this.akX;
    int k = this.akX;
    int i = 0;
    if ((k < this.Fe) && (k < paramInt))
    {
      int j = i;
      int n;
      float f2;
      if (k + 1 < this.Fe)
      {
        j = i;
        n = m;
        f2 = f1;
        if (this.Bbo[(k + 1)] == 0.0F) {
          break label181;
        }
        j = i;
        if (i == 0) {
          if ((!this.BbQ) || (this.Bbo[(k + 1)] != this.BbS)) {
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
            f2 = f1 + this.BbS;
          }
          f2 += this.Bbo[m] + this.BbP;
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
    AppMethodBeat.o(3248);
    return f1;
  }
  
  public final int getStart()
  {
    return this.akX;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(3251);
    int i = this.akX;
    int j = this.Fe;
    int k = (int)this.mHeight;
    int m = (int)this.mWidth;
    int n = (int)this.BbR;
    int i1 = this.BbU.hashCode();
    AppMethodBeat.o(3251);
    return i + j + k + m + n + i1;
  }
  
  public final RectF ij(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3246);
    RectF localRectF = new RectF();
    if (paramInt1 >= paramInt2)
    {
      AppMethodBeat.o(3246);
      return localRectF;
    }
    float f1 = dTv();
    int i = this.akX;
    while (i < paramInt1)
    {
      f1 += this.Bbo[i] + this.BbP;
      i += 1;
    }
    float f2 = f1;
    while (paramInt1 < paramInt2)
    {
      f2 += this.Bbo[paramInt1] + this.BbP;
      paramInt1 += 1;
    }
    localRectF.set(f1, this.BbU.top, f2, this.BbU.bottom);
    AppMethodBeat.o(3246);
    return localRectF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(3252);
    String str = "MeasuredLine{mStart=" + this.akX + ", mEnd=" + this.Fe + ", mLetter=" + this.BbP + ", isSmartLetter=" + this.BbQ + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.BbR + ", mLineRect=" + this.BbU + ", mLineRect=" + this.BbV + '}';
    AppMethodBeat.o(3252);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.d
 * JD-Core Version:    0.7.0.1
 */