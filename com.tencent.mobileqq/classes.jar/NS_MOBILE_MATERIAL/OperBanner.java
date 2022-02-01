package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class OperBanner
  extends JceStruct
{
  static MaterialFile cache_stFile = new MaterialFile();
  public MaterialFile stFile = null;
  public String strH5JumpUrl = "";
  public String strSchema = "";
  
  public OperBanner() {}
  
  public OperBanner(MaterialFile paramMaterialFile, String paramString1, String paramString2)
  {
    this.stFile = paramMaterialFile;
    this.strSchema = paramString1;
    this.strH5JumpUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stFile = ((MaterialFile)paramJceInputStream.read(cache_stFile, 0, true));
    this.strSchema = paramJceInputStream.readString(1, false);
    this.strH5JumpUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stFile, 0);
    String str = this.strSchema;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strH5JumpUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.OperBanner
 * JD-Core Version:    0.7.0.1
 */