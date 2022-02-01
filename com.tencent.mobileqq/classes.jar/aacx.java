import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

public class aacx
  extends aoav
{
  public aacx(FollowTextView paramFollowTextView) {}
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onUnfollowPublicAccount(paramBoolean, paramString);
    FollowTextView.a(this.a, true);
    if (paramBoolean)
    {
      if (!FollowTextView.a(this.a)) {
        FollowTextView.a(this.a, false, FollowTextView.a(this.a));
      }
      this.a.a(0);
      if (FollowTextView.a(this.a) != null)
      {
        if (FollowTextView.a(this.a) != null) {
          FollowTextView.a(this.a).a(false, FollowTextView.a(this.a));
        }
        SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(0, FollowTextView.a(this.a).poster.id.get()));
      }
      return;
    }
    QQToast.a(this.a.getContext(), 2131690746, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacx
 * JD-Core Version:    0.7.0.1
 */