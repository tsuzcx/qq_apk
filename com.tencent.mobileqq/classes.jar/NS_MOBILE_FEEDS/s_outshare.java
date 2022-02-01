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
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 0);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 1);
    }
    if (this.photourl != null) {
      paramJceOutputStream.write(this.photourl, 2);
    }
    if (this.ark_sharedata != null) {
      paramJceOutputStream.write(this.ark_sharedata, 3);
    }
    if (this.action_url != null) {
      paramJceOutputStream.write(this.action_url, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_outshare
 * JD-Core Version:    0.7.0.1
 */