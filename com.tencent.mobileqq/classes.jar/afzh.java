import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder;

public class afzh
  implements View.OnClickListener
{
  public afzh(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    afzl localafzl = (afzl)aekt.a(paramView);
    if (paramView == localafzl.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localafzl);
    }
    while (paramView != localafzl.jdField_a_of_type_AndroidWidgetRelativeLayout) {
      return;
    }
    this.a.a(localafzl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzh
 * JD-Core Version:    0.7.0.1
 */