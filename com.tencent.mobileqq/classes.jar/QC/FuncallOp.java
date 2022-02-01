package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FuncallOp
  extends JceStruct
{
  public String fuzz_image_url = "";
  public String image_url = "";
  public String media_url = "";
  public String small_image_url = "";
  public String thumb_nail_url = "";
  
  public FuncallOp() {}
  
  public FuncallOp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.media_url = paramString1;
    this.image_url = paramString2;
    this.small_image_url = paramString3;
    this.thumb_nail_url = paramString4;
    this.fuzz_image_url = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.media_url = paramJceInputStream.readString(0, false);
    this.image_url = paramJceInputStream.readString(1, false);
    this.small_image_url = paramJceInputStream.readString(2, false);
    this.thumb_nail_url = paramJceInputStream.readString(3, false);
    this.fuzz_image_url = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.media_url;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.image_url;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.small_image_url;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.thumb_nail_url;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.fuzz_image_url;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.FuncallOp
 * JD-Core Version:    0.7.0.1
 */