package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stOpVideo
  extends JceStruct
{
  static stSchema cache_jump = new stSchema();
  public String h5_url = "";
  public String img_url = "";
  public stSchema jump;
  public String schema = "";
  public String text = "";
  public int videoType;
  
  public stOpVideo() {}
  
  public stOpVideo(int paramInt, String paramString1, String paramString2, stSchema paramstSchema, String paramString3, String paramString4)
  {
    this.videoType = paramInt;
    this.h5_url = paramString1;
    this.schema = paramString2;
    this.jump = paramstSchema;
    this.text = paramString3;
    this.img_url = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.videoType = paramJceInputStream.read(this.videoType, 0, false);
    this.h5_url = paramJceInputStream.readString(1, false);
    this.schema = paramJceInputStream.readString(2, false);
    this.jump = ((stSchema)paramJceInputStream.read(cache_jump, 3, false));
    this.text = paramJceInputStream.readString(4, false);
    this.img_url = paramJceInputStream.readString(5, false);
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
    if (this.jump != null) {
      paramJceOutputStream.write(this.jump, 3);
    }
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 4);
    }
    if (this.img_url != null) {
      paramJceOutputStream.write(this.img_url, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stOpVideo
 * JD-Core Version:    0.7.0.1
 */