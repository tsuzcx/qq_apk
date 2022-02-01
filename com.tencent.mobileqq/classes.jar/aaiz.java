import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class aaiz
  implements DialogInterface.OnShowListener
{
  aaiz(aaiu paramaaiu, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (aaiu.a(this.jdField_a_of_type_Aaiu) != null) {
      aaiu.a(this.jdField_a_of_type_Aaiu).a(paramDialogInterface);
    }
    paramDialogInterface = aane.a().a(aaiu.a(this.jdField_a_of_type_Aaiu), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply);
    aaiu.a(this.jdField_a_of_type_Aaiu).a(paramDialogInterface);
    aaak.a().a(new CommentListShowStateEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaiz
 * JD-Core Version:    0.7.0.1
 */