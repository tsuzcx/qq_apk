package com.tencent.tinker.a.a;

public final class s
  extends t.a.a<s>
{
  public String value;
  
  public s(int paramInt, String paramString)
  {
    super(paramInt);
    this.value = paramString;
  }
  
  private int b(s params)
  {
    return this.value.compareTo(params.value);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof s)) {}
    while (b((s)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return this.value.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tinker.a.a.s
 * JD-Core Version:    0.7.0.1
 */