package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class comm_page_info
  extends JceStruct
{
  public boolean has_more;
  public String page_str = "";
  
  public comm_page_info() {}
  
  public comm_page_info(String paramString, boolean paramBoolean)
  {
    this.page_str = paramString;
    this.has_more = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.page_str = paramJceInputStream.readString(0, false);
    this.has_more = paramJceInputStream.read(this.has_more, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.page_str != null) {
      paramJceOutputStream.write(this.page_str, 0);
    }
    paramJceOutputStream.write(this.has_more, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.comm_page_info
 * JD-Core Version:    0.7.0.1
 */