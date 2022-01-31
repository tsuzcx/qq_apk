package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.neattextview.textview.layout.c;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class b<T extends CharacterStyle>
  implements Serializable
{
  private int Eo;
  private int aiH;
  protected LinkedList<RectF> wDy;
  public CharacterStyle wDz;
  
  b(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    this.aiH = paramInt1;
    this.Eo = paramInt2;
    this.wDz = paramCharacterStyle;
  }
  
  public abstract void a(Canvas paramCanvas, TextPaint paramTextPaint, List<c> paramList);
  
  public final boolean af(float paramFloat1, float paramFloat2)
  {
    if (this.wDy == null) {
      return false;
    }
    Iterator localIterator = this.wDy.iterator();
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
    } while ((paramObject.aiH != this.aiH) || (paramObject.Eo != this.Eo));
    int i = 0;
    for (;;)
    {
      if (i >= this.wDy.size()) {
        break label88;
      }
      if (!((RectF)this.wDy.get(i)).equals((RectF)paramObject.wDy.get(i))) {
        break;
      }
      i += 1;
    }
    label88:
    return true;
  }
  
  final void ev(List<c> paramList)
  {
    if (this.wDy == null)
    {
      this.wDy = new LinkedList();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      c localc;
      if (paramList.hasNext())
      {
        localc = (c)paramList.next();
        if ((localc.aiH <= this.aiH) && (this.Eo < localc.Eo)) {
          this.wDy.add(localc.fY(this.aiH, this.Eo));
        }
      }
      else
      {
        return;
      }
      if ((localc.aiH <= this.aiH) && (this.aiH < localc.Eo) && (localc.Eo <= this.Eo))
      {
        this.wDy.add(localc.fY(this.aiH, localc.Eo));
      }
      else
      {
        if ((this.aiH < localc.aiH) && (this.Eo < localc.Eo) && (this.Eo >= localc.aiH))
        {
          this.wDy.add(localc.fY(localc.aiH, this.Eo));
          return;
        }
        if ((this.aiH < localc.aiH) && (this.Eo >= localc.Eo)) {
          this.wDy.add(localc.fY(localc.aiH, localc.Eo));
        }
      }
    }
  }
  
  public int hashCode()
  {
    int i = 0;
    int j = 0;
    while (i < this.wDy.size())
    {
      j += ((RectF)this.wDy.get(i)).hashCode();
      i += 1;
    }
    return this.aiH + this.Eo + j;
  }
  
  public String toString()
  {
    return "CharacterBgStyle{mRectFList=" + this.wDy + ", mStart=" + this.aiH + ", mEnd=" + this.Eo + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.b.b
 * JD-Core Version:    0.7.0.1
 */