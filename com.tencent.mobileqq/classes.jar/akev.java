import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akev
  implements View.OnClickListener
{
  public akev(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(bhzu.e, anzj.a(2131700511));
    localBundle.putString(bhzu.f, "CJCLUBT");
    localBundle.putString(bhzu.d, "1450000516");
    localBundle.putInt(bhzu.b, 3);
    localBundle.putString(bhzu.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    localBundle.putString(bhzu.g, "svip");
    localBundle.putString(bhzu.a, this.a.b.getCurrentAccountUin());
    bhzu.a(this.a.b, this.a.getActivity(), localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akev
 * JD-Core Version:    0.7.0.1
 */