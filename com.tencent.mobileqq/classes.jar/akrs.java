import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class akrs
{
  private static volatile akrs jdField_a_of_type_Akrs;
  private bhhh jdField_a_of_type_Bhhh;
  private bhhk jdField_a_of_type_Bhhk;
  
  private akrs()
  {
    if (this.jdField_a_of_type_Bhhh == null)
    {
      this.jdField_a_of_type_Bhhh = new bhhh(null);
      this.jdField_a_of_type_Bhhk = this.jdField_a_of_type_Bhhh.a(1);
    }
  }
  
  public static akrs a()
  {
    if (jdField_a_of_type_Akrs == null) {}
    try
    {
      if (jdField_a_of_type_Akrs == null) {
        jdField_a_of_type_Akrs = new akrs();
      }
      return jdField_a_of_type_Akrs;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, bhhe parambhhe, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, parambhhe, paramBundle), 8, null, true);
  }
  
  public void a(DownloadParam paramDownloadParam, bhhe parambhhe, Bundle paramBundle)
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
    parambhhe = new akrt(this, parambhhe);
    parambhhe = new akru(this, localQQAppInterface, paramDownloadParam.url, paramBundle, parambhhe, paramDownloadParam);
    ((beaw)localQQAppInterface.getManager(193)).a(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, parambhhe);
    return;
    a(paramBundle, parambhhe, paramDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrs
 * JD-Core Version:    0.7.0.1
 */