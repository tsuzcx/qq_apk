package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_main_page_req
  extends JceStruct
{
  static Map<Integer, Long> cache_mapTimeStamp;
  public String attach_info = "";
  public byte force;
  public Map<Integer, Long> mapTimeStamp;
  public long uin;
  public long visituin;
  
  public mobile_main_page_req() {}
  
  public mobile_main_page_req(long paramLong1, long paramLong2, byte paramByte, String paramString, Map<Integer, Long> paramMap)
  {
    this.uin = paramLong1;
    this.visituin = paramLong2;
    this.force = paramByte;
    this.attach_info = paramString;
    this.mapTimeStamp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.visituin = paramJceInputStream.read(this.visituin, 1, false);
    this.force = paramJceInputStream.read(this.force, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    if (cache_mapTimeStamp == null)
    {
      cache_mapTimeStamp = new HashMap();
      cache_mapTimeStamp.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    this.mapTimeStamp = ((Map)paramJceInputStream.read(cache_mapTimeStamp, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.visituin, 1);
    paramJceOutputStream.write(this.force, 2);
    Object localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.mapTimeStamp;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_main_page_req
 * JD-Core Version:    0.7.0.1
 */