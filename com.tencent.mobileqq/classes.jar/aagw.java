import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;

class aagw
  implements aanq
{
  aagw(aagu paramaagu, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      abbe.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_follow", "clk_unfollow", 0, 0, new String[0]);
      paramString = this.jdField_a_of_type_Aagu.getDataList().iterator();
      while (paramString.hasNext()) {
        if (TextUtils.equals(((CertifiedAccountMeta.StFeed)paramString.next()).poster.id.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get())) {
          paramString.remove();
        }
      }
      this.jdField_a_of_type_Aagu.notifyDataSetChanged();
      QQToast.a(aagu.a(this.jdField_a_of_type_Aagu), 2, anzj.a(2131690630), 0).a();
      if (this.jdField_a_of_type_Aagu.getDataList().size() < 5) {
        this.jdField_a_of_type_Aagu.onRefreshData();
      }
    }
    if (paramBoolean2) {
      abbe.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_follow", "clk_cancel", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagw
 * JD-Core Version:    0.7.0.1
 */