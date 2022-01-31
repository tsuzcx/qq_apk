package NeighborSvc;

import NeighborComm.EctFragmentation;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetNeighbors
  extends JceStruct
{
  static byte[] cache_nearbyGroupResp;
  static EctFragmentation cache_stEctFmt;
  static RespHeader cache_stHeader;
  static UserDetailLocalInfo cache_stUDLinfo;
  static UserData cache_stUserData;
  static ArrayList<GroupInfo> cache_vGroupList;
  static ArrayList<RespNeighborInfo> cache_vNeighborInfos;
  public long RespTime;
  public int iSessionTotalNumber;
  public byte[] nearbyGroupResp;
  public EctFragmentation stEctFmt;
  public RespHeader stHeader;
  public UserDetailLocalInfo stUDLinfo;
  public UserData stUserData;
  public ArrayList<GroupInfo> vGroupList;
  public ArrayList<RespNeighborInfo> vNeighborInfos;
  
  public RespGetNeighbors() {}
  
  public RespGetNeighbors(RespHeader paramRespHeader, long paramLong, ArrayList<RespNeighborInfo> paramArrayList, ArrayList<GroupInfo> paramArrayList1, UserData paramUserData, UserDetailLocalInfo paramUserDetailLocalInfo, EctFragmentation paramEctFragmentation, int paramInt, byte[] paramArrayOfByte)
  {
    this.stHeader = paramRespHeader;
    this.RespTime = paramLong;
    this.vNeighborInfos = paramArrayList;
    this.vGroupList = paramArrayList1;
    this.stUserData = paramUserData;
    this.stUDLinfo = paramUserDetailLocalInfo;
    this.stEctFmt = paramEctFragmentation;
    this.iSessionTotalNumber = paramInt;
    this.nearbyGroupResp = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.RespTime = paramJceInputStream.read(this.RespTime, 1, true);
    Object localObject;
    if (cache_vNeighborInfos == null)
    {
      cache_vNeighborInfos = new ArrayList();
      localObject = new RespNeighborInfo();
      cache_vNeighborInfos.add(localObject);
    }
    this.vNeighborInfos = ((ArrayList)paramJceInputStream.read(cache_vNeighborInfos, 2, false));
    if (cache_vGroupList == null)
    {
      cache_vGroupList = new ArrayList();
      localObject = new GroupInfo();
      cache_vGroupList.add(localObject);
    }
    this.vGroupList = ((ArrayList)paramJceInputStream.read(cache_vGroupList, 3, false));
    if (cache_stUserData == null) {
      cache_stUserData = new UserData();
    }
    this.stUserData = ((UserData)paramJceInputStream.read(cache_stUserData, 4, false));
    if (cache_stUDLinfo == null) {
      cache_stUDLinfo = new UserDetailLocalInfo();
    }
    this.stUDLinfo = ((UserDetailLocalInfo)paramJceInputStream.read(cache_stUDLinfo, 5, false));
    if (cache_stEctFmt == null) {
      cache_stEctFmt = new EctFragmentation();
    }
    this.stEctFmt = ((EctFragmentation)paramJceInputStream.read(cache_stEctFmt, 6, false));
    this.iSessionTotalNumber = paramJceInputStream.read(this.iSessionTotalNumber, 7, false);
    if (cache_nearbyGroupResp == null)
    {
      cache_nearbyGroupResp = (byte[])new byte[1];
      ((byte[])cache_nearbyGroupResp)[0] = 0;
    }
    this.nearbyGroupResp = ((byte[])paramJceInputStream.read(cache_nearbyGroupResp, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.RespTime, 1);
    if (this.vNeighborInfos != null) {
      paramJceOutputStream.write(this.vNeighborInfos, 2);
    }
    if (this.vGroupList != null) {
      paramJceOutputStream.write(this.vGroupList, 3);
    }
    if (this.stUserData != null) {
      paramJceOutputStream.write(this.stUserData, 4);
    }
    if (this.stUDLinfo != null) {
      paramJceOutputStream.write(this.stUDLinfo, 5);
    }
    if (this.stEctFmt != null) {
      paramJceOutputStream.write(this.stEctFmt, 6);
    }
    paramJceOutputStream.write(this.iSessionTotalNumber, 7);
    if (this.nearbyGroupResp != null) {
      paramJceOutputStream.write(this.nearbyGroupResp, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NeighborSvc.RespGetNeighbors
 * JD-Core Version:    0.7.0.1
 */