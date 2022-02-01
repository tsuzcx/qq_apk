package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiGetOneItemWithCheckReq
  extends JceStruct
{
  static LoginInfo cache_stLogin = new LoginInfo();
  public int appid = 0;
  public int itemid = 0;
  public LoginInfo stLogin = null;
  
  public UniBusiGetOneItemWithCheckReq() {}
  
  public UniBusiGetOneItemWithCheckReq(LoginInfo paramLoginInfo, int paramInt1, int paramInt2)
  {
    this.stLogin = paramLoginInfo;
    this.appid = paramInt1;
    this.itemid = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, false));
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.itemid = paramJceInputStream.read(this.itemid, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stLogin != null) {
      paramJceOutputStream.write(this.stLogin, 0);
    }
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.itemid, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusiGetOneItemWithCheckReq
 * JD-Core Version:    0.7.0.1
 */