package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stPostCommentDingRsp
  extends JceStruct
  implements Cloneable
{
  public String nothing = "";
  
  public stPostCommentDingRsp() {}
  
  public stPostCommentDingRsp(String paramString)
  {
    this.nothing = paramString;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stPostCommentDingRsp";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.nothing, "nothing");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.nothing, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (stPostCommentDingRsp)paramObject;
    return JceUtil.equals(this.nothing, paramObject.nothing);
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stPostCommentDingRsp";
  }
  
  public String getNothing()
  {
    return this.nothing;
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
    this.nothing = paramJceInputStream.readString(0, false);
  }
  
  public void setNothing(String paramString)
  {
    this.nothing = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.nothing;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_INTERFACE.stPostCommentDingRsp
 * JD-Core Version:    0.7.0.1
 */