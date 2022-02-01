package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class single_detail
  extends JceStruct
{
  static ArrayList<Map<Integer, byte[]>> cache_recomfeeds;
  static Map<Integer, byte[]> cache_singledetail = new HashMap();
  public String feed_attach_info = "";
  public String feed_info = "";
  public String feedskey = "";
  public ArrayList<Map<Integer, byte[]>> recomfeeds = null;
  public Map<Integer, byte[]> singledetail;
  public long status = 0L;
  public int time = 0;
  public long uContainerSubType = 0L;
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Object localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_singledetail.put(localInteger, localObject);
    cache_recomfeeds = new ArrayList();
    localObject = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    ((Map)localObject).put(localInteger, arrayOfByte);
    cache_recomfeeds.add(localObject);
  }
  
  public single_detail() {}
  
  public single_detail(Map<Integer, byte[]> paramMap, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt, ArrayList<Map<Integer, byte[]>> paramArrayList, long paramLong2)
  {
    this.singledetail = paramMap;
    this.status = paramLong1;
    this.feed_info = paramString1;
    this.feed_attach_info = paramString2;
    this.feedskey = paramString3;
    this.time = paramInt;
    this.recomfeeds = paramArrayList;
    this.uContainerSubType = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.singledetail = ((Map)paramJceInputStream.read(cache_singledetail, 0, false));
    this.status = paramJceInputStream.read(this.status, 1, false);
    this.feed_info = paramJceInputStream.readString(2, false);
    this.feed_attach_info = paramJceInputStream.readString(3, false);
    this.feedskey = paramJceInputStream.readString(4, false);
    this.time = paramJceInputStream.read(this.time, 5, false);
    this.recomfeeds = ((ArrayList)paramJceInputStream.read(cache_recomfeeds, 6, false));
    this.uContainerSubType = paramJceInputStream.read(this.uContainerSubType, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.singledetail;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.single_detail
 * JD-Core Version:    0.7.0.1
 */