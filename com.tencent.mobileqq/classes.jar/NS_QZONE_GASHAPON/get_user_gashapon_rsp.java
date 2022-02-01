package NS_QZONE_GASHAPON;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class get_user_gashapon_rsp
  extends JceStruct
{
  public int iFrameRate = 0;
  public String strH5Url = "";
  public String strPicUrl = "";
  public String strTextUrl = "";
  public long uiGashaponCount = 0L;
  
  public get_user_gashapon_rsp() {}
  
  public get_user_gashapon_rsp(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    this.strPicUrl = paramString1;
    this.strTextUrl = paramString2;
    this.strH5Url = paramString3;
    this.uiGashaponCount = paramLong;
    this.iFrameRate = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPicUrl = paramJceInputStream.readString(0, false);
    this.strTextUrl = paramJceInputStream.readString(1, false);
    this.strH5Url = paramJceInputStream.readString(2, false);
    this.uiGashaponCount = paramJceInputStream.read(this.uiGashaponCount, 3, false);
    this.iFrameRate = paramJceInputStream.read(this.iFrameRate, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strPicUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.strTextUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strH5Url;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.uiGashaponCount, 3);
    paramJceOutputStream.write(this.iFrameRate, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_GASHAPON.get_user_gashapon_rsp
 * JD-Core Version:    0.7.0.1
 */