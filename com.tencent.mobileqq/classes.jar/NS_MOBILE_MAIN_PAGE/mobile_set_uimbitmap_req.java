package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_set_uimbitmap_req
  extends JceStruct
{
  public boolean switch_flag = true;
  public long uin;
  
  public mobile_set_uimbitmap_req() {}
  
  public mobile_set_uimbitmap_req(long paramLong, boolean paramBoolean)
  {
    this.uin = paramLong;
    this.switch_flag = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.switch_flag = paramJceInputStream.read(this.switch_flag, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.switch_flag, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_set_uimbitmap_req
 * JD-Core Version:    0.7.0.1
 */