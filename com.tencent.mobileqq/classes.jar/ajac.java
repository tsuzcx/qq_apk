import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.bless.BlessActivity;

public class ajac
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ajac(BlessActivity paramBlessActivity, RelativeLayout paramRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    BlessActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
    BlessActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth());
    BlessActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajac
 * JD-Core Version:    0.7.0.1
 */