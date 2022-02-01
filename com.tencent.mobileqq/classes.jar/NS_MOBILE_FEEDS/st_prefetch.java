package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class st_prefetch
  extends JceStruct
{
  static Map<String, String> cache_mapExt;
  static ArrayList<String> cache_vecPicUrl = new ArrayList();
  public Map<String, String> mapExt;
  public String sExtendInfo = "";
  public ArrayList<String> vecPicUrl;
  
  static
  {
    cache_vecPicUrl.add("");
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public st_prefetch() {}
  
  public st_prefetch(ArrayList<String> paramArrayList, String paramString, Map<String, String> paramMap)
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
    Object localObject = this.vecPicUrl;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.sExtendInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.st_prefetch
 * JD-Core Version:    0.7.0.1
 */