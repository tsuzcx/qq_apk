import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnZipEventListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

class acsw
  implements TroopFileProtocol.OnGetZipFileList
{
  acsw(acsv paramacsv) {}
  
  public void a(List paramList)
  {
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.a(paramList, this.a.a.jdField_a_of_type_JavaLangString, this.a.a.b, this.a.a.c, this.a.a.d);
    }
    if (paramList != null)
    {
      ReportController.b(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_suc", 0, 0, "" + this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin, "", FileManagerUtil.f(this.a.a.a()), "1");
      return;
    }
    ReportController.b(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, "" + this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin, "-1", FileManagerUtil.f(this.a.a.a()), "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsw
 * JD-Core Version:    0.7.0.1
 */