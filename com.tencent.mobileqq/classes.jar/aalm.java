import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.text.TextUtils;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;

public class aalm
  implements aaav<CertifiedAccountRead.StGetMainPageRsp>
{
  public aalm(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    SubscribePersonalDetailFragment.a(this.a, paramBoolean);
    if (paramBoolean)
    {
      if (paramStGetMainPageRsp != null)
      {
        yuk.c("SubscribePersonalDetail", "sendRequest GetMainPage success");
        SubscribePersonalDetailFragment.a(this.a, paramStGetMainPageRsp);
        if ((this.a.a != null) && (SubscribePersonalDetailFragment.a(this.a).user != null)) {
          this.a.a.poster.set(SubscribePersonalDetailFragment.a(this.a).user.get());
        }
        aaee.a(paramStGetMainPageRsp);
        SubscribePersonalDetailFragment.a(this.a, paramString);
        SubscribePersonalDetailFragment.a(this.a);
        SubscribePersonalDetailFragment.a(this.a).notifyLoadingComplete(true);
        if (paramStGetMainPageRsp.user.type.get() == 0) {
          abbe.b(paramStGetMainPageRsp.user.id.get(), "auth_person", "user_exp", 0, 0, new String[0]);
        }
      }
      abbe.a("subscribe_personal_detail_page_request", abbe.a(0L, System.currentTimeMillis() - SubscribePersonalDetailFragment.a(this.a)));
      return;
    }
    yuk.c("SubscribePersonalDetail", "sendRequest GetMainPage error");
    paramStGetMainPageRsp = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      paramStGetMainPageRsp = anzj.a(2131713448);
    }
    if (this.a.getActivity() != null) {
      QQToast.a(this.a.getActivity(), paramStGetMainPageRsp, 0).a();
    }
    abbe.a("subscribe_personal_detail_page_request", abbe.a(paramLong, System.currentTimeMillis() - SubscribePersonalDetailFragment.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalm
 * JD-Core Version:    0.7.0.1
 */