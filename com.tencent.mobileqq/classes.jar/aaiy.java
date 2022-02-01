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

class aaiy
  implements aakp
{
  aaiy(aaiu paramaaiu, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d(aaiu.a(), 1, "onCommentSend()");
    if (aaiu.a(this.jdField_a_of_type_Aaiu) == null)
    {
      QLog.d(aaiu.a(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = aaiu.a(this.jdField_a_of_type_Aaiu).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(aaiu.m(this.jdField_a_of_type_Aaiu), aaiu.n(this.jdField_a_of_type_Aaiu).getString(2131692047), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(aaiu.o(this.jdField_a_of_type_Aaiu)))
    {
      QQToast.a(aaiu.p(this.jdField_a_of_type_Aaiu), 1, aaiu.q(this.jdField_a_of_type_Aaiu).getString(2131693974), 0).a();
      return;
    }
    Object localObject = aaiu.a(this.jdField_a_of_type_Aaiu);
    if (localObject == null)
    {
      QLog.e(aaiu.a(), 1, "feed is null");
      return;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (aaiu.a(this.jdField_a_of_type_Aaiu) == null) {
        aaiu.a(this.jdField_a_of_type_Aaiu, aaiu.a(this.jdField_a_of_type_Aaiu, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      aaiu.a(this.jdField_a_of_type_Aaiu).content.set(str);
      CertifiedAccountMeta.StReply localStReply = new CertifiedAccountMeta.StReply();
      localStReply.id.set("fakeId_" + System.currentTimeMillis());
      localStReply.content.set(str);
      localStReply.createTime.set((int)(System.currentTimeMillis() / 1000L));
      localStReply.postUser.set(aaiu.a(this.jdField_a_of_type_Aaiu));
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null) {}
      for (localStReply.targetUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser.get()); localObject == null; localStReply.targetUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser)
      {
        QLog.e(aaiu.a(), 1, "feed is null");
        return;
      }
      if (aaiu.a(this.jdField_a_of_type_Aaiu).targetUser != null) {
        aaiu.a(this.jdField_a_of_type_Aaiu).put(Long.valueOf(aaiu.a(this.jdField_a_of_type_Aaiu)), aaiu.a(this.jdField_a_of_type_Aaiu).targetUser);
      }
      aaiu.b(this.jdField_a_of_type_Aaiu, aaiu.a(this.jdField_a_of_type_Aaiu).a(aaiu.a(this.jdField_a_of_type_Aaiu), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, localStReply));
      aaiu.c(this.jdField_a_of_type_Aaiu, true);
      aaiu.d(this.jdField_a_of_type_Aaiu, true);
      if (aaiu.b(this.jdField_a_of_type_Aaiu) != null) {
        aaiu.b(this.jdField_a_of_type_Aaiu).put(Long.valueOf(aaiu.a(this.jdField_a_of_type_Aaiu)), aaiu.a(this.jdField_a_of_type_Aaiu));
      }
      aaiu.a(this.jdField_a_of_type_Aaiu, null);
      if (aaiu.a(this.jdField_a_of_type_Aaiu) != null)
      {
        aaiu.a(this.jdField_a_of_type_Aaiu).a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), localStReply);
        aaiu.a(this.jdField_a_of_type_Aaiu).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      aaiu.a(this.jdField_a_of_type_Aaiu).a("");
      aaiu.a(this.jdField_a_of_type_Aaiu).b(null);
      aaiu.a(this.jdField_a_of_type_Aaiu).dismiss();
      return;
      if (aaiu.a(this.jdField_a_of_type_Aaiu) == null) {
        aaiu.a(this.jdField_a_of_type_Aaiu, aaiu.b(this.jdField_a_of_type_Aaiu, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      aaiu.a(this.jdField_a_of_type_Aaiu).content.set(str);
      localObject = new CertifiedAccountMeta.StComment();
      ((CertifiedAccountMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((CertifiedAccountMeta.StComment)localObject).content.set(str);
      ((CertifiedAccountMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject).postUser.set(aaiu.a(this.jdField_a_of_type_Aaiu));
      aaiu.a(this.jdField_a_of_type_Aaiu).a(aaiu.a(this.jdField_a_of_type_Aaiu), (CertifiedAccountMeta.StComment)localObject);
      aaiu.c(this.jdField_a_of_type_Aaiu, true);
      aaiu.d(this.jdField_a_of_type_Aaiu, true);
      aaiu.a(this.jdField_a_of_type_Aaiu, null);
      if (aaiu.a(this.jdField_a_of_type_Aaiu) != null)
      {
        aaiu.a(this.jdField_a_of_type_Aaiu).a(0, (CertifiedAccountMeta.StComment)localObject);
        aaiu.a(this.jdField_a_of_type_Aaiu).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Aaiu.a != null)
      {
        QLog.d(aaiu.a(), 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_Aaiu.a.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaiy
 * JD-Core Version:    0.7.0.1
 */