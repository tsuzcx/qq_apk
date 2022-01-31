import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acgd
  extends DownloadListener
{
  public acgd(DoutuManager paramDoutuManager, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    boolean bool;
    int i;
    if (paramDownloadTask.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
      }
      paramDownloadTask = DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager, this.b);
      if (this.c.equalsIgnoreCase(paramDownloadTask))
      {
        DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager, this.b);
        DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager, DoutuManager.jdField_a_of_type_JavaLangString + "doutuResInfo", this.c);
        SharedPreUtils.e(BaseApplication.getContext(), false);
        DuiButtonImageView.a();
        bool = true;
        i = 0;
      }
    }
    for (;;)
    {
      paramDownloadTask = new HashMap();
      paramDownloadTask.put("param_FailCode", String.valueOf(i));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "doutuResDownload", bool, 0L, 0L, paramDownloadTask, "");
      DoutuManager.jdField_a_of_type_Boolean = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[onDone] checkMd5 failed: " + this.b);
      }
      i = 80704;
      FileUtils.d(this.b);
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + paramDownloadTask.b + " code=" + paramDownloadTask.a);
      }
      i = paramDownloadTask.a;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgd
 * JD-Core Version:    0.7.0.1
 */