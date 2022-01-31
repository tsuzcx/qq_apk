package NS_COMM_UPLOAD_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CUploadDownstream
  extends JceStruct
{
  static byte[] cache_extra = (byte[])new byte[1];
  public byte[] extra = null;
  public int retcode = 0;
  public String serverID = "";
  
  static
  {
    ((byte[])cache_extra)[0] = 0;
  }
  
  public CUploadDownstream() {}
  
  public CUploadDownstream(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.retcode = paramInt;
    this.serverID = paramString;
    this.extra = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retcode = paramJceInputStream.read(this.retcode, 0, false);
    this.serverID = paramJceInputStream.readString(1, false);
    this.extra = ((byte[])paramJceInputStream.read(cache_extra, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retcode, 0);
    if (this.serverID != null) {
      paramJceOutputStream.write(this.serverID, 1);
    }
    if (this.extra != null) {
      paramJceOutputStream.write(this.extra, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     NS_COMM_UPLOAD_PROTOCOL.CUploadDownstream
 * JD-Core Version:    0.7.0.1
 */