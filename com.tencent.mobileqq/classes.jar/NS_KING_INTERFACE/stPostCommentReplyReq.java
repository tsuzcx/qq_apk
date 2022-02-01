package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaReply;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPostCommentReplyReq
  extends JceStruct
{
  static stMetaReply cache_reply = new stMetaReply();
  public String commentId = "";
  public String feed_id = "";
  public stMetaReply reply = null;
  
  public stPostCommentReplyReq() {}
  
  public stPostCommentReplyReq(String paramString1, String paramString2, stMetaReply paramstMetaReply)
  {
    this.feed_id = paramString1;
    this.commentId = paramString2;
    this.reply = paramstMetaReply;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed_id = paramJceInputStream.readString(0, false);
    this.commentId = paramJceInputStream.readString(1, false);
    this.reply = ((stMetaReply)paramJceInputStream.read(cache_reply, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.feed_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.commentId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.reply;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_INTERFACE.stPostCommentReplyReq
 * JD-Core Version:    0.7.0.1
 */