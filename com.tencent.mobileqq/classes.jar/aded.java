import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerInitCallback;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class aded
  implements TVK_SDKMgr.InstallListener
{
  public aded(FileVideoManager paramFileVideoManager, long paramLong, FileVideoManager.FileVideoManagerInitCallback paramFileVideoManagerInitCallback) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    System.currentTimeMillis();
    long l = this.jdField_a_of_type_Long;
  }
  
  public void onInstalledSuccessed()
  {
    System.currentTimeMillis();
    long l = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerInitCallback.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aded
 * JD-Core Version:    0.7.0.1
 */