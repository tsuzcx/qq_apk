package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CKV_LikeInfo
  extends JceStruct
{
  public long iTotal = 0L;
  
  public CKV_LikeInfo() {}
  
  public CKV_LikeInfo(long paramLong)
  {
    this.iTotal = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTotal = paramJceInputStream.read(this.iTotal, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTotal, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.CKV_LikeInfo
 * JD-Core Version:    0.7.0.1
 */