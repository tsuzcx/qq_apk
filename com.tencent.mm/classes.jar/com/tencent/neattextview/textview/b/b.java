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
  protected LinkedList<RectF> IhX;
  public CharacterStyle IhY;
  private int Mc;
  private int asw;
  
  b(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    this.asw = paramInt1;
    this.Mc = paramInt2;
    this.IhY = paramCharacterStyle;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    this.asw = paramObjectInputStream.readInt();
    this.Mc = paramObjectInputStream.readInt();
    int j = paramObjectInputStream.readInt();
    this.IhX = new LinkedList();
    int i = 0;
    while (i < j)
    {
      RectF localRectF = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
      this.IhX.add(localRectF);
      i += 1;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeInt(this.asw);
    paramObjectOutputStream.writeInt(this.Mc);
    paramObjectOutputStream.writeInt(this.IhX.size());
    Iterator localIterator = this.IhX.iterator();
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
  
  public final boolean al(float paramFloat1, float paramFloat2)
  {
    if (this.IhX == null) {
      return false;
    }
    Iterator localIterator = this.IhX.iterator();
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
    } while ((paramObject.asw != this.asw) || (paramObject.Mc != this.Mc));
    int i = 0;
    for (;;)
    {
      if (i >= this.IhX.size()) {
        break label88;
      }
      if (!((RectF)this.IhX.get(i)).equals((RectF)paramObject.IhX.get(i))) {
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
    while (i < this.IhX.size())
    {
      j += ((RectF)this.IhX.get(i)).hashCode();
      i += 1;
    }
    return this.asw + this.Mc + j;
  }
  
  final void in(List<d> paramList)
  {
    if (this.IhX == null)
    {
      this.IhX = new LinkedList();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      d locald;
      if (paramList.hasNext())
      {
        locald = (d)paramList.next();
        if ((locald.asw <= this.asw) && (this.Mc < locald.Mc)) {
          this.IhX.add(locald.kg(this.asw, this.Mc));
        }
      }
      else
      {
        return;
      }
      if ((locald.asw <= this.asw) && (this.asw < locald.Mc) && (locald.Mc <= this.Mc))
      {
        this.IhX.add(locald.kg(this.asw, locald.Mc));
      }
      else
      {
        if ((this.asw < locald.asw) && (this.Mc < locald.Mc) && (this.Mc >= locald.asw))
        {
          this.IhX.add(locald.kg(locald.asw, this.Mc));
          return;
        }
        if ((this.asw < locald.asw) && (this.Mc >= locald.Mc)) {
          this.IhX.add(locald.kg(locald.asw, locald.Mc));
        }
      }
    }
  }
  
  public String toString()
  {
    return "CharacterBgStyle{mRectFList=" + this.IhX + ", mStart=" + this.asw + ", mEnd=" + this.Mc + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.b.b
 * JD-Core Version:    0.7.0.1
 */