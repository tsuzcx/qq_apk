import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class aldd
{
  private static volatile aldd jdField_a_of_type_Aldd;
  private bihw jdField_a_of_type_Bihw;
  private bihz jdField_a_of_type_Bihz;
  
  private aldd()
  {
    if (this.jdField_a_of_type_Bihw == null)
    {
      this.jdField_a_of_type_Bihw = new bihw(null);
      this.jdField_a_of_type_Bihz = this.jdField_a_of_type_Bihw.a(1);
    }
  }
  
  public static aldd a()
  {
    if (jdField_a_of_type_Aldd == null) {}
    try
    {
      if (jdField_a_of_type_Aldd == null) {
        jdField_a_of_type_Aldd = new aldd();
      }
      return jdField_a_of_type_Aldd;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, biht parambiht, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, parambiht, paramBundle), 8, null, true);
  }
  
  public void a(DownloadParam paramDownloadParam, biht parambiht, Bundle paramBundle)
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
    parambiht = new alde(this, parambiht);
    parambiht = new aldf(this, localQQAppInterface, paramDownloadParam.url, paramBundle, parambiht, paramDownloadParam);
    ((bezv)localQQAppInterface.getManager(193)).a(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, parambiht);
    return;
    a(paramBundle, parambiht, paramDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldd
 * JD-Core Version:    0.7.0.1
 */