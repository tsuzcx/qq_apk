package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupLabel
  extends JceStruct
{
  static Color cache_edging_color;
  static Color cache_text_color;
  public Color edging_color = null;
  public String strWording = "";
  public Color text_color = null;
  public long type = 0L;
  
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
    Object localObject = this.strWording;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.text_color;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    paramJceOutputStream.write(this.type, 2);
    localObject = this.edging_color;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NearbyGroup.GroupLabel
 * JD-Core Version:    0.7.0.1
 */