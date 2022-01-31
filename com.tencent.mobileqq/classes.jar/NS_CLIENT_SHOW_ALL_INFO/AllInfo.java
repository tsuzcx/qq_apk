package NS_CLIENT_SHOW_ALL_INFO;

import NS_COMM_VIP_GROWTH.SearchClientShowInfoRsp;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AllInfo
  extends JceStruct
{
  static SearchClientShowInfoRsp cache_stYellowVipInfo = new SearchClientShowInfoRsp();
  static byte[] cache_vecQQBigVipInfo = (byte[])new byte[1];
  public SearchClientShowInfoRsp stYellowVipInfo;
  public byte[] vecQQBigVipInfo;
  
  static
  {
    ((byte[])cache_vecQQBigVipInfo)[0] = 0;
  }
  
  public AllInfo() {}
  
  public AllInfo(byte[] paramArrayOfByte, SearchClientShowInfoRsp paramSearchClientShowInfoRsp)
  {
    this.vecQQBigVipInfo = paramArrayOfByte;
    this.stYellowVipInfo = paramSearchClientShowInfoRsp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecQQBigVipInfo = ((byte[])paramJceInputStream.read(cache_vecQQBigVipInfo, 0, false));
    this.stYellowVipInfo = ((SearchClientShowInfoRsp)paramJceInputStream.read(cache_stYellowVipInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecQQBigVipInfo != null) {
      paramJceOutputStream.write(this.vecQQBigVipInfo, 0);
    }
    if (this.stYellowVipInfo != null) {
      paramJceOutputStream.write(this.stYellowVipInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CLIENT_SHOW_ALL_INFO.AllInfo
 * JD-Core Version:    0.7.0.1
 */