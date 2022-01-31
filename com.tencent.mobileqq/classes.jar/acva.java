import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class acva
  implements Runnable
{
  public acva(FileManagerNotifyCenter paramFileManagerNotifyCenter, FileManagerEntity paramFileManagerEntity, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext != null) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext instanceof String)) && ("DeceptiveProgressed".equalsIgnoreCase((String)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext)))
    {
      QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + " DeceptiveProgressed return");
      return;
    }
    QLog.i("Bug", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + " do DeceptiveProgress");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 14, null);
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress >= 0.95F)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter.a.a().a(true, 3, null);
      }
      try
      {
        Thread.sleep(50L);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress < 1.0F) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext = new String("DeceptiveProgressed");
        QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + " set DeceptiveProgressed");
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter.a.a().a(true, 3, null);
          FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = MessageCache.a();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter.a.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          return;
          FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
          localFileManagerEntity.fProgress = ((float)(localFileManagerEntity.fProgress + 0.05D));
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter.a.a().a(true, 34, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter.a.a().a(true, 33, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acva
 * JD-Core Version:    0.7.0.1
 */