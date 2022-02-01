package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_event_tag
  extends JceStruct
{
  static Map<String, String> cache_extendInfo;
  static s_join_list cache_join_list = new s_join_list();
  public String backgd_picurl = "";
  public String count_desc = "";
  public Map<String, String> extendInfo = null;
  public String id = "";
  public boolean is_default = false;
  public s_join_list join_list = null;
  public int pic_height = 0;
  public String pic_url = "";
  public int pic_width = 0;
  public String show_desc = "";
  public String show_txt = "";
  public long time = 0L;
  public String title = "";
  public long uin = 0L;
  public boolean update_flag = false;
  public long view_count = 0L;
  
  static
  {
    cache_extendInfo = new HashMap();
    cache_extendInfo.put("", "");
  }
  
  public s_event_tag() {}
  
  public s_event_tag(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, s_join_list params_join_list, boolean paramBoolean1, Map<String, String> paramMap, long paramLong3, String paramString7, boolean paramBoolean2)
  {
    this.uin = paramLong1;
    this.time = paramLong2;
    this.id = paramString1;
    this.title = paramString2;
    this.show_txt = paramString3;
    this.show_desc = paramString4;
    this.pic_url = paramString5;
    this.pic_width = paramInt1;
    this.pic_height = paramInt2;
    this.count_desc = paramString6;
    this.join_list = params_join_list;
    this.is_default = paramBoolean1;
    this.extendInfo = paramMap;
    this.view_count = paramLong3;
    this.backgd_picurl = paramString7;
    this.update_flag = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.time = paramJceInputStream.read(this.time, 1, false);
    this.id = paramJceInputStream.readString(2, false);
    this.title = paramJceInputStream.readString(3, false);
    this.show_txt = paramJceInputStream.readString(4, false);
    this.show_desc = paramJceInputStream.readString(5, false);
    this.pic_url = paramJceInputStream.readString(6, false);
    this.pic_width = paramJceInputStream.read(this.pic_width, 7, false);
    this.pic_height = paramJceInputStream.read(this.pic_height, 8, false);
    this.count_desc = paramJceInputStream.readString(9, false);
    this.join_list = ((s_join_list)paramJceInputStream.read(cache_join_list, 10, false));
    this.is_default = paramJceInputStream.read(this.is_default, 11, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 12, false));
    this.view_count = paramJceInputStream.read(this.view_count, 13, false);
    this.backgd_picurl = paramJceInputStream.readString(14, false);
    this.update_flag = paramJceInputStream.read(this.update_flag, 15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.time, 1);
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 2);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 3);
    }
    if (this.show_txt != null) {
      paramJceOutputStream.write(this.show_txt, 4);
    }
    if (this.show_desc != null) {
      paramJceOutputStream.write(this.show_desc, 5);
    }
    if (this.pic_url != null) {
      paramJceOutputStream.write(this.pic_url, 6);
    }
    paramJceOutputStream.write(this.pic_width, 7);
    paramJceOutputStream.write(this.pic_height, 8);
    if (this.count_desc != null) {
      paramJceOutputStream.write(this.count_desc, 9);
    }
    if (this.join_list != null) {
      paramJceOutputStream.write(this.join_list, 10);
    }
    paramJceOutputStream.write(this.is_default, 11);
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 12);
    }
    paramJceOutputStream.write(this.view_count, 13);
    if (this.backgd_picurl != null) {
      paramJceOutputStream.write(this.backgd_picurl, 14);
    }
    paramJceOutputStream.write(this.update_flag, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_event_tag
 * JD-Core Version:    0.7.0.1
 */