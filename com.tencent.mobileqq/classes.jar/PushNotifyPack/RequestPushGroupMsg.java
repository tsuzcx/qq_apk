package PushNotifyPack;

import QQService.shareData;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RequestPushGroupMsg
  extends JceStruct
{
  static GroupMsgHead cache_stGroupMsgHead;
  static shareData cache_stShareData;
  static byte[] cache_vAppShareCookie;
  static ArrayList cache_vGPicInfo;
  static ArrayList cache_vMarketFace;
  static byte[] cache_vMsg;
  public byte cGroupType;
  public byte cType;
  public long lFromInstId;
  public long lGroupCode;
  public long lInfoSeq;
  public long lSendUin;
  public long lUin;
  public long lsMsgSeq;
  public short shMsgLen;
  public GroupMsgHead stGroupMsgHead;
  public shareData stShareData;
  public String strCmd = "";
  public String strGroupCard = "";
  public String strService = "";
  public long uAppShareID;
  public int uMsgTime;
  public long uSuperQQBubbleId;
  public byte[] vAppShareCookie;
  public ArrayList vGPicInfo;
  public ArrayList vMarketFace;
  public byte[] vMsg;
  public int wUserActive;
  
  public RequestPushGroupMsg() {}
  
  public RequestPushGroupMsg(long paramLong1, byte paramByte1, String paramString1, String paramString2, long paramLong2, byte paramByte2, long paramLong3, long paramLong4, int paramInt1, long paramLong5, short paramShort, byte[] paramArrayOfByte1, String paramString3, long paramLong6, ArrayList paramArrayList1, byte[] paramArrayOfByte2, shareData paramshareData, long paramLong7, GroupMsgHead paramGroupMsgHead, int paramInt2, ArrayList paramArrayList2, long paramLong8)
  {
    this.lUin = paramLong1;
    this.cType = paramByte1;
    this.strService = paramString1;
    this.strCmd = paramString2;
    this.lGroupCode = paramLong2;
    this.cGroupType = paramByte2;
    this.lSendUin = paramLong3;
    this.lsMsgSeq = paramLong4;
    this.uMsgTime = paramInt1;
    this.lInfoSeq = paramLong5;
    this.shMsgLen = paramShort;
    this.vMsg = paramArrayOfByte1;
    this.strGroupCard = paramString3;
    this.uAppShareID = paramLong6;
    this.vGPicInfo = paramArrayList1;
    this.vAppShareCookie = paramArrayOfByte2;
    this.stShareData = paramshareData;
    this.lFromInstId = paramLong7;
    this.stGroupMsgHead = paramGroupMsgHead;
    this.wUserActive = paramInt2;
    this.vMarketFace = paramArrayList2;
    this.uSuperQQBubbleId = paramLong8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cType = paramJceInputStream.read(this.cType, 1, true);
    this.strService = paramJceInputStream.readString(2, true);
    this.strCmd = paramJceInputStream.readString(3, true);
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 4, true);
    this.cGroupType = paramJceInputStream.read(this.cGroupType, 5, true);
    this.lSendUin = paramJceInputStream.read(this.lSendUin, 6, true);
    this.lsMsgSeq = paramJceInputStream.read(this.lsMsgSeq, 7, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 8, true);
    this.lInfoSeq = paramJceInputStream.read(this.lInfoSeq, 9, true);
    this.shMsgLen = paramJceInputStream.read(this.shMsgLen, 10, true);
    if (cache_vMsg == null)
    {
      cache_vMsg = (byte[])new byte[1];
      ((byte[])cache_vMsg)[0] = 0;
    }
    this.vMsg = ((byte[])paramJceInputStream.read(cache_vMsg, 11, true));
    this.strGroupCard = paramJceInputStream.readString(12, false);
    this.uAppShareID = paramJceInputStream.read(this.uAppShareID, 13, false);
    Object localObject;
    if (cache_vGPicInfo == null)
    {
      cache_vGPicInfo = new ArrayList();
      localObject = new GPicInfo();
      cache_vGPicInfo.add(localObject);
    }
    this.vGPicInfo = ((ArrayList)paramJceInputStream.read(cache_vGPicInfo, 14, false));
    if (cache_vAppShareCookie == null)
    {
      cache_vAppShareCookie = (byte[])new byte[1];
      ((byte[])cache_vAppShareCookie)[0] = 0;
    }
    this.vAppShareCookie = ((byte[])paramJceInputStream.read(cache_vAppShareCookie, 15, false));
    if (cache_stShareData == null) {
      cache_stShareData = new shareData();
    }
    this.stShareData = ((shareData)paramJceInputStream.read(cache_stShareData, 16, false));
    this.lFromInstId = paramJceInputStream.read(this.lFromInstId, 17, false);
    if (cache_stGroupMsgHead == null) {
      cache_stGroupMsgHead = new GroupMsgHead();
    }
    this.stGroupMsgHead = ((GroupMsgHead)paramJceInputStream.read(cache_stGroupMsgHead, 18, false));
    this.wUserActive = paramJceInputStream.read(this.wUserActive, 19, false);
    if (cache_vMarketFace == null)
    {
      cache_vMarketFace = new ArrayList();
      localObject = new MarketFaceInfo();
      cache_vMarketFace.add(localObject);
    }
    this.vMarketFace = ((ArrayList)paramJceInputStream.read(cache_vMarketFace, 20, false));
    this.uSuperQQBubbleId = paramJceInputStream.read(this.uSuperQQBubbleId, 21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cType, 1);
    paramJceOutputStream.write(this.strService, 2);
    paramJceOutputStream.write(this.strCmd, 3);
    paramJceOutputStream.write(this.lGroupCode, 4);
    paramJceOutputStream.write(this.cGroupType, 5);
    paramJceOutputStream.write(this.lSendUin, 6);
    paramJceOutputStream.write(this.lsMsgSeq, 7);
    paramJceOutputStream.write(this.uMsgTime, 8);
    paramJceOutputStream.write(this.lInfoSeq, 9);
    paramJceOutputStream.write(this.shMsgLen, 10);
    paramJceOutputStream.write(this.vMsg, 11);
    if (this.strGroupCard != null) {
      paramJceOutputStream.write(this.strGroupCard, 12);
    }
    paramJceOutputStream.write(this.uAppShareID, 13);
    if (this.vGPicInfo != null) {
      paramJceOutputStream.write(this.vGPicInfo, 14);
    }
    if (this.vAppShareCookie != null) {
      paramJceOutputStream.write(this.vAppShareCookie, 15);
    }
    if (this.stShareData != null) {
      paramJceOutputStream.write(this.stShareData, 16);
    }
    paramJceOutputStream.write(this.lFromInstId, 17);
    if (this.stGroupMsgHead != null) {
      paramJceOutputStream.write(this.stGroupMsgHead, 18);
    }
    paramJceOutputStream.write(this.wUserActive, 19);
    if (this.vMarketFace != null) {
      paramJceOutputStream.write(this.vMarketFace, 20);
    }
    paramJceOutputStream.write(this.uSuperQQBubbleId, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     PushNotifyPack.RequestPushGroupMsg
 * JD-Core Version:    0.7.0.1
 */