package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_del_icfeed_rsp
  extends JceStruct
{
  public String msg = "";
  public int ret;
  public String verifyurl = "";
  
  public operation_del_icfeed_rsp() {}
  
  public operation_del_icfeed_rsp(int paramInt, String paramString1, String paramString2)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.verifyurl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.verifyurl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.verifyurl != null) {
      paramJceOutputStream.write(this.verifyurl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.operation_del_icfeed_rsp
 * JD-Core Version:    0.7.0.1
 */