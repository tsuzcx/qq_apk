package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stOperaData
  extends JceStruct
{
  static Map<Integer, String> cache_extendinfo = new HashMap();
  public int actiontype = 0;
  public Map<Integer, String> extendinfo = null;
  public String strData = "";
  
  static
  {
    cache_extendinfo.put(Integer.valueOf(0), "");
  }
  
  public stOperaData() {}
  
  public stOperaData(String paramString, int paramInt, Map<Integer, String> paramMap)
  {
    this.strData = paramString;
    this.actiontype = paramInt;
    this.extendinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strData = paramJceInputStream.readString(0, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 1, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.strData;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.actiontype, 1);
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_COMM.stOperaData
 * JD-Core Version:    0.7.0.1
 */