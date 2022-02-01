package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_recomm_item
  extends JceStruct
{
  static Map<String, String> cache_extendinfo;
  static s_picurl cache_icon_after_click;
  static s_picurl cache_icon_before_click;
  static s_user cache_userinfo = new s_user();
  public int ButtonType = 0;
  public String content = "";
  public String desc_after_click = "";
  public String desc_before_click = "";
  public Map<String, String> extendinfo = null;
  public s_picurl icon_after_click = null;
  public s_picurl icon_before_click = null;
  public s_user userinfo = null;
  
  static
  {
    cache_icon_before_click = new s_picurl();
    cache_icon_after_click = new s_picurl();
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public cell_recomm_item() {}
  
  public cell_recomm_item(s_user params_user, s_picurl params_picurl1, s_picurl params_picurl2, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, int paramInt)
  {
    this.userinfo = params_user;
    this.icon_before_click = params_picurl1;
    this.icon_after_click = params_picurl2;
    this.desc_before_click = paramString1;
    this.desc_after_click = paramString2;
    this.content = paramString3;
    this.extendinfo = paramMap;
    this.ButtonType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.userinfo = ((s_user)paramJceInputStream.read(cache_userinfo, 0, false));
    this.icon_before_click = ((s_picurl)paramJceInputStream.read(cache_icon_before_click, 1, false));
    this.icon_after_click = ((s_picurl)paramJceInputStream.read(cache_icon_after_click, 2, false));
    this.desc_before_click = paramJceInputStream.readString(3, false);
    this.desc_after_click = paramJceInputStream.readString(4, false);
    this.content = paramJceInputStream.readString(5, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 6, false));
    this.ButtonType = paramJceInputStream.read(this.ButtonType, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.userinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.icon_before_click;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.icon_after_click;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.desc_before_click;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.desc_after_click;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
    paramJceOutputStream.write(this.ButtonType, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_recomm_item
 * JD-Core Version:    0.7.0.1
 */