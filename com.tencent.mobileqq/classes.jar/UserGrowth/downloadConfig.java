package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class downloadConfig
  extends JceStruct
{
  public boolean appStoreSwitch = false;
  public String downloadUrl = "";
  public boolean enableRock = false;
  public String packageName = "";
  public boolean preload = false;
  public String preloadDownloadUrl = "";
  public String qqDownloadUrl = "";
  public int vendorId = 0;
  public int versionCode = 0;
  
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadConfig {preload=");
    localStringBuilder.append(this.preload);
    localStringBuilder.append(", appStoreSwitch=");
    localStringBuilder.append(this.appStoreSwitch);
    localStringBuilder.append(", packageName='");
    localStringBuilder.append(this.packageName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadUrl='");
    localStringBuilder.append(this.downloadUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vendorId=");
    localStringBuilder.append(this.vendorId);
    localStringBuilder.append(", versionCode=");
    localStringBuilder.append(this.versionCode);
    localStringBuilder.append(", preloadDownloadUrl='");
    localStringBuilder.append(this.preloadDownloadUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", enableRock=");
    localStringBuilder.append(this.enableRock);
    localStringBuilder.append(", qqDownloadUrl=");
    localStringBuilder.append(this.qqDownloadUrl);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.preload, 0);
    paramJceOutputStream.write(this.appStoreSwitch, 1);
    String str = this.packageName;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.downloadUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.vendorId, 4);
    paramJceOutputStream.write(this.versionCode, 5);
    str = this.preloadDownloadUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    paramJceOutputStream.write(this.enableRock, 7);
    str = this.qqDownloadUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.downloadConfig
 * JD-Core Version:    0.7.0.1
 */