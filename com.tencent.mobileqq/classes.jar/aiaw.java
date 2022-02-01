import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class aiaw
  implements View.OnTouchListener
{
  aiaw(aiav paramaiav) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramView = this.a.jdField_a_of_type_Bilj.a();
    if (i == 0) {
      if ((paramView != null) && (paramView.d()))
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131704567));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setPressed(true);
        this.a.jdField_a_of_type_Axrb.b();
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
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131704563));
      this.a.jdField_a_of_type_AndroidWidgetTextView.setPressed(false);
      this.a.jdField_a_of_type_Axrb.c();
    } while (paramView == null);
    paramView.a(false);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiaw
 * JD-Core Version:    0.7.0.1
 */