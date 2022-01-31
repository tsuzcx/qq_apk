import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;

public class ahgu
  implements View.OnTouchListener
{
  public ahgu(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramMotionEvent.getX();
    float f = paramMotionEvent.getY();
    if (i == 0) {
      this.a.jdField_b_of_type_AndroidWidgetButton.setText(null);
    }
    do
    {
      return false;
      if (i == 2)
      {
        if (f < this.a.jdField_b_of_type_Int * -1)
        {
          this.a.a(false, false);
          return true;
        }
        this.a.a(true, false);
        return true;
      }
      if (i == 3)
      {
        this.a.a(false, true);
        return false;
      }
    } while (i != 1);
    if (f < this.a.jdField_b_of_type_Int * -1)
    {
      this.a.l = false;
      this.a.a(false, true);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidWidgetButton.setText(2131626997);
      return false;
      this.a.l = true;
      this.a.a(true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgu
 * JD-Core Version:    0.7.0.1
 */