package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestGroupInfo
  extends JceStruct
{
  public long lGroupCode;
  public long lLastSeqId;
  
  public SvcRequestGroupInfo() {}
  
  public SvcRequestGroupInfo(long paramLong1, long paramLong2)
  {
    this.lGroupCode = paramLong1;
    this.lLastSeqId = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 0, true);
    this.lLastSeqId = paramJceInputStream.read(this.lLastSeqId, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lGroupCode, 0);
    paramJceOutputStream.write(this.lLastSeqId, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestGroupInfo
 * JD-Core Version:    0.7.0.1
 */