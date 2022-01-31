import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;

public class akff
  implements Runnable
{
  public akff(TroopShareUtility paramTroopShareUtility, QQAppInterface paramQQAppInterface, TroopInfoData paramTroopInfoData, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (byte)3, false, false);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("face", localBitmap);
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.a.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akff
 * JD-Core Version:    0.7.0.1
 */