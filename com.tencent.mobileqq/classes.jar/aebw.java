import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class aebw
  implements View.OnClickListener
{
  public aebw(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(bdqe.e, alpo.a(2131715989));
    paramView.putString(bdqe.f, "CJCLUBT");
    paramView.putString(bdqe.d, "1450000516");
    paramView.putInt(bdqe.b, 3);
    paramView.putString(bdqe.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    paramView.putString(bdqe.g, "svip");
    paramView.putString(bdqe.a, this.a.app.getCurrentAccountUin());
    bdqe.a(this.a.app, this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebw
 * JD-Core Version:    0.7.0.1
 */