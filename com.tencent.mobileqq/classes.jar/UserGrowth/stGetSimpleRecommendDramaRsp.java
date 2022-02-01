package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class stGetSimpleRecommendDramaRsp
  extends JceStruct
{
  static Map<String, ArrayList<String>> cache_dramaFeedsMap;
  static ArrayList<stDrama> cache_dramas = new ArrayList();
  static Map<String, stDramaFeed> cache_feedInfoMap;
  public Map<String, ArrayList<String>> dramaFeedsMap = null;
  public ArrayList<stDrama> dramas = null;
  public Map<String, stDramaFeed> feedInfoMap = null;
  
  static
  {
    Object localObject = new stDrama();
    cache_dramas.add(localObject);
    cache_dramaFeedsMap = new HashMap();
    localObject = new ArrayList();
    ((ArrayList)localObject).add("");
    cache_dramaFeedsMap.put("", localObject);
    cache_feedInfoMap = new HashMap();
    localObject = new stDramaFeed();
    cache_feedInfoMap.put("", localObject);
  }
  
  public stGetSimpleRecommendDramaRsp() {}
  
  public stGetSimpleRecommendDramaRsp(ArrayList<stDrama> paramArrayList, Map<String, ArrayList<String>> paramMap, Map<String, stDramaFeed> paramMap1)
  {
    this.dramas = paramArrayList;
    this.dramaFeedsMap = paramMap;
    this.feedInfoMap = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dramas = ((ArrayList)paramJceInputStream.read(cache_dramas, 0, false));
    this.dramaFeedsMap = ((Map)paramJceInputStream.read(cache_dramaFeedsMap, 1, false));
    this.feedInfoMap = ((Map)paramJceInputStream.read(cache_feedInfoMap, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.dramas;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.dramaFeedsMap;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    localObject = this.feedInfoMap;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetSimpleRecommendDramaRsp
 * JD-Core Version:    0.7.0.1
 */