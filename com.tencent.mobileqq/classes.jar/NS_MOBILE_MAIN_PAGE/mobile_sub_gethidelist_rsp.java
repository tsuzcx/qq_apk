package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_gethidelist_rsp
  extends JceStruct
{
  static s_hidelist cache_hidelist;
  public s_hidelist hidelist;
  
  public mobile_sub_gethidelist_rsp() {}
  
  public mobile_sub_gethidelist_rsp(s_hidelist params_hidelist)
  {
    this.hidelist = params_hidelist;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_hidelist == null) {
      cache_hidelist = new s_hidelist();
    }
    this.hidelist = ((s_hidelist)paramJceInputStream.read(cache_hidelist, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.hidelist != null) {
      paramJceOutputStream.write(this.hidelist, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_gethidelist_rsp
 * JD-Core Version:    0.7.0.1
 */