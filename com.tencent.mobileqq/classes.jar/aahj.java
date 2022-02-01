import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aahj
  implements View.OnClickListener
{
  public aahj(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, aagr paramaagr) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("postUin", this.jdField_a_of_type_Aagr.a.poster.id.get());
    if (this.jdField_a_of_type_Aagr.a.poster.youZhan.size() > 0) {
      if (((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_Aagr.a.poster.youZhan.get(0)).type.get() <= 1) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("has_shop", bool);
      blsb.a(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment.getActivity(), localIntent, 0);
      aaxb.b(this.jdField_a_of_type_Aagr.a.poster.id.get(), "auth_person", "blank_post", 0, 0, new String[0]);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahj
 * JD-Core Version:    0.7.0.1
 */