package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public class ShareDexDiffPatchInfo
{
  public final String dBS;
  public final String path;
  public final String wYm;
  public final String wYn;
  public final String wYo;
  public final String wYp;
  public final String wYq;
  public final String wYr;
  public final String wYs;
  public final boolean wYt;
  
  public ShareDexDiffPatchInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.wYm = paramString1;
    this.path = paramString2;
    this.wYn = paramString3;
    this.wYo = paramString4;
    this.wYr = paramString5;
    this.wYp = paramString6;
    this.wYq = paramString7;
    this.wYs = paramString8;
    if (paramString8.equals("jar"))
    {
      this.wYt = true;
      if (SharePatchFileUtil.agn(paramString1))
      {
        this.dBS = (paramString1 + ".jar");
        return;
      }
      this.dBS = paramString1;
      return;
    }
    if (paramString8.equals("raw"))
    {
      this.wYt = false;
      this.dBS = paramString1;
      return;
    }
    throw new TinkerRuntimeException("can't recognize dex mode:" + paramString8);
  }
  
  public static boolean c(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo)
  {
    if (paramShareDexDiffPatchInfo == null) {}
    for (;;)
    {
      return false;
      String str = paramShareDexDiffPatchInfo.wYm;
      if (ShareTinkerInternals.cQP()) {}
      for (paramShareDexDiffPatchInfo = paramShareDexDiffPatchInfo.wYo; (str != null) && (str.length() > 0) && (paramShareDexDiffPatchInfo != null) && (paramShareDexDiffPatchInfo.length() == 32); paramShareDexDiffPatchInfo = paramShareDexDiffPatchInfo.wYn) {
        return true;
      }
    }
  }
  
  public static void m(String paramString, ArrayList<ShareDexDiffPatchInfo> paramArrayList)
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
    localStringBuffer.append(this.wYm);
    localStringBuffer.append(",");
    localStringBuffer.append(this.path);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wYn);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wYo);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wYp);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wYq);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wYr);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wYs);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo
 * JD-Core Version:    0.7.0.1
 */