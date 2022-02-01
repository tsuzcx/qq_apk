import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class aiaz
  implements View.OnTouchListener
{
  aiaz(aiay paramaiay) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramView = this.a.jdField_a_of_type_Bhtu.a();
    if (i == 0) {
      if ((paramView != null) && (paramView.d()))
      {
        this.a.l.setText(anni.a(2131703880));
        this.a.l.setPressed(true);
        this.a.jdField_a_of_type_Axey.b();
        paramView.a(true);
      }
    }
    do
    {
      return true;
      this.a.v(false);
      return true;
      if ((i != 3) && (i != 1)) {
        break;
      }
      this.a.l.setText(anni.a(2131703876));
      this.a.l.setPressed(false);
      this.a.jdField_a_of_type_Axey.c();
    } while (paramView == null);
    paramView.a(false);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiaz
 * JD-Core Version:    0.7.0.1
 */