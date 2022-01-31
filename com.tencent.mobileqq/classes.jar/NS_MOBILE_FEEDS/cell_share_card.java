package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_share_card
  extends JceStruct
{
  static byte[] cache_content_buf = (byte[])new byte[1];
  static Map<String, String> cache_mapExt;
  public byte[] content_buf;
  public Map<String, String> mapExt;
  
  static
  {
    ((byte[])cache_content_buf)[0] = 0;
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public cell_share_card() {}
  
  public cell_share_card(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this.content_buf = paramArrayOfByte;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.content_buf = ((byte[])paramJceInputStream.read(cache_content_buf, 0, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.content_buf != null) {
      paramJceOutputStream.write(this.content_buf, 0);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_share_card
 * JD-Core Version:    0.7.0.1
 */