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
  protected LinkedList<RectF> Bbi;
  public CharacterStyle Bbj;
  private int Fe;
  private int akX;
  
  b(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    this.akX = paramInt1;
    this.Fe = paramInt2;
    this.Bbj = paramCharacterStyle;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    this.akX = paramObjectInputStream.readInt();
    this.Fe = paramObjectInputStream.readInt();
    int j = paramObjectInputStream.readInt();
    this.Bbi = new LinkedList();
    int i = 0;
    while (i < j)
    {
      RectF localRectF = new RectF(paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat(), paramObjectInputStream.readFloat());
      this.Bbi.add(localRectF);
      i += 1;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeInt(this.akX);
    paramObjectOutputStream.writeInt(this.Fe);
    paramObjectOutputStream.writeInt(this.Bbi.size());
    Iterator localIterator = this.Bbi.iterator();
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
  
  public final boolean aq(float paramFloat1, float paramFloat2)
  {
    if (this.Bbi == null) {
      return false;
    }
    Iterator localIterator = this.Bbi.iterator();
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
    } while ((paramObject.akX != this.akX) || (paramObject.Fe != this.Fe));
    int i = 0;
    for (;;)
    {
      if (i >= this.Bbi.size()) {
        break label88;
      }
      if (!((RectF)this.Bbi.get(i)).equals((RectF)paramObject.Bbi.get(i))) {
        break;
      }
      i += 1;
    }
    label88:
    return true;
  }
  
  final void fH(List<d> paramList)
  {
    if (this.Bbi == null)
    {
      this.Bbi = new LinkedList();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      d locald;
      if (paramList.hasNext())
      {
        locald = (d)paramList.next();
        if ((locald.akX <= this.akX) && (this.Fe < locald.Fe)) {
          this.Bbi.add(locald.ij(this.akX, this.Fe));
        }
      }
      else
      {
        return;
      }
      if ((locald.akX <= this.akX) && (this.akX < locald.Fe) && (locald.Fe <= this.Fe))
      {
        this.Bbi.add(locald.ij(this.akX, locald.Fe));
      }
      else
      {
        if ((this.akX < locald.akX) && (this.Fe < locald.Fe) && (this.Fe >= locald.akX))
        {
          this.Bbi.add(locald.ij(locald.akX, this.Fe));
          return;
        }
        if ((this.akX < locald.akX) && (this.Fe >= locald.Fe)) {
          this.Bbi.add(locald.ij(locald.akX, locald.Fe));
        }
      }
    }
  }
  
  public int hashCode()
  {
    int i = 0;
    int j = 0;
    while (i < this.Bbi.size())
    {
      j += ((RectF)this.Bbi.get(i)).hashCode();
      i += 1;
    }
    return this.akX + this.Fe + j;
  }
  
  public String toString()
  {
    return "CharacterBgStyle{mRectFList=" + this.Bbi + ", mStart=" + this.akX + ", mEnd=" + this.Fe + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.b.b
 * JD-Core Version:    0.7.0.1
 */