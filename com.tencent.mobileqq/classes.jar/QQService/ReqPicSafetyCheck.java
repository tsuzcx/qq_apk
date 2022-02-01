package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqPicSafetyCheck
  extends JceStruct
{
  static ReqHead cache_stHeader;
  public int iScene = 0;
  public long lToUIN = 0L;
  public ReqHead stHeader = null;
  
  public ReqPicSafetyCheck() {}
  
  public ReqPicSafetyCheck(ReqHead paramReqHead, long paramLong, int paramInt)
  {
    this.stHeader = paramReqHead;
    this.lToUIN = paramLong;
    this.iScene = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 1, true);
    this.iScene = paramJceInputStream.read(this.iScene, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lToUIN, 1);
    paramJceOutputStream.write(this.iScene, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.ReqPicSafetyCheck
 * JD-Core Version:    0.7.0.1
 */