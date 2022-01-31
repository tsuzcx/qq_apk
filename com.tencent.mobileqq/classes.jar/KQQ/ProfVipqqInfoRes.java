package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ProfVipqqInfoRes
  extends JceStruct
{
  public short wLevel;
  
  public ProfVipqqInfoRes() {}
  
  public ProfVipqqInfoRes(short paramShort)
  {
    this.wLevel = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.wLevel = paramJceInputStream.read(this.wLevel, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wLevel, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     KQQ.ProfVipqqInfoRes
 * JD-Core Version:    0.7.0.1
 */