package NS_KING_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetFeedCommentListV2Req
  extends JceStruct
{
  public String attach_info = "";
  public String commentId = "";
  public String contextCommentID = "";
  public String contextReplyID = "";
  public String feed_id = "";
  public int getRepyListByPage = 0;
  public int isFirst = 0;
  public String replyId = "";
  public int reqFrom = 0;
  
  public stGetFeedCommentListV2Req() {}
  
  public stGetFeedCommentListV2Req(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5, String paramString6, int paramInt3)
  {
    this.attach_info = paramString1;
    this.feed_id = paramString2;
    this.commentId = paramString3;
    this.reqFrom = paramInt1;
    this.replyId = paramString4;
    this.getRepyListByPage = paramInt2;
    this.contextCommentID = paramString5;
    this.contextReplyID = paramString6;
    this.isFirst = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attach_info = paramJceInputStream.readString(0, true);
    this.feed_id = paramJceInputStream.readString(1, true);
    this.commentId = paramJceInputStream.readString(2, false);
    this.reqFrom = paramJceInputStream.read(this.reqFrom, 3, false);
    this.replyId = paramJceInputStream.readString(4, false);
    this.getRepyListByPage = paramJceInputStream.read(this.getRepyListByPage, 5, false);
    this.contextCommentID = paramJceInputStream.readString(6, false);
    this.contextReplyID = paramJceInputStream.readString(7, false);
    this.isFirst = paramJceInputStream.read(this.isFirst, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.attach_info, 0);
    paramJceOutputStream.write(this.feed_id, 1);
    String str = this.commentId;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.reqFrom, 3);
    str = this.replyId;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.getRepyListByPage, 5);
    str = this.contextCommentID;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.contextReplyID;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    paramJceOutputStream.write(this.isFirst, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_INTERFACE.stGetFeedCommentListV2Req
 * JD-Core Version:    0.7.0.1
 */