import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class adet
  implements FileVideoManager.FileVideoManagerCallback
{
  public adet(FileVideoManager.VideoControl paramVideoControl, FileManagerEntity paramFileManagerEntity, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]on Error[" + paramInt + "]msg[" + paramString + "]");
    }
    Object localObject;
    if ((paramInt == -25081) || (paramInt == -6101) || (paramInt == -7003))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ((QQAppInterface)localObject).a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      FMToastUtil.a(2131428190);
      ((QQAppInterface)localObject).a().a(true, 3, null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject = (FileVideoManager.FileVideoManagerCallback)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        ((FileVideoManager.FileVideoManagerCallback)localObject).a(paramInt, paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onGetUrlCookies");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_Boolean);
  }
  
  public void ag_() {}
  
  public void ah_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adet
 * JD-Core Version:    0.7.0.1
 */