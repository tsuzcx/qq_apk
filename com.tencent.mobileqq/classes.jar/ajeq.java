import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.Map;

public class ajeq
  implements DialogInterface.OnClickListener
{
  public ajeq(TroopFileItemOperation paramTroopFileItemOperation, TroopFileInfo paramTroopFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.b).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
    paramDialogInterface = (TroopFileInfo)TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.b).c.get(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.f);
    if (paramDialogInterface != null) {
      paramDialogInterface.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a, "CliOper", "", "", "Grp", "Cancel_pause_download", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.b + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajeq
 * JD-Core Version:    0.7.0.1
 */