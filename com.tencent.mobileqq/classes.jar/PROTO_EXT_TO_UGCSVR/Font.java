package PROTO_EXT_TO_UGCSVR;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Font
  extends JceStruct
{
  static int cache_font_size = 0;
  static int cache_hideFlag = 0;
  public int font_size = 0;
  public int hideFlag = 0;
  
  public Font() {}
  
  public Font(int paramInt1, int paramInt2)
  {
    this.font_size = paramInt1;
    this.hideFlag = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.font_size = paramJceInputStream.read(this.font_size, 0, false);
    this.hideFlag = paramJceInputStream.read(this.hideFlag, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.font_size, 0);
    paramJceOutputStream.write(this.hideFlag, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     PROTO_EXT_TO_UGCSVR.Font
 * JD-Core Version:    0.7.0.1
 */