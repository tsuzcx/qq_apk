import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.NewStyleDropdownView.DropdownCallback;
import com.tencent.qphone.base.util.QLog;

public class akvd
  implements View.OnClickListener
{
  public akvd(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Akvg.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_Akvg.getWindowToken(), 0);
    Drawable localDrawable;
    StringBuilder localStringBuilder;
    if ((this.a.jdField_a_of_type_Akvg.getAdapter() != null) && (this.a.jdField_a_of_type_Akvg.getAdapter().getCount() > 0))
    {
      localDrawable = ((ImageView)paramView).getDrawable();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("arrow clicked, drawable is down=");
        if (localDrawable != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
          break label248;
        }
      }
    }
    label248:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("NewStyleDropdownView", 2, bool + ", isLastDropDown=" + this.a.jdField_a_of_type_Boolean);
      if ((localDrawable != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) || (this.a.jdField_a_of_type_Boolean)) {
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback.c(false);
      }
      NewStyleDropdownView.a(this.a).postDelayed(new akve(this, paramView), 500L);
      paramView = paramView.getContext();
      if ((paramView != null) && ((paramView instanceof LoginActivity))) {
        ReportController.a(((LoginActivity)paramView).app, "dc00898", "", "", "0X8007367", "0X8007367", 0, 0, "", "", "", "");
      }
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback.c(true);
    }
    this.a.jdField_a_of_type_Akvg.dismissDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akvd
 * JD-Core Version:    0.7.0.1
 */