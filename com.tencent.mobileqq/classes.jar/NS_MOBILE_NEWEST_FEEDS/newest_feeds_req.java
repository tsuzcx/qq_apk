package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class newest_feeds_req
  extends JceStruct
{
  static Map cache_mapUinTimes;
  static ArrayList cache_vec_uinlist = new ArrayList();
  public int cmd;
  public long last_feed_time;
  public long login_uin;
  public Map mapUinTimes;
  public String strQua = "";
  public String str_attach = "";
  public ArrayList vec_uinlist;
  
  static
  {
    cache_vec_uinlist.add(Long.valueOf(0L));
    cache_mapUinTimes = new HashMap();
    cache_mapUinTimes.put(Long.valueOf(0L), Long.valueOf(0L));
  }
  
  public newest_feeds_req() {}
  
  public newest_feeds_req(int paramInt, long paramLong1, ArrayList paramArrayList, long paramLong2, String paramString1, String paramString2, Map paramMap)
  {
    this.cmd = paramInt;
    this.login_uin = paramLong1;
    this.vec_uinlist = paramArrayList;
    this.last_feed_time = paramLong2;
    this.str_attach = paramString1;
    this.strQua = paramString2;
    this.mapUinTimes = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmd = paramJceInputStream.read(this.cmd, 0, false);
    this.login_uin = paramJceInputStream.read(this.login_uin, 1, false);
    this.vec_uinlist = ((ArrayList)paramJceInputStream.read(cache_vec_uinlist, 2, false));
    this.last_feed_time = paramJceInputStream.read(this.last_feed_time, 3, false);
    this.str_attach = paramJceInputStream.readString(4, false);
    this.strQua = paramJceInputStream.readString(5, false);
    this.mapUinTimes = ((Map)paramJceInputStream.read(cache_mapUinTimes, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmd, 0);
    paramJceOutputStream.write(this.login_uin, 1);
    if (this.vec_uinlist != null) {
      paramJceOutputStream.write(this.vec_uinlist, 2);
    }
    paramJceOutputStream.write(this.last_feed_time, 3);
    if (this.str_attach != null) {
      paramJceOutputStream.write(this.str_attach, 4);
    }
    if (this.strQua != null) {
      paramJceOutputStream.write(this.strQua, 5);
    }
    if (this.mapUinTimes != null) {
      paramJceOutputStream.write(this.mapUinTimes, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_NEWEST_FEEDS.newest_feeds_req
 * JD-Core Version:    0.7.0.1
 */