package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class pendantStageConfig
  extends JceStruct
{
  static Map<String, String> cache_exp = new HashMap();
  public int duration = 0;
  public Map<String, String> exp = null;
  public String h5url = "";
  public String icon_url = "";
  public String scheme_url = "";
  public String text_button = "";
  public String text_description = "";
  public String text_title = "";
  public String url = "";
  
  static
  {
    cache_exp.put("", "");
  }
  
  public pendantStageConfig() {}
  
  public pendantStageConfig(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, Map<String, String> paramMap)
  {
    this.text_title = paramString1;
    this.text_description = paramString2;
    this.text_button = paramString3;
    this.icon_url = paramString4;
    this.url = paramString5;
    this.duration = paramInt;
    this.h5url = paramString6;
    this.scheme_url = paramString7;
    this.exp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.text_title = paramJceInputStream.readString(0, false);
    this.text_description = paramJceInputStream.readString(1, false);
    this.text_button = paramJceInputStream.readString(2, false);
    this.icon_url = paramJceInputStream.readString(3, false);
    this.url = paramJceInputStream.readString(4, false);
    this.duration = paramJceInputStream.read(this.duration, 5, false);
    this.h5url = paramJceInputStream.readString(6, false);
    this.scheme_url = paramJceInputStream.readString(7, false);
    this.exp = ((Map)paramJceInputStream.read(cache_exp, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.text_title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.text_description;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.text_button;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.icon_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.duration, 5);
    localObject = this.h5url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.scheme_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.exp;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.pendantStageConfig
 * JD-Core Version:    0.7.0.1
 */