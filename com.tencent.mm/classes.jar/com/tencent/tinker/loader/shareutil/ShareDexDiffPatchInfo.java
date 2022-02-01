package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public class ShareDexDiffPatchInfo
{
  public final String destMd5InArt;
  public final String destMd5InDvm;
  public final String dexDiffMd5;
  public final String dexMode;
  public final boolean isJarMode;
  public final String newOrPatchedDexCrC;
  public final String oldDexCrC;
  public final String path;
  public final String rawName;
  public final String realName;
  
  public ShareDexDiffPatchInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.rawName = paramString1;
    this.path = paramString2;
    this.destMd5InDvm = paramString3;
    this.destMd5InArt = paramString4;
    this.dexDiffMd5 = paramString5;
    this.oldDexCrC = paramString6;
    this.newOrPatchedDexCrC = paramString7;
    this.dexMode = paramString8;
    if (paramString8.equals("jar"))
    {
      this.isJarMode = true;
      if (SharePatchFileUtil.isRawDexFile(paramString1))
      {
        this.realName = (paramString1 + ".jar");
        return;
      }
      this.realName = paramString1;
      return;
    }
    if (paramString8.equals("raw"))
    {
      this.isJarMode = false;
      this.realName = paramString1;
      return;
    }
    throw new TinkerRuntimeException("can't recognize dex mode:".concat(String.valueOf(paramString8)));
  }
  
  public static boolean checkDexDiffPatchInfo(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo)
  {
    if (paramShareDexDiffPatchInfo == null) {}
    for (;;)
    {
      return false;
      String str = paramShareDexDiffPatchInfo.rawName;
      if (ShareTinkerInternals.isVmArt()) {}
      for (paramShareDexDiffPatchInfo = paramShareDexDiffPatchInfo.destMd5InArt; (str != null) && (str.length() > 0) && (paramShareDexDiffPatchInfo != null) && (paramShareDexDiffPatchInfo.length() == 32); paramShareDexDiffPatchInfo = paramShareDexDiffPatchInfo.destMd5InDvm) {
        return true;
      }
    }
  }
  
  public static void parseDexDiffPatchInfo(String paramString, ArrayList<ShareDexDiffPatchInfo> paramArrayList)
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
            paramArrayList.add(new ShareDexDiffPatchInfo(arrayOfString[0].trim(), arrayOfString[1].trim(), arrayOfString[2].trim(), arrayOfString[3].trim(), arrayOfString[4].trim(), arrayOfString[5].trim(), arrayOfString[6].trim(), arrayOfString[7].trim()));
          }
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.rawName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.path);
    localStringBuffer.append(",");
    localStringBuffer.append(this.destMd5InDvm);
    localStringBuffer.append(",");
    localStringBuffer.append(this.destMd5InArt);
    localStringBuffer.append(",");
    localStringBuffer.append(this.oldDexCrC);
    localStringBuffer.append(",");
    localStringBuffer.append(this.newOrPatchedDexCrC);
    localStringBuffer.append(",");
    localStringBuffer.append(this.dexDiffMd5);
    localStringBuffer.append(",");
    localStringBuffer.append(this.dexMode);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo
 * JD-Core Version:    0.7.0.1
 */