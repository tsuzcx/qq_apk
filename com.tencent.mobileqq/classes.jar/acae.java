import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class acae
  implements View.OnClickListener
{
  public acae(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(baoz.e, ajjy.a(2131649815));
    paramView.putString(baoz.f, "CJCLUBT");
    paramView.putString(baoz.d, "1450000516");
    paramView.putInt(baoz.b, 3);
    paramView.putString(baoz.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    paramView.putString(baoz.g, "svip");
    paramView.putString(baoz.a, this.a.app.getCurrentAccountUin());
    baoz.a(this.a.app, this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acae
 * JD-Core Version:    0.7.0.1
 */