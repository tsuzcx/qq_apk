import android.os.Handler;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import org.json.JSONObject;

public class akdi
  implements Runnable
{
  public akdi(TroopInteractGiftAnimationController paramTroopInteractGiftAnimationController, String paramString, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean, FrameSprite.OnFrameEndListener paramOnFrameEndListener, TroopGiftManager paramTroopGiftManager) {}
  
  public void run()
  {
    JSONObject localJSONObject = TroopGiftUtil.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a.post(new akdj(this, localJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdi
 * JD-Core Version:    0.7.0.1
 */