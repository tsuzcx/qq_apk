import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnZipEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import java.util.List;

class actq
  implements TroopFileProtocol.OnGetZipFileList
{
  actq(actp paramactp) {}
  
  public void a(List paramList)
  {
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.a(paramList, this.a.a.jdField_a_of_type_JavaLangString, this.a.a.b, this.a.a.c, this.a.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     actq
 * JD-Core Version:    0.7.0.1
 */