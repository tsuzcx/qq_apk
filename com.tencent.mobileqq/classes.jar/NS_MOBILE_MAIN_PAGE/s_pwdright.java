package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_pwdright
  extends JceStruct
{
  static s_user cache_data;
  public s_user data;
  
  public s_pwdright() {}
  
  public s_pwdright(s_user params_user)
  {
    this.data = params_user;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_data == null) {
      cache_data = new s_user();
    }
    this.data = ((s_user)paramJceInputStream.read(cache_data, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    s_user locals_user = this.data;
    if (locals_user != null) {
      paramJceOutputStream.write(locals_user, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_pwdright
 * JD-Core Version:    0.7.0.1
 */