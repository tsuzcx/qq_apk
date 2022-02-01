package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class mobile_video_layer_adv_rsp
  extends JceStruct
{
  static ArrayList<single_feed> cache_all_feeds_adv = new ArrayList();
  static ArrayList<single_feed> cache_all_pop_adv;
  static ArrayList<s_premovie_adv> cache_all_premovie_adv;
  static Map<String, single_feed> cache_all_tips_adv;
  static Map<String, String> cache_mapExt;
  public ArrayList<single_feed> all_feeds_adv = null;
  public ArrayList<single_feed> all_pop_adv = null;
  public ArrayList<s_premovie_adv> all_premovie_adv = null;
  public Map<String, single_feed> all_tips_adv = null;
  public Map<String, String> mapExt = null;
  
  static
  {
    Object localObject = new single_feed();
    cache_all_feeds_adv.add(localObject);
    cache_all_tips_adv = new HashMap();
    localObject = new single_feed();
    cache_all_tips_adv.put("", localObject);
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
    cache_all_premovie_adv = new ArrayList();
    localObject = new s_premovie_adv();
    cache_all_premovie_adv.add(localObject);
    cache_all_pop_adv = new ArrayList();
    localObject = new single_feed();
    cache_all_pop_adv.add(localObject);
  }
  
  public mobile_video_layer_adv_rsp() {}
  
  public mobile_video_layer_adv_rsp(ArrayList<single_feed> paramArrayList1, Map<String, single_feed> paramMap, Map<String, String> paramMap1, ArrayList<s_premovie_adv> paramArrayList, ArrayList<single_feed> paramArrayList2)
  {
    this.all_feeds_adv = paramArrayList1;
    this.all_tips_adv = paramMap;
    this.mapExt = paramMap1;
    this.all_premovie_adv = paramArrayList;
    this.all_pop_adv = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.all_feeds_adv = ((ArrayList)paramJceInputStream.read(cache_all_feeds_adv, 0, false));
    this.all_tips_adv = ((Map)paramJceInputStream.read(cache_all_tips_adv, 1, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 2, false));
    this.all_premovie_adv = ((ArrayList)paramJceInputStream.read(cache_all_premovie_adv, 3, false));
    this.all_pop_adv = ((ArrayList)paramJceInputStream.read(cache_all_pop_adv, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.all_feeds_adv;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.all_tips_adv;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    localObject = this.all_premovie_adv;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.all_pop_adv;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_video_layer_adv_rsp
 * JD-Core Version:    0.7.0.1
 */