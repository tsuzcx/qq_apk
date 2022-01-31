import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.io.File;
import java.util.UUID;

public class ajle
  implements Runnable
{
  public ajle(TroopFileTransferMgr paramTroopFileTransferMgr, TroopFileTransferManager.Item paramItem, UUID paramUUID) {}
  
  public void run()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Status)
    {
    default: 
      return;
    case 9: 
    case 10: 
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile != null) {
        new File(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile).delete();
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferMgr.a(this.jdField_a_of_type_JavaUtilUUID, true);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile = null;
      TroopFileTransferMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferMgr, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 7);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile != null) {
        new File(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajle
 * JD-Core Version:    0.7.0.1
 */