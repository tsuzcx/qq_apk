package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stGetCommentReplyListReq
  extends JceStruct
  implements Cloneable
{
  public String attach_info = "";
  public String commentId = "";
  public int direction = 0;
  public String feed_id = "";
  
  static
  {
    if (!stGetCommentReplyListReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public stGetCommentReplyListReq() {}
  
  public stGetCommentReplyListReq(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.attach_info = paramString1;
    this.feed_id = paramString2;
    this.commentId = paramString3;
    this.direction = paramInt;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stGetCommentReplyListReq";
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
    paramStringBuilder.display(this.attach_info, "attach_info");
    paramStringBuilder.display(this.feed_id, "feed_id");
    paramStringBuilder.display(this.commentId, "commentId");
    paramStringBuilder.display(this.direction, "direction");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.attach_info, true);
    paramStringBuilder.displaySimple(this.feed_id, true);
    paramStringBuilder.displaySimple(this.commentId, true);
    paramStringBuilder.displaySimple(this.direction, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stGetCommentReplyListReq)paramObject;
    } while ((!JceUtil.equals(this.attach_info, paramObject.attach_info)) || (!JceUtil.equals(this.feed_id, paramObject.feed_id)) || (!JceUtil.equals(this.commentId, paramObject.commentId)) || (!JceUtil.equals(this.direction, paramObject.direction)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stGetCommentReplyListReq";
  }
  
  public String getAttach_info()
  {
    return this.attach_info;
  }
  
  public String getCommentId()
  {
    return this.commentId;
  }
  
  public int getDirection()
  {
    return this.direction;
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
    this.attach_info = paramJceInputStream.readString(0, true);
    this.feed_id = paramJceInputStream.readString(1, true);
    this.commentId = paramJceInputStream.readString(2, true);
    this.direction = paramJceInputStream.read(this.direction, 3, false);
  }
  
  public void setAttach_info(String paramString)
  {
    this.attach_info = paramString;
  }
  
  public void setCommentId(String paramString)
  {
    this.commentId = paramString;
  }
  
  public void setDirection(int paramInt)
  {
    this.direction = paramInt;
  }
  
  public void setFeed_id(String paramString)
  {
    this.feed_id = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.attach_info, 0);
    paramJceOutputStream.write(this.feed_id, 1);
    paramJceOutputStream.write(this.commentId, 2);
    paramJceOutputStream.write(this.direction, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stGetCommentReplyListReq
 * JD-Core Version:    0.7.0.1
 */