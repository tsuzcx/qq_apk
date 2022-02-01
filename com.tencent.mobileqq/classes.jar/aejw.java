import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class aejw
  extends aoaa
{
  aejw(aejv paramaejv, BaseActivity paramBaseActivity) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this);
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Aejv.a != null) && (this.jdField_a_of_type_Aejv.a.isShowing())) {
        this.jdField_a_of_type_Aejv.a.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, anzj.a(2131701501), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if ((this.jdField_a_of_type_Aejv.a != null) && (this.jdField_a_of_type_Aejv.a.isShowing())) {
      this.jdField_a_of_type_Aejv.a.dismiss();
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, anzj.a(2131701502), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejw
 * JD-Core Version:    0.7.0.1
 */