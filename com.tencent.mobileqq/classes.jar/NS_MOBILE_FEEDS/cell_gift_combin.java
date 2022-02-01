package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_gift_combin
  extends JceStruct
{
  static ArrayList<s_gift_item> cache_gifts = new ArrayList();
  public ArrayList<s_gift_item> gifts;
  
  static
  {
    s_gift_item locals_gift_item = new s_gift_item();
    cache_gifts.add(locals_gift_item);
  }
  
  public cell_gift_combin() {}
  
  public cell_gift_combin(ArrayList<s_gift_item> paramArrayList)
  {
    this.gifts = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.gifts = ((ArrayList)paramJceInputStream.read(cache_gifts, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.gifts;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_gift_combin
 * JD-Core Version:    0.7.0.1
 */