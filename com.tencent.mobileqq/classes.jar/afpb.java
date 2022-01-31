import com.tencent.mobileqq.ocr.OcrCamera.CameraCallback;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;

public class afpb
  implements OcrCamera.CameraCallback
{
  public afpb(ScanOcrActivity paramScanOcrActivity) {}
  
  public void a()
  {
    this.a.runOnUiThread(new afpg(this));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new afpc(this, paramInt1));
  }
  
  public void a(String paramString)
  {
    this.a.runOnUiThread(new afph(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.runOnUiThread(new afpe(this));
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afpb
 * JD-Core Version:    0.7.0.1
 */