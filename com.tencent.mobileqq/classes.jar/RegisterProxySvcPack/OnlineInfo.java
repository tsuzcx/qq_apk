package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class OnlineInfo
  extends JceStruct
{
  static byte[] cache_subPlatform = (byte[])new byte[1];
  public int clientType;
  public int instanceId;
  public int onlineStatus;
  public int platformId;
  public byte[] subPlatform;
  
  static
  {
    ((byte[])cache_subPlatform)[0] = 0;
  }
  
  public OnlineInfo() {}
  
  public OnlineInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    this.instanceId = paramInt1;
    this.clientType = paramInt2;
    this.onlineStatus = paramInt3;
    this.platformId = paramInt4;
    this.subPlatform = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.instanceId = paramJceInputStream.read(this.instanceId, 0, false);
    this.clientType = paramJceInputStream.read(this.clientType, 1, false);
    this.onlineStatus = paramJceInputStream.read(this.onlineStatus, 2, false);
    this.platformId = paramJceInputStream.read(this.platformId, 3, false);
    this.subPlatform = ((byte[])paramJceInputStream.read(cache_subPlatform, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.instanceId, 0);
    paramJceOutputStream.write(this.clientType, 1);
    paramJceOutputStream.write(this.onlineStatus, 2);
    paramJceOutputStream.write(this.platformId, 3);
    if (this.subPlatform != null) {
      paramJceOutputStream.write(this.subPlatform, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     RegisterProxySvcPack.OnlineInfo
 * JD-Core Version:    0.7.0.1
 */