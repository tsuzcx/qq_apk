import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileScanTask;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner;
import java.util.LinkedList;
import java.util.Map;

public class ajmm
  implements Runnable
{
  public ajmm(TroopFileScaner paramTroopFileScaner, long paramLong, TroopFileScanTask paramTroopFileScanTask, String paramString) {}
  
  public void run()
  {
    TroopFileScaner.a(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner).put(Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask);
    TroopFileScaner.a(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner).add(Long.valueOf(this.jdField_a_of_type_Long));
    TroopFileTransferUtil.Log.c("TroopFileScaner", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_Long + "] startScan filePath. " + this.jdField_a_of_type_JavaLangString + TroopFileScaner.a(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner));
    TroopFileScaner.a(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScaner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmm
 * JD-Core Version:    0.7.0.1
 */