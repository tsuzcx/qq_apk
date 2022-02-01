import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;

class aauh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aauh(aaud paramaaud) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.d.getMeasuredWidth();
    i = (int)(this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() - i - bhmg.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 5.0F));
    this.a.c.setMaxWidth(i);
    this.a.c.setText(new begb(this.a.jdField_a_of_type_Bfrq.h, 16).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauh
 * JD-Core Version:    0.7.0.1
 */