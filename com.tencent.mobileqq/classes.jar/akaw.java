import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;

public class akaw
{
  private static volatile akaw jdField_a_of_type_Akaw;
  private bgog jdField_a_of_type_Bgog;
  private bgoj jdField_a_of_type_Bgoj;
  
  private akaw()
  {
    if (this.jdField_a_of_type_Bgog == null)
    {
      this.jdField_a_of_type_Bgog = new bgog(null);
      this.jdField_a_of_type_Bgoj = this.jdField_a_of_type_Bgog.a(1);
    }
  }
  
  public static akaw a()
  {
    if (jdField_a_of_type_Akaw == null) {}
    try
    {
      if (jdField_a_of_type_Akaw == null) {
        jdField_a_of_type_Akaw = new akaw();
      }
      return jdField_a_of_type_Akaw;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, bgod parambgod, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, parambgod, paramBundle), 8, null, true);
  }
  
  public void a(DownloadParam paramDownloadParam, bgod parambgod, Bundle paramBundle)
  {
    if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url)) || (TextUtils.isEmpty(paramDownloadParam.filePath))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      if (!paramDownloadParam.isPreDownload) {
        break;
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (localQQAppInterface == null);
    parambgod = new akax(this, parambgod);
    parambgod = new akay(this, localQQAppInterface, paramDownloadParam.url, paramBundle, parambgod, paramDownloadParam);
    ((PreDownloadController)localQQAppInterface.getManager(193)).requestPreDownload(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, parambgod);
    return;
    a(paramBundle, parambgod, paramDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akaw
 * JD-Core Version:    0.7.0.1
 */