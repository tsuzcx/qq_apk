import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class aepf
  implements View.OnTouchListener
{
  aepf(aepe paramaepe) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramView = this.a.jdField_a_of_type_Bcjg.a();
    if (i == 0) {
      if ((paramView != null) && (paramView.d()))
      {
        this.a.l.setText(ajya.a(2131705100));
        this.a.l.setPressed(true);
        this.a.jdField_a_of_type_Atch.b();
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
      this.a.l.setText(ajya.a(2131705096));
      this.a.l.setPressed(false);
      this.a.jdField_a_of_type_Atch.c();
    } while (paramView == null);
    paramView.a(false);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aepf
 * JD-Core Version:    0.7.0.1
 */