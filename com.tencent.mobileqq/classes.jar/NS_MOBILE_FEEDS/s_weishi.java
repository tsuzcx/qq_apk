package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_weishi
  extends JceStruct
{
  static Map cache_dc_report = new HashMap();
  public String cover_url = "";
  public Map dc_report;
  public String nick_name = "";
  public String weishi_feedId = "";
  public String weishi_fileId = "";
  public String weishi_musicId = "";
  public String weishi_musicName = "";
  public String weishi_musicUrl = "";
  public String weishi_schema = "";
  public String weishi_topicID = "";
  public String weishi_topicName = "";
  public String weishi_topicUrl = "";
  
  static
  {
    cache_dc_report.put("", "");
  }
  
  public s_weishi() {}
  
  public s_weishi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Map paramMap)
  {
    this.weishi_feedId = paramString1;
    this.weishi_fileId = paramString2;
    this.cover_url = paramString3;
    this.nick_name = paramString4;
    this.weishi_musicId = paramString5;
    this.weishi_musicName = paramString6;
    this.weishi_musicUrl = paramString7;
    this.weishi_topicID = paramString8;
    this.weishi_topicName = paramString9;
    this.weishi_topicUrl = paramString10;
    this.weishi_schema = paramString11;
    this.dc_report = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.weishi_feedId = paramJceInputStream.readString(0, false);
    this.weishi_fileId = paramJceInputStream.readString(1, false);
    this.cover_url = paramJceInputStream.readString(2, false);
    this.nick_name = paramJceInputStream.readString(3, false);
    this.weishi_musicId = paramJceInputStream.readString(4, false);
    this.weishi_musicName = paramJceInputStream.readString(5, false);
    this.weishi_musicUrl = paramJceInputStream.readString(6, false);
    this.weishi_topicID = paramJceInputStream.readString(7, false);
    this.weishi_topicName = paramJceInputStream.readString(8, false);
    this.weishi_topicUrl = paramJceInputStream.readString(9, false);
    this.weishi_schema = paramJceInputStream.readString(10, false);
    this.dc_report = ((Map)paramJceInputStream.read(cache_dc_report, 11, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.weishi_feedId != null) {
      paramJceOutputStream.write(this.weishi_feedId, 0);
    }
    if (this.weishi_fileId != null) {
      paramJceOutputStream.write(this.weishi_fileId, 1);
    }
    if (this.cover_url != null) {
      paramJceOutputStream.write(this.cover_url, 2);
    }
    if (this.nick_name != null) {
      paramJceOutputStream.write(this.nick_name, 3);
    }
    if (this.weishi_musicId != null) {
      paramJceOutputStream.write(this.weishi_musicId, 4);
    }
    if (this.weishi_musicName != null) {
      paramJceOutputStream.write(this.weishi_musicName, 5);
    }
    if (this.weishi_musicUrl != null) {
      paramJceOutputStream.write(this.weishi_musicUrl, 6);
    }
    if (this.weishi_topicID != null) {
      paramJceOutputStream.write(this.weishi_topicID, 7);
    }
    if (this.weishi_topicName != null) {
      paramJceOutputStream.write(this.weishi_topicName, 8);
    }
    if (this.weishi_topicUrl != null) {
      paramJceOutputStream.write(this.weishi_topicUrl, 9);
    }
    if (this.weishi_schema != null) {
      paramJceOutputStream.write(this.weishi_schema, 10);
    }
    if (this.dc_report != null) {
      paramJceOutputStream.write(this.dc_report, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_weishi
 * JD-Core Version:    0.7.0.1
 */