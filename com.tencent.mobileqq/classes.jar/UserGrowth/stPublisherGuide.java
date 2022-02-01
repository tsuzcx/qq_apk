package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPublisherGuide
  extends JceStruct
{
  public String btnText = "";
  public String desc = "";
  public int imageType = 0;
  public String imageUrl = "";
  
  public stPublisherGuide() {}
  
  public stPublisherGuide(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.imageUrl = paramString1;
    this.btnText = paramString2;
    this.desc = paramString3;
    this.imageType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imageUrl = paramJceInputStream.readString(0, false);
    this.btnText = paramJceInputStream.readString(1, false);
    this.desc = paramJceInputStream.readString(2, false);
    this.imageType = paramJceInputStream.read(this.imageType, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.imageUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.btnText;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.desc;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.imageType, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stPublisherGuide
 * JD-Core Version:    0.7.0.1
 */