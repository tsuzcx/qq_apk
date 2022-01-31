package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ResponeBindMobileV2
  extends JceStruct
{
  static byte[] cache_sessionSid = (byte[])new byte[1];
  public String alreadyBindedUin = "";
  public boolean bindSuccess;
  public byte[] sessionSid;
  
  static
  {
    ((byte[])cache_sessionSid)[0] = 0;
  }
  
  public ResponeBindMobileV2() {}
  
  public ResponeBindMobileV2(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    this.sessionSid = paramArrayOfByte;
    this.alreadyBindedUin = paramString;
    this.bindSuccess = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 0, true));
    this.alreadyBindedUin = paramJceInputStream.readString(1, false);
    this.bindSuccess = paramJceInputStream.read(this.bindSuccess, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sessionSid, 0);
    if (this.alreadyBindedUin != null) {
      paramJceOutputStream.write(this.alreadyBindedUin, 1);
    }
    paramJceOutputStream.write(this.bindSuccess, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.ResponeBindMobileV2
 * JD-Core Version:    0.7.0.1
 */