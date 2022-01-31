import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import java.util.ArrayList;

public class ajdu
  implements DialogInterface.OnClickListener
{
  public ajdu(TroopBarReplyActivity paramTroopBarReplyActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    case 6: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.h();
      return;
    case 2: 
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new ajdv(this), 200L);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.b(4);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.g();
      return;
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.b(3);
      return;
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new ajdw(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdu
 * JD-Core Version:    0.7.0.1
 */