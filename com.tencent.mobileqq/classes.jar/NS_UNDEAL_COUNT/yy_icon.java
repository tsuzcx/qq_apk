package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class yy_icon
  extends JceStruct
{
  public int iEntranceId;
  public String sIconName = "";
  public String sIconTraceInfo = "";
  public String sIconUrl = "";
  
  public yy_icon() {}
  
  public yy_icon(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.iEntranceId = paramInt;
    this.sIconUrl = paramString1;
    this.sIconName = paramString2;
    this.sIconTraceInfo = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iEntranceId = paramJceInputStream.read(this.iEntranceId, 0, false);
    this.sIconUrl = paramJceInputStream.readString(1, false);
    this.sIconName = paramJceInputStream.readString(2, false);
    this.sIconTraceInfo = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iEntranceId, 0);
    String str = this.sIconUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.sIconName;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.sIconTraceInfo;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.yy_icon
 * JD-Core Version:    0.7.0.1
 */