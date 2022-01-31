package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_set_visitor_notify_list_req
  extends JceStruct
{
  static ArrayList cache_fuin_vec;
  public ArrayList fuin_vec;
  public int operation;
  
  public mobile_set_visitor_notify_list_req() {}
  
  public mobile_set_visitor_notify_list_req(ArrayList paramArrayList, int paramInt)
  {
    this.fuin_vec = paramArrayList;
    this.operation = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_fuin_vec == null)
    {
      cache_fuin_vec = new ArrayList();
      cache_fuin_vec.add(Long.valueOf(0L));
    }
    this.fuin_vec = ((ArrayList)paramJceInputStream.read(cache_fuin_vec, 0, true));
    this.operation = paramJceInputStream.read(this.operation, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fuin_vec, 0);
    paramJceOutputStream.write(this.operation, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_set_visitor_notify_list_req
 * JD-Core Version:    0.7.0.1
 */