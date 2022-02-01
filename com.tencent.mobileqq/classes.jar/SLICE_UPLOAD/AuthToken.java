package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AuthToken
  extends JceStruct
{
  static byte[] cache_data = (byte[])new byte[1];
  static byte[] cache_ext_key;
  static int cache_type;
  public int appid = 0;
  public byte[] data = null;
  public byte[] ext_key = null;
  public int type = 0;
  public long wt_appid = 0L;
  
  static
  {
    ((byte[])cache_data)[0] = 0;
    cache_ext_key = (byte[])new byte[1];
    ((byte[])cache_ext_key)[0] = 0;
  }
  
  public AuthToken() {}
  
  public AuthToken(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, long paramLong)
  {
    this.type = paramInt1;
    this.data = paramArrayOfByte1;
    this.ext_key = paramArrayOfByte2;
    this.appid = paramInt2;
    this.wt_appid = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.data = ((byte[])paramJceInputStream.read(cache_data, 1, true));
    this.ext_key = ((byte[])paramJceInputStream.read(cache_ext_key, 2, true));
    this.appid = paramJceInputStream.read(this.appid, 3, true);
    this.wt_appid = paramJceInputStream.read(this.wt_appid, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.data, 1);
    paramJceOutputStream.write(this.ext_key, 2);
    paramJceOutputStream.write(this.appid, 3);
    paramJceOutputStream.write(this.wt_appid, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SLICE_UPLOAD.AuthToken
 * JD-Core Version:    0.7.0.1
 */