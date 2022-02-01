package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetItemWatchWordReq
  extends JceStruct
{
  static LoginInfo cache_stLogin = new LoginInfo();
  static UniBusinessItem cache_stUniBusinessItem = new UniBusinessItem();
  public LoginInfo stLogin;
  public UniBusinessItem stUniBusinessItem;
  
  public GetItemWatchWordReq() {}
  
  public GetItemWatchWordReq(LoginInfo paramLoginInfo, UniBusinessItem paramUniBusinessItem)
  {
    this.stLogin = paramLoginInfo;
    this.stUniBusinessItem = paramUniBusinessItem;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, false));
    this.stUniBusinessItem = ((UniBusinessItem)paramJceInputStream.read(cache_stUniBusinessItem, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stLogin != null) {
      paramJceOutputStream.write(this.stLogin, 0);
    }
    if (this.stUniBusinessItem != null) {
      paramJceOutputStream.write(this.stUniBusinessItem, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.GetItemWatchWordReq
 * JD-Core Version:    0.7.0.1
 */