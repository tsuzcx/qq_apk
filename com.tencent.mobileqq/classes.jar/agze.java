import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;

class agze
  implements View.OnClickListener
{
  agze(agzd paramagzd) {}
  
  public void onClick(View paramView)
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      paramView = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (paramView != null)
      {
        paramView = paramView.a();
        if (paramView != null) {
          paramView.b(agzd.a(this.a));
        }
      }
      anpd.a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agze
 * JD-Core Version:    0.7.0.1
 */