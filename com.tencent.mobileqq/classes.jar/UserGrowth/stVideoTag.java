package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stVideoTag
  extends JceStruct
{
  public String bgColor = "";
  public String imgUrl = "";
  public int tagId = 0;
  public String text = "";
  public String textColor = "";
  
  public stVideoTag() {}
  
  public stVideoTag(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.tagId = paramInt;
    this.imgUrl = paramString1;
    this.text = paramString2;
    this.textColor = paramString3;
    this.bgColor = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tagId = paramJceInputStream.read(this.tagId, 0, false);
    this.imgUrl = paramJceInputStream.readString(1, false);
    this.text = paramJceInputStream.readString(2, false);
    this.textColor = paramJceInputStream.readString(3, false);
    this.bgColor = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tagId, 0);
    String str = this.imgUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.text;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.textColor;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.bgColor;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stVideoTag
 * JD-Core Version:    0.7.0.1
 */