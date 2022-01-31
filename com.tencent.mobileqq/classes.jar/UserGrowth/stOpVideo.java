package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stOpVideo
  extends JceStruct
{
  public String h5_url = "";
  public String schema = "";
  public int videoType;
  
  public stOpVideo() {}
  
  public stOpVideo(int paramInt, String paramString1, String paramString2)
  {
    this.videoType = paramInt;
    this.h5_url = paramString1;
    this.schema = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.videoType = paramJceInputStream.read(this.videoType, 0, false);
    this.h5_url = paramJceInputStream.readString(1, false);
    this.schema = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.videoType, 0);
    if (this.h5_url != null) {
      paramJceOutputStream.write(this.h5_url, 1);
    }
    if (this.schema != null) {
      paramJceOutputStream.write(this.schema, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stOpVideo
 * JD-Core Version:    0.7.0.1
 */