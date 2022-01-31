package com.tencent.tencentmap.mapsdk.a;

import java.net.MalformedURLException;
import java.net.URL;

public final class ul
  extends uj
{
  private String[] b = { "https://p0.map.gtimg.com/sateTiles", "https://p1.map.gtimg.com/sateTiles", "https://p2.map.gtimg.com/sateTiles", "https://p3.map.gtimg.com/sateTiles" };
  
  public ul(int paramInt)
  {
    super(paramInt);
  }
  
  public final URL a(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    paramInt2 = (int)(Math.pow(2.0D, paramInt3) - paramInt2 - 1.0D);
    int i = a(paramInt1 + paramInt2, 4);
    paramVarArgs = this.b[i] + '/' + paramInt3 + '/' + (paramInt1 >> 4) + '/' + (paramInt2 >> 4) + '/' + paramInt1 + '_' + paramInt2 + ".jpg";
    try
    {
      paramVarArgs = new URL(paramVarArgs);
      return paramVarArgs;
    }
    catch (MalformedURLException paramVarArgs) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ul
 * JD-Core Version:    0.7.0.1
 */