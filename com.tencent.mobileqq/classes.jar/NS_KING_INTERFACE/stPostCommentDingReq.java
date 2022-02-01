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
  public int dingAction = 0;
  public String feed_id = "";
  
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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (stPostCommentDingReq)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.feed_id, paramObject.feed_id))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.commentId, paramObject.commentId))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.dingAction, paramObject.dingAction)) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
    String str = this.feed_id;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.commentId;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.dingAction, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_INTERFACE.stPostCommentDingReq
 * JD-Core Version:    0.7.0.1
 */