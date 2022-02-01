import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class aaey
  implements DialogInterface.OnShowListener
{
  aaey(aaet paramaaet, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (aaet.a(this.jdField_a_of_type_Aaet) != null) {
      aaet.a(this.jdField_a_of_type_Aaet).a(paramDialogInterface);
    }
    paramDialogInterface = aajd.a().a(aaet.a(this.jdField_a_of_type_Aaet), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply);
    aaet.a(this.jdField_a_of_type_Aaet).a(paramDialogInterface);
    zwp.a().a(new CommentListShowStateEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaey
 * JD-Core Version:    0.7.0.1
 */