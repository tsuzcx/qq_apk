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
  protected LinkedList<RectF> JJG;
  public CharacterStyle JJH;
  private int MZ;
  private int atr;
  
  b(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    this.atr = paramInt1;
    this.MZ = paramInt2;
    this.JJH = paramCharacterStyle;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    this.atr = paramObjectInputStream.readInt();
    this.MZ = paramObjectInputStream.readInt();
    int j = paramObjectInputStream.readInt();
    this.JJG = new LinkedList();
    int i = 0;
    while (i < j)
    {
      RectF localRectF = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
      this.JJG.add(localRectF);
      i += 1;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeInt(this.atr);
    paramObjectOutputStream.writeInt(this.MZ);
    paramObjectOutputStream.writeInt(this.JJG.size());
    Iterator localIterator = this.JJG.iterator();
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
  
  public final boolean ap(float paramFloat1, float paramFloat2)
  {
    if (this.JJG == null) {
      return false;
    }
    Iterator localIterator = this.JJG.iterator();
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
    } while ((paramObject.atr != this.atr) || (paramObject.MZ != this.MZ));
    int i = 0;
    for (;;)
    {
      if (i >= this.JJG.size()) {
        break label88;
      }
      if (!((RectF)this.JJG.get(i)).equals((RectF)paramObject.JJG.get(i))) {
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
    while (i < this.JJG.size())
    {
      j += ((RectF)this.JJG.get(i)).hashCode();
      i += 1;
    }
    return this.atr + this.MZ + j;
  }
  
  final void iA(List<d> paramList)
  {
    if (this.JJG == null)
    {
      this.JJG = new LinkedList();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      d locald;
      if (paramList.hasNext())
      {
        locald = (d)paramList.next();
        if ((locald.atr <= this.atr) && (this.MZ < locald.MZ)) {
          this.JJG.add(locald.kt(this.atr, this.MZ));
        }
      }
      else
      {
        return;
      }
      if ((locald.atr <= this.atr) && (this.atr < locald.MZ) && (locald.MZ <= this.MZ))
      {
        this.JJG.add(locald.kt(this.atr, locald.MZ));
      }
      else
      {
        if ((this.atr < locald.atr) && (this.MZ < locald.MZ) && (this.MZ >= locald.atr))
        {
          this.JJG.add(locald.kt(locald.atr, this.MZ));
          return;
        }
        if ((this.atr < locald.atr) && (this.MZ >= locald.MZ)) {
          this.JJG.add(locald.kt(locald.atr, locald.MZ));
        }
      }
    }
  }
  
  public String toString()
  {
    return "CharacterBgStyle{mRectFList=" + this.JJG + ", mStart=" + this.atr + ", mEnd=" + this.MZ + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.b.b
 * JD-Core Version:    0.7.0.1
 */