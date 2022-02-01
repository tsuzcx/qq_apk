package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetWatchWordShareReq
  extends JceStruct
{
  static LoginInfo cache_stLogin = new LoginInfo();
  public LoginInfo stLogin = null;
  public String watchWord = "";
  
  public GetWatchWordShareReq() {}
  
  public GetWatchWordShareReq(LoginInfo paramLoginInfo, String paramString)
  {
    this.stLogin = paramLoginInfo;
    this.watchWord = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, false));
    this.watchWord = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stLogin;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.watchWord;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.GetWatchWordShareReq
 * JD-Core Version:    0.7.0.1
 */