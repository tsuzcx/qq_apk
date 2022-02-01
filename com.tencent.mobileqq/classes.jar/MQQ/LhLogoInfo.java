package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class LhLogoInfo
  extends JceStruct
{
  static Map<Integer, LhLogoResources> cache_lhLogoResources = new HashMap();
  public int bUpdate = 0;
  public Map<Integer, LhLogoResources> lhLogoResources = null;
  
  static
  {
    LhLogoResources localLhLogoResources = new LhLogoResources();
    cache_lhLogoResources.put(Integer.valueOf(0), localLhLogoResources);
  }
  
  public LhLogoInfo() {}
  
  public LhLogoInfo(int paramInt, Map<Integer, LhLogoResources> paramMap)
  {
    this.bUpdate = paramInt;
    this.lhLogoResources = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bUpdate = paramJceInputStream.read(this.bUpdate, 0, false);
    this.lhLogoResources = ((Map)paramJceInputStream.read(cache_lhLogoResources, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bUpdate, 0);
    Map localMap = this.lhLogoResources;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.LhLogoInfo
 * JD-Core Version:    0.7.0.1
 */