package NS_GROUP_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class mobile_batch_get_profile_count_req
  extends JceStruct
{
  static Map<String, String> cache_extendinfo;
  static ArrayList<Long> cache_vecUinList = new ArrayList();
  public Map<String, String> extendinfo = null;
  public ArrayList<Long> vecUinList = null;
  
  static
  {
    cache_vecUinList.add(Long.valueOf(0L));
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public mobile_batch_get_profile_count_req() {}
  
  public mobile_batch_get_profile_count_req(ArrayList<Long> paramArrayList, Map<String, String> paramMap)
  {
    this.vecUinList = paramArrayList;
    this.extendinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecUinList = ((ArrayList)paramJceInputStream.read(cache_vecUinList, 0, false));
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.vecUinList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_GROUP_COUNT.mobile_batch_get_profile_count_req
 * JD-Core Version:    0.7.0.1
 */