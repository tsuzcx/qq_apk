package com.tencent.tinker.loader.a;

import java.util.ArrayList;

public final class a
{
  public String aat;
  public String afE;
  public String alS;
  public String alT;
  public String name;
  
  private a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.name = paramString1;
    this.afE = paramString2;
    this.alS = paramString4;
    this.alT = paramString5;
    this.aat = paramString3;
  }
  
  public static void b(String paramString, ArrayList<a> paramArrayList)
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
          arrayOfString = arrayOfString.split(",", 5);
          if ((arrayOfString != null) && (arrayOfString.length >= 5))
          {
            String str1 = arrayOfString[0].trim();
            String str2 = arrayOfString[1].trim();
            paramArrayList.add(new a(str1, arrayOfString[2].trim(), str2, arrayOfString[3].trim(), arrayOfString[4].trim()));
          }
        }
        i += 1;
      }
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.name);
    localStringBuffer.append(",");
    localStringBuffer.append(this.aat);
    localStringBuffer.append(",");
    localStringBuffer.append(this.afE);
    localStringBuffer.append(",");
    localStringBuffer.append(this.alS);
    localStringBuffer.append(",");
    localStringBuffer.append(this.alT);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.a.a
 * JD-Core Version:    0.7.0.1
 */