package com.tencent.tencentmap.mapsdk.a;

public class bo
  extends RuntimeException
{
  int a;
  
  public bo() {}
  
  public bo(int paramInt)
  {
    super("server error code :" + paramInt);
    this.a = paramInt;
  }
  
  public bo(String paramString)
  {
    super(paramString);
  }
  
  public bo(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public static bo a(int paramInt)
  {
    return a(paramInt, "");
  }
  
  public static bo a(int paramInt, String paramString)
  {
    if (paramInt == -1) {
      return new bt(paramInt);
    }
    if (paramInt == -2) {
      return new bu(paramInt);
    }
    if (paramInt == -3) {
      return new bv(paramInt);
    }
    if (paramInt == -4) {
      return new bw(paramInt);
    }
    if (paramInt == -6) {
      return new bx(paramInt);
    }
    if (paramInt == -5) {
      return new by(paramInt);
    }
    return new bz(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bo
 * JD-Core Version:    0.7.0.1
 */