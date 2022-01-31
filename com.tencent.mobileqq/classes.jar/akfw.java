import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.DropdownView;

public class akfw
  implements View.OnClickListener
{
  public akfw(DropdownView paramDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Akfz.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_Akfz.getWindowToken(), 0);
    if ((this.a.jdField_a_of_type_Akfz.getAdapter() != null) && (this.a.jdField_a_of_type_Akfz.getAdapter().getCount() > 0))
    {
      if ((((ImageView)paramView).getDrawable() != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) || (this.a.jdField_a_of_type_Boolean)) {
        break label160;
      }
      DropdownView.a(this.a).postDelayed(new akfx(this, paramView), 250L);
      paramView = paramView.getContext();
      if ((paramView != null) && ((paramView instanceof LoginActivity))) {
        ReportController.a(((LoginActivity)paramView).app, "dc00898", "", "", "0X8007367", "0X8007367", 0, 0, "", "", "", "");
      }
    }
    return;
    label160:
    this.a.jdField_a_of_type_Akfz.dismissDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akfw
 * JD-Core Version:    0.7.0.1
 */