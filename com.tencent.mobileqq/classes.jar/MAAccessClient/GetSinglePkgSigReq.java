package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetSinglePkgSigReq
  extends JceStruct
{
  public int marketVer;
  public String pkgName = "";
  public int sysVer;
  public int versionCode;
  
  public GetSinglePkgSigReq() {}
  
  public GetSinglePkgSigReq(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.pkgName = paramString;
    this.versionCode = paramInt1;
    this.sysVer = paramInt2;
    this.marketVer = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pkgName = paramJceInputStream.readString(0, true);
    this.versionCode = paramJceInputStream.read(this.versionCode, 1, true);
    this.sysVer = paramJceInputStream.read(this.sysVer, 2, false);
    this.marketVer = paramJceInputStream.read(this.marketVer, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pkgName, 0);
    paramJceOutputStream.write(this.versionCode, 1);
    paramJceOutputStream.write(this.sysVer, 2);
    paramJceOutputStream.write(this.marketVer, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MAAccessClient.GetSinglePkgSigReq
 * JD-Core Version:    0.7.0.1
 */