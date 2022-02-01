package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestQueryQQMobileContactsNotBind
  extends JceStruct
{
  static byte[] cache_sessionSid = (byte[])new byte[1];
  public boolean Compressd = false;
  public String MobileUniqueNo = "";
  public long nextFlag = 0L;
  public byte[] sessionSid = null;
  public long timeStamp = 0L;
  
  static
  {
    ((byte[])cache_sessionSid)[0] = 0;
  }
  
  public RequestQueryQQMobileContactsNotBind() {}
  
  public RequestQueryQQMobileContactsNotBind(long paramLong1, byte[] paramArrayOfByte, boolean paramBoolean, String paramString, long paramLong2)
  {
    this.nextFlag = paramLong1;
    this.sessionSid = paramArrayOfByte;
    this.Compressd = paramBoolean;
    this.MobileUniqueNo = paramString;
    this.timeStamp = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 1, true));
    this.Compressd = paramJceInputStream.read(this.Compressd, 2, false);
    this.MobileUniqueNo = paramJceInputStream.readString(3, false);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.sessionSid, 1);
    paramJceOutputStream.write(this.Compressd, 2);
    if (this.MobileUniqueNo != null) {
      paramJceOutputStream.write(this.MobileUniqueNo, 3);
    }
    paramJceOutputStream.write(this.timeStamp, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestQueryQQMobileContactsNotBind
 * JD-Core Version:    0.7.0.1
 */