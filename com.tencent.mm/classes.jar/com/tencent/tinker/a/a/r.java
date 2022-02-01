package com.tencent.tinker.a.a;

public final class r
  extends s.a.a<r>
{
  public String value;
  
  public r(int paramInt, String paramString)
  {
    super(paramInt);
    this.value = paramString;
  }
  
  private int b(r paramr)
  {
    return this.value.compareTo(paramr.value);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof r)) {}
    while (b((r)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return this.value.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.r
 * JD-Core Version:    0.7.0.1
 */