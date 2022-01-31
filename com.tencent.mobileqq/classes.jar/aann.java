import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.ar.config.WorldCupMgr.DownloadListener;
import com.tencent.qphone.base.util.QLog;

public class aann
  implements WorldCupMgr.DownloadListener
{
  public aann(AREngine paramAREngine) {}
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      QLog.i("AREngine_AREngine", 2, "downloadWorldCupIdx1Res. download failed. error code = " + paramInt2);
      WorldCupMgr.a(AREngine.a(this.a)).b(this);
      AREngine.a(this.a, this.a.b);
      if ((AREngine.e(this.a)) && (AREngine.e(this.a) == 2) && (AREngine.a(this.a) != null)) {
        AREngine.b(this.a, 7);
      }
    }
    do
    {
      do
      {
        return;
        if ((paramInt2 < 0) || (paramInt2 > 99)) {
          break;
        }
        QLog.i("AREngine_AREngine", 2, "downloadWorldCupIdx1Res. download... progress = " + paramInt2);
      } while ((!AREngine.e(this.a)) || (AREngine.e(this.a) != 2) || (AREngine.a(this.a) == null));
      AREngine.a(this.a, 8, paramInt2);
      return;
    } while (paramInt2 != 100);
    QLog.i("AREngine_AREngine", 2, "downloadWorldCupIdx1Res. download successfully.");
    WorldCupMgr.a(AREngine.a(this.a)).b(this);
    AREngine.a(this.a, this.a.b);
    if ((AREngine.e(this.a)) && (AREngine.e(this.a) == 2) && (AREngine.a(this.a) != null))
    {
      AREngine.b(this.a, 6);
      AREngine.b(this.a, 5);
    }
    AREngine.a(new aano(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aann
 * JD-Core Version:    0.7.0.1
 */