import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.LocalCrashCollector;
import com.tencent.widget.XEditTextEx;

public class aact
  implements View.OnLongClickListener
{
  public aact(BaseChatPie paramBaseChatPie) {}
  
  public boolean onLongClick(View paramView)
  {
    if ("//findcrash".equals(this.a.a.getText().toString())) {
      ThreadManager.post(new LocalCrashCollector(this.a), 8, null, true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aact
 * JD-Core Version:    0.7.0.1
 */