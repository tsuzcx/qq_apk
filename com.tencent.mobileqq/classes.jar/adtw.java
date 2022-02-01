import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class adtw
  extends anwo
{
  adtw(adtv paramadtv, BaseActivity paramBaseActivity) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this);
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Adtv.a != null) && (this.jdField_a_of_type_Adtv.a.isShowing())) {
        this.jdField_a_of_type_Adtv.a.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, anvx.a(2131702087), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if ((this.jdField_a_of_type_Adtv.a != null) && (this.jdField_a_of_type_Adtv.a.isShowing())) {
      this.jdField_a_of_type_Adtv.a.dismiss();
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, anvx.a(2131702088), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtw
 * JD-Core Version:    0.7.0.1
 */