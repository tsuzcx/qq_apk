import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajvp
  implements Runnable
{
  public ajvp(TroopAppMgr paramTroopAppMgr, ArrayList paramArrayList, EntityManager paramEntityManager, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Object localObject1 = TableBuilder.b(TroopAIOAppInfo.class);
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopAIOAppInfo.class);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.a(".troop.troop_appVASH", "before delete type:" + this.jdField_a_of_type_Int, (List)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((String)localObject1, "groupType=?", new String[] { String.valueOf(this.jdField_a_of_type_Int) });
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopAIOAppInfo.class);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.a(".troop.troop_appVASH", "before update after delete type:" + this.jdField_a_of_type_Int, (List)localObject1);
      }
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopAIOAppInfo)((Iterator)localObject1).next();
        ((TroopAIOAppInfo)localObject2).setStatus(1000);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (Entity)localObject2);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopAIOAppInfo.class);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.a(".troop.troop_appVASH", "after update type:" + this.jdField_a_of_type_Int, (List)localObject1);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvp
 * JD-Core Version:    0.7.0.1
 */