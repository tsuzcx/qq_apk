package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public class ShareDexDiffPatchInfo
{
  public final String BuQ;
  public final String BuR;
  public final String BuS;
  public final String BuT;
  public final String BuU;
  public final String BuV;
  public final String BuW;
  public final boolean BuX;
  public final String ezj;
  public final String path;
  
  public ShareDexDiffPatchInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.BuQ = paramString1;
    this.path = paramString2;
    this.BuR = paramString3;
    this.BuS = paramString4;
    this.BuV = paramString5;
    this.BuT = paramString6;
    this.BuU = paramString7;
    this.BuW = paramString8;
    if (paramString8.equals("jar"))
    {
      this.BuX = true;
      if (SharePatchFileUtil.axe(paramString1))
      {
        this.ezj = (paramString1 + ".jar");
        return;
      }
      this.ezj = paramString1;
      return;
    }
    if (paramString8.equals("raw"))
    {
      this.BuX = false;
      this.ezj = paramString1;
      return;
    }
    throw new TinkerRuntimeException("can't recognize dex mode:".concat(String.valueOf(paramString8)));
  }
  
  public static boolean c(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo)
  {
    if (paramShareDexDiffPatchInfo == null) {}
    for (;;)
    {
      return false;
      String str = paramShareDexDiffPatchInfo.BuQ;
      if (ShareTinkerInternals.dWE()) {}
      for (paramShareDexDiffPatchInfo = paramShareDexDiffPatchInfo.BuS; (str != null) && (str.length() > 0) && (paramShareDexDiffPatchInfo != null) && (paramShareDexDiffPatchInfo.length() == 32); paramShareDexDiffPatchInfo = paramShareDexDiffPatchInfo.BuR) {
        return true;
      }
    }
  }
  
  public static void o(String paramString, ArrayList<ShareDexDiffPatchInfo> paramArrayList)
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
    localStringBuffer.append(this.BuQ);
    localStringBuffer.append(",");
    localStringBuffer.append(this.path);
    localStringBuffer.append(",");
    localStringBuffer.append(this.BuR);
    localStringBuffer.append(",");
    localStringBuffer.append(this.BuS);
    localStringBuffer.append(",");
    localStringBuffer.append(this.BuT);
    localStringBuffer.append(",");
    localStringBuffer.append(this.BuU);
    localStringBuffer.append(",");
    localStringBuffer.append(this.BuV);
    localStringBuffer.append(",");
    localStringBuffer.append(this.BuW);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo
 * JD-Core Version:    0.7.0.1
 */