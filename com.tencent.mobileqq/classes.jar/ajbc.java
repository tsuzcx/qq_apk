import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

class ajbc
  implements Runnable
{
  ajbc(ajbb paramajbb, String paramString, TroopFileInfo paramTroopFileInfo) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b;
    }
    localObject = (MessageForTroopFile)this.jdField_a_of_type_Ajbb.a.a.a().a(String.valueOf(this.jdField_a_of_type_Ajbb.a.f), 1, (String)localObject);
    if (localObject != null) {
      ((AIOMessageSpreadManager)this.jdField_a_of_type_Ajbb.a.a.getManager(271)).a((MessageRecord)localObject);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("AIOMessageSpreadManager", 1, "can't find troopFile Msg, troop[" + this.jdField_a_of_type_Ajbb.a.f + "], id:" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajbc
 * JD-Core Version:    0.7.0.1
 */