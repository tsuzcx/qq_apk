import android.os.Handler;
import android.os.Looper;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.DeviceFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;

public class adcz
  extends DeviceFileObserver
{
  public adcz(DeviceFileModel paramDeviceFileModel) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {}
    while ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null) || (paramSession.uSessionID != DeviceFileModel.a(this.a))) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.a(paramFloat);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener != null) && (paramSession.uSessionID == DeviceFileModel.b(this.a)) && (paramBoolean))
      {
        localFileManagerEntity.strThumbPath = paramSession.strFilePathSrc;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener.a(String.valueOf(localFileManagerEntity.nSessionId), paramSession.strFilePathSrc);
      }
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null) || (paramSession.uSessionID != DeviceFileModel.a(this.a)));
    if (paramBoolean)
    {
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.f();
      if (this.a.e() == 2)
      {
        new Handler(Looper.getMainLooper()).postDelayed(new adda(this), 1000L);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.f();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.g();
  }
  
  public void b(Session paramSession)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) && (paramSession.uSessionID == DeviceFileModel.a(this.a))) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adcz
 * JD-Core Version:    0.7.0.1
 */