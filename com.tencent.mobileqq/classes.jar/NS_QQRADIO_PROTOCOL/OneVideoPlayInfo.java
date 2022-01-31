package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class OneVideoPlayInfo
  extends JceStruct
{
  public int definition;
  public String url = "";
  public int vbitrate;
  public int vheight;
  public int vwidth;
  
  public OneVideoPlayInfo() {}
  
  public OneVideoPlayInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.url = paramString;
    this.definition = paramInt1;
    this.vbitrate = paramInt2;
    this.vheight = paramInt3;
    this.vwidth = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, false);
    this.definition = paramJceInputStream.read(this.definition, 1, false);
    this.vbitrate = paramJceInputStream.read(this.vbitrate, 2, false);
    this.vheight = paramJceInputStream.read(this.vheight, 3, false);
    this.vwidth = paramJceInputStream.read(this.vwidth, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 0);
    }
    paramJceOutputStream.write(this.definition, 1);
    paramJceOutputStream.write(this.vbitrate, 2);
    paramJceOutputStream.write(this.vheight, 3);
    paramJceOutputStream.write(this.vwidth, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQRADIO_PROTOCOL.OneVideoPlayInfo
 * JD-Core Version:    0.7.0.1
 */