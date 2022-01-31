import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity.29.1;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class achs
  implements Observer
{
  public achs(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.a.isFinishing()) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof bana));
      paramObservable = (bana)paramObject;
    } while (paramObservable.a != 1);
    if (paramObservable.d == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("update isAvatar=%b", new Object[] { Boolean.valueOf(bool) }));
      }
      if (bool)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead = true;
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isUseClassAvatar) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isUseClassAvatar = false;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead = true;
          this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop;
          if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isUseClassAvatar()) {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.setUseClassAvatar(false);
          }
          this.a.b();
        }
      }
      if (!this.a.isResume()) {
        break;
      }
      this.a.runOnUiThread(new TroopInfoActivity.29.1(this, paramObservable));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     achs
 * JD-Core Version:    0.7.0.1
 */