package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stReplyListInfo
  extends JceStruct
  implements Cloneable
{
  public String attach_info = "";
  public boolean isFinished = true;
  public boolean isRFinished = true;
  
  public stReplyListInfo() {}
  
  public stReplyListInfo(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.isFinished = paramBoolean1;
    this.isRFinished = paramBoolean2;
    this.attach_info = paramString;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stReplyListInfo";
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
    paramStringBuilder.display(this.isFinished, "isFinished");
    paramStringBuilder.display(this.isRFinished, "isRFinished");
    paramStringBuilder.display(this.attach_info, "attach_info");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.isFinished, true);
    paramStringBuilder.displaySimple(this.isRFinished, true);
    paramStringBuilder.displaySimple(this.attach_info, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (stReplyListInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.isFinished, paramObject.isFinished))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.isRFinished, paramObject.isRFinished))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.attach_info, paramObject.attach_info)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stReplyListInfo";
  }
  
  public String getAttach_info()
  {
    return this.attach_info;
  }
  
  public boolean getIsFinished()
  {
    return this.isFinished;
  }
  
  public boolean getIsRFinished()
  {
    return this.isRFinished;
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
    this.isFinished = paramJceInputStream.read(this.isFinished, 0, false);
    this.isRFinished = paramJceInputStream.read(this.isRFinished, 1, false);
    this.attach_info = paramJceInputStream.readString(2, false);
  }
  
  public void setAttach_info(String paramString)
  {
    this.attach_info = paramString;
  }
  
  public void setIsFinished(boolean paramBoolean)
  {
    this.isFinished = paramBoolean;
  }
  
  public void setIsRFinished(boolean paramBoolean)
  {
    this.isRFinished = paramBoolean;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isFinished, 0);
    paramJceOutputStream.write(this.isRFinished, 1);
    String str = this.attach_info;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_INTERFACE.stReplyListInfo
 * JD-Core Version:    0.7.0.1
 */