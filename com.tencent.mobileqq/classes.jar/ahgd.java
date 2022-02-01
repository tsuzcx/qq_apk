import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class ahgd
  implements View.OnTouchListener
{
  ahgd(ahgc paramahgc) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramView = this.a.jdField_a_of_type_Bhar.a();
    if (i == 0) {
      if ((paramView != null) && (paramView.d()))
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131704216));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setPressed(true);
        this.a.jdField_a_of_type_Awkz.b();
        paramView.a(true);
      }
    }
    do
    {
      return true;
      this.a.a(false);
      return true;
      if ((i != 3) && (i != 1)) {
        break;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131704212));
      this.a.jdField_a_of_type_AndroidWidgetTextView.setPressed(false);
      this.a.jdField_a_of_type_Awkz.c();
    } while (paramView == null);
    paramView.a(false);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgd
 * JD-Core Version:    0.7.0.1
 */