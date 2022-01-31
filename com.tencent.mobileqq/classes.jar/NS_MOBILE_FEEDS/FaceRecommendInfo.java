package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FaceRecommendInfo
  extends JceStruct
{
  public String groupid = "";
  public String nick = "";
  public long uin;
  
  public FaceRecommendInfo() {}
  
  public FaceRecommendInfo(long paramLong, String paramString1, String paramString2)
  {
    this.uin = paramLong;
    this.nick = paramString1;
    this.groupid = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nick = paramJceInputStream.readString(1, false);
    this.groupid = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 1);
    }
    if (this.groupid != null) {
      paramJceOutputStream.write(this.groupid, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.FaceRecommendInfo
 * JD-Core Version:    0.7.0.1
 */