package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniCheckForQzoneReq
  extends JceStruct
{
  static LoginInfo cache_stLogin = new LoginInfo();
  public LoginInfo stLogin = null;
  public String strSuixintieCheckInfo = "";
  
  public UniCheckForQzoneReq() {}
  
  public UniCheckForQzoneReq(LoginInfo paramLoginInfo, String paramString)
  {
    this.stLogin = paramLoginInfo;
    this.strSuixintieCheckInfo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, false));
    this.strSuixintieCheckInfo = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stLogin != null) {
      paramJceOutputStream.write(this.stLogin, 0);
    }
    if (this.strSuixintieCheckInfo != null) {
      paramJceOutputStream.write(this.strSuixintieCheckInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniCheckForQzoneReq
 * JD-Core Version:    0.7.0.1
 */