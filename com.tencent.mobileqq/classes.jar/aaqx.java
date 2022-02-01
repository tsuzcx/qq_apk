import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

public class aaqx
  extends aoeg
{
  public aaqx(FollowTextView paramFollowTextView) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    FollowTextView.a(this.a, true);
    if (paramBoolean)
    {
      if (!FollowTextView.a(this.a)) {
        FollowTextView.a(this.a, true, FollowTextView.a(this.a));
      }
      this.a.a(1);
      if (FollowTextView.a(this.a) != null)
      {
        if (FollowTextView.a(this.a) != null) {
          FollowTextView.a(this.a).a(true, FollowTextView.a(this.a));
        }
        aaak.a().a(new FollowUpdateEvent(1, FollowTextView.a(this.a).poster.id.get()));
      }
      return;
    }
    QQToast.a(this.a.getContext(), 2131690620, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqx
 * JD-Core Version:    0.7.0.1
 */