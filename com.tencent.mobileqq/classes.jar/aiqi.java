import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;

public class aiqi
  implements DialogInterface.OnClickListener
{
  public aiqi(TroopFileItemOperation paramTroopFileItemOperation, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      TroopFileItemOperation.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiqi
 * JD-Core Version:    0.7.0.1
 */