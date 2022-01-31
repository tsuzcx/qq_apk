package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ProfIncInfoReq
  extends JceStruct
{
  public int iReloadFlag;
  public int iRetIncomPlete;
  public long iUin;
  
  public ProfIncInfoReq() {}
  
  public ProfIncInfoReq(long paramLong, int paramInt1, int paramInt2)
  {
    this.iUin = paramLong;
    this.iRetIncomPlete = paramInt1;
    this.iReloadFlag = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 1, true);
    this.iRetIncomPlete = paramJceInputStream.read(this.iRetIncomPlete, 2, false);
    this.iReloadFlag = paramJceInputStream.read(this.iReloadFlag, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 1);
    paramJceOutputStream.write(this.iRetIncomPlete, 2);
    paramJceOutputStream.write(this.iReloadFlag, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     KQQ.ProfIncInfoReq
 * JD-Core Version:    0.7.0.1
 */