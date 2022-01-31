import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;

public class ajii
  implements Runnable
{
  public ajii(TroopInteractGiftAnimationController paramTroopInteractGiftAnimationController) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.d.removeView(this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView);
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton != null) {
      this.a.jdField_a_of_type_AndroidViewViewGroup.removeView(this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView = null;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajii
 * JD-Core Version:    0.7.0.1
 */