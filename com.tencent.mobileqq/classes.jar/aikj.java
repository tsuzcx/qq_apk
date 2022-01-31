import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog;
import com.tencent.qphone.base.util.QLog;

public class aikj
  extends SubAccountBindObserver
{
  public aikj(AssociatedAccountOptPopBar paramAssociatedAccountOptPopBar) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "onGetBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) || (this.a.jdField_a_of_type_JavaUtilList == null) || (!this.a.a()) || (paramSubAccountBackProtocData == null) || (!TextUtils.equals(paramSubAccountBackProtocData.b, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c()))) {
      return;
    }
    AssociatedAccountOptPopBar.a(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.a(this.a.jdField_a_of_type_JavaUtilList);
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "onBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) || (this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.isShowing()) || (paramSubAccountBackProtocData == null) || (!TextUtils.equals(paramSubAccountBackProtocData.b, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c()))) {
      return;
    }
    AssociatedAccountOptPopBar.a(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.a(this.a.jdField_a_of_type_JavaUtilList);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "onUnBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) || (this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.isShowing()) || (paramSubAccountBackProtocData == null) || (!TextUtils.equals(paramSubAccountBackProtocData.b, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c()))) {
      return;
    }
    AssociatedAccountOptPopBar.a(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.a(this.a.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikj
 * JD-Core Version:    0.7.0.1
 */