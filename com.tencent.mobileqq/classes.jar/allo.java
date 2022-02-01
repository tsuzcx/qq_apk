import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class allo
  implements View.OnClickListener
{
  allo(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    if (aljw.a(this.a) != null) {}
    for (QQAppInterface localQQAppInterface = aljw.a(this.a).app;; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        aqcz.a().a(aljw.a(this.a), localQQAppInterface);
      }
      aqcz.a().a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allo
 * JD-Core Version:    0.7.0.1
 */