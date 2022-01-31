package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class newest_feeds_rsp
  extends JceStruct
{
  static Map cache_mapVcByte;
  static ArrayList cache_vec_feed_info = new ArrayList();
  public int code;
  public long last_feed_time;
  public Map mapVcByte;
  public String str_attach = "";
  public ArrayList vec_feed_info;
  
  static
  {
    Object localObject = new feed_info();
    cache_vec_feed_info.add(localObject);
    cache_mapVcByte = new HashMap();
    localObject = new QzoneData();
    cache_mapVcByte.put(Long.valueOf(0L), localObject);
  }
  
  public newest_feeds_rsp() {}
  
  public newest_feeds_rsp(int paramInt, ArrayList paramArrayList, long paramLong, String paramString, Map paramMap)
  {
    this.code = paramInt;
    this.vec_feed_info = paramArrayList;
    this.last_feed_time = paramLong;
    this.str_attach = paramString;
    this.mapVcByte = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    this.vec_feed_info = ((ArrayList)paramJceInputStream.read(cache_vec_feed_info, 1, false));
    this.last_feed_time = paramJceInputStream.read(this.last_feed_time, 2, false);
    this.str_attach = paramJceInputStream.readString(3, false);
    this.mapVcByte = ((Map)paramJceInputStream.read(cache_mapVcByte, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    if (this.vec_feed_info != null) {
      paramJceOutputStream.write(this.vec_feed_info, 1);
    }
    paramJceOutputStream.write(this.last_feed_time, 2);
    if (this.str_attach != null) {
      paramJceOutputStream.write(this.str_attach, 3);
    }
    if (this.mapVcByte != null) {
      paramJceOutputStream.write(this.mapVcByte, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp
 * JD-Core Version:    0.7.0.1
 */