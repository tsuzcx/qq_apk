package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestBindMobileV2
  extends JceStruct
{
  static byte[] cache_encrptBindMobileInfo = (byte[])new byte[1];
  static int cache_type;
  public byte[] encrptBindMobileInfo = null;
  public boolean isChangeBind = false;
  public boolean isFromChangeBind = false;
  public boolean isFromUni = false;
  public boolean isSecNewReq = false;
  public String mobileNo = "";
  public String nationCode = "";
  public long originBinder = 0L;
  public int type = 0;
  
  static
  {
    ((byte[])cache_encrptBindMobileInfo)[0] = 0;
  }
  
  public RequestBindMobileV2() {}
  
  public RequestBindMobileV2(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte)
  {
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.originBinder = paramLong;
    this.type = paramInt;
    this.isFromUni = paramBoolean1;
    this.isFromChangeBind = paramBoolean2;
    this.isChangeBind = paramBoolean3;
    this.isSecNewReq = paramBoolean4;
    this.encrptBindMobileInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nationCode = paramJceInputStream.readString(0, true);
    this.mobileNo = paramJceInputStream.readString(1, true);
    this.originBinder = paramJceInputStream.read(this.originBinder, 2, false);
    this.type = paramJceInputStream.read(this.type, 3, false);
    this.isFromUni = paramJceInputStream.read(this.isFromUni, 4, false);
    this.isFromChangeBind = paramJceInputStream.read(this.isFromChangeBind, 5, false);
    this.isChangeBind = paramJceInputStream.read(this.isChangeBind, 6, false);
    this.isSecNewReq = paramJceInputStream.read(this.isSecNewReq, 7, false);
    this.encrptBindMobileInfo = ((byte[])paramJceInputStream.read(cache_encrptBindMobileInfo, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nationCode, 0);
    paramJceOutputStream.write(this.mobileNo, 1);
    paramJceOutputStream.write(this.originBinder, 2);
    paramJceOutputStream.write(this.type, 3);
    paramJceOutputStream.write(this.isFromUni, 4);
    paramJceOutputStream.write(this.isFromChangeBind, 5);
    paramJceOutputStream.write(this.isChangeBind, 6);
    paramJceOutputStream.write(this.isSecNewReq, 7);
    byte[] arrayOfByte = this.encrptBindMobileInfo;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.RequestBindMobileV2
 * JD-Core Version:    0.7.0.1
 */