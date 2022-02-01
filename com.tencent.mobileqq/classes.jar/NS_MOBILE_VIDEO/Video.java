package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class Video
  extends JceStruct
{
  static Map<Integer, String> cache_cover;
  static Map<Integer, String> cache_map_urls = new HashMap();
  public int appid = 0;
  public Map<Integer, String> cover = null;
  public String desc = "";
  public int file_size = 0;
  public int height = 0;
  public String lloc = "";
  public Map<Integer, String> map_urls = null;
  public long play_time = 0L;
  public int play_type = 0;
  public int rights = 0;
  public long status = 0L;
  public String subid = "";
  public String tid = "";
  public long timestamp = 0L;
  public String toast = "";
  public String ugckey = "";
  public long uin = 0L;
  public String vid = "";
  public int visitor_num = 0;
  public int width = 0;
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    cache_map_urls.put(localInteger, "");
    cache_cover = new HashMap();
    cache_cover.put(localInteger, "");
  }
  
  public Video() {}
  
  public Video(long paramLong1, String paramString1, long paramLong2, long paramLong3, Map<Integer, String> paramMap1, int paramInt1, Map<Integer, String> paramMap2, int paramInt2, long paramLong4, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString6, String paramString7)
  {
    this.uin = paramLong1;
    this.vid = paramString1;
    this.timestamp = paramLong2;
    this.play_time = paramLong3;
    this.map_urls = paramMap1;
    this.file_size = paramInt1;
    this.cover = paramMap2;
    this.rights = paramInt2;
    this.status = paramLong4;
    this.toast = paramString2;
    this.tid = paramString3;
    this.desc = paramString4;
    this.visitor_num = paramInt3;
    this.ugckey = paramString5;
    this.play_type = paramInt4;
    this.width = paramInt5;
    this.height = paramInt6;
    this.appid = paramInt7;
    this.subid = paramString6;
    this.lloc = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.vid = paramJceInputStream.readString(1, false);
    this.timestamp = paramJceInputStream.read(this.timestamp, 2, false);
    this.play_time = paramJceInputStream.read(this.play_time, 3, false);
    this.map_urls = ((Map)paramJceInputStream.read(cache_map_urls, 4, false));
    this.file_size = paramJceInputStream.read(this.file_size, 5, false);
    this.cover = ((Map)paramJceInputStream.read(cache_cover, 6, false));
    this.rights = paramJceInputStream.read(this.rights, 7, false);
    this.status = paramJceInputStream.read(this.status, 8, false);
    this.toast = paramJceInputStream.readString(9, false);
    this.tid = paramJceInputStream.readString(10, false);
    this.desc = paramJceInputStream.readString(11, false);
    this.visitor_num = paramJceInputStream.read(this.visitor_num, 12, false);
    this.ugckey = paramJceInputStream.readString(13, false);
    this.play_type = paramJceInputStream.read(this.play_type, 14, false);
    this.width = paramJceInputStream.read(this.width, 15, false);
    this.height = paramJceInputStream.read(this.height, 16, false);
    this.appid = paramJceInputStream.read(this.appid, 17, false);
    this.subid = paramJceInputStream.readString(18, false);
    this.lloc = paramJceInputStream.readString(19, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    Object localObject = this.vid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.timestamp, 2);
    paramJceOutputStream.write(this.play_time, 3);
    localObject = this.map_urls;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
    paramJceOutputStream.write(this.file_size, 5);
    localObject = this.cover;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
    paramJceOutputStream.write(this.rights, 7);
    paramJceOutputStream.write(this.status, 8);
    localObject = this.toast;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.tid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    paramJceOutputStream.write(this.visitor_num, 12);
    localObject = this.ugckey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    paramJceOutputStream.write(this.play_type, 14);
    paramJceOutputStream.write(this.width, 15);
    paramJceOutputStream.write(this.height, 16);
    paramJceOutputStream.write(this.appid, 17);
    localObject = this.subid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 18);
    }
    localObject = this.lloc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.Video
 * JD-Core Version:    0.7.0.1
 */