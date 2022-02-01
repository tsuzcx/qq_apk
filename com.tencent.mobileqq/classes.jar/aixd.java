import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.XListView;

public class aixd
  extends aoav
{
  public aixd(PublicView paramPublicView) {}
  
  public void onUpdateRecommendList(boolean paramBoolean)
  {
    if (true == paramBoolean)
    {
      PublicView.a(this.a).a(0);
      PublicView.a(this.a).sendEmptyMessage(1);
      PublicView.a(this.a).sendEmptyMessage(3);
      return;
    }
    PublicView.a(this.a).springBackOverScrollHeaderView();
    PublicView.a(this.a, 1, 2131718993);
    PublicView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixd
 * JD-Core Version:    0.7.0.1
 */