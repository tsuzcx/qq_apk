package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ExposStuctInfo
  extends JceStruct
{
  static Map<String, String> cache_extendInfo = new HashMap();
  public int appid;
  public Map<String, String> extendInfo;
  public byte opType;
  public String recordId = "";
  
  static
  {
    cache_extendInfo.put("", "");
  }
  
  public ExposStuctInfo() {}
  
  public ExposStuctInfo(String paramString, int paramInt, byte paramByte, Map<String, String> paramMap)
  {
    this.recordId = paramString;
    this.appid = paramInt;
    this.opType = paramByte;
    this.extendInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.recordId = paramJceInputStream.readString(0, false);
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.opType = paramJceInputStream.read(this.opType, 2, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.recordId != null) {
      paramJceOutputStream.write(this.recordId, 0);
    }
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.opType, 2);
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.ExposStuctInfo
 * JD-Core Version:    0.7.0.1
 */