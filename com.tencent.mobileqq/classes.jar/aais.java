import com.tencent.mobileqq.ar.arengine.ARWorldCupBaseResDownload;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.ar.config.WorldCupMgr.DownloadListener;
import com.tencent.qphone.base.util.QLog;

public class aais
  implements WorldCupMgr.DownloadListener
{
  public aais(ARWorldCupBaseResDownload paramARWorldCupBaseResDownload) {}
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "downloadWorldCupBaseRes0. download failed. error code = " + paramInt2);
      WorldCupMgr.a(ARWorldCupBaseResDownload.a(this.a)).b(this);
      ARWorldCupBaseResDownload.a(this.a, 0, paramInt2);
    }
    do
    {
      return;
      if ((paramInt2 >= 0) && (paramInt2 <= 99))
      {
        QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "downloadWorldCupBaseRes0. download... progress = " + paramInt2);
        ARWorldCupBaseResDownload.a(this.a, 0, paramInt2);
        return;
      }
    } while (paramInt2 != 100);
    QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "downloadWorldCupBaseRes0. download successfully.");
    WorldCupMgr.a(ARWorldCupBaseResDownload.a(this.a)).b(this);
    ARWorldCupBaseResDownload.a(this.a, 0, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aais
 * JD-Core Version:    0.7.0.1
 */