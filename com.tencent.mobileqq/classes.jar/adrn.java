import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class adrn
  implements bmiz
{
  public adrn(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(int paramInt)
  {
    boolean bool;
    View localView;
    if (paramInt == 0)
    {
      this.a.b = true;
      bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
      localView = this.a.jdField_a_of_type_ArrayOfAndroidViewView[5];
      if (localView != null) {
        if (!bool) {
          break label81;
        }
      }
    }
    label81:
    for (paramInt = 0;; paramInt = 8)
    {
      localView.setVisibility(paramInt);
      if (bool) {
        bhbu.a("Grp_set_new", "grpData_admin", "manageGrp_exp", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrn
 * JD-Core Version:    0.7.0.1
 */