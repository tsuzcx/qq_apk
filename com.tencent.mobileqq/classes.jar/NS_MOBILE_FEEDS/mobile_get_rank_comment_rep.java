package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_get_rank_comment_rep
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  public Map<Integer, String> busi_param;
  public int icount;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public mobile_get_rank_comment_rep() {}
  
  public mobile_get_rank_comment_rep(int paramInt, Map<Integer, String> paramMap)
  {
    this.icount = paramInt;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.icount = paramJceInputStream.read(this.icount, 0, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.icount, 0);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_get_rank_comment_rep
 * JD-Core Version:    0.7.0.1
 */