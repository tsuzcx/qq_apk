import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Map;
import java.util.UUID;

public class ajwv
  implements Runnable
{
  public ajwv(TroopFileTransferManager paramTroopFileTransferManager, UUID paramUUID, TroopFileInfo paramTroopFileInfo, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.c();
    TroopFileTransferManager.Item localItem2 = (TroopFileTransferManager.Item)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a.get(this.jdField_a_of_type_JavaUtilUUID);
    TroopFileTransferManager.Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      localItem1 = new TroopFileTransferManager.Item(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(localItem1);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.b(localItem1, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwv
 * JD-Core Version:    0.7.0.1
 */