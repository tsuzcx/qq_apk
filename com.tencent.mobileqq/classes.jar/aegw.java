import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class aegw
  implements bnsj
{
  public aegw(ChatSettingForTroop paramChatSettingForTroop) {}
  
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
          break label88;
        }
      }
    }
    label88:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
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
 * Qualified Name:     aegw
 * JD-Core Version:    0.7.0.1
 */