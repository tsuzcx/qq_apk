package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetRichSigRes
  extends JceStruct
{
  public byte cResult = -1;
  public long dwTime;
  
  public SetRichSigRes() {}
  
  public SetRichSigRes(byte paramByte, long paramLong)
  {
    this.cResult = paramByte;
    this.dwTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cResult = paramJceInputStream.read(this.cResult, 1, true);
    this.dwTime = paramJceInputStream.read(this.dwTime, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cResult, 1);
    paramJceOutputStream.write(this.dwTime, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     KQQ.SetRichSigRes
 * JD-Core Version:    0.7.0.1
 */