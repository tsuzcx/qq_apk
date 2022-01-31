import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class aihv
  implements Runnable
{
  public aihv(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str3;
    try
    {
      if (RedBagVideoManager.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : isLoadingRes = true");
        }
        return;
      }
      RedBagVideoManager.jdField_a_of_type_Boolean = true;
      String str1 = SharedPreUtils.o(this.a.getApp(), this.a.getCurrentAccountUin());
      str3 = SharedPreUtils.p(this.a.getApp(), this.a.getCurrentAccountUin());
      if ((QLog.isColorLevel()) && (str1 != null) && (str3 != null)) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes: md5 = " + str1 + ", url = " + str3);
      }
      if ((str1 == null) || (str1.length() == 0) || (str3 == null) || (str3.length() == 0))
      {
        RedBagVideoManager.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    finally {}
    if (!RedBagVideoManager.a(str2, this.a))
    {
      String str4 = RedBagVideoManager.jdField_a_of_type_JavaLangString + "VideoRedbagRes_2.0_android.zip";
      DownloadTask localDownloadTask = new DownloadTask(str3, new File(str4));
      localDownloadTask.l = true;
      DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.a.getManager(46)).a(1);
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [download] startDownload: " + str3 + " path=" + str4);
      }
      localDownloaderInterface.a(localDownloadTask, new aihw(this, str3, str4, str2), null);
    }
    for (;;)
    {
      return;
      RedBagVideoManager.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aihv
 * JD-Core Version:    0.7.0.1
 */