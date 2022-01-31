package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class sparkle_word
  extends JceStruct
{
  static Map cache_extend_info;
  static ArrayList cache_sparkle_color = new ArrayList();
  public Map extend_info;
  public long span_time;
  public ArrayList sparkle_color;
  
  static
  {
    cache_sparkle_color.add("");
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
  }
  
  public sparkle_word() {}
  
  public sparkle_word(ArrayList paramArrayList, long paramLong, Map paramMap)
  {
    this.sparkle_color = paramArrayList;
    this.span_time = paramLong;
    this.extend_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sparkle_color = ((ArrayList)paramJceInputStream.read(cache_sparkle_color, 0, false));
    this.span_time = paramJceInputStream.read(this.span_time, 1, false);
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sparkle_color != null) {
      paramJceOutputStream.write(this.sparkle_color, 0);
    }
    paramJceOutputStream.write(this.span_time, 1);
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_COMM.sparkle_word
 * JD-Core Version:    0.7.0.1
 */