package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_life_moment_info
  extends JceStruct
{
  static s_picurl cache_moment_feed_night_pic = new s_picurl();
  static s_picurl cache_moment_feed_pic;
  static s_picurl cache_moment_pic = new s_picurl();
  public s_picurl moment_feed_night_pic;
  public s_picurl moment_feed_pic;
  public String moment_id = "";
  public String moment_name = "";
  public s_picurl moment_pic;
  public int type;
  
  static
  {
    cache_moment_feed_pic = new s_picurl();
  }
  
  public s_life_moment_info() {}
  
  public s_life_moment_info(int paramInt, String paramString1, s_picurl params_picurl1, s_picurl params_picurl2, s_picurl params_picurl3, String paramString2)
  {
    this.type = paramInt;
    this.moment_name = paramString1;
    this.moment_pic = params_picurl1;
    this.moment_feed_pic = params_picurl2;
    this.moment_feed_night_pic = params_picurl3;
    this.moment_id = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.moment_name = paramJceInputStream.readString(1, false);
    this.moment_pic = ((s_picurl)paramJceInputStream.read(cache_moment_pic, 2, false));
    this.moment_feed_pic = ((s_picurl)paramJceInputStream.read(cache_moment_feed_pic, 3, false));
    this.moment_feed_night_pic = ((s_picurl)paramJceInputStream.read(cache_moment_feed_night_pic, 4, false));
    this.moment_id = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.moment_name != null) {
      paramJceOutputStream.write(this.moment_name, 1);
    }
    if (this.moment_pic != null) {
      paramJceOutputStream.write(this.moment_pic, 2);
    }
    if (this.moment_feed_pic != null) {
      paramJceOutputStream.write(this.moment_feed_pic, 3);
    }
    if (this.moment_feed_night_pic != null) {
      paramJceOutputStream.write(this.moment_feed_night_pic, 4);
    }
    if (this.moment_id != null) {
      paramJceOutputStream.write(this.moment_id, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_life_moment_info
 * JD-Core Version:    0.7.0.1
 */