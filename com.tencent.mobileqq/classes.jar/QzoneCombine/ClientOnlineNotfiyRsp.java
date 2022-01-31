package QzoneCombine;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ClientOnlineNotfiyRsp
  extends JceStruct
{
  static byte[] cache_AttachInfo = (byte[])new byte[1];
  public byte[] AttachInfo;
  
  static
  {
    ((byte[])cache_AttachInfo)[0] = 0;
  }
  
  public ClientOnlineNotfiyRsp() {}
  
  public ClientOnlineNotfiyRsp(byte[] paramArrayOfByte)
  {
    this.AttachInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.AttachInfo = ((byte[])paramJceInputStream.read(cache_AttachInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.AttachInfo != null) {
      paramJceOutputStream.write(this.AttachInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QzoneCombine.ClientOnlineNotfiyRsp
 * JD-Core Version:    0.7.0.1
 */