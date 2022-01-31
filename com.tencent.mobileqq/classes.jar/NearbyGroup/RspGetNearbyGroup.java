package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RspGetNearbyGroup
  extends JceStruct
{
  static int cache_eReplyCode;
  static RspActivity cache_stRspAct;
  static RspHotGrp cache_stRspHotGrp;
  static RspTopic cache_stRspTopic;
  static ArrayList<Activity> cache_vActivity;
  static byte[] cache_vContext;
  static ArrayList<GroupArea> cache_vGroupArea;
  static ArrayList<GroupInfo> cache_vGroupInfo;
  static ArrayList<XiaoQuInfo> cache_vXiaoQuInfo;
  public short dwFlag;
  public int eReplyCode;
  public int iCompletedFlag;
  public int iLat;
  public int iLon;
  public int iRadius;
  public short shSortType;
  public RspActivity stRspAct;
  public RspHotGrp stRspHotGrp;
  public RspTopic stRspTopic;
  public String strCity = "";
  public String strCityCode = "";
  public ArrayList<Activity> vActivity;
  public byte[] vContext;
  public ArrayList<GroupArea> vGroupArea;
  public ArrayList<GroupInfo> vGroupInfo;
  public ArrayList<XiaoQuInfo> vXiaoQuInfo;
  
  public RspGetNearbyGroup() {}
  
  public RspGetNearbyGroup(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, ArrayList<GroupInfo> paramArrayList, ArrayList<XiaoQuInfo> paramArrayList1, ArrayList<Activity> paramArrayList2, ArrayList<GroupArea> paramArrayList3, short paramShort1, int paramInt4, int paramInt5, RspHotGrp paramRspHotGrp, RspActivity paramRspActivity, RspTopic paramRspTopic, String paramString1, String paramString2, short paramShort2)
  {
    this.eReplyCode = paramInt1;
    this.vContext = paramArrayOfByte;
    this.iCompletedFlag = paramInt2;
    this.iRadius = paramInt3;
    this.vGroupInfo = paramArrayList;
    this.vXiaoQuInfo = paramArrayList1;
    this.vActivity = paramArrayList2;
    this.vGroupArea = paramArrayList3;
    this.shSortType = paramShort1;
    this.iLat = paramInt4;
    this.iLon = paramInt5;
    this.stRspHotGrp = paramRspHotGrp;
    this.stRspAct = paramRspActivity;
    this.stRspTopic = paramRspTopic;
    this.strCity = paramString1;
    this.strCityCode = paramString2;
    this.dwFlag = paramShort2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.eReplyCode = paramJceInputStream.read(this.eReplyCode, 0, true);
    if (cache_vContext == null)
    {
      cache_vContext = (byte[])new byte[1];
      ((byte[])cache_vContext)[0] = 0;
    }
    this.vContext = ((byte[])paramJceInputStream.read(cache_vContext, 1, false));
    this.iCompletedFlag = paramJceInputStream.read(this.iCompletedFlag, 2, true);
    this.iRadius = paramJceInputStream.read(this.iRadius, 3, false);
    Object localObject;
    if (cache_vGroupInfo == null)
    {
      cache_vGroupInfo = new ArrayList();
      localObject = new GroupInfo();
      cache_vGroupInfo.add(localObject);
    }
    this.vGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vGroupInfo, 4, false));
    if (cache_vXiaoQuInfo == null)
    {
      cache_vXiaoQuInfo = new ArrayList();
      localObject = new XiaoQuInfo();
      cache_vXiaoQuInfo.add(localObject);
    }
    this.vXiaoQuInfo = ((ArrayList)paramJceInputStream.read(cache_vXiaoQuInfo, 5, false));
    if (cache_vActivity == null)
    {
      cache_vActivity = new ArrayList();
      localObject = new Activity();
      cache_vActivity.add(localObject);
    }
    this.vActivity = ((ArrayList)paramJceInputStream.read(cache_vActivity, 6, false));
    if (cache_vGroupArea == null)
    {
      cache_vGroupArea = new ArrayList();
      localObject = new GroupArea();
      cache_vGroupArea.add(localObject);
    }
    this.vGroupArea = ((ArrayList)paramJceInputStream.read(cache_vGroupArea, 7, false));
    this.shSortType = paramJceInputStream.read(this.shSortType, 8, false);
    this.iLat = paramJceInputStream.read(this.iLat, 9, false);
    this.iLon = paramJceInputStream.read(this.iLon, 10, false);
    if (cache_stRspHotGrp == null) {
      cache_stRspHotGrp = new RspHotGrp();
    }
    this.stRspHotGrp = ((RspHotGrp)paramJceInputStream.read(cache_stRspHotGrp, 11, false));
    if (cache_stRspAct == null) {
      cache_stRspAct = new RspActivity();
    }
    this.stRspAct = ((RspActivity)paramJceInputStream.read(cache_stRspAct, 12, false));
    if (cache_stRspTopic == null) {
      cache_stRspTopic = new RspTopic();
    }
    this.stRspTopic = ((RspTopic)paramJceInputStream.read(cache_stRspTopic, 13, false));
    this.strCity = paramJceInputStream.readString(14, false);
    this.strCityCode = paramJceInputStream.readString(15, false);
    this.dwFlag = paramJceInputStream.read(this.dwFlag, 16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.eReplyCode, 0);
    if (this.vContext != null) {
      paramJceOutputStream.write(this.vContext, 1);
    }
    paramJceOutputStream.write(this.iCompletedFlag, 2);
    paramJceOutputStream.write(this.iRadius, 3);
    if (this.vGroupInfo != null) {
      paramJceOutputStream.write(this.vGroupInfo, 4);
    }
    if (this.vXiaoQuInfo != null) {
      paramJceOutputStream.write(this.vXiaoQuInfo, 5);
    }
    if (this.vActivity != null) {
      paramJceOutputStream.write(this.vActivity, 6);
    }
    if (this.vGroupArea != null) {
      paramJceOutputStream.write(this.vGroupArea, 7);
    }
    paramJceOutputStream.write(this.shSortType, 8);
    paramJceOutputStream.write(this.iLat, 9);
    paramJceOutputStream.write(this.iLon, 10);
    if (this.stRspHotGrp != null) {
      paramJceOutputStream.write(this.stRspHotGrp, 11);
    }
    if (this.stRspAct != null) {
      paramJceOutputStream.write(this.stRspAct, 12);
    }
    if (this.stRspTopic != null) {
      paramJceOutputStream.write(this.stRspTopic, 13);
    }
    if (this.strCity != null) {
      paramJceOutputStream.write(this.strCity, 14);
    }
    if (this.strCityCode != null) {
      paramJceOutputStream.write(this.strCityCode, 15);
    }
    paramJceOutputStream.write(this.dwFlag, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NearbyGroup.RspGetNearbyGroup
 * JD-Core Version:    0.7.0.1
 */