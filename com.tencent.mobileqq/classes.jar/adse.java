import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class adse
  implements Runnable
{
  public adse(TroopRemindSettingManager paramTroopRemindSettingManager, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((TroopRemindSettingData)localEntityManager.a(TroopRemindSettingData.class, this.jdField_a_of_type_JavaLangString) == null)
    {
      TroopRemindSettingData localTroopRemindSettingData = new TroopRemindSettingData();
      localTroopRemindSettingData.troopUin = this.jdField_a_of_type_JavaLangString;
      localTroopRemindSettingData.isOpenState = 0;
      localEntityManager.b(localTroopRemindSettingData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adse
 * JD-Core Version:    0.7.0.1
 */