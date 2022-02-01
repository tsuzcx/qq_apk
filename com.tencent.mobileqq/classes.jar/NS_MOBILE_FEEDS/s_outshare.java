package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_outshare
  extends JceStruct
{
  static s_arkshare cache_ark_sharedata = new s_arkshare();
  static Map<Integer, s_picurl> cache_photourl = new HashMap();
  public String action_url = "";
  public s_arkshare ark_sharedata = null;
  public Map<Integer, s_picurl> photourl = null;
  public String summary = "";
  public String title = "";
  
  static
  {
    s_picurl locals_picurl = new s_picurl();
    cache_photourl.put(Integer.valueOf(0), locals_picurl);
  }
  
  public s_outshare() {}
  
  public s_outshare(String paramString1, String paramString2, Map<Integer, s_picurl> paramMap, s_arkshare params_arkshare, String paramString3)
  {
    this.title = paramString1;
    this.summary = paramString2;
    this.photourl = paramMap;
    this.ark_sharedata = params_arkshare;
    this.action_url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.summary = paramJceInputStream.readString(1, false);
    this.photourl = ((Map)paramJceInputStream.read(cache_photourl, 2, false));
    this.ark_sharedata = ((s_arkshare)paramJceInputStream.read(cache_ark_sharedata, 3, false));
    this.action_url = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.photourl;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    localObject = this.ark_sharedata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.action_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_outshare
 * JD-Core Version:    0.7.0.1
 */