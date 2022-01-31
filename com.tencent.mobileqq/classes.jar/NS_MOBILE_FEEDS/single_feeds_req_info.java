package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class single_feeds_req_info
  extends JceStruct
{
  static ArrayList cache_all_commont_list = new ArrayList();
  public ArrayList all_commont_list;
  public int appId;
  public long feeds_time;
  public boolean pullAll = true;
  public String ugc_key = "";
  public long uin;
  
  static
  {
    SimpleComment localSimpleComment = new SimpleComment();
    cache_all_commont_list.add(localSimpleComment);
  }
  
  public single_feeds_req_info() {}
  
  public single_feeds_req_info(long paramLong1, int paramInt, long paramLong2, String paramString, ArrayList paramArrayList, boolean paramBoolean)
  {
    this.uin = paramLong1;
    this.appId = paramInt;
    this.feeds_time = paramLong2;
    this.ugc_key = paramString;
    this.all_commont_list = paramArrayList;
    this.pullAll = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.appId = paramJceInputStream.read(this.appId, 1, false);
    this.feeds_time = paramJceInputStream.read(this.feeds_time, 2, false);
    this.ugc_key = paramJceInputStream.readString(3, false);
    this.all_commont_list = ((ArrayList)paramJceInputStream.read(cache_all_commont_list, 4, false));
    this.pullAll = paramJceInputStream.read(this.pullAll, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.appId, 1);
    paramJceOutputStream.write(this.feeds_time, 2);
    if (this.ugc_key != null) {
      paramJceOutputStream.write(this.ugc_key, 3);
    }
    if (this.all_commont_list != null) {
      paramJceOutputStream.write(this.all_commont_list, 4);
    }
    paramJceOutputStream.write(this.pullAll, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.single_feeds_req_info
 * JD-Core Version:    0.7.0.1
 */