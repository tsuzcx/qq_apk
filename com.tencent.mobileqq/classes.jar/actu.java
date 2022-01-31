import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class actu
  implements Runnable
{
  public actu(FileManagerEngine paramFileManagerEngine, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, long paramLong) {}
  
  public void run()
  {
    FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.a.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, this.c, 0L, true, this.jdField_a_of_type_Int, this.d, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq, null, this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid, -1L, MessageCache.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] SendLocalfile[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "], peerType[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType + "]");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.a.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] SendLocalfileToWeiyun[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     actu
 * JD-Core Version:    0.7.0.1
 */