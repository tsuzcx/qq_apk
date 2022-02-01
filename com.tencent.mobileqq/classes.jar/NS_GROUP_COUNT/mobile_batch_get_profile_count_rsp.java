package NS_GROUP_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class mobile_batch_get_profile_count_rsp
  extends JceStruct
{
  static Map<String, String> cache_extendinfo;
  static ArrayList<profile_count_item> cache_profileCountItems = new ArrayList();
  public Map<String, String> extendinfo = null;
  public int iNextTimeout = 0;
  public int iNextUinsBufCount = 0;
  public String iconURL = "";
  public ArrayList<profile_count_item> profileCountItems = null;
  
  static
  {
    profile_count_item localprofile_count_item = new profile_count_item();
    cache_profileCountItems.add(localprofile_count_item);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public mobile_batch_get_profile_count_rsp() {}
  
  public mobile_batch_get_profile_count_rsp(ArrayList<profile_count_item> paramArrayList, int paramInt1, int paramInt2, String paramString, Map<String, String> paramMap)
  {
    this.profileCountItems = paramArrayList;
    this.iNextTimeout = paramInt1;
    this.iNextUinsBufCount = paramInt2;
    this.iconURL = paramString;
    this.extendinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.profileCountItems = ((ArrayList)paramJceInputStream.read(cache_profileCountItems, 0, false));
    this.iNextTimeout = paramJceInputStream.read(this.iNextTimeout, 1, false);
    this.iNextUinsBufCount = paramJceInputStream.read(this.iNextUinsBufCount, 2, false);
    this.iconURL = paramJceInputStream.readString(3, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.profileCountItems;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    paramJceOutputStream.write(this.iNextTimeout, 1);
    paramJceOutputStream.write(this.iNextUinsBufCount, 2);
    localObject = this.iconURL;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_GROUP_COUNT.mobile_batch_get_profile_count_rsp
 * JD-Core Version:    0.7.0.1
 */