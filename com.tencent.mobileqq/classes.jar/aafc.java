import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.mobileqq.widget.QQToast;

public class aafc
  implements aamw
{
  public aafc(RecommendBannerFeedItemView paramRecommendBannerFeedItemView) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aaak.a().a(new RecommendFeedbackEvent(RecommendBannerFeedItemView.a(this.a)));
      return;
    }
    QQToast.a(this.a.getContext(), 2131718483, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafc
 * JD-Core Version:    0.7.0.1
 */