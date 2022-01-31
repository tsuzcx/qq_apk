import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class aepx
  implements View.OnTouchListener
{
  aepx(aepg paramaepg) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = paramMotionEvent.getAction();
    paramView = this.a.jdField_a_of_type_Bcis.a();
    if (i == 0)
    {
      this.a.m.setText(ajyc.a(2131705135));
      this.a.m.setTextColor(this.a.r);
      this.a.jdField_a_of_type_Atcf.b();
      if (paramView != null) {
        paramView.a(true);
      }
      axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "wolf_talk", 0, 0, "", "", "", "");
      bool = true;
    }
    while ((i != 3) && (i != 1)) {
      return bool;
    }
    this.a.m.setText(ajyc.a(2131705074));
    this.a.m.setTextColor(this.a.q);
    this.a.jdField_a_of_type_Atcf.c();
    if (paramView != null) {
      paramView.a(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aepx
 * JD-Core Version:    0.7.0.1
 */