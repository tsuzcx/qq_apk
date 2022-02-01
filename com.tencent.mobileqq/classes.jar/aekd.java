import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aekd
  implements View.OnClickListener
{
  public aekd(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isFinishing()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.c = false;
      if (this.a.a != null)
      {
        this.a.a.a(4);
        this.a.d();
        this.a.c();
      }
      if (avnu.a().c()) {
        avnu.a().f(this.a.app);
      }
      TroopAssistantActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekd
 * JD-Core Version:    0.7.0.1
 */