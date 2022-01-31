package NeighborSvc;

import NeighborComm.NewListType;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetNeighbors
  extends JceStruct
{
  static int cache_eNewListType;
  static byte[] cache_nearbyGroupReq;
  static ReqUserInfo cache_stCheckInInfo;
  static ReqHeader cache_stHeader;
  static UserData cache_stUserData;
  static byte[] cache_strA2;
  public int eNewListType = NewListType.NewListType_Nomal.value();
  public int iListSize = -1;
  public int iSimpleSort;
  public byte[] nearbyGroupReq;
  public ReqUserInfo stCheckInInfo;
  public ReqHeader stHeader;
  public UserData stUserData;
  public byte[] strA2;
  
  public ReqGetNeighbors() {}
  
  public ReqGetNeighbors(ReqHeader paramReqHeader, ReqUserInfo paramReqUserInfo, UserData paramUserData, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2)
  {
    this.stHeader = paramReqHeader;
    this.stCheckInInfo = paramReqUserInfo;
    this.stUserData = paramUserData;
    this.iListSize = paramInt1;
    this.eNewListType = paramInt2;
    this.strA2 = paramArrayOfByte1;
    this.iSimpleSort = paramInt3;
    this.nearbyGroupReq = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stCheckInInfo == null) {
      cache_stCheckInInfo = new ReqUserInfo();
    }
    this.stCheckInInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stCheckInInfo, 1, false));
    if (cache_stUserData == null) {
      cache_stUserData = new UserData();
    }
    this.stUserData = ((UserData)paramJceInputStream.read(cache_stUserData, 2, false));
    this.iListSize = paramJceInputStream.read(this.iListSize, 3, false);
    this.eNewListType = paramJceInputStream.read(this.eNewListType, 4, false);
    if (cache_strA2 == null)
    {
      cache_strA2 = (byte[])new byte[1];
      ((byte[])cache_strA2)[0] = 0;
    }
    this.strA2 = ((byte[])paramJceInputStream.read(cache_strA2, 5, false));
    this.iSimpleSort = paramJceInputStream.read(this.iSimpleSort, 6, false);
    if (cache_nearbyGroupReq == null)
    {
      cache_nearbyGroupReq = (byte[])new byte[1];
      ((byte[])cache_nearbyGroupReq)[0] = 0;
    }
    this.nearbyGroupReq = ((byte[])paramJceInputStream.read(cache_nearbyGroupReq, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    if (this.stCheckInInfo != null) {
      paramJceOutputStream.write(this.stCheckInInfo, 1);
    }
    if (this.stUserData != null) {
      paramJceOutputStream.write(this.stUserData, 2);
    }
    paramJceOutputStream.write(this.iListSize, 3);
    paramJceOutputStream.write(this.eNewListType, 4);
    if (this.strA2 != null) {
      paramJceOutputStream.write(this.strA2, 5);
    }
    paramJceOutputStream.write(this.iSimpleSort, 6);
    if (this.nearbyGroupReq != null) {
      paramJceOutputStream.write(this.nearbyGroupReq, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NeighborSvc.ReqGetNeighbors
 * JD-Core Version:    0.7.0.1
 */