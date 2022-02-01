package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UrlRsp
  extends JceStruct
{
  public int code;
  public String url = "";
  public int url_type;
  
  public UrlRsp() {}
  
  public UrlRsp(int paramInt1, String paramString, int paramInt2)
  {
    this.code = paramInt1;
    this.url = paramString;
    this.url_type = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    this.url = paramJceInputStream.readString(1, false);
    this.url_type = paramJceInputStream.read(this.url_type, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    String str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.url_type, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.UrlRsp
 * JD-Core Version:    0.7.0.1
 */