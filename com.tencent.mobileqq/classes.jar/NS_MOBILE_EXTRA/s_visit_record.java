package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_visit_record
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param;
  public int appid;
  public Map<Integer, String> busi_param;
  public long fuin;
  public long gameId;
  public String srcId = "";
  public int subid;
  public int visit_type;
  
  public s_visit_record() {}
  
  public s_visit_record(long paramLong1, int paramInt1, int paramInt2, String paramString, Map<Integer, String> paramMap, long paramLong2, int paramInt3)
  {
    this.fuin = paramLong1;
    this.appid = paramInt1;
    this.subid = paramInt2;
    this.srcId = paramString;
    this.busi_param = paramMap;
    this.gameId = paramLong2;
    this.visit_type = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fuin = paramJceInputStream.read(this.fuin, 0, true);
    this.appid = paramJceInputStream.read(this.appid, 1, true);
    this.subid = paramJceInputStream.read(this.subid, 2, true);
    this.srcId = paramJceInputStream.readString(3, true);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 4, false));
    this.gameId = paramJceInputStream.read(this.gameId, 5, false);
    this.visit_type = paramJceInputStream.read(this.visit_type, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fuin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.subid, 2);
    paramJceOutputStream.write(this.srcId, 3);
    Map localMap = this.busi_param;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 4);
    }
    paramJceOutputStream.write(this.gameId, 5);
    paramJceOutputStream.write(this.visit_type, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.s_visit_record
 * JD-Core Version:    0.7.0.1
 */