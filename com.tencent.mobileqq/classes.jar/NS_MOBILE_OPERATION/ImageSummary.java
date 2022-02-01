package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ImageSummary
  extends JceStruct
{
  public String bubbleUrl = "";
  public String imageId = "";
  public int source_id = 0;
  public String url = "";
  
  public ImageSummary() {}
  
  public ImageSummary(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.imageId = paramString1;
    this.url = paramString2;
    this.bubbleUrl = paramString3;
    this.source_id = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imageId = paramJceInputStream.readString(0, true);
    this.url = paramJceInputStream.readString(1, false);
    this.bubbleUrl = paramJceInputStream.readString(2, false);
    this.source_id = paramJceInputStream.read(this.source_id, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imageId, 0);
    String str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.bubbleUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.source_id, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.ImageSummary
 * JD-Core Version:    0.7.0.1
 */