package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public final class stMetaExternPlatformInfo
  extends JceStruct
  implements Cloneable
{
  static stAction cache_action;
  static Map<Integer, String> cache_reserve;
  public stAction action;
  public int count;
  public String icon = "";
  public String infoName = "";
  public String name = "";
  public Map<Integer, String> reserve;
  public int show;
  
  static
  {
    if (!stMetaExternPlatformInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_action = new stAction();
      cache_reserve = new HashMap();
      cache_reserve.put(Integer.valueOf(0), "");
      return;
    }
  }
  
  public stMetaExternPlatformInfo() {}
  
  public stMetaExternPlatformInfo(String paramString1, String paramString2, String paramString3, stAction paramstAction, int paramInt1, int paramInt2, Map<Integer, String> paramMap)
  {
    this.name = paramString1;
    this.icon = paramString2;
    this.infoName = paramString3;
    this.action = paramstAction;
    this.count = paramInt1;
    this.show = paramInt2;
    this.reserve = paramMap;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stMetaExternPlatformInfo";
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
    paramStringBuilder.display(this.name, "name");
    paramStringBuilder.display(this.icon, "icon");
    paramStringBuilder.display(this.infoName, "infoName");
    paramStringBuilder.display(this.action, "action");
    paramStringBuilder.display(this.count, "count");
    paramStringBuilder.display(this.show, "show");
    paramStringBuilder.display(this.reserve, "reserve");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.name, true);
    paramStringBuilder.displaySimple(this.icon, true);
    paramStringBuilder.displaySimple(this.infoName, true);
    paramStringBuilder.displaySimple(this.action, true);
    paramStringBuilder.displaySimple(this.count, true);
    paramStringBuilder.displaySimple(this.show, true);
    paramStringBuilder.displaySimple(this.reserve, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stMetaExternPlatformInfo)paramObject;
    } while ((!JceUtil.equals(this.name, paramObject.name)) || (!JceUtil.equals(this.icon, paramObject.icon)) || (!JceUtil.equals(this.infoName, paramObject.infoName)) || (!JceUtil.equals(this.action, paramObject.action)) || (!JceUtil.equals(this.count, paramObject.count)) || (!JceUtil.equals(this.show, paramObject.show)) || (!JceUtil.equals(this.reserve, paramObject.reserve)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stMetaExternPlatformInfo";
  }
  
  public stAction getAction()
  {
    return this.action;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public String getInfoName()
  {
    return this.infoName;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Map<Integer, String> getReserve()
  {
    return this.reserve;
  }
  
  public int getShow()
  {
    return this.show;
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
    this.name = paramJceInputStream.readString(0, false);
    this.icon = paramJceInputStream.readString(1, false);
    this.infoName = paramJceInputStream.readString(2, false);
    this.action = ((stAction)paramJceInputStream.read(cache_action, 3, false));
    this.count = paramJceInputStream.read(this.count, 4, false);
    this.show = paramJceInputStream.read(this.show, 5, false);
    this.reserve = ((Map)paramJceInputStream.read(cache_reserve, 6, false));
  }
  
  public void setAction(stAction paramstAction)
  {
    this.action = paramstAction;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setInfoName(String paramString)
  {
    this.infoName = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setReserve(Map<Integer, String> paramMap)
  {
    this.reserve = paramMap;
  }
  
  public void setShow(int paramInt)
  {
    this.show = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 0);
    }
    if (this.icon != null) {
      paramJceOutputStream.write(this.icon, 1);
    }
    if (this.infoName != null) {
      paramJceOutputStream.write(this.infoName, 2);
    }
    if (this.action != null) {
      paramJceOutputStream.write(this.action, 3);
    }
    paramJceOutputStream.write(this.count, 4);
    paramJceOutputStream.write(this.show, 5);
    if (this.reserve != null) {
      paramJceOutputStream.write(this.reserve, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stMetaExternPlatformInfo
 * JD-Core Version:    0.7.0.1
 */