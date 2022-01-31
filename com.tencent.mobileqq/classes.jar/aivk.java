import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class aivk
{
  private static volatile aivk jdField_a_of_type_Aivk;
  private bdvx jdField_a_of_type_Bdvx;
  private bdwa jdField_a_of_type_Bdwa;
  
  private aivk()
  {
    if (this.jdField_a_of_type_Bdvx == null)
    {
      this.jdField_a_of_type_Bdvx = new bdvx(null);
      this.jdField_a_of_type_Bdwa = this.jdField_a_of_type_Bdvx.a(1);
    }
  }
  
  public static aivk a()
  {
    if (jdField_a_of_type_Aivk == null) {}
    try
    {
      if (jdField_a_of_type_Aivk == null) {
        jdField_a_of_type_Aivk = new aivk();
      }
      return jdField_a_of_type_Aivk;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, bdvu parambdvu, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, parambdvu, paramBundle), 8, null, true);
  }
  
  public void a(bdvv parambdvv, bdvu parambdvu, Bundle paramBundle)
  {
    if (parambdvv != null) {
      ThreadManager.post(new PreloadComDownloader.4(this, parambdvv, parambdvu, paramBundle), 8, null, true);
    }
  }
  
  public void a(DownloadParam paramDownloadParam, bdvu parambdvu, Bundle paramBundle)
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
    parambdvu = new aivl(this, parambdvu);
    parambdvu = new aivm(this, localQQAppInterface, paramDownloadParam.url, paramBundle, parambdvu, paramDownloadParam);
    ((bavr)localQQAppInterface.getManager(193)).a(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, parambdvu);
    return;
    a(paramBundle, parambdvu, paramDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivk
 * JD-Core Version:    0.7.0.1
 */