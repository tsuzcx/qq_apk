package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestGetRecommendedList
  extends JceStruct
{
  static byte[] cache_sessionSid = (byte[])new byte[1];
  static int cache_type = 0;
  public long PopVersion = 0L;
  public long nextFlag = 0L;
  public byte[] sessionSid = null;
  public long timeStamp = 0L;
  public int type = 0;
  public byte version = 0;
  
  static
  {
    ((byte[])cache_sessionSid)[0] = 0;
  }
  
  public RequestGetRecommendedList() {}
  
  public RequestGetRecommendedList(long paramLong1, long paramLong2, byte[] paramArrayOfByte, byte paramByte, int paramInt, long paramLong3)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.sessionSid = paramArrayOfByte;
    this.version = paramByte;
    this.type = paramInt;
    this.PopVersion = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    this.version = paramJceInputStream.read(this.version, 3, false);
    this.type = paramJceInputStream.read(this.type, 4, false);
    this.PopVersion = paramJceInputStream.read(this.PopVersion, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.version, 3);
    paramJceOutputStream.write(this.type, 4);
    paramJceOutputStream.write(this.PopVersion, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestGetRecommendedList
 * JD-Core Version:    0.7.0.1
 */