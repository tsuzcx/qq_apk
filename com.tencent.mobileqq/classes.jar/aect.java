import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder;

public class aect
  implements View.OnClickListener
{
  public aect(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    aecx localaecx = (aecx)actj.a(paramView);
    if (paramView == localaecx.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localaecx);
    }
    while (paramView != localaecx.jdField_a_of_type_AndroidWidgetRelativeLayout) {
      return;
    }
    this.a.a(localaecx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aect
 * JD-Core Version:    0.7.0.1
 */