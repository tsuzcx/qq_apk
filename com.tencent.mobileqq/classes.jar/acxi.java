import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class acxi
  implements Runnable
{
  public acxi(OnlineFileSessionWorker paramOnlineFileSessionWorker, float paramFloat) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if ((localFileManagerEntity.fProgress < this.jdField_a_of_type_Float) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null))
      {
        float f = localFileManagerEntity.fProgress + 0.05F;
        if (f > this.jdField_a_of_type_Float) {}
        for (localFileManagerEntity.fProgress = this.jdField_a_of_type_Float;; localFileManagerEntity.fProgress = f)
        {
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 16, null, 0, null);
            try
            {
              Thread.sleep(100L);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
          break;
        }
      }
    } while ((localFileManagerEntity.fProgress < 1.0F) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null));
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + localFileManagerEntity.nSessionId + "] state:" + OnlineFileSessionWorker.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " make progress. direct pass to 1.0 and notify make done");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 41, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acxi
 * JD-Core Version:    0.7.0.1
 */