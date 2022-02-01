package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stBusinessIconInfo
  extends JceStruct
{
  static stBusinessAdCard cache_adCard = new stBusinessAdCard();
  static stIconButton cache_button;
  static Map<String, String> cache_mapExt;
  static stSchema cache_schema = new stSchema();
  public stBusinessAdCard adCard = null;
  public stIconButton button = null;
  public int cardSwitch = 0;
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
  
  public stBusinessIconInfo(stSchema paramstSchema, stIconButton paramstIconButton, int paramInt1, Map<String, String> paramMap, stBusinessAdCard paramstBusinessAdCard, int paramInt2)
  {
    this.schema = paramstSchema;
    this.button = paramstIconButton;
    this.type = paramInt1;
    this.mapExt = paramMap;
    this.adCard = paramstBusinessAdCard;
    this.cardSwitch = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 0, false));
    this.button = ((stIconButton)paramJceInputStream.read(cache_button, 1, false));
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 3, false));
    this.adCard = ((stBusinessAdCard)paramJceInputStream.read(cache_adCard, 4, false));
    this.cardSwitch = paramJceInputStream.read(this.cardSwitch, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.schema;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.button;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    paramJceOutputStream.write(this.type, 2);
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    localObject = this.adCard;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    paramJceOutputStream.write(this.cardSwitch, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stBusinessIconInfo
 * JD-Core Version:    0.7.0.1
 */