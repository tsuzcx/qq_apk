import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.widget.XListView;
import java.util.List;

public class acny
  implements TroopFileProtocol.OnGetZipFileList
{
  public acny(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.stopTitleProgress();
    if (paramList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter = new ZipFilesListAdapter(paramList, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.e = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.e + "/");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.c = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.c;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.d = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.d;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acny
 * JD-Core Version:    0.7.0.1
 */