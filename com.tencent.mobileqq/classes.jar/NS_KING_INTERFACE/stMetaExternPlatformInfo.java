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
  static stAction cache_action = new stAction();
  static Map<Integer, String> cache_reserve = new HashMap();
  public stAction action = null;
  public int count = 0;
  public String icon = "";
  public String infoName = "";
  public String name = "";
  public Map<Integer, String> reserve = null;
  public int show = 0;
  
  static
  {
    cache_reserve.put(Integer.valueOf(0), "");
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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (stMetaExternPlatformInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.name, paramObject.name))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.icon, paramObject.icon))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.infoName, paramObject.infoName))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.action, paramObject.action))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.count, paramObject.count))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.show, paramObject.show))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.reserve, paramObject.reserve)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
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
    Object localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.icon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.infoName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.action;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    paramJceOutputStream.write(this.count, 4);
    paramJceOutputStream.write(this.show, 5);
    localObject = this.reserve;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_INTERFACE.stMetaExternPlatformInfo
 * JD-Core Version:    0.7.0.1
 */