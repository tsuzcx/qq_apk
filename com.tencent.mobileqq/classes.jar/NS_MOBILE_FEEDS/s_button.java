package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_button
  extends JceStruct
{
  static Map<String, String> cache_extendinfo;
  static Map<Integer, Integer> cache_stMapABTest = new HashMap();
  public int actiontype = 0;
  public String actionurl = "";
  public int animation_duration = 0;
  public String animation_url = "";
  public int appear_time = 0;
  public String button_background_img = "";
  public String button_icon = "";
  public String button_img = "";
  public int duration_time = 0;
  public Map<String, String> extendinfo = null;
  public Map<Integer, Integer> stMapABTest = null;
  public String text = "";
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    cache_stMapABTest.put(localInteger, localInteger);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public s_button() {}
  
  public s_button(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, Map<Integer, Integer> paramMap, int paramInt2, int paramInt3, String paramString6, int paramInt4, Map<String, String> paramMap1)
  {
    this.text = paramString1;
    this.actiontype = paramInt1;
    this.actionurl = paramString2;
    this.button_img = paramString3;
    this.button_background_img = paramString4;
    this.button_icon = paramString5;
    this.stMapABTest = paramMap;
    this.appear_time = paramInt2;
    this.duration_time = paramInt3;
    this.animation_url = paramString6;
    this.animation_duration = paramInt4;
    this.extendinfo = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.text = paramJceInputStream.readString(0, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 1, false);
    this.actionurl = paramJceInputStream.readString(2, false);
    this.button_img = paramJceInputStream.readString(3, false);
    this.button_background_img = paramJceInputStream.readString(4, false);
    this.button_icon = paramJceInputStream.readString(5, false);
    this.stMapABTest = ((Map)paramJceInputStream.read(cache_stMapABTest, 6, false));
    this.appear_time = paramJceInputStream.read(this.appear_time, 7, false);
    this.duration_time = paramJceInputStream.read(this.duration_time, 8, false);
    this.animation_url = paramJceInputStream.readString(9, false);
    this.animation_duration = paramJceInputStream.read(this.animation_duration, 10, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 11, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.text;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.actiontype, 1);
    localObject = this.actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.button_img;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.button_background_img;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.button_icon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.stMapABTest;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
    paramJceOutputStream.write(this.appear_time, 7);
    paramJceOutputStream.write(this.duration_time, 8);
    localObject = this.animation_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    paramJceOutputStream.write(this.animation_duration, 10);
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_button
 * JD-Core Version:    0.7.0.1
 */