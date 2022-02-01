import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agrm
  implements View.OnClickListener
{
  agrm(agrl paramagrl) {}
  
  public void onClick(View paramView)
  {
    agrq localagrq = (agrq)AIOUtils.getHolder(paramView);
    if (paramView == localagrq.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localagrq);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == localagrq.jdField_a_of_type_AndroidWidgetRelativeLayout) {
        this.a.a(localagrq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrm
 * JD-Core Version:    0.7.0.1
 */