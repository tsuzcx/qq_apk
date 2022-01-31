import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;

public class ajwm
  implements Runnable
{
  public ajwm(TroopInteractGiftAnimationController paramTroopInteractGiftAnimationController) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwm
 * JD-Core Version:    0.7.0.1
 */