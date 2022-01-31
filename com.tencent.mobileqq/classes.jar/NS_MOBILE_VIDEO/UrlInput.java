package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UrlInput
  extends JceStruct
{
  public String url_detail = "";
  public int url_type;
  
  public UrlInput() {}
  
  public UrlInput(int paramInt, String paramString)
  {
    this.url_type = paramInt;
    this.url_detail = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url_type = paramJceInputStream.read(this.url_type, 0, false);
    this.url_detail = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.url_type, 0);
    if (this.url_detail != null) {
      paramJceOutputStream.write(this.url_detail, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_VIDEO.UrlInput
 * JD-Core Version:    0.7.0.1
 */