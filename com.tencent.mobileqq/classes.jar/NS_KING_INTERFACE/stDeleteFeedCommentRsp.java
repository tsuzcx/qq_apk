package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stDeleteFeedCommentRsp
  extends JceStruct
  implements Cloneable
{
  public int ret = 0;
  
  public stDeleteFeedCommentRsp() {}
  
  public stDeleteFeedCommentRsp(int paramInt)
  {
    this.ret = paramInt;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stDeleteFeedCommentRsp";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.ret, "ret");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.ret, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (stDeleteFeedCommentRsp)paramObject;
    return JceUtil.equals(this.ret, paramObject.ret);
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stDeleteFeedCommentRsp";
  }
  
  public int getRet()
  {
    return this.ret;
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
    this.ret = paramJceInputStream.read(this.ret, 0, true);
  }
  
  public void setRet(int paramInt)
  {
    this.ret = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_INTERFACE.stDeleteFeedCommentRsp
 * JD-Core Version:    0.7.0.1
 */