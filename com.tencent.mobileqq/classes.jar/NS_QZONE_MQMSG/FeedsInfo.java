package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FeedsInfo
  extends JceStruct
{
  public int appid = 0;
  public long hostUin = 0L;
  public String jumpUrl = "";
  public String likekey = "";
  
  public FeedsInfo() {}
  
  public FeedsInfo(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    this.appid = paramInt;
    this.hostUin = paramLong;
    this.likekey = paramString1;
    this.jumpUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.hostUin = paramJceInputStream.read(this.hostUin, 1, false);
    this.likekey = paramJceInputStream.readString(2, false);
    this.jumpUrl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.hostUin, 1);
    if (this.likekey != null) {
      paramJceOutputStream.write(this.likekey, 2);
    }
    if (this.jumpUrl != null) {
      paramJceOutputStream.write(this.jumpUrl, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.FeedsInfo
 * JD-Core Version:    0.7.0.1
 */