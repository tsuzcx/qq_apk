package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class common_gift_type_item
  extends JceStruct
{
  static ArrayList<s_gift_item> cache_common_gift_list;
  public ArrayList<s_gift_item> common_gift_list;
  public int item_type_id;
  public String name = "";
  public int total;
  
  public common_gift_type_item() {}
  
  public common_gift_type_item(int paramInt1, String paramString, ArrayList<s_gift_item> paramArrayList, int paramInt2)
  {
    this.item_type_id = paramInt1;
    this.name = paramString;
    this.common_gift_list = paramArrayList;
    this.total = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.item_type_id = paramJceInputStream.read(this.item_type_id, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    if (cache_common_gift_list == null)
    {
      cache_common_gift_list = new ArrayList();
      s_gift_item locals_gift_item = new s_gift_item();
      cache_common_gift_list.add(locals_gift_item);
    }
    this.common_gift_list = ((ArrayList)paramJceInputStream.read(cache_common_gift_list, 2, false));
    this.total = paramJceInputStream.read(this.total, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.item_type_id, 0);
    paramJceOutputStream.write(this.name, 1);
    if (this.common_gift_list != null) {
      paramJceOutputStream.write(this.common_gift_list, 2);
    }
    paramJceOutputStream.write(this.total, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.common_gift_type_item
 * JD-Core Version:    0.7.0.1
 */