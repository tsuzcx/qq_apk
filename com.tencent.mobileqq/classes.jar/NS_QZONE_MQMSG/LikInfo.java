package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LikInfo
  extends JceStruct
{
  public int appid = 0;
  public int hasDoLik = 0;
  public long hostUin = 0L;
  public String likeKey = "";
  public int totalLik = 0;
  
  public LikInfo() {}
  
  public LikInfo(int paramInt1, String paramString, int paramInt2, long paramLong, int paramInt3)
  {
    this.totalLik = paramInt1;
    this.likeKey = paramString;
    this.appid = paramInt2;
    this.hostUin = paramLong;
    this.hasDoLik = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.totalLik = paramJceInputStream.read(this.totalLik, 0, false);
    this.likeKey = paramJceInputStream.readString(1, false);
    this.appid = paramJceInputStream.read(this.appid, 2, false);
    this.hostUin = paramJceInputStream.read(this.hostUin, 3, false);
    this.hasDoLik = paramJceInputStream.read(this.hasDoLik, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.totalLik, 0);
    if (this.likeKey != null) {
      paramJceOutputStream.write(this.likeKey, 1);
    }
    paramJceOutputStream.write(this.appid, 2);
    paramJceOutputStream.write(this.hostUin, 3);
    paramJceOutputStream.write(this.hasDoLik, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.LikInfo
 * JD-Core Version:    0.7.0.1
 */