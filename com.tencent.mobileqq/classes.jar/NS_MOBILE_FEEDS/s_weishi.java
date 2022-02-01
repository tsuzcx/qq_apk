package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_weishi
  extends JceStruct
{
  static Map<String, String> cache_dc_report = new HashMap();
  public String cover_url = "";
  public Map<String, String> dc_report = null;
  public boolean need_show_related = false;
  public String nick_name = "";
  public String pull_weishi_alg_id = "";
  public int pull_weishi_mask = 0;
  public String related_button_text = "";
  public String weishi_clipbrd = "";
  public String weishi_download_url = "";
  public String weishi_feedId = "";
  public String weishi_fileId = "";
  public String weishi_musicId = "";
  public String weishi_musicName = "";
  public String weishi_musicUrl = "";
  public String weishi_pull_schema = "";
  public String weishi_schema = "";
  public String weishi_topicID = "";
  public String weishi_topicName = "";
  public String weishi_topicUrl = "";
  
  static
  {
    cache_dc_report.put("", "");
  }
  
  public s_weishi() {}
  
  public s_weishi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Map<String, String> paramMap, int paramInt, String paramString12, String paramString13, String paramString14, String paramString15, boolean paramBoolean, String paramString16)
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
    this.pull_weishi_mask = paramInt;
    this.weishi_download_url = paramString12;
    this.weishi_pull_schema = paramString13;
    this.weishi_clipbrd = paramString14;
    this.pull_weishi_alg_id = paramString15;
    this.need_show_related = paramBoolean;
    this.related_button_text = paramString16;
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
    this.pull_weishi_mask = paramJceInputStream.read(this.pull_weishi_mask, 12, false);
    this.weishi_download_url = paramJceInputStream.readString(13, false);
    this.weishi_pull_schema = paramJceInputStream.readString(14, false);
    this.weishi_clipbrd = paramJceInputStream.readString(15, false);
    this.pull_weishi_alg_id = paramJceInputStream.readString(16, false);
    this.need_show_related = paramJceInputStream.read(this.need_show_related, 17, false);
    this.related_button_text = paramJceInputStream.readString(18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.weishi_feedId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.weishi_fileId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.cover_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.nick_name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.weishi_musicId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.weishi_musicName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.weishi_musicUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.weishi_topicID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.weishi_topicName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.weishi_topicUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.weishi_schema;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.dc_report;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 11);
    }
    paramJceOutputStream.write(this.pull_weishi_mask, 12);
    localObject = this.weishi_download_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    localObject = this.weishi_pull_schema;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    localObject = this.weishi_clipbrd;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    localObject = this.pull_weishi_alg_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    paramJceOutputStream.write(this.need_show_related, 17);
    localObject = this.related_button_text;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_weishi
 * JD-Core Version:    0.7.0.1
 */