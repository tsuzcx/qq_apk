import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopFileVideoOnlinePlayManager.TroopFileWhiteListCallback;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnPreviewVideoOnlineListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsVideo;

public class addw
  implements TroopFileVideoOnlinePlayManager.TroopFileWhiteListCallback
{
  public addw(TroopFileModel paramTroopFileModel, FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener, TroopInfo paramTroopInfo, TroopManager paramTroopManager) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener != null)
    {
      if (paramInt1 == 0) {
        break label144;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener.ac_();
    }
    while (paramInt1 != 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener.ac_();
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopFileVideoIsWhite = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopFileVideoReqInterval = (System.currentTimeMillis() + paramInt2 * 1000);
      ThreadManager.post(new addx(this), 5, null, true);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "OfflineVideoFileView initVarView() is_white = " + paramInt1 + ", req_interval = " + paramInt2);
      }
      return;
      label144:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener.ad_();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener.ad_();
    }
    if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
    for (String str = "0";; str = "-1")
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     addw
 * JD-Core Version:    0.7.0.1
 */