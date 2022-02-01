package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class event_card_req
  extends JceStruct
{
  static ArrayList<event_card> cache_cards;
  static Map<String, String> cache_extern;
  static lbs_info cache_lbs = new lbs_info();
  public ArrayList<event_card> cards = null;
  public Map<String, String> extern = null;
  public lbs_info lbs = null;
  public long uin = 0L;
  
  static
  {
    cache_cards = new ArrayList();
    event_card localevent_card = new event_card();
    cache_cards.add(localevent_card);
    cache_extern = new HashMap();
    cache_extern.put("", "");
  }
  
  public event_card_req() {}
  
  public event_card_req(long paramLong, lbs_info paramlbs_info, ArrayList<event_card> paramArrayList, Map<String, String> paramMap)
  {
    this.uin = paramLong;
    this.lbs = paramlbs_info;
    this.cards = paramArrayList;
    this.extern = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.lbs = ((lbs_info)paramJceInputStream.read(cache_lbs, 1, true));
    this.cards = ((ArrayList)paramJceInputStream.read(cache_cards, 2, true));
    this.extern = ((Map)paramJceInputStream.read(cache_extern, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.lbs, 1);
    paramJceOutputStream.write(this.cards, 2);
    Map localMap = this.extern;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.event_card_req
 * JD-Core Version:    0.7.0.1
 */