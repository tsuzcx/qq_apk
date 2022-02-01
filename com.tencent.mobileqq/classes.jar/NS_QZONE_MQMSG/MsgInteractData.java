package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MsgInteractData
  extends JceStruct
{
  static CommentInfo cache_commentInfo;
  static LikInfo cache_likInfo = new LikInfo();
  static PushInfo cache_pushInfo = new PushInfo();
  static ShareInfo cache_shareInfo;
  static ArrayList<ButtonInfo> cache_vecButtonInfo;
  static ViewInfo cache_viewInfo = new ViewInfo();
  public CommentInfo commentInfo = null;
  public LikInfo likInfo = null;
  public PushInfo pushInfo = null;
  public ShareInfo shareInfo = null;
  public int type = 0;
  public ArrayList<ButtonInfo> vecButtonInfo = null;
  public ViewInfo viewInfo = null;
  
  static
  {
    cache_commentInfo = new CommentInfo();
    cache_shareInfo = new ShareInfo();
    cache_vecButtonInfo = new ArrayList();
    ButtonInfo localButtonInfo = new ButtonInfo();
    cache_vecButtonInfo.add(localButtonInfo);
  }
  
  public MsgInteractData() {}
  
  public MsgInteractData(int paramInt, LikInfo paramLikInfo, CommentInfo paramCommentInfo, ShareInfo paramShareInfo, ArrayList<ButtonInfo> paramArrayList, PushInfo paramPushInfo, ViewInfo paramViewInfo)
  {
    this.type = paramInt;
    this.likInfo = paramLikInfo;
    this.commentInfo = paramCommentInfo;
    this.shareInfo = paramShareInfo;
    this.vecButtonInfo = paramArrayList;
    this.pushInfo = paramPushInfo;
    this.viewInfo = paramViewInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.likInfo = ((LikInfo)paramJceInputStream.read(cache_likInfo, 1, false));
    this.commentInfo = ((CommentInfo)paramJceInputStream.read(cache_commentInfo, 2, false));
    this.shareInfo = ((ShareInfo)paramJceInputStream.read(cache_shareInfo, 3, false));
    this.vecButtonInfo = ((ArrayList)paramJceInputStream.read(cache_vecButtonInfo, 4, false));
    this.pushInfo = ((PushInfo)paramJceInputStream.read(cache_pushInfo, 5, false));
    this.viewInfo = ((ViewInfo)paramJceInputStream.read(cache_viewInfo, 6, false));
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
    if (this.vecButtonInfo != null) {
      paramJceOutputStream.write(this.vecButtonInfo, 4);
    }
    if (this.pushInfo != null) {
      paramJceOutputStream.write(this.pushInfo, 5);
    }
    if (this.viewInfo != null) {
      paramJceOutputStream.write(this.viewInfo, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.MsgInteractData
 * JD-Core Version:    0.7.0.1
 */