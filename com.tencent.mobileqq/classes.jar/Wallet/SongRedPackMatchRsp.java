package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SongRedPackMatchRsp
  extends JceStruct
{
  public String billno = "";
  public String degree = "";
  public long grabUin = 0L;
  public long makeUin = 0L;
  public int status = 0;
  public String strErr = "";
  public int timeInterval = 0;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.grabUin = paramJceInputStream.read(this.grabUin, 0, false);
    this.billno = paramJceInputStream.readString(1, false);
    this.makeUin = paramJceInputStream.read(this.makeUin, 2, false);
    this.status = paramJceInputStream.read(this.status, 3, false);
    this.timeInterval = paramJceInputStream.read(this.timeInterval, 4, false);
    this.strErr = paramJceInputStream.readString(5, false);
    this.degree = paramJceInputStream.readString(6, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SongRedPackMatchRsp{grabUin=");
    localStringBuilder.append(this.grabUin);
    localStringBuilder.append(", billno='");
    localStringBuilder.append(this.billno);
    localStringBuilder.append('\'');
    localStringBuilder.append(", makeUin=");
    localStringBuilder.append(this.makeUin);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", timeInterval=");
    localStringBuilder.append(this.timeInterval);
    localStringBuilder.append(", strErr='");
    localStringBuilder.append(this.strErr);
    localStringBuilder.append('\'');
    localStringBuilder.append(", degree='");
    localStringBuilder.append(this.degree);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.grabUin, 0);
    String str = this.billno;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.makeUin, 2);
    paramJceOutputStream.write(this.status, 3);
    paramJceOutputStream.write(this.timeInterval, 4);
    str = this.strErr;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.degree;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.SongRedPackMatchRsp
 * JD-Core Version:    0.7.0.1
 */