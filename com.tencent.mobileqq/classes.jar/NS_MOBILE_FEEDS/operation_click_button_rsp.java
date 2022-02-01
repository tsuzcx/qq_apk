package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_click_button_rsp
  extends JceStruct
{
  public int iRet = 0;
  public String strButtonText = "";
  public String strJumpUrl = "";
  public String strToastText = "";
  
  public operation_click_button_rsp() {}
  
  public operation_click_button_rsp(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.iRet = paramInt;
    this.strButtonText = paramString1;
    this.strJumpUrl = paramString2;
    this.strToastText = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, false);
    this.strButtonText = paramJceInputStream.readString(1, false);
    this.strJumpUrl = paramJceInputStream.readString(2, false);
    this.strToastText = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    String str = this.strButtonText;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strJumpUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.strToastText;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.operation_click_button_rsp
 * JD-Core Version:    0.7.0.1
 */