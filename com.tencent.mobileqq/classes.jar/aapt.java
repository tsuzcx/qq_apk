import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aapt
  implements View.OnClickListener
{
  aapt(aaps paramaaps, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    aaej.a(this.jdField_a_of_type_Aaps.a.getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, 0, aame.a(aaps.a(this.jdField_a_of_type_Aaps), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.width.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.height.get()));
    abbe.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_follow", "blank_content_clk", 0, 0, new String[] { "", aaps.a(this.jdField_a_of_type_Aaps) + "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapt
 * JD-Core Version:    0.7.0.1
 */