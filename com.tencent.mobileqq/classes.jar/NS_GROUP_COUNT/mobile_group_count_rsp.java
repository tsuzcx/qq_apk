package NS_GROUP_COUNT;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_group_count_rsp
  extends JceStruct
  implements Cloneable
{
  static Map<String, String> cache_extendinfo;
  static ArrayList<Long> cache_vecUinList;
  public Map<String, String> extendinfo;
  public int iNextTimeout;
  public int iShowRedPoint;
  public long stCount;
  public ArrayList<Long> vecUinList;
  
  static
  {
    if (!mobile_group_count_rsp.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_vecUinList = new ArrayList();
      cache_vecUinList.add(Long.valueOf(0L));
      cache_extendinfo = new HashMap();
      cache_extendinfo.put("", "");
      return;
    }
  }
  
  public mobile_group_count_rsp() {}
  
  public mobile_group_count_rsp(long paramLong, ArrayList<Long> paramArrayList, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    this.stCount = paramLong;
    this.vecUinList = paramArrayList;
    this.iShowRedPoint = paramInt1;
    this.iNextTimeout = paramInt2;
    this.extendinfo = paramMap;
  }
  
  public String className()
  {
    return "NS_GROUP_COUNT.mobile_group_count_rsp";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.stCount, "stCount");
    paramStringBuilder.display(this.vecUinList, "vecUinList");
    paramStringBuilder.display(this.iShowRedPoint, "iShowRedPoint");
    paramStringBuilder.display(this.iNextTimeout, "iNextTimeout");
    paramStringBuilder.display(this.extendinfo, "extendinfo");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.stCount, true);
    paramStringBuilder.displaySimple(this.vecUinList, true);
    paramStringBuilder.displaySimple(this.iShowRedPoint, true);
    paramStringBuilder.displaySimple(this.iNextTimeout, true);
    paramStringBuilder.displaySimple(this.extendinfo, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (mobile_group_count_rsp)paramObject;
    } while ((!JceUtil.equals(this.stCount, paramObject.stCount)) || (!JceUtil.equals(this.vecUinList, paramObject.vecUinList)) || (!JceUtil.equals(this.iShowRedPoint, paramObject.iShowRedPoint)) || (!JceUtil.equals(this.iNextTimeout, paramObject.iNextTimeout)) || (!JceUtil.equals(this.extendinfo, paramObject.extendinfo)));
    return true;
  }
  
  public String fullClassName()
  {
    return "protocolqzone.NS_GROUP_COUNT.mobile_group_count_rsp";
  }
  
  public Map<String, String> getExtendinfo()
  {
    return this.extendinfo;
  }
  
  public int getINextTimeout()
  {
    return this.iNextTimeout;
  }
  
  public int getIShowRedPoint()
  {
    return this.iShowRedPoint;
  }
  
  public long getStCount()
  {
    return this.stCount;
  }
  
  public ArrayList<Long> getVecUinList()
  {
    return this.vecUinList;
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
    this.stCount = paramJceInputStream.read(this.stCount, 0, false);
    this.vecUinList = ((ArrayList)paramJceInputStream.read(cache_vecUinList, 1, false));
    this.iShowRedPoint = paramJceInputStream.read(this.iShowRedPoint, 2, false);
    this.iNextTimeout = paramJceInputStream.read(this.iNextTimeout, 3, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 4, false));
  }
  
  public void setExtendinfo(Map<String, String> paramMap)
  {
    this.extendinfo = paramMap;
  }
  
  public void setINextTimeout(int paramInt)
  {
    this.iNextTimeout = paramInt;
  }
  
  public void setIShowRedPoint(int paramInt)
  {
    this.iShowRedPoint = paramInt;
  }
  
  public void setStCount(long paramLong)
  {
    this.stCount = paramLong;
  }
  
  public void setVecUinList(ArrayList<Long> paramArrayList)
  {
    this.vecUinList = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stCount, 0);
    if (this.vecUinList != null) {
      paramJceOutputStream.write(this.vecUinList, 1);
    }
    paramJceOutputStream.write(this.iShowRedPoint, 2);
    paramJceOutputStream.write(this.iNextTimeout, 3);
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_GROUP_COUNT.mobile_group_count_rsp
 * JD-Core Version:    0.7.0.1
 */