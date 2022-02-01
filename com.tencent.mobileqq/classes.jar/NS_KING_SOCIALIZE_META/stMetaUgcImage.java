package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaUgcImage
  extends JceStruct
{
  public String format = "";
  public int height = 0;
  public String photo_rgb = "";
  public int priority = 0;
  public int sprite_height = 0;
  public int sprite_span = 0;
  public int sprite_width = 0;
  public int type = 0;
  public String url = "";
  public int width = 0;
  
  public stMetaUgcImage() {}
  
  public stMetaUgcImage(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3)
  {
    this.url = paramString1;
    this.width = paramInt1;
    this.height = paramInt2;
    this.type = paramInt3;
    this.sprite_width = paramInt4;
    this.sprite_height = paramInt5;
    this.sprite_span = paramInt6;
    this.priority = paramInt7;
    this.photo_rgb = paramString2;
    this.format = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, false);
    this.width = paramJceInputStream.read(this.width, 1, false);
    this.height = paramJceInputStream.read(this.height, 2, false);
    this.type = paramJceInputStream.read(this.type, 3, false);
    this.sprite_width = paramJceInputStream.read(this.sprite_width, 4, false);
    this.sprite_height = paramJceInputStream.read(this.sprite_height, 5, false);
    this.sprite_span = paramJceInputStream.read(this.sprite_span, 6, false);
    this.priority = paramJceInputStream.read(this.priority, 7, false);
    this.photo_rgb = paramJceInputStream.readString(8, false);
    this.format = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.width, 1);
    paramJceOutputStream.write(this.height, 2);
    paramJceOutputStream.write(this.type, 3);
    paramJceOutputStream.write(this.sprite_width, 4);
    paramJceOutputStream.write(this.sprite_height, 5);
    paramJceOutputStream.write(this.sprite_span, 6);
    paramJceOutputStream.write(this.priority, 7);
    str = this.photo_rgb;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.format;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaUgcImage
 * JD-Core Version:    0.7.0.1
 */