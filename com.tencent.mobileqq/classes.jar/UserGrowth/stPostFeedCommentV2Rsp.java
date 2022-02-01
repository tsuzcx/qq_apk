package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPostFeedCommentV2Rsp
  extends JceStruct
{
  static stSimpleMetaComment cache_comment = new stSimpleMetaComment();
  public stSimpleMetaComment comment = null;
  public int prompt = 0;
  
  public stPostFeedCommentV2Rsp() {}
  
  public stPostFeedCommentV2Rsp(stSimpleMetaComment paramstSimpleMetaComment, int paramInt)
  {
    this.comment = paramstSimpleMetaComment;
    this.prompt = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.comment = ((stSimpleMetaComment)paramJceInputStream.read(cache_comment, 0, true));
    this.prompt = paramJceInputStream.read(this.prompt, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.comment, 0);
    paramJceOutputStream.write(this.prompt, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stPostFeedCommentV2Rsp
 * JD-Core Version:    0.7.0.1
 */