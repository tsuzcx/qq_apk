package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetUsrKeyWordInfoReq
  extends JceStruct
{
  public long uGroupNum = 0L;
  
  public GetUsrKeyWordInfoReq() {}
  
  public GetUsrKeyWordInfoReq(long paramLong)
  {
    this.uGroupNum = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uGroupNum = paramJceInputStream.read(this.uGroupNum, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uGroupNum, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.GetUsrKeyWordInfoReq
 * JD-Core Version:    0.7.0.1
 */