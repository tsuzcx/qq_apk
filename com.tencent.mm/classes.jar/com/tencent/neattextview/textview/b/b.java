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
  private int Pc;
  protected LinkedList<RectF> RAL;
  public CharacterStyle RAM;
  private int avh;
  
  b(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    this.avh = paramInt1;
    this.Pc = paramInt2;
    this.RAM = paramCharacterStyle;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    this.avh = paramObjectInputStream.readInt();
    this.Pc = paramObjectInputStream.readInt();
    int j = paramObjectInputStream.readInt();
    this.RAL = new LinkedList();
    int i = 0;
    while (i < j)
    {
      RectF localRectF = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
      this.RAL.add(localRectF);
      i += 1;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeInt(this.avh);
    paramObjectOutputStream.writeInt(this.Pc);
    paramObjectOutputStream.writeInt(this.RAL.size());
    Iterator localIterator = this.RAL.iterator();
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
  
  public final boolean aF(float paramFloat1, float paramFloat2)
  {
    if (this.RAL == null) {
      return false;
    }
    Iterator localIterator = this.RAL.iterator();
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
    } while ((paramObject.avh != this.avh) || (paramObject.Pc != this.Pc));
    int i = 0;
    for (;;)
    {
      if (i >= this.RAL.size()) {
        break label88;
      }
      if (!((RectF)this.RAL.get(i)).equals((RectF)paramObject.RAL.get(i))) {
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
    while (i < this.RAL.size())
    {
      j += ((RectF)this.RAL.get(i)).hashCode();
      i += 1;
    }
    return this.avh + this.Pc + j;
  }
  
  final void kb(List<d> paramList)
  {
    if (this.RAL == null)
    {
      this.RAL = new LinkedList();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      d locald;
      if (paramList.hasNext())
      {
        locald = (d)paramList.next();
        if ((locald.avh <= this.avh) && (this.Pc < locald.Pc)) {
          this.RAL.add(locald.mo(this.avh, this.Pc));
        }
      }
      else
      {
        return;
      }
      if ((locald.avh <= this.avh) && (this.avh < locald.Pc) && (locald.Pc <= this.Pc))
      {
        this.RAL.add(locald.mo(this.avh, locald.Pc));
      }
      else
      {
        if ((this.avh < locald.avh) && (this.Pc < locald.Pc) && (this.Pc >= locald.avh))
        {
          this.RAL.add(locald.mo(locald.avh, this.Pc));
          return;
        }
        if ((this.avh < locald.avh) && (this.Pc >= locald.Pc)) {
          this.RAL.add(locald.mo(locald.avh, locald.Pc));
        }
      }
    }
  }
  
  public String toString()
  {
    return "CharacterBgStyle{mRectFList=" + this.RAL + ", mStart=" + this.avh + ", mEnd=" + this.Pc + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.b.b
 * JD-Core Version:    0.7.0.1
 */