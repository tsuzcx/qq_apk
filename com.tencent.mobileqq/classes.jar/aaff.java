import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaff
  implements View.OnClickListener
{
  aaff(aafd paramaafd, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    if (aaet.a(this.jdField_a_of_type_Aafd.a) != null)
    {
      aaet.a(this.jdField_a_of_type_Aafd.a, aaet.a(this.jdField_a_of_type_Aafd.a).a(aaet.a(this.jdField_a_of_type_Aafd.a), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      aaet.c(this.jdField_a_of_type_Aafd.a, true);
    }
    aaet.a(this.jdField_a_of_type_Aafd.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaff
 * JD-Core Version:    0.7.0.1
 */