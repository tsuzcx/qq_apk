package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.msgb_rapidemotion;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class m_rapid_tab_info
  extends JceStruct
{
  static Map cache_extend_info;
  static ArrayList cache_rapid_emotions = new ArrayList();
  public Map extend_info;
  public ArrayList rapid_emotions;
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
  
  public m_rapid_tab_info(long paramLong, ArrayList paramArrayList, String paramString1, String paramString2, Map paramMap)
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
    if (this.rapid_emotions != null) {
      paramJceOutputStream.write(this.rapid_emotions, 1);
    }
    if (this.zip_url != null) {
      paramJceOutputStream.write(this.zip_url, 2);
    }
    if (this.zip_md5_value != null) {
      paramJceOutputStream.write(this.zip_md5_value, 3);
    }
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.m_rapid_tab_info
 * JD-Core Version:    0.7.0.1
 */