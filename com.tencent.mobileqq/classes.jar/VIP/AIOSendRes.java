package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class AIOSendRes
  extends JceStruct
{
  static Map<String, String> cache_mHighLightMap = new HashMap();
  public int iPopGrayStip = 0;
  public Map<String, String> mHighLightMap = null;
  public String sGrayStipMsg = "";
  
  static
  {
    cache_mHighLightMap.put("", "");
  }
  
  public AIOSendRes() {}
  
  public AIOSendRes(int paramInt, String paramString, Map<String, String> paramMap)
  {
    this.iPopGrayStip = paramInt;
    this.sGrayStipMsg = paramString;
    this.mHighLightMap = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iPopGrayStip = paramJceInputStream.read(this.iPopGrayStip, 0, true);
    this.sGrayStipMsg = paramJceInputStream.readString(1, true);
    this.mHighLightMap = ((Map)paramJceInputStream.read(cache_mHighLightMap, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iPopGrayStip, 0);
    paramJceOutputStream.write(this.sGrayStipMsg, 1);
    paramJceOutputStream.write(this.mHighLightMap, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.AIOSendRes
 * JD-Core Version:    0.7.0.1
 */