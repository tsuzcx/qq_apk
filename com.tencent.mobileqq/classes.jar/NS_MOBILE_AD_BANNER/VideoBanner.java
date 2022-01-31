package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class VideoBanner
  extends JceStruct
{
  static ArrayList cache_videos = new ArrayList();
  public String nick = "";
  public long uUin;
  public ArrayList videos;
  
  static
  {
    OneVideoInfo localOneVideoInfo = new OneVideoInfo();
    cache_videos.add(localOneVideoInfo);
  }
  
  public VideoBanner() {}
  
  public VideoBanner(long paramLong, ArrayList paramArrayList, String paramString)
  {
    this.uUin = paramLong;
    this.videos = paramArrayList;
    this.nick = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uUin = paramJceInputStream.read(this.uUin, 0, false);
    this.videos = ((ArrayList)paramJceInputStream.read(cache_videos, 1, false));
    this.nick = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uUin, 0);
    if (this.videos != null) {
      paramJceOutputStream.write(this.videos, 1);
    }
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_AD_BANNER.VideoBanner
 * JD-Core Version:    0.7.0.1
 */