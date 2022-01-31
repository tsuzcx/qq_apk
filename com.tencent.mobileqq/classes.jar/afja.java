import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afja
  implements View.OnClickListener
{
  public afja(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo;
    if ((paramView.getTag() instanceof PicInfo))
    {
      localPicInfo = (PicInfo)paramView.getTag();
      if (localPicInfo.g != "type_qq_head_pic") {
        break label183;
      }
      localPicInfo.c = this.a.a.app.a(1, String.valueOf(NearbyProfileDisplayPanel.a(this.a).uin), 200);
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby_people_card.", 2, "on mode guest small head clicked: uin is: " + NearbyProfileDisplayPanel.a(this.a).uin + " local path is: " + localPicInfo.c);
      }
      paramView = AnimationUtils.a(paramView);
      this.a.a.a(localPicInfo, paramView);
      if (ProfileActivity.c(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
        ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005240", "0X8005240", 0, 0, "", "", "", "");
      }
    }
    return;
    label183:
    paramView = AnimationUtils.a(paramView);
    int i = 0;
    label190:
    if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (localPicInfo.jdField_a_of_type_Int != ((PicInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int) {}
    }
    for (;;)
    {
      this.a.a.a(i, paramView);
      ReportController.b(this.a.a.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
      if (this.a.a.e == 3) {}
      for (paramView = "2";; paramView = "1")
      {
        ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_pic", 0, 0, paramView, "", "", "");
        if (!NearbyProxy.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, this.a.a.e)) {
          break;
        }
        this.a.a.app.a().b(localPicInfo.jdField_a_of_type_JavaLangString);
        return;
        i += 1;
        break label190;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afja
 * JD-Core Version:    0.7.0.1
 */