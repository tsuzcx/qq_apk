import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;

public class ajqh
  implements View.OnTouchListener
{
  public ajqh(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845730);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130845730));
    if (this.a.b)
    {
      this.a.jdField_a_of_type_AndroidViewWindowManager.removeView(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
      this.a.b = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajqh
 * JD-Core Version:    0.7.0.1
 */