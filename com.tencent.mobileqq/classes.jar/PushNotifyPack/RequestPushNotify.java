package PushNotifyPack;

import OnlinePushPack.MsgInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestPushNotify
  extends JceStruct
{
  static byte[] cache_bytes_server_buf;
  static MsgInfo cache_stMsgInfo;
  static byte[] cache_vNotifyCookie = (byte[])new byte[1];
  public byte[] bytes_server_buf;
  public byte cType;
  public long lBindedUin;
  public long lUin;
  public String msg_ctrl_buf = "";
  public long ping_flag;
  public MsgInfo stMsgInfo;
  public String strCmd = "";
  public String strService = "";
  public int svrip;
  public int usMsgType;
  public byte[] vNotifyCookie;
  public int wGeneralFlag;
  public int wUserActive;
  
  static
  {
    ((byte[])cache_vNotifyCookie)[0] = 0;
    cache_stMsgInfo = new MsgInfo();
    cache_bytes_server_buf = (byte[])new byte[1];
    ((byte[])cache_bytes_server_buf)[0] = 0;
  }
  
  public RequestPushNotify() {}
  
  public RequestPushNotify(long paramLong1, byte paramByte, String paramString1, String paramString2, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, MsgInfo paramMsgInfo, String paramString3, byte[] paramArrayOfByte2, long paramLong3, int paramInt4)
  {
    this.lUin = paramLong1;
    this.cType = paramByte;
    this.strService = paramString1;
    this.strCmd = paramString2;
    this.vNotifyCookie = paramArrayOfByte1;
    this.usMsgType = paramInt1;
    this.wUserActive = paramInt2;
    this.wGeneralFlag = paramInt3;
    this.lBindedUin = paramLong2;
    this.stMsgInfo = paramMsgInfo;
    this.msg_ctrl_buf = paramString3;
    this.bytes_server_buf = paramArrayOfByte2;
    this.ping_flag = paramLong3;
    this.svrip = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cType = paramJceInputStream.read(this.cType, 1, true);
    this.strService = paramJceInputStream.readString(2, true);
    this.strCmd = paramJceInputStream.readString(3, true);
    this.vNotifyCookie = ((byte[])paramJceInputStream.read(cache_vNotifyCookie, 4, false));
    this.usMsgType = paramJceInputStream.read(this.usMsgType, 5, false);
    this.wUserActive = paramJceInputStream.read(this.wUserActive, 6, false);
    this.wGeneralFlag = paramJceInputStream.read(this.wGeneralFlag, 7, false);
    this.lBindedUin = paramJceInputStream.read(this.lBindedUin, 8, false);
    this.stMsgInfo = ((MsgInfo)paramJceInputStream.read(cache_stMsgInfo, 9, false));
    this.msg_ctrl_buf = paramJceInputStream.readString(10, false);
    this.bytes_server_buf = ((byte[])paramJceInputStream.read(cache_bytes_server_buf, 11, false));
    this.ping_flag = paramJceInputStream.read(this.ping_flag, 12, false);
    this.svrip = paramJceInputStream.read(this.svrip, 13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cType, 1);
    paramJceOutputStream.write(this.strService, 2);
    paramJceOutputStream.write(this.strCmd, 3);
    if (this.vNotifyCookie != null) {
      paramJceOutputStream.write(this.vNotifyCookie, 4);
    }
    paramJceOutputStream.write(this.usMsgType, 5);
    paramJceOutputStream.write(this.wUserActive, 6);
    paramJceOutputStream.write(this.wGeneralFlag, 7);
    paramJceOutputStream.write(this.lBindedUin, 8);
    if (this.stMsgInfo != null) {
      paramJceOutputStream.write(this.stMsgInfo, 9);
    }
    if (this.msg_ctrl_buf != null) {
      paramJceOutputStream.write(this.msg_ctrl_buf, 10);
    }
    if (this.bytes_server_buf != null) {
      paramJceOutputStream.write(this.bytes_server_buf, 11);
    }
    paramJceOutputStream.write(this.ping_flag, 12);
    paramJceOutputStream.write(this.svrip, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     PushNotifyPack.RequestPushNotify
 * JD-Core Version:    0.7.0.1
 */