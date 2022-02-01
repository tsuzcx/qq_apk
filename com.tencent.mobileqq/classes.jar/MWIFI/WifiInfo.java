package MWIFI;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WifiInfo
  extends JceStruct
{
  public String bssid = "";
  public int hasPwd = 1;
  public boolean haveLocalConf = false;
  public int safeType = 0;
  public String ssid = "";
  
  public JceStruct newInit()
  {
    return new WifiInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ssid = paramJceInputStream.readString(0, false);
    this.bssid = paramJceInputStream.readString(1, false);
    this.hasPwd = paramJceInputStream.read(this.hasPwd, 2, false);
    this.safeType = paramJceInputStream.read(this.safeType, 3, false);
    this.haveLocalConf = paramJceInputStream.read(this.haveLocalConf, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.ssid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.bssid;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    int i = this.hasPwd;
    if (i != 1) {
      paramJceOutputStream.write(i, 2);
    }
    i = this.safeType;
    if (i != 0) {
      paramJceOutputStream.write(i, 3);
    }
    paramJceOutputStream.write(this.haveLocalConf, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MWIFI.WifiInfo
 * JD-Core Version:    0.7.0.1
 */