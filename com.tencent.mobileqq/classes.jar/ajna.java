import android.os.Bundle;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.DownloadGftData;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.DownloadGiftResStateObservable;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class ajna
  extends DownloadListener
{
  public ajna(AIOAnimationControlManager paramAIOAnimationControlManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    AIOAnimationControlManager.DownloadGftData localDownloadGftData = new AIOAnimationControlManager.DownloadGftData();
    Bundle localBundle = paramDownloadTask.a();
    String str1 = localBundle.getString("GiftAnimationId");
    String str2 = localBundle.getString("TroopUin");
    int i = localBundle.getInt("GiftAnimationType");
    boolean bool = localBundle.getBoolean("GiftIsInteract");
    localDownloadGftData.jdField_a_of_type_Boolean = true;
    localDownloadGftData.jdField_a_of_type_JavaLangString = str1;
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().setChanged();
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().notifyObservers(localDownloadGftData);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + str1 + " task:" + paramDownloadTask);
    }
    ReportController.b(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, paramDownloadTask.a, str1, "", "", "");
    if (paramDownloadTask.a == 0)
    {
      paramDownloadTask = new File(TroopGiftUtil.a(str1, i, bool));
      if (paramDownloadTask.exists()) {}
      try
      {
        FileUtils.a(paramDownloadTask.getAbsolutePath(), AppConstants.cc, false);
        paramDownloadTask.delete();
        this.a.jdField_a_of_type_JavaUtilHashMap.put(str1, Integer.valueOf(3));
        ReportController.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, str2, "", "", "");
        if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) || (this.a.jdField_a_of_type_AndroidAppActivity != null)) && (!AIOAnimationControlManager.jdField_a_of_type_JavaLangString.equals(this.a.b))) {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        paramDownloadTask.delete();
      }
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(4));
    i = NetworkUtil.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      if ((!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof NearbyChatPie)) && (!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof HotChatPie))) {
        break label428;
      }
      NearbyFlowerManager.a("gift_aio", "fail_cartoon", str2, "", "", "");
      break;
      if (i == 2) {
        i = 3;
      } else if (i == 3) {
        i = 2;
      } else if (i == 4) {
        i = 1;
      } else {
        i = 4;
      }
    }
    label428:
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      paramDownloadTask = "0";
      label441:
      if (!AnonymousChatHelper.a().a(str2)) {
        break label521;
      }
    }
    label521:
    for (int j = 2;; j = 1)
    {
      ReportController.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", j, 0, str2, localObject + "", paramDownloadTask, i + "");
      break;
      paramDownloadTask = "1";
      break label441;
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.a().getString("GiftAnimationId");
    AIOAnimationControlManager.DownloadGftData localDownloadGftData = new AIOAnimationControlManager.DownloadGftData();
    localDownloadGftData.jdField_a_of_type_Boolean = false;
    localDownloadGftData.jdField_a_of_type_JavaLangString = str;
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().setChanged();
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().notifyObservers(localDownloadGftData);
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajna
 * JD-Core Version:    0.7.0.1
 */