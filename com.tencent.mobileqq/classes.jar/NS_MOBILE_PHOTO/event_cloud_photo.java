package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picurl;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class event_cloud_photo
  extends JceStruct
{
  static Map<Integer, s_picurl> cache_specUrls = new HashMap();
  public String albumid = "";
  public String lloc = "";
  public long owner;
  public Map<Integer, s_picurl> specUrls;
  public int type;
  public long uploadTime;
  
  static
  {
    s_picurl locals_picurl = new s_picurl();
    cache_specUrls.put(Integer.valueOf(0), locals_picurl);
  }
  
  public event_cloud_photo() {}
  
  public event_cloud_photo(long paramLong1, String paramString1, String paramString2, long paramLong2, int paramInt, Map<Integer, s_picurl> paramMap)
  {
    this.owner = paramLong1;
    this.albumid = paramString1;
    this.lloc = paramString2;
    this.uploadTime = paramLong2;
    this.type = paramInt;
    this.specUrls = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.owner = paramJceInputStream.read(this.owner, 0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.lloc = paramJceInputStream.readString(2, true);
    this.uploadTime = paramJceInputStream.read(this.uploadTime, 5, true);
    this.type = paramJceInputStream.read(this.type, 10, false);
    this.specUrls = ((Map)paramJceInputStream.read(cache_specUrls, 11, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.owner, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.lloc, 2);
    paramJceOutputStream.write(this.uploadTime, 5);
    paramJceOutputStream.write(this.type, 10);
    if (this.specUrls != null) {
      paramJceOutputStream.write(this.specUrls, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.event_cloud_photo
 * JD-Core Version:    0.7.0.1
 */