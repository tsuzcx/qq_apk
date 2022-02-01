package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserInfo
  extends JceStruct
{
  static byte[] cache_sig;
  public String MobileNick = "";
  public long lMobileUin = 0L;
  public String nickname = "";
  public String sKey = "";
  public byte[] sig = null;
  
  public UserInfo() {}
  
  public UserInfo(String paramString1, long paramLong, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    this.nickname = paramString1;
    this.lMobileUin = paramLong;
    this.sig = paramArrayOfByte;
    this.MobileNick = paramString2;
    this.sKey = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nickname = paramJceInputStream.readString(0, false);
    this.lMobileUin = paramJceInputStream.read(this.lMobileUin, 1, false);
    if (cache_sig == null)
    {
      cache_sig = (byte[])new byte[1];
      ((byte[])cache_sig)[0] = 0;
    }
    this.sig = ((byte[])paramJceInputStream.read(cache_sig, 2, false));
    this.MobileNick = paramJceInputStream.readString(3, false);
    this.sKey = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.nickname;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.lMobileUin, 1);
    localObject = this.sig;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 2);
    }
    localObject = this.MobileNick;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.sKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     AccostSvc.UserInfo
 * JD-Core Version:    0.7.0.1
 */