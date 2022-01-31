package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class VideoSummary
  extends JceStruct
{
  static Map<Integer, String> cache_cover = new HashMap();
  public Map<Integer, String> cover;
  public int num;
  
  static
  {
    cache_cover.put(Integer.valueOf(0), "");
  }
  
  public VideoSummary() {}
  
  public VideoSummary(int paramInt, Map<Integer, String> paramMap)
  {
    this.num = paramInt;
    this.cover = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.cover = ((Map)paramJceInputStream.read(cache_cover, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    if (this.cover != null) {
      paramJceOutputStream.write(this.cover, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_VIDEO.VideoSummary
 * JD-Core Version:    0.7.0.1
 */