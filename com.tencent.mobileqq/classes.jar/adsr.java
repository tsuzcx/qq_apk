import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class adsr
  implements bmiz
{
  public adsr(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(int paramInt)
  {
    int i = 0;
    boolean bool;
    Object localObject;
    if (paramInt == 0)
    {
      this.a.b = true;
      bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
      localObject = this.a.jdField_a_of_type_ArrayOfAndroidViewView[5];
      if (localObject != null) {
        if (!bool) {
          break label120;
        }
      }
    }
    label120:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      if (bool) {
        bhbu.a("Grp_set_new", "grpData_admin", "manageGrp_exp", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
      localObject = (FormSimpleItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if (localObject != null)
      {
        paramInt = i;
        if (bool) {
          paramInt = 3;
        }
        ((FormSimpleItem)localObject).setBgType(paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsr
 * JD-Core Version:    0.7.0.1
 */