package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_detail_actshuoshuo_req
  extends JceStruct
{
  public String act_id = "";
  public String busi_param = "";
  
  public mobile_detail_actshuoshuo_req() {}
  
  public mobile_detail_actshuoshuo_req(String paramString1, String paramString2)
  {
    this.act_id = paramString1;
    this.busi_param = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.act_id = paramJceInputStream.readString(0, false);
    this.busi_param = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.act_id;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.busi_param;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_detail_actshuoshuo_req
 * JD-Core Version:    0.7.0.1
 */