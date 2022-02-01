import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahkk
  implements View.OnClickListener
{
  ahkk(ahkj paramahkj) {}
  
  public void onClick(View paramView)
  {
    ahko localahko = (ahko)AIOUtils.getHolder(paramView);
    if (paramView == localahko.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localahko);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == localahko.jdField_a_of_type_AndroidWidgetRelativeLayout) {
        this.a.a(localahko);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkk
 * JD-Core Version:    0.7.0.1
 */