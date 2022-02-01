package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaComment;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stDeleteFeedCommentReq
  extends JceStruct
  implements Cloneable
{
  static stMetaComment cache_comment = new stMetaComment();
  public stMetaComment comment = null;
  public String feed_id = "";
  
  public stDeleteFeedCommentReq() {}
  
  public stDeleteFeedCommentReq(String paramString, stMetaComment paramstMetaComment)
  {
    this.feed_id = paramString;
    this.comment = paramstMetaComment;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stDeleteFeedCommentReq";
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
    paramStringBuilder.display(this.comment, "comment");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.feed_id, true);
    paramStringBuilder.displaySimple(this.comment, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (stDeleteFeedCommentReq)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.feed_id, paramObject.feed_id))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.comment, paramObject.comment)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stDeleteFeedCommentReq";
  }
  
  public stMetaComment getComment()
  {
    return this.comment;
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
    this.feed_id = paramJceInputStream.readString(0, true);
    this.comment = ((stMetaComment)paramJceInputStream.read(cache_comment, 1, true));
  }
  
  public void setComment(stMetaComment paramstMetaComment)
  {
    this.comment = paramstMetaComment;
  }
  
  public void setFeed_id(String paramString)
  {
    this.feed_id = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.feed_id, 0);
    paramJceOutputStream.write(this.comment, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_INTERFACE.stDeleteFeedCommentReq
 * JD-Core Version:    0.7.0.1
 */