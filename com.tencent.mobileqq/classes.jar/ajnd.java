import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadWorker;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;

class ajnd
  implements Runnable
{
  ajnd(ajnc paramajnc, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ajnc.a.jdField_a_of_type_Boolean) {
      return;
    }
    TroopFileError.SimpleErrorInfo localSimpleErrorInfo = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_Ajnc.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 3, 210);
    this.jdField_a_of_type_Ajnc.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
    this.jdField_a_of_type_Ajnc.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = -36;
    this.jdField_a_of_type_Ajnc.a.a(false, TroopTechReportUtils.TroopFileReportResultCode.c, -36, localSimpleErrorInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnd
 * JD-Core Version:    0.7.0.1
 */