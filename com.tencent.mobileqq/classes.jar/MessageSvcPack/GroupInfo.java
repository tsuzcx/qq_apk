package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupInfo
  extends JceStruct
  implements Cloneable
{
  public long lGroupCode = 0L;
  public long lGroupSeq = 0L;
  public long lMask = 0L;
  public long lMemberSeq = 0L;
  public long lRedPackTime = 0L;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 0, true);
    this.lGroupSeq = paramJceInputStream.read(this.lGroupSeq, 1, true);
    this.lMemberSeq = paramJceInputStream.read(this.lMemberSeq, 2, true);
    this.lMask = paramJceInputStream.read(this.lMask, 3, false);
    this.lRedPackTime = paramJceInputStream.read(this.lRedPackTime, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lGroupCode, 0);
    paramJceOutputStream.write(this.lGroupSeq, 1);
    paramJceOutputStream.write(this.lMemberSeq, 2);
    paramJceOutputStream.write(this.lMask, 3);
    paramJceOutputStream.write(this.lRedPackTime, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.GroupInfo
 * JD-Core Version:    0.7.0.1
 */