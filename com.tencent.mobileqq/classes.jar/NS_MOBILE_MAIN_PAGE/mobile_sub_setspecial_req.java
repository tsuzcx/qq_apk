package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_setspecial_req
  extends JceStruct
{
  static s_special cache_special = new s_special();
  public int action;
  public s_special special;
  
  public mobile_sub_setspecial_req() {}
  
  public mobile_sub_setspecial_req(int paramInt, s_special params_special)
  {
    this.action = paramInt;
    this.special = params_special;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.action = paramJceInputStream.read(this.action, 0, false);
    this.special = ((s_special)paramJceInputStream.read(cache_special, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.action, 0);
    s_special locals_special = this.special;
    if (locals_special != null) {
      paramJceOutputStream.write(locals_special, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_setspecial_req
 * JD-Core Version:    0.7.0.1
 */