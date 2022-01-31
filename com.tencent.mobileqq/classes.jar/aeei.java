import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class aeei
  implements View.OnTouchListener
{
  aeei(aeeh paramaeeh) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramView = this.a.jdField_a_of_type_Bbfs.a();
    if (i == 0) {
      if ((paramView != null) && (paramView.d()))
      {
        this.a.l.setText(ajjy.a(2131639304));
        this.a.l.setPressed(true);
        this.a.jdField_a_of_type_Asgb.b();
        paramView.a(true);
      }
    }
    do
    {
      return true;
      this.a.t(false);
      return true;
      if ((i != 3) && (i != 1)) {
        break;
      }
      this.a.l.setText(ajjy.a(2131639300));
      this.a.l.setPressed(false);
      this.a.jdField_a_of_type_Asgb.c();
    } while (paramView == null);
    paramView.a(false);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeei
 * JD-Core Version:    0.7.0.1
 */