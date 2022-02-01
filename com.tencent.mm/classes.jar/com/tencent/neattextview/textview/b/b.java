package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.neattextview.textview.layout.d;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class b<T extends CharacterStyle>
  implements Serializable
{
  protected LinkedList<RectF> ahaS;
  public CharacterStyle ahaT;
  private int uG;
  private int uH;
  
  b(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    this.uG = paramInt1;
    this.uH = paramInt2;
    this.ahaT = paramCharacterStyle;
  }
  
  public abstract void a(Canvas paramCanvas, TextPaint paramTextPaint, List<d> paramList);
  
  public final boolean bq(float paramFloat1, float paramFloat2)
  {
    if (this.ahaS == null) {
      return false;
    }
    Iterator localIterator = this.ahaS.iterator();
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
    } while ((paramObject.uG != this.uG) || (paramObject.uH != this.uH));
    int i = 0;
    for (;;)
    {
      if (i >= this.ahaS.size()) {
        break label88;
      }
      if (!((RectF)this.ahaS.get(i)).equals((RectF)paramObject.ahaS.get(i))) {
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
    while (i < this.ahaS.size())
    {
      j += ((RectF)this.ahaS.get(i)).hashCode();
      i += 1;
    }
    return this.uG + this.uH + j;
  }
  
  final void os(List<d> paramList)
  {
    if (this.ahaS == null)
    {
      this.ahaS = new LinkedList();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      d locald;
      if (paramList.hasNext())
      {
        locald = (d)paramList.next();
        if ((locald.uG <= this.uG) && (this.uH < locald.uH)) {
          this.ahaS.add(locald.pC(this.uG, this.uH));
        }
      }
      else
      {
        return;
      }
      if ((locald.uG <= this.uG) && (this.uG < locald.uH) && (locald.uH <= this.uH))
      {
        this.ahaS.add(locald.pC(this.uG, locald.uH));
      }
      else
      {
        if ((this.uG < locald.uG) && (this.uH < locald.uH) && (this.uH >= locald.uG))
        {
          this.ahaS.add(locald.pC(locald.uG, this.uH));
          return;
        }
        if ((this.uG < locald.uG) && (this.uH >= locald.uH)) {
          this.ahaS.add(locald.pC(locald.uG, locald.uH));
        }
      }
    }
  }
  
  public String toString()
  {
    return "CharacterBgStyle{mRectFList=" + this.ahaS + ", mStart=" + this.uG + ", mEnd=" + this.uH + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.neattextview.textview.b.b
 * JD-Core Version:    0.7.0.1
 */