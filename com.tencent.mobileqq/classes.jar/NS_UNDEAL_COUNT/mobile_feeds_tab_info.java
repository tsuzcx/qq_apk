package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_feeds_tab_info
  extends JceStruct
{
  public int iTabSwitch;
  public String strTabActionUrl = "";
  public String strTabName = "";
  
  public mobile_feeds_tab_info() {}
  
  public mobile_feeds_tab_info(String paramString1, String paramString2, int paramInt)
  {
    this.strTabName = paramString1;
    this.strTabActionUrl = paramString2;
    this.iTabSwitch = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strTabName = paramJceInputStream.readString(0, false);
    this.strTabActionUrl = paramJceInputStream.readString(1, false);
    this.iTabSwitch = paramJceInputStream.read(this.iTabSwitch, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strTabName != null) {
      paramJceOutputStream.write(this.strTabName, 0);
    }
    if (this.strTabActionUrl != null) {
      paramJceOutputStream.write(this.strTabActionUrl, 1);
    }
    paramJceOutputStream.write(this.iTabSwitch, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_feeds_tab_info
 * JD-Core Version:    0.7.0.1
 */