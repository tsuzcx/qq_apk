package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DeviceItemDes
  extends JceStruct
{
  static byte[] cache_vecItemDes;
  public byte[] vecItemDes;
  
  public DeviceItemDes() {}
  
  public DeviceItemDes(byte[] paramArrayOfByte)
  {
    this.vecItemDes = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecItemDes == null)
    {
      cache_vecItemDes = (byte[])new byte[1];
      ((byte[])cache_vecItemDes)[0] = 0;
    }
    this.vecItemDes = ((byte[])paramJceInputStream.read(cache_vecItemDes, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecItemDes, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QQService.DeviceItemDes
 * JD-Core Version:    0.7.0.1
 */