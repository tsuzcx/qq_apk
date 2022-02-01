package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMagicBrand
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  public String icon = "";
  public stSchema schema = null;
  public String text = "";
  public int type = 0;
  
  public stMagicBrand() {}
  
  public stMagicBrand(int paramInt, String paramString1, String paramString2, stSchema paramstSchema)
  {
    this.type = paramInt;
    this.icon = paramString1;
    this.text = paramString2;
    this.schema = paramstSchema;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.icon = paramJceInputStream.readString(1, false);
    this.text = paramJceInputStream.readString(2, false);
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    Object localObject = this.icon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.text;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.schema;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stMagicBrand
 * JD-Core Version:    0.7.0.1
 */