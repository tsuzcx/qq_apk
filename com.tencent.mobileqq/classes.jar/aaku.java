import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class aaku
  implements aqrn
{
  public aaku(SubscribeBaseFragment paramSubscribeBaseFragment) {}
  
  public ColorNote getColorNote()
  {
    if ((this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) || (this.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null))
    {
      QLog.e("SubscribeBaseFragment", 1, "initColorNote, shareInfoBean is null");
      return null;
    }
    byte[] arrayOfByte = aanc.a(new SubscribeColorNoteReserveBean(this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray(), this.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType));
    aagc localaagc = new aagc();
    localaagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    localaagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
    String str1 = "";
    String str3 = localaagc.c();
    String str2 = localaagc.d();
    String str4 = localaagc.e();
    switch (localaagc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
    {
    }
    while (TextUtils.isEmpty(str1))
    {
      return null;
      str2 = localaagc.f();
      str1 = "" + localaagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get();
      continue;
      str1 = "" + localaagc.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
    }
    return new aqrv().a(16908291).a(str1).b(str3).c(str2).d(str4).a(arrayOfByte).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaku
 * JD-Core Version:    0.7.0.1
 */