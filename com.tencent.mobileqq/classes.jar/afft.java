import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.mobileqq.nearby.profilecard.ProfileQiqiLiveController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;

public class afft
  extends Handler
{
  public afft(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton == null);
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131438097);
            return;
          } while (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton == null);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(paramMessage.arg1);
          return;
        } while (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton == null);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(100);
        return;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController == null) || (NearbyProfileDisplayTribePanel.a(this.a) == null));
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131438093);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(NearbyProfileDisplayTribePanel.a(this.a).uRoomid);
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "install_bootstrap", 0, 0, NearbyProfileDisplayTribePanel.a(this.a).uin, "", "yes", "android");
      return;
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131438098, 0).a();
      return;
    } while (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController == null);
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afft
 * JD-Core Version:    0.7.0.1
 */