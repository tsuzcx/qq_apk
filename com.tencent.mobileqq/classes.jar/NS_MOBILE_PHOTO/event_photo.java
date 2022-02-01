package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class event_photo
  extends JceStruct
{
  static Map<String, String> cache_ext;
  static lbs_info cache_lbs = new lbs_info();
  static byte[] cache_longTag;
  public Map<String, String> ext = null;
  public lbs_info lbs = null;
  public byte[] longTag = null;
  public long modifytime = 0L;
  public String picid = "";
  public long shoottime = 0L;
  public long tag = 0L;
  
  static
  {
    cache_ext = new HashMap();
    cache_ext.put("", "");
    cache_longTag = (byte[])new byte[1];
    ((byte[])cache_longTag)[0] = 0;
  }
  
  public event_photo() {}
  
  public event_photo(String paramString, long paramLong1, lbs_info paramlbs_info, long paramLong2, Map<String, String> paramMap, long paramLong3, byte[] paramArrayOfByte)
  {
    this.picid = paramString;
    this.shoottime = paramLong1;
    this.lbs = paramlbs_info;
    this.tag = paramLong2;
    this.ext = paramMap;
    this.modifytime = paramLong3;
    this.longTag = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picid = paramJceInputStream.readString(0, false);
    this.shoottime = paramJceInputStream.read(this.shoottime, 1, true);
    this.lbs = ((lbs_info)paramJceInputStream.read(cache_lbs, 2, true));
    this.tag = paramJceInputStream.read(this.tag, 3, false);
    this.ext = ((Map)paramJceInputStream.read(cache_ext, 4, false));
    this.modifytime = paramJceInputStream.read(this.modifytime, 5, false);
    this.longTag = ((byte[])paramJceInputStream.read(cache_longTag, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.picid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.shoottime, 1);
    paramJceOutputStream.write(this.lbs, 2);
    paramJceOutputStream.write(this.tag, 3);
    localObject = this.ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
    paramJceOutputStream.write(this.modifytime, 5);
    localObject = this.longTag;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.event_photo
 * JD-Core Version:    0.7.0.1
 */