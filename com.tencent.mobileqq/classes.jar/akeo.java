import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;

public class akeo
  implements View.OnTouchListener
{
  public akeo(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845858);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130845858));
    if (this.a.b)
    {
      this.a.jdField_a_of_type_AndroidViewWindowManager.removeView(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
      this.a.b = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akeo
 * JD-Core Version:    0.7.0.1
 */