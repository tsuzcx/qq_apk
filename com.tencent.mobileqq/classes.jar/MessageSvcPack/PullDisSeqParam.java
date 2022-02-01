package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PullDisSeqParam
  extends JceStruct
{
  public long lDisCode = 0L;
  public long lLastSeqId = 0L;
  
  public PullDisSeqParam() {}
  
  public PullDisSeqParam(long paramLong1, long paramLong2)
  {
    this.lDisCode = paramLong1;
    this.lLastSeqId = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lDisCode = paramJceInputStream.read(this.lDisCode, 0, true);
    this.lLastSeqId = paramJceInputStream.read(this.lLastSeqId, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lDisCode, 0);
    paramJceOutputStream.write(this.lLastSeqId, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.PullDisSeqParam
 * JD-Core Version:    0.7.0.1
 */