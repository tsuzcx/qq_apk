import android.app.Activity;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ajjv
  implements Runnable
{
  ajjv(ajju paramajju) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a.getString(2131429727), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a.getString(2131429730));
      return;
    }
    int i = TroopFileItemOperation.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation, false);
    ajjw localajjw = new ajjw(this);
    if (i == 1) {}
    for (localObject = TroopFileItemOperation.a(2131429777, new Object[] { TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a() });; localObject = TroopFileItemOperation.a(2131429784, new Object[] { TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c) }))
    {
      DialogUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a, 230, TroopFileItemOperation.a(2131429772), (String)localObject, 2131433029, 2131429734, localajjw, localajjw).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjv
 * JD-Core Version:    0.7.0.1
 */