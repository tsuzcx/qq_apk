import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

public class agxw
  implements Runnable
{
  public agxw(EffectsCameraCaptureView paramEffectsCameraCaptureView) {}
  
  public void run()
  {
    if ((this.a.h) && (this.a.a != null))
    {
      this.a.a.c(this.a.f, this.a.g, this.a.getWidth(), this.a.getHeight());
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
 * Qualified Name:     agxw
 * JD-Core Version:    0.7.0.1
 */