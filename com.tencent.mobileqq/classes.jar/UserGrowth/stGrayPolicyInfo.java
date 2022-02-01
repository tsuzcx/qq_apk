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
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (stGrayPolicyInfo)paramObject;
      if (!TextUtils.equals(this.grayPolicyId, paramObject.grayPolicyId)) {
        return false;
      }
      if (this.params != null) {
        break;
      }
    } while (paramObject.params == null);
    return false;
    return this.params.equals(paramObject.params);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.grayPolicyId = paramJceInputStream.readString(0, false);
    this.params = ((Map)paramJceInputStream.read(cache_params, 1, false));
  }
  
  public String toString()
  {
    return "{grayPolicyId='" + this.grayPolicyId + '\'' + ", params=" + this.params + "}\n";
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.grayPolicyId != null) {
      paramJceOutputStream.write(this.grayPolicyId, 0);
    }
    if (this.params != null) {
      paramJceOutputStream.write(this.params, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stGrayPolicyInfo
 * JD-Core Version:    0.7.0.1
 */