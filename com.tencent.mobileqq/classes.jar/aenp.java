import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class aenp
  implements Runnable
{
  public aenp(TroopAssistantManager paramTroopAssistantManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    localObject3 = null;
    localObject4 = this.jdField_a_of_type_ComTencentMobileqqManagersTroopAssistantManager.jdField_a_of_type_JavaLangObject;
    localObject1 = localObject3;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqManagersTroopAssistantManager.jdField_a_of_type_JavaUtilSet != null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_ComTencentMobileqqManagersTroopAssistantManager.jdField_a_of_type_JavaUtilSet.size() > 0) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqManagersTroopAssistantManager.jdField_a_of_type_JavaUtilSet.toArray();
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("troopassist_guide", 2, localIllegalArgumentException.getMessage());
          localObject1 = localObject3;
        }
      }
    }
    finally {}
    if (localObject1 != null) {
      SharedPreferencesHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit(), "troop_assis_new_unread_list", (Object[])localObject1).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenp
 * JD-Core Version:    0.7.0.1
 */