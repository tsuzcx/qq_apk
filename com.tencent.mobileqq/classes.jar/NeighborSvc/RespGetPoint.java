package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespGetPoint
  extends JceStruct
{
  static GPS cache_stGps;
  static UserDetailLocalInfo cache_stUDLinfo;
  public GPS stGps = null;
  public UserDetailLocalInfo stUDLinfo = null;
  
  public RespGetPoint() {}
  
  public RespGetPoint(GPS paramGPS, UserDetailLocalInfo paramUserDetailLocalInfo)
  {
    this.stGps = paramGPS;
    this.stUDLinfo = paramUserDetailLocalInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new GPS();
    }
    this.stGps = ((GPS)paramJceInputStream.read(cache_stGps, 0, true));
    if (cache_stUDLinfo == null) {
      cache_stUDLinfo = new UserDetailLocalInfo();
    }
    this.stUDLinfo = ((UserDetailLocalInfo)paramJceInputStream.read(cache_stUDLinfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    UserDetailLocalInfo localUserDetailLocalInfo = this.stUDLinfo;
    if (localUserDetailLocalInfo != null) {
      paramJceOutputStream.write(localUserDetailLocalInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NeighborSvc.RespGetPoint
 * JD-Core Version:    0.7.0.1
 */