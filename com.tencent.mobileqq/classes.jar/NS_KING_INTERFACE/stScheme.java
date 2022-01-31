package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stScheme
  extends JceStruct
  implements Cloneable
{
  public String appID = "";
  public String schemeURL = "";
  public String storeURL = "";
  public String webURL = "";
  
  static
  {
    if (!stScheme.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public stScheme() {}
  
  public stScheme(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.appID = paramString1;
    this.schemeURL = paramString2;
    this.storeURL = paramString3;
    this.webURL = paramString4;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stScheme";
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
    paramStringBuilder.display(this.appID, "appID");
    paramStringBuilder.display(this.schemeURL, "schemeURL");
    paramStringBuilder.display(this.storeURL, "storeURL");
    paramStringBuilder.display(this.webURL, "webURL");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.appID, true);
    paramStringBuilder.displaySimple(this.schemeURL, true);
    paramStringBuilder.displaySimple(this.storeURL, true);
    paramStringBuilder.displaySimple(this.webURL, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stScheme)paramObject;
    } while ((!JceUtil.equals(this.appID, paramObject.appID)) || (!JceUtil.equals(this.schemeURL, paramObject.schemeURL)) || (!JceUtil.equals(this.storeURL, paramObject.storeURL)) || (!JceUtil.equals(this.webURL, paramObject.webURL)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stScheme";
  }
  
  public String getAppID()
  {
    return this.appID;
  }
  
  public String getSchemeURL()
  {
    return this.schemeURL;
  }
  
  public String getStoreURL()
  {
    return this.storeURL;
  }
  
  public String getWebURL()
  {
    return this.webURL;
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
    this.appID = paramJceInputStream.readString(0, false);
    this.schemeURL = paramJceInputStream.readString(1, false);
    this.storeURL = paramJceInputStream.readString(2, false);
    this.webURL = paramJceInputStream.readString(3, false);
  }
  
  public void setAppID(String paramString)
  {
    this.appID = paramString;
  }
  
  public void setSchemeURL(String paramString)
  {
    this.schemeURL = paramString;
  }
  
  public void setStoreURL(String paramString)
  {
    this.storeURL = paramString;
  }
  
  public void setWebURL(String paramString)
  {
    this.webURL = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.appID != null) {
      paramJceOutputStream.write(this.appID, 0);
    }
    if (this.schemeURL != null) {
      paramJceOutputStream.write(this.schemeURL, 1);
    }
    if (this.storeURL != null) {
      paramJceOutputStream.write(this.storeURL, 2);
    }
    if (this.webURL != null) {
      paramJceOutputStream.write(this.webURL, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stScheme
 * JD-Core Version:    0.7.0.1
 */