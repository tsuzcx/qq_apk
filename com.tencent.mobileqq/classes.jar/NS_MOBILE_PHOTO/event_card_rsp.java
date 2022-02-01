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
  public boolean gray_status = false;
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
  
  public event_card_rsp(long paramLong, ArrayList<event_group> paramArrayList, String paramString, Map<String, String> paramMap, int paramInt, boolean paramBoolean)
  {
    this.uin = paramLong;
    this.groups = paramArrayList;
    this.start_cardid = paramString;
    this.ext = paramMap;
    this.reset = paramInt;
    this.gray_status = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.groups = ((ArrayList)paramJceInputStream.read(cache_groups, 1, true));
    this.start_cardid = paramJceInputStream.readString(2, false);
    this.ext = ((Map)paramJceInputStream.read(cache_ext, 3, false));
    this.reset = paramJceInputStream.read(this.reset, 4, false);
    this.gray_status = paramJceInputStream.read(this.gray_status, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.groups, 1);
    Object localObject = this.start_cardid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    paramJceOutputStream.write(this.reset, 4);
    paramJceOutputStream.write(this.gray_status, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.event_card_rsp
 * JD-Core Version:    0.7.0.1
 */