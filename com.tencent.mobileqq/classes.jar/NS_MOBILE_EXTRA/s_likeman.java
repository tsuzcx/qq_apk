package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_likeman
  extends JceStruct
{
  static s_user cache_user = new s_user();
  public s_user user = null;
  
  public s_likeman() {}
  
  public s_likeman(s_user params_user)
  {
    this.user = params_user;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    s_user locals_user = this.user;
    if (locals_user != null) {
      paramJceOutputStream.write(locals_user, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.s_likeman
 * JD-Core Version:    0.7.0.1
 */