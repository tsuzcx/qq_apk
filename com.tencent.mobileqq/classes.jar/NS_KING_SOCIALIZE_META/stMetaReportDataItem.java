package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stMetaReportDataItem
  extends JceStruct
{
  static Map<String, String> cache_strData = new HashMap();
  public Map<String, String> strData = null;
  
  static
  {
    cache_strData.put("", "");
  }
  
  public stMetaReportDataItem() {}
  
  public stMetaReportDataItem(Map<String, String> paramMap)
  {
    this.strData = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strData = ((Map)paramJceInputStream.read(cache_strData, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strData, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaReportDataItem
 * JD-Core Version:    0.7.0.1
 */