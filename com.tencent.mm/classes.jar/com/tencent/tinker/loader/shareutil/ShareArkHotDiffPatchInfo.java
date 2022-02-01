package com.tencent.tinker.loader.shareutil;

import java.util.ArrayList;

public class ShareArkHotDiffPatchInfo
{
  public String name;
  public String patchMd5;
  public String path;
  
  public ShareArkHotDiffPatchInfo(String paramString1, String paramString2, String paramString3)
  {
    this.name = paramString2;
    this.patchMd5 = paramString3;
    this.path = paramString1;
  }
  
  public static boolean checkDiffPatchInfo(ShareArkHotDiffPatchInfo paramShareArkHotDiffPatchInfo)
  {
    if (paramShareArkHotDiffPatchInfo == null) {}
    String str;
    do
    {
      return false;
      str = paramShareArkHotDiffPatchInfo.name;
      paramShareArkHotDiffPatchInfo = paramShareArkHotDiffPatchInfo.patchMd5;
    } while ((str == null) || (str.length() <= 0) || (paramShareArkHotDiffPatchInfo == null) || (paramShareArkHotDiffPatchInfo.length() != 32));
    return true;
  }
  
  public static void parseDiffPatchInfo(String paramString, ArrayList<ShareArkHotDiffPatchInfo> paramArrayList)
  {
    if ((paramString == null) || (paramArrayList == null)) {}
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
          arrayOfString = arrayOfString.split(",", 4);
          if ((arrayOfString != null) && (arrayOfString.length >= 3))
          {
            String str = arrayOfString[0].trim();
            paramArrayList.add(new ShareArkHotDiffPatchInfo(arrayOfString[1].trim(), str, arrayOfString[2].trim()));
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
    localStringBuffer.append(this.patchMd5);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareArkHotDiffPatchInfo
 * JD-Core Version:    0.7.0.1
 */