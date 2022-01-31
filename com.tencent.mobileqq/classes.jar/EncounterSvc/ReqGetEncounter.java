package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetEncounter
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static UserData cache_stUserData;
  static ReqUserInfo cache_stUserInfo;
  public int iListSize = -1;
  public ReqHeader stHeader;
  public UserData stUserData;
  public ReqUserInfo stUserInfo;
  
  public ReqGetEncounter() {}
  
  public ReqGetEncounter(ReqHeader paramReqHeader, ReqUserInfo paramReqUserInfo, UserData paramUserData, int paramInt)
  {
    this.stHeader = paramReqHeader;
    this.stUserInfo = paramReqUserInfo;
    this.stUserData = paramUserData;
    this.iListSize = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 1, true));
    if (cache_stUserData == null) {
      cache_stUserData = new UserData();
    }
    this.stUserData = ((UserData)paramJceInputStream.read(cache_stUserData, 2, true));
    this.iListSize = paramJceInputStream.read(this.iListSize, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stUserInfo, 1);
    paramJceOutputStream.write(this.stUserData, 2);
    paramJceOutputStream.write(this.iListSize, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     EncounterSvc.ReqGetEncounter
 * JD-Core Version:    0.7.0.1
 */