package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_ss_recom_pic_report_req
  extends JceStruct
{
  public byte op = 0;
  public long uin = 0L;
  
  public mobile_ss_recom_pic_report_req() {}
  
  public mobile_ss_recom_pic_report_req(long paramLong, byte paramByte)
  {
    this.uin = paramLong;
    this.op = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.op = paramJceInputStream.read(this.op, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.op, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.mobile_ss_recom_pic_report_req
 * JD-Core Version:    0.7.0.1
 */