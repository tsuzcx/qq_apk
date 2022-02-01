package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRespPushMsg
  extends JceStruct
{
  static byte[] cache_bytes_push_token;
  static DeviceInfo cache_deviceInfo = new DeviceInfo();
  static ArrayList<DelMsgInfo> cache_vDelInfos = new ArrayList();
  public byte[] bytes_push_token = null;
  public DeviceInfo deviceInfo = null;
  public long lUin = 0L;
  public int service_type = 0;
  public int svrip = 0;
  public ArrayList<DelMsgInfo> vDelInfos = null;
  
  static
  {
    DelMsgInfo localDelMsgInfo = new DelMsgInfo();
    cache_vDelInfos.add(localDelMsgInfo);
    cache_bytes_push_token = (byte[])new byte[1];
    ((byte[])cache_bytes_push_token)[0] = 0;
  }
  
  public SvcRespPushMsg() {}
  
  public SvcRespPushMsg(long paramLong, ArrayList<DelMsgInfo> paramArrayList, int paramInt1, byte[] paramArrayOfByte, int paramInt2, DeviceInfo paramDeviceInfo)
  {
    this.lUin = paramLong;
    this.vDelInfos = paramArrayList;
    this.svrip = paramInt1;
    this.bytes_push_token = paramArrayOfByte;
    this.service_type = paramInt2;
    this.deviceInfo = paramDeviceInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.vDelInfos = ((ArrayList)paramJceInputStream.read(cache_vDelInfos, 1, true));
    this.svrip = paramJceInputStream.read(this.svrip, 2, true);
    this.bytes_push_token = ((byte[])paramJceInputStream.read(cache_bytes_push_token, 3, false));
    this.service_type = paramJceInputStream.read(this.service_type, 4, false);
    this.deviceInfo = ((DeviceInfo)paramJceInputStream.read(cache_deviceInfo, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vDelInfos, 1);
    paramJceOutputStream.write(this.svrip, 2);
    Object localObject = this.bytes_push_token;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 3);
    }
    paramJceOutputStream.write(this.service_type, 4);
    localObject = this.deviceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     OnlinePushPack.SvcRespPushMsg
 * JD-Core Version:    0.7.0.1
 */