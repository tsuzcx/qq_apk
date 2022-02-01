package PUSHAPI;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PushRsp
  extends JceStruct
{
  static byte[] cache_UID = (byte[])new byte[1];
  public String Mark = "";
  public byte[] UID;
  public long flag;
  public byte is_bgd;
  public long ptime;
  public String sUID = "";
  
  static
  {
    ((byte[])cache_UID)[0] = 0;
  }
  
  public PushRsp() {}
  
  public PushRsp(byte[] paramArrayOfByte, long paramLong1, String paramString1, byte paramByte, String paramString2, long paramLong2)
  {
    this.UID = paramArrayOfByte;
    this.ptime = paramLong1;
    this.Mark = paramString1;
    this.is_bgd = paramByte;
    this.sUID = paramString2;
    this.flag = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.UID = ((byte[])paramJceInputStream.read(cache_UID, 0, false));
    this.ptime = paramJceInputStream.read(this.ptime, 1, false);
    this.Mark = paramJceInputStream.readString(3, false);
    this.is_bgd = paramJceInputStream.read(this.is_bgd, 4, false);
    this.sUID = paramJceInputStream.readString(5, false);
    this.flag = paramJceInputStream.read(this.flag, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.UID;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 0);
    }
    paramJceOutputStream.write(this.ptime, 1);
    localObject = this.Mark;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.is_bgd, 4);
    localObject = this.sUID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.flag, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     PUSHAPI.PushRsp
 * JD-Core Version:    0.7.0.1
 */