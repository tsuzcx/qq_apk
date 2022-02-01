package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_video_adapter_rsp
  extends JceStruct
{
  public int iType;
  public String strData = "";
  public String strOrgUrl = "";
  
  public mobile_video_adapter_rsp() {}
  
  public mobile_video_adapter_rsp(int paramInt, String paramString1, String paramString2)
  {
    this.iType = paramInt;
    this.strData = paramString1;
    this.strOrgUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, false);
    this.strData = paramJceInputStream.readString(1, false);
    this.strOrgUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    String str = this.strData;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strOrgUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.mobile_video_adapter_rsp
 * JD-Core Version:    0.7.0.1
 */