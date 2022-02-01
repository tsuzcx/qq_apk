package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class NoCheckMarket
  extends JceStruct
{
  public String pkgName = "";
  public String signatureMd5 = "";
  public int versionCode = 0;
  
  public NoCheckMarket() {}
  
  public NoCheckMarket(String paramString1, String paramString2, int paramInt)
  {
    this.pkgName = paramString1;
    this.signatureMd5 = paramString2;
    this.versionCode = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pkgName = paramJceInputStream.readString(0, false);
    this.signatureMd5 = paramJceInputStream.readString(1, false);
    this.versionCode = paramJceInputStream.read(this.versionCode, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.pkgName;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.signatureMd5;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.versionCode, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MAAccessClient.NoCheckMarket
 * JD-Core Version:    0.7.0.1
 */