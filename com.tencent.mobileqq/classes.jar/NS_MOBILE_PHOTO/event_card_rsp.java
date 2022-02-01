package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class event_card_rsp
  extends JceStruct
{
  static Map<String, String> cache_ext;
  static ArrayList<event_group> cache_groups = new ArrayList();
  public Map<String, String> ext = null;
  public ArrayList<event_group> groups = null;
  public int reset = 0;
  public String start_cardid = "";
  public long uin = 0L;
  
  static
  {
    event_group localevent_group = new event_group();
    cache_groups.add(localevent_group);
    cache_ext = new HashMap();
    cache_ext.put("", "");
  }
  
  public event_card_rsp() {}
  
  public event_card_rsp(long paramLong, ArrayList<event_group> paramArrayList, String paramString, Map<String, String> paramMap, int paramInt)
  {
    this.uin = paramLong;
    this.groups = paramArrayList;
    this.start_cardid = paramString;
    this.ext = paramMap;
    this.reset = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.groups = ((ArrayList)paramJceInputStream.read(cache_groups, 1, true));
    this.start_cardid = paramJceInputStream.readString(2, false);
    this.ext = ((Map)paramJceInputStream.read(cache_ext, 3, false));
    this.reset = paramJceInputStream.read(this.reset, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.groups, 1);
    if (this.start_cardid != null) {
      paramJceOutputStream.write(this.start_cardid, 2);
    }
    if (this.ext != null) {
      paramJceOutputStream.write(this.ext, 3);
    }
    paramJceOutputStream.write(this.reset, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.event_card_rsp
 * JD-Core Version:    0.7.0.1
 */