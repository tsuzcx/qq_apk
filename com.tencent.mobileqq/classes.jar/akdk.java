import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;

class akdk
  implements View.OnClickListener
{
  akdk(akdj paramakdj) {}
  
  public void onClick(View paramView)
  {
    this.a.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.b();
    paramView = this.a.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController;
    paramView.jdField_a_of_type_Int += 1;
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_Boolean)
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_Boolean = false;
      this.a.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a(this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId, this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationPackageId, this.a.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_Int, false);
    }
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_Int % 5 == 0) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.a(this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationPackageId + "");
    }
    ReportController.b(null, "dc00899", "Grp_flower", "", "inter_gift", "clk_ball", 0, 0, this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdk
 * JD-Core Version:    0.7.0.1
 */