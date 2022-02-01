package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BroadCastInfo
  extends JceStruct
{
  static int cache_subchannel;
  public String billno = "";
  public String hbIdiom = "";
  public String hbIdiomLastPY = "";
  public String hbPoemRule = "";
  public int idiomSeq = 0;
  public long idiomUin = 0L;
  public int isFinished = 0;
  public int subchannel = 0;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hbIdiom = paramJceInputStream.readString(0, false);
    this.idiomSeq = paramJceInputStream.read(this.idiomSeq, 1, false);
    this.billno = paramJceInputStream.readString(2, false);
    this.idiomUin = paramJceInputStream.read(this.idiomUin, 3, false);
    this.isFinished = paramJceInputStream.read(this.isFinished, 4, false);
    this.hbIdiomLastPY = paramJceInputStream.readString(5, false);
    this.subchannel = paramJceInputStream.read(this.subchannel, 6, false);
    this.hbPoemRule = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.hbIdiom;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.idiomSeq, 1);
    str = this.billno;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.idiomUin, 3);
    paramJceOutputStream.write(this.isFinished, 4);
    str = this.hbIdiomLastPY;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.subchannel, 6);
    str = this.hbPoemRule;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.BroadCastInfo
 * JD-Core Version:    0.7.0.1
 */