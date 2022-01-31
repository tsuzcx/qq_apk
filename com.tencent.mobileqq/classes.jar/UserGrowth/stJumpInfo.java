package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stJumpInfo
  extends JceStruct
{
  static Map<String, String> cache_mapExt = new HashMap();
  public String h5url = "";
  public int id;
  public int index;
  public Map<String, String> mapExt;
  public String schema_url = "";
  public String text = "";
  public String trace_id = "";
  public String url = "";
  
  static
  {
    cache_mapExt.put("", "");
  }
  
  public stJumpInfo() {}
  
  public stJumpInfo(int paramInt1, String paramString1, String paramString2, Map<String, String> paramMap, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    this.index = paramInt1;
    this.url = paramString1;
    this.text = paramString2;
    this.mapExt = paramMap;
    this.id = paramInt2;
    this.h5url = paramString3;
    this.schema_url = paramString4;
    this.trace_id = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.index = paramJceInputStream.read(this.index, 0, false);
    this.url = paramJceInputStream.readString(1, false);
    this.text = paramJceInputStream.readString(2, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 3, false));
    this.id = paramJceInputStream.read(this.id, 4, false);
    this.h5url = paramJceInputStream.readString(5, false);
    this.schema_url = paramJceInputStream.readString(6, false);
    this.trace_id = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.index, 0);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 1);
    }
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 2);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 3);
    }
    paramJceOutputStream.write(this.id, 4);
    if (this.h5url != null) {
      paramJceOutputStream.write(this.h5url, 5);
    }
    if (this.schema_url != null) {
      paramJceOutputStream.write(this.schema_url, 6);
    }
    if (this.trace_id != null) {
      paramJceOutputStream.write(this.trace_id, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stJumpInfo
 * JD-Core Version:    0.7.0.1
 */