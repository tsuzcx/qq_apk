import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

public class ahqs
  implements Runnable
{
  public ahqs(EffectsCameraCaptureView paramEffectsCameraCaptureView) {}
  
  public void run()
  {
    if (!this.a.i)
    {
      this.a.a.a(EffectsCameraCaptureView.a(this.a));
      this.a.a.b(this.a.n, this.a.o, this.a.getWidth(), this.a.getHeight());
      this.a.a.c(this.a.n, this.a.o, this.a.getWidth(), this.a.getHeight());
      this.a.a.c(EffectsCameraCaptureView.b(this.a));
      this.a.i = true;
      if (EffectsCameraCaptureView.a(this.a) != null) {
        this.a.setFaceEffect(EffectsCameraCaptureView.a(this.a));
      }
      if (EffectsCameraCaptureView.a(this.a) != 0) {
        this.a.setBeauty(EffectsCameraCaptureView.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahqs
 * JD-Core Version:    0.7.0.1
 */