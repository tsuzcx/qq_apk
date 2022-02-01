package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestGetMsgV2
  extends JceStruct
{
  static int cache_cSyncFlag;
  static int cache_eBusiType;
  static int cache_eMqqSysType;
  static byte[] cache_vCookies;
  static byte[] cache_vNotifyCookie;
  static byte[] cache_vPubAccountCookie;
  static byte[] cache_vSyncCookie;
  public byte cAutoGetMsg = 0;
  public byte cChannel = 1;
  public byte cChannelEx = 0;
  public byte cContextFlag = 0;
  public byte cInnerFlag = 0;
  public byte cInst = 0;
  public byte cMsgStoreType = 0;
  public byte cOnlineSyncFlag = 1;
  public byte cPushService = 0;
  public byte cRambleFlag = 0;
  public byte cRecivePic = 0;
  public int cSyncFlag = MsgSyncFlag.SYNC_BEGIN.value();
  public byte cUnFilter = 0;
  public byte cVerifyType = 0;
  public int eBusiType = BusinessType.BusinessType_MQQ.value();
  public int eMqqSysType = MqqSysType.MqqSysType_default.value();
  public long iOSVersion = 0L;
  public long lGeneralAbi = 0L;
  public long lUin = 0L;
  public String sA2 = "";
  public short shAbility = 0;
  public short shLatestRambleNumber = 20;
  public short shOtherRambleNumber = 3;
  public int uDateTime = 0;
  public byte[] vCookies = null;
  public byte[] vNotifyCookie = null;
  public byte[] vPubAccountCookie = null;
  public byte[] vSyncCookie = null;
  
  public SvcRequestGetMsgV2() {}
  
  public SvcRequestGetMsgV2(long paramLong1, int paramInt1, String paramString, byte paramByte1, byte paramByte2, byte paramByte3, short paramShort1, byte paramByte4, byte paramByte5, byte paramByte6, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, long paramLong2, byte paramByte7, byte paramByte8, byte paramByte9, byte[] paramArrayOfByte3, int paramInt4, byte paramByte10, short paramShort2, short paramShort3, byte paramByte11, byte paramByte12, byte paramByte13, long paramLong3, byte[] paramArrayOfByte4)
  {
    this.lUin = paramLong1;
    this.uDateTime = paramInt1;
    this.sA2 = paramString;
    this.cVerifyType = paramByte1;
    this.cRecivePic = paramByte2;
    this.cAutoGetMsg = paramByte3;
    this.shAbility = paramShort1;
    this.cMsgStoreType = paramByte4;
    this.cPushService = paramByte5;
    this.cChannel = paramByte6;
    this.vCookies = paramArrayOfByte1;
    this.eBusiType = paramInt2;
    this.eMqqSysType = paramInt3;
    this.vNotifyCookie = paramArrayOfByte2;
    this.iOSVersion = paramLong2;
    this.cUnFilter = paramByte7;
    this.cInst = paramByte8;
    this.cChannelEx = paramByte9;
    this.vSyncCookie = paramArrayOfByte3;
    this.cSyncFlag = paramInt4;
    this.cRambleFlag = paramByte10;
    this.shLatestRambleNumber = paramShort2;
    this.shOtherRambleNumber = paramShort3;
    this.cInnerFlag = paramByte11;
    this.cOnlineSyncFlag = paramByte12;
    this.cContextFlag = paramByte13;
    this.lGeneralAbi = paramLong3;
    this.vPubAccountCookie = paramArrayOfByte4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.uDateTime = paramJceInputStream.read(this.uDateTime, 1, true);
    this.sA2 = paramJceInputStream.readString(2, false);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 3, false);
    this.cRecivePic = paramJceInputStream.read(this.cRecivePic, 4, false);
    this.cAutoGetMsg = paramJceInputStream.read(this.cAutoGetMsg, 5, false);
    this.shAbility = paramJceInputStream.read(this.shAbility, 6, false);
    this.cMsgStoreType = paramJceInputStream.read(this.cMsgStoreType, 7, false);
    this.cPushService = paramJceInputStream.read(this.cPushService, 8, false);
    this.cChannel = paramJceInputStream.read(this.cChannel, 9, false);
    if (cache_vCookies == null)
    {
      cache_vCookies = (byte[])new byte[1];
      ((byte[])cache_vCookies)[0] = 0;
    }
    this.vCookies = ((byte[])paramJceInputStream.read(cache_vCookies, 10, false));
    this.eBusiType = paramJceInputStream.read(this.eBusiType, 11, false);
    this.eMqqSysType = paramJceInputStream.read(this.eMqqSysType, 12, false);
    if (cache_vNotifyCookie == null)
    {
      cache_vNotifyCookie = (byte[])new byte[1];
      ((byte[])cache_vNotifyCookie)[0] = 0;
    }
    this.vNotifyCookie = ((byte[])paramJceInputStream.read(cache_vNotifyCookie, 13, false));
    this.iOSVersion = paramJceInputStream.read(this.iOSVersion, 14, false);
    this.cUnFilter = paramJceInputStream.read(this.cUnFilter, 15, false);
    this.cInst = paramJceInputStream.read(this.cInst, 16, false);
    this.cChannelEx = paramJceInputStream.read(this.cChannelEx, 17, false);
    if (cache_vSyncCookie == null)
    {
      cache_vSyncCookie = (byte[])new byte[1];
      ((byte[])cache_vSyncCookie)[0] = 0;
    }
    this.vSyncCookie = ((byte[])paramJceInputStream.read(cache_vSyncCookie, 18, false));
    this.cSyncFlag = paramJceInputStream.read(this.cSyncFlag, 19, false);
    this.cRambleFlag = paramJceInputStream.read(this.cRambleFlag, 20, false);
    this.shLatestRambleNumber = paramJceInputStream.read(this.shLatestRambleNumber, 21, false);
    this.shOtherRambleNumber = paramJceInputStream.read(this.shOtherRambleNumber, 22, false);
    this.cInnerFlag = paramJceInputStream.read(this.cInnerFlag, 23, false);
    this.cOnlineSyncFlag = paramJceInputStream.read(this.cOnlineSyncFlag, 24, false);
    this.cContextFlag = paramJceInputStream.read(this.cContextFlag, 25, false);
    this.lGeneralAbi = paramJceInputStream.read(this.lGeneralAbi, 26, false);
    if (cache_vPubAccountCookie == null)
    {
      cache_vPubAccountCookie = (byte[])new byte[1];
      ((byte[])cache_vPubAccountCookie)[0] = 0;
    }
    this.vPubAccountCookie = ((byte[])paramJceInputStream.read(cache_vPubAccountCookie, 27, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.uDateTime, 1);
    if (this.sA2 != null) {
      paramJceOutputStream.write(this.sA2, 2);
    }
    paramJceOutputStream.write(this.cVerifyType, 3);
    paramJceOutputStream.write(this.cRecivePic, 4);
    paramJceOutputStream.write(this.cAutoGetMsg, 5);
    paramJceOutputStream.write(this.shAbility, 6);
    paramJceOutputStream.write(this.cMsgStoreType, 7);
    paramJceOutputStream.write(this.cPushService, 8);
    paramJceOutputStream.write(this.cChannel, 9);
    if (this.vCookies != null) {
      paramJceOutputStream.write(this.vCookies, 10);
    }
    paramJceOutputStream.write(this.eBusiType, 11);
    paramJceOutputStream.write(this.eMqqSysType, 12);
    if (this.vNotifyCookie != null) {
      paramJceOutputStream.write(this.vNotifyCookie, 13);
    }
    paramJceOutputStream.write(this.iOSVersion, 14);
    paramJceOutputStream.write(this.cUnFilter, 15);
    paramJceOutputStream.write(this.cInst, 16);
    paramJceOutputStream.write(this.cChannelEx, 17);
    if (this.vSyncCookie != null) {
      paramJceOutputStream.write(this.vSyncCookie, 18);
    }
    paramJceOutputStream.write(this.cSyncFlag, 19);
    paramJceOutputStream.write(this.cRambleFlag, 20);
    paramJceOutputStream.write(this.shLatestRambleNumber, 21);
    paramJceOutputStream.write(this.shOtherRambleNumber, 22);
    paramJceOutputStream.write(this.cInnerFlag, 23);
    paramJceOutputStream.write(this.cOnlineSyncFlag, 24);
    paramJceOutputStream.write(this.cContextFlag, 25);
    paramJceOutputStream.write(this.lGeneralAbi, 26);
    if (this.vPubAccountCookie != null) {
      paramJceOutputStream.write(this.vPubAccountCookie, 27);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestGetMsgV2
 * JD-Core Version:    0.7.0.1
 */