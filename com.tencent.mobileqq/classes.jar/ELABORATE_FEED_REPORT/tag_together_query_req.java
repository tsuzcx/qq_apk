package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class tag_together_query_req
  extends JceStruct
{
  static Map<Integer, String> cache_mapExt = new HashMap();
  public Map<Integer, String> mapExt = null;
  public String sPgcFeedKey = "";
  public long uPgcAppid = 0L;
  public long uPgcUin = 0L;
  
  static
  {
    cache_mapExt.put(Integer.valueOf(0), "");
  }
  
  public tag_together_query_req() {}
  
  public tag_together_query_req(long paramLong1, long paramLong2, String paramString, Map<Integer, String> paramMap)
  {
    this.uPgcUin = paramLong1;
    this.uPgcAppid = paramLong2;
    this.sPgcFeedKey = paramString;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uPgcUin = paramJceInputStream.read(this.uPgcUin, 0, false);
    this.uPgcAppid = paramJceInputStream.read(this.uPgcAppid, 1, false);
    this.sPgcFeedKey = paramJceInputStream.readString(2, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uPgcUin, 0);
    paramJceOutputStream.write(this.uPgcAppid, 1);
    Object localObject = this.sPgcFeedKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.tag_together_query_req
 * JD-Core Version:    0.7.0.1
 */