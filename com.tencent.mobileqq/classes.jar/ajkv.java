import android.os.Handler;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class ajkv
  implements Runnable
{
  public ajkv(TroopEnterEffectManager paramTroopEnterEffectManager, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig = this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.a.get()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.jdField_a_of_type_AndroidOsHandler.post(new ajkw(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkv
 * JD-Core Version:    0.7.0.1
 */