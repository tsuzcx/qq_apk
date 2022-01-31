import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileManager;

public class aiql
  implements DialogInterface.OnClickListener
{
  public aiql(TroopFileItemOperation paramTroopFileItemOperation, TroopFileInfo paramTroopFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    if (TroopFileItemOperation.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation) != 0) {
      TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.b).b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a, "CliOper", "", "", "Grp", "Cancel_pause_upload", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.b + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiql
 * JD-Core Version:    0.7.0.1
 */