package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRespPushMsg
  extends JceStruct
{
  static byte[] cache_bytes_push_token;
  static ArrayList cache_vDelInfos = new ArrayList();
  public byte[] bytes_push_token;
  public long lUin;
  public int svrip;
  public ArrayList vDelInfos;
  
  static
  {
    DelMsgInfo localDelMsgInfo = new DelMsgInfo();
    cache_vDelInfos.add(localDelMsgInfo);
    cache_bytes_push_token = (byte[])new byte[1];
    ((byte[])cache_bytes_push_token)[0] = 0;
  }
  
  public SvcRespPushMsg() {}
  
  public SvcRespPushMsg(long paramLong, ArrayList paramArrayList, int paramInt, byte[] paramArrayOfByte)
  {
    this.lUin = paramLong;
    this.vDelInfos = paramArrayList;
    this.svrip = paramInt;
    this.bytes_push_token = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.vDelInfos = ((ArrayList)paramJceInputStream.read(cache_vDelInfos, 1, true));
    this.svrip = paramJceInputStream.read(this.svrip, 2, true);
    this.bytes_push_token = ((byte[])paramJceInputStream.read(cache_bytes_push_token, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vDelInfos, 1);
    paramJceOutputStream.write(this.svrip, 2);
    if (this.bytes_push_token != null) {
      paramJceOutputStream.write(this.bytes_push_token, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     OnlinePushPack.SvcRespPushMsg
 * JD-Core Version:    0.7.0.1
 */