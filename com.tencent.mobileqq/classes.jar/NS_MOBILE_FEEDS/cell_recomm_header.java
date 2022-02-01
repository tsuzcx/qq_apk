package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_recomm_header
  extends JceStruct
{
  static s_button cache_left_top_button = new s_button();
  static Map<String, s_picurl> cache_mapCoverUrl = new HashMap();
  static s_picurl cache_rightBgPic = new s_picurl();
  public String action_type = "";
  public String action_url = "";
  public byte btn_type = 0;
  public String custom_icon = "";
  public String desc = "";
  public int icon_height = 0;
  public int icon_width = 0;
  public String left_title = "";
  public s_button left_top_button = null;
  public Map<String, s_picurl> mapCoverUrl = null;
  public long recomm_uin = 0L;
  public s_picurl rightBgPic = null;
  public String right_title = "";
  
  static
  {
    s_picurl locals_picurl = new s_picurl();
    cache_mapCoverUrl.put("", locals_picurl);
  }
  
  public cell_recomm_header() {}
  
  public cell_recomm_header(String paramString1, byte paramByte, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, Map<String, s_picurl> paramMap, long paramLong, String paramString5, String paramString6, s_button params_button, s_picurl params_picurl)
  {
    this.left_title = paramString1;
    this.btn_type = paramByte;
    this.right_title = paramString2;
    this.custom_icon = paramString3;
    this.icon_width = paramInt1;
    this.icon_height = paramInt2;
    this.desc = paramString4;
    this.mapCoverUrl = paramMap;
    this.recomm_uin = paramLong;
    this.action_url = paramString5;
    this.action_type = paramString6;
    this.left_top_button = params_button;
    this.rightBgPic = params_picurl;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.left_title = paramJceInputStream.readString(0, false);
    this.btn_type = paramJceInputStream.read(this.btn_type, 1, false);
    this.right_title = paramJceInputStream.readString(2, false);
    this.custom_icon = paramJceInputStream.readString(3, false);
    this.icon_width = paramJceInputStream.read(this.icon_width, 4, false);
    this.icon_height = paramJceInputStream.read(this.icon_height, 5, false);
    this.desc = paramJceInputStream.readString(6, false);
    this.mapCoverUrl = ((Map)paramJceInputStream.read(cache_mapCoverUrl, 7, false));
    this.recomm_uin = paramJceInputStream.read(this.recomm_uin, 8, false);
    this.action_url = paramJceInputStream.readString(9, false);
    this.action_type = paramJceInputStream.readString(10, false);
    this.left_top_button = ((s_button)paramJceInputStream.read(cache_left_top_button, 11, false));
    this.rightBgPic = ((s_picurl)paramJceInputStream.read(cache_rightBgPic, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.left_title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.btn_type, 1);
    localObject = this.right_title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.custom_icon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.icon_width, 4);
    paramJceOutputStream.write(this.icon_height, 5);
    localObject = this.desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.mapCoverUrl;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 7);
    }
    paramJceOutputStream.write(this.recomm_uin, 8);
    localObject = this.action_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.action_type;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.left_top_button;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.rightBgPic;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_recomm_header
 * JD-Core Version:    0.7.0.1
 */