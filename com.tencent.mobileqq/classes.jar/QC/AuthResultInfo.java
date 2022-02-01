package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AuthResultInfo
  extends JceStruct
{
  public String authmsg = "";
  public int authret = 0;
  public String authurl = "";
  
  public AuthResultInfo() {}
  
  public AuthResultInfo(int paramInt, String paramString1, String paramString2)
  {
    this.authret = paramInt;
    this.authmsg = paramString1;
    this.authurl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.authret = paramJceInputStream.read(this.authret, 0, false);
    this.authmsg = paramJceInputStream.readString(1, false);
    this.authurl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.authret, 0);
    String str = this.authmsg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.authurl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.AuthResultInfo
 * JD-Core Version:    0.7.0.1
 */