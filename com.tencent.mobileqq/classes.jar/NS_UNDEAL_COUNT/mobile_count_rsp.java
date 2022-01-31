package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_count_rsp
  extends JceStruct
{
  static Map<Long, s_comm_data> cache_mapBuf;
  static Map<Long, Long> cache_mapLastGetTime;
  static master_info cache_masterinfo = new master_info();
  static single_count cache_stActiveCount;
  static single_count cache_stAppCount;
  static ban_info cache_stBanInfo;
  static birth_info cache_stBirthInfo;
  static single_count cache_stFlower;
  static single_count cache_stFriendReqCount;
  static single_count cache_stFriendsBirthdayCount;
  static single_count cache_stGameBarInfo;
  static single_count cache_stHappyRoom;
  static single_count cache_stMainPageCount;
  static master_info cache_stMasterInfo;
  static medal_info cache_stMedalInfo;
  static single_count cache_stPassiveCount = new single_count();
  static single_count cache_stPersionalInfo;
  static single_count cache_stQzoneVipInfo;
  static single_count cache_stReadSpace;
  static single_count cache_stSecretInfo;
  static single_count cache_stSecretPavInfo;
  static single_count cache_stSubscribeAlbum;
  static single_count cache_stVisitReqInfo;
  static single_count cache_stVisitorCount;
  static yellow_info cache_stYellowInfo;
  static single_count cache_stZebraAppInfo;
  static ArrayList<operat_data> cache_vecOperateInfo;
  static ArrayList<feed_host_info> cache_vecUpdateFeedFriendsList;
  static ArrayList<feed_host_info> cache_vecUpdatePassiveList;
  public long busiFlag;
  public int iNextTimeout;
  public Map<Long, s_comm_data> mapBuf;
  public Map<Long, Long> mapLastGetTime;
  public master_info masterinfo;
  public single_count stActiveCount;
  public single_count stAppCount;
  public ban_info stBanInfo;
  public birth_info stBirthInfo;
  public single_count stFlower;
  public single_count stFriendReqCount;
  public single_count stFriendsBirthdayCount;
  public single_count stGameBarInfo;
  public single_count stHappyRoom;
  public single_count stMainPageCount;
  public master_info stMasterInfo;
  public medal_info stMedalInfo;
  public single_count stPassiveCount;
  public single_count stPersionalInfo;
  public single_count stQzoneVipInfo;
  public single_count stReadSpace;
  public single_count stSecretInfo;
  public single_count stSecretPavInfo;
  public single_count stSubscribeAlbum;
  public single_count stVisitReqInfo;
  public single_count stVisitorCount;
  public yellow_info stYellowInfo;
  public single_count stZebraAppInfo;
  public String strDeviceName = "";
  public String strNick = "";
  public long uRspMask;
  public ArrayList<operat_data> vecOperateInfo;
  public ArrayList<feed_host_info> vecUpdateFeedFriendsList;
  public ArrayList<feed_host_info> vecUpdatePassiveList;
  
  static
  {
    cache_stActiveCount = new single_count();
    cache_stVisitorCount = new single_count();
    cache_stFriendReqCount = new single_count();
    cache_stBanInfo = new ban_info();
    cache_stBirthInfo = new birth_info();
    cache_stAppCount = new single_count();
    cache_stFriendsBirthdayCount = new single_count();
    cache_stMainPageCount = new single_count();
    cache_stYellowInfo = new yellow_info();
    cache_vecUpdateFeedFriendsList = new ArrayList();
    Object localObject = new feed_host_info();
    cache_vecUpdateFeedFriendsList.add(localObject);
    cache_vecUpdatePassiveList = new ArrayList();
    localObject = new feed_host_info();
    cache_vecUpdatePassiveList.add(localObject);
    cache_stReadSpace = new single_count();
    cache_stFlower = new single_count();
    cache_stSubscribeAlbum = new single_count();
    cache_mapBuf = new HashMap();
    localObject = new s_comm_data();
    cache_mapBuf.put(Long.valueOf(0L), localObject);
    cache_stGameBarInfo = new single_count();
    cache_stPersionalInfo = new single_count();
    cache_stQzoneVipInfo = new single_count();
    cache_stVisitReqInfo = new single_count();
    cache_stSecretInfo = new single_count();
    cache_stHappyRoom = new single_count();
    cache_stMasterInfo = new master_info();
    cache_vecOperateInfo = new ArrayList();
    localObject = new operat_data();
    cache_vecOperateInfo.add(localObject);
    cache_stZebraAppInfo = new single_count();
    cache_stSecretPavInfo = new single_count();
    cache_mapLastGetTime = new HashMap();
    cache_mapLastGetTime.put(Long.valueOf(0L), Long.valueOf(0L));
    cache_stMedalInfo = new medal_info();
  }
  
  public mobile_count_rsp() {}
  
  public mobile_count_rsp(single_count paramsingle_count1, single_count paramsingle_count2, single_count paramsingle_count3, single_count paramsingle_count4, long paramLong1, ban_info paramban_info, birth_info parambirth_info, String paramString1, single_count paramsingle_count5, int paramInt, single_count paramsingle_count6, single_count paramsingle_count7, yellow_info paramyellow_info, ArrayList<feed_host_info> paramArrayList1, String paramString2, ArrayList<feed_host_info> paramArrayList2, single_count paramsingle_count8, single_count paramsingle_count9, single_count paramsingle_count10, Map<Long, s_comm_data> paramMap, single_count paramsingle_count11, single_count paramsingle_count12, single_count paramsingle_count13, single_count paramsingle_count14, single_count paramsingle_count15, single_count paramsingle_count16, master_info parammaster_info1, ArrayList<operat_data> paramArrayList, single_count paramsingle_count17, single_count paramsingle_count18, Map<Long, Long> paramMap1, medal_info parammedal_info, long paramLong2, master_info parammaster_info2)
  {
    this.stPassiveCount = paramsingle_count1;
    this.stActiveCount = paramsingle_count2;
    this.stVisitorCount = paramsingle_count3;
    this.stFriendReqCount = paramsingle_count4;
    this.uRspMask = paramLong1;
    this.stBanInfo = paramban_info;
    this.stBirthInfo = parambirth_info;
    this.strNick = paramString1;
    this.stAppCount = paramsingle_count5;
    this.iNextTimeout = paramInt;
    this.stFriendsBirthdayCount = paramsingle_count6;
    this.stMainPageCount = paramsingle_count7;
    this.stYellowInfo = paramyellow_info;
    this.vecUpdateFeedFriendsList = paramArrayList1;
    this.strDeviceName = paramString2;
    this.vecUpdatePassiveList = paramArrayList2;
    this.stReadSpace = paramsingle_count8;
    this.stFlower = paramsingle_count9;
    this.stSubscribeAlbum = paramsingle_count10;
    this.mapBuf = paramMap;
    this.stGameBarInfo = paramsingle_count11;
    this.stPersionalInfo = paramsingle_count12;
    this.stQzoneVipInfo = paramsingle_count13;
    this.stVisitReqInfo = paramsingle_count14;
    this.stSecretInfo = paramsingle_count15;
    this.stHappyRoom = paramsingle_count16;
    this.stMasterInfo = parammaster_info1;
    this.vecOperateInfo = paramArrayList;
    this.stZebraAppInfo = paramsingle_count17;
    this.stSecretPavInfo = paramsingle_count18;
    this.mapLastGetTime = paramMap1;
    this.stMedalInfo = parammedal_info;
    this.busiFlag = paramLong2;
    this.masterinfo = parammaster_info2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stPassiveCount = ((single_count)paramJceInputStream.read(cache_stPassiveCount, 0, false));
    this.stActiveCount = ((single_count)paramJceInputStream.read(cache_stActiveCount, 1, false));
    this.stVisitorCount = ((single_count)paramJceInputStream.read(cache_stVisitorCount, 2, false));
    this.stFriendReqCount = ((single_count)paramJceInputStream.read(cache_stFriendReqCount, 3, false));
    this.uRspMask = paramJceInputStream.read(this.uRspMask, 4, false);
    this.stBanInfo = ((ban_info)paramJceInputStream.read(cache_stBanInfo, 5, false));
    this.stBirthInfo = ((birth_info)paramJceInputStream.read(cache_stBirthInfo, 6, false));
    this.strNick = paramJceInputStream.readString(7, false);
    this.stAppCount = ((single_count)paramJceInputStream.read(cache_stAppCount, 8, false));
    this.iNextTimeout = paramJceInputStream.read(this.iNextTimeout, 9, false);
    this.stFriendsBirthdayCount = ((single_count)paramJceInputStream.read(cache_stFriendsBirthdayCount, 10, false));
    this.stMainPageCount = ((single_count)paramJceInputStream.read(cache_stMainPageCount, 11, false));
    this.stYellowInfo = ((yellow_info)paramJceInputStream.read(cache_stYellowInfo, 12, false));
    this.vecUpdateFeedFriendsList = ((ArrayList)paramJceInputStream.read(cache_vecUpdateFeedFriendsList, 13, false));
    this.strDeviceName = paramJceInputStream.readString(14, false);
    this.vecUpdatePassiveList = ((ArrayList)paramJceInputStream.read(cache_vecUpdatePassiveList, 15, false));
    this.stReadSpace = ((single_count)paramJceInputStream.read(cache_stReadSpace, 16, false));
    this.stFlower = ((single_count)paramJceInputStream.read(cache_stFlower, 17, false));
    this.stSubscribeAlbum = ((single_count)paramJceInputStream.read(cache_stSubscribeAlbum, 18, false));
    this.mapBuf = ((Map)paramJceInputStream.read(cache_mapBuf, 19, false));
    this.stGameBarInfo = ((single_count)paramJceInputStream.read(cache_stGameBarInfo, 20, false));
    this.stPersionalInfo = ((single_count)paramJceInputStream.read(cache_stPersionalInfo, 21, false));
    this.stQzoneVipInfo = ((single_count)paramJceInputStream.read(cache_stQzoneVipInfo, 22, false));
    this.stVisitReqInfo = ((single_count)paramJceInputStream.read(cache_stVisitReqInfo, 23, false));
    this.stSecretInfo = ((single_count)paramJceInputStream.read(cache_stSecretInfo, 24, false));
    this.stHappyRoom = ((single_count)paramJceInputStream.read(cache_stHappyRoom, 25, false));
    this.stMasterInfo = ((master_info)paramJceInputStream.read(cache_stMasterInfo, 26, false));
    this.vecOperateInfo = ((ArrayList)paramJceInputStream.read(cache_vecOperateInfo, 27, false));
    this.stZebraAppInfo = ((single_count)paramJceInputStream.read(cache_stZebraAppInfo, 28, false));
    this.stSecretPavInfo = ((single_count)paramJceInputStream.read(cache_stSecretPavInfo, 29, false));
    this.mapLastGetTime = ((Map)paramJceInputStream.read(cache_mapLastGetTime, 30, false));
    this.stMedalInfo = ((medal_info)paramJceInputStream.read(cache_stMedalInfo, 31, false));
    this.busiFlag = paramJceInputStream.read(this.busiFlag, 32, false);
    this.masterinfo = ((master_info)paramJceInputStream.read(cache_masterinfo, 33, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stPassiveCount != null) {
      paramJceOutputStream.write(this.stPassiveCount, 0);
    }
    if (this.stActiveCount != null) {
      paramJceOutputStream.write(this.stActiveCount, 1);
    }
    if (this.stVisitorCount != null) {
      paramJceOutputStream.write(this.stVisitorCount, 2);
    }
    if (this.stFriendReqCount != null) {
      paramJceOutputStream.write(this.stFriendReqCount, 3);
    }
    paramJceOutputStream.write(this.uRspMask, 4);
    if (this.stBanInfo != null) {
      paramJceOutputStream.write(this.stBanInfo, 5);
    }
    if (this.stBirthInfo != null) {
      paramJceOutputStream.write(this.stBirthInfo, 6);
    }
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 7);
    }
    if (this.stAppCount != null) {
      paramJceOutputStream.write(this.stAppCount, 8);
    }
    paramJceOutputStream.write(this.iNextTimeout, 9);
    if (this.stFriendsBirthdayCount != null) {
      paramJceOutputStream.write(this.stFriendsBirthdayCount, 10);
    }
    if (this.stMainPageCount != null) {
      paramJceOutputStream.write(this.stMainPageCount, 11);
    }
    if (this.stYellowInfo != null) {
      paramJceOutputStream.write(this.stYellowInfo, 12);
    }
    if (this.vecUpdateFeedFriendsList != null) {
      paramJceOutputStream.write(this.vecUpdateFeedFriendsList, 13);
    }
    if (this.strDeviceName != null) {
      paramJceOutputStream.write(this.strDeviceName, 14);
    }
    if (this.vecUpdatePassiveList != null) {
      paramJceOutputStream.write(this.vecUpdatePassiveList, 15);
    }
    if (this.stReadSpace != null) {
      paramJceOutputStream.write(this.stReadSpace, 16);
    }
    if (this.stFlower != null) {
      paramJceOutputStream.write(this.stFlower, 17);
    }
    if (this.stSubscribeAlbum != null) {
      paramJceOutputStream.write(this.stSubscribeAlbum, 18);
    }
    if (this.mapBuf != null) {
      paramJceOutputStream.write(this.mapBuf, 19);
    }
    if (this.stGameBarInfo != null) {
      paramJceOutputStream.write(this.stGameBarInfo, 20);
    }
    if (this.stPersionalInfo != null) {
      paramJceOutputStream.write(this.stPersionalInfo, 21);
    }
    if (this.stQzoneVipInfo != null) {
      paramJceOutputStream.write(this.stQzoneVipInfo, 22);
    }
    if (this.stVisitReqInfo != null) {
      paramJceOutputStream.write(this.stVisitReqInfo, 23);
    }
    if (this.stSecretInfo != null) {
      paramJceOutputStream.write(this.stSecretInfo, 24);
    }
    if (this.stHappyRoom != null) {
      paramJceOutputStream.write(this.stHappyRoom, 25);
    }
    if (this.stMasterInfo != null) {
      paramJceOutputStream.write(this.stMasterInfo, 26);
    }
    if (this.vecOperateInfo != null) {
      paramJceOutputStream.write(this.vecOperateInfo, 27);
    }
    if (this.stZebraAppInfo != null) {
      paramJceOutputStream.write(this.stZebraAppInfo, 28);
    }
    if (this.stSecretPavInfo != null) {
      paramJceOutputStream.write(this.stSecretPavInfo, 29);
    }
    if (this.mapLastGetTime != null) {
      paramJceOutputStream.write(this.mapLastGetTime, 30);
    }
    if (this.stMedalInfo != null) {
      paramJceOutputStream.write(this.stMedalInfo, 31);
    }
    paramJceOutputStream.write(this.busiFlag, 32);
    if (this.masterinfo != null) {
      paramJceOutputStream.write(this.masterinfo, 33);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_count_rsp
 * JD-Core Version:    0.7.0.1
 */