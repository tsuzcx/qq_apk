import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class aeye
  extends DownloadListener
{
  aeye(aeyd paramaeyd, int paramInt) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.jdField_a_of_type_Int == 0) {
      localObject = paramDownloadTask.a().getString("filePath");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        paramDownloadTask = new File((String)localObject);
        String str = FileUtils.b(paramDownloadTask);
        if (QLog.isColorLevel()) {
          QLog.d(NearbyGiftPanelDialog.a(), 2, "onDone() content =  " + str + ", filePath = " + (String)localObject);
        }
        if (!TextUtils.isEmpty(str))
        {
          localObject = new TroopGiftAioPanelData(new JSONObject(str));
          ((TroopGiftAioPanelData)localObject).a(NearbyGiftPanelDialog.a(this.jdField_a_of_type_Aeyd.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog), NearbyGiftPanelDialog.a(this.jdField_a_of_type_Aeyd.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog));
          this.jdField_a_of_type_Aeyd.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(this.jdField_a_of_type_Int, NearbyGiftPanelDialog.a(this.jdField_a_of_type_Aeyd.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog));
          if (NearbyGiftPanelDialog.a(this.jdField_a_of_type_Aeyd.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog) != null) {
            NearbyGiftPanelDialog.a(this.jdField_a_of_type_Aeyd.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog).post(new aeyf(this, (TroopGiftAioPanelData)localObject));
          }
          paramDownloadTask.deleteOnExit();
        }
        return;
      }
      catch (IOException paramDownloadTask)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(NearbyGiftPanelDialog.a(), 2, QLog.getStackTraceString(paramDownloadTask));
        return;
      }
      catch (JSONException paramDownloadTask)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(NearbyGiftPanelDialog.a(), 2, QLog.getStackTraceString(paramDownloadTask));
        return;
      }
    }
    QLog.d(NearbyGiftPanelDialog.a(), 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Aeyd.jdField_a_of_type_Long) + ", errorCode = " + paramDownloadTask.jdField_a_of_type_Int);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeye
 * JD-Core Version:    0.7.0.1
 */