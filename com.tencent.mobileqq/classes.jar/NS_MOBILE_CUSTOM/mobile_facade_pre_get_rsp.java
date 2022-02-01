package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class mobile_facade_pre_get_rsp
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo;
  static Map<Long, Facade> cache_mapUinFacade;
  static ArrayList<Long> cache_vecUinNoVisitRight;
  public Map<String, String> mapExtInfo;
  public Map<Long, Facade> mapUinFacade;
  public ArrayList<Long> vecUinNoVisitRight;
  
  public mobile_facade_pre_get_rsp() {}
  
  public mobile_facade_pre_get_rsp(Map<Long, Facade> paramMap, ArrayList<Long> paramArrayList, Map<String, String> paramMap1)
  {
    this.mapUinFacade = paramMap;
    this.vecUinNoVisitRight = paramArrayList;
    this.mapExtInfo = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    Object localObject = cache_mapUinFacade;
    Long localLong = Long.valueOf(0L);
    if (localObject == null)
    {
      cache_mapUinFacade = new HashMap();
      localObject = new Facade();
      cache_mapUinFacade.put(localLong, localObject);
    }
    this.mapUinFacade = ((Map)paramJceInputStream.read(cache_mapUinFacade, 0, false));
    if (cache_vecUinNoVisitRight == null)
    {
      cache_vecUinNoVisitRight = new ArrayList();
      cache_vecUinNoVisitRight.add(localLong);
    }
    this.vecUinNoVisitRight = ((ArrayList)paramJceInputStream.read(cache_vecUinNoVisitRight, 1, false));
    if (cache_mapExtInfo == null)
    {
      cache_mapExtInfo = new HashMap();
      cache_mapExtInfo.put("", "");
    }
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.mapUinFacade;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 0);
    }
    localObject = this.vecUinNoVisitRight;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.mapExtInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.mobile_facade_pre_get_rsp
 * JD-Core Version:    0.7.0.1
 */