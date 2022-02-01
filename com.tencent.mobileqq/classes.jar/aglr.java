import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aglr
  implements View.OnClickListener
{
  public aglr(QQStoryItemBuilder paramQQStoryItemBuilder) {}
  
  public void onClick(View paramView)
  {
    aglx localaglx = (aglx)AIOUtils.getHolder(paramView);
    if (paramView == localaglx.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localaglx);
    }
    for (;;)
    {
      bcef.b(this.a.a, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "5", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == localaglx.jdField_a_of_type_AndroidWidgetRelativeLayout) {
        this.a.a(localaglx);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglr
 * JD-Core Version:    0.7.0.1
 */