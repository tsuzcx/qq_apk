package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_photo_layer
  extends JceStruct
{
  public String button_text = "";
  public String layer_text = "";
  public String layer_title = "";
  public int opmask;
  
  public cell_photo_layer() {}
  
  public cell_photo_layer(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.opmask = paramInt;
    this.layer_title = paramString1;
    this.layer_text = paramString2;
    this.button_text = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.opmask = paramJceInputStream.read(this.opmask, 0, false);
    this.layer_title = paramJceInputStream.readString(1, false);
    this.layer_text = paramJceInputStream.readString(2, false);
    this.button_text = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.opmask, 0);
    if (this.layer_title != null) {
      paramJceOutputStream.write(this.layer_title, 1);
    }
    if (this.layer_text != null) {
      paramJceOutputStream.write(this.layer_text, 2);
    }
    if (this.button_text != null) {
      paramJceOutputStream.write(this.button_text, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_photo_layer
 * JD-Core Version:    0.7.0.1
 */