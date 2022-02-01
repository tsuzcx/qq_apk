package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetCategoryDetailReqItem
  extends JceStruct
{
  static int cache_type;
  public String categoryid = "";
  public String page_str = "";
  public int type = 1;
  
  public GetCategoryDetailReqItem() {}
  
  public GetCategoryDetailReqItem(String paramString1, String paramString2, int paramInt)
  {
    this.categoryid = paramString1;
    this.page_str = paramString2;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.categoryid = paramJceInputStream.readString(0, false);
    this.page_str = paramJceInputStream.readString(1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.categoryid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.page_str;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.type, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetCategoryDetailReqItem
 * JD-Core Version:    0.7.0.1
 */