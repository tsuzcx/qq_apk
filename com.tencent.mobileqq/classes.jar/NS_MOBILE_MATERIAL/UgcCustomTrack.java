package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UgcCustomTrack
  extends JceStruct
{
  static byte[] cache_strExtFields = (byte[])new byte[1];
  public int iItemId = -1;
  public byte[] strExtFields = null;
  
  static
  {
    ((byte[])cache_strExtFields)[0] = 0;
  }
  
  public UgcCustomTrack() {}
  
  public UgcCustomTrack(int paramInt, byte[] paramArrayOfByte)
  {
    this.iItemId = paramInt;
    this.strExtFields = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.strExtFields = ((byte[])paramJceInputStream.read(cache_strExtFields, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    byte[] arrayOfByte = this.strExtFields;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.UgcCustomTrack
 * JD-Core Version:    0.7.0.1
 */