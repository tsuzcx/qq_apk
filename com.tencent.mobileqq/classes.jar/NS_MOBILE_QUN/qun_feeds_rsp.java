package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class qun_feeds_rsp
  extends JceStruct
{
  static ArrayList<single_feed> cache_all_feeds_data;
  public ArrayList<single_feed> all_feeds_data;
  public String attach_info = "";
  public int auto_load;
  public int hasmore;
  
  public qun_feeds_rsp() {}
  
  public qun_feeds_rsp(int paramInt1, String paramString, ArrayList<single_feed> paramArrayList, int paramInt2)
  {
    this.hasmore = paramInt1;
    this.attach_info = paramString;
    this.all_feeds_data = paramArrayList;
    this.auto_load = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 0, false);
    this.attach_info = paramJceInputStream.readString(1, false);
    if (cache_all_feeds_data == null)
    {
      cache_all_feeds_data = new ArrayList();
      single_feed localsingle_feed = new single_feed();
      cache_all_feeds_data.add(localsingle_feed);
    }
    this.all_feeds_data = ((ArrayList)paramJceInputStream.read(cache_all_feeds_data, 2, false));
    this.auto_load = paramJceInputStream.read(this.auto_load, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasmore, 0);
    Object localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.all_feeds_data;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    paramJceOutputStream.write(this.auto_load, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_feeds_rsp
 * JD-Core Version:    0.7.0.1
 */