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
  protected LinkedList<RectF> Zco;
  public CharacterStyle Zcp;
  private int tH;
  private int tI;
  
  b(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    this.tH = paramInt1;
    this.tI = paramInt2;
    this.Zcp = paramCharacterStyle;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    this.tH = paramObjectInputStream.readInt();
    this.tI = paramObjectInputStream.readInt();
    int j = paramObjectInputStream.readInt();
    this.Zco = new LinkedList();
    int i = 0;
    while (i < j)
    {
      RectF localRectF = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
      this.Zco.add(localRectF);
      i += 1;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeInt(this.tH);
    paramObjectOutputStream.writeInt(this.tI);
    paramObjectOutputStream.writeInt(this.Zco.size());
    Iterator localIterator = this.Zco.iterator();
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
  
  public final boolean aM(float paramFloat1, float paramFloat2)
  {
    if (this.Zco == null) {
      return false;
    }
    Iterator localIterator = this.Zco.iterator();
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
    } while ((paramObject.tH != this.tH) || (paramObject.tI != this.tI));
    int i = 0;
    for (;;)
    {
      if (i >= this.Zco.size()) {
        break label88;
      }
      if (!((RectF)this.Zco.get(i)).equals((RectF)paramObject.Zco.get(i))) {
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
    while (i < this.Zco.size())
    {
      j += ((RectF)this.Zco.get(i)).hashCode();
      i += 1;
    }
    return this.tH + this.tI + j;
  }
  
  final void kV(List<d> paramList)
  {
    if (this.Zco == null)
    {
      this.Zco = new LinkedList();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      d locald;
      if (paramList.hasNext())
      {
        locald = (d)paramList.next();
        if ((locald.tH <= this.tH) && (this.tI < locald.tI)) {
          this.Zco.add(locald.nF(this.tH, this.tI));
        }
      }
      else
      {
        return;
      }
      if ((locald.tH <= this.tH) && (this.tH < locald.tI) && (locald.tI <= this.tI))
      {
        this.Zco.add(locald.nF(this.tH, locald.tI));
      }
      else
      {
        if ((this.tH < locald.tH) && (this.tI < locald.tI) && (this.tI >= locald.tH))
        {
          this.Zco.add(locald.nF(locald.tH, this.tI));
          return;
        }
        if ((this.tH < locald.tH) && (this.tI >= locald.tI)) {
          this.Zco.add(locald.nF(locald.tH, locald.tI));
        }
      }
    }
  }
  
  public String toString()
  {
    return "CharacterBgStyle{mRectFList=" + this.Zco + ", mStart=" + this.tH + ", mEnd=" + this.tI + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.neattextview.textview.b.b
 * JD-Core Version:    0.7.0.1
 */