import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.Map;

public class ajom
  extends BizTroopObserver
{
  static
  {
    if (!TroopFileManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public ajom(TroopFileManager paramTroopFileManager) {}
  
  protected void a(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof TroopFileStatusInfo))) {
      return;
    }
    Object localObject2 = (TroopFileStatusInfo)???;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager)
    {
      if (((TroopFileStatusInfo)localObject2).jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.jdField_a_of_type_Long) {
        return;
      }
    }
    TroopFileInfo localTroopFileInfo1 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.b.get(((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaUtilUUID);
    if ((!jdField_a_of_type_Boolean) && (localTroopFileInfo1 == null)) {
      throw new AssertionError();
    }
    if (localTroopFileInfo1 == null) {
      return;
    }
    int i = localTroopFileInfo1.e;
    if ((localTroopFileInfo1.b == null) && (((TroopFileStatusInfo)localObject2).e != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.put(((TroopFileStatusInfo)localObject2).e, localTroopFileInfo1);
    }
    localTroopFileInfo1.a((TroopFileStatusInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((TroopFileStatusInfo)localObject2).b == 12)
    {
      localObject2 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(localTroopFileInfo1.f);
      if (localObject2 != null) {
        ((TroopFileInfo)localObject2).a(localTroopFileInfo1);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d(localTroopFileInfo1);
      return;
    }
    if (localTroopFileInfo1.jdField_a_of_type_Boolean) {
      if (((TroopFileStatusInfo)localObject2).b != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localTroopFileInfo1.jdField_a_of_type_Boolean = bool;; localTroopFileInfo1.jdField_a_of_type_Boolean = true) {
        do
        {
          if (!"/".equals(localTroopFileInfo1.f))
          {
            TroopFileInfo localTroopFileInfo2 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(localTroopFileInfo1.f);
            if ((localTroopFileInfo2 != null) && ((localTroopFileInfo1.e == 9) || (localTroopFileInfo1.e == 10) || (localTroopFileInfo1.e == 11))) {
              localTroopFileInfo2.a(localTroopFileInfo1);
            }
          }
          if ((((TroopFileStatusInfo)localObject2).b == 6) && (i != 6))
          {
            localTroopFileInfo1.a((int)NetConnInfoCenter.getServerTime());
            localTroopFileInfo1.b((int)NetConnInfoCenter.getServerTime());
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.e(localTroopFileInfo1);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d(localTroopFileInfo1);
          return;
        } while ((((TroopFileStatusInfo)localObject2).b != 11) || (localTroopFileInfo1.e == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajom
 * JD-Core Version:    0.7.0.1
 */