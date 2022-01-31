package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSchema
  extends JceStruct
{
  public String H5Url = "";
  public String miniAppSchema = "";
  public String schema = "";
  public int type;
  
  public stSchema() {}
  
  public stSchema(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.type = paramInt;
    this.schema = paramString1;
    this.miniAppSchema = paramString2;
    this.H5Url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.schema = paramJceInputStream.readString(1, false);
    this.miniAppSchema = paramJceInputStream.readString(2, false);
    this.H5Url = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.schema != null) {
      paramJceOutputStream.write(this.schema, 1);
    }
    if (this.miniAppSchema != null) {
      paramJceOutputStream.write(this.miniAppSchema, 2);
    }
    if (this.H5Url != null) {
      paramJceOutputStream.write(this.H5Url, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stSchema
 * JD-Core Version:    0.7.0.1
 */