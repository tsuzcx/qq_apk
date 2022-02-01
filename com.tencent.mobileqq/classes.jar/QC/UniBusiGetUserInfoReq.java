package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiGetUserInfoReq
  extends JceStruct
{
  static UniBusiUsingUid cache_relateUIDInfo = new UniBusiUsingUid();
  static LoginInfo cache_stLogin = new LoginInfo();
  public int appid = 0;
  public int pageSize = 0;
  public UniBusiUsingUid relateUIDInfo = null;
  public LoginInfo stLogin = null;
  public int startIndex = 0;
  
  public UniBusiGetUserInfoReq() {}
  
  public UniBusiGetUserInfoReq(LoginInfo paramLoginInfo, int paramInt1, int paramInt2, int paramInt3, UniBusiUsingUid paramUniBusiUsingUid)
  {
    this.stLogin = paramLoginInfo;
    this.appid = paramInt1;
    this.pageSize = paramInt2;
    this.startIndex = paramInt3;
    this.relateUIDInfo = paramUniBusiUsingUid;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, false));
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.pageSize = paramJceInputStream.read(this.pageSize, 2, false);
    this.startIndex = paramJceInputStream.read(this.startIndex, 3, false);
    this.relateUIDInfo = ((UniBusiUsingUid)paramJceInputStream.read(cache_relateUIDInfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stLogin != null) {
      paramJceOutputStream.write(this.stLogin, 0);
    }
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.pageSize, 2);
    paramJceOutputStream.write(this.startIndex, 3);
    if (this.relateUIDInfo != null) {
      paramJceOutputStream.write(this.relateUIDInfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusiGetUserInfoReq
 * JD-Core Version:    0.7.0.1
 */