package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class QQValueInfoItem
  extends JceStruct
{
  static Map<String, String> cache_qqvalue_ext_info = new HashMap();
  public int level = 0;
  public String material_id = "";
  public int on_off = 0;
  public Map<String, String> qqvalue_ext_info = null;
  public int score = 0;
  public int trend = 0;
  public String url = "";
  
  static
  {
    cache_qqvalue_ext_info.put("", "");
  }
  
  public QQValueInfoItem() {}
  
  public QQValueInfoItem(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2, Map<String, String> paramMap)
  {
    this.score = paramInt1;
    this.level = paramInt2;
    this.trend = paramInt3;
    this.url = paramString1;
    this.on_off = paramInt4;
    this.material_id = paramString2;
    this.qqvalue_ext_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.score = paramJceInputStream.read(this.score, 0, false);
    this.level = paramJceInputStream.read(this.level, 1, false);
    this.trend = paramJceInputStream.read(this.trend, 2, false);
    this.url = paramJceInputStream.readString(4, false);
    this.on_off = paramJceInputStream.read(this.on_off, 5, false);
    this.material_id = paramJceInputStream.readString(6, false);
    this.qqvalue_ext_info = ((Map)paramJceInputStream.read(cache_qqvalue_ext_info, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.score, 0);
    paramJceOutputStream.write(this.level, 1);
    paramJceOutputStream.write(this.trend, 2);
    Object localObject = this.url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.on_off, 5);
    localObject = this.material_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.qqvalue_ext_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.QQValueInfoItem
 * JD-Core Version:    0.7.0.1
 */