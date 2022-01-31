import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;

public class aere
  implements ViewPager.OnPageChangeListener
{
  public aere(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("onPageSelected", new Object[] { Integer.valueOf(paramInt) });
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, true);
    Object localObject1 = (NearbyBaseFragment)this.a.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("android:switcher:2131365206:" + paramInt);
    if (localObject1 != null) {
      ((NearbyBaseFragment)localObject1).ap_();
    }
    ReportTask localReportTask;
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2)
    {
      if (paramInt != 0) {
        break label364;
      }
      NearbyProfileDisplayPanel.a(this.a).setVisibility(8);
      if (NearbyDataManager.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app))
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        new NowVideoReporter().h("data_card").i("shoot_exp").d("2").b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
        new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_post_view").a(new String[] { "", "" + (NearbyProfileDisplayPanel.a(this.a).gender + 1) }).a();
      }
    }
    else
    {
      if (paramInt != 0) {
        break label402;
      }
      localReportTask = new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp");
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e != 2) {
        break label390;
      }
      localObject1 = "1";
      label312:
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a() != 0) {
        break label396;
      }
    }
    label390:
    label396:
    for (Object localObject2 = "1";; localObject2 = "2")
    {
      localReportTask.a(new String[] { localObject1, localObject2 }).a();
      return;
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label364:
      NearbyProfileDisplayPanel.a(this.a).setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      localObject1 = "2";
      break label312;
    }
    label402:
    localObject2 = new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("datatab_exp");
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2) {}
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aere
 * JD-Core Version:    0.7.0.1
 */