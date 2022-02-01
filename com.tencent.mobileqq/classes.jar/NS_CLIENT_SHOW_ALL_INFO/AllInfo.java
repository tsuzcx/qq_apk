package NS_CLIENT_SHOW_ALL_INFO;

import NS_COMM_VIP_GROWTH.SearchClientShowInfoRsp;
import SWEET_NEW_COMM_SVR.guest_mainpage_rsp;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AllInfo
  extends JceStruct
{
  static byte[] cache_DynamicNickModuleRsp;
  static guest_mainpage_rsp cache_stGuestMainpageRsp;
  static SearchClientShowInfoRsp cache_stYellowVipInfo;
  static byte[] cache_vecQQBigVipInfo = (byte[])new byte[1];
  static byte[] cache_vecSweetStyleInfo;
  public byte[] DynamicNickModuleRsp = null;
  public guest_mainpage_rsp stGuestMainpageRsp = null;
  public SearchClientShowInfoRsp stYellowVipInfo = null;
  public byte[] vecQQBigVipInfo = null;
  public byte[] vecSweetStyleInfo = null;
  
  static
  {
    ((byte[])cache_vecQQBigVipInfo)[0] = 0;
    cache_stYellowVipInfo = new SearchClientShowInfoRsp();
    cache_stGuestMainpageRsp = new guest_mainpage_rsp();
    cache_vecSweetStyleInfo = (byte[])new byte[1];
    ((byte[])cache_vecSweetStyleInfo)[0] = 0;
    cache_DynamicNickModuleRsp = (byte[])new byte[1];
    ((byte[])cache_DynamicNickModuleRsp)[0] = 0;
  }
  
  public AllInfo() {}
  
  public AllInfo(byte[] paramArrayOfByte1, SearchClientShowInfoRsp paramSearchClientShowInfoRsp, guest_mainpage_rsp paramguest_mainpage_rsp, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.vecQQBigVipInfo = paramArrayOfByte1;
    this.stYellowVipInfo = paramSearchClientShowInfoRsp;
    this.stGuestMainpageRsp = paramguest_mainpage_rsp;
    this.vecSweetStyleInfo = paramArrayOfByte2;
    this.DynamicNickModuleRsp = paramArrayOfByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecQQBigVipInfo = ((byte[])paramJceInputStream.read(cache_vecQQBigVipInfo, 0, false));
    this.stYellowVipInfo = ((SearchClientShowInfoRsp)paramJceInputStream.read(cache_stYellowVipInfo, 1, false));
    this.stGuestMainpageRsp = ((guest_mainpage_rsp)paramJceInputStream.read(cache_stGuestMainpageRsp, 2, false));
    this.vecSweetStyleInfo = ((byte[])paramJceInputStream.read(cache_vecSweetStyleInfo, 3, false));
    this.DynamicNickModuleRsp = ((byte[])paramJceInputStream.read(cache_DynamicNickModuleRsp, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.vecQQBigVipInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 0);
    }
    localObject = this.stYellowVipInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.stGuestMainpageRsp;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.vecSweetStyleInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 3);
    }
    localObject = this.DynamicNickModuleRsp;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CLIENT_SHOW_ALL_INFO.AllInfo
 * JD-Core Version:    0.7.0.1
 */