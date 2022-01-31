import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ackq
  implements View.OnClickListener
{
  public ackq(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(bbqw.e, ajyc.a(2131715606));
    paramView.putString(bbqw.f, "CJCLUBT");
    paramView.putString(bbqw.d, "1450000516");
    paramView.putInt(bbqw.b, 3);
    paramView.putString(bbqw.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    paramView.putString(bbqw.g, "svip");
    paramView.putString(bbqw.a, this.a.app.getCurrentAccountUin());
    bbqw.a(this.a.app, this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ackq
 * JD-Core Version:    0.7.0.1
 */