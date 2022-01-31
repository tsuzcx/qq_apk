import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.NowHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.now.ChannelResponse;
import com.tencent.mobileqq.now.NowAppHelper;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class agea
  implements Runnable
{
  public agea(QQAppInterface paramQQAppInterface, NowHandler paramNowHandler, ChannelResponse paramChannelResponse, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    int j = 0;
    int i = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 50.0F);
    int k = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 14.0F);
    Object localObject1 = ImageUtil.b(BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130844304), k, i, i);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppNowHandler;
    if (localObject1 != null)
    {
      i = 0;
      ((NowHandler)localObject2).a("createIcon", "", "", "", "", i);
      if (localObject1 != null) {
        break label109;
      }
      if (QLog.isColorLevel()) {
        QLog.w(NowAppHelper.a, 2, "doShortCutAction end, iconBmp is null");
      }
    }
    label109:
    do
    {
      do
      {
        return;
        i = -1;
        break;
        localObject2 = new Intent("intent.start.shortcut.guide");
        ((Intent)localObject2).setClassName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), ShortcutGuideActivity.class.getName());
        ((Intent)localObject2).putExtra("from", "now_app_shortcut");
        ((Intent)localObject2).putExtra("key_apkUrl", this.jdField_a_of_type_ComTencentMobileqqNowChannelResponse.downloadLink);
        ((Intent)localObject2).putExtra("key_h5Url", this.jdField_a_of_type_ComTencentMobileqqNowChannelResponse.h5_url);
        ((Intent)localObject2).putExtra("key_md5", this.jdField_a_of_type_ComTencentMobileqqNowChannelResponse.md5sum);
        ((Intent)localObject2).putExtra("key_client_action", this.jdField_a_of_type_ComTencentMobileqqNowChannelResponse.client_action);
        ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
        QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Intent)localObject2, "NOW", (Bitmap)localObject1);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_now_create_flag", true).commit();
        if (QLog.isColorLevel()) {
          QLog.d(NowAppHelper.a, 2, "doShortCutAction createShortcut done client_action=" + this.jdField_a_of_type_ComTencentMobileqqNowChannelResponse.client_action);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqNowChannelResponse.client_action == 1);
      localObject1 = new File(AppConstants.aK + MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqNowChannelResponse.downloadLink) + ".apk");
      boolean bool = ((File)localObject1).exists();
      i = j;
      if (bool)
      {
        localObject2 = MD5Utils.a(((File)localObject1).getAbsolutePath());
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqNowChannelResponse.md5sum != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqNowChannelResponse.md5sum.equals(localObject2)) {
            i = 1;
          }
        }
      }
      if ((!bool) || (i == 0))
      {
        if (!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
        {
          NowHandler localNowHandler = this.jdField_a_of_type_ComTencentMobileqqAppNowHandler;
          if (bool)
          {
            localObject1 = "true";
            if (i == 0) {
              break label484;
            }
          }
          for (localObject2 = "true";; localObject2 = "false")
          {
            localNowHandler.a("downloadApk", (String)localObject1, (String)localObject2, "", "", 9);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(NowAppHelper.a, 2, "doShortCutAction end, network is not wifi");
            return;
            localObject1 = "false";
            break label436;
          }
        }
        ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1).a(new DownloadTask(this.jdField_a_of_type_ComTencentMobileqqNowChannelResponse.downloadLink, (File)localObject1), new ageb(this), null);
        return;
      }
    } while (!QLog.isColorLevel());
    label436:
    label484:
    QLog.w(NowAppHelper.a, 2, "doShortCutAction end, params valid error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agea
 * JD-Core Version:    0.7.0.1
 */