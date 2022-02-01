package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UnifyRecomStruct
  extends JceStruct
{
  static Map<String, String> cache_compassInfoList;
  static Map<Integer, String> cache_newReportInfoList;
  static ExposStuctInfo cache_stuExposInfo;
  static byte[] cache_vctBusiData = (byte[])new byte[1];
  public Map<String, String> compassInfoList = null;
  public int iPos = 0;
  public Map<Integer, String> newReportInfoList = null;
  public ExposStuctInfo stuExposInfo = null;
  public String ugckey = "";
  public byte[] vctBusiData = null;
  
  static
  {
    ((byte[])cache_vctBusiData)[0] = 0;
    cache_stuExposInfo = new ExposStuctInfo();
    cache_compassInfoList = new HashMap();
    cache_compassInfoList.put("", "");
    cache_newReportInfoList = new HashMap();
    cache_newReportInfoList.put(Integer.valueOf(0), "");
  }
  
  public UnifyRecomStruct() {}
  
  public UnifyRecomStruct(int paramInt, byte[] paramArrayOfByte, ExposStuctInfo paramExposStuctInfo, Map<String, String> paramMap, String paramString, Map<Integer, String> paramMap1)
  {
    this.iPos = paramInt;
    this.vctBusiData = paramArrayOfByte;
    this.stuExposInfo = paramExposStuctInfo;
    this.compassInfoList = paramMap;
    this.ugckey = paramString;
    this.newReportInfoList = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iPos = paramJceInputStream.read(this.iPos, 0, false);
    this.vctBusiData = ((byte[])paramJceInputStream.read(cache_vctBusiData, 1, false));
    this.stuExposInfo = ((ExposStuctInfo)paramJceInputStream.read(cache_stuExposInfo, 2, false));
    this.compassInfoList = ((Map)paramJceInputStream.read(cache_compassInfoList, 3, false));
    this.ugckey = paramJceInputStream.readString(4, false);
    this.newReportInfoList = ((Map)paramJceInputStream.read(cache_newReportInfoList, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iPos, 0);
    Object localObject = this.vctBusiData;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 1);
    }
    localObject = this.stuExposInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.compassInfoList;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    localObject = this.ugckey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.newReportInfoList;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.UnifyRecomStruct
 * JD-Core Version:    0.7.0.1
 */