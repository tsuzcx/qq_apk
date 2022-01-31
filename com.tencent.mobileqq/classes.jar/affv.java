import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.mobileqq.nearby.profilecard.ProfileQiqiLiveController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.List;

public class affv
  implements DownloadListener
{
  public affv(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    this.a.jdField_a_of_type_Int = 2;
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.jdField_a_of_type_Int = 4;
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    if (NearbyProfileDisplayTribePanel.a(this.a) != null) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "install_done", 0, 0, NearbyProfileDisplayTribePanel.a(this.a).uin, "", "yes", "android");
    }
  }
  
  public void a(List paramList)
  {
    this.a.jdField_a_of_type_Int = 1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (DownloadInfo)paramList.get(0);
      Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 2;
      localMessage.arg1 = paramList.g;
      localMessage.sendToTarget();
      if ((paramList.g == 0) && (NearbyProfileDisplayTribePanel.a(this.a) != null)) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_begin", 0, 0, NearbyProfileDisplayTribePanel.a(this.a).uin, "", "yes", "android");
      }
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    this.a.jdField_a_of_type_Int = 2;
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    this.a.jdField_a_of_type_Int = 3;
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(5);
    }
    if (NearbyProfileDisplayTribePanel.a(this.a) != null) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_done", 0, 0, NearbyProfileDisplayTribePanel.a(this.a).uin, "", "yes", "android");
    }
  }
  
  public void c(String paramString1, String paramString2) {}
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    this.a.jdField_a_of_type_Int = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     affv
 * JD-Core Version:    0.7.0.1
 */