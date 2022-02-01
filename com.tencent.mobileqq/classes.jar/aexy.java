import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aexy
  implements View.OnClickListener
{
  public aexy(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.l) {
      this.a.w();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ("group_activity".equals(this.a.o))
      {
        this.a.k();
      }
      else
      {
        this.a.setResult(-1, this.a.a());
        this.a.finish();
        this.a.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexy
 * JD-Core Version:    0.7.0.1
 */