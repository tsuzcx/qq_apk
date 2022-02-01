package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_space_event
  extends JceStruct
{
  public int iAdID = 0;
  public String strEventPic = "";
  public String strEventTxt = "";
  public String strJumpType = "";
  public String strJumpUrl = "";
  public String traceinfo = "";
  
  public s_space_event() {}
  
  public s_space_event(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.strEventPic = paramString1;
    this.strJumpType = paramString2;
    this.strJumpUrl = paramString3;
    this.strEventTxt = paramString4;
    this.traceinfo = paramString5;
    this.iAdID = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strEventPic = paramJceInputStream.readString(0, false);
    this.strJumpType = paramJceInputStream.readString(1, false);
    this.strJumpUrl = paramJceInputStream.readString(2, false);
    this.strEventTxt = paramJceInputStream.readString(3, false);
    this.traceinfo = paramJceInputStream.readString(4, false);
    this.iAdID = paramJceInputStream.read(this.iAdID, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strEventPic;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.strJumpType;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strJumpUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.strEventTxt;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.traceinfo;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.iAdID, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_space_event
 * JD-Core Version:    0.7.0.1
 */