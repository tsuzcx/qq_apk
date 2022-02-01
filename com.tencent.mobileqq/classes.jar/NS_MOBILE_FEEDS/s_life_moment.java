package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class s_life_moment
  extends JceStruct
{
  static s_single_count cache_stCount = new s_single_count();
  static single_feed cache_stMomentFeed;
  static ArrayList<s_life_moment_info> cache_vec_lifemoment = new ArrayList();
  static ArrayList<s_picurl> cache_vec_picurls;
  public String action_url = "";
  public String button_text = "";
  public String left_title = "";
  public String right_title = "";
  public int show_type = 0;
  public s_single_count stCount = null;
  public single_feed stMomentFeed = null;
  public String summary = "";
  public ArrayList<s_life_moment_info> vec_lifemoment = null;
  public ArrayList<s_picurl> vec_picurls = null;
  
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
  
  public s_life_moment(int paramInt, ArrayList<s_life_moment_info> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArrayList<s_picurl> paramArrayList1, single_feed paramsingle_feed, s_single_count params_single_count)
  {
    this.show_type = paramInt;
    this.vec_lifemoment = paramArrayList;
    this.left_title = paramString1;
    this.right_title = paramString2;
    this.action_url = paramString3;
    this.summary = paramString4;
    this.button_text = paramString5;
    this.vec_picurls = paramArrayList1;
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
    Object localObject = this.vec_lifemoment;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.left_title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.right_title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.action_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.button_text;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.vec_picurls;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    localObject = this.stMomentFeed;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    localObject = this.stCount;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_life_moment
 * JD-Core Version:    0.7.0.1
 */