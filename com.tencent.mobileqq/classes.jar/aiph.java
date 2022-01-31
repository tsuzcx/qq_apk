import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog;

class aiph
  implements Runnable
{
  aiph(aipg paramaipg) {}
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog != null) && (this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.isShowing()))
    {
      AssociatedAccountOptPopBar.a(this.a.a);
      this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.a(this.a.a.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiph
 * JD-Core Version:    0.7.0.1
 */