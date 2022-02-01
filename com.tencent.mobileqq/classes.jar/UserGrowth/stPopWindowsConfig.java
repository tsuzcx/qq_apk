package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stPopWindowsConfig
  extends JceStruct
{
  static stAnnexation cache_annexation;
  static Map<String, String> cache_exp;
  static stPopWindowsButton cache_jp_button = new stPopWindowsButton();
  public stAnnexation annexation = null;
  public String bg_img_url = "";
  public Map<String, String> exp = null;
  public String h5url = "";
  public int index = 0;
  public stPopWindowsButton jp_button = null;
  public String remark = "";
  public int scene = 0;
  public String schema_url = "";
  public String text = "";
  public String title = "";
  public String trace_id = "";
  public int type = 0;
  public int windowsid = 0;
  
  static
  {
    cache_annexation = new stAnnexation();
    cache_exp = new HashMap();
    cache_exp.put("", "");
  }
  
  public stPopWindowsConfig() {}
  
  public stPopWindowsConfig(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, stPopWindowsButton paramstPopWindowsButton, stAnnexation paramstAnnexation, int paramInt4, String paramString5, String paramString6, Map<String, String> paramMap, String paramString7)
  {
    this.windowsid = paramInt1;
    this.index = paramInt2;
    this.type = paramInt3;
    this.title = paramString1;
    this.text = paramString2;
    this.remark = paramString3;
    this.bg_img_url = paramString4;
    this.jp_button = paramstPopWindowsButton;
    this.annexation = paramstAnnexation;
    this.scene = paramInt4;
    this.h5url = paramString5;
    this.schema_url = paramString6;
    this.exp = paramMap;
    this.trace_id = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.windowsid = paramJceInputStream.read(this.windowsid, 0, false);
    this.index = paramJceInputStream.read(this.index, 1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.title = paramJceInputStream.readString(3, false);
    this.text = paramJceInputStream.readString(4, false);
    this.remark = paramJceInputStream.readString(5, false);
    this.bg_img_url = paramJceInputStream.readString(6, false);
    this.jp_button = ((stPopWindowsButton)paramJceInputStream.read(cache_jp_button, 7, false));
    this.annexation = ((stAnnexation)paramJceInputStream.read(cache_annexation, 8, false));
    this.scene = paramJceInputStream.read(this.scene, 9, false);
    this.h5url = paramJceInputStream.readString(11, false);
    this.schema_url = paramJceInputStream.readString(12, false);
    this.exp = ((Map)paramJceInputStream.read(cache_exp, 13, false));
    this.trace_id = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.windowsid, 0);
    paramJceOutputStream.write(this.index, 1);
    paramJceOutputStream.write(this.type, 2);
    Object localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.text;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.remark;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.bg_img_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.jp_button;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.annexation;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    paramJceOutputStream.write(this.scene, 9);
    localObject = this.h5url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.schema_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.exp;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 13);
    }
    localObject = this.trace_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stPopWindowsConfig
 * JD-Core Version:    0.7.0.1
 */