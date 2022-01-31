import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Map;

class ajpb
  implements Runnable
{
  ajpb(ajpa paramajpa) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.b.remove(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile = null;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpb
 * JD-Core Version:    0.7.0.1
 */