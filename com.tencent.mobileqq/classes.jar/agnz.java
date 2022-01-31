import com.tencent.mobileqq.ar.arengine.ARWorldCupBaseResDownload.DownloadListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agnz
  implements ARWorldCupBaseResDownload.DownloadListener
{
  public agnz(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.a.e = 100;
      if (!ScanTorchActivity.r(this.a)) {}
    }
    do
    {
      do
      {
        return;
        if (ScanTorchActivity.s(this.a))
        {
          this.a.e(9);
          return;
        }
        this.a.e(10);
        return;
        if (paramInt1 != 1) {
          break;
        }
      } while (ScanTorchActivity.r(this.a));
      this.a.e(10);
      return;
    } while (paramInt1 != 2);
    this.a.e = paramInt2;
    paramInt1 = (this.a.b + this.a.e) / 2;
    this.a.b(11, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnz
 * JD-Core Version:    0.7.0.1
 */