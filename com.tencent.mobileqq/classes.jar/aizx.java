import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aizx
  implements Runnable
{
  public aizx(TroopAppMgr paramTroopAppMgr, EntityManager paramEntityManager, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopAIOAppInfo.class);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.a(".troop.troop_appVASH", "before updateEntity(" + this.jdField_a_of_type_Int + ")", (List)localObject);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, localTroopAIOAppInfo);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopAIOAppInfo.class);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.a(".troop.troop_appVASH", "after updateEntity(" + this.jdField_a_of_type_Int + ")", (List)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aizx
 * JD-Core Version:    0.7.0.1
 */