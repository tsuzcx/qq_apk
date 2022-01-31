import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class acsk
  extends FMObserver
{
  public acsk(C2CFileModel paramC2CFileModel) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    if (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().nSessionId) {
      return;
    }
    FileManagerUtil.a(paramLong, paramInt, paramString);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    if ((paramLong1 == this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    }
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().nSessionId) {}
    while ((paramString2 == null) || (paramString2.length() <= 0) || (paramInt == 0)) {
      return;
    }
    FileManagerUtil.a(paramString2);
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if ((TextUtils.isEmpty(paramThumbnailInfo.a)) || (TextUtils.isEmpty(paramThumbnailInfo.b))) {
      if (QLog.isColorLevel()) {
        QLog.i("C2CFileModel<FileAssistant>", 2, "OnThumbDownLoad error : [fileId] = " + paramThumbnailInfo.a + " [path] = " + paramThumbnailInfo.b);
      }
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(paramThumbnailInfo.a, paramThumbnailInfo.b);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (!paramBoolean) {}
    do
    {
      do
      {
        do
        {
          return;
          paramInt = this.a.e();
          if (paramInt != 4) {
            break;
          }
        } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener == null);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(String.valueOf(paramLong), paramString2);
        return;
        if (paramInt != 0) {
          break;
        }
      } while ((this.a.c() != paramLong) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener == null));
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(String.valueOf(paramLong), paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("C2CFileModel<FileAssistant>", 2, "OnZipImageThumbDownloadCompleted : sessionId[" + paramLong + "]  thumbPath[" + paramString2 + "] but current file browser can not handle");
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    if (!paramBoolean) {
      FileManagerUtil.a(paramLong3, paramInt, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()) {}
    do
    {
      return;
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    } while ((paramString == null) || ((paramString.getCloudType() == 0) && (paramString.nOpType == 10)) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null));
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.a(paramString.fProgress);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CFileModel<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (paramLong2 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null) {
      return;
    }
    if (!paramBoolean)
    {
      FileManagerUtil.a(paramLong2, paramInt2, paramString2);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.g();
      return;
    }
    if (this.a.e() == 2)
    {
      new Handler().postDelayed(new acsl(this), 1000L);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.f();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.d();
  }
  
  protected void c(int paramInt, String paramString)
  {
    FileManagerUtil.a(paramString);
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsk
 * JD-Core Version:    0.7.0.1
 */