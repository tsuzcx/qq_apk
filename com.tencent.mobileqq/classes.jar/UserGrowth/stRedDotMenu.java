package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stRedDotMenu
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  public String imageUrl = "";
  public String menuKey = "";
  public stSchema schema = null;
  public String text = "";
  
  public stRedDotMenu() {}
  
  public stRedDotMenu(String paramString1, stSchema paramstSchema, String paramString2, String paramString3)
  {
    this.menuKey = paramString1;
    this.schema = paramstSchema;
    this.text = paramString2;
    this.imageUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.menuKey = paramJceInputStream.readString(0, false);
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 1, false));
    this.text = paramJceInputStream.readString(2, false);
    this.imageUrl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.menuKey != null) {
      paramJceOutputStream.write(this.menuKey, 0);
    }
    if (this.schema != null) {
      paramJceOutputStream.write(this.schema, 1);
    }
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 2);
    }
    if (this.imageUrl != null) {
      paramJceOutputStream.write(this.imageUrl, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stRedDotMenu
 * JD-Core Version:    0.7.0.1
 */