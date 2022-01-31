package com.tencent.util;

public final class d$a
{
  public int height;
  public int width;
  
  d$a(d paramd, int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.width != paramObject.width) {
        return false;
      }
    } while (this.height == paramObject.height);
    return false;
  }
  
  public final int hashCode()
  {
    return this.width * 31 + this.height;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.util.d.a
 * JD-Core Version:    0.7.0.1
 */