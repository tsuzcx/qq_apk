import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aafi
  implements View.OnClickListener
{
  aafi(aafd paramaafd, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onClick(View paramView)
  {
    aaet.b(this.jdField_a_of_type_Aafd.a, aaet.a(this.jdField_a_of_type_Aafd.a).a(aaet.a(this.jdField_a_of_type_Aafd.a), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
    aaet.c(this.jdField_a_of_type_Aafd.a, true);
    aaet.a(this.jdField_a_of_type_Aafd.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafi
 * JD-Core Version:    0.7.0.1
 */