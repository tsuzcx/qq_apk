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
  public Map<String, String> ext_info = null;
  public String img = "";
  public String playurl = "";
  public int pub_route = 0;
  public int subtype = 0;
  public long time = 0L;
  public String title = "";
  public String video_id = "";
  public int who = 0;
  
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
    Object localObject = this.playurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.img;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.who, 3);
    localObject = this.detailurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.video_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.pub_route, 6);
    paramJceOutputStream.write(this.time, 7);
    paramJceOutputStream.write(this.subtype, 8);
    localObject = this.ext_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.VedioInfo
 * JD-Core Version:    0.7.0.1
 */