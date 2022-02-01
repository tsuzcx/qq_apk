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
  static SvcRequestGetMsgV2 cache_c2cmsg;
  static SvcRequestPullDisMsgSeq cache_confmsg;
  static SvcRequestPullDisGroupSeq cache_disgroupmsg;
  static SvcRequestPullGroupMsgSeq cache_groupmsg;
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
  public long ulLastFilterListTime = 0L;
  public long ulMaxDisGrpMsgTime = 0L;
  public long ulRequestOptional = 0L;
  public long ulSyncTime = 0L;
  public byte[] vCookies = null;
  public byte[] vSaveTraffic = null;
  public byte[] vSig = null;
  
  public SvcRequestRegisterNew() {}
  
  public SvcRequestRegisterNew(long paramLong1, SvcRequestGetMsgV2 paramSvcRequestGetMsgV2, SvcRequestPullGroupMsgSeq paramSvcRequestPullGroupMsgSeq, SvcRequestPullDisMsgSeq paramSvcRequestPullDisMsgSeq, SvcReqRegister paramSvcReqRegister, byte paramByte1, byte paramByte2, byte paramByte3, long paramLong2, SvcRequestPullDisGroupSeq paramSvcRequestPullDisGroupSeq, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, SvcReqGet paramSvcReqGet, byte paramByte4, byte paramByte5, long paramLong3, byte paramByte6, long paramLong4, long paramLong5, byte[] paramArrayOfByte4, long paramLong6)
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
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ulRequestOptional = paramJceInputStream.read(this.ulRequestOptional, 0, true);
    if (cache_c2cmsg == null) {
      cache_c2cmsg = new SvcRequestGetMsgV2();
    }
    this.c2cmsg = ((SvcRequestGetMsgV2)paramJceInputStream.read(cache_c2cmsg, 1, false));
    if (cache_groupmsg == null) {
      cache_groupmsg = new SvcRequestPullGroupMsgSeq();
    }
    this.groupmsg = ((SvcRequestPullGroupMsgSeq)paramJceInputStream.read(cache_groupmsg, 2, false));
    if (cache_confmsg == null) {
      cache_confmsg = new SvcRequestPullDisMsgSeq();
    }
    this.confmsg = ((SvcRequestPullDisMsgSeq)paramJceInputStream.read(cache_confmsg, 3, false));
    if (cache_regist == null) {
      cache_regist = new SvcReqRegister();
    }
    this.regist = ((SvcReqRegister)paramJceInputStream.read(cache_regist, 4, false));
    this.cSubCmd = paramJceInputStream.read(this.cSubCmd, 5, false);
    this.cGetGroupPttUrl = paramJceInputStream.read(this.cGetGroupPttUrl, 6, false);
    this.cGetDisPttUrl = paramJceInputStream.read(this.cGetDisPttUrl, 7, false);
    this.badge = paramJceInputStream.read(this.badge, 8, false);
    if (cache_disgroupmsg == null) {
      cache_disgroupmsg = new SvcRequestPullDisGroupSeq();
    }
    this.disgroupmsg = ((SvcRequestPullDisGroupSeq)paramJceInputStream.read(cache_disgroupmsg, 9, false));
    if (cache_vSaveTraffic == null)
    {
      cache_vSaveTraffic = (byte[])new byte[1];
      ((byte[])cache_vSaveTraffic)[0] = 0;
    }
    this.vSaveTraffic = ((byte[])paramJceInputStream.read(cache_vSaveTraffic, 10, false));
    if (cache_vCookies == null)
    {
      cache_vCookies = (byte[])new byte[1];
      ((byte[])cache_vCookies)[0] = 0;
    }
    this.vCookies = ((byte[])paramJceInputStream.read(cache_vCookies, 11, false));
    if (cache_vSig == null)
    {
      cache_vSig = (byte[])new byte[1];
      ((byte[])cache_vSig)[0] = 0;
    }
    this.vSig = ((byte[])paramJceInputStream.read(cache_vSig, 12, false));
    if (cache_heartbeat == null) {
      cache_heartbeat = new SvcReqGet();
    }
    this.heartbeat = ((SvcReqGet)paramJceInputStream.read(cache_heartbeat, 13, false));
    this.cDisgroupMsgFilter = paramJceInputStream.read(this.cDisgroupMsgFilter, 14, false);
    this.cGroupMask = paramJceInputStream.read(this.cGroupMask, 15, false);
    this.uEndSeq = paramJceInputStream.read(this.uEndSeq, 16, false);
    this.cOptGroupMsgFlag = paramJceInputStream.read(this.cOptGroupMsgFlag, 17, false);
    this.ulSyncTime = paramJceInputStream.read(this.ulSyncTime, 18, false);
    this.ulMaxDisGrpMsgTime = paramJceInputStream.read(this.ulMaxDisGrpMsgTime, 19, false);
    if (cache_bytes_0x769_reqbody == null)
    {
      cache_bytes_0x769_reqbody = (byte[])new byte[1];
      ((byte[])cache_bytes_0x769_reqbody)[0] = 0;
    }
    this.bytes_0x769_reqbody = ((byte[])paramJceInputStream.read(cache_bytes_0x769_reqbody, 20, false));
    this.ulLastFilterListTime = paramJceInputStream.read(this.ulLastFilterListTime, 23, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ulRequestOptional, 0);
    if (this.c2cmsg != null) {
      paramJceOutputStream.write(this.c2cmsg, 1);
    }
    if (this.groupmsg != null) {
      paramJceOutputStream.write(this.groupmsg, 2);
    }
    if (this.confmsg != null) {
      paramJceOutputStream.write(this.confmsg, 3);
    }
    if (this.regist != null) {
      paramJceOutputStream.write(this.regist, 4);
    }
    paramJceOutputStream.write(this.cSubCmd, 5);
    paramJceOutputStream.write(this.cGetGroupPttUrl, 6);
    paramJceOutputStream.write(this.cGetDisPttUrl, 7);
    paramJceOutputStream.write(this.badge, 8);
    if (this.disgroupmsg != null) {
      paramJceOutputStream.write(this.disgroupmsg, 9);
    }
    if (this.vSaveTraffic != null) {
      paramJceOutputStream.write(this.vSaveTraffic, 10);
    }
    if (this.vCookies != null) {
      paramJceOutputStream.write(this.vCookies, 11);
    }
    if (this.vSig != null) {
      paramJceOutputStream.write(this.vSig, 12);
    }
    if (this.heartbeat != null) {
      paramJceOutputStream.write(this.heartbeat, 13);
    }
    paramJceOutputStream.write(this.cDisgroupMsgFilter, 14);
    paramJceOutputStream.write(this.cGroupMask, 15);
    paramJceOutputStream.write(this.uEndSeq, 16);
    paramJceOutputStream.write(this.cOptGroupMsgFlag, 17);
    paramJceOutputStream.write(this.ulSyncTime, 18);
    paramJceOutputStream.write(this.ulMaxDisGrpMsgTime, 19);
    if (this.bytes_0x769_reqbody != null) {
      paramJceOutputStream.write(this.bytes_0x769_reqbody, 20);
    }
    paramJceOutputStream.write(this.ulLastFilterListTime, 23);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     RegisterProxySvcPack.SvcRequestRegisterNew
 * JD-Core Version:    0.7.0.1
 */