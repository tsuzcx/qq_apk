package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class Media_Data
  extends JceStruct
{
  static Map<String, String> cache_extendInfo = new HashMap();
  public Map<String, String> extendInfo = null;
  public String strImgUrl = "";
  public int uType = 0;
  
  static
  {
    cache_extendInfo.put("", "");
  }
  
  public Media_Data() {}
  
  public Media_Data(String paramString, int paramInt, Map<String, String> paramMap)
  {
    this.strImgUrl = paramString;
    this.uType = paramInt;
    this.extendInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strImgUrl = paramJceInputStream.readString(0, false);
    this.uType = paramJceInputStream.read(this.uType, 1, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strImgUrl != null) {
      paramJceOutputStream.write(this.strImgUrl, 0);
    }
    paramJceOutputStream.write(this.uType, 1);
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_AIONewestFeed.Media_Data
 * JD-Core Version:    0.7.0.1
 */