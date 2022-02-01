package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaComment;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stPostFeedCommentRsp
  extends JceStruct
  implements Cloneable
{
  static stMetaComment cache_comment;
  public stMetaComment comment = null;
  public int prompt = 0;
  
  static
  {
    if (!stPostFeedCommentRsp.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_comment = new stMetaComment();
      return;
    }
  }
  
  public stPostFeedCommentRsp() {}
  
  public stPostFeedCommentRsp(stMetaComment paramstMetaComment, int paramInt)
  {
    this.comment = paramstMetaComment;
    this.prompt = paramInt;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stPostFeedCommentRsp";
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
    paramStringBuilder.display(this.comment, "comment");
    paramStringBuilder.display(this.prompt, "prompt");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.comment, true);
    paramStringBuilder.displaySimple(this.prompt, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stPostFeedCommentRsp)paramObject;
    } while ((!JceUtil.equals(this.comment, paramObject.comment)) || (!JceUtil.equals(this.prompt, paramObject.prompt)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stPostFeedCommentRsp";
  }
  
  public stMetaComment getComment()
  {
    return this.comment;
  }
  
  public int getPrompt()
  {
    return this.prompt;
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
    this.comment = ((stMetaComment)paramJceInputStream.read(cache_comment, 0, true));
    this.prompt = paramJceInputStream.read(this.prompt, 1, false);
  }
  
  public void setComment(stMetaComment paramstMetaComment)
  {
    this.comment = paramstMetaComment;
  }
  
  public void setPrompt(int paramInt)
  {
    this.prompt = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.comment, 0);
    paramJceOutputStream.write(this.prompt, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stPostFeedCommentRsp
 * JD-Core Version:    0.7.0.1
 */