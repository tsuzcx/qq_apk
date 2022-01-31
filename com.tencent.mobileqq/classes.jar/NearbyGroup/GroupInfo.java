package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GroupInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList<GroupLabel> cache_labels = new ArrayList();
  public boolean bAlive = true;
  public boolean bIsNew;
  public long dwCertType;
  public long dwExtFlag;
  public long dwGroupActiveGrade;
  public long dwGroupFlagExt;
  public int iDistance;
  public int iFaceId;
  public int iLat = 900000000;
  public int iLon = 900000000;
  public int iMemberCnt;
  public int iOnlineMemberCnt;
  public long lCode;
  public long lCreator;
  public long lUin;
  public ArrayList<GroupLabel> labels;
  public String strIntro = "";
  public String strJoinAuth = "";
  public String strJoinSig = "";
  public String strLocation = "";
  public String strName = "";
  
  static
  {
    GroupLabel localGroupLabel = new GroupLabel();
    cache_labels.add(localGroupLabel);
  }
  
  public GroupInfo() {}
  
  public GroupInfo(long paramLong1, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, long paramLong2, int paramInt5, int paramInt6, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean2, long paramLong6, long paramLong7, ArrayList<GroupLabel> paramArrayList, String paramString4, String paramString5)
  {
    this.lCode = paramLong1;
    this.strName = paramString1;
    this.strLocation = paramString2;
    this.iMemberCnt = paramInt1;
    this.strIntro = paramString3;
    this.iFaceId = paramInt2;
    this.bAlive = paramBoolean1;
    this.iDistance = paramInt3;
    this.iOnlineMemberCnt = paramInt4;
    this.dwGroupFlagExt = paramLong2;
    this.iLat = paramInt5;
    this.iLon = paramInt6;
    this.lUin = paramLong3;
    this.dwCertType = paramLong4;
    this.dwGroupActiveGrade = paramLong5;
    this.bIsNew = paramBoolean2;
    this.lCreator = paramLong6;
    this.dwExtFlag = paramLong7;
    this.labels = paramArrayList;
    this.strJoinAuth = paramString4;
    this.strJoinSig = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lCode = paramJceInputStream.read(this.lCode, 0, true);
    this.strName = paramJceInputStream.readString(1, true);
    this.strLocation = paramJceInputStream.readString(2, true);
    this.iMemberCnt = paramJceInputStream.read(this.iMemberCnt, 3, true);
    this.strIntro = paramJceInputStream.readString(4, true);
    this.iFaceId = paramJceInputStream.read(this.iFaceId, 5, true);
    this.bAlive = paramJceInputStream.read(this.bAlive, 6, true);
    this.iDistance = paramJceInputStream.read(this.iDistance, 7, false);
    this.iOnlineMemberCnt = paramJceInputStream.read(this.iOnlineMemberCnt, 8, false);
    this.dwGroupFlagExt = paramJceInputStream.read(this.dwGroupFlagExt, 9, false);
    this.iLat = paramJceInputStream.read(this.iLat, 10, false);
    this.iLon = paramJceInputStream.read(this.iLon, 11, false);
    this.lUin = paramJceInputStream.read(this.lUin, 12, false);
    this.dwCertType = paramJceInputStream.read(this.dwCertType, 13, false);
    this.dwGroupActiveGrade = paramJceInputStream.read(this.dwGroupActiveGrade, 14, false);
    this.bIsNew = paramJceInputStream.read(this.bIsNew, 15, false);
    this.lCreator = paramJceInputStream.read(this.lCreator, 16, false);
    this.dwExtFlag = paramJceInputStream.read(this.dwExtFlag, 17, false);
    this.labels = ((ArrayList)paramJceInputStream.read(cache_labels, 18, false));
    this.strJoinAuth = paramJceInputStream.readString(19, false);
    this.strJoinSig = paramJceInputStream.readString(20, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lCode, 0);
    paramJceOutputStream.write(this.strName, 1);
    paramJceOutputStream.write(this.strLocation, 2);
    paramJceOutputStream.write(this.iMemberCnt, 3);
    paramJceOutputStream.write(this.strIntro, 4);
    paramJceOutputStream.write(this.iFaceId, 5);
    paramJceOutputStream.write(this.bAlive, 6);
    paramJceOutputStream.write(this.iDistance, 7);
    paramJceOutputStream.write(this.iOnlineMemberCnt, 8);
    paramJceOutputStream.write(this.dwGroupFlagExt, 9);
    paramJceOutputStream.write(this.iLat, 10);
    paramJceOutputStream.write(this.iLon, 11);
    paramJceOutputStream.write(this.lUin, 12);
    paramJceOutputStream.write(this.dwCertType, 13);
    paramJceOutputStream.write(this.dwGroupActiveGrade, 14);
    paramJceOutputStream.write(this.bIsNew, 15);
    paramJceOutputStream.write(this.lCreator, 16);
    paramJceOutputStream.write(this.dwExtFlag, 17);
    if (this.labels != null) {
      paramJceOutputStream.write(this.labels, 18);
    }
    if (this.strJoinAuth != null) {
      paramJceOutputStream.write(this.strJoinAuth, 19);
    }
    if (this.strJoinSig != null) {
      paramJceOutputStream.write(this.strJoinSig, 20);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NearbyGroup.GroupInfo
 * JD-Core Version:    0.7.0.1
 */