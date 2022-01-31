package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stAction
  extends JceStruct
  implements Cloneable
{
  static stScheme cache_scheme;
  static int cache_type;
  public String argb = "";
  public String icon = "";
  public stScheme scheme;
  public String text = "";
  public int type;
  
  static
  {
    if (!stAction.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_type = 0;
      cache_scheme = new stScheme();
      return;
    }
  }
  
  public stAction() {}
  
  public stAction(int paramInt, stScheme paramstScheme, String paramString1, String paramString2, String paramString3)
  {
    this.type = paramInt;
    this.scheme = paramstScheme;
    this.icon = paramString1;
    this.argb = paramString2;
    this.text = paramString3;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stAction";
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
    paramStringBuilder.display(this.type, "type");
    paramStringBuilder.display(this.scheme, "scheme");
    paramStringBuilder.display(this.icon, "icon");
    paramStringBuilder.display(this.argb, "argb");
    paramStringBuilder.display(this.text, "text");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.type, true);
    paramStringBuilder.displaySimple(this.scheme, true);
    paramStringBuilder.displaySimple(this.icon, true);
    paramStringBuilder.displaySimple(this.argb, true);
    paramStringBuilder.displaySimple(this.text, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stAction)paramObject;
    } while ((!JceUtil.equals(this.type, paramObject.type)) || (!JceUtil.equals(this.scheme, paramObject.scheme)) || (!JceUtil.equals(this.icon, paramObject.icon)) || (!JceUtil.equals(this.argb, paramObject.argb)) || (!JceUtil.equals(this.text, paramObject.text)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stAction";
  }
  
  public String getArgb()
  {
    return this.argb;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public stScheme getScheme()
  {
    return this.scheme;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public int getType()
  {
    return this.type;
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
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.scheme = ((stScheme)paramJceInputStream.read(cache_scheme, 1, false));
    this.icon = paramJceInputStream.readString(2, false);
    this.argb = paramJceInputStream.readString(3, false);
    this.text = paramJceInputStream.readString(4, false);
  }
  
  public void setArgb(String paramString)
  {
    this.argb = paramString;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setScheme(stScheme paramstScheme)
  {
    this.scheme = paramstScheme;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.scheme != null) {
      paramJceOutputStream.write(this.scheme, 1);
    }
    if (this.icon != null) {
      paramJceOutputStream.write(this.icon, 2);
    }
    if (this.argb != null) {
      paramJceOutputStream.write(this.argb, 3);
    }
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stAction
 * JD-Core Version:    0.7.0.1
 */