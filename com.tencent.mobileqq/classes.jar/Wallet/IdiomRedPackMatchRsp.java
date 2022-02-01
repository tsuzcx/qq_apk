package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IdiomRedPackMatchRsp
  extends JceStruct
{
  static int cache_subchannel;
  public String billno = "";
  public int fromType = 0;
  public long grabUin = 0L;
  public String groupid = "";
  public String hbIdiom = "";
  public String hbIdiomLastPY = "";
  public String hbPoemRule = "";
  public int idiomSeq = 0;
  public int isFinished = 0;
  public long makeUin = 0L;
  public int status = 0;
  public String strErr = "";
  public int subchannel = 0;
  public int timeInterval = 0;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.grabUin = paramJceInputStream.read(this.grabUin, 0, false);
    this.billno = paramJceInputStream.readString(1, false);
    this.makeUin = paramJceInputStream.read(this.makeUin, 2, false);
    this.status = paramJceInputStream.read(this.status, 3, false);
    this.timeInterval = paramJceInputStream.read(this.timeInterval, 4, false);
    this.strErr = paramJceInputStream.readString(5, false);
    this.hbIdiom = paramJceInputStream.readString(6, false);
    this.idiomSeq = paramJceInputStream.read(this.idiomSeq, 7, false);
    this.fromType = paramJceInputStream.read(this.fromType, 8, false);
    this.groupid = paramJceInputStream.readString(9, false);
    this.isFinished = paramJceInputStream.read(this.isFinished, 10, false);
    this.hbIdiomLastPY = paramJceInputStream.readString(11, false);
    this.subchannel = paramJceInputStream.read(this.subchannel, 12, false);
    this.hbPoemRule = paramJceInputStream.readString(13, false);
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
    str = this.hbIdiom;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    paramJceOutputStream.write(this.idiomSeq, 7);
    paramJceOutputStream.write(this.fromType, 8);
    str = this.groupid;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    paramJceOutputStream.write(this.isFinished, 10);
    str = this.hbIdiomLastPY;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    paramJceOutputStream.write(this.subchannel, 12);
    str = this.hbPoemRule;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.IdiomRedPackMatchRsp
 * JD-Core Version:    0.7.0.1
 */