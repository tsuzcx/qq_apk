import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.VipProfileWZRYView;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class agxb
  implements View.OnClickListener
{
  public agxb(VipProfileWZRYView paramVipProfileWZRYView, ProfileCardInfo paramProfileCardInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = IndividuationUrlHelper.a("gameHonourAddHonour");
    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileWZRYView.a, paramView, -1L, null, false, -1);
    VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_into", "0", 1, 0, 0, HttpUtil.a(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentBgId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentStyleId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agxb
 * JD-Core Version:    0.7.0.1
 */