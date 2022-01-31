package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_canvas
  extends JceStruct
{
  public String canvas_data = "";
  public String guide_text = "";
  public int jump_type = 0;
  public boolean show_breath_light = true;
  public boolean show_guide_bar = true;
  
  public cell_canvas() {}
  
  public cell_canvas(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.guide_text = paramString1;
    this.canvas_data = paramString2;
    this.jump_type = paramInt;
    this.show_breath_light = paramBoolean1;
    this.show_guide_bar = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.guide_text = paramJceInputStream.readString(0, false);
    this.canvas_data = paramJceInputStream.readString(1, false);
    this.jump_type = paramJceInputStream.read(this.jump_type, 2, false);
    this.show_breath_light = paramJceInputStream.read(this.show_breath_light, 3, false);
    this.show_guide_bar = paramJceInputStream.read(this.show_guide_bar, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.guide_text != null) {
      paramJceOutputStream.write(this.guide_text, 0);
    }
    if (this.canvas_data != null) {
      paramJceOutputStream.write(this.canvas_data, 1);
    }
    paramJceOutputStream.write(this.jump_type, 2);
    paramJceOutputStream.write(this.show_breath_light, 3);
    paramJceOutputStream.write(this.show_guide_bar, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_canvas
 * JD-Core Version:    0.7.0.1
 */