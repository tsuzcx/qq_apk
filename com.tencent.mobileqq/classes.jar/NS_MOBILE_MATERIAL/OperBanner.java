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
    if (this.strSchema != null) {
      paramJceOutputStream.write(this.strSchema, 1);
    }
    if (this.strH5JumpUrl != null) {
      paramJceOutputStream.write(this.strH5JumpUrl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.OperBanner
 * JD-Core Version:    0.7.0.1
 */