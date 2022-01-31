package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_set_cover_rsp
  extends JceStruct
{
  static Map<String, String> cache_MulRelsotionUrl;
  public Map<String, String> MulRelsotionUrl;
  public long coverScene;
  public int ret;
  public long syncflag;
  
  public mobile_sub_set_cover_rsp() {}
  
  public mobile_sub_set_cover_rsp(int paramInt, Map<String, String> paramMap, long paramLong1, long paramLong2)
  {
    this.ret = paramInt;
    this.MulRelsotionUrl = paramMap;
    this.syncflag = paramLong1;
    this.coverScene = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    if (cache_MulRelsotionUrl == null)
    {
      cache_MulRelsotionUrl = new HashMap();
      cache_MulRelsotionUrl.put("", "");
    }
    this.MulRelsotionUrl = ((Map)paramJceInputStream.read(cache_MulRelsotionUrl, 1, false));
    this.syncflag = paramJceInputStream.read(this.syncflag, 2, false);
    this.coverScene = paramJceInputStream.read(this.coverScene, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.MulRelsotionUrl != null) {
      paramJceOutputStream.write(this.MulRelsotionUrl, 1);
    }
    paramJceOutputStream.write(this.syncflag, 2);
    paramJceOutputStream.write(this.coverScene, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_set_cover_rsp
 * JD-Core Version:    0.7.0.1
 */