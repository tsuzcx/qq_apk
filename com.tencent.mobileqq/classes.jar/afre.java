import android.view.View;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.concurrent.ConcurrentHashMap;

public class afre
  implements bliz
{
  public afre(TroopAssisSettingActivity paramTroopAssisSettingActivity, int paramInt, TroopInfo paramTroopInfo, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = -1;
      if (this.jdField_a_of_type_Int != paramInt)
      {
        if (!bhnv.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.getActivity())) {
          break label218;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_Bhru.b.clear();
        axan.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_Bhru.c.put(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Boolean.valueOf(true));
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_Amro.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.b();
        axan.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.app, "P_CliOper", "Grp_msg", "", "set_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.dismiss();
      return;
      paramInt = 1;
      break;
      paramInt = 4;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      label218:
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.getActivity(), 2131693965, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afre
 * JD-Core Version:    0.7.0.1
 */