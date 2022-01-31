package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupMngReq
  extends JceStruct
{
  static int cache_reqtype;
  static byte[] cache_vecBody;
  static byte[] cache_vecJoinGroupRichMsg;
  public byte cCheckInGroup;
  public byte cIfGetAuthInfo;
  public byte cIsSupportAuthQuestionJoin;
  public byte cStatOption;
  public long dwDiscussUin;
  public int reqtype;
  public String sGroupLocation = "";
  public String sJoinGroupKey = "";
  public String sJoinGroupPicUrl = "";
  public long uin;
  public byte[] vecBody;
  public byte[] vecJoinGroupRichMsg;
  public int wSourceID;
  public int wSourceSubID;
  
  public String className()
  {
    return "KQQ.GroupMngReq";
  }
  
  public String fullClassName()
  {
    return "KQQ.GroupMngReq";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqtype = paramJceInputStream.read(this.reqtype, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    if (cache_vecBody == null)
    {
      cache_vecBody = (byte[])new byte[1];
      ((byte[])cache_vecBody)[0] = 0;
    }
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
    if (cache_vecJoinGroupRichMsg == null)
    {
      cache_vecJoinGroupRichMsg = (byte[])new byte[1];
      ((byte[])cache_vecJoinGroupRichMsg)[0] = 0;
    }
    this.vecJoinGroupRichMsg = ((byte[])paramJceInputStream.read(cache_vecJoinGroupRichMsg, 13, false));
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     KQQ.GroupMngReq
 * JD-Core Version:    0.7.0.1
 */