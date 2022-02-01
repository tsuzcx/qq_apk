package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqDeleteVisitorRecord
  extends JceStruct
{
  static int cache_cRecordType = 0;
  static ReqHead cache_stHeader = new ReqHead();
  public int cRecordType = 0;
  public long lTargetUin = 0L;
  public ReqHead stHeader = null;
  
  public ReqDeleteVisitorRecord() {}
  
  public ReqDeleteVisitorRecord(ReqHead paramReqHead, long paramLong, int paramInt)
  {
    this.stHeader = paramReqHead;
    this.lTargetUin = paramLong;
    this.cRecordType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lTargetUin = paramJceInputStream.read(this.lTargetUin, 1, false);
    this.cRecordType = paramJceInputStream.read(this.cRecordType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lTargetUin, 1);
    paramJceOutputStream.write(this.cRecordType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.ReqDeleteVisitorRecord
 * JD-Core Version:    0.7.0.1
 */