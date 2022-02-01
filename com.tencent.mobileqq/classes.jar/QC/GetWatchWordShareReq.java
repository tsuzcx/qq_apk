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
    if (this.stLogin != null) {
      paramJceOutputStream.write(this.stLogin, 0);
    }
    if (this.watchWord != null) {
      paramJceOutputStream.write(this.watchWord, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.GetWatchWordShareReq
 * JD-Core Version:    0.7.0.1
 */