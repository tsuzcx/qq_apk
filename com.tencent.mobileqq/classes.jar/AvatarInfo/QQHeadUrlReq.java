package AvatarInfo;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class QQHeadUrlReq
  extends JceStruct
{
  static ArrayList<DestQQHeadInfo> cache_destUserInfo;
  public ArrayList<DestQQHeadInfo> destUserInfo;
  public byte dstUsrType;
  public long myUin;
  
  public QQHeadUrlReq() {}
  
  public QQHeadUrlReq(long paramLong, ArrayList<DestQQHeadInfo> paramArrayList, byte paramByte)
  {
    this.myUin = paramLong;
    this.destUserInfo = paramArrayList;
    this.dstUsrType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.myUin = paramJceInputStream.read(this.myUin, 0, true);
    if (cache_destUserInfo == null)
    {
      cache_destUserInfo = new ArrayList();
      DestQQHeadInfo localDestQQHeadInfo = new DestQQHeadInfo();
      cache_destUserInfo.add(localDestQQHeadInfo);
    }
    this.destUserInfo = ((ArrayList)paramJceInputStream.read(cache_destUserInfo, 1, true));
    this.dstUsrType = paramJceInputStream.read(this.dstUsrType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.myUin, 0);
    paramJceOutputStream.write(this.destUserInfo, 1);
    paramJceOutputStream.write(this.dstUsrType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     AvatarInfo.QQHeadUrlReq
 * JD-Core Version:    0.7.0.1
 */