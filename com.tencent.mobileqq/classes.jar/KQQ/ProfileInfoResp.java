package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ProfileInfoResp
  extends JceStruct
{
  static byte[] cache_vecValue;
  public byte cOper;
  public byte cType;
  public long dwTimeStamp;
  public String strKey = "";
  public byte[] vecValue;
  
  public ProfileInfoResp() {}
  
  public ProfileInfoResp(byte paramByte1, byte paramByte2, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.cOper = paramByte1;
    this.cType = paramByte2;
    this.strKey = paramString;
    this.dwTimeStamp = paramLong;
    this.vecValue = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cOper = paramJceInputStream.read(this.cOper, 0, true);
    this.cType = paramJceInputStream.read(this.cType, 1, true);
    this.strKey = paramJceInputStream.readString(2, true);
    this.dwTimeStamp = paramJceInputStream.read(this.dwTimeStamp, 3, true);
    if (cache_vecValue == null)
    {
      cache_vecValue = (byte[])new byte[1];
      ((byte[])cache_vecValue)[0] = 0;
    }
    this.vecValue = ((byte[])paramJceInputStream.read(cache_vecValue, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cOper, 0);
    paramJceOutputStream.write(this.cType, 1);
    paramJceOutputStream.write(this.strKey, 2);
    paramJceOutputStream.write(this.dwTimeStamp, 3);
    paramJceOutputStream.write(this.vecValue, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     KQQ.ProfileInfoResp
 * JD-Core Version:    0.7.0.1
 */