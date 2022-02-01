package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestVerifySmscode
  extends JceStruct
{
  static byte[] cache_sessionSid;
  static int cache_type;
  public boolean isFromChangeBind = false;
  public boolean isFromUni = false;
  public byte[] sessionSid = null;
  public String smsCode = "";
  public int type = 0;
  
  public RequestVerifySmscode() {}
  
  public RequestVerifySmscode(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.smsCode = paramString;
    this.sessionSid = paramArrayOfByte;
    this.type = paramInt;
    this.isFromUni = paramBoolean1;
    this.isFromChangeBind = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.smsCode = paramJceInputStream.readString(0, true);
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 1, true));
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.isFromUni = paramJceInputStream.read(this.isFromUni, 3, false);
    this.isFromChangeBind = paramJceInputStream.read(this.isFromChangeBind, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.smsCode, 0);
    paramJceOutputStream.write(this.sessionSid, 1);
    paramJceOutputStream.write(this.type, 2);
    paramJceOutputStream.write(this.isFromUni, 3);
    paramJceOutputStream.write(this.isFromChangeBind, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestVerifySmscode
 * JD-Core Version:    0.7.0.1
 */