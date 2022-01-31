import android.os.Handler;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import org.json.JSONObject;

public class ajhr
  implements Runnable
{
  public ajhr(TroopInteractGiftAnimationController paramTroopInteractGiftAnimationController, String paramString, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean, FrameSprite.OnFrameEndListener paramOnFrameEndListener, TroopGiftManager paramTroopGiftManager) {}
  
  public void run()
  {
    JSONObject localJSONObject = TroopGiftUtil.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a.post(new ajhs(this, localJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajhr
 * JD-Core Version:    0.7.0.1
 */