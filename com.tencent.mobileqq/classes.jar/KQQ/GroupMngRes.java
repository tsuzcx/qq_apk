package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupMngRes
  extends JceStruct
{
  static int cache_reqtype;
  static byte[] cache_vecBody = (byte[])new byte[1];
  static byte[] cache_vecJoinPrompt;
  static byte[] cache_vecKaiyangTransInfo;
  public String ErrorString = "";
  public byte cIsInGroup = 0;
  public byte cIsMemInvite = 0;
  public long dwDis2GrpLimitType = 0L;
  public short errorCode = 0;
  public int reqtype = 0;
  public byte result = 0;
  public String sAuthGrpInfo = "";
  public String sGroupLocation = "";
  public String sJoinAnswer = "";
  public String sJoinQuestion = "";
  public byte[] vecBody = null;
  public byte[] vecJoinPrompt = null;
  public byte[] vecKaiyangTransInfo = null;
  
  static
  {
    ((byte[])cache_vecBody)[0] = 0;
    cache_vecJoinPrompt = (byte[])new byte[1];
    ((byte[])cache_vecJoinPrompt)[0] = 0;
    cache_vecKaiyangTransInfo = (byte[])new byte[1];
    ((byte[])cache_vecKaiyangTransInfo)[0] = 0;
  }
  
  public GroupMngRes() {}
  
  public GroupMngRes(int paramInt, byte paramByte1, byte[] paramArrayOfByte1, String paramString1, short paramShort, byte paramByte2, String paramString2, byte paramByte3, String paramString3, String paramString4, String paramString5, long paramLong, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.reqtype = paramInt;
    this.result = paramByte1;
    this.vecBody = paramArrayOfByte1;
    this.ErrorString = paramString1;
    this.errorCode = paramShort;
    this.cIsInGroup = paramByte2;
    this.sGroupLocation = paramString2;
    this.cIsMemInvite = paramByte3;
    this.sAuthGrpInfo = paramString3;
    this.sJoinQuestion = paramString4;
    this.sJoinAnswer = paramString5;
    this.dwDis2GrpLimitType = paramLong;
    this.vecJoinPrompt = paramArrayOfByte2;
    this.vecKaiyangTransInfo = paramArrayOfByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqtype = paramJceInputStream.read(this.reqtype, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
    this.vecBody = ((byte[])paramJceInputStream.read(cache_vecBody, 2, true));
    this.ErrorString = paramJceInputStream.readString(3, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 4, false);
    this.cIsInGroup = paramJceInputStream.read(this.cIsInGroup, 5, false);
    this.sGroupLocation = paramJceInputStream.readString(6, false);
    this.cIsMemInvite = paramJceInputStream.read(this.cIsMemInvite, 7, false);
    this.sAuthGrpInfo = paramJceInputStream.readString(8, false);
    this.sJoinQuestion = paramJceInputStream.readString(9, false);
    this.sJoinAnswer = paramJceInputStream.readString(10, false);
    this.dwDis2GrpLimitType = paramJceInputStream.read(this.dwDis2GrpLimitType, 11, false);
    this.vecJoinPrompt = ((byte[])paramJceInputStream.read(cache_vecJoinPrompt, 12, false));
    this.vecKaiyangTransInfo = ((byte[])paramJceInputStream.read(cache_vecKaiyangTransInfo, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqtype, 0);
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.vecBody, 2);
    paramJceOutputStream.write(this.ErrorString, 3);
    paramJceOutputStream.write(this.errorCode, 4);
    paramJceOutputStream.write(this.cIsInGroup, 5);
    Object localObject = this.sGroupLocation;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.cIsMemInvite, 7);
    localObject = this.sAuthGrpInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.sJoinQuestion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.sJoinAnswer;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.dwDis2GrpLimitType, 11);
    localObject = this.vecJoinPrompt;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 12);
    }
    localObject = this.vecKaiyangTransInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQ.GroupMngRes
 * JD-Core Version:    0.7.0.1
 */