import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class adeq
  extends FileTransferObserver
{
  public adeq(FileVideoManager.VideoControl paramVideoControl, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, FileVideoManager.FileVideoManagerCallback paramFileVideoManagerCallback) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2)
  {
    QLog.i("FileVideoManager<FileAssistant>", 2, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],[getOnlinePlay Url]  ID[" + paramLong2 + "] OnDiscDownloadInfo");
    if (paramLong1 == -100001L) {}
    while ((paramString3 == null) || (paramString3.length() == 0))
    {
      paramLong2 = 9360L;
      if (paramLong1 == 0L) {
        paramLong2 = 9048L;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.a((int)paramLong2, BaseApplication.getContext().getResources().getString(2131428602));
      return;
      if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.a((int)paramLong1, BaseApplication.getContext().getResources().getString(2131428190));
        return;
      }
      if (!paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.a((int)9045L, BaseApplication.getContext().getResources().getString(2131428602));
        return;
      }
    }
    paramString1 = "http://" + paramString3 + ":" + String.valueOf(paramInt1) + "/ftn_handler/" + paramString4;
    if (QLog.isDevelopLevel()) {
      QLog.d("FileVideoManager<FileAssistant>", 1, paramString1);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.c = paramString5;
    FileVideoManager.VideoControl.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.a(paramString1, paramString5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adeq
 * JD-Core Version:    0.7.0.1
 */