package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_set_red_key_data_req
  extends JceStruct
{
  public long appid = 0L;
  public String pay_key = "";
  public String ugc_key = "";
  public long uin = 0L;
  
  public mobile_set_red_key_data_req() {}
  
  public mobile_set_red_key_data_req(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    this.uin = paramLong1;
    this.appid = paramLong2;
    this.ugc_key = paramString1;
    this.pay_key = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.appid = paramJceInputStream.read(this.appid, 1, true);
    this.ugc_key = paramJceInputStream.readString(2, true);
    this.pay_key = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.ugc_key, 2);
    paramJceOutputStream.write(this.pay_key, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_set_red_key_data_req
 * JD-Core Version:    0.7.0.1
 */