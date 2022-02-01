package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stTabInfo
  extends JceStruct
{
  static stSchema cache_schema = new stSchema();
  public String displayIcon = "";
  public int displayType = 0;
  public int id = 0;
  public String name = "";
  public stSchema schema = null;
  
  public stTabInfo() {}
  
  public stTabInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, stSchema paramstSchema)
  {
    this.name = paramString1;
    this.id = paramInt1;
    this.displayType = paramInt2;
    this.displayIcon = paramString2;
    this.schema = paramstSchema;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.name = paramJceInputStream.readString(0, false);
    this.id = paramJceInputStream.read(this.id, 1, false);
    this.displayType = paramJceInputStream.read(this.displayType, 2, false);
    this.displayIcon = paramJceInputStream.readString(3, false);
    this.schema = ((stSchema)paramJceInputStream.read(cache_schema, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 0);
    }
    paramJceOutputStream.write(this.id, 1);
    paramJceOutputStream.write(this.displayType, 2);
    if (this.displayIcon != null) {
      paramJceOutputStream.write(this.displayIcon, 3);
    }
    if (this.schema != null) {
      paramJceOutputStream.write(this.schema, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stTabInfo
 * JD-Core Version:    0.7.0.1
 */