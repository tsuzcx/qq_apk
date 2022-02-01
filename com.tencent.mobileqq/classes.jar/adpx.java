import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.List;

class adpx
  implements audq
{
  adpx(adpw paramadpw, FileManagerEntity paramFileManagerEntity) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0) {
      this.jdField_a_of_type_Adpw.a.a.getOnlineFileSessionCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    }
    ansr localansr;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 6) {
        break;
      }
      localansr = (ansr)this.jdField_a_of_type_Adpw.a.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq));
    } while (localansr.a(localArrayList));
    audr.a(2131692468);
    return;
    this.jdField_a_of_type_Adpw.a.a.getFileManagerEngine().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpx
 * JD-Core Version:    0.7.0.1
 */