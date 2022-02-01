package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class RespGetFavoriteList
  extends JceStruct
{
  static RespHead cache_stHeader;
  static UserCntlData cache_stUserData;
  static ArrayList<UserProfile> cache_vFavoriteInfos;
  static byte[] cache_vNotice;
  public long RespTime = 0L;
  public RespHead stHeader = null;
  public UserCntlData stUserData = null;
  public ArrayList<UserProfile> vFavoriteInfos = null;
  public byte[] vNotice = null;
  
  public RespGetFavoriteList() {}
  
  public RespGetFavoriteList(RespHead paramRespHead, long paramLong, ArrayList<UserProfile> paramArrayList, UserCntlData paramUserCntlData, byte[] paramArrayOfByte)
  {
    this.stHeader = paramRespHead;
    this.RespTime = paramLong;
    this.vFavoriteInfos = paramArrayList;
    this.stUserData = paramUserCntlData;
    this.vNotice = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.RespTime = paramJceInputStream.read(this.RespTime, 1, true);
    if (cache_vFavoriteInfos == null)
    {
      cache_vFavoriteInfos = new ArrayList();
      UserProfile localUserProfile = new UserProfile();
      cache_vFavoriteInfos.add(localUserProfile);
    }
    this.vFavoriteInfos = ((ArrayList)paramJceInputStream.read(cache_vFavoriteInfos, 2, false));
    if (cache_stUserData == null) {
      cache_stUserData = new UserCntlData();
    }
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 3, false));
    if (cache_vNotice == null)
    {
      cache_vNotice = (byte[])new byte[1];
      ((byte[])cache_vNotice)[0] = 0;
    }
    this.vNotice = ((byte[])paramJceInputStream.read(cache_vNotice, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.RespTime, 1);
    Object localObject = this.vFavoriteInfos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.stUserData;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.vNotice;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.RespGetFavoriteList
 * JD-Core Version:    0.7.0.1
 */