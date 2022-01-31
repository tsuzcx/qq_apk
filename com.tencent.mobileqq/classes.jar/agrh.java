import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class agrh
  implements View.OnTouchListener
{
  agrh(agqq paramagqq) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = paramMotionEvent.getAction();
    paramView = this.a.jdField_a_of_type_Bemq.a();
    if (i == 0)
    {
      this.a.m.setText(alud.a(2131705530));
      this.a.m.setTextColor(this.a.r);
      this.a.jdField_a_of_type_Auxp.b();
      if (paramView != null) {
        paramView.a(true);
      }
      azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "wolf_talk", 0, 0, "", "", "", "");
      bool = true;
    }
    while ((i != 3) && (i != 1)) {
      return bool;
    }
    this.a.m.setText(alud.a(2131705469));
    this.a.m.setTextColor(this.a.q);
    this.a.jdField_a_of_type_Auxp.c();
    if (paramView != null) {
      paramView.a(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrh
 * JD-Core Version:    0.7.0.1
 */