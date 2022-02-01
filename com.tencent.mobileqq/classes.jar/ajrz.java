import com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.List;

class ajrz
  implements audq
{
  ajrz(ajrx paramajrx, FileManagerEntity paramFileManagerEntity) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0) {
      this.jdField_a_of_type_Ajrx.a.a.getOnlineFileSessionCenter().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    }
    ansr localansr;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 6) {
        break;
      }
      localansr = (ansr)this.jdField_a_of_type_Ajrx.a.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq));
    } while (localansr.a(localArrayList));
    audr.a(2131692468);
    return;
    this.jdField_a_of_type_Ajrx.a.a.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrz
 * JD-Core Version:    0.7.0.1
 */