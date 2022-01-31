import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import org.json.JSONObject;

class akdq
  implements FrameSprite.OnFrameEndListener
{
  akdq(akdp paramakdp) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView == null) {
      return;
    }
    if (this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.playTotalMicroseconds / 1000L > this.a.jdField_a_of_type_Int + this.a.jdField_b_of_type_Int)
    {
      String str = this.a.jdField_a_of_type_JavaLangString + this.a.jdField_b_of_type_OrgJsonJSONObject.optString("videoPath", "3.mp4");
      this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a(str, new akdr(this));
      return;
    }
    this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a();
    if (this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null) {
      this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
    }
    this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a(this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId, this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationPackageId, this.a.jdField_a_of_type_Akdj.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_Int, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdq
 * JD-Core Version:    0.7.0.1
 */