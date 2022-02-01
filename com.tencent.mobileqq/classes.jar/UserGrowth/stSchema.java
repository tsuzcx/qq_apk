package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSchema
  extends JceStruct
{
  public String H5Url = "";
  public String miniAppSchema = "";
  public String qqSchema = "";
  public String schema = "";
  public int type = 0;
  
  public stSchema() {}
  
  public stSchema(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.type = paramInt;
    this.schema = paramString1;
    this.miniAppSchema = paramString2;
    this.H5Url = paramString3;
    this.qqSchema = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.schema = paramJceInputStream.readString(1, false);
    this.miniAppSchema = paramJceInputStream.readString(2, false);
    this.H5Url = paramJceInputStream.readString(3, false);
    this.qqSchema = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    String str = this.schema;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.miniAppSchema;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.H5Url;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.qqSchema;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stSchema
 * JD-Core Version:    0.7.0.1
 */