package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class event_card_type
  extends JceStruct
{
  static Map<String, String> cache_element = new HashMap();
  static int cache_type;
  public int coverHeight = 0;
  public String coverUrl = "";
  public int coverWidth = 0;
  public Map<String, String> element = null;
  public String h5Url = "";
  public int headHeight = 0;
  public String headUrl = "";
  public int headWidth = 0;
  public int rank = 0;
  public String subtitle = "";
  public String summery = "";
  public int type = 0;
  
  static
  {
    cache_element.put("", "");
  }
  
  public event_card_type() {}
  
  public event_card_type(int paramInt1, String paramString1, Map<String, String> paramMap, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
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
    this.rank = paramInt6;
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
    this.rank = paramJceInputStream.read(this.rank, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    Object localObject = this.summery;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.element;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    localObject = this.subtitle;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.coverUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.headUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.h5Url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.coverWidth, 7);
    paramJceOutputStream.write(this.coverHeight, 8);
    paramJceOutputStream.write(this.headWidth, 9);
    paramJceOutputStream.write(this.headHeight, 10);
    paramJceOutputStream.write(this.rank, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.event_card_type
 * JD-Core Version:    0.7.0.1
 */