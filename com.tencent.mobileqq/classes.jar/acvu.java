import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class acvu
  implements Runnable
{
  public acvu(FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]StartDownload");
    }
    FileVideoManager.VideoControl localVideoControl1 = FileVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    localVideoControl1.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    Iterator localIterator = FileVideoManager.a(FileVideoManager.a).keySet().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      FileVideoManager.VideoControl localVideoControl2 = (FileVideoManager.VideoControl)FileVideoManager.a(FileVideoManager.a).get(Long.valueOf(l));
      if (localVideoControl2.a())
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]is downloading continue");
        }
        return;
      }
      if (localVideoControl2.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        localVideoControl2.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        localVideoControl2.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
        localVideoControl2.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        if (QLog.isDevelopLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + localVideoControl2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]Paused!");
        }
      }
      if (localVideoControl2.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
      {
        if (QLog.isDevelopLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localVideoControl2.hashCode() + "]downMgr[" + localVideoControl2.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + localVideoControl2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]pause,start other download, stop this[" + localVideoControl2.jdField_a_of_type_Int + "]");
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localVideoControl2.hashCode() + "]downMgr[" + localVideoControl2.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + localVideoControl2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]pause，start other download, stop this[" + localVideoControl2.c + "]");
        }
        if (localVideoControl2.jdField_a_of_type_Int > 0) {
          localVideoControl2.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(localVideoControl2.jdField_a_of_type_Int);
        }
        if (localVideoControl2.c > 0) {
          localVideoControl2.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(localVideoControl2.c);
        }
        if (localVideoControl2.d > 0) {
          localVideoControl2.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(localVideoControl2.d);
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + localVideoControl2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]##########Need pause########### bDownloading = false");
        }
        localVideoControl2.b = false;
      }
    }
    localVideoControl1.b = true;
    localVideoControl1.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvu
 * JD-Core Version:    0.7.0.1
 */