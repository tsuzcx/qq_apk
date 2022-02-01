package OnlinePushPack;

import QQService.shareData;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MsgInfo
  extends JceStruct
  implements Cloneable
{
  static TempMsgHead cache_stC2CTmpMsgHead;
  static shareData cache_stShareData;
  static byte[] cache_vAppShareCookie;
  static ArrayList<CPicInfo> cache_vCPicInfo;
  static byte[] cache_vMsg;
  static byte[] cache_vMsgCookies;
  static ArrayList<String> cache_vNickName;
  static byte[] cache_vRemarkOfSender;
  public long lFromInstId = 0L;
  public long lFromUin = 0L;
  public long lLastChangeTime = 1L;
  public long lMsgUid = 0L;
  public short shMsgSeq = 0;
  public short shMsgType = 0;
  public TempMsgHead stC2CTmpMsgHead = null;
  public shareData stShareData = null;
  public String strFromMobile = "";
  public String strFromName = "";
  public String strMsg = "";
  public long uAppShareID = 0L;
  public long uMsgTime = 0L;
  public int uRealMsgTime = 0;
  public byte[] vAppShareCookie = null;
  public ArrayList<CPicInfo> vCPicInfo = null;
  public byte[] vMsg = null;
  public byte[] vMsgCookies = null;
  public ArrayList<String> vNickName = null;
  public byte[] vRemarkOfSender = null;
  
  public MsgInfo() {}
  
  public MsgInfo(long paramLong1, long paramLong2, short paramShort1, short paramShort2, String paramString1, int paramInt, byte[] paramArrayOfByte1, long paramLong3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong4, long paramLong5, ArrayList<CPicInfo> paramArrayList, shareData paramshareData, long paramLong6, byte[] paramArrayOfByte4, String paramString2, String paramString3, ArrayList<String> paramArrayList1, TempMsgHead paramTempMsgHead)
  {
    this.lFromUin = paramLong1;
    this.uMsgTime = paramLong2;
    this.shMsgType = paramShort1;
    this.shMsgSeq = paramShort2;
    this.strMsg = paramString1;
    this.uRealMsgTime = paramInt;
    this.vMsg = paramArrayOfByte1;
    this.uAppShareID = paramLong3;
    this.vMsgCookies = paramArrayOfByte2;
    this.vAppShareCookie = paramArrayOfByte3;
    this.lMsgUid = paramLong4;
    this.lLastChangeTime = paramLong5;
    this.vCPicInfo = paramArrayList;
    this.stShareData = paramshareData;
    this.lFromInstId = paramLong6;
    this.vRemarkOfSender = paramArrayOfByte4;
    this.strFromMobile = paramString2;
    this.strFromName = paramString3;
    this.vNickName = paramArrayList1;
    this.stC2CTmpMsgHead = paramTempMsgHead;
  }
  
  public String className()
  {
    return "OnlinePushPack.MsgInfo";
  }
  
  public String fullClassName()
  {
    return "OnlinePushPack.MsgInfo";
  }
  
  public long getLFromInstId()
  {
    return this.lFromInstId;
  }
  
  public long getLFromUin()
  {
    return this.lFromUin;
  }
  
  public long getLLastChangeTime()
  {
    return this.lLastChangeTime;
  }
  
  public long getLMsgUid()
  {
    return this.lMsgUid;
  }
  
  public short getShMsgSeq()
  {
    return this.shMsgSeq;
  }
  
  public short getShMsgType()
  {
    return this.shMsgType;
  }
  
  public shareData getStShareData()
  {
    return this.stShareData;
  }
  
  public String getStrFromMobile()
  {
    return this.strFromMobile;
  }
  
  public String getStrFromName()
  {
    return this.strFromName;
  }
  
  public String getStrMsg()
  {
    return this.strMsg;
  }
  
  public long getUAppShareID()
  {
    return this.uAppShareID;
  }
  
  public long getUMsgTime()
  {
    return this.uMsgTime;
  }
  
  public int getURealMsgTime()
  {
    return this.uRealMsgTime;
  }
  
  public byte[] getVAppShareCookie()
  {
    return this.vAppShareCookie;
  }
  
  public ArrayList<CPicInfo> getVCPicInfo()
  {
    return this.vCPicInfo;
  }
  
  public byte[] getVMsg()
  {
    return this.vMsg;
  }
  
  public byte[] getVMsgCookies()
  {
    return this.vMsgCookies;
  }
  
  public ArrayList<String> getVNickName()
  {
    return this.vNickName;
  }
  
  public byte[] getVRemarkOfSender()
  {
    return this.vRemarkOfSender;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUin = paramJceInputStream.read(this.lFromUin, 0, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 1, true);
    this.shMsgType = paramJceInputStream.read(this.shMsgType, 2, true);
    this.shMsgSeq = paramJceInputStream.read(this.shMsgSeq, 3, true);
    this.strMsg = paramJceInputStream.readString(4, true);
    this.uRealMsgTime = paramJceInputStream.read(this.uRealMsgTime, 5, false);
    if (cache_vMsg == null)
    {
      cache_vMsg = (byte[])new byte[1];
      ((byte[])cache_vMsg)[0] = 0;
    }
    this.vMsg = ((byte[])paramJceInputStream.read(cache_vMsg, 6, false));
    this.uAppShareID = paramJceInputStream.read(this.uAppShareID, 7, false);
    if (cache_vMsgCookies == null)
    {
      cache_vMsgCookies = (byte[])new byte[1];
      ((byte[])cache_vMsgCookies)[0] = 0;
    }
    this.vMsgCookies = ((byte[])paramJceInputStream.read(cache_vMsgCookies, 8, false));
    if (cache_vAppShareCookie == null)
    {
      cache_vAppShareCookie = (byte[])new byte[1];
      ((byte[])cache_vAppShareCookie)[0] = 0;
    }
    this.vAppShareCookie = ((byte[])paramJceInputStream.read(cache_vAppShareCookie, 9, false));
    this.lMsgUid = paramJceInputStream.read(this.lMsgUid, 10, false);
    this.lLastChangeTime = paramJceInputStream.read(this.lLastChangeTime, 11, false);
    if (cache_vCPicInfo == null)
    {
      cache_vCPicInfo = new ArrayList();
      CPicInfo localCPicInfo = new CPicInfo();
      cache_vCPicInfo.add(localCPicInfo);
    }
    this.vCPicInfo = ((ArrayList)paramJceInputStream.read(cache_vCPicInfo, 12, false));
    if (cache_stShareData == null) {
      cache_stShareData = new shareData();
    }
    this.stShareData = ((shareData)paramJceInputStream.read(cache_stShareData, 13, false));
    this.lFromInstId = paramJceInputStream.read(this.lFromInstId, 14, false);
    if (cache_vRemarkOfSender == null)
    {
      cache_vRemarkOfSender = (byte[])new byte[1];
      ((byte[])cache_vRemarkOfSender)[0] = 0;
    }
    this.vRemarkOfSender = ((byte[])paramJceInputStream.read(cache_vRemarkOfSender, 15, false));
    this.strFromMobile = paramJceInputStream.readString(16, false);
    this.strFromName = paramJceInputStream.readString(17, false);
    if (cache_vNickName == null)
    {
      cache_vNickName = new ArrayList();
      cache_vNickName.add("");
    }
    this.vNickName = ((ArrayList)paramJceInputStream.read(cache_vNickName, 18, false));
    if (cache_stC2CTmpMsgHead == null) {
      cache_stC2CTmpMsgHead = new TempMsgHead();
    }
    this.stC2CTmpMsgHead = ((TempMsgHead)paramJceInputStream.read(cache_stC2CTmpMsgHead, 19, false));
  }
  
  public void setLFromInstId(long paramLong)
  {
    this.lFromInstId = paramLong;
  }
  
  public void setLFromUin(long paramLong)
  {
    this.lFromUin = paramLong;
  }
  
  public void setLLastChangeTime(long paramLong)
  {
    this.lLastChangeTime = paramLong;
  }
  
  public void setLMsgUid(long paramLong)
  {
    this.lMsgUid = paramLong;
  }
  
  public void setShMsgSeq(short paramShort)
  {
    this.shMsgSeq = paramShort;
  }
  
  public void setShMsgType(short paramShort)
  {
    this.shMsgType = paramShort;
  }
  
  public void setStShareData(shareData paramshareData)
  {
    this.stShareData = paramshareData;
  }
  
  public void setStrFromMobile(String paramString)
  {
    this.strFromMobile = paramString;
  }
  
  public void setStrFromName(String paramString)
  {
    this.strFromName = paramString;
  }
  
  public void setStrMsg(String paramString)
  {
    this.strMsg = paramString;
  }
  
  public void setUAppShareID(long paramLong)
  {
    this.uAppShareID = paramLong;
  }
  
  public void setUMsgTime(long paramLong)
  {
    this.uMsgTime = paramLong;
  }
  
  public void setURealMsgTime(int paramInt)
  {
    this.uRealMsgTime = paramInt;
  }
  
  public void setVAppShareCookie(byte[] paramArrayOfByte)
  {
    this.vAppShareCookie = paramArrayOfByte;
  }
  
  public void setVCPicInfo(ArrayList<CPicInfo> paramArrayList)
  {
    this.vCPicInfo = paramArrayList;
  }
  
  public void setVMsg(byte[] paramArrayOfByte)
  {
    this.vMsg = paramArrayOfByte;
  }
  
  public void setVMsgCookies(byte[] paramArrayOfByte)
  {
    this.vMsgCookies = paramArrayOfByte;
  }
  
  public void setVNickName(ArrayList<String> paramArrayList)
  {
    this.vNickName = paramArrayList;
  }
  
  public void setVRemarkOfSender(byte[] paramArrayOfByte)
  {
    this.vRemarkOfSender = paramArrayOfByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUin, 0);
    paramJceOutputStream.write(this.uMsgTime, 1);
    paramJceOutputStream.write(this.shMsgType, 2);
    paramJceOutputStream.write(this.shMsgSeq, 3);
    paramJceOutputStream.write(this.strMsg, 4);
    paramJceOutputStream.write(this.uRealMsgTime, 5);
    if (this.vMsg != null) {
      paramJceOutputStream.write(this.vMsg, 6);
    }
    paramJceOutputStream.write(this.uAppShareID, 7);
    if (this.vMsgCookies != null) {
      paramJceOutputStream.write(this.vMsgCookies, 8);
    }
    if (this.vAppShareCookie != null) {
      paramJceOutputStream.write(this.vAppShareCookie, 9);
    }
    paramJceOutputStream.write(this.lMsgUid, 10);
    paramJceOutputStream.write(this.lLastChangeTime, 11);
    if (this.vCPicInfo != null) {
      paramJceOutputStream.write(this.vCPicInfo, 12);
    }
    if (this.stShareData != null) {
      paramJceOutputStream.write(this.stShareData, 13);
    }
    paramJceOutputStream.write(this.lFromInstId, 14);
    if (this.vRemarkOfSender != null) {
      paramJceOutputStream.write(this.vRemarkOfSender, 15);
    }
    if (this.strFromMobile != null) {
      paramJceOutputStream.write(this.strFromMobile, 16);
    }
    if (this.strFromName != null) {
      paramJceOutputStream.write(this.strFromName, 17);
    }
    if (this.vNickName != null) {
      paramJceOutputStream.write(this.vNickName, 18);
    }
    if (this.stC2CTmpMsgHead != null) {
      paramJceOutputStream.write(this.stC2CTmpMsgHead, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     OnlinePushPack.MsgInfo
 * JD-Core Version:    0.7.0.1
 */