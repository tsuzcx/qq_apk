import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class adeu
  implements Runnable
{
  public adeu(FileVideoManager.VideoControl paramVideoControl, FileManagerEntity paramFileManagerEntity, FileVideoManager.FileVideoManagerCallback paramFileVideoManagerCallback) {}
  
  public void run()
  {
    if ((FileVideoManager.a != null) && (FileVideoManager.a(FileVideoManager.a) != null) && (FileVideoManager.a(FileVideoManager.a).size() > 0))
    {
      localObject = FileVideoManager.a(FileVideoManager.a).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        long l = ((Long)((Iterator)localObject).next()).longValue();
        if (l != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId)
        {
          FileVideoManager.VideoControl localVideoControl = (FileVideoManager.VideoControl)FileVideoManager.a(FileVideoManager.a).get(Long.valueOf(l));
          if (localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
          {
            localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
            localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
            localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
          }
          if (localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
          {
            if (localVideoControl.jdField_a_of_type_Int > 0)
            {
              localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(localVideoControl.jdField_a_of_type_Int);
              if (QLog.isDevelopLevel()) {
                QLog.i("FileVideoManager<FileAssistant>", 1, "[" + localVideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] stop playId[" + localVideoControl.jdField_a_of_type_Int + "]");
              }
            }
            if (localVideoControl.jdField_c_of_type_Int > 0)
            {
              localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(localVideoControl.jdField_c_of_type_Int);
              if (QLog.isDevelopLevel()) {
                QLog.i("FileVideoManager<FileAssistant>", 1, "[" + localVideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] stop downloadId[" + localVideoControl.jdField_c_of_type_Int + "]");
              }
            }
            if (localVideoControl.d > 0)
            {
              localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(localVideoControl.d);
              if (QLog.isDevelopLevel()) {
                QLog.i("FileVideoManager<FileAssistant>", 1, "[" + localVideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] stop blockId[" + localVideoControl.jdField_c_of_type_Int + "]");
              }
            }
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]getPlayUrl");
    }
    Object localObject = FMSettings.a().c() + MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_JavaLangString = ((String)localObject);
    FileVideoManager.VideoControl.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl);
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]##########getPlayUrl########### bDownloading = false");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Int >= 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.buildPlayURLMp4(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Int);
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 2, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]getPlayUrl:" + (String)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_c_of_type_JavaLangString);
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
    {
      FileVideoManager.VideoControl.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, new adev(this));
      return;
    }
    FileVideoManager.VideoControl.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, new adew(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adeu
 * JD-Core Version:    0.7.0.1
 */