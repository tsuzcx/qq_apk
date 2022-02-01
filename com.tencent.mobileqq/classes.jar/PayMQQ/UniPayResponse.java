package PayMQQ;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public final class UniPayResponse
  extends JceStruct
  implements Cloneable
{
  static Map<String, String> cache_mapResponse;
  public int iShowOpen = 0;
  public int iUniPayType = 0;
  public Map<String, String> mapResponse = null;
  public String sProductID = "";
  public String sUin = "";
  
  public UniPayResponse() {}
  
  public UniPayResponse(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap)
  {
    this.sUin = paramString1;
    this.iShowOpen = paramInt1;
    this.iUniPayType = paramInt2;
    this.sProductID = paramString2;
    this.mapResponse = paramMap;
  }
  
  public String className()
  {
    return "MQQ.UniPayResponse";
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
    paramStringBuilder.display(this.sUin, "sUin");
    paramStringBuilder.display(this.iShowOpen, "iShowOpen");
    paramStringBuilder.display(this.iUniPayType, "iUniPayType");
    paramStringBuilder.display(this.sProductID, "sProductID");
    paramStringBuilder.display(this.mapResponse, "mapResponse");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.sUin, true);
    paramStringBuilder.displaySimple(this.iShowOpen, true);
    paramStringBuilder.displaySimple(this.iUniPayType, true);
    paramStringBuilder.displaySimple(this.sProductID, true);
    paramStringBuilder.displaySimple(this.mapResponse, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (UniPayResponse)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.sUin, paramObject.sUin))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.iShowOpen, paramObject.iShowOpen))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.iUniPayType, paramObject.iUniPayType))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.sProductID, paramObject.sProductID))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.mapResponse, paramObject.mapResponse)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "MQQ.UniPayResponse";
  }
  
  public int getIShowOpen()
  {
    return this.iShowOpen;
  }
  
  public int getIUniPayType()
  {
    return this.iUniPayType;
  }
  
  public Map<String, String> getMapResponse()
  {
    return this.mapResponse;
  }
  
  public String getSProductID()
  {
    return this.sProductID;
  }
  
  public String getSUin()
  {
    return this.sUin;
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
    this.sUin = paramJceInputStream.readString(0, true);
    this.iShowOpen = paramJceInputStream.read(this.iShowOpen, 1, true);
    this.iUniPayType = paramJceInputStream.read(this.iUniPayType, 2, true);
    this.sProductID = paramJceInputStream.readString(3, true);
    if (cache_mapResponse == null)
    {
      cache_mapResponse = new HashMap();
      cache_mapResponse.put("", "");
    }
    this.mapResponse = ((Map)paramJceInputStream.read(cache_mapResponse, 4, true));
  }
  
  public void setIShowOpen(int paramInt)
  {
    this.iShowOpen = paramInt;
  }
  
  public void setIUniPayType(int paramInt)
  {
    this.iUniPayType = paramInt;
  }
  
  public void setMapResponse(Map<String, String> paramMap)
  {
    this.mapResponse = paramMap;
  }
  
  public void setSProductID(String paramString)
  {
    this.sProductID = paramString;
  }
  
  public void setSUin(String paramString)
  {
    this.sUin = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sUin, 0);
    paramJceOutputStream.write(this.iShowOpen, 1);
    paramJceOutputStream.write(this.iUniPayType, 2);
    paramJceOutputStream.write(this.sProductID, 3);
    paramJceOutputStream.write(this.mapResponse, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     PayMQQ.UniPayResponse
 * JD-Core Version:    0.7.0.1
 */