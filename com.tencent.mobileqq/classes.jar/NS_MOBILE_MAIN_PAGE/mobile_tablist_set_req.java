package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_tablist_set_req
  extends JceStruct
{
  static s_tab_list cache_tab_lst = new s_tab_list();
  public boolean is_mq = true;
  public s_tab_list tab_lst = null;
  public long uin = 0L;
  
  public mobile_tablist_set_req() {}
  
  public mobile_tablist_set_req(long paramLong, s_tab_list params_tab_list, boolean paramBoolean)
  {
    this.uin = paramLong;
    this.tab_lst = params_tab_list;
    this.is_mq = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.tab_lst = ((s_tab_list)paramJceInputStream.read(cache_tab_lst, 1, true));
    this.is_mq = paramJceInputStream.read(this.is_mq, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.tab_lst, 1);
    paramJceOutputStream.write(this.is_mq, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_tablist_set_req
 * JD-Core Version:    0.7.0.1
 */