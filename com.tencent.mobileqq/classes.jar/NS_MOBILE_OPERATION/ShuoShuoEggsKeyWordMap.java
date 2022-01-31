package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ShuoShuoEggsKeyWordMap
  extends JceStruct
{
  static Map cache_mapKeyWordEggs;
  public Map mapKeyWordEggs;
  
  public ShuoShuoEggsKeyWordMap() {}
  
  public ShuoShuoEggsKeyWordMap(Map paramMap)
  {
    this.mapKeyWordEggs = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_mapKeyWordEggs == null)
    {
      cache_mapKeyWordEggs = new HashMap();
      ImageSummaryList localImageSummaryList = new ImageSummaryList();
      cache_mapKeyWordEggs.put("", localImageSummaryList);
    }
    this.mapKeyWordEggs = ((Map)paramJceInputStream.read(cache_mapKeyWordEggs, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapKeyWordEggs != null) {
      paramJceOutputStream.write(this.mapKeyWordEggs, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_OPERATION.ShuoShuoEggsKeyWordMap
 * JD-Core Version:    0.7.0.1
 */