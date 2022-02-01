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
    Object localObject = this.jump;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.text;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.imgUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFunctionalIconInfo
 * JD-Core Version:    0.7.0.1
 */