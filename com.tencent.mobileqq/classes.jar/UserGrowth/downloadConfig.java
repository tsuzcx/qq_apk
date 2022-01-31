package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class downloadConfig
  extends JceStruct
{
  public boolean appStoreSwitch;
  public String downloadUrl = "";
  public boolean enableRock;
  public String packageName = "";
  public boolean preload;
  public String preloadDownloadUrl = "";
  public String qqDownloadUrl = "";
  public int vendorId;
  public int versionCode;
  
  public downloadConfig() {}
  
  public downloadConfig(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean3, String paramString4)
  {
    this.preload = paramBoolean1;
    this.appStoreSwitch = paramBoolean2;
    this.packageName = paramString1;
    this.downloadUrl = paramString2;
    this.vendorId = paramInt1;
    this.versionCode = paramInt2;
    this.preloadDownloadUrl = paramString3;
    this.enableRock = paramBoolean3;
    this.qqDownloadUrl = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.preload = paramJceInputStream.read(this.preload, 0, false);
    this.appStoreSwitch = paramJceInputStream.read(this.appStoreSwitch, 1, false);
    this.packageName = paramJceInputStream.readString(2, false);
    this.downloadUrl = paramJceInputStream.readString(3, false);
    this.vendorId = paramJceInputStream.read(this.vendorId, 4, false);
    this.versionCode = paramJceInputStream.read(this.versionCode, 5, false);
    this.preloadDownloadUrl = paramJceInputStream.readString(6, false);
    this.enableRock = paramJceInputStream.read(this.enableRock, 7, false);
    this.qqDownloadUrl = paramJceInputStream.readString(8, false);
  }
  
  public String toString()
  {
    return "downloadConfig {preload=" + this.preload + ", appStoreSwitch=" + this.appStoreSwitch + ", packageName='" + this.packageName + '\'' + ", downloadUrl='" + this.downloadUrl + '\'' + ", vendorId=" + this.vendorId + ", versionCode=" + this.versionCode + ", preloadDownloadUrl='" + this.preloadDownloadUrl + '\'' + ", enableRock=" + this.enableRock + ", qqDownloadUrl=" + this.qqDownloadUrl + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.preload, 0);
    paramJceOutputStream.write(this.appStoreSwitch, 1);
    if (this.packageName != null) {
      paramJceOutputStream.write(this.packageName, 2);
    }
    if (this.downloadUrl != null) {
      paramJceOutputStream.write(this.downloadUrl, 3);
    }
    paramJceOutputStream.write(this.vendorId, 4);
    paramJceOutputStream.write(this.versionCode, 5);
    if (this.preloadDownloadUrl != null) {
      paramJceOutputStream.write(this.preloadDownloadUrl, 6);
    }
    paramJceOutputStream.write(this.enableRock, 7);
    if (this.qqDownloadUrl != null) {
      paramJceOutputStream.write(this.qqDownloadUrl, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.downloadConfig
 * JD-Core Version:    0.7.0.1
 */