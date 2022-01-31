package com.tencent.tencentmap.mapsdk.a;

public class kc
{
  public final String a;
  public final String b;
  public final int c;
  public final String[] d;
  
  public kc(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.d = a(paramArrayOfString);
    this.c = paramInt;
  }
  
  private String[] a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    String[] arrayOfString = new String[paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, arrayOfString.length);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.kc
 * JD-Core Version:    0.7.0.1
 */