package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespHYCommonCard
  extends JceStruct
{
  static CommonCard cache_stCommonCard;
  static RespHead cache_stHeader;
  static ArrayList cache_vFaceInfo;
  static byte[] cache_vQQFaceID;
  public byte bFavorited;
  public byte bQzoneInfo;
  public byte bShareLBS;
  public byte bVoted;
  public byte bWeiboInfo;
  public byte cSqqLevel;
  public CommonCard stCommonCard;
  public RespHead stHeader;
  public String strReMark = "";
  public ArrayList vFaceInfo;
  public byte[] vQQFaceID;
  
  public RespHYCommonCard() {}
  
  public RespHYCommonCard(RespHead paramRespHead, CommonCard paramCommonCard, String paramString, byte paramByte1, byte paramByte2, ArrayList paramArrayList, byte paramByte3, byte paramByte4, byte paramByte5, byte[] paramArrayOfByte, byte paramByte6)
  {
    this.stHeader = paramRespHead;
    this.stCommonCard = paramCommonCard;
    this.strReMark = paramString;
    this.bWeiboInfo = paramByte1;
    this.bQzoneInfo = paramByte2;
    this.vFaceInfo = paramArrayList;
    this.bVoted = paramByte3;
    this.bFavorited = paramByte4;
    this.bShareLBS = paramByte5;
    this.vQQFaceID = paramArrayOfByte;
    this.cSqqLevel = paramByte6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stCommonCard == null) {
      cache_stCommonCard = new CommonCard();
    }
    this.stCommonCard = ((CommonCard)paramJceInputStream.read(cache_stCommonCard, 1, true));
    this.strReMark = paramJceInputStream.readString(2, true);
    this.bWeiboInfo = paramJceInputStream.read(this.bWeiboInfo, 3, true);
    this.bQzoneInfo = paramJceInputStream.read(this.bQzoneInfo, 4, true);
    if (cache_vFaceInfo == null)
    {
      cache_vFaceInfo = new ArrayList();
      FaceInfo localFaceInfo = new FaceInfo();
      cache_vFaceInfo.add(localFaceInfo);
    }
    this.vFaceInfo = ((ArrayList)paramJceInputStream.read(cache_vFaceInfo, 5, false));
    this.bVoted = paramJceInputStream.read(this.bVoted, 6, false);
    this.bFavorited = paramJceInputStream.read(this.bFavorited, 7, false);
    this.bShareLBS = paramJceInputStream.read(this.bShareLBS, 8, false);
    if (cache_vQQFaceID == null)
    {
      cache_vQQFaceID = (byte[])new byte[1];
      ((byte[])cache_vQQFaceID)[0] = 0;
    }
    this.vQQFaceID = ((byte[])paramJceInputStream.read(cache_vQQFaceID, 9, false));
    this.cSqqLevel = paramJceInputStream.read(this.cSqqLevel, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stCommonCard, 1);
    paramJceOutputStream.write(this.strReMark, 2);
    paramJceOutputStream.write(this.bWeiboInfo, 3);
    paramJceOutputStream.write(this.bQzoneInfo, 4);
    if (this.vFaceInfo != null) {
      paramJceOutputStream.write(this.vFaceInfo, 5);
    }
    paramJceOutputStream.write(this.bVoted, 6);
    paramJceOutputStream.write(this.bFavorited, 7);
    paramJceOutputStream.write(this.bShareLBS, 8);
    if (this.vQQFaceID != null) {
      paramJceOutputStream.write(this.vQQFaceID, 9);
    }
    paramJceOutputStream.write(this.cSqqLevel, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QQService.RespHYCommonCard
 * JD-Core Version:    0.7.0.1
 */