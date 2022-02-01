import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahuy
  implements View.OnClickListener
{
  ahuy(ahux paramahux) {}
  
  public void onClick(View paramView)
  {
    ahvc localahvc = (ahvc)agej.a(paramView);
    if (paramView == localahvc.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localahvc);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == localahvc.jdField_a_of_type_AndroidWidgetRelativeLayout) {
        this.a.a(localahvc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuy
 * JD-Core Version:    0.7.0.1
 */