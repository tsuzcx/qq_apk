package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.msgb_rapidemotion;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class m_rapid_tab_info
  extends JceStruct
{
  static Map<String, String> cache_extend_info;
  static ArrayList<msgb_rapidemotion> cache_rapid_emotions = new ArrayList();
  public Map<String, String> extend_info;
  public ArrayList<msgb_rapidemotion> rapid_emotions;
  public long tab_id;
  public String zip_md5_value = "";
  public String zip_url = "";
  
  static
  {
    msgb_rapidemotion localmsgb_rapidemotion = new msgb_rapidemotion();
    cache_rapid_emotions.add(localmsgb_rapidemotion);
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
  }
  
  public m_rapid_tab_info() {}
  
  public m_rapid_tab_info(long paramLong, ArrayList<msgb_rapidemotion> paramArrayList, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.tab_id = paramLong;
    this.rapid_emotions = paramArrayList;
    this.zip_url = paramString1;
    this.zip_md5_value = paramString2;
    this.extend_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tab_id = paramJceInputStream.read(this.tab_id, 0, false);
    this.rapid_emotions = ((ArrayList)paramJceInputStream.read(cache_rapid_emotions, 1, false));
    this.zip_url = paramJceInputStream.readString(2, false);
    this.zip_md5_value = paramJceInputStream.readString(3, false);
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tab_id, 0);
    Object localObject = this.rapid_emotions;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.zip_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.zip_md5_value;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.extend_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.m_rapid_tab_info
 * JD-Core Version:    0.7.0.1
 */