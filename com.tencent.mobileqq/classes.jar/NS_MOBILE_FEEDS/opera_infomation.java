package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class opera_infomation
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  public Map<Integer, String> busi_param = null;
  public long feedUin = 0L;
  public String strFeedsKey = "";
  public String strOperaData = "";
  public String strSummary = "";
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public opera_infomation() {}
  
  public opera_infomation(Map<Integer, String> paramMap, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this.busi_param = paramMap;
    this.strFeedsKey = paramString1;
    this.strOperaData = paramString2;
    this.strSummary = paramString3;
    this.feedUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 0, false));
    this.strFeedsKey = paramJceInputStream.readString(1, false);
    this.strOperaData = paramJceInputStream.readString(2, false);
    this.strSummary = paramJceInputStream.readString(3, false);
    this.feedUin = paramJceInputStream.read(this.feedUin, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 0);
    }
    localObject = this.strFeedsKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.strOperaData;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.strSummary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.feedUin, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.opera_infomation
 * JD-Core Version:    0.7.0.1
 */