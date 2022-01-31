import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateInfo;

class ajdp
  implements Runnable
{
  ajdp(ajdo paramajdo, String paramString, TroopInfo paramTroopInfo, int paramInt) {}
  
  public void run()
  {
    ((TroopHandler)this.jdField_a_of_type_Ajdo.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_JavaLangString, (byte)1, 0L, 0);
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_Ajdo.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null) {
      localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    }
    for (;;)
    {
      Object localObject;
      int j;
      int i;
      if (localTroopInfo != null)
      {
        localTroopInfo.dwGroupClassExt = this.jdField_a_of_type_Ajdo.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_Int;
        localTroopInfo.mRichFingerMemo = this.jdField_a_of_type_Ajdo.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.d;
        localObject = this.jdField_a_of_type_Ajdo.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.e.split("\\|");
        if (localObject.length != 4) {
          break label260;
        }
        j = (int)(Float.valueOf(localObject[1]).floatValue() * 1000000.0F);
        i = (int)(Float.valueOf(localObject[2]).floatValue() * 1000000.0F);
      }
      for (;;)
      {
        localTroopInfo.troopLat = j;
        localTroopInfo.troopLon = i;
        localTroopInfo.isNewTroop = true;
        localTroopInfo.hasSetNewTroopHead = false;
        localTroopInfo.hasSetNewTroopName = false;
        localTroopInfo.wMemberNum = this.jdField_a_of_type_Int;
        localTroopInfo.wMemberNumClient = localTroopInfo.wMemberNum;
        localTroopInfo.troopowneruin = this.jdField_a_of_type_Ajdo.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localTroopInfo.troopCreateTime = (System.currentTimeMillis() / 1000L);
        localObject = (TroopManager)this.jdField_a_of_type_Ajdo.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (localObject != null) {
          ((TroopManager)localObject).b(localTroopInfo);
        }
        return;
        label260:
        i = 0;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdp
 * JD-Core Version:    0.7.0.1
 */