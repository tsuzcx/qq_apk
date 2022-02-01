import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeop
  implements View.OnClickListener
{
  public aeop(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(bgge.e, amtj.a(2131714623));
    localBundle.putString(bgge.f, "CJCLUBT");
    localBundle.putString(bgge.d, "1450000516");
    localBundle.putInt(bgge.b, 3);
    localBundle.putString(bgge.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    localBundle.putString(bgge.g, "svip");
    localBundle.putString(bgge.a, this.a.app.getCurrentAccountUin());
    bgge.a(this.a.app, this.a, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeop
 * JD-Core Version:    0.7.0.1
 */