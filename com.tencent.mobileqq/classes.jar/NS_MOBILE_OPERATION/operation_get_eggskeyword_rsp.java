package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_get_eggskeyword_rsp
  extends JceStruct
{
  static GuidePaster cache_guidePaster;
  static Map<String, String> cache_mapKeyWord;
  static Map<String, ImageSummaryList> cache_mapKeyWordEggs;
  public GuidePaster guidePaster;
  public int ifOpenEntrance;
  public Map<String, String> mapKeyWord;
  public Map<String, ImageSummaryList> mapKeyWordEggs;
  public long updatetime;
  
  public operation_get_eggskeyword_rsp() {}
  
  public operation_get_eggskeyword_rsp(int paramInt, Map<String, ImageSummaryList> paramMap, Map<String, String> paramMap1, GuidePaster paramGuidePaster, long paramLong)
  {
    this.ifOpenEntrance = paramInt;
    this.mapKeyWordEggs = paramMap;
    this.mapKeyWord = paramMap1;
    this.guidePaster = paramGuidePaster;
    this.updatetime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ifOpenEntrance = paramJceInputStream.read(this.ifOpenEntrance, 0, true);
    if (cache_mapKeyWordEggs == null)
    {
      cache_mapKeyWordEggs = new HashMap();
      ImageSummaryList localImageSummaryList = new ImageSummaryList();
      cache_mapKeyWordEggs.put("", localImageSummaryList);
    }
    this.mapKeyWordEggs = ((Map)paramJceInputStream.read(cache_mapKeyWordEggs, 1, false));
    if (cache_mapKeyWord == null)
    {
      cache_mapKeyWord = new HashMap();
      cache_mapKeyWord.put("", "");
    }
    this.mapKeyWord = ((Map)paramJceInputStream.read(cache_mapKeyWord, 2, false));
    if (cache_guidePaster == null) {
      cache_guidePaster = new GuidePaster();
    }
    this.guidePaster = ((GuidePaster)paramJceInputStream.read(cache_guidePaster, 3, false));
    this.updatetime = paramJceInputStream.read(this.updatetime, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ifOpenEntrance, 0);
    Object localObject = this.mapKeyWordEggs;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    localObject = this.mapKeyWord;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    localObject = this.guidePaster;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    paramJceOutputStream.write(this.updatetime, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_get_eggskeyword_rsp
 * JD-Core Version:    0.7.0.1
 */