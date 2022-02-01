package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaReply;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPostCommentReplyRsp
  extends JceStruct
{
  static stMetaReply cache_reply = new stMetaReply();
  public stMetaReply reply = null;
  
  public stPostCommentReplyRsp() {}
  
  public stPostCommentReplyRsp(stMetaReply paramstMetaReply)
  {
    this.reply = paramstMetaReply;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reply = ((stMetaReply)paramJceInputStream.read(cache_reply, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.reply != null) {
      paramJceOutputStream.write(this.reply, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stPostCommentReplyRsp
 * JD-Core Version:    0.7.0.1
 */