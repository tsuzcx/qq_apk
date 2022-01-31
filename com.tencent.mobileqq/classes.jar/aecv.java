import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder;

public class aecv
  implements View.OnClickListener
{
  public aecv(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    aecz localaecz = (aecz)actn.a(paramView);
    if (paramView == localaecz.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localaecz);
    }
    while (paramView != localaecz.jdField_a_of_type_AndroidWidgetRelativeLayout) {
      return;
    }
    this.a.a(localaecz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecv
 * JD-Core Version:    0.7.0.1
 */