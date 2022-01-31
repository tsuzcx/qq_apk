package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_life_moment
  extends JceStruct
{
  static s_single_count cache_stCount = new s_single_count();
  static single_feed cache_stMomentFeed;
  static ArrayList cache_vec_lifemoment = new ArrayList();
  static ArrayList cache_vec_picurls;
  public String action_url = "";
  public String button_text = "";
  public String left_title = "";
  public String right_title = "";
  public int show_type;
  public s_single_count stCount;
  public single_feed stMomentFeed;
  public String summary = "";
  public ArrayList vec_lifemoment;
  public ArrayList vec_picurls;
  
  static
  {
    Object localObject = new s_life_moment_info();
    cache_vec_lifemoment.add(localObject);
    cache_vec_picurls = new ArrayList();
    localObject = new s_picurl();
    cache_vec_picurls.add(localObject);
    cache_stMomentFeed = new single_feed();
  }
  
  public s_life_moment() {}
  
  public s_life_moment(int paramInt, ArrayList paramArrayList1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArrayList paramArrayList2, single_feed paramsingle_feed, s_single_count params_single_count)
  {
    this.show_type = paramInt;
    this.vec_lifemoment = paramArrayList1;
    this.left_title = paramString1;
    this.right_title = paramString2;
    this.action_url = paramString3;
    this.summary = paramString4;
    this.button_text = paramString5;
    this.vec_picurls = paramArrayList2;
    this.stMomentFeed = paramsingle_feed;
    this.stCount = params_single_count;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.show_type = paramJceInputStream.read(this.show_type, 0, false);
    this.vec_lifemoment = ((ArrayList)paramJceInputStream.read(cache_vec_lifemoment, 1, false));
    this.left_title = paramJceInputStream.readString(2, false);
    this.right_title = paramJceInputStream.readString(3, false);
    this.action_url = paramJceInputStream.readString(4, false);
    this.summary = paramJceInputStream.readString(5, false);
    this.button_text = paramJceInputStream.readString(6, false);
    this.vec_picurls = ((ArrayList)paramJceInputStream.read(cache_vec_picurls, 7, false));
    this.stMomentFeed = ((single_feed)paramJceInputStream.read(cache_stMomentFeed, 8, false));
    this.stCount = ((s_single_count)paramJceInputStream.read(cache_stCount, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.show_type, 0);
    if (this.vec_lifemoment != null) {
      paramJceOutputStream.write(this.vec_lifemoment, 1);
    }
    if (this.left_title != null) {
      paramJceOutputStream.write(this.left_title, 2);
    }
    if (this.right_title != null) {
      paramJceOutputStream.write(this.right_title, 3);
    }
    if (this.action_url != null) {
      paramJceOutputStream.write(this.action_url, 4);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 5);
    }
    if (this.button_text != null) {
      paramJceOutputStream.write(this.button_text, 6);
    }
    if (this.vec_picurls != null) {
      paramJceOutputStream.write(this.vec_picurls, 7);
    }
    if (this.stMomentFeed != null) {
      paramJceOutputStream.write(this.stMomentFeed, 8);
    }
    if (this.stCount != null) {
      paramJceOutputStream.write(this.stCount, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_life_moment
 * JD-Core Version:    0.7.0.1
 */