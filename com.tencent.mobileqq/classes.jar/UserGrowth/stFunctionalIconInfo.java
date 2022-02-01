package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFunctionalIconInfo
  extends JceStruct
{
  static stSchema cache_jump = new stSchema();
  public String imgUrl = "";
  public stSchema jump = null;
  public String text = "";
  
  public stFunctionalIconInfo() {}
  
  public stFunctionalIconInfo(stSchema paramstSchema, String paramString1, String paramString2)
  {
    this.jump = paramstSchema;
    this.text = paramString1;
    this.imgUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.jump = ((stSchema)paramJceInputStream.read(cache_jump, 0, false));
    this.text = paramJceInputStream.readString(1, false);
    this.imgUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.jump != null) {
      paramJceOutputStream.write(this.jump, 0);
    }
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 1);
    }
    if (this.imgUrl != null) {
      paramJceOutputStream.write(this.imgUrl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stFunctionalIconInfo
 * JD-Core Version:    0.7.0.1
 */