package com.tencent.mm.ui;

public final class f$b<K, T>
{
  public K object;
  public int uIt;
  public T uIu;
  
  public f$b(K paramK, int paramInt)
  {
    this.object = paramK;
    this.uIt = paramInt;
    this.uIu = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (b)paramObject;
        if (this.uIt != paramObject.uIt) {
          return false;
        }
        if (this.object != null) {
          break;
        }
      } while (paramObject.object == null);
      return false;
    } while (this.object.equals(paramObject.object));
    return false;
  }
  
  public final int hashCode()
  {
    int j = this.uIt;
    if (this.object == null) {}
    for (int i = 0;; i = this.object.hashCode()) {
      return i + (j + 31) * 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.f.b
 * JD-Core Version:    0.7.0.1
 */