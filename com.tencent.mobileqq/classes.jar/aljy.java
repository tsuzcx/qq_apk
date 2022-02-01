import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aljy
  implements View.OnClickListener
{
  aljy(aljw paramaljw, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (BaseActivity.sTopActivity != null) {
      axgj.a().a(BaseActivity.sTopActivity, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      axgj.m();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "sTopActivity is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljy
 * JD-Core Version:    0.7.0.1
 */