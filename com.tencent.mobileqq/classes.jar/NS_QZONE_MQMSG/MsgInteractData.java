package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsgInteractData
  extends JceStruct
{
  static CommentInfo cache_commentInfo = new CommentInfo();
  static LikInfo cache_likInfo = new LikInfo();
  static ShareInfo cache_shareInfo = new ShareInfo();
  public CommentInfo commentInfo;
  public LikInfo likInfo;
  public ShareInfo shareInfo;
  public int type;
  
  public MsgInteractData() {}
  
  public MsgInteractData(int paramInt, LikInfo paramLikInfo, CommentInfo paramCommentInfo, ShareInfo paramShareInfo)
  {
    this.type = paramInt;
    this.likInfo = paramLikInfo;
    this.commentInfo = paramCommentInfo;
    this.shareInfo = paramShareInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.likInfo = ((LikInfo)paramJceInputStream.read(cache_likInfo, 1, false));
    this.commentInfo = ((CommentInfo)paramJceInputStream.read(cache_commentInfo, 2, false));
    this.shareInfo = ((ShareInfo)paramJceInputStream.read(cache_shareInfo, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.likInfo != null) {
      paramJceOutputStream.write(this.likInfo, 1);
    }
    if (this.commentInfo != null) {
      paramJceOutputStream.write(this.commentInfo, 2);
    }
    if (this.shareInfo != null) {
      paramJceOutputStream.write(this.shareInfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.MsgInteractData
 * JD-Core Version:    0.7.0.1
 */