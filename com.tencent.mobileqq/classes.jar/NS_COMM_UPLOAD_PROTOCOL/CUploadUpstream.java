package NS_COMM_UPLOAD_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CUploadUpstream
  extends JceStruct
{
  static int cache_busiType;
  static byte[] cache_extra = (byte[])new byte[1];
  static int cache_fileType;
  public int busiType = 0;
  public byte[] extra = null;
  public int fileType = 0;
  
  static
  {
    ((byte[])cache_extra)[0] = 0;
  }
  
  public CUploadUpstream() {}
  
  public CUploadUpstream(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.busiType = paramInt1;
    this.fileType = paramInt2;
    this.extra = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.busiType = paramJceInputStream.read(this.busiType, 0, false);
    this.fileType = paramJceInputStream.read(this.fileType, 1, false);
    this.extra = ((byte[])paramJceInputStream.read(cache_extra, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.busiType, 0);
    paramJceOutputStream.write(this.fileType, 1);
    byte[] arrayOfByte = this.extra;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_COMM_UPLOAD_PROTOCOL.CUploadUpstream
 * JD-Core Version:    0.7.0.1
 */