package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class RespGetVisitorList
  extends JceStruct
{
  static RespHead cache_stHeader;
  static UserCntlData cache_stUserData;
  static ArrayList<UserProfile> cache_vEncounterInfos;
  public long RespTime = 0L;
  public RespHead stHeader = null;
  public UserCntlData stUserData = null;
  public ArrayList<UserProfile> vEncounterInfos = null;
  
  public RespGetVisitorList() {}
  
  public RespGetVisitorList(RespHead paramRespHead, long paramLong, ArrayList<UserProfile> paramArrayList, UserCntlData paramUserCntlData)
  {
    this.stHeader = paramRespHead;
    this.RespTime = paramLong;
    this.vEncounterInfos = paramArrayList;
    this.stUserData = paramUserCntlData;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.RespTime = paramJceInputStream.read(this.RespTime, 1, true);
    if (cache_vEncounterInfos == null)
    {
      cache_vEncounterInfos = new ArrayList();
      UserProfile localUserProfile = new UserProfile();
      cache_vEncounterInfos.add(localUserProfile);
    }
    this.vEncounterInfos = ((ArrayList)paramJceInputStream.read(cache_vEncounterInfos, 2, false));
    if (cache_stUserData == null) {
      cache_stUserData = new UserCntlData();
    }
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.RespTime, 1);
    Object localObject = this.vEncounterInfos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.stUserData;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.RespGetVisitorList
 * JD-Core Version:    0.7.0.1
 */