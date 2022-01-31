package com.tencent.tinker.loader.shareutil;

import java.util.ArrayList;

public class ShareBsDiffPatchInfo
{
  public String bIW;
  public String bvC;
  public String name;
  public String path;
  public String wYk;
  
  private ShareBsDiffPatchInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.name = paramString1;
    this.bIW = paramString2;
    this.wYk = paramString4;
    this.bvC = paramString5;
    this.path = paramString3;
  }
  
  public static boolean a(ShareBsDiffPatchInfo paramShareBsDiffPatchInfo)
  {
    if (paramShareBsDiffPatchInfo == null) {}
    String str;
    do
    {
      return false;
      str = paramShareBsDiffPatchInfo.name;
      paramShareBsDiffPatchInfo = paramShareBsDiffPatchInfo.bIW;
    } while ((str == null) || (str.length() <= 0) || (paramShareBsDiffPatchInfo == null) || (paramShareBsDiffPatchInfo.length() != 32));
    return true;
  }
  
  public static void l(String paramString, ArrayList<ShareBsDiffPatchInfo> paramArrayList)
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
            paramArrayList.add(new ShareBsDiffPatchInfo(str1, arrayOfString[2].trim(), str2, arrayOfString[3].trim(), arrayOfString[4].trim()));
          }
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.name);
    localStringBuffer.append(",");
    localStringBuffer.append(this.path);
    localStringBuffer.append(",");
    localStringBuffer.append(this.bIW);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wYk);
    localStringBuffer.append(",");
    localStringBuffer.append(this.bvC);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo
 * JD-Core Version:    0.7.0.1
 */