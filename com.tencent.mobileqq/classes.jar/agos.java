import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class agos
{
  private static volatile agos jdField_a_of_type_Agos;
  private bato jdField_a_of_type_Bato;
  private batr jdField_a_of_type_Batr;
  
  private agos()
  {
    if (this.jdField_a_of_type_Bato == null)
    {
      this.jdField_a_of_type_Bato = new bato(null);
      this.jdField_a_of_type_Batr = this.jdField_a_of_type_Bato.a(1);
    }
  }
  
  public static agos a()
  {
    if (jdField_a_of_type_Agos == null) {}
    try
    {
      if (jdField_a_of_type_Agos == null) {
        jdField_a_of_type_Agos = new agos();
      }
      return jdField_a_of_type_Agos;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, batl parambatl, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, parambatl, paramBundle), 8, null, true);
  }
  
  public void a(batm parambatm, batl parambatl, Bundle paramBundle)
  {
    if (parambatm != null) {
      ThreadManager.post(new PreloadComDownloader.4(this, parambatm, parambatl, paramBundle), 8, null, true);
    }
  }
  
  public void a(DownloadParam paramDownloadParam, batl parambatl, Bundle paramBundle)
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
    parambatl = new agot(this, parambatl);
    parambatl = new agou(this, localQQAppInterface, paramDownloadParam.url, paramBundle, parambatl, paramDownloadParam);
    ((axxj)localQQAppInterface.getManager(193)).a(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, parambatl);
    return;
    a(paramBundle, parambatl, paramDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agos
 * JD-Core Version:    0.7.0.1
 */