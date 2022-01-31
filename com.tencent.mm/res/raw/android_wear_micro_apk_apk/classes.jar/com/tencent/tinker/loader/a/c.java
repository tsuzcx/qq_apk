package com.tencent.tinker.loader.a;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public final class c
{
  public final String aat;
  public final String alV;
  public final String alW;
  public final String alX;
  public final String alY;
  public final String alZ;
  public final String ama;
  public final String amb;
  public final boolean amc;
  public final String amd;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.alV = paramString1;
    this.aat = paramString2;
    this.alW = paramString3;
    this.alX = paramString4;
    this.ama = paramString5;
    this.alY = paramString6;
    this.alZ = paramString7;
    this.amb = paramString8;
    if (paramString8.equals("jar"))
    {
      this.amc = true;
      if (f.ai(paramString1))
      {
        this.amd = (paramString1 + ".jar");
        return;
      }
      this.amd = paramString1;
      return;
    }
    if (paramString8.equals("raw"))
    {
      this.amc = false;
      this.amd = paramString1;
      return;
    }
    throw new TinkerRuntimeException("can't recognize dex mode:" + paramString8);
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
    localStringBuffer.append(this.alV);
    localStringBuffer.append(",");
    localStringBuffer.append(this.aat);
    localStringBuffer.append(",");
    localStringBuffer.append(this.alW);
    localStringBuffer.append(",");
    localStringBuffer.append(this.alX);
    localStringBuffer.append(",");
    localStringBuffer.append(this.alY);
    localStringBuffer.append(",");
    localStringBuffer.append(this.alZ);
    localStringBuffer.append(",");
    localStringBuffer.append(this.ama);
    localStringBuffer.append(",");
    localStringBuffer.append(this.amb);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.a.c
 * JD-Core Version:    0.7.0.1
 */