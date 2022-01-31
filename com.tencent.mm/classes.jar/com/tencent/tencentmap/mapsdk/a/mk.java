package com.tencent.tencentmap.mapsdk.a;

public class mk
{
  private w a;
  
  public mk(w paramw)
  {
    this.a = paramw;
  }
  
  public String a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = (int)(Math.pow(2.0D, paramInt3) - 1.0D - paramInt2);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("https://p0.map.gtimg.com/scenic/");
    localStringBuffer.append("?z=");
    localStringBuffer.append(paramInt3);
    localStringBuffer.append("&y=");
    localStringBuffer.append(paramInt2);
    localStringBuffer.append("&x=");
    localStringBuffer.append(paramInt1);
    localStringBuffer.append("&styleid=");
    localStringBuffer.append(7);
    localStringBuffer.append("&version=");
    localStringBuffer.append(mh.a());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mk
 * JD-Core Version:    0.7.0.1
 */