import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.qphone.base.util.QLog;

class airo
  implements Runnable
{
  airo(airn paramairn, int paramInt, TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public void run()
  {
    QLog.d("TroopEnterEffect.Controller", 2, "download Res isAIO = " + this.jdField_a_of_type_Airn.a.a);
    if (this.jdField_a_of_type_Airn.a.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "download Res callback success id = " + this.jdField_a_of_type_Int + " showAnimation");
      }
      this.jdField_a_of_type_Airn.a.a(this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$TroopEnterEffectData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     airo
 * JD-Core Version:    0.7.0.1
 */