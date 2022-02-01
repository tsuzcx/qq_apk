import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaha
  implements View.OnClickListener
{
  aaha(aagz paramaagz, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if (((this.jdField_a_of_type_Aagz.itemView instanceof RelativeFeedItemView)) && (aagu.a(this.jdField_a_of_type_Aagz.a) != null)) {
      aagu.a(this.jdField_a_of_type_Aagz.a).a(this.jdField_a_of_type_Aagz.itemView, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaha
 * JD-Core Version:    0.7.0.1
 */