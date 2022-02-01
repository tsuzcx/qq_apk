import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afms
  implements View.OnClickListener
{
  public afms(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(bgzo.e, anni.a(2131714282));
    localBundle.putString(bgzo.f, "CJCLUBT");
    localBundle.putString(bgzo.d, "1450000516");
    localBundle.putInt(bgzo.b, 3);
    localBundle.putString(bgzo.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    localBundle.putString(bgzo.g, "svip");
    localBundle.putString(bgzo.a, this.a.app.getCurrentAccountUin());
    bgzo.a(this.a.app, this.a, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afms
 * JD-Core Version:    0.7.0.1
 */