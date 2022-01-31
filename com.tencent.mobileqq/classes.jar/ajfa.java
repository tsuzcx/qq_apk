import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class ajfa
  implements TbsListener
{
  public ajfa(BrowserAppInterface paramBrowserAppInterface, SharedPreferences paramSharedPreferences, long paramLong) {}
  
  public void onDownloadFinish(int paramInt)
  {
    QLog.d("TBS_update", 1, "tbs download finish result=" + paramInt);
    if ((paramInt != 100) && (paramInt != 120) && (paramInt != 122))
    {
      if (BrowserAppInterface.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
      {
        QbSdk.setTbsListener(null);
        int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("tbs_download_count", 0);
        long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("tbs_download_cost", 0L);
        long l2 = System.currentTimeMillis();
        long l3 = this.jdField_a_of_type_Long;
        localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putInt("tbs_download_count", i + 1);
        localEditor.putLong("tbs_download_cost", l1 + (l2 - l3));
        localEditor.commit();
        awqx.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_download_error", 0, 1, paramInt, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("TBS_update", 2, "tbs download aborted:" + paramInt);
        }
      }
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putInt("tbs_download_complete", paramInt);
      localEditor.remove("tbs_downloading");
      localEditor.remove("tbs_download_progress");
      localEditor.commit();
      if (this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.jdField_a_of_type_Boolean) {
        BrowserAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.jdField_a_of_type_AndroidContentIntent);
      }
    }
    do
    {
      return;
      awqx.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_download_ok", 0, 1, paramInt, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("TBS_update", 2, "tbs download finished");
  }
  
  public void onDownloadProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TBS_update", 2, "tbs download progress " + paramInt);
    }
  }
  
  public void onInstallFinish(int paramInt)
  {
    QLog.d("TBS_update", 1, "tbs download install finish result=" + paramInt);
    if (paramInt == 200) {
      return;
    }
    int i;
    long l1;
    long l2;
    long l3;
    SharedPreferences.Editor localEditor;
    if (BrowserAppInterface.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      QbSdk.setTbsListener(null);
      if ((paramInt == 232) || (paramInt == 220)) {
        break label280;
      }
      i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("tbs_download_count", 0);
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("tbs_download_cost", 0L);
      l2 = System.currentTimeMillis();
      l3 = this.jdField_a_of_type_Long;
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putInt("tbs_download_count", i + 1);
      localEditor.putLong("tbs_download_cost", l1 + (l2 - l3));
      localEditor.commit();
      awqx.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_install_error", 0, 1, paramInt, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("TBS_update", 2, "tbs install error:" + paramInt);
      }
    }
    for (;;)
    {
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putInt("tbs_download_complete", paramInt);
      localEditor.remove("tbs_downloading");
      localEditor.remove("tbs_download_progress");
      localEditor.commit();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.jdField_a_of_type_Boolean) {
        break;
      }
      BrowserAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.jdField_a_of_type_AndroidContentIntent);
      return;
      label280:
      i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("tbs_download_count", 0);
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("tbs_download_cost", 0L);
      l2 = System.currentTimeMillis();
      l3 = this.jdField_a_of_type_Long;
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.remove("tbs_download_count");
      localEditor.remove("tbs_download_cost");
      localEditor.commit();
      awqx.b(null, "P_CliOper", "BizTechReport", "", "web", "tbs_install_ok", 0, 1, paramInt, Long.toString(l1 + (l2 - l3)), Integer.toString(i + 1), "", "");
      if (QLog.isColorLevel()) {
        QLog.d("TBS_update", 2, "tbs install finished:" + paramInt);
      }
      WebpSoLoader.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajfa
 * JD-Core Version:    0.7.0.1
 */