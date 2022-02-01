package com.tencent.tinker.loader.a;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public final class c
{
  public final String adU;
  public final String apA;
  public final String apB;
  public final boolean apC;
  public final String apD;
  public final String apv;
  public final String apw;
  public final String apx;
  public final String apy;
  public final String apz;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.apv = paramString1;
    this.adU = paramString2;
    this.apw = paramString3;
    this.apx = paramString4;
    this.apA = paramString5;
    this.apy = paramString6;
    this.apz = paramString7;
    this.apB = paramString8;
    if (paramString8.equals("jar"))
    {
      this.apC = true;
      if (f.am(paramString1))
      {
        this.apD = (paramString1 + ".jar");
        return;
      }
      this.apD = paramString1;
      return;
    }
    if (paramString8.equals("raw"))
    {
      this.apC = false;
      this.apD = paramString1;
      return;
    }
    throw new TinkerRuntimeException("can't recognize dex mode:".concat(String.valueOf(paramString8)));
  }
  
  public static void c(String paramString, ArrayList<c> paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      paramString = paramString.split("\n");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i];
        if ((arrayOfString != null) && (arrayOfString.length() > 0))
        {
          arrayOfString = arrayOfString.split(",", 8);
          if ((arrayOfString != null) && (arrayOfString.length >= 8)) {
            paramArrayList.add(new c(arrayOfString[0].trim(), arrayOfString[1].trim(), arrayOfString[2].trim(), arrayOfString[3].trim(), arrayOfString[4].trim(), arrayOfString[5].trim(), arrayOfString[6].trim(), arrayOfString[7].trim()));
          }
        }
        i += 1;
      }
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.apv);
    localStringBuffer.append(",");
    localStringBuffer.append(this.adU);
    localStringBuffer.append(",");
    localStringBuffer.append(this.apw);
    localStringBuffer.append(",");
    localStringBuffer.append(this.apx);
    localStringBuffer.append(",");
    localStringBuffer.append(this.apy);
    localStringBuffer.append(",");
    localStringBuffer.append(this.apz);
    localStringBuffer.append(",");
    localStringBuffer.append(this.apA);
    localStringBuffer.append(",");
    localStringBuffer.append(this.apB);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.a.c
 * JD-Core Version:    0.7.0.1
 */