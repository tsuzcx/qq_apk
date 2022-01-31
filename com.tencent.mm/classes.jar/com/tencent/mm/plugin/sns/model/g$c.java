package com.tencent.mm.plugin.sns.model;

final class g$c
{
  public int code;
  public String id;
  public int opC;
  public boolean opD;
  
  public g$c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.id = paramString;
    this.code = paramInt1;
    this.opC = paramInt2;
    this.opD = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && (paramObject.hashCode() == this.code);
  }
  
  public final int hashCode()
  {
    return this.code;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.c
 * JD-Core Version:    0.7.0.1
 */