package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stDelCommentReplyReq
  extends JceStruct
  implements Cloneable
{
  public String commentId = "";
  public String feed_id = "";
  public String replyId = "";
  
  static
  {
    if (!stDelCommentReplyReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public stDelCommentReplyReq() {}
  
  public stDelCommentReplyReq(String paramString1, String paramString2)
  {
    this.feed_id = paramString1;
    this.commentId = paramString2;
  }
  
  public stDelCommentReplyReq(String paramString1, String paramString2, String paramString3)
  {
    this.feed_id = paramString1;
    this.commentId = paramString2;
    this.replyId = paramString3;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stDelCommentReplyReq";
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
    paramStringBuilder.display(this.replyId, "replyId");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.feed_id, true);
    paramStringBuilder.displaySimple(this.commentId, true);
    paramStringBuilder.displaySimple(this.replyId, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stDelCommentReplyReq)paramObject;
    } while ((!JceUtil.equals(this.feed_id, paramObject.feed_id)) || (!JceUtil.equals(this.commentId, paramObject.commentId)) || (!JceUtil.equals(this.replyId, paramObject.replyId)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stDelCommentReplyReq";
  }
  
  public String getCommentId()
  {
    return this.commentId;
  }
  
  public String getFeed_id()
  {
    return this.feed_id;
  }
  
  public String getReplyId()
  {
    return this.replyId;
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
    this.replyId = paramJceInputStream.readString(2, false);
  }
  
  public void setCommentId(String paramString)
  {
    this.commentId = paramString;
  }
  
  public void setFeed_id(String paramString)
  {
    this.feed_id = paramString;
  }
  
  public void setReplyId(String paramString)
  {
    this.replyId = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.feed_id != null) {
      paramJceOutputStream.write(this.feed_id, 0);
    }
    if (this.commentId != null) {
      paramJceOutputStream.write(this.commentId, 1);
    }
    if (this.replyId != null) {
      paramJceOutputStream.write(this.replyId, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stDelCommentReplyReq
 * JD-Core Version:    0.7.0.1
 */