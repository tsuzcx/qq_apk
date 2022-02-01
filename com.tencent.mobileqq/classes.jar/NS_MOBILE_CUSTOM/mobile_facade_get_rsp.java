package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_facade_get_rsp
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo;
  static Facade cache_stFacade = new Facade();
  public int iCode = 0;
  public int iShowOnFriDyn = 0;
  public Map<String, String> mapExtInfo = null;
  public Facade stFacade = null;
  
  static
  {
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public mobile_facade_get_rsp() {}
  
  public mobile_facade_get_rsp(int paramInt1, Facade paramFacade, Map<String, String> paramMap, int paramInt2)
  {
    this.iCode = paramInt1;
    this.stFacade = paramFacade;
    this.mapExtInfo = paramMap;
    this.iShowOnFriDyn = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, false);
    this.stFacade = ((Facade)paramJceInputStream.read(cache_stFacade, 1, false));
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 2, false));
    this.iShowOnFriDyn = paramJceInputStream.read(this.iShowOnFriDyn, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    Object localObject = this.stFacade;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.mapExtInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    paramJceOutputStream.write(this.iShowOnFriDyn, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.mobile_facade_get_rsp
 * JD-Core Version:    0.7.0.1
 */