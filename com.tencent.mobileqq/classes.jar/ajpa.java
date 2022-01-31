import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.io.File;
import mqq.os.MqqHandler;

public class ajpa
  implements Runnable
{
  public ajpa(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item == null) {
      return;
    }
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
      ThreadManager.getUIHandler().post(new ajpb(this));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile != null) {
        new File(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpa
 * JD-Core Version:    0.7.0.1
 */