package EncounterSvc;

import NeighborComm.EctFragmentation;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class RespGetEncounterV2
  extends JceStruct
{
  static byte[] cache_NearRankingsResp;
  static byte[] cache_NewUserAreaResp;
  static RecommEncounterInfo cache_RecommEncounters = new RecommEncounterInfo();
  static ArrayList<NeighborAd> cache_ad_list;
  static AlumnusConfigInfo cache_alumnus_conf;
  static ArrayList<EntranceContent> cache_entrance_list;
  static byte[] cache_nearbyGroupResp;
  static byte[] cache_nearbyPublicAcctResp;
  static ArrayList<NeighborBanner> cache_neighbor_banners;
  static SelfInfo cache_self_info;
  static EctFragmentation cache_stEctFmt;
  static PengYouInfo cache_stPYInfo;
  static UserDetailLocalInfo cache_stUDLinfo;
  static UserData cache_stUserData = new UserData();
  static ArrayList<RespEncounterInfo> cache_vEncounterInfos = new ArrayList();
  public byte[] NearRankingsResp = null;
  public byte[] NewUserAreaResp = null;
  public byte RankingFlag = 0;
  public RecommEncounterInfo RecommEncounters = null;
  public long RespTime = 0L;
  public ArrayList<NeighborAd> ad_list = null;
  public AlumnusConfigInfo alumnus_conf = null;
  public byte can_add_sub_interest = 0;
  public ArrayList<EntranceContent> entrance_list = null;
  public int iEncounterNumber = 0;
  public int iSessionTotalNumber = 0;
  public byte[] nearbyGroupResp = null;
  public byte[] nearbyPublicAcctResp = null;
  public ArrayList<NeighborBanner> neighbor_banners = null;
  public SelfInfo self_info = null;
  public EctFragmentation stEctFmt = null;
  public PengYouInfo stPYInfo = null;
  public UserDetailLocalInfo stUDLinfo = null;
  public UserData stUserData = null;
  public String strSecurityDetailUrl = "";
  public String strSecurityTips = "";
  public byte system_pic = 0;
  public byte useInterestTag = 0;
  public ArrayList<RespEncounterInfo> vEncounterInfos = null;
  public byte watch_color = 0;
  
  static
  {
    Object localObject = new RespEncounterInfo();
    cache_vEncounterInfos.add(localObject);
    cache_stUDLinfo = new UserDetailLocalInfo();
    cache_stPYInfo = new PengYouInfo();
    cache_stEctFmt = new EctFragmentation();
    cache_nearbyGroupResp = (byte[])new byte[1];
    ((byte[])cache_nearbyGroupResp)[0] = 0;
    cache_nearbyPublicAcctResp = (byte[])new byte[1];
    ((byte[])cache_nearbyPublicAcctResp)[0] = 0;
    cache_entrance_list = new ArrayList();
    localObject = new EntranceContent();
    cache_entrance_list.add(localObject);
    cache_neighbor_banners = new ArrayList();
    localObject = new NeighborBanner();
    cache_neighbor_banners.add(localObject);
    cache_ad_list = new ArrayList();
    localObject = new NeighborAd();
    cache_ad_list.add(localObject);
    cache_self_info = new SelfInfo();
    cache_NearRankingsResp = (byte[])new byte[1];
    ((byte[])cache_NearRankingsResp)[0] = 0;
    cache_NewUserAreaResp = (byte[])new byte[1];
    ((byte[])cache_NewUserAreaResp)[0] = 0;
    cache_alumnus_conf = new AlumnusConfigInfo();
  }
  
  public RespGetEncounterV2() {}
  
  public RespGetEncounterV2(long paramLong, UserData paramUserData, ArrayList<RespEncounterInfo> paramArrayList, UserDetailLocalInfo paramUserDetailLocalInfo, PengYouInfo paramPengYouInfo, EctFragmentation paramEctFragmentation, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, String paramString2, ArrayList<EntranceContent> paramArrayList1, ArrayList<NeighborBanner> paramArrayList2, byte paramByte1, byte paramByte2, byte paramByte3, ArrayList<NeighborAd> paramArrayList3, SelfInfo paramSelfInfo, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, AlumnusConfigInfo paramAlumnusConfigInfo, byte paramByte4, RecommEncounterInfo paramRecommEncounterInfo, byte paramByte5)
  {
    this.RespTime = paramLong;
    this.stUserData = paramUserData;
    this.vEncounterInfos = paramArrayList;
    this.stUDLinfo = paramUserDetailLocalInfo;
    this.stPYInfo = paramPengYouInfo;
    this.stEctFmt = paramEctFragmentation;
    this.iSessionTotalNumber = paramInt1;
    this.iEncounterNumber = paramInt2;
    this.nearbyGroupResp = paramArrayOfByte1;
    this.nearbyPublicAcctResp = paramArrayOfByte2;
    this.strSecurityTips = paramString1;
    this.strSecurityDetailUrl = paramString2;
    this.entrance_list = paramArrayList1;
    this.neighbor_banners = paramArrayList2;
    this.system_pic = paramByte1;
    this.watch_color = paramByte2;
    this.useInterestTag = paramByte3;
    this.ad_list = paramArrayList3;
    this.self_info = paramSelfInfo;
    this.NearRankingsResp = paramArrayOfByte3;
    this.NewUserAreaResp = paramArrayOfByte4;
    this.alumnus_conf = paramAlumnusConfigInfo;
    this.can_add_sub_interest = paramByte4;
    this.RecommEncounters = paramRecommEncounterInfo;
    this.RankingFlag = paramByte5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.RespTime = paramJceInputStream.read(this.RespTime, 0, true);
    this.stUserData = ((UserData)paramJceInputStream.read(cache_stUserData, 1, true));
    this.vEncounterInfos = ((ArrayList)paramJceInputStream.read(cache_vEncounterInfos, 2, false));
    this.stUDLinfo = ((UserDetailLocalInfo)paramJceInputStream.read(cache_stUDLinfo, 3, false));
    this.stPYInfo = ((PengYouInfo)paramJceInputStream.read(cache_stPYInfo, 4, false));
    this.stEctFmt = ((EctFragmentation)paramJceInputStream.read(cache_stEctFmt, 5, false));
    this.iSessionTotalNumber = paramJceInputStream.read(this.iSessionTotalNumber, 6, false);
    this.iEncounterNumber = paramJceInputStream.read(this.iEncounterNumber, 7, false);
    this.nearbyGroupResp = ((byte[])paramJceInputStream.read(cache_nearbyGroupResp, 8, false));
    this.nearbyPublicAcctResp = ((byte[])paramJceInputStream.read(cache_nearbyPublicAcctResp, 9, false));
    this.strSecurityTips = paramJceInputStream.readString(10, false);
    this.strSecurityDetailUrl = paramJceInputStream.readString(11, false);
    this.entrance_list = ((ArrayList)paramJceInputStream.read(cache_entrance_list, 12, false));
    this.neighbor_banners = ((ArrayList)paramJceInputStream.read(cache_neighbor_banners, 13, false));
    this.system_pic = paramJceInputStream.read(this.system_pic, 14, false);
    this.watch_color = paramJceInputStream.read(this.watch_color, 15, false);
    this.useInterestTag = paramJceInputStream.read(this.useInterestTag, 16, false);
    this.ad_list = ((ArrayList)paramJceInputStream.read(cache_ad_list, 17, false));
    this.self_info = ((SelfInfo)paramJceInputStream.read(cache_self_info, 18, false));
    this.NearRankingsResp = ((byte[])paramJceInputStream.read(cache_NearRankingsResp, 19, false));
    this.NewUserAreaResp = ((byte[])paramJceInputStream.read(cache_NewUserAreaResp, 20, false));
    this.alumnus_conf = ((AlumnusConfigInfo)paramJceInputStream.read(cache_alumnus_conf, 21, false));
    this.can_add_sub_interest = paramJceInputStream.read(this.can_add_sub_interest, 22, false);
    this.RecommEncounters = ((RecommEncounterInfo)paramJceInputStream.read(cache_RecommEncounters, 23, false));
    this.RankingFlag = paramJceInputStream.read(this.RankingFlag, 24, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.RespTime, 0);
    paramJceOutputStream.write(this.stUserData, 1);
    Object localObject = this.vEncounterInfos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.stUDLinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.stPYInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.stEctFmt;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.iSessionTotalNumber, 6);
    paramJceOutputStream.write(this.iEncounterNumber, 7);
    localObject = this.nearbyGroupResp;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 8);
    }
    localObject = this.nearbyPublicAcctResp;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 9);
    }
    localObject = this.strSecurityTips;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.strSecurityDetailUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.entrance_list;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 12);
    }
    localObject = this.neighbor_banners;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 13);
    }
    paramJceOutputStream.write(this.system_pic, 14);
    paramJceOutputStream.write(this.watch_color, 15);
    paramJceOutputStream.write(this.useInterestTag, 16);
    localObject = this.ad_list;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 17);
    }
    localObject = this.self_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 18);
    }
    localObject = this.NearRankingsResp;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 19);
    }
    localObject = this.NewUserAreaResp;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 20);
    }
    localObject = this.alumnus_conf;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 21);
    }
    paramJceOutputStream.write(this.can_add_sub_interest, 22);
    localObject = this.RecommEncounters;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 23);
    }
    paramJceOutputStream.write(this.RankingFlag, 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     EncounterSvc.RespGetEncounterV2
 * JD-Core Version:    0.7.0.1
 */