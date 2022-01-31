package Wallet;

import babp;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public final class GetMiniAppReq
  extends JceStruct
{
  public static final int ACTION_GET_SHARE_PIC_UPLOAD_URL = 6;
  public static final int ACTION_GET_SYSTEM_LOG_UPLOAD_URL = 4;
  public static final int ACTION_GET_USER_LOG_UPLOAD_URL = 5;
  public static final int ACTION_NORMAL_GET_INFO = 0;
  public static final int ACTION_QQ_SCAN_CODE = 1;
  public static final int ACTION_WX_SCAN_CODE = 2;
  public int action;
  public String extra_keys = "";
  public String mini_appid = "";
  public int mini_version;
  public String platform = "";
  public String qq_version = "";
  public String uin = "";
  
  public GetMiniAppReq() {}
  
  public GetMiniAppReq(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.mini_appid = paramString1;
    this.uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.mini_version = paramInt1;
    this.platform = ("Android|" + babp.e() + "|" + babp.i());
    this.qq_version = babp.c();
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
    return "GetMiniAppReq{mini_appid='" + this.mini_appid + '\'' + ", uin='" + this.uin + '\'' + ", mini_version=" + this.mini_version + ", platform='" + this.platform + '\'' + ", qq_version='" + this.qq_version + '\'' + ", action=" + this.action + ", extra_keys='" + this.extra_keys + '\'' + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mini_appid != null) {
      paramJceOutputStream.write(this.mini_appid, 0);
    }
    if (this.uin != null) {
      paramJceOutputStream.write(this.uin, 1);
    }
    paramJceOutputStream.write(this.mini_version, 2);
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 3);
    }
    if (this.qq_version != null) {
      paramJceOutputStream.write(this.qq_version, 4);
    }
    paramJceOutputStream.write(this.action, 5);
    if (this.extra_keys != null) {
      paramJceOutputStream.write(this.extra_keys, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.GetMiniAppReq
 * JD-Core Version:    0.7.0.1
 */