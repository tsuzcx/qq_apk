package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_limit_page_card
  extends JceStruct
{
  static ArrayList<s_limit_page_card_item> cache_lst_data = new ArrayList();
  public ArrayList<s_limit_page_card_item> lst_data;
  
  static
  {
    s_limit_page_card_item locals_limit_page_card_item = new s_limit_page_card_item();
    cache_lst_data.add(locals_limit_page_card_item);
  }
  
  public s_limit_page_card() {}
  
  public s_limit_page_card(ArrayList<s_limit_page_card_item> paramArrayList)
  {
    this.lst_data = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lst_data = ((ArrayList)paramJceInputStream.read(cache_lst_data, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lst_data, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_limit_page_card
 * JD-Core Version:    0.7.0.1
 */