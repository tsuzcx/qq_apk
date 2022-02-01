package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_tab_list
  extends JceStruct
{
  static ArrayList<s_tab_list_item> cache_lst_hide;
  static ArrayList<s_tab_list_item> cache_lst_show = new ArrayList();
  public ArrayList<s_tab_list_item> lst_hide = null;
  public ArrayList<s_tab_list_item> lst_show = null;
  
  static
  {
    s_tab_list_item locals_tab_list_item = new s_tab_list_item();
    cache_lst_show.add(locals_tab_list_item);
    cache_lst_hide = new ArrayList();
    locals_tab_list_item = new s_tab_list_item();
    cache_lst_hide.add(locals_tab_list_item);
  }
  
  public s_tab_list() {}
  
  public s_tab_list(ArrayList<s_tab_list_item> paramArrayList1, ArrayList<s_tab_list_item> paramArrayList2)
  {
    this.lst_show = paramArrayList1;
    this.lst_hide = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lst_show = ((ArrayList)paramJceInputStream.read(cache_lst_show, 0, true));
    this.lst_hide = ((ArrayList)paramJceInputStream.read(cache_lst_hide, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lst_show, 0);
    paramJceOutputStream.write(this.lst_hide, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_tab_list
 * JD-Core Version:    0.7.0.1
 */