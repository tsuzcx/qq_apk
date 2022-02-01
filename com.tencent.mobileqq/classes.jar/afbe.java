import android.view.View;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.concurrent.ConcurrentHashMap;

public class afbe
  implements bkzq
{
  public afbe(TroopAssisSettingActivity paramTroopAssisSettingActivity, int paramInt, TroopInfo paramTroopInfo, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = -1;
      if (this.jdField_a_of_type_Int != paramInt)
      {
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.getActivity())) {
          break label218;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_Bhhi.b.clear();
        awtz.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_Bhhi.c.put(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, Boolean.valueOf(true));
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.jdField_a_of_type_Amkj.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.b();
        awtz.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.app, "P_CliOper", "Grp_msg", "", "set_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.getActivity(), 2131694255, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssisSettingActivity.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbe
 * JD-Core Version:    0.7.0.1
 */