package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.neattextview.textview.layout.d;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class b<T extends CharacterStyle>
  implements Serializable
{
  protected LinkedList<RectF> Mat;
  public CharacterStyle Mau;
  private int OQ;
  private int avj;
  
  b(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    this.avj = paramInt1;
    this.OQ = paramInt2;
    this.Mau = paramCharacterStyle;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    this.avj = paramObjectInputStream.readInt();
    this.OQ = paramObjectInputStream.readInt();
    int j = paramObjectInputStream.readInt();
    this.Mat = new LinkedList();
    int i = 0;
    while (i < j)
    {
      RectF localRectF = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
      this.Mat.add(localRectF);
      i += 1;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeInt(this.avj);
    paramObjectOutputStream.writeInt(this.OQ);
    paramObjectOutputStream.writeInt(this.Mat.size());
    Iterator localIterator = this.Mat.iterator();
    while (localIterator.hasNext())
    {
      RectF localRectF = (RectF)localIterator.next();
      paramObjectOutputStream.writeFloat(localRectF.left);
      paramObjectOutputStream.writeFloat(localRectF.top);
      paramObjectOutputStream.writeFloat(localRectF.right);
      paramObjectOutputStream.writeFloat(localRectF.bottom);
    }
  }
  
  public abstract void a(Canvas paramCanvas, TextPaint paramTextPaint, List<d> paramList);
  
  public final boolean at(float paramFloat1, float paramFloat2)
  {
    if (this.Mat == null) {
      return false;
    }
    Iterator localIterator = this.Mat.iterator();
    while (localIterator.hasNext()) {
      if (((RectF)localIterator.next()).contains(paramFloat1, paramFloat2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof b));
      paramObject = (b)paramObject;
    } while ((paramObject.avj != this.avj) || (paramObject.OQ != this.OQ));
    int i = 0;
    for (;;)
    {
      if (i >= this.Mat.size()) {
        break label88;
      }
      if (!((RectF)this.Mat.get(i)).equals((RectF)paramObject.Mat.get(i))) {
        break;
      }
      i += 1;
    }
    label88:
    return true;
  }
  
  public int hashCode()
  {
    int i = 0;
    int j = 0;
    while (i < this.Mat.size())
    {
      j += ((RectF)this.Mat.get(i)).hashCode();
      i += 1;
    }
    return this.avj + this.OQ + j;
  }
  
  final void iY(List<d> paramList)
  {
    if (this.Mat == null)
    {
      this.Mat = new LinkedList();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      d locald;
      if (paramList.hasNext())
      {
        locald = (d)paramList.next();
        if ((locald.avj <= this.avj) && (this.OQ < locald.OQ)) {
          this.Mat.add(locald.kP(this.avj, this.OQ));
        }
      }
      else
      {
        return;
      }
      if ((locald.avj <= this.avj) && (this.avj < locald.OQ) && (locald.OQ <= this.OQ))
      {
        this.Mat.add(locald.kP(this.avj, locald.OQ));
      }
      else
      {
        if ((this.avj < locald.avj) && (this.OQ < locald.OQ) && (this.OQ >= locald.avj))
        {
          this.Mat.add(locald.kP(locald.avj, this.OQ));
          return;
        }
        if ((this.avj < locald.avj) && (this.OQ >= locald.OQ)) {
          this.Mat.add(locald.kP(locald.avj, locald.OQ));
        }
      }
    }
  }
  
  public String toString()
  {
    return "CharacterBgStyle{mRectFList=" + this.Mat + ", mStart=" + this.avj + ", mEnd=" + this.OQ + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.b.b
 * JD-Core Version:    0.7.0.1
 */