package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ResInfo
  extends JceStruct
{
  public boolean bDownload;
  public int iResId;
  public int iSize;
  public int iVersion;
  public String sResId = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iResId = paramJceInputStream.read(this.iResId, 0, false);
    this.iSize = paramJceInputStream.read(this.iSize, 1, false);
    this.iVersion = paramJceInputStream.read(this.iVersion, 2, false);
    this.bDownload = paramJceInputStream.read(this.bDownload, 3, false);
    this.sResId = paramJceInputStream.readString(4, false);
  }
  
  public String toString()
  {
    return "ResInfo{iResId=" + this.iResId + ", iSize='" + this.iSize + ", sResId='" + this.sResId + '\'' + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResId, 0);
    paramJceOutputStream.write(this.iSize, 1);
    paramJceOutputStream.write(this.iVersion, 2);
    paramJceOutputStream.write(this.bDownload, 3);
    if (this.sResId != null) {
      paramJceOutputStream.write(this.sResId, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     Wallet.ResInfo
 * JD-Core Version:    0.7.0.1
 */