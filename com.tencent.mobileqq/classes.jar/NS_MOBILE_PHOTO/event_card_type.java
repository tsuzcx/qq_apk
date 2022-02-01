package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class event_card_type
  extends JceStruct
{
  static Map<String, String> cache_element;
  static int cache_type = 0;
  public int coverHeight = 0;
  public String coverUrl = "";
  public int coverWidth = 0;
  public Map<String, String> element = null;
  public String h5Url = "";
  public int headHeight = 0;
  public String headUrl = "";
  public int headWidth = 0;
  public String subtitle = "";
  public String summery = "";
  public int type = 0;
  
  static
  {
    cache_element = new HashMap();
    cache_element.put("", "");
  }
  
  public event_card_type() {}
  
  public event_card_type(int paramInt1, String paramString1, Map<String, String> paramMap, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.type = paramInt1;
    this.summery = paramString1;
    this.element = paramMap;
    this.subtitle = paramString2;
    this.coverUrl = paramString3;
    this.headUrl = paramString4;
    this.h5Url = paramString5;
    this.coverWidth = paramInt2;
    this.coverHeight = paramInt3;
    this.headWidth = paramInt4;
    this.headHeight = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.summery = paramJceInputStream.readString(1, false);
    this.element = ((Map)paramJceInputStream.read(cache_element, 2, false));
    this.subtitle = paramJceInputStream.readString(3, false);
    this.coverUrl = paramJceInputStream.readString(4, false);
    this.headUrl = paramJceInputStream.readString(5, false);
    this.h5Url = paramJceInputStream.readString(6, false);
    this.coverWidth = paramJceInputStream.read(this.coverWidth, 7, false);
    this.coverHeight = paramJceInputStream.read(this.coverHeight, 8, false);
    this.headWidth = paramJceInputStream.read(this.headWidth, 9, false);
    this.headHeight = paramJceInputStream.read(this.headHeight, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.summery != null) {
      paramJceOutputStream.write(this.summery, 1);
    }
    if (this.element != null) {
      paramJceOutputStream.write(this.element, 2);
    }
    if (this.subtitle != null) {
      paramJceOutputStream.write(this.subtitle, 3);
    }
    if (this.coverUrl != null) {
      paramJceOutputStream.write(this.coverUrl, 4);
    }
    if (this.headUrl != null) {
      paramJceOutputStream.write(this.headUrl, 5);
    }
    if (this.h5Url != null) {
      paramJceOutputStream.write(this.h5Url, 6);
    }
    paramJceOutputStream.write(this.coverWidth, 7);
    paramJceOutputStream.write(this.coverHeight, 8);
    paramJceOutputStream.write(this.headWidth, 9);
    paramJceOutputStream.write(this.headHeight, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.event_card_type
 * JD-Core Version:    0.7.0.1
 */