package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_pwdright_req
  extends JceStruct
{
  static s_pwdright cache_pwdright;
  public s_pwdright pwdright;
  public long uin;
  
  public mobile_sub_pwdright_req() {}
  
  public mobile_sub_pwdright_req(long paramLong, s_pwdright params_pwdright)
  {
    this.uin = paramLong;
    this.pwdright = params_pwdright;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    if (cache_pwdright == null) {
      cache_pwdright = new s_pwdright();
    }
    this.pwdright = ((s_pwdright)paramJceInputStream.read(cache_pwdright, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.pwdright != null) {
      paramJceOutputStream.write(this.pwdright, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_pwdright_req
 * JD-Core Version:    0.7.0.1
 */