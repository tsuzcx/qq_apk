package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommentUgcDeco
  extends JceStruct
{
  static CommentBubble cache_stBubble = new CommentBubble();
  public CommentBubble stBubble;
  
  public CommentUgcDeco() {}
  
  public CommentUgcDeco(CommentBubble paramCommentBubble)
  {
    this.stBubble = paramCommentBubble;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stBubble = ((CommentBubble)paramJceInputStream.read(cache_stBubble, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stBubble != null) {
      paramJceOutputStream.write(this.stBubble, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.CommentUgcDeco
 * JD-Core Version:    0.7.0.1
 */