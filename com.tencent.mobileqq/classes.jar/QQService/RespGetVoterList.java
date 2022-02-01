package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class RespGetVoterList
  extends JceStruct
{
  static RespHead cache_stHeader = new RespHead();
  static UserCntlData cache_stUserData;
  static ArrayList<UserProfile> cache_vTodayFavoriteInfos;
  static ArrayList<UserProfile> cache_vVoterInfos = new ArrayList();
  public long RespTime = 0L;
  public int iMaxFriendFavoriteCount = 50;
  public int iMaxStrangerFavoriteCount = 50;
  public int iTodayVoteCount = 0;
  public int iTodayVoteRank = -1;
  public int iTotalVoteCount = 0;
  public RespHead stHeader = null;
  public UserCntlData stUserData = null;
  public ArrayList<UserProfile> vTodayFavoriteInfos = null;
  public ArrayList<UserProfile> vVoterInfos = null;
  
  static
  {
    UserProfile localUserProfile = new UserProfile();
    cache_vVoterInfos.add(localUserProfile);
    cache_stUserData = new UserCntlData();
    cache_vTodayFavoriteInfos = new ArrayList();
    localUserProfile = new UserProfile();
    cache_vTodayFavoriteInfos.add(localUserProfile);
  }
  
  public RespGetVoterList() {}
  
  public RespGetVoterList(RespHead paramRespHead, long paramLong, ArrayList<UserProfile> paramArrayList1, UserCntlData paramUserCntlData, ArrayList<UserProfile> paramArrayList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.stHeader = paramRespHead;
    this.RespTime = paramLong;
    this.vVoterInfos = paramArrayList1;
    this.stUserData = paramUserCntlData;
    this.vTodayFavoriteInfos = paramArrayList2;
    this.iMaxFriendFavoriteCount = paramInt1;
    this.iMaxStrangerFavoriteCount = paramInt2;
    this.iTodayVoteCount = paramInt3;
    this.iTodayVoteRank = paramInt4;
    this.iTotalVoteCount = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.RespTime = paramJceInputStream.read(this.RespTime, 1, true);
    this.vVoterInfos = ((ArrayList)paramJceInputStream.read(cache_vVoterInfos, 2, false));
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 3, false));
    this.vTodayFavoriteInfos = ((ArrayList)paramJceInputStream.read(cache_vTodayFavoriteInfos, 4, false));
    this.iMaxFriendFavoriteCount = paramJceInputStream.read(this.iMaxFriendFavoriteCount, 5, false);
    this.iMaxStrangerFavoriteCount = paramJceInputStream.read(this.iMaxStrangerFavoriteCount, 6, false);
    this.iTodayVoteCount = paramJceInputStream.read(this.iTodayVoteCount, 7, false);
    this.iTodayVoteRank = paramJceInputStream.read(this.iTodayVoteRank, 8, false);
    this.iTotalVoteCount = paramJceInputStream.read(this.iTotalVoteCount, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.RespTime, 1);
    Object localObject = this.vVoterInfos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.stUserData;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.vTodayFavoriteInfos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    paramJceOutputStream.write(this.iMaxFriendFavoriteCount, 5);
    paramJceOutputStream.write(this.iMaxStrangerFavoriteCount, 6);
    paramJceOutputStream.write(this.iTodayVoteCount, 7);
    paramJceOutputStream.write(this.iTodayVoteRank, 8);
    paramJceOutputStream.write(this.iTotalVoteCount, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.RespGetVoterList
 * JD-Core Version:    0.7.0.1
 */