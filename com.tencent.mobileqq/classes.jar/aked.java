import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class aked
  implements View.OnTouchListener
{
  aked(akdz paramakdz, ImageView paramImageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 0))
    {
      if (paramMotionEvent.getAction() != 1) {
        break label45;
      }
      i = 255;
      if (Build.VERSION.SDK_INT < 16) {
        break label51;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageAlpha(i);
    }
    for (;;)
    {
      return false;
      label45:
      i = 127;
      break;
      label51:
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aked
 * JD-Core Version:    0.7.0.1
 */