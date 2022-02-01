import android.view.View;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class ajoa
  implements bkzq
{
  public ajoa(ContactsTroopAdapter paramContactsTroopAdapter, boolean paramBoolean, TroopInfo paramTroopInfo, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_AndroidContentContext, 1, 2131692125, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.e();
      return;
      paramView = (anrb)this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode, 1);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800808D", "0X800808D", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode, 0);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800808C", "0X800808C", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoa
 * JD-Core Version:    0.7.0.1
 */