package RegisterProxySvcPack;

import MessageSvcPack.SvcRequestGetMsgV2;
import MessageSvcPack.SvcRequestPullDisMsgSeq;
import MessageSvcPack.SvcRequestPullGroupMsgSeq;
import QQService.SvcReqGet;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.msf.service.protocol.push.SvcReqRegister;

public final class SvcRequestRegisterNew
  extends JceStruct
{
  static byte[] cache_bytes_0x769_reqbody;
  static SvcRequestGetMsgV2 cache_c2cmsg = new SvcRequestGetMsgV2();
  static SvcRequestPullDisMsgSeq cache_confmsg;
  static SvcRequestPullDisGroupSeq cache_disgroupmsg;
  static SvcRequestPullGroupMsgSeq cache_groupmsg = new SvcRequestPullGroupMsgSeq();
  static SvcReqGet cache_heartbeat;
  static SvcReqRegister cache_regist;
  static byte[] cache_vCookies;
  static byte[] cache_vSaveTraffic;
  static byte[] cache_vSig;
  public long badge = 0L;
  public byte[] bytes_0x769_reqbody = null;
  public SvcRequestGetMsgV2 c2cmsg = null;
  public byte cDisgroupMsgFilter = 0;
  public byte cGetDisPttUrl = 0;
  public byte cGetGroupPttUrl = 0;
  public byte cGroupMask = 0;
  public byte cOptGroupMsgFlag = 0;
  public byte cSubCmd = 0;
  public SvcRequestPullDisMsgSeq confmsg = null;
  public SvcRequestPullDisGroupSeq disgroupmsg = null;
  public SvcRequestPullGroupMsgSeq groupmsg = null;
  public SvcReqGet heartbeat = null;
  public SvcReqRegister regist = null;
  public long uEndSeq = 0L;
  public int uGuildUdcFlag = 0;
  public long ulLastFilterListTime = 0L;
  public long ulMaxDisGrpMsgTime = 0L;
  public long ulReportFlag = 0L;
  public long ulRequestOptional = 0L;
  public long ulSyncTime = 0L;
  public byte[] vCookies = null;
  public byte[] vSaveTraffic = null;
  public byte[] vSig = null;
  
  static
  {
    cache_confmsg = new SvcRequestPullDisMsgSeq();
    cache_regist = new SvcReqRegister();
    cache_disgroupmsg = new SvcRequestPullDisGroupSeq();
    cache_vSaveTraffic = (byte[])new byte[1];
    ((byte[])cache_vSaveTraffic)[0] = 0;
    cache_vCookies = (byte[])new byte[1];
    ((byte[])cache_vCookies)[0] = 0;
    cache_vSig = (byte[])new byte[1];
    ((byte[])cache_vSig)[0] = 0;
    cache_heartbeat = new SvcReqGet();
    cache_bytes_0x769_reqbody = (byte[])new byte[1];
    ((byte[])cache_bytes_0x769_reqbody)[0] = 0;
  }
  
  public SvcRequestRegisterNew() {}
  
  public SvcRequestRegisterNew(long paramLong1, SvcRequestGetMsgV2 paramSvcRequestGetMsgV2, SvcRequestPullGroupMsgSeq paramSvcRequestPullGroupMsgSeq, SvcRequestPullDisMsgSeq paramSvcRequestPullDisMsgSeq, SvcReqRegister paramSvcReqRegister, byte paramByte1, byte paramByte2, byte paramByte3, long paramLong2, SvcRequestPullDisGroupSeq paramSvcRequestPullDisGroupSeq, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, SvcReqGet paramSvcReqGet, byte paramByte4, byte paramByte5, long paramLong3, byte paramByte6, long paramLong4, long paramLong5, byte[] paramArrayOfByte4, long paramLong6, int paramInt, long paramLong7)
  {
    this.ulRequestOptional = paramLong1;
    this.c2cmsg = paramSvcRequestGetMsgV2;
    this.groupmsg = paramSvcRequestPullGroupMsgSeq;
    this.confmsg = paramSvcRequestPullDisMsgSeq;
    this.regist = paramSvcReqRegister;
    this.cSubCmd = paramByte1;
    this.cGetGroupPttUrl = paramByte2;
    this.cGetDisPttUrl = paramByte3;
    this.badge = paramLong2;
    this.disgroupmsg = paramSvcRequestPullDisGroupSeq;
    this.vSaveTraffic = paramArrayOfByte1;
    this.vCookies = paramArrayOfByte2;
    this.vSig = paramArrayOfByte3;
    this.heartbeat = paramSvcReqGet;
    this.cDisgroupMsgFilter = paramByte4;
    this.cGroupMask = paramByte5;
    this.uEndSeq = paramLong3;
    this.cOptGroupMsgFlag = paramByte6;
    this.ulSyncTime = paramLong4;
    this.ulMaxDisGrpMsgTime = paramLong5;
    this.bytes_0x769_reqbody = paramArrayOfByte4;
    this.ulLastFilterListTime = paramLong6;
    this.uGuildUdcFlag = paramInt;
    this.ulReportFlag = paramLong7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ulRequestOptional = paramJceInputStream.read(this.ulRequestOptional, 0, true);
    this.c2cmsg = ((SvcRequestGetMsgV2)paramJceInputStream.read(cache_c2cmsg, 1, false));
    this.groupmsg = ((SvcRequestPullGroupMsgSeq)paramJceInputStream.read(cache_groupmsg, 2, false));
    this.confmsg = ((SvcRequestPullDisMsgSeq)paramJceInputStream.read(cache_confmsg, 3, false));
    this.regist = ((SvcReqRegister)paramJceInputStream.read(cache_regist, 4, false));
    this.cSubCmd = paramJceInputStream.read(this.cSubCmd, 5, false);
    this.cGetGroupPttUrl = paramJceInputStream.read(this.cGetGroupPttUrl, 6, false);
    this.cGetDisPttUrl = paramJceInputStream.read(this.cGetDisPttUrl, 7, false);
    this.badge = paramJceInputStream.read(this.badge, 8, false);
    this.disgroupmsg = ((SvcRequestPullDisGroupSeq)paramJceInputStream.read(cache_disgroupmsg, 9, false));
    this.vSaveTraffic = ((byte[])paramJceInputStream.read(cache_vSaveTraffic, 10, false));
    this.vCookies = ((byte[])paramJceInputStream.read(cache_vCookies, 11, false));
    this.vSig = ((byte[])paramJceInputStream.read(cache_vSig, 12, false));
    this.heartbeat = ((SvcReqGet)paramJceInputStream.read(cache_heartbeat, 13, false));
    this.cDisgroupMsgFilter = paramJceInputStream.read(this.cDisgroupMsgFilter, 14, false);
    this.cGroupMask = paramJceInputStream.read(this.cGroupMask, 15, false);
    this.uEndSeq = paramJceInputStream.read(this.uEndSeq, 16, false);
    this.cOptGroupMsgFlag = paramJceInputStream.read(this.cOptGroupMsgFlag, 17, false);
    this.ulSyncTime = paramJceInputStream.read(this.ulSyncTime, 18, false);
    this.ulMaxDisGrpMsgTime = paramJceInputStream.read(this.ulMaxDisGrpMsgTime, 19, false);
    this.bytes_0x769_reqbody = ((byte[])paramJceInputStream.read(cache_bytes_0x769_reqbody, 20, false));
    this.ulLastFilterListTime = paramJceInputStream.read(this.ulLastFilterListTime, 23, false);
    this.uGuildUdcFlag = paramJceInputStream.read(this.uGuildUdcFlag, 24, false);
    this.ulReportFlag = paramJceInputStream.read(this.ulReportFlag, 25, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ulRequestOptional, 0);
    Object localObject = this.c2cmsg;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.groupmsg;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.confmsg;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.regist;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    paramJceOutputStream.write(this.cSubCmd, 5);
    paramJceOutputStream.write(this.cGetGroupPttUrl, 6);
    paramJceOutputStream.write(this.cGetDisPttUrl, 7);
    paramJceOutputStream.write(this.badge, 8);
    localObject = this.disgroupmsg;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.vSaveTraffic;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 10);
    }
    localObject = this.vCookies;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 11);
    }
    localObject = this.vSig;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 12);
    }
    localObject = this.heartbeat;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 13);
    }
    paramJceOutputStream.write(this.cDisgroupMsgFilter, 14);
    paramJceOutputStream.write(this.cGroupMask, 15);
    paramJceOutputStream.write(this.uEndSeq, 16);
    paramJceOutputStream.write(this.cOptGroupMsgFlag, 17);
    paramJceOutputStream.write(this.ulSyncTime, 18);
    paramJceOutputStream.write(this.ulMaxDisGrpMsgTime, 19);
    localObject = this.bytes_0x769_reqbody;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 20);
    }
    paramJceOutputStream.write(this.ulLastFilterListTime, 23);
    paramJceOutputStream.write(this.uGuildUdcFlag, 24);
    paramJceOutputStream.write(this.ulReportFlag, 25);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     RegisterProxySvcPack.SvcRequestRegisterNew
 * JD-Core Version:    0.7.0.1
 */