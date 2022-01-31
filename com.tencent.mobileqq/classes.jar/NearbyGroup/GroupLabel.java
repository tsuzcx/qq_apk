package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupLabel
  extends JceStruct
{
  static Color cache_edging_color;
  static Color cache_text_color;
  public Color edging_color;
  public String strWording = "";
  public Color text_color;
  public long type;
  
  public GroupLabel() {}
  
  public GroupLabel(String paramString, Color paramColor1, long paramLong, Color paramColor2)
  {
    this.strWording = paramString;
    this.text_color = paramColor1;
    this.type = paramLong;
    this.edging_color = paramColor2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strWording = paramJceInputStream.readString(0, false);
    if (cache_text_color == null) {
      cache_text_color = new Color();
    }
    this.text_color = ((Color)paramJceInputStream.read(cache_text_color, 1, false));
    this.type = paramJceInputStream.read(this.type, 2, false);
    if (cache_edging_color == null) {
      cache_edging_color = new Color();
    }
    this.edging_color = ((Color)paramJceInputStream.read(cache_edging_color, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strWording != null) {
      paramJceOutputStream.write(this.strWording, 0);
    }
    if (this.text_color != null) {
      paramJceOutputStream.write(this.text_color, 1);
    }
    paramJceOutputStream.write(this.type, 2);
    if (this.edging_color != null) {
      paramJceOutputStream.write(this.edging_color, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NearbyGroup.GroupLabel
 * JD-Core Version:    0.7.0.1
 */