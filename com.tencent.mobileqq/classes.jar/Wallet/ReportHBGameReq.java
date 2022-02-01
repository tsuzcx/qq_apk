package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportHBGameReq
  extends JceStruct
  implements Cloneable
{
  public boolean bStart = false;
  public boolean bSucc = false;
  public int iAmount = 0;
  public int iGameId = 0;
  public long lUin = 0L;
  public String sHBId = "";
  public String sPoint = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sHBId = paramJceInputStream.readString(0, false);
    this.lUin = paramJceInputStream.read(this.lUin, 1, false);
    this.sPoint = paramJceInputStream.readString(2, false);
    this.iAmount = paramJceInputStream.read(this.iAmount, 3, false);
    this.bSucc = paramJceInputStream.read(this.bSucc, 4, false);
    this.bStart = paramJceInputStream.read(this.bStart, 5, false);
    this.iGameId = paramJceInputStream.read(this.iGameId, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sHBId, 0);
    paramJceOutputStream.write(this.lUin, 1);
    paramJceOutputStream.write(this.sPoint, 2);
    paramJceOutputStream.write(this.iAmount, 3);
    paramJceOutputStream.write(this.bSucc, 4);
    paramJceOutputStream.write(this.bStart, 5);
    paramJceOutputStream.write(this.iGameId, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.ReportHBGameReq
 * JD-Core Version:    0.7.0.1
 */