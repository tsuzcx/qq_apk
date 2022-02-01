import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.mobileqq.widget.QQToast;

public class aalb
  implements aajd
{
  public aalb(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public void a(int paramInt)
  {
    SubscribeHybirdFragment.a(this.a).a(paramInt);
  }
  
  public void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean, long paramLong, String paramString)
  {
    if ((paramStGetFeedDetailRsp == null) || (paramStGetFeedDetailRsp.feed.get() == null))
    {
      QQToast.a(this.a.getHostActivity(), anzj.a(2131713443), 0).a();
      return;
    }
    SubscribeHybirdFragment.a(this.a, paramStGetFeedDetailRsp, paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalb
 * JD-Core Version:    0.7.0.1
 */