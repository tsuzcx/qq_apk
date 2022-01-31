package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ResponeUpdateAddressBook
  extends JceStruct
{
  static byte[] cache_sessionSid;
  public long nextFlag;
  public byte[] sessionSid;
  
  public ResponeUpdateAddressBook() {}
  
  public ResponeUpdateAddressBook(long paramLong, byte[] paramArrayOfByte)
  {
    this.nextFlag = paramLong;
    this.sessionSid = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.sessionSid, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.ResponeUpdateAddressBook
 * JD-Core Version:    0.7.0.1
 */