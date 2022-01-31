package PROTO_EXT_TO_UGCSVR;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Font
  extends JceStruct
{
  static int cache_font_size = 0;
  public int font_size;
  
  public Font() {}
  
  public Font(int paramInt)
  {
    this.font_size = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.font_size = paramJceInputStream.read(this.font_size, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.font_size, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     PROTO_EXT_TO_UGCSVR.Font
 * JD-Core Version:    0.7.0.1
 */