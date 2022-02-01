import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aajg
  implements View.OnClickListener
{
  aajg(aaje paramaaje, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    if (aaiu.a(this.jdField_a_of_type_Aaje.a) != null)
    {
      aaiu.a(this.jdField_a_of_type_Aaje.a, aaiu.a(this.jdField_a_of_type_Aaje.a).a(aaiu.a(this.jdField_a_of_type_Aaje.a), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      aaiu.c(this.jdField_a_of_type_Aaje.a, true);
    }
    aaiu.a(this.jdField_a_of_type_Aaje.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajg
 * JD-Core Version:    0.7.0.1
 */