package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPostCommentReplyV2Rsp
  extends JceStruct
{
  static stSimpleMetaReply cache_reply = new stSimpleMetaReply();
  public stSimpleMetaReply reply = null;
  
  public stPostCommentReplyV2Rsp() {}
  
  public stPostCommentReplyV2Rsp(stSimpleMetaReply paramstSimpleMetaReply)
  {
    this.reply = paramstSimpleMetaReply;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reply = ((stSimpleMetaReply)paramJceInputStream.read(cache_reply, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.reply != null) {
      paramJceOutputStream.write(this.reply, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stPostCommentReplyV2Rsp
 * JD-Core Version:    0.7.0.1
 */