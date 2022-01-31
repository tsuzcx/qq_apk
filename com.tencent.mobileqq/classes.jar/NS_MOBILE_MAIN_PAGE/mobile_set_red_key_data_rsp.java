package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_set_red_key_data_rsp
  extends JceStruct
{
  public int rsp_code;
  public String rsp_msg = "";
  
  public mobile_set_red_key_data_rsp() {}
  
  public mobile_set_red_key_data_rsp(int paramInt, String paramString)
  {
    this.rsp_code = paramInt;
    this.rsp_msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rsp_code = paramJceInputStream.read(this.rsp_code, 0, true);
    this.rsp_msg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rsp_code, 0);
    if (this.rsp_msg != null) {
      paramJceOutputStream.write(this.rsp_msg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_set_red_key_data_rsp
 * JD-Core Version:    0.7.0.1
 */