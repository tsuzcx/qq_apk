import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

public class aiwk
  implements Runnable
{
  public aiwk(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.app == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.app.getEntityManagerFactory().createEntityManager();
    Setting localSetting = (Setting)localEntityManager.a(Setting.class, "troop_" + this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.a);
    localEntityManager.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.runOnUiThread(new aiwl(this, localSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwk
 * JD-Core Version:    0.7.0.1
 */