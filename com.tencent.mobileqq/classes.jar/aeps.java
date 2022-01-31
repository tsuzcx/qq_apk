import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aeps
  extends TroopGiftCallback
{
  public aeps(NearbyGiftPanelDialog paramNearbyGiftPanelDialog, TroopGiftManager paramTroopGiftManager, long paramLong, AIOAnimationControlManager paramAIOAnimationControlManager, int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(NearbyGiftPanelDialog.a(), 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(NearbyGiftPanelDialog.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog));
    if (QLog.isColorLevel()) {
      QLog.d(NearbyGiftPanelDialog.a(), 2, "onGetExtraData() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", configURL = " + paramString + ", version:" + paramInt + ", oldVersion:" + i);
    }
    if ((paramInt <= i) && (TroopGiftAioPanelData.a(NearbyGiftPanelDialog.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog), NearbyGiftPanelDialog.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog)) != null)) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new File(AppConstants.ba);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = AppConstants.ba + "troopGiftConfig.tmp";
    paramString = new DownloadTask(paramString, new File((String)localObject));
    paramString.b = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.a().a(paramString, new aept(this, paramInt), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeps
 * JD-Core Version:    0.7.0.1
 */