package NS_MOBILE_COMM_CONF;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MobileCommConf
  extends JceStruct
{
  static NewMobileGlobalConf cache_new_mobile_global_conf = new NewMobileGlobalConf();
  static NewMobileUserConf cache_new_mobile_user_conf = new NewMobileUserConf();
  public NewMobileGlobalConf new_mobile_global_conf;
  public NewMobileUserConf new_mobile_user_conf;
  
  public MobileCommConf() {}
  
  public MobileCommConf(NewMobileGlobalConf paramNewMobileGlobalConf, NewMobileUserConf paramNewMobileUserConf)
  {
    this.new_mobile_global_conf = paramNewMobileGlobalConf;
    this.new_mobile_user_conf = paramNewMobileUserConf;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.new_mobile_global_conf = ((NewMobileGlobalConf)paramJceInputStream.read(cache_new_mobile_global_conf, 0, false));
    this.new_mobile_user_conf = ((NewMobileUserConf)paramJceInputStream.read(cache_new_mobile_user_conf, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.new_mobile_global_conf != null) {
      paramJceOutputStream.write(this.new_mobile_global_conf, 0);
    }
    if (this.new_mobile_user_conf != null) {
      paramJceOutputStream.write(this.new_mobile_user_conf, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_COMM_CONF.MobileCommConf
 * JD-Core Version:    0.7.0.1
 */