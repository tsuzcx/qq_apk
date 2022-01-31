import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.FileUtils;

public class ajmg
  implements Runnable
{
  public ajmg(TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.jdField_a_of_type_Boolean)
    {
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.jdField_a_of_type_JavaLangString + "] passiveEnd. but had stop");
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.a(this.jdField_a_of_type_Int, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.e = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.e.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.jdField_a_of_type_JavaLangString + "] passiveSuc thumbpath is same.");
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.a(true, true);
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.jdField_a_of_type_JavaLangString + "] passiveSuc copy file.");
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.d = (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.e + ".ttmp");
    FileUtils.d(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.d);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailGenTask.a(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmg
 * JD-Core Version:    0.7.0.1
 */