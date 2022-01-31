import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.qphone.base.util.QLog;

class ajfs
  implements Runnable
{
  ajfs(ajfr paramajfr, int paramInt, TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public void run()
  {
    QLog.d("TroopEnterEffect.Controller", 2, "download Res isAIO = " + this.jdField_a_of_type_Ajfr.a.a);
    if (this.jdField_a_of_type_Ajfr.a.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "download Res callback success id = " + this.jdField_a_of_type_Int + " showAnimation");
      }
      this.jdField_a_of_type_Ajfr.a.a(this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$TroopEnterEffectData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfs
 * JD-Core Version:    0.7.0.1
 */