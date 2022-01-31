import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;

class aimw
  implements DialogInterface.OnClickListener
{
  aimw(aimv paramaimv, TimDocSSOMsg.UinRightInfo paramUinRightInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Aimv.a.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Aimv.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.b(String.valueOf(this.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint64_uin.get()));
    this.jdField_a_of_type_Aimv.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_Aimv.a.b == 1) {
      ReportController.b(TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_Aimv.a), "dc00898", "", "", "0x8007CFD", "0x8007CFD", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimw
 * JD-Core Version:    0.7.0.1
 */