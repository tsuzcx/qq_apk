import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class ahgt
  implements View.OnTouchListener
{
  ahgt(ahgc paramahgc) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = paramMotionEvent.getAction();
    paramView = this.a.jdField_a_of_type_Bhar.a();
    if (i == 0)
    {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131704262));
      this.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.a.jdField_b_of_type_Int);
      this.a.jdField_a_of_type_Awkz.b();
      if (paramView != null) {
        paramView.a(true);
      }
      bcef.b(this.a.app, "dc00899", "Grp_wolf", "", "in_game", "wolf_talk", 0, 0, "", "", "", "");
      bool = true;
    }
    while ((i != 3) && (i != 1)) {
      return bool;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131704201));
    this.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.a.jdField_a_of_type_Int);
    this.a.jdField_a_of_type_Awkz.c();
    if (paramView != null) {
      paramView.a(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgt
 * JD-Core Version:    0.7.0.1
 */