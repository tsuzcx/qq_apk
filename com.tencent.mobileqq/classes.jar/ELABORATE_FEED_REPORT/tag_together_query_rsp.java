package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class tag_together_query_rsp
  extends JceStruct
{
  static Map<Long, ArrayList<Long>> cache_mapClassContrastList;
  static Map<Long, String> cache_mapClassId2Text;
  static tag_deatail_info cache_stTagDetailInfo = new tag_deatail_info();
  public Map<Long, ArrayList<Long>> mapClassContrastList = null;
  public Map<Long, String> mapClassId2Text = null;
  public tag_deatail_info stTagDetailInfo = null;
  
  static
  {
    cache_mapClassContrastList = new HashMap();
    Long localLong = Long.valueOf(0L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localLong);
    cache_mapClassContrastList.put(localLong, localArrayList);
    cache_mapClassId2Text = new HashMap();
    cache_mapClassId2Text.put(localLong, "");
  }
  
  public tag_together_query_rsp() {}
  
  public tag_together_query_rsp(tag_deatail_info paramtag_deatail_info, Map<Long, ArrayList<Long>> paramMap, Map<Long, String> paramMap1)
  {
    this.stTagDetailInfo = paramtag_deatail_info;
    this.mapClassContrastList = paramMap;
    this.mapClassId2Text = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stTagDetailInfo = ((tag_deatail_info)paramJceInputStream.read(cache_stTagDetailInfo, 0, false));
    this.mapClassContrastList = ((Map)paramJceInputStream.read(cache_mapClassContrastList, 1, false));
    this.mapClassId2Text = ((Map)paramJceInputStream.read(cache_mapClassId2Text, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stTagDetailInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.mapClassContrastList;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    localObject = this.mapClassId2Text;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.tag_together_query_rsp
 * JD-Core Version:    0.7.0.1
 */