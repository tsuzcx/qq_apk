import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class ahbf
{
  private static volatile ahbf jdField_a_of_type_Ahbf;
  private bbww jdField_a_of_type_Bbww;
  private bbwz jdField_a_of_type_Bbwz;
  
  private ahbf()
  {
    if (this.jdField_a_of_type_Bbww == null)
    {
      this.jdField_a_of_type_Bbww = new bbww(null);
      this.jdField_a_of_type_Bbwz = this.jdField_a_of_type_Bbww.a(1);
    }
  }
  
  public static ahbf a()
  {
    if (jdField_a_of_type_Ahbf == null) {}
    try
    {
      if (jdField_a_of_type_Ahbf == null) {
        jdField_a_of_type_Ahbf = new ahbf();
      }
      return jdField_a_of_type_Ahbf;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, bbwt parambbwt, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, parambbwt, paramBundle), 8, null, true);
  }
  
  public void a(bbwu parambbwu, bbwt parambbwt, Bundle paramBundle)
  {
    if (parambbwu != null) {
      ThreadManager.post(new PreloadComDownloader.4(this, parambbwu, parambbwt, paramBundle), 8, null, true);
    }
  }
  
  public void a(DownloadParam paramDownloadParam, bbwt parambbwt, Bundle paramBundle)
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
    parambbwt = new ahbg(this, parambbwt);
    parambbwt = new ahbh(this, localQQAppInterface, paramDownloadParam.url, paramBundle, parambbwt, paramDownloadParam);
    ((ayxs)localQQAppInterface.getManager(193)).a(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, parambbwt);
    return;
    a(paramBundle, parambbwt, paramDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbf
 * JD-Core Version:    0.7.0.1
 */