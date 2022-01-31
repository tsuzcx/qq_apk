package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class VedioInfo
  extends JceStruct
{
  static Map<String, String> cache_ext_info = new HashMap();
  public String detailurl = "";
  public Map<String, String> ext_info;
  public String img = "";
  public String playurl = "";
  public int pub_route;
  public int subtype;
  public long time;
  public String title = "";
  public String video_id = "";
  public int who;
  
  static
  {
    cache_ext_info.put("", "");
  }
  
  public VedioInfo() {}
  
  public VedioInfo(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong, int paramInt3, Map<String, String> paramMap)
  {
    this.playurl = paramString1;
    this.img = paramString2;
    this.title = paramString3;
    this.who = paramInt1;
    this.detailurl = paramString4;
    this.video_id = paramString5;
    this.pub_route = paramInt2;
    this.time = paramLong;
    this.subtype = paramInt3;
    this.ext_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.playurl = paramJceInputStream.readString(0, false);
    this.img = paramJceInputStream.readString(1, false);
    this.title = paramJceInputStream.readString(2, false);
    this.who = paramJceInputStream.read(this.who, 3, false);
    this.detailurl = paramJceInputStream.readString(4, false);
    this.video_id = paramJceInputStream.readString(5, false);
    this.pub_route = paramJceInputStream.read(this.pub_route, 6, false);
    this.time = paramJceInputStream.read(this.time, 7, false);
    this.subtype = paramJceInputStream.read(this.subtype, 8, false);
    this.ext_info = ((Map)paramJceInputStream.read(cache_ext_info, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.playurl != null) {
      paramJceOutputStream.write(this.playurl, 0);
    }
    if (this.img != null) {
      paramJceOutputStream.write(this.img, 1);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 2);
    }
    paramJceOutputStream.write(this.who, 3);
    if (this.detailurl != null) {
      paramJceOutputStream.write(this.detailurl, 4);
    }
    if (this.video_id != null) {
      paramJceOutputStream.write(this.video_id, 5);
    }
    paramJceOutputStream.write(this.pub_route, 6);
    paramJceOutputStream.write(this.time, 7);
    paramJceOutputStream.write(this.subtype, 8);
    if (this.ext_info != null) {
      paramJceOutputStream.write(this.ext_info, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     NS_MOBILE_OPERATION.VedioInfo
 * JD-Core Version:    0.7.0.1
 */