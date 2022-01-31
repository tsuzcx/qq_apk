import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.NewStyleDropdownView.DropdownCallback;
import com.tencent.qphone.base.util.QLog;

class akve
  implements Runnable
{
  akve(akvd paramakvd, View paramView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "arrow clicked and postDelayed 250 run, set icon up and isLastDropDown true");
    }
    ((ImageView)this.jdField_a_of_type_AndroidViewView).setImageDrawable(this.jdField_a_of_type_Akvd.a.b);
    if (this.jdField_a_of_type_Akvd.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback != null) {
      this.jdField_a_of_type_Akvd.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback.b();
    }
    this.jdField_a_of_type_Akvd.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akve
 * JD-Core Version:    0.7.0.1
 */