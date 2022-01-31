package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_tab_list_tmem
  extends JceStruct
{
  static ArrayList<Integer> cache_user_list = new ArrayList();
  public ArrayList<Integer> user_list;
  
  static
  {
    cache_user_list.add(Integer.valueOf(0));
  }
  
  public s_tab_list_tmem() {}
  
  public s_tab_list_tmem(ArrayList<Integer> paramArrayList)
  {
    this.user_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.user_list = ((ArrayList)paramJceInputStream.read(cache_user_list, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.user_list, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_tab_list_tmem
 * JD-Core Version:    0.7.0.1
 */