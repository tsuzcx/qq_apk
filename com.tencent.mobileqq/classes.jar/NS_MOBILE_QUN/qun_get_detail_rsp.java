package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.single_detail;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_get_detail_rsp
  extends JceStruct
{
  static single_detail cache_detail_data;
  public String attach_info = "";
  public single_detail detail_data;
  public int hasmore;
  
  public qun_get_detail_rsp() {}
  
  public qun_get_detail_rsp(single_detail paramsingle_detail, int paramInt, String paramString)
  {
    this.detail_data = paramsingle_detail;
    this.hasmore = paramInt;
    this.attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_detail_data == null) {
      cache_detail_data = new single_detail();
    }
    this.detail_data = ((single_detail)paramJceInputStream.read(cache_detail_data, 0, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.attach_info = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.detail_data != null) {
      paramJceOutputStream.write(this.detail_data, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_detail_rsp
 * JD-Core Version:    0.7.0.1
 */