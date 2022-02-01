package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHYMakeFriendsCard
  extends JceStruct
{
  static ReqHead cache_stHeader;
  public byte bReqType = 0;
  public long lUIN = 0L;
  public ReqHead stHeader = null;
  public int uFaceTimeStamp = -1;
  
  public ReqHYMakeFriendsCard() {}
  
  public ReqHYMakeFriendsCard(ReqHead paramReqHead, long paramLong, byte paramByte, int paramInt)
  {
    this.stHeader = paramReqHead;
    this.lUIN = paramLong;
    this.bReqType = paramByte;
    this.uFaceTimeStamp = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lUIN = paramJceInputStream.read(this.lUIN, 1, true);
    this.bReqType = paramJceInputStream.read(this.bReqType, 2, true);
    this.uFaceTimeStamp = paramJceInputStream.read(this.uFaceTimeStamp, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lUIN, 1);
    paramJceOutputStream.write(this.bReqType, 2);
    paramJceOutputStream.write(this.uFaceTimeStamp, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.ReqHYMakeFriendsCard
 * JD-Core Version:    0.7.0.1
 */