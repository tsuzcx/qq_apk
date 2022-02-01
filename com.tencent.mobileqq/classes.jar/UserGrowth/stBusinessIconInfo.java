package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stBusinessIconInfo
  extends JceStruct
{
  static stIconButton cache_button;
  static Map<String, String> cache_mapExt;
  static stSchema cache_schema = new stSchema();
  public stIconButton button = null;
  public Map<String, String> mapExt = null;
  public stSchema schema = null;
  public int type = 0;
  
  static
  {
    cache_button = new stIconButton();
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public stBusinessIconInfo() {}
  
  public stBusinessIconInfo(stSchema paramstSchema, stIconButton paramstIconButton, int paramInt, Map<String, String> paramMap)
  {
    this.schema = paramstSchema;
    this.button = paramstIconButton;
    this.type = paramInt;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 0, false));
    this.button = ((stIconButton)paramJceInputStream.read(cache_button, 1, false));
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.schema != null) {
      paramJceOutputStream.write(this.schema, 0);
    }
    if (this.button != null) {
      paramJceOutputStream.write(this.button, 1);
    }
    paramJceOutputStream.write(this.type, 2);
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stBusinessIconInfo
 * JD-Core Version:    0.7.0.1
 */