package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picurl;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_outshare
  extends JceStruct
{
  static Map<Integer, s_picurl> cache_photourl = new HashMap();
  public int album_right = 0;
  public String md5 = "";
  public Map<Integer, s_picurl> photourl = null;
  public String qq_url = "";
  public int space_right = 0;
  public String summary = "";
  public String title = "";
  public String weixin_url = "";
  public String xcx_name = "";
  public String xcx_share_path = "";
  
  static
  {
    s_picurl locals_picurl = new s_picurl();
    cache_photourl.put(Integer.valueOf(0), locals_picurl);
  }
  
  public s_outshare() {}
  
  public s_outshare(String paramString1, String paramString2, String paramString3, String paramString4, Map<Integer, s_picurl> paramMap, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7)
  {
    this.weixin_url = paramString1;
    this.qq_url = paramString2;
    this.title = paramString3;
    this.summary = paramString4;
    this.photourl = paramMap;
    this.space_right = paramInt1;
    this.album_right = paramInt2;
    this.xcx_share_path = paramString5;
    this.xcx_name = paramString6;
    this.md5 = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.weixin_url = paramJceInputStream.readString(0, false);
    this.qq_url = paramJceInputStream.readString(1, false);
    this.title = paramJceInputStream.readString(2, false);
    this.summary = paramJceInputStream.readString(3, false);
    this.photourl = ((Map)paramJceInputStream.read(cache_photourl, 4, false));
    this.space_right = paramJceInputStream.read(this.space_right, 5, false);
    this.album_right = paramJceInputStream.read(this.album_right, 6, false);
    this.xcx_share_path = paramJceInputStream.readString(7, false);
    this.xcx_name = paramJceInputStream.readString(8, false);
    this.md5 = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.weixin_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.qq_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.photourl;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
    paramJceOutputStream.write(this.space_right, 5);
    paramJceOutputStream.write(this.album_right, 6);
    localObject = this.xcx_share_path;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.xcx_name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.md5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.s_outshare
 * JD-Core Version:    0.7.0.1
 */