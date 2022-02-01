import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aamb
  implements View.OnClickListener
{
  public aamb(RelativePersonalDetailHeadItemView paramRelativePersonalDetailHeadItemView, CertifiedAccountMeta.StYouZanShop paramStYouZanShop) {}
  
  public void onClick(View paramView)
  {
    aaae.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StYouZanShop.schema.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamb
 * JD-Core Version:    0.7.0.1
 */