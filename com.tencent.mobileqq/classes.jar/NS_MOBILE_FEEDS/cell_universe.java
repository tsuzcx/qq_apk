package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_universe
  extends JceStruct
{
  static Map<Integer, byte[]> cache_BgReqData = new HashMap();
  static Map<String, String> cache_extendInfo;
  public Map<Integer, byte[]> BgReqData;
  public Map<String, String> extendInfo;
  public int iUniverseType;
  public String strTraceId = "";
  public String strUIJson = "";
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_BgReqData.put(Integer.valueOf(0), arrayOfByte);
    cache_extendInfo = new HashMap();
    cache_extendInfo.put("", "");
  }
  
  public cell_universe() {}
  
  public cell_universe(String paramString1, String paramString2, Map<Integer, byte[]> paramMap, int paramInt, Map<String, String> paramMap1)
  {
    this.strTraceId = paramString1;
    this.strUIJson = paramString2;
    this.BgReqData = paramMap;
    this.iUniverseType = paramInt;
    this.extendInfo = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strTraceId = paramJceInputStream.readString(0, false);
    this.strUIJson = paramJceInputStream.readString(1, false);
    this.BgReqData = ((Map)paramJceInputStream.read(cache_BgReqData, 2, false));
    this.iUniverseType = paramJceInputStream.read(this.iUniverseType, 3, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strTraceId != null) {
      paramJceOutputStream.write(this.strTraceId, 0);
    }
    if (this.strUIJson != null) {
      paramJceOutputStream.write(this.strUIJson, 1);
    }
    if (this.BgReqData != null) {
      paramJceOutputStream.write(this.BgReqData, 2);
    }
    paramJceOutputStream.write(this.iUniverseType, 3);
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_universe
 * JD-Core Version:    0.7.0.1
 */