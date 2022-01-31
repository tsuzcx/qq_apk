package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_host_hb_info_req
  extends JceStruct
{
  public String ext_info = "";
  public long huin;
  
  public mobile_host_hb_info_req() {}
  
  public mobile_host_hb_info_req(long paramLong, String paramString)
  {
    this.huin = paramLong;
    this.ext_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.huin = paramJceInputStream.read(this.huin, 0, true);
    this.ext_info = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.huin, 0);
    if (this.ext_info != null) {
      paramJceOutputStream.write(this.ext_info, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_host_hb_info_req
 * JD-Core Version:    0.7.0.1
 */