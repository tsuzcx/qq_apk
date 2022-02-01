package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class single_feed
  extends JceStruct
{
  static Map<Integer, byte[]> cache_patch_singlefeed;
  static ArrayList<Map<Integer, byte[]>> cache_recomfeeds;
  static Map<Integer, byte[]> cache_singlefeed = new HashMap();
  public String feed_attach_info = "";
  public String feed_info = "";
  public long feeds_update_time = 0L;
  public String feedskey = "";
  public int iUnifyRecomType = 0;
  public Map<Integer, byte[]> patch_singlefeed = null;
  public boolean pullAll = false;
  public ArrayList<Map<Integer, byte[]>> recomfeeds = null;
  public Map<Integer, byte[]> singlefeed = null;
  public long status = 0L;
  public int time = 0;
  public long uContainerSubType = 0L;
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Object localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_singlefeed.put(localInteger, localObject);
    cache_recomfeeds = new ArrayList();
    localObject = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    ((Map)localObject).put(localInteger, arrayOfByte);
    cache_recomfeeds.add(localObject);
    cache_patch_singlefeed = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_patch_singlefeed.put(localInteger, localObject);
  }
  
  public single_feed() {}
  
  public single_feed(Map<Integer, byte[]> paramMap1, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, ArrayList<Map<Integer, byte[]>> paramArrayList, long paramLong2, Map<Integer, byte[]> paramMap2, long paramLong3, boolean paramBoolean, int paramInt2)
  {
    this.singlefeed = paramMap1;
    this.status = paramLong1;
    this.feed_info = paramString1;
    this.feed_attach_info = paramString2;
    this.feedskey = paramString3;
    this.time = paramInt1;
    this.recomfeeds = paramArrayList;
    this.uContainerSubType = paramLong2;
    this.patch_singlefeed = paramMap2;
    this.feeds_update_time = paramLong3;
    this.pullAll = paramBoolean;
    this.iUnifyRecomType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.singlefeed = ((Map)paramJceInputStream.read(cache_singlefeed, 0, false));
    this.status = paramJceInputStream.read(this.status, 1, false);
    this.feed_info = paramJceInputStream.readString(2, false);
    this.feed_attach_info = paramJceInputStream.readString(3, false);
    this.feedskey = paramJceInputStream.readString(4, false);
    this.time = paramJceInputStream.read(this.time, 5, false);
    this.recomfeeds = ((ArrayList)paramJceInputStream.read(cache_recomfeeds, 6, false));
    this.uContainerSubType = paramJceInputStream.read(this.uContainerSubType, 7, false);
    this.patch_singlefeed = ((Map)paramJceInputStream.read(cache_patch_singlefeed, 8, false));
    this.feeds_update_time = paramJceInputStream.read(this.feeds_update_time, 9, false);
    this.pullAll = paramJceInputStream.read(this.pullAll, 10, false);
    this.iUnifyRecomType = paramJceInputStream.read(this.iUnifyRecomType, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.singlefeed;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 0);
    }
    paramJceOutputStream.write(this.status, 1);
    localObject = this.feed_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.feed_attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.feedskey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.time, 5);
    localObject = this.recomfeeds;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
    paramJceOutputStream.write(this.uContainerSubType, 7);
    localObject = this.patch_singlefeed;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
    paramJceOutputStream.write(this.feeds_update_time, 9);
    paramJceOutputStream.write(this.pullAll, 10);
    paramJceOutputStream.write(this.iUnifyRecomType, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.single_feed
 * JD-Core Version:    0.7.0.1
 */