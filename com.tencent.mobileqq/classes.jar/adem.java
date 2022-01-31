import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr.ICallBackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import mqq.os.MqqHandler;

public class adem
  implements TVK_IDownloadMgr.ICallBackListener
{
  public adem(FileVideoManager.VideoControl paramVideoControl, QQAppInterface paramQQAppInterface) {}
  
  public void downloadCallBack(String paramString)
  {
    int i;
    int j;
    long l2;
    long l1;
    try
    {
      paramString = FileManagerUtil.a(paramString);
      i = Integer.parseInt((String)paramString.get("callbacktype"));
      j = Integer.parseInt((String)paramString.get("playid"));
      l2 = Long.parseLong((String)paramString.get("offset"));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Int = FileVideoManager.VideoControl.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      }
      if ((j != this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration() > 1L) && (l2 > this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Long)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Long = l2;
      }
      l1 = l2;
      if (l2 < this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Long) {
        l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Long;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_c_of_type_Boolean) {
        break label1064;
      }
      QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.hashCode() + "].[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],playid +[" + j + "] download success! igon");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.hashCode() + "]mDownloadMgr[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "]" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],playid +[" + j + "] File download over igon");
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      l2 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_JavaLangString);
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],playid +[" + j + "],downloadId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_c_of_type_Int + "],pos[" + l1 + "], tmpLen[" + l2 + "],block[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Int + "],bDownloadBlock[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Boolean + "],progress[" + (float)l2 / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize + "]");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (l1 - l2 > this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Int) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setRemainTime(20160714, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Int, 2147483647);
        ThreadManager.getUIHandler().post(new aden(this));
        if (QLog.isDevelopLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>.FVBlock", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],setRemainTime for playID[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Int + "]");
          QLog.i("FileVideoManager<FileAssistant>.FVBlock", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],startDownload for recv block [" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.d + "]");
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Boolean = true;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.d > 0) && (l1 - l2 < this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Int))
      {
        ThreadManager.getUIHandler().post(new adeo(this));
        if (QLog.isDevelopLevel()) {
          QLog.i("FileVideoManager<FileAssistant>.FVBlock", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] block is full will be stop [" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.d + "]");
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Boolean = false;
      }
      float f = (float)l2 / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = f;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      return;
      if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_JavaLangString) == this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize)
      {
        FileVideoManager.VideoControl.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl);
        return;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 12, null, 6, null);
        paramString = (FileVideoManager.FileVideoManagerCallback)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramString != null) {
          paramString.a(201, "");
        }
        FileVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      }
    }
    return;
    label1064:
    switch (i)
    {
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adem
 * JD-Core Version:    0.7.0.1
 */