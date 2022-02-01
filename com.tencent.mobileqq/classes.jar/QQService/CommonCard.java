package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CommonCard
  extends JceStruct
{
  static int cache_eUserIdentityType;
  static byte[] cache_vBackground;
  static ArrayList<TagInfo> cache_vTags;
  public byte bSingle = 0;
  public int eUserIdentityType = UserIdentityType.UserIdentityType_Nomal.value();
  public int iFaceNum = 0;
  public int iQQLevel = 0;
  public long lFavoriteCount = 0L;
  public long lVisitCount = 0L;
  public long lVoteCount = 0L;
  public int nFaceID = 0;
  public short shAge = 0;
  public short shGender = 0;
  public String strCompany = "";
  public String strNick = "";
  public String strSchool = "";
  public String strSign = "";
  public int uFaceTimeStamp = 0;
  public byte[] vBackground = null;
  public ArrayList<TagInfo> vTags = null;
  
  public CommonCard() {}
  
  public CommonCard(String paramString1, short paramShort1, short paramShort2, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, byte paramByte, long paramLong1, long paramLong2, ArrayList<TagInfo> paramArrayList, int paramInt3, byte[] paramArrayOfByte, int paramInt4, long paramLong3, int paramInt5)
  {
    this.strNick = paramString1;
    this.shGender = paramShort1;
    this.shAge = paramShort2;
    this.nFaceID = paramInt1;
    this.strSign = paramString2;
    this.strCompany = paramString3;
    this.strSchool = paramString4;
    this.uFaceTimeStamp = paramInt2;
    this.bSingle = paramByte;
    this.lVisitCount = paramLong1;
    this.lVoteCount = paramLong2;
    this.vTags = paramArrayList;
    this.eUserIdentityType = paramInt3;
    this.vBackground = paramArrayOfByte;
    this.iFaceNum = paramInt4;
    this.lFavoriteCount = paramLong3;
    this.iQQLevel = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strNick = paramJceInputStream.readString(0, true);
    this.shGender = paramJceInputStream.read(this.shGender, 1, true);
    this.shAge = paramJceInputStream.read(this.shAge, 2, true);
    this.nFaceID = paramJceInputStream.read(this.nFaceID, 3, true);
    this.strSign = paramJceInputStream.readString(4, true);
    this.strCompany = paramJceInputStream.readString(5, true);
    this.strSchool = paramJceInputStream.readString(6, true);
    this.uFaceTimeStamp = paramJceInputStream.read(this.uFaceTimeStamp, 7, true);
    this.bSingle = paramJceInputStream.read(this.bSingle, 8, false);
    this.lVisitCount = paramJceInputStream.read(this.lVisitCount, 9, false);
    this.lVoteCount = paramJceInputStream.read(this.lVoteCount, 10, false);
    if (cache_vTags == null)
    {
      cache_vTags = new ArrayList();
      TagInfo localTagInfo = new TagInfo();
      cache_vTags.add(localTagInfo);
    }
    this.vTags = ((ArrayList)paramJceInputStream.read(cache_vTags, 11, false));
    this.eUserIdentityType = paramJceInputStream.read(this.eUserIdentityType, 12, false);
    if (cache_vBackground == null)
    {
      cache_vBackground = (byte[])new byte[1];
      ((byte[])cache_vBackground)[0] = 0;
    }
    this.vBackground = ((byte[])paramJceInputStream.read(cache_vBackground, 13, false));
    this.iFaceNum = paramJceInputStream.read(this.iFaceNum, 14, false);
    this.lFavoriteCount = paramJceInputStream.read(this.lFavoriteCount, 15, false);
    this.iQQLevel = paramJceInputStream.read(this.iQQLevel, 16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strNick, 0);
    paramJceOutputStream.write(this.shGender, 1);
    paramJceOutputStream.write(this.shAge, 2);
    paramJceOutputStream.write(this.nFaceID, 3);
    paramJceOutputStream.write(this.strSign, 4);
    paramJceOutputStream.write(this.strCompany, 5);
    paramJceOutputStream.write(this.strSchool, 6);
    paramJceOutputStream.write(this.uFaceTimeStamp, 7);
    paramJceOutputStream.write(this.bSingle, 8);
    paramJceOutputStream.write(this.lVisitCount, 9);
    paramJceOutputStream.write(this.lVoteCount, 10);
    if (this.vTags != null) {
      paramJceOutputStream.write(this.vTags, 11);
    }
    paramJceOutputStream.write(this.eUserIdentityType, 12);
    if (this.vBackground != null) {
      paramJceOutputStream.write(this.vBackground, 13);
    }
    paramJceOutputStream.write(this.iFaceNum, 14);
    paramJceOutputStream.write(this.lFavoriteCount, 15);
    paramJceOutputStream.write(this.iQQLevel, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.CommonCard
 * JD-Core Version:    0.7.0.1
 */