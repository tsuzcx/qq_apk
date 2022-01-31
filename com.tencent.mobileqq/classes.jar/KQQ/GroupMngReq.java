package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupMngReq
  extends JceStruct
{
  static int cache_reqtype = 0;
  static byte[] cache_vecBody = (byte[])new byte[1];
  static byte[] cache_vecJoinGroupRichMsg;
  public byte cCheckInGroup;
  public byte cIfGetAuthInfo;
  public byte cIsSupportAuthQuestionJoin;
  public byte cStatOption;
  public long dwDiscussUin;
  public long dwJoinVerifyType;
  public int reqtype;
  public String sGroupLocation = "";
  public String sJoinGroupAuth = "";
  public String sJoinGroupKey = "";
  public String sJoinGroupPicUrl = "";
  public String sJoinGroupVerifyToken = "";
  public long uin;
  public byte[] vecBody;
  public byte[] vecJoinGroupRichMsg;
  public int wSourceID;
  public int wSourceSubID;
  
  static
  {
    ((byte[])cache_vecBody)[0] = 0;
    cache_vecJoinGroupRichMsg = (byte[])new byte[1];
    ((byte[])cache_vecJoinGroupRichMsg)[0] = 0;
  }
  
  public GroupMngReq() {}
  
  public GroupMngReq(int paramInt1, long paramLong1, byte[] paramArrayOfByte1, byte paramByte1, String paramString1, byte paramByte2, int paramInt2, int paramInt3, byte paramByte3, byte paramByte4, long paramLong2, String paramString2, String paramString3, byte[] paramArrayOfByte2, String paramString4, String paramString5, long paramLong3)
  {
    this.reqtype = paramInt1;
    this.uin = paramLong1;
    this.vecBody = paramArrayOfByte1;
    this.cCheckInGroup = paramByte1;
    this.sGroupLocation = paramString1;
    this.cStatOption = paramByte2;
    this.wSourceID = paramInt2;
    this.wSourceSubID = paramInt3;
    this.cIsSupportAuthQuestionJoin = paramByte3;
    this.cIfGetAuthInfo = paramByte4;
    this.dwDiscussUin = paramLong2;
    this.sJoinGroupKey = paramString2;
    this.sJoinGroupPicUrl = paramString3;
    this.vecJoinGroupRichMsg = paramArrayOfByte2;
    this.sJoinGroupAuth = paramString4;
    this.sJoinGroupVerifyToken = paramString5;
    this.dwJoinVerifyType = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqtype = paramJceInputStream.read(this.reqtype, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.vecBody = ((byte[])paramJceInputStream.read(cache_vecBody, 2, true));
    this.cCheckInGroup = paramJceInputStream.read(this.cCheckInGroup, 3, false);
    this.sGroupLocation = paramJceInputStream.readString(4, false);
    this.cStatOption = paramJceInputStream.read(this.cStatOption, 5, false);
    this.wSourceID = paramJceInputStream.read(this.wSourceID, 6, false);
    this.wSourceSubID = paramJceInputStream.read(this.wSourceSubID, 7, false);
    this.cIsSupportAuthQuestionJoin = paramJceInputStream.read(this.cIsSupportAuthQuestionJoin, 8, false);
    this.cIfGetAuthInfo = paramJceInputStream.read(this.cIfGetAuthInfo, 9, false);
    this.dwDiscussUin = paramJceInputStream.read(this.dwDiscussUin, 10, false);
    this.sJoinGroupKey = paramJceInputStream.readString(11, false);
    this.sJoinGroupPicUrl = paramJceInputStream.readString(12, false);
    this.vecJoinGroupRichMsg = ((byte[])paramJceInputStream.read(cache_vecJoinGroupRichMsg, 13, false));
    this.sJoinGroupAuth = paramJceInputStream.readString(14, false);
    this.sJoinGroupVerifyToken = paramJceInputStream.readString(15, false);
    this.dwJoinVerifyType = paramJceInputStream.read(this.dwJoinVerifyType, 16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqtype, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.vecBody, 2);
    paramJceOutputStream.write(this.cCheckInGroup, 3);
    if (this.sGroupLocation != null) {
      paramJceOutputStream.write(this.sGroupLocation, 4);
    }
    paramJceOutputStream.write(this.cStatOption, 5);
    paramJceOutputStream.write(this.wSourceID, 6);
    paramJceOutputStream.write(this.wSourceSubID, 7);
    paramJceOutputStream.write(this.cIsSupportAuthQuestionJoin, 8);
    paramJceOutputStream.write(this.cIfGetAuthInfo, 9);
    paramJceOutputStream.write(this.dwDiscussUin, 10);
    if (this.sJoinGroupKey != null) {
      paramJceOutputStream.write(this.sJoinGroupKey, 11);
    }
    if (this.sJoinGroupPicUrl != null) {
      paramJceOutputStream.write(this.sJoinGroupPicUrl, 12);
    }
    if (this.vecJoinGroupRichMsg != null) {
      paramJceOutputStream.write(this.vecJoinGroupRichMsg, 13);
    }
    if (this.sJoinGroupAuth != null) {
      paramJceOutputStream.write(this.sJoinGroupAuth, 14);
    }
    if (this.sJoinGroupVerifyToken != null) {
      paramJceOutputStream.write(this.sJoinGroupVerifyToken, 15);
    }
    paramJceOutputStream.write(this.dwJoinVerifyType, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.GroupMngReq
 * JD-Core Version:    0.7.0.1
 */