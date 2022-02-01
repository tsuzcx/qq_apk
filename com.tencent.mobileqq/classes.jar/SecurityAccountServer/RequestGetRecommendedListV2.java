package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestGetRecommendedListV2
  extends JceStruct
{
  static byte[] cache_sessionSid;
  static int cache_type;
  public long PopVersion = 0L;
  public long nextFlag = 0L;
  public byte[] sessionSid = null;
  public long timeStamp = 0L;
  public int type = 0;
  
  public RequestGetRecommendedListV2() {}
  
  public RequestGetRecommendedListV2(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt, long paramLong3)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.sessionSid = paramArrayOfByte;
    this.type = paramInt;
    this.PopVersion = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    this.type = paramJceInputStream.read(this.type, 3, false);
    this.PopVersion = paramJceInputStream.read(this.PopVersion, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.type, 3);
    paramJceOutputStream.write(this.PopVersion, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.RequestGetRecommendedListV2
 * JD-Core Version:    0.7.0.1
 */