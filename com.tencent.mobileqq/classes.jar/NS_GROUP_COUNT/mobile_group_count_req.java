package NS_GROUP_COUNT;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public final class mobile_group_count_req
  extends JceStruct
  implements Cloneable
{
  static Map<String, String> cache_extendinfo = new HashMap();
  public Map<String, String> extendinfo = null;
  public long uGroupid = 0L;
  
  static
  {
    cache_extendinfo.put("", "");
  }
  
  public mobile_group_count_req() {}
  
  public mobile_group_count_req(long paramLong, Map<String, String> paramMap)
  {
    this.uGroupid = paramLong;
    this.extendinfo = paramMap;
  }
  
  public String className()
  {
    return "NS_GROUP_COUNT.mobile_group_count_req";
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.uGroupid, "uGroupid");
    paramStringBuilder.display(this.extendinfo, "extendinfo");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.uGroupid, true);
    paramStringBuilder.displaySimple(this.extendinfo, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (mobile_group_count_req)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.uGroupid, paramObject.uGroupid))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.extendinfo, paramObject.extendinfo)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "protocolqzone.NS_GROUP_COUNT.mobile_group_count_req";
  }
  
  public Map<String, String> getExtendinfo()
  {
    return this.extendinfo;
  }
  
  public long getUGroupid()
  {
    return this.uGroupid;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uGroupid = paramJceInputStream.read(this.uGroupid, 0, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 1, false));
  }
  
  public void setExtendinfo(Map<String, String> paramMap)
  {
    this.extendinfo = paramMap;
  }
  
  public void setUGroupid(long paramLong)
  {
    this.uGroupid = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uGroupid, 0);
    Map localMap = this.extendinfo;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_GROUP_COUNT.mobile_group_count_req
 * JD-Core Version:    0.7.0.1
 */