package GROUP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MessageRemindReq
  extends JceStruct
{
  public long dwAppId = 0L;
  public long iGroupCode = 0L;
  public String sKey = "";
  public String sKeyType = "";
  public long uOwnerUin = 0L;
  
  public MessageRemindReq() {}
  
  public MessageRemindReq(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2)
  {
    this.iGroupCode = paramLong1;
    this.uOwnerUin = paramLong2;
    this.dwAppId = paramLong3;
    this.sKey = paramString1;
    this.sKeyType = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iGroupCode = paramJceInputStream.read(this.iGroupCode, 0, true);
    this.uOwnerUin = paramJceInputStream.read(this.uOwnerUin, 1, true);
    this.dwAppId = paramJceInputStream.read(this.dwAppId, 2, true);
    this.sKey = paramJceInputStream.readString(3, true);
    this.sKeyType = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iGroupCode, 0);
    paramJceOutputStream.write(this.uOwnerUin, 1);
    paramJceOutputStream.write(this.dwAppId, 2);
    paramJceOutputStream.write(this.sKey, 3);
    if (this.sKeyType != null) {
      paramJceOutputStream.write(this.sKeyType, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     GROUP.MessageRemindReq
 * JD-Core Version:    0.7.0.1
 */