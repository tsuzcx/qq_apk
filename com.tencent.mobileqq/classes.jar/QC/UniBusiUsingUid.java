package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiUsingUid
  extends JceStruct
{
  public int locationtype = 0;
  public long uid = 0L;
  
  public UniBusiUsingUid() {}
  
  public UniBusiUsingUid(long paramLong, int paramInt)
  {
    this.uid = paramLong;
    this.locationtype = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uid = paramJceInputStream.read(this.uid, 0, false);
    this.locationtype = paramJceInputStream.read(this.locationtype, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uid, 0);
    paramJceOutputStream.write(this.locationtype, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusiUsingUid
 * JD-Core Version:    0.7.0.1
 */