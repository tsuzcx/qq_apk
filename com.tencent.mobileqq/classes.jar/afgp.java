import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.InputMethodUtil;
import tencent.im.oidb.cmd0xac5.cmd0xac5.MasterState;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;

public class afgp
  implements View.OnClickListener
{
  public afgp(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.getIntExtra("param_mode", 0) == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e != 1);
      InputMethodUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131434811));
        return;
      }
    } while (!NearbyProfileEditPanel.a(this.a));
    this.a.b();
    boolean bool1 = this.a.a();
    boolean bool2 = ((Boolean)NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
    boolean bool3 = this.a.c();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get() != null) && (((cmd0xac5.NearbyNowData)this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get() != null)) {}
    for (int i = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).uint32_state.get();; i = 0)
    {
      if ((i == 1) || (i == 2)) {}
      for (i = 1; (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (bool3) && (i != 0); i = 0)
      {
        new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_change").a(new String[] { "", "" + (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1) }).a();
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.s = bool3;
        paramView = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "修改资料后，需重新进行颜值达人审核，确定保存并重新审核吗？", 0, 0, null, null);
        paramView.setPositiveButton("保存并重审", new afgq(this, paramView));
        paramView.setNegativeButton("取消", new afgr(this, paramView));
        paramView.show();
        return;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (bool1))
      {
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131437447, new Object[] { this.a.jdField_a_of_type_JavaLangString });
        paramView = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView, 0, 0, null, null);
        paramView.setPositiveButton("完成编辑", new afgs(this, paramView));
        paramView.setNegativeButton("放弃编辑", new afgt(this, paramView));
        paramView.show();
        return;
      }
      if ((bool1) && (bool2))
      {
        paramView = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "交友资料禁止宣传色情与广告信息，发现将降低魅力等级或封号处理!", 0, 0, null, null);
        paramView.setPositiveButton("发布资料", new afgu(this, paramView));
        paramView.setNegativeButton("返回修改", new afgv(this, paramView));
        paramView.show();
        NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
        return;
      }
      if (bool1)
      {
        this.a.f();
        return;
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afgp
 * JD-Core Version:    0.7.0.1
 */