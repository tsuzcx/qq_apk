package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_premovie_adv
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param;
  static s_premovie_item cache_premovie = new s_premovie_item();
  static Map<Integer, String> cache_report_cookie;
  public Map<Integer, String> busi_param;
  public s_premovie_item premovie;
  public Map<Integer, String> report_cookie;
  
  static
  {
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_report_cookie = new HashMap();
    cache_report_cookie.put(Integer.valueOf(0), "");
  }
  
  public s_premovie_adv() {}
  
  public s_premovie_adv(s_premovie_item params_premovie_item, Map<Integer, String> paramMap1, Map<Integer, String> paramMap2)
  {
    this.premovie = params_premovie_item;
    this.busi_param = paramMap1;
    this.report_cookie = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.premovie = ((s_premovie_item)paramJceInputStream.read(cache_premovie, 0, false));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 1, false));
    this.report_cookie = ((Map)paramJceInputStream.read(cache_report_cookie, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.premovie != null) {
      paramJceOutputStream.write(this.premovie, 0);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 1);
    }
    if (this.report_cookie != null) {
      paramJceOutputStream.write(this.report_cookie, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_premovie_adv
 * JD-Core Version:    0.7.0.1
 */