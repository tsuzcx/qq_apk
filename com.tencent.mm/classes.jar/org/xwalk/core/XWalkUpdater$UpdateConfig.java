package org.xwalk.core;

public class XWalkUpdater$UpdateConfig
{
  public int apkVer = -1;
  public boolean bTryUseSharedCore;
  public boolean bUseCdn;
  public String downUrl;
  public String downloadFileMd5;
  public boolean isMatchMd5;
  public boolean isPatchUpdate;
  public String patchEndFileMd5;
  public String versionDetail;
  
  public XWalkUpdater$UpdateConfig(String paramString, boolean paramBoolean, int paramInt)
  {
    this.isMatchMd5 = false;
    this.isPatchUpdate = paramBoolean;
    this.downUrl = paramString;
    this.apkVer = paramInt;
    if (!checkValid()) {
      throw new RuntimeException("royle:UpdateConfig is not valid");
    }
  }
  
  public XWalkUpdater$UpdateConfig(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt)
  {
    this.isMatchMd5 = true;
    this.downloadFileMd5 = paramString1;
    this.isPatchUpdate = paramBoolean;
    this.patchEndFileMd5 = paramString2;
    this.downUrl = paramString3;
    this.apkVer = paramInt;
    if (!checkValid()) {
      throw new RuntimeException("royle:UpdateConfig is not valid");
    }
  }
  
  public boolean checkValid()
  {
    if ((this.isMatchMd5) && ((this.downloadFileMd5 == null) || (this.downloadFileMd5.isEmpty()))) {}
    while ((this.downUrl == null) || (this.downUrl.isEmpty()) || (this.apkVer == -1) || ((this.isMatchMd5) && (this.isPatchUpdate) && ((this.patchEndFileMd5 == null) || (this.patchEndFileMd5.isEmpty())))) {
      return false;
    }
    return true;
  }
  
  public String getDownloadPath()
  {
    if (checkValid())
    {
      if (this.isPatchUpdate) {
        return XWalkEnvironment.getDownloadPatchPath(this.apkVer);
      }
      return XWalkEnvironment.getDownloadZipDir(this.apkVer);
    }
    throw new RuntimeException("royle:UpdateConfig is not valid");
  }
  
  public String getLogSelf()
  {
    if (checkValid()) {
      return "UpdateConfig isMatchMd5:" + this.isMatchMd5 + " downloadFileMd5:" + this.downloadFileMd5 + ",isPatchUpdate:" + this.isPatchUpdate + ",downUrl:" + this.downUrl + ",apkVer:" + this.apkVer + ",useCDN:" + this.bUseCdn + ",downloadPath:" + getDownloadPath() + ".";
    }
    return "UpdateConfig is not valid";
  }
  
  public int getUpdateBizType()
  {
    if (this.isPatchUpdate) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.UpdateConfig
 * JD-Core Version:    0.7.0.1
 */