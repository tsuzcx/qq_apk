import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aacx
  implements View.OnClickListener
{
  aacx(aacw paramaacw, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if (((this.jdField_a_of_type_Aacw.itemView instanceof RelativeFeedItemView)) && (aacp.a(this.jdField_a_of_type_Aacw.a) != null)) {
      aacp.a(this.jdField_a_of_type_Aacw.a).a(this.jdField_a_of_type_Aacw.itemView, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacx
 * JD-Core Version:    0.7.0.1
 */