import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahlo
  implements View.OnClickListener
{
  ahlo(ahln paramahln) {}
  
  public void onClick(View paramView)
  {
    ahls localahls = (ahls)afur.a(paramView);
    if (paramView == localahls.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localahls);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == localahls.jdField_a_of_type_AndroidWidgetRelativeLayout) {
        this.a.a(localahls);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlo
 * JD-Core Version:    0.7.0.1
 */