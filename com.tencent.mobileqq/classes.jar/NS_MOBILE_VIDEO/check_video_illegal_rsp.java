package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class check_video_illegal_rsp
  extends JceStruct
{
  static Map<String, UrlRsp> cache_video_urls = new HashMap();
  public String illegal_msg = "";
  public String msg = "";
  public int ret;
  public Map<String, UrlRsp> video_urls;
  
  static
  {
    UrlRsp localUrlRsp = new UrlRsp();
    cache_video_urls.put("", localUrlRsp);
  }
  
  public check_video_illegal_rsp() {}
  
  public check_video_illegal_rsp(int paramInt, String paramString1, Map<String, UrlRsp> paramMap, String paramString2)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.video_urls = paramMap;
    this.illegal_msg = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.video_urls = ((Map)paramJceInputStream.read(cache_video_urls, 2, false));
    this.illegal_msg = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.video_urls != null) {
      paramJceOutputStream.write(this.video_urls, 2);
    }
    if (this.illegal_msg != null) {
      paramJceOutputStream.write(this.illegal_msg, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_VIDEO.check_video_illegal_rsp
 * JD-Core Version:    0.7.0.1
 */