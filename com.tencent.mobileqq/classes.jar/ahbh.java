import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class ahbh
{
  private static volatile ahbh jdField_a_of_type_Ahbh;
  private bbwi jdField_a_of_type_Bbwi;
  private bbwl jdField_a_of_type_Bbwl;
  
  private ahbh()
  {
    if (this.jdField_a_of_type_Bbwi == null)
    {
      this.jdField_a_of_type_Bbwi = new bbwi(null);
      this.jdField_a_of_type_Bbwl = this.jdField_a_of_type_Bbwi.a(1);
    }
  }
  
  public static ahbh a()
  {
    if (jdField_a_of_type_Ahbh == null) {}
    try
    {
      if (jdField_a_of_type_Ahbh == null) {
        jdField_a_of_type_Ahbh = new ahbh();
      }
      return jdField_a_of_type_Ahbh;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, bbwf parambbwf, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, parambbwf, paramBundle), 8, null, true);
  }
  
  public void a(bbwg parambbwg, bbwf parambbwf, Bundle paramBundle)
  {
    if (parambbwg != null) {
      ThreadManager.post(new PreloadComDownloader.4(this, parambbwg, parambbwf, paramBundle), 8, null, true);
    }
  }
  
  public void a(DownloadParam paramDownloadParam, bbwf parambbwf, Bundle paramBundle)
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
    parambbwf = new ahbi(this, parambbwf);
    parambbwf = new ahbj(this, localQQAppInterface, paramDownloadParam.url, paramBundle, parambbwf, paramDownloadParam);
    ((ayxq)localQQAppInterface.getManager(193)).a(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, parambbwf);
    return;
    a(paramBundle, parambbwf, paramDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbh
 * JD-Core Version:    0.7.0.1
 */