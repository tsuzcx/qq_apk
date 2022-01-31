import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.logic.TroopAvatarWallEditCtrl;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import java.util.ArrayList;
import mqq.observer.AccountObserver;

public class ajmb
  extends AccountObserver
{
  public ajmb(TroopAvatarWallEditCtrl paramTroopAvatarWallEditCtrl) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    int i = this.a.jdField_a_of_type_JavaUtilArrayList.size();
    if (paramString1 == null) {
      while (i > 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b - 1);
        i -= 1;
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
      TroopUtils.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmb
 * JD-Core Version:    0.7.0.1
 */