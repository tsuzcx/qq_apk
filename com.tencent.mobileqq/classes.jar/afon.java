import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;

public class afon
  implements View.OnClickListener
{
  public afon(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(baoz.e, ajjy.a(2131635804));
    paramView.putString(baoz.f, "CJCLUBT");
    paramView.putString(baoz.d, "1450000516");
    paramView.putInt(baoz.b, 3);
    paramView.putString(baoz.i, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    paramView.putString(baoz.g, "svip");
    paramView.putString(baoz.a, this.a.b.getCurrentAccountUin());
    baoz.a(this.a.b, this.a.getActivity(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afon
 * JD-Core Version:    0.7.0.1
 */