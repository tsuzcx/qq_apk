import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acmj
  extends FileTransferObserver
{
  public acmj(FileVideoManager.VideoControl paramVideoControl, FileManagerEntity paramFileManagerEntity, FileVideoManager.FileVideoManagerCallback paramFileVideoManagerCallback) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, String paramString3, short paramShort, String paramString4, List paramList, int paramInt, String paramString5, long paramLong2)
  {
    QLog.i("FileVideoManager<FileAssistant>", 2, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],[getOnlinePlay]  ID[" + paramLong2 + "] onUpdateGetOfflineDownloadInfo");
    paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (paramLong1 == -100001L) {}
    while ((paramString3 == null) || (paramString3.length() == 0))
    {
      paramLong2 = 9360L;
      if (paramLong1 == 0L) {
        paramLong2 = 9048L;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.a((int)paramLong2, BaseApplication.getContext().getResources().getString(2131428596));
      return;
      if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
        paramString1.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.a((int)paramLong1, BaseApplication.getContext().getResources().getString(2131428190));
        return;
      }
      if (!paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.a((int)9045L, BaseApplication.getContext().getResources().getString(2131428596));
        return;
      }
    }
    paramString1 = "http://" + paramString3 + ":" + String.valueOf(paramShort) + paramString4;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.c = paramString2;
    FileVideoManager.VideoControl.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmj
 * JD-Core Version:    0.7.0.1
 */