import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aheh
  implements View.OnClickListener
{
  public aheh(QQStoryItemBuilder paramQQStoryItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ahen localahen = (ahen)AIOUtils.getHolder(paramView);
    if (paramView == localahen.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localahen);
    }
    for (;;)
    {
      bdla.b(this.a.a, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "5", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == localahen.jdField_a_of_type_AndroidWidgetRelativeLayout) {
        this.a.a(localahen);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aheh
 * JD-Core Version:    0.7.0.1
 */