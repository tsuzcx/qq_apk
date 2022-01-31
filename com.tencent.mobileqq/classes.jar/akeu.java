import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.widget.ConfigClearableEditText.OnTextClearedListener;

public class akeu
  implements View.OnTouchListener
{
  public akeu(ConfigClearableEditText paramConfigClearableEditText) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = 1;
    if (this.a.getCompoundDrawables()[2] == null) {}
    label107:
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        if (paramMotionEvent.getX() > this.a.getWidth() - this.a.getPaddingRight() - this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth()) {}
        for (;;)
        {
          if (i == 0) {
            break label107;
          }
          this.a.setText("");
          this.a.setClearButtonVisible(false);
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$OnTextClearedListener == null) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$OnTextClearedListener.a();
          return false;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akeu
 * JD-Core Version:    0.7.0.1
 */