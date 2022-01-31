import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ackm
  implements View.OnClickListener
{
  public ackm(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(bbrk.e, ajya.a(2131715617));
    paramView.putString(bbrk.f, "CJCLUBT");
    paramView.putString(bbrk.d, "1450000516");
    paramView.putInt(bbrk.b, 3);
    paramView.putString(bbrk.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    paramView.putString(bbrk.g, "svip");
    paramView.putString(bbrk.a, this.a.app.getCurrentAccountUin());
    bbrk.a(this.a.app, this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ackm
 * JD-Core Version:    0.7.0.1
 */