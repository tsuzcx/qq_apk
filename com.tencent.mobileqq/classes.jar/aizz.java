import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class aizz
{
  private static volatile aizz jdField_a_of_type_Aizz;
  private beag jdField_a_of_type_Beag;
  private beaj jdField_a_of_type_Beaj;
  
  private aizz()
  {
    if (this.jdField_a_of_type_Beag == null)
    {
      this.jdField_a_of_type_Beag = new beag(null);
      this.jdField_a_of_type_Beaj = this.jdField_a_of_type_Beag.a(1);
    }
  }
  
  public static aizz a()
  {
    if (jdField_a_of_type_Aizz == null) {}
    try
    {
      if (jdField_a_of_type_Aizz == null) {
        jdField_a_of_type_Aizz = new aizz();
      }
      return jdField_a_of_type_Aizz;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, bead parambead, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, parambead, paramBundle), 8, null, true);
  }
  
  public void a(beae parambeae, bead parambead, Bundle paramBundle)
  {
    if (parambeae != null) {
      ThreadManager.post(new PreloadComDownloader.4(this, parambeae, parambead, paramBundle), 8, null, true);
    }
  }
  
  public void a(DownloadParam paramDownloadParam, bead parambead, Bundle paramBundle)
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
    parambead = new ajaa(this, parambead);
    parambead = new ajab(this, localQQAppInterface, paramDownloadParam.url, paramBundle, parambead, paramDownloadParam);
    ((bbaa)localQQAppInterface.getManager(193)).a(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, parambead);
    return;
    a(paramBundle, parambead, paramDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizz
 * JD-Core Version:    0.7.0.1
 */