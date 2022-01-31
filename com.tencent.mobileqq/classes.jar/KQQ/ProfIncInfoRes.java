package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ProfIncInfoRes
  extends JceStruct
{
  public int uOnlineTime;
  public int uRemainTime;
  public short wLevel;
  
  public ProfIncInfoRes() {}
  
  public ProfIncInfoRes(short paramShort, int paramInt1, int paramInt2)
  {
    this.wLevel = paramShort;
    this.uOnlineTime = paramInt1;
    this.uRemainTime = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.wLevel = paramJceInputStream.read(this.wLevel, 1, true);
    this.uOnlineTime = paramJceInputStream.read(this.uOnlineTime, 2, true);
    this.uRemainTime = paramJceInputStream.read(this.uRemainTime, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wLevel, 1);
    paramJceOutputStream.write(this.uOnlineTime, 2);
    paramJceOutputStream.write(this.uRemainTime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.ProfIncInfoRes
 * JD-Core Version:    0.7.0.1
 */