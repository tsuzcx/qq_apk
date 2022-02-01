package NS_CLIENT_SHOW_ALL_INFO;

import NS_COMM_VIP_GROWTH.SearchClientShowInfoRsp;
import SWEET_NEW_COMM_SVR.guest_mainpage_rsp;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AllInfo
  extends JceStruct
{
  static guest_mainpage_rsp cache_stGuestMainpageRsp;
  static SearchClientShowInfoRsp cache_stYellowVipInfo;
  static byte[] cache_vecQQBigVipInfo = (byte[])new byte[1];
  static byte[] cache_vecSweetStyleInfo;
  public guest_mainpage_rsp stGuestMainpageRsp;
  public SearchClientShowInfoRsp stYellowVipInfo;
  public byte[] vecQQBigVipInfo;
  public byte[] vecSweetStyleInfo;
  
  static
  {
    ((byte[])cache_vecQQBigVipInfo)[0] = 0;
    cache_stYellowVipInfo = new SearchClientShowInfoRsp();
    cache_stGuestMainpageRsp = new guest_mainpage_rsp();
    cache_vecSweetStyleInfo = (byte[])new byte[1];
    ((byte[])cache_vecSweetStyleInfo)[0] = 0;
  }
  
  public AllInfo() {}
  
  public AllInfo(byte[] paramArrayOfByte1, SearchClientShowInfoRsp paramSearchClientShowInfoRsp, guest_mainpage_rsp paramguest_mainpage_rsp, byte[] paramArrayOfByte2)
  {
    this.vecQQBigVipInfo = paramArrayOfByte1;
    this.stYellowVipInfo = paramSearchClientShowInfoRsp;
    this.stGuestMainpageRsp = paramguest_mainpage_rsp;
    this.vecSweetStyleInfo = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecQQBigVipInfo = ((byte[])paramJceInputStream.read(cache_vecQQBigVipInfo, 0, false));
    this.stYellowVipInfo = ((SearchClientShowInfoRsp)paramJceInputStream.read(cache_stYellowVipInfo, 1, false));
    this.stGuestMainpageRsp = ((guest_mainpage_rsp)paramJceInputStream.read(cache_stGuestMainpageRsp, 2, false));
    this.vecSweetStyleInfo = ((byte[])paramJceInputStream.read(cache_vecSweetStyleInfo, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecQQBigVipInfo != null) {
      paramJceOutputStream.write(this.vecQQBigVipInfo, 0);
    }
    if (this.stYellowVipInfo != null) {
      paramJceOutputStream.write(this.stYellowVipInfo, 1);
    }
    if (this.stGuestMainpageRsp != null) {
      paramJceOutputStream.write(this.stGuestMainpageRsp, 2);
    }
    if (this.vecSweetStyleInfo != null) {
      paramJceOutputStream.write(this.vecSweetStyleInfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CLIENT_SHOW_ALL_INFO.AllInfo
 * JD-Core Version:    0.7.0.1
 */