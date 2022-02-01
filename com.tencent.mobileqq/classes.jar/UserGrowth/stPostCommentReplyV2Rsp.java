package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPostCommentReplyV2Rsp
  extends JceStruct
{
  static stSimpleMetaReply cache_reply = new stSimpleMetaReply();
  public int arkPopWindow = 0;
  public stSimpleMetaReply reply = null;
  public int sendArk = 0;
  
  public stPostCommentReplyV2Rsp() {}
  
  public stPostCommentReplyV2Rsp(stSimpleMetaReply paramstSimpleMetaReply, int paramInt1, int paramInt2)
  {
    this.reply = paramstSimpleMetaReply;
    this.sendArk = paramInt1;
    this.arkPopWindow = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reply = ((stSimpleMetaReply)paramJceInputStream.read(cache_reply, 0, false));
    this.sendArk = paramJceInputStream.read(this.sendArk, 1, false);
    this.arkPopWindow = paramJceInputStream.read(this.arkPopWindow, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    stSimpleMetaReply localstSimpleMetaReply = this.reply;
    if (localstSimpleMetaReply != null) {
      paramJceOutputStream.write(localstSimpleMetaReply, 0);
    }
    paramJceOutputStream.write(this.sendArk, 1);
    paramJceOutputStream.write(this.arkPopWindow, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stPostCommentReplyV2Rsp
 * JD-Core Version:    0.7.0.1
 */