package DCClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stDataPackage
  extends JceStruct
{
  static Map<String, String> cache_numData;
  static Map<String, String> cache_strData;
  public Map<String, String> numData = null;
  public Map<String, String> strData = null;
  
  public stDataPackage() {}
  
  public stDataPackage(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    this.numData = paramMap1;
    this.strData = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_numData == null)
    {
      cache_numData = new HashMap();
      cache_numData.put("", "");
    }
    this.numData = ((Map)paramJceInputStream.read(cache_numData, 0, true));
    if (cache_strData == null)
    {
      cache_strData = new HashMap();
      cache_strData.put("", "");
    }
    this.strData = ((Map)paramJceInputStream.read(cache_strData, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.numData, 0);
    paramJceOutputStream.write(this.strData, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     DCClientInterface.stDataPackage
 * JD-Core Version:    0.7.0.1
 */