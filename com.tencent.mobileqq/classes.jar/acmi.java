import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

class acmi
  implements Runnable
{
  acmi(acmh paramacmh) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>.FVBlock", 1, "[" + this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] chang thread[" + this.a.a.d + "]");
    }
    if (this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
    {
      this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.a.a.d);
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>.FVBlock", 1, "[" + this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] block is full stop downloadId[" + this.a.a.d + "]");
      }
      this.a.a.d = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmi
 * JD-Core Version:    0.7.0.1
 */