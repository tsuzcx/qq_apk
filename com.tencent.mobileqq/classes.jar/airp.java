import android.os.Handler;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class airp
  implements Runnable
{
  public airp(TroopEnterEffectManager paramTroopEnterEffectManager, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig = this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.a.get()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.jdField_a_of_type_AndroidOsHandler.post(new airq(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     airp
 * JD-Core Version:    0.7.0.1
 */