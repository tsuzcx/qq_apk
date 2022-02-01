package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CheckSinglePkgSigReq
  extends JceStruct
{
  public int marketVer = 0;
  public String pkgName = "";
  public String pkgSig = "";
  public int sysVer = 0;
  public int versionCode = 0;
  
  public CheckSinglePkgSigReq() {}
  
  public CheckSinglePkgSigReq(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.pkgName = paramString1;
    this.pkgSig = paramString2;
    this.versionCode = paramInt1;
    this.sysVer = paramInt2;
    this.marketVer = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pkgName = paramJceInputStream.readString(0, true);
    this.pkgSig = paramJceInputStream.readString(1, true);
    this.versionCode = paramJceInputStream.read(this.versionCode, 2, true);
    this.sysVer = paramJceInputStream.read(this.sysVer, 3, false);
    this.marketVer = paramJceInputStream.read(this.marketVer, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pkgName, 0);
    paramJceOutputStream.write(this.pkgSig, 1);
    paramJceOutputStream.write(this.versionCode, 2);
    paramJceOutputStream.write(this.sysVer, 3);
    paramJceOutputStream.write(this.marketVer, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MAAccessClient.CheckSinglePkgSigReq
 * JD-Core Version:    0.7.0.1
 */