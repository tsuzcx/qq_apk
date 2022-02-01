package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class stGetAllABTestPolicyRsp
  extends JceStruct
{
  static Map<String, String> cache_mapExt;
  static Map<String, stGrayPolicyInfo> cache_policyInfo = new HashMap();
  static Map<String, ArrayList<String>> cache_profile;
  public Map<String, String> mapExt = null;
  public Map<String, stGrayPolicyInfo> policyInfo = null;
  public Map<String, ArrayList<String>> profile = null;
  public long serverTime = 0L;
  
  static
  {
    Object localObject = new stGrayPolicyInfo();
    cache_policyInfo.put("", localObject);
    cache_profile = new HashMap();
    localObject = new ArrayList();
    ((ArrayList)localObject).add("");
    cache_profile.put("", localObject);
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public stGetAllABTestPolicyRsp() {}
  
  public stGetAllABTestPolicyRsp(Map<String, stGrayPolicyInfo> paramMap, Map<String, ArrayList<String>> paramMap1, Map<String, String> paramMap2, long paramLong)
  {
    this.policyInfo = paramMap;
    this.profile = paramMap1;
    this.mapExt = paramMap2;
    this.serverTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.policyInfo = ((Map)paramJceInputStream.read(cache_policyInfo, 0, false));
    this.profile = ((Map)paramJceInputStream.read(cache_profile, 1, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 2, false));
    this.serverTime = paramJceInputStream.read(this.serverTime, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Map localMap = this.policyInfo;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 0);
    }
    localMap = this.profile;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 1);
    }
    localMap = this.mapExt;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 2);
    }
    paramJceOutputStream.write(this.serverTime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetAllABTestPolicyRsp
 * JD-Core Version:    0.7.0.1
 */