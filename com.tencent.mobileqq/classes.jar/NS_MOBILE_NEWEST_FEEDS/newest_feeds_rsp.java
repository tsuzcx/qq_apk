package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class newest_feeds_rsp
  extends JceStruct
{
  static Map<Long, String> cache_mapExt;
  static Map<Long, QzoneData> cache_mapVcByte;
  static ArrayList<feed_info> cache_vec_feed_info = new ArrayList();
  public int code = 0;
  public long last_feed_time = 0L;
  public Map<Long, String> mapExt = null;
  public Map<Long, QzoneData> mapVcByte = null;
  public String str_attach = "";
  public long uNextTime = 0L;
  public ArrayList<feed_info> vec_feed_info = null;
  
  static
  {
    Object localObject = new feed_info();
    cache_vec_feed_info.add(localObject);
    cache_mapVcByte = new HashMap();
    localObject = Long.valueOf(0L);
    QzoneData localQzoneData = new QzoneData();
    cache_mapVcByte.put(localObject, localQzoneData);
    cache_mapExt = new HashMap();
    cache_mapExt.put(localObject, "");
  }
  
  public newest_feeds_rsp() {}
  
  public newest_feeds_rsp(int paramInt, ArrayList<feed_info> paramArrayList, long paramLong1, String paramString, Map<Long, QzoneData> paramMap, Map<Long, String> paramMap1, long paramLong2)
  {
    this.code = paramInt;
    this.vec_feed_info = paramArrayList;
    this.last_feed_time = paramLong1;
    this.str_attach = paramString;
    this.mapVcByte = paramMap;
    this.mapExt = paramMap1;
    this.uNextTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    this.vec_feed_info = ((ArrayList)paramJceInputStream.read(cache_vec_feed_info, 1, false));
    this.last_feed_time = paramJceInputStream.read(this.last_feed_time, 2, false);
    this.str_attach = paramJceInputStream.readString(3, false);
    this.mapVcByte = ((Map)paramJceInputStream.read(cache_mapVcByte, 4, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 5, false));
    this.uNextTime = paramJceInputStream.read(this.uNextTime, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    Object localObject = this.vec_feed_info;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    paramJceOutputStream.write(this.last_feed_time, 2);
    localObject = this.str_attach;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.mapVcByte;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
    paramJceOutputStream.write(this.uNextTime, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp
 * JD-Core Version:    0.7.0.1
 */