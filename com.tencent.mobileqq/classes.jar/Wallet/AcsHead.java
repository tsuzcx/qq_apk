package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsHead
  extends JceStruct
{
  public String model = "";
  public String platform = "";
  public String version = "";
  
  public AcsHead() {}
  
  public AcsHead(String paramString1, String paramString2, String paramString3)
  {
    this.version = paramString1;
    this.platform = paramString2;
    this.model = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.version = paramJceInputStream.readString(0, false);
    this.platform = paramJceInputStream.readString(1, false);
    this.model = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.version;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.platform;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.model;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AcsHead
 * JD-Core Version:    0.7.0.1
 */