package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CustomTrackDeco
  extends JceStruct
{
  static byte[] cache_strExtFields = (byte[])new byte[1];
  public int iAppID = 149;
  public int iItemId = -1;
  public byte[] strExtFields = null;
  
  static
  {
    ((byte[])cache_strExtFields)[0] = 0;
  }
  
  public CustomTrackDeco() {}
  
  public CustomTrackDeco(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.iAppID = paramInt1;
    this.iItemId = paramInt2;
    this.strExtFields = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppID = paramJceInputStream.read(this.iAppID, 0, false);
    this.iItemId = paramJceInputStream.read(this.iItemId, 1, false);
    this.strExtFields = ((byte[])paramJceInputStream.read(cache_strExtFields, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppID, 0);
    paramJceOutputStream.write(this.iItemId, 1);
    byte[] arrayOfByte = this.strExtFields;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.CustomTrackDeco
 * JD-Core Version:    0.7.0.1
 */