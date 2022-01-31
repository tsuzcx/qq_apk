import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;

public class aicy
  implements View.OnClickListener
{
  public aicy(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(bdun.e, alud.a(2131701984));
    paramView.putString(bdun.f, "CJCLUBT");
    paramView.putString(bdun.d, "1450000516");
    paramView.putInt(bdun.b, 3);
    paramView.putString(bdun.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    paramView.putString(bdun.g, "svip");
    paramView.putString(bdun.a, this.a.b.getCurrentAccountUin());
    bdun.a(this.a.b, this.a.getActivity(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicy
 * JD-Core Version:    0.7.0.1
 */