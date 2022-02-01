package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stNewIconStyle
  extends JceStruct
{
  static Map<String, String> cache_exp = new HashMap();
  public Map<String, String> exp = null;
  public String h5_url = "";
  public String iconUrl = "";
  public int id = 0;
  public String img_url = "";
  public String schema_url = "";
  public int tag_type = 0;
  public String title = "";
  
  static
  {
    cache_exp.put("", "");
  }
  
  public stNewIconStyle() {}
  
  public stNewIconStyle(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, Map<String, String> paramMap)
  {
    this.title = paramString1;
    this.tag_type = paramInt1;
    this.iconUrl = paramString2;
    this.img_url = paramString3;
    this.h5_url = paramString4;
    this.schema_url = paramString5;
    this.id = paramInt2;
    this.exp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.tag_type = paramJceInputStream.read(this.tag_type, 1, false);
    this.iconUrl = paramJceInputStream.readString(2, false);
    this.img_url = paramJceInputStream.readString(3, false);
    this.h5_url = paramJceInputStream.readString(4, false);
    this.schema_url = paramJceInputStream.readString(5, false);
    this.id = paramJceInputStream.read(this.id, 6, false);
    this.exp = ((Map)paramJceInputStream.read(cache_exp, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.tag_type, 1);
    localObject = this.iconUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.img_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.h5_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.schema_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.id, 6);
    localObject = this.exp;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stNewIconStyle
 * JD-Core Version:    0.7.0.1
 */