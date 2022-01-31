package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DelVideoSummary
  extends JceStruct
{
  public String msg = "";
  public int ret;
  public String vid = "";
  
  public DelVideoSummary() {}
  
  public DelVideoSummary(String paramString1, int paramInt, String paramString2)
  {
    this.vid = paramString1;
    this.ret = paramInt;
    this.msg = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vid = paramJceInputStream.readString(0, false);
    this.ret = paramJceInputStream.read(this.ret, 1, false);
    this.msg = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vid != null) {
      paramJceOutputStream.write(this.vid, 0);
    }
    paramJceOutputStream.write(this.ret, 1);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_VIDEO.DelVideoSummary
 * JD-Core Version:    0.7.0.1
 */