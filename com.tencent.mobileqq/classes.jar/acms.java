import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class acms
  implements Runnable
{
  public acms(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "preloadWebProcess");
    }
    try
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      WebProcessManager localWebProcessManager = (WebProcessManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
      if (localWebProcessManager != null)
      {
        SharedPreferences localSharedPreferences = this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("emoticon_panel_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        long l = localSharedPreferences.getLong("sp_key_market_open_time", 0L);
        if (System.currentTimeMillis() - l < 2592000000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "preloadWebProcess, startWebProcess for market open strategy");
          }
          localWebProcessManager.a(-1, new acmt(this));
          return;
        }
        l = localSharedPreferences.getLong("sp_key_send_h5_magic_face_time", 0L);
        if (System.currentTimeMillis() - l >= 2592000000L) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "preloadWebProcess, startWebProcess for h5 magic send strategy");
        }
        localWebProcessManager.a(-1, new acmu(this));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("EmoticonMainPanel", 1, "preloadWebProcess, exception=" + MsfSdkUtils.getStackTraceString(localException));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "preloadWebProcess, web process alive already");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acms
 * JD-Core Version:    0.7.0.1
 */