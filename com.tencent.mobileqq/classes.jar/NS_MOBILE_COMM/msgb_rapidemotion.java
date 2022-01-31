package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class msgb_rapidemotion
  extends JceStruct
{
  static Map<String, String> cache_extend_info = new HashMap();
  public int emotion_height_b;
  public int emotion_height_s;
  public int emotion_id;
  public String emotion_text = "";
  public int emotion_width_b;
  public int emotion_width_s;
  public Map<String, String> extend_info;
  public String rapid_emotion_url_b = "";
  public String rapid_emotion_url_s = "";
  
  static
  {
    cache_extend_info.put("", "");
  }
  
  public msgb_rapidemotion() {}
  
  public msgb_rapidemotion(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, Map<String, String> paramMap)
  {
    this.emotion_id = paramInt1;
    this.rapid_emotion_url_s = paramString1;
    this.rapid_emotion_url_b = paramString2;
    this.emotion_width_s = paramInt2;
    this.emotion_height_s = paramInt3;
    this.emotion_width_b = paramInt4;
    this.emotion_height_b = paramInt5;
    this.emotion_text = paramString3;
    this.extend_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.emotion_id = paramJceInputStream.read(this.emotion_id, 0, false);
    this.rapid_emotion_url_s = paramJceInputStream.readString(1, false);
    this.rapid_emotion_url_b = paramJceInputStream.readString(2, false);
    this.emotion_width_s = paramJceInputStream.read(this.emotion_width_s, 3, false);
    this.emotion_height_s = paramJceInputStream.read(this.emotion_height_s, 4, false);
    this.emotion_width_b = paramJceInputStream.read(this.emotion_width_b, 5, false);
    this.emotion_height_b = paramJceInputStream.read(this.emotion_height_b, 6, false);
    this.emotion_text = paramJceInputStream.readString(7, false);
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.emotion_id, 0);
    if (this.rapid_emotion_url_s != null) {
      paramJceOutputStream.write(this.rapid_emotion_url_s, 1);
    }
    if (this.rapid_emotion_url_b != null) {
      paramJceOutputStream.write(this.rapid_emotion_url_b, 2);
    }
    paramJceOutputStream.write(this.emotion_width_s, 3);
    paramJceOutputStream.write(this.emotion_height_s, 4);
    paramJceOutputStream.write(this.emotion_width_b, 5);
    paramJceOutputStream.write(this.emotion_height_b, 6);
    if (this.emotion_text != null) {
      paramJceOutputStream.write(this.emotion_text, 7);
    }
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_COMM.msgb_rapidemotion
 * JD-Core Version:    0.7.0.1
 */