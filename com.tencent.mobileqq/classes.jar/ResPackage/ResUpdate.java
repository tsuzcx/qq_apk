package ResPackage;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public final class ResUpdate
  extends JceStruct
  implements Cloneable
{
  static Map cache_AttrMap;
  static int cache_OpType;
  public Map AttrMap;
  public int OpType;
  public String Path = "";
  public String ResURL = "";
  
  static
  {
    if (!ResUpdate.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ResUpdate() {}
  
  public ResUpdate(String paramString1, int paramInt, String paramString2, Map paramMap)
  {
    this.Path = paramString1;
    this.OpType = paramInt;
    this.ResURL = paramString2;
    this.AttrMap = paramMap;
  }
  
  public String className()
  {
    return "ResPackage.ResUpdate";
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
    paramStringBuilder.display(this.Path, "Path");
    paramStringBuilder.display(this.OpType, "OpType");
    paramStringBuilder.display(this.ResURL, "ResURL");
    paramStringBuilder.display(this.AttrMap, "AttrMap");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.Path, true);
    paramStringBuilder.displaySimple(this.OpType, true);
    paramStringBuilder.displaySimple(this.ResURL, true);
    paramStringBuilder.displaySimple(this.AttrMap, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ResUpdate)paramObject;
    } while ((!JceUtil.equals(this.Path, paramObject.Path)) || (!JceUtil.equals(this.OpType, paramObject.OpType)) || (!JceUtil.equals(this.ResURL, paramObject.ResURL)) || (!JceUtil.equals(this.AttrMap, paramObject.AttrMap)));
    return true;
  }
  
  public String fullClassName()
  {
    return "ResPackage.ResUpdate";
  }
  
  public Map getAttrMap()
  {
    return this.AttrMap;
  }
  
  public int getOpType()
  {
    return this.OpType;
  }
  
  public String getPath()
  {
    return this.Path;
  }
  
  public String getResURL()
  {
    return this.ResURL;
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
    this.Path = paramJceInputStream.readString(0, true);
    this.OpType = paramJceInputStream.read(this.OpType, 1, true);
    this.ResURL = paramJceInputStream.readString(2, false);
    if (cache_AttrMap == null)
    {
      cache_AttrMap = new HashMap();
      cache_AttrMap.put("", "");
    }
    this.AttrMap = ((Map)paramJceInputStream.read(cache_AttrMap, 3, false));
  }
  
  public void setAttrMap(Map paramMap)
  {
    this.AttrMap = paramMap;
  }
  
  public void setOpType(int paramInt)
  {
    this.OpType = paramInt;
  }
  
  public void setPath(String paramString)
  {
    this.Path = paramString;
  }
  
  public void setResURL(String paramString)
  {
    this.ResURL = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Path, 0);
    paramJceOutputStream.write(this.OpType, 1);
    if (this.ResURL != null) {
      paramJceOutputStream.write(this.ResURL, 2);
    }
    if (this.AttrMap != null) {
      paramJceOutputStream.write(this.AttrMap, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ResPackage.ResUpdate
 * JD-Core Version:    0.7.0.1
 */