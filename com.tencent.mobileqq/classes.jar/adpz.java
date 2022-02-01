import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adpz
  implements View.OnClickListener
{
  public adpz(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    awwm.a().a = 0;
    this.a.a.a(this.a.a(), this.a.a().getIntent());
    this.a.b(1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpz
 * JD-Core Version:    0.7.0.1
 */