package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaUgcImage
  extends JceStruct
{
  public int height;
  public int sprite_height;
  public int sprite_span;
  public int sprite_width;
  public int type;
  public String url = "";
  public int width;
  
  public stMetaUgcImage() {}
  
  public stMetaUgcImage(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.url = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.type = paramInt3;
    this.sprite_width = paramInt4;
    this.sprite_height = paramInt5;
    this.sprite_span = paramInt6;
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
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 0);
    }
    paramJceOutputStream.write(this.width, 1);
    paramJceOutputStream.write(this.height, 2);
    paramJceOutputStream.write(this.type, 3);
    paramJceOutputStream.write(this.sprite_width, 4);
    paramJceOutputStream.write(this.sprite_height, 5);
    paramJceOutputStream.write(this.sprite_span, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaUgcImage
 * JD-Core Version:    0.7.0.1
 */