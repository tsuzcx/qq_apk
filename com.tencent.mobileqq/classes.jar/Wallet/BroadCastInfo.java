package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BroadCastInfo
  extends JceStruct
{
  public String billno = "";
  public String hbIdiom = "";
  public String hbIdiomLastPY = "";
  public int idiomSeq;
  public long idiomUin;
  public int isFinished;
  
  public BroadCastInfo() {}
  
  public BroadCastInfo(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3)
  {
    this.hbIdiom = paramString1;
    this.idiomSeq = paramInt1;
    this.billno = paramString2;
    this.idiomUin = paramLong;
    this.isFinished = paramInt2;
    this.hbIdiomLastPY = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hbIdiom = paramJceInputStream.readString(0, false);
    this.idiomSeq = paramJceInputStream.read(this.idiomSeq, 1, false);
    this.billno = paramJceInputStream.readString(2, false);
    this.idiomUin = paramJceInputStream.read(this.idiomUin, 3, false);
    this.isFinished = paramJceInputStream.read(this.isFinished, 4, false);
    this.hbIdiomLastPY = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.hbIdiom != null) {
      paramJceOutputStream.write(this.hbIdiom, 0);
    }
    paramJceOutputStream.write(this.idiomSeq, 1);
    if (this.billno != null) {
      paramJceOutputStream.write(this.billno, 2);
    }
    paramJceOutputStream.write(this.idiomUin, 3);
    paramJceOutputStream.write(this.isFinished, 4);
    if (this.hbIdiomLastPY != null) {
      paramJceOutputStream.write(this.hbIdiomLastPY, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.BroadCastInfo
 * JD-Core Version:    0.7.0.1
 */