package UserGrowth;

import NS_KING_INTERFACE.stGetFeedCommentListRsp;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stQQGetFeedCommentListRsp
  extends JceStruct
{
  static ArrayList<stCommentJumpText> cache_comment_text;
  static stGetFeedCommentListRsp cache_rsp = new stGetFeedCommentListRsp();
  public ArrayList<stCommentJumpText> comment_text;
  public int link;
  public stGetFeedCommentListRsp rsp;
  
  static
  {
    cache_comment_text = new ArrayList();
    stCommentJumpText localstCommentJumpText = new stCommentJumpText();
    cache_comment_text.add(localstCommentJumpText);
  }
  
  public stQQGetFeedCommentListRsp() {}
  
  public stQQGetFeedCommentListRsp(stGetFeedCommentListRsp paramstGetFeedCommentListRsp, int paramInt, ArrayList<stCommentJumpText> paramArrayList)
  {
    this.rsp = paramstGetFeedCommentListRsp;
    this.link = paramInt;
    this.comment_text = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rsp = ((stGetFeedCommentListRsp)paramJceInputStream.read(cache_rsp, 0, false));
    this.link = paramJceInputStream.read(this.link, 1, false);
    this.comment_text = ((ArrayList)paramJceInputStream.read(cache_comment_text, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rsp != null) {
      paramJceOutputStream.write(this.rsp, 0);
    }
    paramJceOutputStream.write(this.link, 1);
    if (this.comment_text != null) {
      paramJceOutputStream.write(this.comment_text, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stQQGetFeedCommentListRsp
 * JD-Core Version:    0.7.0.1
 */