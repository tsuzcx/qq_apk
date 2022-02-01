import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;

public class akwp
{
  private static volatile akwp jdField_a_of_type_Akwp;
  private bhyq jdField_a_of_type_Bhyq;
  private bhyt jdField_a_of_type_Bhyt;
  
  private akwp()
  {
    if (this.jdField_a_of_type_Bhyq == null)
    {
      this.jdField_a_of_type_Bhyq = new bhyq(null);
      this.jdField_a_of_type_Bhyt = this.jdField_a_of_type_Bhyq.a(1);
    }
  }
  
  public static akwp a()
  {
    if (jdField_a_of_type_Akwp == null) {}
    try
    {
      if (jdField_a_of_type_Akwp == null) {
        jdField_a_of_type_Akwp = new akwp();
      }
      return jdField_a_of_type_Akwp;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, bhyn parambhyn, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, parambhyn, paramBundle), 8, null, true);
  }
  
  public void a(DownloadParam paramDownloadParam, bhyn parambhyn, Bundle paramBundle)
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
    parambhyn = new akwq(this, parambhyn);
    parambhyn = new akwr(this, localQQAppInterface, paramDownloadParam.url, paramBundle, parambhyn, paramDownloadParam);
    ((PreDownloadController)localQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2)).requestPreDownload(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, parambhyn);
    return;
    a(paramBundle, parambhyn, paramDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwp
 * JD-Core Version:    0.7.0.1
 */