import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahfs
  implements View.OnClickListener
{
  public ahfs(QQStoryItemBuilder paramQQStoryItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ahfy localahfy = (ahfy)afur.a(paramView);
    if (paramView == localahfy.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localahfy);
    }
    for (;;)
    {
      bcst.b(this.a.a, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "5", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == localahfy.jdField_a_of_type_AndroidWidgetRelativeLayout) {
        this.a.a(localahfy);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfs
 * JD-Core Version:    0.7.0.1
 */