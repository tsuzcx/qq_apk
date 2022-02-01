import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ListView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class aaex
  implements aago
{
  aaex(aaet paramaaet, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d(aaet.a(), 1, "onCommentSend()");
    if (aaet.a(this.jdField_a_of_type_Aaet) == null)
    {
      QLog.d(aaet.a(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = aaet.a(this.jdField_a_of_type_Aaet).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(aaet.m(this.jdField_a_of_type_Aaet), aaet.n(this.jdField_a_of_type_Aaet).getString(2131692042), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(aaet.o(this.jdField_a_of_type_Aaet)))
    {
      QQToast.a(aaet.p(this.jdField_a_of_type_Aaet), 1, aaet.q(this.jdField_a_of_type_Aaet).getString(2131693957), 0).a();
      return;
    }
    Object localObject = aaet.a(this.jdField_a_of_type_Aaet);
    if (localObject == null)
    {
      QLog.e(aaet.a(), 1, "feed is null");
      return;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (aaet.a(this.jdField_a_of_type_Aaet) == null) {
        aaet.a(this.jdField_a_of_type_Aaet, aaet.a(this.jdField_a_of_type_Aaet, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      aaet.a(this.jdField_a_of_type_Aaet).content.set(str);
      CertifiedAccountMeta.StReply localStReply = new CertifiedAccountMeta.StReply();
      localStReply.id.set("fakeId_" + System.currentTimeMillis());
      localStReply.content.set(str);
      localStReply.createTime.set((int)(System.currentTimeMillis() / 1000L));
      localStReply.postUser.set(aaet.a(this.jdField_a_of_type_Aaet));
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null) {}
      for (localStReply.targetUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser.get()); localObject == null; localStReply.targetUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser)
      {
        QLog.e(aaet.a(), 1, "feed is null");
        return;
      }
      if (aaet.a(this.jdField_a_of_type_Aaet).targetUser != null) {
        aaet.a(this.jdField_a_of_type_Aaet).put(Long.valueOf(aaet.a(this.jdField_a_of_type_Aaet)), aaet.a(this.jdField_a_of_type_Aaet).targetUser);
      }
      aaet.b(this.jdField_a_of_type_Aaet, aaet.a(this.jdField_a_of_type_Aaet).a(aaet.a(this.jdField_a_of_type_Aaet), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, localStReply));
      aaet.c(this.jdField_a_of_type_Aaet, true);
      aaet.d(this.jdField_a_of_type_Aaet, true);
      if (aaet.b(this.jdField_a_of_type_Aaet) != null) {
        aaet.b(this.jdField_a_of_type_Aaet).put(Long.valueOf(aaet.a(this.jdField_a_of_type_Aaet)), aaet.a(this.jdField_a_of_type_Aaet));
      }
      aaet.a(this.jdField_a_of_type_Aaet, null);
      if (aaet.a(this.jdField_a_of_type_Aaet) != null)
      {
        aaet.a(this.jdField_a_of_type_Aaet).a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), localStReply);
        aaet.a(this.jdField_a_of_type_Aaet).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      aaet.a(this.jdField_a_of_type_Aaet).a("");
      aaet.a(this.jdField_a_of_type_Aaet).b(null);
      aaet.a(this.jdField_a_of_type_Aaet).dismiss();
      return;
      if (aaet.a(this.jdField_a_of_type_Aaet) == null) {
        aaet.a(this.jdField_a_of_type_Aaet, aaet.b(this.jdField_a_of_type_Aaet, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      aaet.a(this.jdField_a_of_type_Aaet).content.set(str);
      localObject = new CertifiedAccountMeta.StComment();
      ((CertifiedAccountMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((CertifiedAccountMeta.StComment)localObject).content.set(str);
      ((CertifiedAccountMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject).postUser.set(aaet.a(this.jdField_a_of_type_Aaet));
      aaet.a(this.jdField_a_of_type_Aaet).a(aaet.a(this.jdField_a_of_type_Aaet), (CertifiedAccountMeta.StComment)localObject);
      aaet.c(this.jdField_a_of_type_Aaet, true);
      aaet.d(this.jdField_a_of_type_Aaet, true);
      aaet.a(this.jdField_a_of_type_Aaet, null);
      if (aaet.a(this.jdField_a_of_type_Aaet) != null)
      {
        aaet.a(this.jdField_a_of_type_Aaet).a(0, (CertifiedAccountMeta.StComment)localObject);
        aaet.a(this.jdField_a_of_type_Aaet).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Aaet.a != null)
      {
        QLog.d(aaet.a(), 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_Aaet.a.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaex
 * JD-Core Version:    0.7.0.1
 */