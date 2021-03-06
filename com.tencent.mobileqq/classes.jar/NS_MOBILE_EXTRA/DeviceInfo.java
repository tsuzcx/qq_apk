package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import org.json.JSONException;
import org.json.JSONObject;

public final class DeviceInfo
  extends JceStruct
  implements Cloneable
{
  public int iChooseTag;
  public int iEditTag;
  public int iOpMask;
  public String strDeviceIcon = "";
  public String strDeviceTail = "";
  public String strDiyMemo = "";
  public String strIdentifySqua = "";
  
  public DeviceInfo() {}
  
  public DeviceInfo(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3)
  {
    this.strDeviceTail = paramString1;
    this.strDeviceIcon = paramString2;
    this.iOpMask = paramInt1;
    this.strIdentifySqua = paramString3;
    this.strDiyMemo = paramString4;
    this.iChooseTag = paramInt2;
    this.iEditTag = paramInt3;
  }
  
  public String className()
  {
    return "NS_MOBILE_EXTRA.DeviceInfo";
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
    paramStringBuilder.display(this.strDeviceTail, "strDeviceTail");
    paramStringBuilder.display(this.strDeviceIcon, "strDeviceIcon");
    paramStringBuilder.display(this.iOpMask, "iOpMask");
    paramStringBuilder.display(this.strIdentifySqua, "strIdentifySqua");
    paramStringBuilder.display(this.strDiyMemo, "strDiyMemo");
    paramStringBuilder.display(this.iChooseTag, "iChooseTag");
    paramStringBuilder.display(this.iEditTag, "iEditTag");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.strDeviceTail, true);
    paramStringBuilder.displaySimple(this.strDeviceIcon, true);
    paramStringBuilder.displaySimple(this.iOpMask, true);
    paramStringBuilder.displaySimple(this.strIdentifySqua, true);
    paramStringBuilder.displaySimple(this.strDiyMemo, true);
    paramStringBuilder.displaySimple(this.iChooseTag, true);
    paramStringBuilder.displaySimple(this.iEditTag, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (DeviceInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.strDeviceTail, paramObject.strDeviceTail))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.strDeviceIcon, paramObject.strDeviceIcon))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.iOpMask, paramObject.iOpMask))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.strIdentifySqua, paramObject.strIdentifySqua))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.strDiyMemo, paramObject.strDiyMemo))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.iChooseTag, paramObject.iChooseTag))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.iEditTag, paramObject.iEditTag)) {
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
    return "NS_MOBILE_EXTRA.DeviceInfo";
  }
  
  public int getIChooseTag()
  {
    return this.iChooseTag;
  }
  
  public int getIEditTag()
  {
    return this.iEditTag;
  }
  
  public int getIOpMask()
  {
    return this.iOpMask;
  }
  
  public String getStrDeviceIcon()
  {
    return this.strDeviceIcon;
  }
  
  public String getStrDeviceTail()
  {
    return this.strDeviceTail;
  }
  
  public String getStrDiyMemo()
  {
    return this.strDiyMemo;
  }
  
  public String getStrIdentifySqua()
  {
    return this.strIdentifySqua;
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
    this.strDeviceTail = paramJceInputStream.readString(0, true);
    this.strDeviceIcon = paramJceInputStream.readString(1, true);
    this.iOpMask = paramJceInputStream.read(this.iOpMask, 2, false);
    this.strIdentifySqua = paramJceInputStream.readString(3, false);
    this.strDiyMemo = paramJceInputStream.readString(4, false);
    this.iChooseTag = paramJceInputStream.read(this.iChooseTag, 5, false);
    this.iEditTag = paramJceInputStream.read(this.iEditTag, 6, false);
  }
  
  public void setIChooseTag(int paramInt)
  {
    this.iChooseTag = paramInt;
  }
  
  public void setIEditTag(int paramInt)
  {
    this.iEditTag = paramInt;
  }
  
  public void setIOpMask(int paramInt)
  {
    this.iOpMask = paramInt;
  }
  
  public void setStrDeviceIcon(String paramString)
  {
    this.strDeviceIcon = paramString;
  }
  
  public void setStrDeviceTail(String paramString)
  {
    this.strDeviceTail = paramString;
  }
  
  public void setStrDiyMemo(String paramString)
  {
    this.strDiyMemo = paramString;
  }
  
  public void setStrIdentifySqua(String paramString)
  {
    this.strIdentifySqua = paramString;
  }
  
  public JSONObject toJSON()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("strDiyMemo", this.strDiyMemo);
      localJSONObject.put("strDeviceTail", this.strDeviceTail);
      localJSONObject.put("iOpMask", this.iOpMask);
      localJSONObject.put("strIdentifySqua", this.strIdentifySqua);
      localJSONObject.put("strDeviceIcon", this.strDeviceIcon);
      localJSONObject.put("iChooseTag", this.iChooseTag);
      localJSONObject.put("iDeviceType", this.iEditTag);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strDeviceTail, 0);
    paramJceOutputStream.write(this.strDeviceIcon, 1);
    paramJceOutputStream.write(this.iOpMask, 2);
    String str = this.strIdentifySqua;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.strDiyMemo;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.iChooseTag, 5);
    paramJceOutputStream.write(this.iEditTag, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */