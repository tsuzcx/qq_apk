package com.tencent.soter.core.c;

public class f
{
  public String aox;
  public int errCode;
  
  public f(int paramInt)
  {
    this.errCode = paramInt;
    switch (this.errCode)
    {
    case 1: 
    default: 
      this.aox = "errmsg not specified";
      return;
    case 0: 
      this.aox = "ok";
      return;
    }
    this.aox = "device not support soter";
  }
  
  public f(int paramInt, String paramString)
  {
    this(paramInt);
    if (!g.bl(paramString)) {
      this.aox = paramString;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof f)) && (((f)paramObject).errCode == this.errCode);
  }
  
  public final boolean isSuccess()
  {
    return this.errCode == 0;
  }
  
  public String toString()
  {
    return "SoterCoreResult{errCode=" + this.errCode + ", errMsg='" + this.aox + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.c.f
 * JD-Core Version:    0.7.0.1
 */