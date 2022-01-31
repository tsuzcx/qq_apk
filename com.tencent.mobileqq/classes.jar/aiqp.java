import android.app.Activity;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Map;

class aiqp
  implements Runnable
{
  aiqp(aiqo paramaiqo) {}
  
  public void run()
  {
    Object localObject = (TroopFileTransferManager.Item)this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.b.get(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a.getString(2131429721), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a.getString(2131429724));
      return;
    }
    int i = TroopFileItemOperation.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation, false);
    aiqq localaiqq = new aiqq(this);
    if (i == 1) {}
    for (localObject = TroopFileItemOperation.a(2131429771, new Object[] { TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a() });; localObject = TroopFileItemOperation.a(2131429778, new Object[] { TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c) }))
    {
      DialogUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a, 230, TroopFileItemOperation.a(2131429766), (String)localObject, 2131432998, 2131429728, localaiqq, localaiqq).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiqp
 * JD-Core Version:    0.7.0.1
 */