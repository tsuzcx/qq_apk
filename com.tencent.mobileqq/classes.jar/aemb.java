import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity.30.1;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class aemb
  implements Observer
{
  public aemb(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.a.isFinishing()) {
      break label10;
    }
    label10:
    label271:
    for (;;)
    {
      return;
      if ((paramObject instanceof bfed))
      {
        paramObservable = (bfed)paramObject;
        if (paramObservable.a != 1) {
          break;
        }
        boolean bool;
        if (paramObservable.d == 1)
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopinfo", 2, String.format("update isAvatar=%b", new Object[] { Boolean.valueOf(bool) }));
          }
          if (!bool) {
            break label236;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead = true;
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isUseClassAvatar) {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isUseClassAvatar = false;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopHead = true;
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop;
            if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isUseClassAvatar()) {
              this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.setUseClassAvatar(false);
            }
            this.a.d();
          }
        }
        for (;;)
        {
          if (!this.a.isResume()) {
            break label271;
          }
          this.a.runOnUiThread(new TroopInfoActivity.30.1(this, paramObservable));
          return;
          bool = false;
          break;
          label236:
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopinfo", 2, "pullAvatarList");
          }
          this.a.jdField_a_of_type_Bfai.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemb
 * JD-Core Version:    0.7.0.1
 */