package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class st_prefetch
  extends JceStruct
{
  static Map cache_mapExt;
  static ArrayList cache_vecPicUrl = new ArrayList();
  public Map mapExt;
  public String sExtendInfo = "";
  public ArrayList vecPicUrl;
  
  static
  {
    cache_vecPicUrl.add("");
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public st_prefetch() {}
  
  public st_prefetch(ArrayList paramArrayList, String paramString, Map paramMap)
  {
    this.vecPicUrl = paramArrayList;
    this.sExtendInfo = paramString;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecPicUrl = ((ArrayList)paramJceInputStream.read(cache_vecPicUrl, 0, false));
    this.sExtendInfo = paramJceInputStream.readString(1, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecPicUrl != null) {
      paramJceOutputStream.write(this.vecPicUrl, 0);
    }
    if (this.sExtendInfo != null) {
      paramJceOutputStream.write(this.sExtendInfo, 1);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.st_prefetch
 * JD-Core Version:    0.7.0.1
 */