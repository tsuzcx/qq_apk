import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.qphone.base.util.QLog;

public class adio
  implements View.OnLongClickListener
{
  public adio(MainFragment paramMainFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a() == MainFragment.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "Mainfragment onLongClick");
      }
      paramView = (Conversation)this.a.a(Conversation.class);
      if (paramView != null)
      {
        paramView = paramView.a().a();
        if (paramView != null) {
          aulb.a(this.a.getActivity(), paramView.a(), paramView.a(), paramView.b(), "conversation_tab_bottom");
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adio
 * JD-Core Version:    0.7.0.1
 */