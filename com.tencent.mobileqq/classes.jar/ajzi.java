import android.os.SystemClock;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.qphone.base.util.QLog;

public class ajzi
  implements View.OnLongClickListener
{
  public ajzi(MainFragment paramMainFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a() == MainFragment.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "Mainfragment onLongClick");
      }
      long l = SystemClock.uptimeMillis() - MainFragment.a(this.a);
      if ((MainFragment.a(this.a) > 0L) && (l < 1000L))
      {
        QLog.d("MainFragment", 1, "Mainfragment onLongClick interval = [" + l + "], not start multi aio");
        return false;
      }
      paramView = (Conversation)this.a.a(Conversation.class);
      if (paramView != null)
      {
        paramView = paramView.a().a();
        if (paramView != null) {
          axeh.a(this.a.getActivity(), paramView.getRecentUserUin(), paramView.getRecentUserType(), paramView.getTitleName(), "conversation_tab_bottom");
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzi
 * JD-Core Version:    0.7.0.1
 */