package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class stPostCommentReplyV2Req
  extends JceStruct
{
  static ArrayList<String> cache_atUserQQ;
  static stSimpleMetaReply cache_reply = new stSimpleMetaReply();
  public ArrayList<String> atUserQQ = null;
  public String commentId = "";
  public String feed_id = "";
  public stSimpleMetaReply reply = null;
  
  static
  {
    cache_atUserQQ = new ArrayList();
    cache_atUserQQ.add("");
  }
  
  public stPostCommentReplyV2Req() {}
  
  public stPostCommentReplyV2Req(String paramString1, String paramString2, stSimpleMetaReply paramstSimpleMetaReply, ArrayList<String> paramArrayList)
  {
    this.feed_id = paramString1;
    this.commentId = paramString2;
    this.reply = paramstSimpleMetaReply;
    this.atUserQQ = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed_id = paramJceInputStream.readString(0, false);
    this.commentId = paramJceInputStream.readString(1, false);
    this.reply = ((stSimpleMetaReply)paramJceInputStream.read(cache_reply, 2, false));
    this.atUserQQ = ((ArrayList)paramJceInputStream.read(cache_atUserQQ, 3, false));
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
    localObject = this.atUserQQ;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stPostCommentReplyV2Req
 * JD-Core Version:    0.7.0.1
 */