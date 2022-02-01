import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahpe
  implements View.OnClickListener
{
  public ahpe(QQStoryItemBuilder paramQQStoryItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ahpk localahpk = (ahpk)agej.a(paramView);
    if (paramView == localahpk.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localahpk);
    }
    for (;;)
    {
      bdll.b(this.a.a, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "5", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout) {
        this.a.a(localahpk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpe
 * JD-Core Version:    0.7.0.1
 */