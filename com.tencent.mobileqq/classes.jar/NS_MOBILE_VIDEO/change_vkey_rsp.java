package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class change_vkey_rsp
  extends JceStruct
{
  static Map<String, UrlRsp> cache_video_urls;
  public String msg = "";
  public int ret;
  public Map<String, UrlRsp> video_urls;
  
  public change_vkey_rsp() {}
  
  public change_vkey_rsp(int paramInt, String paramString, Map<String, UrlRsp> paramMap)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.video_urls = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    if (cache_video_urls == null)
    {
      cache_video_urls = new HashMap();
      UrlRsp localUrlRsp = new UrlRsp();
      cache_video_urls.put("", localUrlRsp);
    }
    this.video_urls = ((Map)paramJceInputStream.read(cache_video_urls, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.video_urls;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.change_vkey_rsp
 * JD-Core Version:    0.7.0.1
 */