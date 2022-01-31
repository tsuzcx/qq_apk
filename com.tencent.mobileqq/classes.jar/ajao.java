import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;

public class ajao
  implements Runnable
{
  public ajao(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.app == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.app.getEntityManagerFactory().createEntityManager();
    Setting localSetting = (Setting)localEntityManager.a(Setting.class, "troop_" + this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.a);
    localEntityManager.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.runOnUiThread(new ajap(this, localSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajao
 * JD-Core Version:    0.7.0.1
 */