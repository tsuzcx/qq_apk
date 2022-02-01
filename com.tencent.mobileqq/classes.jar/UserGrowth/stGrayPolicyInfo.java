package UserGrowth;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stGrayPolicyInfo
  extends JceStruct
{
  static Map<String, String> cache_params = new HashMap();
  public String grayPolicyId = "";
  public Map<String, String> params = null;
  
  static
  {
    cache_params.put("", "");
  }
  
  public stGrayPolicyInfo() {}
  
  public stGrayPolicyInfo(String paramString, Map<String, String> paramMap)
  {
    this.grayPolicyId = paramString;
    this.params = paramMap;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (stGrayPolicyInfo)paramObject;
      if (!TextUtils.equals(this.grayPolicyId, paramObject.grayPolicyId)) {
        return false;
      }
      Map localMap = this.params;
      if (localMap == null) {
        return paramObject.params == null;
      }
      return localMap.equals(paramObject.params);
    }
    return false;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.grayPolicyId = paramJceInputStream.readString(0, false);
    this.params = ((Map)paramJceInputStream.read(cache_params, 1, false));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{grayPolicyId='");
    localStringBuilder.append(this.grayPolicyId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.params);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.grayPolicyId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.params;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGrayPolicyInfo
 * JD-Core Version:    0.7.0.1
 */