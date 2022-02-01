import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.mobileqq.widget.QQToast;

public class aaha
  implements aafc
{
  public aaha(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public void a(int paramInt)
  {
    SubscribeHybirdFragment.a(this.a).a(paramInt);
  }
  
  public void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean, long paramLong, String paramString)
  {
    if ((paramStGetFeedDetailRsp == null) || (paramStGetFeedDetailRsp.feed.get() == null))
    {
      QQToast.a(this.a.getHostActivity(), anni.a(2131713334), 0).a();
      return;
    }
    SubscribeHybirdFragment.a(this.a, paramStGetFeedDetailRsp, paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaha
 * JD-Core Version:    0.7.0.1
 */