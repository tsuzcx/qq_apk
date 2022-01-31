package AvatarInfo;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class QQHeadUrlResp
  extends JceStruct
{
  static ArrayList<QQHeadInfo> cache_UserHeadInfoList;
  public ArrayList<QQHeadInfo> UserHeadInfoList;
  public long myUin;
  public int result;
  
  public QQHeadUrlResp() {}
  
  public QQHeadUrlResp(long paramLong, int paramInt, ArrayList<QQHeadInfo> paramArrayList)
  {
    this.myUin = paramLong;
    this.result = paramInt;
    this.UserHeadInfoList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.myUin = paramJceInputStream.read(this.myUin, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
    if (cache_UserHeadInfoList == null)
    {
      cache_UserHeadInfoList = new ArrayList();
      QQHeadInfo localQQHeadInfo = new QQHeadInfo();
      cache_UserHeadInfoList.add(localQQHeadInfo);
    }
    this.UserHeadInfoList = ((ArrayList)paramJceInputStream.read(cache_UserHeadInfoList, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.myUin, 0);
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.UserHeadInfoList, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     AvatarInfo.QQHeadUrlResp
 * JD-Core Version:    0.7.0.1
 */