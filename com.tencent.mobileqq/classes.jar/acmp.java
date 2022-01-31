import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

class acmp
  implements FileVideoManager.FileVideoManagerCallback
{
  acmp(acmo paramacmo) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.a(paramInt, paramString);
      FileVideoManager.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_JavaLangString = paramString1;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.c = paramString2;
    FileVideoManager.VideoControl.b(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Int = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPlayWithSavePath(20160714, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_JavaLangString, FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.b), 0L, 0, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.b, 0);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Int, 6);
    paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.buildPlayURLMp4(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Int);
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.hashCode() + "][" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]getDiscPlayUrl, mPlayId[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_Int + "]");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType = 8;
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.a(paramString1, paramString2);
    }
  }
  
  public void ac_() {}
  
  public void ad_()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$FileVideoManagerCallback.ad_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmp
 * JD-Core Version:    0.7.0.1
 */