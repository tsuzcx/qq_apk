import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;

public class ajem
  implements DialogInterface.OnClickListener
{
  public ajem(TroopFileItemOperation paramTroopFileItemOperation, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      TroopFileItemOperation.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajem
 * JD-Core Version:    0.7.0.1
 */