import com.tencent.mobileqq.ocr.OcrCamera.CameraCallback;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;

public class aggr
  implements OcrCamera.CameraCallback
{
  public aggr(ScanOcrActivity paramScanOcrActivity) {}
  
  public void a()
  {
    this.a.runOnUiThread(new aggw(this));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new aggs(this, paramInt1));
  }
  
  public void a(String paramString)
  {
    this.a.runOnUiThread(new aggx(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.runOnUiThread(new aggu(this));
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aggr
 * JD-Core Version:    0.7.0.1
 */