package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stPostCommentDingReq
  extends JceStruct
  implements Cloneable
{
  public String commentId = "";
  public int dingAction;
  public String feed_id = "";
  
  static
  {
    if (!stPostCommentDingReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public stPostCommentDingReq() {}
  
  public stPostCommentDingReq(String paramString1, String paramString2, int paramInt)
  {
    this.feed_id = paramString1;
    this.commentId = paramString2;
    this.dingAction = paramInt;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stPostCommentDingReq";
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
    paramStringBuilder.display(this.feed_id, "feed_id");
    paramStringBuilder.display(this.commentId, "commentId");
    paramStringBuilder.display(this.dingAction, "dingAction");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.feed_id, true);
    paramStringBuilder.displaySimple(this.commentId, true);
    paramStringBuilder.displaySimple(this.dingAction, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stPostCommentDingReq)paramObject;
    } while ((!JceUtil.equals(this.feed_id, paramObject.feed_id)) || (!JceUtil.equals(this.commentId, paramObject.commentId)) || (!JceUtil.equals(this.dingAction, paramObject.dingAction)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stPostCommentDingReq";
  }
  
  public String getCommentId()
  {
    return this.commentId;
  }
  
  public int getDingAction()
  {
    return this.dingAction;
  }
  
  public String getFeed_id()
  {
    return this.feed_id;
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
    this.feed_id = paramJceInputStream.readString(0, false);
    this.commentId = paramJceInputStream.readString(1, false);
    this.dingAction = paramJceInputStream.read(this.dingAction, 2, false);
  }
  
  public void setCommentId(String paramString)
  {
    this.commentId = paramString;
  }
  
  public void setDingAction(int paramInt)
  {
    this.dingAction = paramInt;
  }
  
  public void setFeed_id(String paramString)
  {
    this.feed_id = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.feed_id != null) {
      paramJceOutputStream.write(this.feed_id, 0);
    }
    if (this.commentId != null) {
      paramJceOutputStream.write(this.commentId, 1);
    }
    paramJceOutputStream.write(this.dingAction, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stPostCommentDingReq
 * JD-Core Version:    0.7.0.1
 */