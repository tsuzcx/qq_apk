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
  public Map<Long, ArrayList<Long>> mapClassContrastList;
  public Map<Long, String> mapClassId2Text;
  public tag_deatail_info stTagDetailInfo;
  
  static
  {
    cache_mapClassContrastList = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(0L));
    cache_mapClassContrastList.put(Long.valueOf(0L), localArrayList);
    cache_mapClassId2Text = new HashMap();
    cache_mapClassId2Text.put(Long.valueOf(0L), "");
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
    if (this.stTagDetailInfo != null) {
      paramJceOutputStream.write(this.stTagDetailInfo, 0);
    }
    if (this.mapClassContrastList != null) {
      paramJceOutputStream.write(this.mapClassContrastList, 1);
    }
    if (this.mapClassId2Text != null) {
      paramJceOutputStream.write(this.mapClassId2Text, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.tag_together_query_rsp
 * JD-Core Version:    0.7.0.1
 */