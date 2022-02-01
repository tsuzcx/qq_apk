package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetMiniAppReq
  extends JceStruct
{
  public static final int ACTION_GET_SHARE_PIC_UPLOAD_URL = 6;
  public static final int ACTION_GET_SYSTEM_LOG_UPLOAD_URL = 4;
  public static final int ACTION_GET_USER_LOG_UPLOAD_URL = 5;
  public static final int ACTION_NORMAL_GET_INFO = 0;
  public static final int ACTION_QQ_SCAN_CODE = 1;
  public static final int ACTION_WX_SCAN_CODE = 2;
  public int action = 0;
  public String extra_keys = "";
  public String mini_appid = "";
  public int mini_version = 0;
  public String platform = "";
  public String qq_version = "";
  public String uin = "";
  
  public GetMiniAppReq() {}
  
  public GetMiniAppReq(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mini_appid = paramString1;
    this.uin = paramString3;
    this.mini_version = paramInt1;
    this.platform = paramString4;
    this.qq_version = paramString5;
    this.action = paramInt2;
    this.extra_keys = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mini_appid = paramJceInputStream.readString(0, false);
    this.uin = paramJceInputStream.readString(1, false);
    this.mini_version = paramJceInputStream.read(this.mini_version, 2, false);
    this.platform = paramJceInputStream.readString(3, false);
    this.qq_version = paramJceInputStream.readString(4, false);
    this.action = paramJceInputStream.read(this.action, 5, false);
    this.extra_keys = paramJceInputStream.readString(6, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetMiniAppReq{mini_appid='");
    localStringBuilder.append(this.mini_appid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mini_version=");
    localStringBuilder.append(this.mini_version);
    localStringBuilder.append(", platform='");
    localStringBuilder.append(this.platform);
    localStringBuilder.append('\'');
    localStringBuilder.append(", qq_version='");
    localStringBuilder.append(this.qq_version);
    localStringBuilder.append('\'');
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.action);
    localStringBuilder.append(", extra_keys='");
    localStringBuilder.append(this.extra_keys);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.mini_appid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.uin;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.mini_version, 2);
    str = this.platform;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.qq_version;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.action, 5);
    str = this.extra_keys;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.GetMiniAppReq
 * JD-Core Version:    0.7.0.1
 */