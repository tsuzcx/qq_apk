package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetItemWatchWordReq
  extends JceStruct
{
  static LoginInfo cache_stLogin = new LoginInfo();
  static UniBusinessItem cache_stUniBusinessItem = new UniBusinessItem();
  public LoginInfo stLogin = null;
  public UniBusinessItem stUniBusinessItem = null;
  
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
    Object localObject = this.stLogin;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.stUniBusinessItem;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.GetItemWatchWordReq
 * JD-Core Version:    0.7.0.1
 */