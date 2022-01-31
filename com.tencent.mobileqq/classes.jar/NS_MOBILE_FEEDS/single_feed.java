package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
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
  public long feeds_update_time;
  public String feedskey = "";
  public int iUnifyRecomType;
  public Map<Integer, byte[]> patch_singlefeed;
  public boolean pullAll;
  public ArrayList<Map<Integer, byte[]>> recomfeeds;
  public Map<Integer, byte[]> singlefeed;
  public long status;
  public int time;
  public long uContainerSubType;
  
  static
  {
    Object localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_singlefeed.put(Integer.valueOf(0), localObject);
    cache_recomfeeds = new ArrayList();
    localObject = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    ((Map)localObject).put(Integer.valueOf(0), arrayOfByte);
    cache_recomfeeds.add(localObject);
    cache_patch_singlefeed = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_patch_singlefeed.put(Integer.valueOf(0), localObject);
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
    if (this.singlefeed != null) {
      paramJceOutputStream.write(this.singlefeed, 0);
    }
    paramJceOutputStream.write(this.status, 1);
    if (this.feed_info != null) {
      paramJceOutputStream.write(this.feed_info, 2);
    }
    if (this.feed_attach_info != null) {
      paramJceOutputStream.write(this.feed_attach_info, 3);
    }
    if (this.feedskey != null) {
      paramJceOutputStream.write(this.feedskey, 4);
    }
    paramJceOutputStream.write(this.time, 5);
    if (this.recomfeeds != null) {
      paramJceOutputStream.write(this.recomfeeds, 6);
    }
    paramJceOutputStream.write(this.uContainerSubType, 7);
    if (this.patch_singlefeed != null) {
      paramJceOutputStream.write(this.patch_singlefeed, 8);
    }
    paramJceOutputStream.write(this.feeds_update_time, 9);
    paramJceOutputStream.write(this.pullAll, 10);
    paramJceOutputStream.write(this.iUnifyRecomType, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.single_feed
 * JD-Core Version:    0.7.0.1
 */