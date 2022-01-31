package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_del_friendreq_req
  extends JceStruct
{
  public long fuin;
  
  public mobile_sub_del_friendreq_req() {}
  
  public mobile_sub_del_friendreq_req(long paramLong)
  {
    this.fuin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fuin = paramJceInputStream.read(this.fuin, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fuin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_del_friendreq_req
 * JD-Core Version:    0.7.0.1
 */