import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;

public class agvo
  implements View.OnClickListener
{
  public agvo(ProfileHeaderView paramProfileHeaderView) {}
  
  public void onClick(View paramView)
  {
    paramView = TroopLinkManager.a();
    Object localObject = paramView.a("troop_unique_title");
    TroopLinkManager.LinkParams localLinkParams;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localLinkParams = new TroopLinkManager.LinkParams();
      localLinkParams.a = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d;
      localLinkParams.b = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;
      localLinkParams.e = TroopMemberCardUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
      localLinkParams.d = "3";
      localLinkParams.c = "aio";
    }
    for (paramView = paramView.a((String)localObject, localLinkParams);; paramView = paramView.toString())
    {
      localObject = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject, 11);
      if (TroopRankConfig.a().a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))
      {
        if (this.a.b != null) {
          this.a.b.setVisibility(8);
        }
        TroopRankConfig.a().a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, false);
      }
      TroopRankConfig.a("grp_data", "clk_medal");
      new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d }).a();
      return;
      paramView = new StringBuilder();
      paramView.append("https://web.qun.qq.com/cgi-bin/misc/dynamic_url?");
      paramView.append("gc=").append(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.d).append("&");
      paramView.append("uin=").append(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a).append("&");
      paramView.append("type=").append(3).append("&");
      paramView.append("from=").append("aio").append("&");
      paramView.append("_wv=").append("16777223");
      paramView.append("&_wwv=1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agvo
 * JD-Core Version:    0.7.0.1
 */