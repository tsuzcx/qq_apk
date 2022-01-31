package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GroupArea
  extends JceStruct
{
  static ArrayList<GroupInfo> cache_vGroupInfo;
  public long dwDistance;
  public long dwGroupStartIdx;
  public long dwGroupTotalCnt;
  public int iLat;
  public int iLon;
  public String strAreaName = "";
  public String strStreet = "";
  public ArrayList<GroupInfo> vGroupInfo;
  
  public GroupArea() {}
  
  public GroupArea(String paramString1, int paramInt1, int paramInt2, long paramLong1, ArrayList<GroupInfo> paramArrayList, long paramLong2, long paramLong3, String paramString2)
  {
    this.strAreaName = paramString1;
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.dwGroupStartIdx = paramLong1;
    this.vGroupInfo = paramArrayList;
    this.dwGroupTotalCnt = paramLong2;
    this.dwDistance = paramLong3;
    this.strStreet = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strAreaName = paramJceInputStream.readString(0, true);
    this.iLat = paramJceInputStream.read(this.iLat, 1, true);
    this.iLon = paramJceInputStream.read(this.iLon, 2, true);
    this.dwGroupStartIdx = paramJceInputStream.read(this.dwGroupStartIdx, 3, false);
    if (cache_vGroupInfo == null)
    {
      cache_vGroupInfo = new ArrayList();
      GroupInfo localGroupInfo = new GroupInfo();
      cache_vGroupInfo.add(localGroupInfo);
    }
    this.vGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vGroupInfo, 4, false));
    this.dwGroupTotalCnt = paramJceInputStream.read(this.dwGroupTotalCnt, 5, true);
    this.dwDistance = paramJceInputStream.read(this.dwDistance, 6, false);
    this.strStreet = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strAreaName, 0);
    paramJceOutputStream.write(this.iLat, 1);
    paramJceOutputStream.write(this.iLon, 2);
    paramJceOutputStream.write(this.dwGroupStartIdx, 3);
    if (this.vGroupInfo != null) {
      paramJceOutputStream.write(this.vGroupInfo, 4);
    }
    paramJceOutputStream.write(this.dwGroupTotalCnt, 5);
    paramJceOutputStream.write(this.dwDistance, 6);
    if (this.strStreet != null) {
      paramJceOutputStream.write(this.strStreet, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NearbyGroup.GroupArea
 * JD-Core Version:    0.7.0.1
 */