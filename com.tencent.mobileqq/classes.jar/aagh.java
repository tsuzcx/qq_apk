import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aagh
  implements View.OnClickListener
{
  aagh(aagg paramaagg, CertifiedAccountMeta.StUser paramStUser) {}
  
  public void onClick(View paramView)
  {
    abbe.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), "auth_" + aapa.a(this.jdField_a_of_type_Aagg.getExtraTypeInfo()), "clk_shop", 0, 0, new String[0]);
    aaej.a(((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.youZhan.get(0)).schema.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagh
 * JD-Core Version:    0.7.0.1
 */