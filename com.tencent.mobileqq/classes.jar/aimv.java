import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter.Holder;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class aimv
  implements ActionSheet.OnButtonClickListener
{
  public aimv(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment, TeamWorkAuthorizeUinListAdapter.Holder paramHolder, SparseArray paramSparseArray, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    TimDocSSOMsg.UinRightInfo localUinRightInfo = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter$Holder.a;
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null) {
      paramInt = -1;
    }
    switch (paramInt)
    {
    default: 
    case 2131439164: 
    case 2131439165: 
      for (;;)
      {
        TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.a.notifyDataSetChanged();
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        return;
        paramInt = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).intValue();
        break;
        localUinRightInfo.uint32_right.set(1);
        continue;
        localUinRightInfo.uint32_right.set(2);
      }
    }
    if ((localUinRightInfo.uint32_right.get() == 1) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.b == 1)) {}
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getString(2131439172);; paramView = this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getString(2131439171))
    {
      DialogUtil.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getActivity(), 230, "提示", paramView, 2131433015, 2131434041, new aimw(this, localUinRightInfo), new aimx(this)).show();
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.b != 1) {
        break;
      }
      ReportController.b(TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment), "dc00898", "", "", "0x8007CFC", "0x8007CFC", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimv
 * JD-Core Version:    0.7.0.1
 */